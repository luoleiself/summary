1、第七章:基于TCP与UDP的数据通信:net模块/dgram模块
  1、使用net模块实现基于TCP的数据通信
    1、创建TCP服务器:
      1、语法格式:var server = net.createServer([options],[connectionListener])
        1、options:allowHalpOpen:default:fasle;
        2、function(socket){};链接建立成功时的回调函数//server.on("connection",function(socket){})
      2、客户端的监听:
        1、server.listen(port,[host],[backlog],[callback]);
          1、port:监听的端口号,
          2、host:指定需要监听的ip地址或主机名
          3、backlog:指定等待队列中客户端链接的最大数量，默认为511，超出限制则拒绝
        2、server.listen(path,[callback]);server代表一个unix端口的服务器
          1、通知一个使用unix端口的服务器开始监听来自于指定路径的客户端链接
        3、server.listen(handle,[callback]);server代表一个TCP服务器
          1、通知一个使用tcp服务器开始监听来自于指定socket句柄的客户端链接
      3、事件:connection、error、close、listen等
      4、方法:
        1、server.address();该方法返回一个对象,var address = server.address();
          1、port:属性值为TCP服务器监听的端口号,
          2、address:属性值为TCP服务器监听的地址
          3、family:属性值为TCP服务器监听的地址的格式(IPv4/IPv6)
        2、server.getConnections(callback);查看当前TCP服务器连接的客户端数量
          e.g:server.getConnections(function(err,count){})
        3、server.close([callback]);显式指定TCP服务器拒绝所有新用户的链接
      5、属性:
        1、maxConnections:设置最大链接数量,server.maxConnections = 200;
    2、Socket对象:可被用来读取客户端发送的流数据,
      1、事件: 
        data:每次接收到客户端发送的流数据时触发,
        end:当客户端关闭socket链接时触发
        drain:当写入数据的write方法返回false时触发,表示操作系统缓存区的数据已全部输出到目标对象中，
              可以继续向操作系统缓存区写入数据
        error:
        lookup:
        timeout:
        connect:
        close:
        server.on("data",function(err,data){});回调函数的参数为一个Buffer对象,
      2、方法:
        1、socket.address();用法和上面一致
        2、socket.setEncoding("utf8");设置读取的数据的编码格式//或者使用buf.toString()
        3、scoket.pipe(destination,[options]);将客户端发送的流数据书写到文件或其他目标对象中
          1、destination:为一个可以写入流数据的对象
          2、options:end:true;当数据全部被读取完毕时立即结束写操作
          e.g:var net = require("net");
              var fsw = require("fs").createWriteStream("./test.txt");
              //pipe方法实践
              var server = net.createServer();
              server.on("connection",function(socket){
                console.log("链接正常...");
                socket.setEncoding("utf8");//socket对象的设置数据编码格式
                socket.on("data",function(data){
                  //console.log(data.toString());//调用buf.toString();
                  console.log(data);
                  socket.pipe(fsw);
                });
                socket.on("end",function(){
                  console.log("链接关闭...");
                })
              }).listen("3000","localhost");
        4、socket.unpipe([destination]);取消目标对象的写入操作
        5、socket.pause();暂停data事件的触发
        6、socket.resume();恢复data事件的触发
      3、属性:
        1、bytesRead:属性值为socket对象接收到的客户端发送的数据的字节数
    3、创建TCP客户端:
      1、只需创建一个用于连接TCP服务器的socket端口对象
        1、var net = new net.Socket([options]);
          1、options:
            1、fd:指定一个现存的socket的文件描述符,TCP客户端将使用这个现存的socket端口和服务器连接
            2、type:指定客户端使用的协议,tcp4/tcp6/unix
            3、allowHalfOpen:
              1、true:服务器接收到客户端发送的一个FIN包时不会回发FIN包,使得服务器可以继续向客户端发送数据,但不会接收客户端发送的数据
              2、false:default;服务器接收到客户端发送的一个FIN包时会回发一个FIN包
      2、方法:
        1、socket.connect(port,[host],[connectionListener]);
        2、socket.connect(path,[connectionListener]);//和一个使用unix端口的服务器进行连接
        3、socket.write(data,[encoding],[callback]);
          当数据写入到缓存队列时返回false,写入到缓存区时返回true,当返回false并且缓存区数据全部发送完毕触发drain事件
        4、socket.destroy();销毁socket端口对象确保不会被再次利用
        5、socket.end([data],[encoding]);服务器与客户端建立连接后,可以使用socket端口对象的end方法关闭链接
        6、server.unref();当客户端链接全部关闭时退出服务器应用程序
        7、server.ref();取消退出服务器应用程序
        8、socket.setKeepAlive([enable],[initialDelay]);
            会不断的向对方发送一个探测包,如果没有返回响应,则认为对方已关闭链接,则开始执行关闭链接后的操作
            1、enable:default:false,
            2、initialDelay:设置隔多久发送一次探测包,单位为毫秒,默认值为0
      3、属性:
        1、TCP客户端和TCP服务器连接后的socket端口对象属性
          1、remoteAddress:连接的另一端所使用的地址
          2、remotePort:连接的另一端所使用的端口号
          3、localAddress:本地用于建立连接的地址
          4、localPort:本地用于建立连接的端口号
        2、bufferSize:查看缓存队列当前缓存的字符数
        3、bytesWritten:属性值为从该socket端口向服务器或客户端已发送的字节数
    4、net模块中的类方法:
      1、net.isIP(input);判断一个字符串是否是一个IP地址;如果不是返回0,否则返回4/6
      2、net.isIPv4(input);判断一个字符串是否是一个IPv4地址,boolean;
      3、net.isIPv6(input);判断一个字符串是否是一个IPv6地址,boolean;
  2、使用dgram模块实现基于UDP的数据通信
    1、创建UDP服务器与客户端
      1、var socket = dgram.createSocket(type,[callback]);
        1、var socket = dgram.createSocket("udp4",function(msg,rinfo){})
        2、type:指定UDP通信时使用的协议类型:udp4/udp6
        3、msg:是一个Buffer对象,存放接收到的数据
        4、rinfo:对象
          1、address:属性值为发送者使用的地址
          2、family:属性值为发送者使用的地址类型,IPv4/IPv6
          3、port:属性值为发送者使用的端口号
          4、size:属性值为发送的数据的字节数
      2、事件:
        1、message:当从该socket端口接收到数据时触发;function(msg,rinfo){}
        2、listening:当开始监听指定端口号和地址时触发;function(){}
        3、close:当socket端口关闭时触发;function(){}
        4、error:UDP服务器向UDP客户端发送数据时产生错误时触发;function(){}
      3、方法:
        1、socket.bind(port,[address],[callback]);指定该socket端口对象监听的地址和端口号
        2、socket.send(buf,offset,length,port,address,[function(err,bytes){}]);socket端口对象向外发送数据
          1、buf:是一个Buffer对象
          2、offset:指定从缓存区中取出要发送的数据的位置
          3、length:指定需要发送的数据的字节数
          4、port:指定接收数据的socket端口对象的端口号
          5、address:指定接收数据的socket端口对象所属地址
          6、bytes:回调函数的第二个参数为发送的数据的字节数
          7、如果未使用socket.bind()方法指定端口号及地址,则由操作系统随机指定一个接收端口号并指定可以接收来自任何地址的数据
        3、var address = socket.address();获取该socket端口对象的相关信息,返回一个对象
          1、port:属性值为socket端口对象的端口号
          2、address:属性值为socket端口对象所属地址
          3、family:属性值为socket端口对象所属地址类型,IPv4/IPv6
        4、socket.close();关闭socket端口对象,停止对该端口的数据监听,
            如果该端口对象的应用程序不再执行其他代码,则应用程序被正常关闭,如果有多个客户端链接,则会产生错误
        5、socket.unref();指定当不存在与该socket端口对象进行通信的客户端链接时允许服务器应用程序关闭
        6、socket.ref();取消退出应用程序
        7、socket.setTTL(ttl);设置网络中发送的每个数据包的生存时间,默认值为64,取值1-255,表示数据包经过路由器的最大数目
    2、实现广播和组播
      1、方法:
        1、socket.setBroadcast(flag);
            参数为 Boolean => true,则利用该socket端口对象的send方法发送广播,同时需要将send的方法的address设置为广播地址
    3、组播:指网络中同一业务类型主机进行逻辑上的分组,从某个socket端口发出的数据只能被该组内的主机接收
      1、网络中的D类地址作为组播地址:224.0.0.0 ~ 239.255.255.255
        1、局部组播地址:224.0.0.0 ~ 224.0.0.255;为路由协议和其他用途保留的地址
        2、预留组播地址:224.0.1.0 ~ 238.255.255.255;可用于全球范围或网络协议
        3、管理权限组播地址:239.0.0.0 ~ 239.255.255.255;可供组织内部使用,不能用于internet,可限制组播范围
      2、方法:
        1、socket.addMembership(multicastAddress,[multicastInterface]);将该socket端口对象加入到组播组中
          1、multicastAddress:String,指定socket端口对象加入的组播组地址,
          2、multicastInterface:String,指定socket端口对象需要加入的网络接口IP地址,省略则被加入所有有效的网络接口中,       
        2、socket.dropMembership(multicastAddress,[multicastInterface]);将该socket端口对象退出组播组
          1、当该socket端口或者运行该socket端口的进程被终止时，自动调用该方法
        3、socket.setMulticastTTL(ttl);
          1、设置该端口进行组播时,从该端口发出的数据包在路由器废弃之前经过的路由器最大数目
        4、socket.setMulticastLoopback(flag);default:true;指定组播数据是否允许被回送,
        var dgram = require("dgram");
        var client = dgram.createSocket("udp4");
        var count = 0;
        client.on("listening",function(){
          client.addMembership("235.185.192.108");
        })
        client.on("message",function(msg,rinfo){
          console.log("接收组播信息第%d次",++count);
          console.log(msg.toString());
          console.log(rinfo);
          if(count === 10){
            var buf = new Buffer("ok");
            client.send(buf,0,buf.length,rinfo.port,rinfo.address,function(err,bytes){
              if(err){
                console.log("请求停止组播发送信息失败...");
              }else{
                console.log("请求停止组播信息成功!");
                client.unref();
              }
            });
          }
        })
        client.bind(8888,"192.168.2.107");


