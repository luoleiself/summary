8. HTTP与HTTPS服务器及客户端
  8.1. HTTP服务器
    1. 方法: var http = require('http');
      1. var server = http.createServer([callback]); // 创建一个http服务器
        1. callback(request): http.IncomingMessage对象,代表一个客户端的请求
        2. callback(response): http.ServerResponse对象,代表一个服务器响应对象
        eg:var server = http.createServer(function(req,res){
            console.log(req); // 和 request 事件的回调函数的作用一致
            console.log(res);
          })
      2. server.listen(port,[host],[backlog],[callback]); // 指定服务器需要监听的地址
        1. port: 指定服务器需要监听的端口号
        2. host: 指定服务器需要监听的地址
        3. backlog: 指定位于等待队列中的客户端连接的最大数,default-max:511
        4. callback: 当开始监听指定端口及地址的客户端连接时触发
        eg:server.listen(3000,'localhost',200,function(){
            console.log('服务器开始监听...'); // 和 listening 事件的回调函数的作用一致 
          })
      3. server.close(); // 关闭该服务器
      4. server.setTimeout(msecs,callback); // 设置服务器的超时时间
        1. msecs: 设置超时时间,单位毫秒,Number,default:2min
        2. callback(socket): 服务器超时时的回调函数 
        eg:server.setTimeout(120000,function(socket){
            console.log(socket.address()); // 超时2分钟时的回调函数, 和 timeout 事件的回调函数的作用一致
          })
    2. 事件:
      1. request: 当接收到客户端的请求时触发 
        eg:server.on('request',function(req,res){
            console.log(req); // 和创建 http 服务器对象的回调函数的作用一致
          })
      2. connnection: 当客户端和服务器端链接时触发
        eg:server.on('connection',function(socket){
            console.log(socket); // 返回值为服务器监听的端口对象
            // 和 request 事件的区别：request事件返回的用户请求和服务器响应的对象;
            // connection事件返回服务器监听的端口对象
          })
      3. listening: 当服务器开始监听指定端口及地址的客户端连接时触发
        eg:server.on('listening',function(){
            console.log('服务器开始监听...'); // 和 server.listen 方法的回调函数的作用一致
          })
      4. close: 当服务器关闭时触发 
        eg:server.on('close',function(){
            console.log('服务器被关闭了...'); 
          })
      5. error: 当服务器发生错误时触发,EADDRINUSE表示服务器监听的端口及地址被占用
        eg:server.on('error',function(err){
            err.code == 'EADDRINUSE' console.log('端口及地址被占用...') : '';
          })
      6. timeout: 当客户端请求超时时触发
        eg:server.on('timeout',function(socket){
            console.log(socket.address()); // 和 server.setTimeout 方法的回调函数的作用一致
          })
    3. 属性:
      1. server.timeout: 查看/设置服务器的超时时间
    4. 获取客户端请求信息
      1. 当该对象用于读取客户端请求流中的数据时:
        1. method:String,值为客户端向服务器发送请求的方法,get,post,put,delete
        2. url:客户端向服务器发送请求时使用的url参数字符串
        3. headers:请求头对象,值为客户端发送的所有的请求头信息,包括cookie信息及浏览器信息
        4. httpVersion:值为客户端发送的http版本,1.1/1.0
        5. trailers:客户端发送的trailer对象,值为客户端附加的一些http信息,该对象在请求数据之后,当end事件出发时才读取
        6. socket:值为服务器监听客户端请求的sokcet对象   
        eg:var http = require("http");
          var fs = require("fs");
          var server = http.createServer(function(req,res){
            if(req.url !== "/favicon.ico" ){
              /*
              var out = fs.createWriteStream("./request.log");
              out.write("客户端所用的请求方法为:"+req.method+"\r\n");
              out.write("客户端所用的url字符串为:"+req.url+"\r\n");
              out.write("客户端请求头对象为:"+JSON.stringify(req.headers)+"\r\n");
              out.end("客户端所用的请求版本:"+req.httpVersion+"\r\n");
              */
              req.on("data",function(data){
                console.log("服务器接收到数据:"+decodeURIComponent(data));
              });
              req.on("end",function(){
                console.log("数据已接收完毕...");
              })
            }
            res.end();
          }).listen("3000","localhost");
      2. 事件:
        1. data: 当从客户端请求流中读取到新的数据时触发
        2. end: 当从客户端请求流中读取完数据时触发
        eg:var http = require('http');
            var server = http.createServer(function(req,res){
              if(req.url !== '/favicon.ico'){
                req.on('data',function(data){
                  console.log('服务器端接收到数据: '+decodeURIComponent(data));
                });
                req.on('end',function(){
                  console.log('客户端请求数据读取完毕...');
                })
              }
              res.end();
            }).listen(3000,'localhost');
  8.2. 转换URL字符串与查询:url模块与Query String模块
    1. 一个完整的url字符串从?(不包括)开始,到#(不包括)结束,称为查询字符串
      eg:http://www.google.com/user.php?userName=ceshi&age=40&sex=male#hash
    2. 方法:
      1. querystring.parse(str,[sep],[eq],[options]);将该字符串转换为一个对象,如果有多个值对应一个键则自动转为数组存放
        1. sep:指定该查询字符串中的分割字符,默认为'&'
        2. eq:制定该查询字符串中的分配符,默认为'='
        3. options:对象,
          1. maxKeys:指定转换后的对象中的属性个数, 
        eg:var parObj = querystring.parse('userName=zhangsan&age=28&sex=male&interest=read&interest=walk');
        // {userName:'zhangsan',age:28,sex:'male':interest:['read','walk']}
      2. querystring.stringify(obj,[sep],[eq]); // 将一个对象转换为查询字符串
        eg:querystring.stringify(parObj);
        // 'userName=zhangsan&age=28&sex=male&interest=read&interest=walk'
      3. url.parse(urlstr,[parsequerystring]); // 对完整的url字符串进行转换,转换为一个对象
        1. urlstr: 指定需要被转换的url
          1. href:被转换的原url字符串
          2. protocol:客户端发送请求时使用的协议;
          3. slashes:在协议和路径之间是否使用'//'分隔符
          4. host:url字符串中完整的地址及端口号
          5. auth:url字符串中的认证信息部分
          6. hostname:url字符串中的完整地址
          7. port:url字符中的端口号
          8. pathname:url字符串的路径,不包含查询字符串
          9. search:url字符串中的查询字符串,包含'?'
          10. path:url字符串中的路径,包含查询字符串
          11. query:url字符串中的查询字符串,不包含'?'
          12. hash:url字符串中的散列字符串,包含起始字符'#'
        2. parsequerystring:设置为true,将查询字符串转换成对象,default:fasle,
        eg:var urlObj = url.parse('http://localhost:3000/server.php?userName=zhangsan&age=28&sex=male#name1',true);
          // {href:'',protocol:''...,hash:''};
      4. url.format(urlObj); // 将url字符串转换后的对象还原成url字符串
      5. url.resolve(from,to); // 将两个方法结合成一个路径
        eg:url.resolve('http://www.baidu.com/a/b/c','one/two/three');
        // 'http://www.baidu.com/one'
  8.3. 发送服务端相应流:
    1. 方法:
      1. res.writeHead(statusCode,[reasonPhrase],[headers]);
        1. statusCode:响应状态码,三位数字
        2. reasonPhrase:String,指定该状态的描述信息
        3. headers:Object,指定服务器创建的响应头对象
          1. content-type:指定内容类型
          2. location:用于将客户端重定向到另一个地址
          3. content-disposition:指定一个被下载的文件
          4. content-length:指定服务器响应的字节数
          5. set-cookie:在客户端创建一个cookie
          6. content-encoding:指定服务器响应内容的编码方式
          7. Cache-control:用于开启缓存机制
          8. Expires:指定缓存过期时间
          9. Etag:指定当服务器响应内容没有变化时不重新下载数据
        eg:res.writeHead(200,'ok',{'Content-Type':'text/plain','Access-Control-Allow-Origin':'http://localhost'})
      2. res.setHeader(name,value); // 单独设置响应头信息
        eg:res.setHeader("content-type","text/plain");
      3. response.getHeader(name); // 单独获取响应头信息
        eg:res.getHeader("content-type");
      4. response.removeHeader(name); // 删除指定响应信息字段
        eg:res.removeHeader("content-type");
      5. res.addTrailers(headers); // 在响应数据的尾部追加一个头部信息,如果客户端使用http 1.0版本,该方法不能生效
      6. res.write(chunk,[encoding]); // 发送响应内容;
        1. chunk:指响应内容,可以为一个Buffer对象或者一个字符串
        2. encoding:默认值为utf8
      7. res.end([chunk],[encoding]); // 结束发送响应内容
      8. res.setTimeout(mesc,[function(socket){}]);设置响应超时时间
    2. 属性:
      1. res.headerSent:当响应头已发送,该值为true,否则该值为false
      2. res.sendDate:default:true,服务器默认自动发送当前服务器时间
      3. res.statusCode:获取服务器的响应状态码
    3. 事件:
      1. timeout: 当响应超时时触发
      2. close: 当连接中断时触发
  8.4. HTTP客户端:
    1. 方法:
      1. var req = http.request(options,[callback]); 
        1. options:Object/String,
          1. host:指定域名或目标主机的ip地址,默认为localhost
          2. hostname:指定域名或目标主机的ip地址,默认为localhost,1,2,都有则优先使用2,
          3. port:指定目标服务器用于HTTP客户端链接的端口号
          4. localAddress:指定专用网络链接的本地端口
          5. socketPath:指定目标UNix域端口
          6. method:指定HTTP的请求方式,默认为'GET'
          7. path:指定请求路径及查询字符串,默认值为'/'
          8. headers:指定客户端请求头对象
          9. auth:指定认证信息部分
          10. agent:指定HTTP用户代理
        2. callback(res): // 返回一个http.ClientRequest对象,代表一个客户端请
        eg:var req = http.request({hostname:'localhost',port:3000,path:'/',method:'get'},function(res){
            console.log(res);
          })
      2. req.write(chunk,[encoding]); // 向服务器发送数据
      3. req.end([chunk],[encoding]); // 结束本次请求,每次发送新请求时
      4. req.abort(); // 终止本次请求
      5. req.setTimeout(timeout,[callback]);// 设置请求的超时时间,
      6. http.get(options,[callback]);
        1. 只能使用get方式请求数据
        2. 不用调用end方法结束请求,NodeJs自动调用
        eg:http.get({hostname:'localhost',port:3000,path:'/'},function(res){
            console.log(res);
          })
    2. 事件:
      1. response: 当客户端请求获取到服务器响应流时触发
        eg:req.on('response',function(){
            console.log(res);
          })
      2. error: 当请求过程中发生错误时触发
        eg:req.on('error',function(err){
            console.log(err);
          })
      3. socket:当为该连接分配端口时触发
        eg:req.on('socket',function(socket){
            console.log(socket);
          })
      4. timeout:当请求超时触发
      5. end:当请求结束时触发
    3. 代理服务器:
      eg:var http = require('http');
          var url = require('url');
          var server = http.createServer(function(sreq,sres){
            var url_parts = url.parse(sreq.url);
            var opts = {
              host:'www.amazon.cn',
              port:80,
              path:url_parts.pathname,
              headers: sreq.headers
            } 
            var creq = http.get(opts,function(cres){
              sres.writeHead(cres.statusCode,cres.headers);
              cres.pipe(sres);
            })
            sreq.pipe(creq); 
          })
  8.5. HTTPS服务器与客户端
    1. 创建私钥和公钥
      $ openssl genrsa -out privatekey.pem 1024 //创建私钥
      $ openssl req -new -key privatekey.pem -out certrequest.csr //创建签名证书请求文件
      $ openssl x509 -req -in certrequest.csr -signkey privatekey.pem -out certificate.pem //获取证书
      $ openssl pkcs12 -export -in certificate.pem -inkey privatekey.pem -out certificate.pfx //创建pfx文件
    2. 方法:
      1. var server = https.createServer(options,[function(request,response){}]);
        1. pfx:String/Buffer,指定从pfx文件读取出私钥. 公钥及证书
        2. key:String/Buffer,指定从后缀名为pem的私钥文件中读取出来的私钥
        3. passphrase:String,用于为私钥文件或pfx文件指定密码
        4. cert:String/Buffer,指定从后缀名为pem的文件中读取出来的公钥
        5. ca:StringArray/BufferArray,指定一组证书
        6. crl:String/StringArray,指定证书吊销列表
        7. ciphers:String,指定使用或取消使用的密码
        8. handshakeTimeout:客户端和服务器之间的握手时间,默认120秒
        9. honorCipherOrder:default:false,设置为true,服务器将密码列表发送给客户端,由客户端选择密码
        10. requestCert:default:false,设置为true,服务器在连接时要求客户端提供证书
        11. rejectUnauthorized:default:false,设置为true,服务器拒绝任何不能提供服务器要求的证书的客户端
        12. NPNProtocols:Array/Buffer,服务器端所需要使用的NPN协议
        13. sessionInContext:String,指定服务器端的session的标识符
      2. server.listen(port,[host],[backlog],[callback]);
      3. server.close();关闭服务器
    3. 事件:
      1. request:当接收到客户端的请求时触发,function(request,response){}
      2. listening:当服务器开始监听指定端口地址时触发,function(){}
      3. close:当服务器关闭时触发
        eg:server.on('close',function(){
          console.log('');
        })
