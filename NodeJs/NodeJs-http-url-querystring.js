1、HTTP与HTTPS服务器及客户端
  1、HTTP服务器
    1、方法: 
      1、var server = http.createServer([requestListener]/function(request,response){});
        1、request:http.IncomingMessage对象,客户端请求
        2、response:http:ServerResponse对象,服务器响应
      2、server.listen(port,[host],[backlog],[callback]);
        1、port:指定Http服务器监听的端口号,为0时则由服务器指定随机端口号
        2、host:指定监听的客户端地址,省略则监听任何来自IPv4地址的客户端链接
        3、backlog:指定等待队列中的客户端链接的最大数量,默认值为511
      3、server.close();如果服务器尚未与任何客户端建立连接,则应用程序正常退出,服务器正常关闭
      4、server.setTimeout(msecs,[callback]);设置http服务器的超时时间,超过时间则需要重新建立链接
        1、msecs:单位毫秒,
        2、function(socket){}
    2、事件:
      1、request:当接收客户端请求时触发;function(request,response){}
      2、listening:当开始监听客户端地址和端口号触发;function(){}
      3、close:当服务器关闭时触发该事件,function(){}
      4、error:当监听端口及地址冲突产生错误时触发,function(){},EADDRINUSE == 端口号或地址被占用
      5、connnection:当客户端和服务器端链接时触发,function(socket){}
      6、timeout:当服务器连接超时触发该事件,function(socket){}
      7、data:当从客户端请求流中读取到新的数据时触发,function(data){}
      8、end:当从客户端请求流中读取完数据时触发,function(){}
    3、属性:
      1、timeout:属性值为服务器的超时时间,单位毫秒;NodeJs中Http服务器的超时为2min
  2、获取客户端请求信息
    1、当该对象用于读取客户端请求流中的数据时:
      1、method:String,值为客户端向服务器发送请求的方法,get,post,put,delete
      2、url:客户端向服务器发送请求时使用的url参数字符串
      3、headers:请求头对象,值为客户端发送的所有的请求头信息,包括cookie信息及浏览器信息
      4、httpVersion:值为客户端发送的http版本,1.1/1.0
      5、trailers:客户端发送的trailer对象,值为客户端附加的一些http信息,该对象在请求数据之后,当end事件出发时才读取
      6、socket:值为服务器监听客户端请求的sokcet对象
      var http = require("http");
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
  3、转换URL字符串与查询:url模块与Query String模块
    1、一个完整的url字符串从?(不包括)开始,到#(不包括)结束,称为查询字符串
      e.g:http://www.google.com/user.php?userName=ceshi&age=40&sex=male#hash
    2、方法:
      1、querystring.parse(str,[sep],[eq],[options]);将该字符串转换为一个对象,如果有多个值对应一个键则自动转为数组存放
        1、sep:指定该查询字符串中的分割字符,默认为'&'
        2、eq:制定该查询字符串中的分配符,默认为'='
        3、options:对象,maxKeys:指定转换后的对象中的属性个数,
      2、querystring.stringify(obj,[sep],[eq]);将一个对象转换为查询字符串
          querystring.stringify({username:'ceshi',age:'26',sex:'female'},'!',':')
      3、url.parse(urlstr,[parsequerystring]);对完整的url字符串进行转换,转换为一个对象
        1、返回的对象:
          1、href:被转换的原url字符串
          2、protocol:客户端发送请求时使用的协议;
          3、slashes:在协议和路径之间是否使用'//'分隔符
          4、host:url字符串中完整的地址及端口号
          5、auth:url字符串中的认证信息部分
          6、hostname:url字符串中的完整地址
          7、port:url字符中的端口号
          8、pathname:url字符串的路径,不包含查询字符串
          9、search:url字符串中的查询字符串,包含'?'
          10、path:url字符串中的路径,包含查询字符串
          11、query:url字符串中的查询字符串,不包含'?'
          12、hash:url字符串中的散列字符串,包含起始字符'#'
        2、parsequerystring:default:fasle,设置为true,将查询字符串转换成对象
      4、url.format(urlobj);将url字符串转换后的对象还原成url字符串
      5、url.resolve(from,to);将两个方法结合为一个路径
  4、发送服务端相应流:
    1、方法:
      1、response.writeHead(statusCode,[reasonPhrase],[headers]);
        1、statusCode:响应状态码,三位数字
        2、reasonPhrase:String,指定该状态的描述信息
        3、headers:Object,指定服务器创建的响应头对象
          1、content-type:指定内容类型
          2、location:用于将客户端重定向到另一个地址
          3、content-disposition:指定一个被下载的文件
          4、content-length:指定服务器响应的字节数
          5、set-cookie:在客户端创建一个cookie
          6、content-encoding:指定服务器响应内容的编码方式
          7、Cache-control:用于开启缓存机制
          8、Expires:指定缓存过期时间
          9、Etag:指定当服务器响应内容没有变化时不重新下载数据
      2、response.setHeader(name,value);单独设置响应头信息
        e.g:res.setHeader("content-type","text/plain");
      3、response.getHeader(name);单独获取响应头信息
        e.g:res.getHeader("content-type");
      4、response.removeHeader(name);删除指定响应信息字段
        e.g:res.removeHeader("content-type");
      5、response.addTrailers(headers);在响应数据的尾部追加一个头部信息
        如果客户端使用http 1.0版本,该方法不能生效
        response.addTrailers({"Content-MD5":"879fda879f7da9s7g9dsa797as"});
      6、response.write(chunk,[encoding]);发送响应内容;
        1、chunk:指响应内容,可以为一个Buffer对象或者一个字符串
        2、encoding:默认值为utf8
      7、response.end([chunk],[encoding]);结束发送响应内容
      8、response.setTimeout(mesc,[function(socket){}]);设置响应超时时间
    2、属性:
      1、headerSent:当响应头已发送,该值为true,否则该值为false
      2、sendDate:default:true,服务器默认自动发送当前服务器时间
      3、statusCode:获取服务器的响应状态码
    3、事件:
      1、timeout:当响应超时触发,function(){}
      2、close:当end方法调用之前,链接中断则触发该事件,function(){}
  5、HTTP客户端:
    1、方法:
      1、var req = http.request(options,[function(response){}]);返回一个http.ClientRequest对象,代表一个客户端请求
        1、options:Object/String,
          1、host:指定域名或目标主机的ip地址,默认为localhost
          2、hostname:指定域名或目标主机的ip地址,默认为localhost,1,2,都有则优先使用2,
          3、port:指定目标服务器用于HTTP客户端链接的端口号
          4、localAddress:指定专用网络链接的本地端口
          5、socketPath:指定目标UNix域端口
          6、method:指定HTTP的请求方式,默认为'GET'
          7、path:指定请求路径及查询字符串,默认值为'/'
          8、headers:指定客户端请求头对象
          9、auth:指定认证信息部分
          10、agent:指定HTTP用户代理
      2、request.write(chunk,[encoding]);向服务器发送数据
      3、request.end([chunk],[encoding]);结束本次请求,每次发送新请求时
      4、request.abort();终止本次请求
      5、request.setTimeout(timeout,[callback]);设置请求的超时时间,
      6、http.get(options,[callback]);
        1、只能使用get方式请求数据
        2、不用调用end方法结束请求,NodeJs自动调用
      var http = require("http");
      var req = http.request({hostname:"www.baidu.com",port:"80",path:"/",method:"GET"}
        ,function(res){
          console.log(res.statusCode);
          console.log(JSON.stringify(res.headers));
        })
      req.end();
    2、事件:
      1、response:当客户端请求获取到服务器响应流时触发
      2、error:当请求过程中发生错误时触发
      3、socket:当为该连接分配端口时触发,function(socket){}
      4、timeout:当请求超时触发,
      5、end:当请求结束时触发,function(){}
  6、HTTPS服务器与客户端
    1、创建私钥和公钥
      $ openssl genrsa -out privatekey.pem 1024 //创建私钥
      $ openssl req -new -key privatekey.pem -out certrequest.csr //创建签名证书请求文件
      $ openssl x509 -req -in certrequest.csr -signkey privatekey.pem -out certificate.pem //获取证书
      $ openssl pkcs12 -export -in certificate.pem -inkey privatekey.pem -out certificate.pfx //创建pfx文件
    2、方法:
      1、var server = https.createServer(options,[function(request,response){}]);
        1、pfx:String/Buffer,指定从pfx文件读取出私钥、公钥及证书
        2、key:String/Buffer,指定从后缀名为pem的私钥文件中读取出来的私钥
        3、passphrase:String,用于为私钥文件或pfx文件指定密码
        4、cert:String/Buffer,指定从后缀名为pem的文件中读取出来的公钥
        5、ca:StringArray/BufferArray,指定一组证书
        6、crl:String/StringArray,指定证书吊销列表
        7、ciphers:String,指定使用或取消使用的密码
        8、handshakeTimeout:客户端和服务器之间的握手时间,默认120秒
        9、honorCipherOrder:default:false,设置为true,服务器将密码列表发送给客户端,由客户端选择密码
        10、requestCert:default:false,设置为true,服务器在连接时要求客户端提供证书
        11、rejectUnauthorized:default:false,设置为true,服务器拒绝任何不能提供服务器要求的证书的客户端
        12、NPNProtocols:Array/Buffer,服务器端所需要使用的NPN协议
        13、sessionInContext:String,指定服务器端的session的标识符
      2、server.listen(port,[host],[backlog],[callback]);
      3、server.close();关闭服务器
    3、事件:
      1、request:当接收到客户端的请求时触发,function(request,response){}
      2、listening:当服务器开始监听指定端口地址时触发,function(){}
      3、close:当服务器关闭时触发,function(){}