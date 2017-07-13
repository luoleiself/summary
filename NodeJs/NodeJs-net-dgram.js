1. 第七章:基于TCP与UDP的数据通信:net模块/dgram模块
  1. 使用net模块实现基于TCP的数据通信
    1. TCP服务器:
      1. 方法:
        1. var server = net.createServer([options],[connectionListener]); // 创建 TCP 服务器
          1. options:参数为一个对象;
            allowHalpOpen:值为false时,当服务器接收到客户端一个FIN包时立即回发一个FIN包,
              值为true时,服务器接收到客户端一个FIN包时不回发FIN包,服务器可以继续向客户端发送数据,但不会继续接收客户端发送的数据,
              需要手动调用end方法关闭连接
              default:false;
          2. connectionListener:指定当客户端和服务器建立连接时调用的回调函数,参数值为服务器监听端口的socket对象
          eg:var server = net.createServer(function(socket){ // 创建一个tcp服务器
            console.log('有客户端链接...'); // 当客户端连接服务器时输出,回调函数和connection事件作用一致
          }); 
        2. server.listen(); // 监听客户端链接,下面三种方法
          2.1. server.listen(port,[host],[backlog],[callback]); 
            1. port:指定需要监听的端口号,值为0时,由TCP服务器将自动分配一个随机端口号
            2. host:指定需要监听的ip地址或主机名,值为null时,服务器将监听任何来自于ipv4地址的客户端链接
            3. backlog:指定位于等待队列中的客户端链接的最大数量,超出则拒绝新的客户端的连接请求,default:511,
            4. callback():指定listening事件触发时的回调函数,
            eg:server.listen(3000,'192.168.2.223',200,function(){
                console.log('服务器开始监听...');
              }); 
            // 服务器开始监听192.168.2.223:3000的客户端链接,最大连接数200,回调函数和listening事件作用一致
          2.2. server.listen(path,[callback]);
            1. path:指定需要监听的路径;
            2. callback():指定listening事件触发时的回调函数,
          2.3. server.listen(handle,[callback]);
            1. handle:指定需要监听的socket句柄
            2. callback():指定listening事件触发时的回调函数,
        3. var addr = server.address(); // 触发listening事件后调用该方法查看监听的地址信息,返回一个对象
          1. addr.port:TCP服务器监听的socket端口号
          2. addr.address:TCP服务器监听的地址
          3. addr.family:TCP服务器监听的地址类型,ipv4,ipv6
          eg:server.on('listening',function(){
              var addr = server.address();
            })
        4. server.getConnections(callback); // 查看当前与服务器建立连接的客户端的连接数量
          1. callback(err,count);
            1. err:错误信息对象
            2. count:代表获取到的客户端链接数量
            eg:server.getConnections(function(err,count){
                console.log('当前与服务器建立连接的客户端的连接数量为: %d',count);
              })
        5. server.close([callback]); // 服务器拒绝新的客户端链接,保存当前现有的连接
          1. callback(); // 当服务器关闭时的回调函数
          eg:server.close(function(){
              console.log('服务器关闭了...'); // 回调函数和close事件作用一致
            })
      2. 事件:
        1. connection:当客户端和服务器建立连接时触发
          eg:server.on('connection',function(socket){
              console.log('有客户端链接...')
            }); // 和创建tcp服务器的回调函数功能一致
        2. listening:当服务器开始监听指定端口地址的客户端链接时触发
          eg:server.on('listening',function(){
              console.log('服务器开始监听...')
            }); // 和listen方法的回调函数功能一致
        3. error:当服务器监听指定端口地址时发生错误时触发,EADDRINUSE:代表服务器监听地址及端口被占用
          eg:server.on('error',function(err){
              console.log('服务器监听发生错误...')
            });
        4. close:当TCP服务器关闭时触发;
          eg:server.on('close',function(){
              console.log('服务器关闭了....')
            }) // 和close方法的回调函数功能一致
      3. Socket对象:可被用来读取客户端发送的流数据;
        1. 使用net.Socket代表一个socket端口对象;
        2. net.createServer的回调函数的参数为一个自动创建的socket端口对象;
        3. 服务器的connection事件的回调函数的参数代表一个自动创建的socket端口对象;
        4. 方法:
          1. var addr = socket.address(); // 获取socket端口对象的相关信息,返回一个对象
            1. addr.port:代表socket端口对象的端口号
            2. addr.address:代表socket端口对象的地址
            3. addr.family:标识该socket端口对象地址的所属类型
            eg:var server = net.createServer(function(socket){
                var addr = socket.address();
              })
          2. socket.setEncoding('utf8'); 设置读取的数据的编码格式
          3. socket.pipe(destination,[options]); 将客户端发送的流数据书写到文件或其他对象中
          4. socket.unpipe([destination]); 取消目标对象的写入操作
            eg:var server = require('net').createServer();
              var file = require('fs').createWriteStream('./message.txt');
              server.on('connection',function(socket){
                socket.setEncoding("utf8");
                socket.on(data,function(data){
                  socket.pipe(file,{end:false});
                  setTimeout(function(){
                    file.end('再见');
                    socket.unpipe(file);
                  },5000)
                })
              })
              server.listen(8888,'localhost');
          5. socket.pause(); 暂停data事件的触发
          6. socket.resume(); 恢复data事件的触发
          7. socket.setTimeout(timeout,[callback]); 指定与该端口相链接的客户端链接的超时时间,和timeout事件的作用一致
            1. timeout:指定客户端链接的超时时间,单位:毫秒
            2. callback():客户端链接超时的回调函数
        5. 事件:
          1. data:每次接收到客户端发送的流数据时触发
            eg:server.on('connection',function(socket){
                socket.on('data',function(data){
                  console.log(data);
                })
              });
              server.listen(3000,'localhost');
          2. end:当客户端链接关闭时触发socket端口对象的该事件
            eg:socket.on('end',function(){
                console.log('客户端链接被关闭...');
              })
          3. timeout:当客户端链接超时时触发
            eg:socket.on('timeout',function(){
                console.log('客户端链接超时...');
              }) // 和socket.setTimeout方法的回调函数作用一致
        6. 属性:
          1. socket.bytesRead; 值为该socket端口对象接收到的客户端发送的数据的字节数
    2. TCP客户端:创建一个用于连接TCP服务器的端口对象
      1. 方法:
        1. var net = new net.Socket([options]); // 创建一个socket端口对象
          1. options:参数为一个对象
            1. fd:指定一个现存的socket的文件描述符,TCP客户端用这个去和服务器连接
            2. type:指定客户端所使用的协议,'tcp4','tcp6','unix'
            3. allowHalfOpen:和创建tcp服务器的回调函数功能一致
          eg:var client = new net.Socket(); // 创建一个Socket端口对象
/**************************************************************/







    3. 创建TCP客户端:
      1. 只需创建一个用于连接TCP服务器的socket端口对象
        1. var net = new net.Socket([options]);
          1. options:
            1. fd:指定一个现存的socket的文件描述符,TCP客户端将使用这个现存的socket端口和服务器连接
            2. type:指定客户端使用的协议,tcp4/tcp6/unix
            3. allowHalfOpen:
              1. true:服务器接收到客户端发送的一个FIN包时不会回发FIN包,使得服务器可以继续向客户端发送数据,但不会接收客户端发送的数据
              2. false:default;服务器接收到客户端发送的一个FIN包时会回发一个FIN包
      2. 方法:
        1. socket.connect(port,[host],[connectionListener]);
        2. socket.connect(path,[connectionListener]);//和一个使用unix端口的服务器进行连接
        3. socket.write(data,[encoding],[callback]);
          当数据写入到缓存队列时返回false,写入到缓存区时返回true,当返回false并且缓存区数据全部发送完毕触发drain事件
        4. socket.destroy();销毁socket端口对象确保不会被再次利用
        5. socket.end([data],[encoding]);服务器与客户端建立连接后,可以使用socket端口对象的end方法关闭链接
        6. server.unref();当客户端链接全部关闭时退出服务器应用程序
        7. server.ref();取消退出服务器应用程序
        8. socket.setKeepAlive([enable],[initialDelay]);
            会不断的向对方发送一个探测包,如果没有返回响应,则认为对方已关闭链接,则开始执行关闭链接后的操作
            1. enable:default:false,
            2. initialDelay:设置隔多久发送一次探测包,单位为毫秒,默认值为0
      3. 属性:
        1. TCP客户端和TCP服务器连接后的socket端口对象属性
          1. remoteAddress:连接的另一端所使用的地址
          2. remotePort:连接的另一端所使用的端口号
          3. localAddress:本地用于建立连接的地址
          4. localPort:本地用于建立连接的端口号
        2. bufferSize:查看缓存队列当前缓存的字符数
        3. bytesWritten:属性值为从该socket端口向服务器或客户端已发送的字节数
    4. net模块中的类方法:
      1. net.isIP(input);判断一个字符串是否是一个IP地址;如果不是返回0,否则返回4/6
      2. net.isIPv4(input);判断一个字符串是否是一个IPv4地址,boolean;
      3. net.isIPv6(input);判断一个字符串是否是一个IPv6地址,boolean;
  2. 使用dgram模块实现基于UDP的数据通信
    1. 创建UDP服务器与客户端
      1. var socket = dgram.createSocket(type,[callback]);
        1. var socket = dgram.createSocket("udp4",function(msg,rinfo){})
        2. type:指定UDP通信时使用的协议类型:udp4/udp6
        3. msg:是一个Buffer对象,存放接收到的数据
        4. rinfo:对象
          1. address:属性值为发送者使用的地址
          2. family:属性值为发送者使用的地址类型,IPv4/IPv6
          3. port:属性值为发送者使用的端口号
          4. size:属性值为发送的数据的字节数
      2. 事件:
        1. message:当从该socket端口接收到数据时触发;function(msg,rinfo){}
        2. listening:当开始监听指定端口号和地址时触发;function(){}
        3. close:当socket端口关闭时触发;function(){}
        4. error:UDP服务器向UDP客户端发送数据时产生错误时触发;function(){}
      3. 方法:
        1. socket.bind(port,[address],[callback]);指定该socket端口对象监听的地址和端口号
        2. socket.send(buf,offset,length,port,address,[function(err,bytes){}]);socket端口对象向外发送数据
          1. buf:是一个Buffer对象
          2. offset:指定从缓存区中取出要发送的数据的位置
          3. length:指定需要发送的数据的字节数
          4. port:指定接收数据的socket端口对象的端口号
          5. address:指定接收数据的socket端口对象所属地址
          6. bytes:回调函数的第二个参数为发送的数据的字节数
          7. 如果未使用socket.bind()方法指定端口号及地址,则由操作系统随机指定一个接收端口号并指定可以接收来自任何地址的数据
        3. var address = socket.address();获取该socket端口对象的相关信息,返回一个对象
          1. port:属性值为socket端口对象的端口号
          2. address:属性值为socket端口对象所属地址
          3. family:属性值为socket端口对象所属地址类型,IPv4/IPv6
        4. socket.close();关闭socket端口对象,停止对该端口的数据监听,
            如果该端口对象的应用程序不再执行其他代码,则应用程序被正常关闭,如果有多个客户端链接,则会产生错误
        5. socket.unref();指定当不存在与该socket端口对象进行通信的客户端链接时允许服务器应用程序关闭
        6. socket.ref();取消退出应用程序
        7. socket.setTTL(ttl);设置网络中发送的每个数据包的生存时间,默认值为64,取值1-255,表示数据包经过路由器的最大数目
    2. 实现广播和组播
      1. 方法:
        1. socket.setBroadcast(flag);
            参数为 Boolean => true,则利用该socket端口对象的send方法发送广播,同时需要将send的方法的address设置为广播地址
    3. 组播:指网络中同一业务类型主机进行逻辑上的分组,从某个socket端口发出的数据只能被该组内的主机接收
      1. 网络中的D类地址作为组播地址:224.0.0.0 ~ 239.255.255.255
        1. 局部组播地址:224.0.0.0 ~ 224.0.0.255;为路由协议和其他用途保留的地址
        2. 预留组播地址:224.0.1.0 ~ 238.255.255.255;可用于全球范围或网络协议
        3. 管理权限组播地址:239.0.0.0 ~ 239.255.255.255;可供组织内部使用,不能用于internet,可限制组播范围
      2. 方法:
        1. socket.addMembership(multicastAddress,[multicastInterface]);将该socket端口对象加入到组播组中
          1. multicastAddress:String,指定socket端口对象加入的组播组地址,
          2. multicastInterface:String,指定socket端口对象需要加入的网络接口IP地址,省略则被加入所有有效的网络接口中,       
        2. socket.dropMembership(multicastAddress,[multicastInterface]);将该socket端口对象退出组播组
          1. 当该socket端口或者运行该socket端口的进程被终止时，自动调用该方法
        3. socket.setMulticastTTL(ttl);
          1. 设置该端口进行组播时,从该端口发出的数据包在路由器废弃之前经过的路由器最大数目
        4. socket.setMulticastLoopback(flag);default:true;指定组播数据是否允许被回送,
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


