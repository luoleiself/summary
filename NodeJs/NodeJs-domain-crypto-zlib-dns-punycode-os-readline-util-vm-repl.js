1、第十章:NodeJs中的错误处理与断言处理
  1、使用domain模块处理错误
    1、try...catch:只能捕获同步方法中抛出的异常,不能捕获异步方法中抛出的异常
      //同步方法可以使用try..catch方法捕获异常
      var fs = require("fs");
      try{
        var data = fs.createReadSync("test.txt","utf8");
        console.log(data);
      }catch(exception){
        console.log(exception);
      }
    2、方法:
      1、var domain = domain.create();返回一个Domain对象,该对象为继承EventEmitter类的实例对象
      2、domain.run(fn);指定该对象需要监听的代码,如果发生异常时,即捕获触发error事件,
      3、domain.add(emitter);值为一个需要被绑定的继承了EventEmitter类的实例对象,如果该实例对象发生异常则被捕获
        1、隐式绑定:run方法将所有的继承了EventEmitter类的实例对象隐式的绑定到domain对象上,
          如果任何对象发生异常都会被捕获
        2、显式绑定:add方法将指定的继承了EventEmitter类的实例对象显式的绑定到domain对象上,
      4、domain.remove(emitter);取消指定对象的绑定,
      5、domain.bind(callback);将一个回调函数与该Domain对象绑定,并返回一个函数将替换原回调函数被调用,如果发生异常必须使用throw方法抛出异常
      6、domain.intercept(callback);拦截一个回调函数中触发的异常,
      7、domain.exit();在run方法内弹出该domain对象,
      8、domain.enter();在run方法内将Domian对象推入Domain堆栈中并设置为当前使用的Domian对象
      9、domian.dispose();将该Domain对象销毁,同时与该对象绑定的回调函数取消,发生异常时不再捕获
    3、事件:
      1、error:当该对象捕获到异常时触发,function(err){}
    4、属性:
      1、domain.name;设置或获取该domain对象的名称
      2、domain._stack;查看domain堆栈中的内容
  2、NodeJs中的断言处理:assert模块
    1、方法:
      1、assert.equal(actual,expected,[message]);判断两个值是否相等,只比较值,不比较数据类型,'=='
      2、assert.notEqual(actual,expected,[message]);判断两个值是否不相等,只比较值,不比较数据类型,'!='
        1、actual;指定实际值,
        2、expected;指定预期值,否则抛出AssertionError
        3、message;指定自定义异常信息,
      3、assert.strictEqual(actual,expected,[message]);判断两个值及数据类型是否相等,'==='
      4、assert.notStrictEqual(actual,expected,[message]);判断两个值及数据类型是否不相等,'!=='
        1、actual;指定实际值,
        2、expected;指定预期值,否则抛出AssertionError
        3、message;指定自定义异常信息,
      5、assert(value,[message]);判断指定值是否为真,否则抛出AssertionError
      6、assert.ok(value,[message]);判断指定值是否为真,否则抛出AssertionError,可以代替ok方法
      7、assert.deepEqual(actual,expected,[message]);深层次比较,如果是原始数据类型,使用'=='比较,
          如果是对象类型,使用'==='比较值和属性的长度
      8、assert.notDeepEqual(actual,expected,[message]);深层次比较,作用和deepEqual方法相反
        1、actual;指定实际值,
        2、expected;指定预期值,否则抛出AssertionError
        3、message;指定自定义异常信息,
      9、assert.throws(block,[error],[message]);执行一段代码判断是否会抛出异常,为真代码抛出异常,为假则抛出AssertionError
      10、assert.doesNotThrow(block,[error],[message]);执行一段代码并判断该代码不会抛出异常,为真则正常执行,否则抛出AssertionError
        1、block;指定需要执行的代码段,
        2、error;为一个返回true或返回false的函数,如果返回false,则抛出AsertionError
        3、message;指定自定义异常信息,
2、第十一章:加密与压缩
  1、加密与解密:crypto模块
    1、方法:
      1、crypto.getCiphers();Array,获取NodeJs中可以使用的所有加密算法
      2、crypto.getHashes();Array,获取NodeJs中可以使用的所有散列加密算法
    2、散列算法:允许对一段数据进行验证的前提下,将数据模糊化,或者为一段数据提供一个校验码
      1、var hash = crypto.createHash(algorithm);创建一个hash对象,
        1、algorithm;String,指定需要使用的散列算法,'sha1','md5','sha256','sha512'
        var hash = crypto.createHash("sha1");
      2、hash.update(data,[input_encoding]);创建一个摘要,
        1、data;String/Buffer,指定摘要内容,
        2、input_encoding;指定摘要内容需要使用的编码格式,不指定则data必须为一个Buffer对象
      3、hash.digest([encoding]);获取该Hash对象的摘要内容,默认返回一个Buffer对象,使用该方法后不能再使用update方法追加摘要内容,
      var crypto = require("crypto");
      var fs = require("fs");
      var shasum = crypto.createHash("sha1");
      var s = fs.ReadStream('./app.js');
      s.on("data",function(d){
        shasum.update(d);
      });
      s.on("end",function(){
        var d = shasum.digest("hex");
        console.log(d);
      })
    3、HMAC算法: 将散列算法和一个秘钥相结合,以组织对签名完整性的破坏,
      1、var hamc = crypto.createHmac(algorithm,key);创建一个Hmac对象,
        1、algorithm;String,指定需要使用的散列算法,'sha1','md5','sha256','sha512'
        2、key;String,指定一个PEM格式的秘钥,openssl genrsa -out key.pem 1024
      2、hmac.update(data);创建一个摘要,
        1、data;String/Buffer,指定摘要内容,
      3、hmac.digest([encoding]);获取该Hmac对象的摘要内容,默认返回一个Buffer对象,使用该方法后不能再使用update方法追加摘要内容,
      var crypto = require("crypto");
      var fs = require("fs");
      var pem = fs.readFileSync("key.pem");
      var key = pem.toString("ascii");
      var shasum = crypto.createHmac("sha1",key);
      var s = fs.ReadStream("./app.js");
      s.on("data",function(data){
        shasum.update(data);
      })
      s.on("end",function(){
        var data = shasum.digest("hex");
        console.log(data);
      })
    4、公钥加密:
      1、Cipher类;用于加密数据
        1、var cipher = crypto.createCipher(algorithm,password);使用指定的算法和密码创建一个Cipher对象
          1、algorithm;String,指定需要使用的散列算法,'sha1','md5','sha256','sha512'
          2、password;Binary String/Buffer,指定加密时使用的密码,为一个二进制的字符串或者一个Buffer对象
        2、var cipher = crypto.createCipheriv(algorithm,password,iv);使用指定的算法,密码和初始向量创建一个Cipher对象
          1、algorithm;String,指定需要使用的散列算法,'sha1','md5','sha256','sha512'
          2、password;Binary String/Buffer,指定加密时使用的密码,为一个二进制的字符串或者一个Buffer对象
          3、iv;Binary String/Buffer,指定加密时使用的初始向量,为一个二进制的字符串或者一个Buffer对象
        3、cipher.update(data,[input_encoding],[out_encoding]);指定需要被加密的数据,指定第三个参数时返回编码后的字符串,
            不指定返回一个加密后的Buffer对象,
        4、cipher.final([out_encoding]);返回加密数据,不使用参数返回一个Buffer对象,使用该方法后不能再使用update方法进行数据加密
        var crypto = require("crypto");
        var fs = require("fs");
        var pem = fs.readFileSync("key.pem");
        var key = pem.toString("ascii");
        var cipher = crypto.createCipher("blowfish",key);
        var text = "test";
        cipher.update(text,"binary","hex");
        var crypted = cipher.final("hex");
        console.log(crypted);
      2、Decipher类;用于解密数据
        1、var decipher = crypto.createDecipher(algorithm,password);使用指定的算法和密码创建一个Decipher对象
          1、algorithm;String,指定需要使用的散列算法,和加密时使用的算法一致,'sha1','md5','sha256','sha512'
          2、password;Binary String/Buffer,指定解密时使用的密码,和加密时使用的密码一致,为一个二进制的字符串或者一个Buffer对象
        2、var decipher = crypto.createDecipheriv(algorithm,password,iv);使用指定的算法,密码和初始向量创建一个Decipher对象
          1、algorithm;String,指定需要使用的散列算法,和加密时使用的算法一致,'sha1','md5','sha256','sha512'
          2、password;Binary String/Buffer,指定加密时使用的密码,和加密时使用的密码一致,为一个二进制的字符串或者一个Buffer对象
          3、iv;Binary String/Buffer,指定加密时使用的初始向量,和加密时使用的一致,为一个二进制的字符串或者一个Buffer对象
        3、decipher.update(data,[input_encoding],[out_encoding]);指定需要被解密的数据,如果不使用第二个参数则data必须为一个Buffer对象,
            不指定第三个参数时,则返回一个存放了解密数据的Buffer对象
        4、decipher.final([out_encoding]);返回解密之后的原始数据,不使用参数返回一个Buffer对象,使用该方法后该对象不能再被使用
        var crypto = require("crypto");
        var fs = require("fs");
        var pem = fs.readFileSync("key.pem");
        var key = pem.toString("ascii");
        var decipher = crypto.createDecipher("blowfish",key);
        var dec = decipher.update(crypted,"hex","utf8");
        dec += decipher.final("utf8");
        console.log(dec);
      3、Sign类;用于生成签名
        1、var sign = crypto.createSign(algorithm);创建一个Sign对象
          1、algorithm;String,指定在加密该数据使用的算法,'RSH-SHA256'
        2、sign.update(data);制定需要被加密的数据,
        3、sign.sign(private_key,[output_format]);对数据进行签名,使用该方法后不能再使用update方法追加数据,该对象不能再被使用
          1、private_key;String,指定PEM格式的私钥,
          2、output_format;String,指定签名输出时的数据使用的编码格式,默认返回一个Buffer对象
        var crypto = require("crypto");
        var fs = require("fs");
        var pem = fs.readFileSync("key.pem");
        var key = pem.toString("ascii");
        var sign = crypto.createSign("RSH-SHA256");
        sign.update("test");
        console.log(sign.sign(key,"hex"));
      4、Verify类;用于验证签名
        1、var verify = crypto.createVerify(algorithm);使用指定的算法创建一个verify对象,
          1、algorithm;String,指定需要使用的加密算法,'RSH-SHA256'
        2、verify.update(data);制定需要被验证的数据,
        3、verify.verify(object,signature,[signature_format]);对签名进行验证
          1、object;指定验证时使用的对象,
          2、signature;指定被验证的签名,
          3、signature_format;指定生成该签名时使用的编码格式
        var crypto = require("crypto");
        var fs = require("fs");
        var privatepem = fs.readFileSync("key.pem");
        var publicpem = fs.readFileSync("cert.pem");
        var key = privatepem.toString();
        var publickey = pbulicpem.toString();
        var data = "test";
        var sign = crypto.createSign("RSH-SHA256");
        sign.update(data);
        var sig = sign.sign(key,"hex");
        var verify = crypto.createVerify("RSH-SHA256");
        verify.update(data);
        console.log(verify.verify(publickey,sig,"hex"));
      5、为私钥创建一个公钥:openssl req -key key.pem -new -x.509 -out cert.pem
  2、压缩与解压缩:zlib模块
    1、创建对数据进行压缩及解压缩处理的对象的方法;以下方法创建的对象均可用于读取数据流/写入数据流
      1、zlib.createGzip([options]);创建并返回一个Gzip对象,使用Gzip算法对数据进行压缩处理
      2、zlib.createDeflate([options]);创建并返回一个Deflate对象,使用Deflate算法对数据进行压缩处理
      3、zlib.createDeflateRaw([options]);创建并返回一个DeflateRaw对象,使用Deflate算法对数据进行压缩,在压缩数据中不添加zlib头,
      4、zlib.createGunzip([options]);创建并返回一个Gunzip对象,使用Gzip算法对压缩的的数据进行解压缩
      5、zlib.createInflate([options]);创建并返回一个Inflate对象,使用Deflate算法对压缩的数据进行解压缩
      6、zlib.createInflateRaw([options]);创建并返回一个Inflate对象,使用DeflateRaw对象对压缩的数据进行解压缩处理
      7、zlib.createUnzip([options]);创建并返回一个Unzip对象,根据压缩数据的zlib头来判断采用哪种算法进行解压缩处理
        1、options;Object,指定压缩或解压缩数据时的选项,
          1、flush;String,用于设定或读取压缩方法及状态,
            1、zlib.Z_NO_FLUSH;default,该模式运行在数据输出之前,预先决定每次压缩多少数据,以实现最大化压缩
            2、zlib.Z_SYNC_FLUSH;指定将压缩数据分为若干个压缩块,每次将一个压缩块的数据写入输出缓存区,
              在数据块后写入一个10位长度的空白数据块,使用某些压缩算法时,该模式可能会降低数据的压缩程度,
            3、zlib.Z_PARTIAL_FLUSH;指定压缩数据时每次都将输出缓存区所能容纳的数据写入输出缓存区,不限制输出数据的字节数
            4、zlib.Z_FULL_FLUSH;与Z_SYNC_FLUSH相同,但在数据块写完之后复位压缩状态,
              因此当压缩的数据流被管道输出时,解压缩该数据的另一端可以在前次数据被破坏时要求重新压缩
            5、zlib.Z_FINISH,输出缓存区中的剩余数据将全部输出
          2、chunkSize;Number,指定数据分块时每个块的大小,单位字节,default:16*1024;
          3、windowBits;Number,属性值为以2为底求出的压缩窗口的对数,用于设定压缩窗口的大小,值为8 ~ 15之间,
            default:15;属性值越大,压缩效果越好,同时内存消耗越多,当使用Deflate算法压缩数据不使用zlib头时,该值为-15 ~ -8之间
          4、level;Number,指定压缩级别,值为-1或0 ~ 9,
            值为-1时,使用默认压缩比,该值自动在压缩速度和压缩比之间妥协(相当于6);
            值为0时,不执行压缩,
            值为1时,压缩速度最快,压缩程度最低,
            值为9时,压缩速度最慢,压缩程度最高,
          5、memLevel;Number,default:8;指定进行压缩时为压缩程序分配多少内存,值为1 ~ 9,
            值为1时,消耗最少的内存,压缩程度被降低,
            值为9时,消耗最多的内存,压缩效果最好,
          6、strategy;调整压缩算法,
            1、zlib.Z_DEFAULT_STRATEGY;default,用于进行标准压缩
            2、zlib.Z_HUFFMAN_ONLY;指定在压缩数据时使用霍夫曼编码(一种用于无损数据压缩的熵编码)
            3、zlib.Z_FILTERED;用于在数据压缩时对数据进行过滤,
            4、zlib.Z_RLE;指定在压缩时采用游程编码(Run-Length Encoding);行程长度编码
            5、zlib.Z_FIXED;指定在压缩数据时禁止使用霍夫曼编码,
          var zlib = require("zlib");
          var http = require("http");
          var fs = require("fs");
          http.createServer(function(request,response){
            var raw = fs.createReadStream("test.txt");
            var acceptEncoding = request.headers["accept-encoding"];
            if(!acceptEncoding){
              acceptEncoding = "";
            }
            if(acceptEncoding.match(/\bdeflate\b/)){
              response.writeHead(200,{"content-encoding":"deflate"});
              raw.pipe(zlib.createDeflate()).pipe(response);
            }else if(acceptEncoding.match(/\bgzip\b/)){
              response.writeHead(200,{"content-encoding":"gzip"});
              raw.pipe(zlib.createGzip()).pipe(response);
            }else{
              response.writeHead(200,{});
              raw.pipe(response);
            }
          }).listen("8888","localhost");
    2、方法:
      1、zlip.gzip(buf,callback);使用Gzip算法压缩buf字符串或者buf缓存区中的数据
      2、zlip.deflate(buf,callback);使用Deflate算法压缩buf字符串或者buf缓存区中的数据
      3、zlip.deflateRaw(buf,callback);使用Deflate算法压缩buf字符串或者buf缓存区中的数据,在压缩数据中不添加zlib头
      4、zlip.gunzip(buf,callback);使用Gunzip算法解压buf缓存区中的数据
      5、zlip.inflate(buf,callback);使用Inflate算法解压buf缓存区中的数据
      6、zlip.inflateRaw(buf,callback);使用Inflate算法解压buf缓存区中的数据,在压缩数据中不使用zlib头
      7、zlip.unzip(buf,callback);根据压缩数据的zlib头来判断采用哪种算法进行解压缩处理
      var zlib = require("zlib");
      var fs = require("fs");
      var out = fs.createWriteStream("commpress.log");
      var input = "fdjkahklfhdaslhfkdlas";
      zlib.gzip(input,function(err,buffer){
        if(!err){
          zlib.unzip(buffer,function(err,buffer){
            if(!err){
              console.log(buffer.toString());
              out.write(buffer);
            }
          })
        }
      })
3、第十二章:NodeJs其他模块
  1、dns模块解析域名:
    1、dns.reslove(domain,[rrtype],callback);将一个域名解析为一组DNS记录
      1、domain;String,指定需要被解析的域名,www.baidu.com
      2、rrtype;String,指定需要获取的记录类型,
        1、"A";default;将一个IPv4地址映射为一个域名,
        2、"AAAA";将一个IPv6地址映射为一个域名,
        3、"CNAME";记录为一个域名的别名记录,www.baidu.com => baidu.com
        4、"MX";指向一个使用SMTP的域中的邮件服务器,
        5、"TXT";为该域名附加的描述记录,
        6、"SRV";用于为一个特定域中所有可用服务提供信息,
        7、"PTR";用于反向地址解析,将一个域名解析为IPv4地址,
        8、"NS";域名服务器记录,用来指定该域名有哪个DNS服务器来解析,
      3、callback;function(err,addresses){};addresses;Array,存放所有获取到的DNS记录
      var dns = require("dns");
      dns.resolve("www.baidu.com","A",function(err,addresses){
        console.log(addresses);
      });//[ '61.135.169.121', '61.135.169.125' ]
    2、reslove便捷方法:
      1、dns.resolve4(domain,callback);用于获取记录类型为"A"的DNS记录,
      2、dns.resolve6(domain,callback);用于获取记录类型为"AAAA"的DNS记录,
      3、dns.resolveMx(domain,callback);用于获取记录类型为SMTP的邮件交换服务器记录,
      4、dns.resolveTxt(domain,callback);用于获取该域名附加的描述记录
      5、dns.resolveSrv(domain,callback);用于获取特定域中所有可用服务的信息
      6、dns.resolveNs(domain,callback);用于获取域名服务器记录
      7、dns.resolveCname(domain,callback);用于获取别名记录
    3、dns.lookup(domain,[family],callback);查询IP地址
      1、domain;String,指定需要被解析的域名,www.baidu.com
      2、family;Number,default:null,4代表获取IPv4,6代表获取IPv6
      3、callback;function(err,addresses,family){};family标识获取到的IP地址类型
    4、dns.reverse(ip,callback);将一个ip地址反向解析为一组与该ip地址绑定的域名
      1、callback;function(err,domains){};domains;Array,获取到的域名,
    5、dns模块解析错误代码:
      1、ENODATA;dns服务器返回一个没有数据的查询结果
      2、EFORMERR;dns服务器发现客户端请求查询时使用了格式错误的查询参数
      3、ESERVFAIL;dns服务器执行查询操作失败
      4、ENOTFOUND;未发现任何域名
      5、ENOTIMP;dns服务器不能进行客户端所请求的查询操作
      6、EREFUSED;dns服务器拒绝查询操作
      7、EBADQUERY;格式错误的dns查询
      8、EBADNAME;域名格式错误
      9、EBADFAMILY;不支持的IP地址类型
      10、EBADRESP;dns答复的格式错误
      11、ECONNREFUSED;不能建立与dns服务器之间的连接
      12、ETIMEOUT;与dns服务器之间建立连接超时
      13、EEOF;已到达文件底部
      14、EFILE;读取文件失败
      15、ENOMEM;没有足够的内存空间
      16、EDESTRUCTION;通道已被销毁
      17、EBADSTR;字符串格式错误
      18、EBADFLAGS;指定了错误的判断标志
      19、ENONAME;指定的主机名不是数值格式的
      20、EBADHINTS;指定的提示标志无效
      21、ENOTINITIALIZED;c-ares类库初始化工作尚未完成
      22、ELOADIPHLPAPI;加载iphlpapi.dll时触发了一个错误
      23、EADDRGETNETWORKPARAMS;未发现GetNetworkParams函数
      24、ECANCELLED;dns查询操作被取消
  2、punycode模块编码转换
    1、punycode.encode(string);将一个Unicode编码转换成一个punycode编码
      punycode.encode("呵呵");//'dtra'
    2、punycode.decode(string);将一个punycode编码转换成一个unicode编码
      punycode.decode("dtra");//"呵呵"
    3、punycode.toASCII(domain);将一个Unicode编码格式的域名转换成一个punycode编码格式的域名,只转换地方语言域名,
      punycode.toASCII("www.呵呵.wen.com");//www.xn--dtra.wen.com
    4、punycode.toUnicode(domain);将一个punycode编码格式的域名转换为一个unicode编码格式的域名,只转换地方语言域名,
      punycode.toUnicode("www.xn--dtra.wen.com");//www.呵呵.wen.com
    5、punycode.ucs2.encode(codePoints);将一个UCS-2编码的数组转换为一个字符串
      punycode.ucs2.encode([97,98,92,99]);//"ab\\c"
    6、punycode.ucs2.decode(string);将一个字符串转换为一个UCS-2编码的数组
      punycode.ucs2.decode("ab\\c");//[97,98,92,99]
    9、punycode.version;查询Punycode.js类库的版本号;
  3、os模块获取操作系统信息:
    1、os.tmpdir();String,获取操作系统中默认的用于存放临时文件的目录;
    2、os.endianness();String,获取CPU的字节序,返回值:BE/LE
    3、os.hostname();String,获取计算机名
    4、os.type();String,获取操作系统类型,'windows_NT'
    5、os.platform();String,获取操作系统平台,"win32"
    6、os.arch();String,获取CPU架构,"x64"
    7、os.release();String,获取系统的版本号,"6.1.7601"
    8、os.uptime();Number,获取系统当前的运行时间,单位为秒,"21161.5599339"
    9、os.loadavg();Array,获取1分钟、5分钟、15分钟系统的平均负载,[0,0,0]
    10、os.totalmem();Number,获取系统的总内存量,
    11、os.freemem();Number,获取系统的空闲内存量,
    12、os.cpus();Array,获取cpu内核的各种信息,[]
    13、os.networkInterfaces();Array,获取系统中所有的网络接口,[]
    14、os.EOL;String,常量值为操作系统中使用的换行符,"\r\n"
  4、readline模块逐行读取流数据
    1、方法:通过Interface对象的使用实现逐行读取流数据的处理
      1、var intface = readline.createInterface(options);
        1、input;值为一个可用来读取流数据的对象,用于指定读入数据的来源
        2、output;值为一个可用来写入流数据的对象,用于指定数据的输出目标
        3、completer;Function,用于指定Tab补全处理
        4、terminal;Boolean,如果需要实时的将输入数据流进行输出,且需要在输出数据中写入ANST/VT100控制字符时,设置该值为true
        var fs = require("fs");
        var intface = require("readline").createInterface({
          input: fs.createReadStream("./message.txt"),
          output: fs.createWriteStream("./othersMessage.txt"),
          terminal: true
        });
        intface.on("line",function(line){})
      2、intface.close();当使用Interface对象从终端读取行数据时,必须使用该方法结束数据的读取操作
      3、intface.pause();暂停该对象读取流数据,
      4、intface.resume();当暂停该对象读取流数据时,可使用该方法恢复去取流数据
      5、intface.write(data,[key]);向output属性值对象写入一些数据,
        1、data;String/Buffer,为一个字符串或者Buffer对象,指定需要写入的数据
        2、key;Object,用于在终端环境中模拟一个按键操作,{ctrl:true,name:"u"}
      6、intface.setprompt(prompt,[length]);在终端环境下定制一个命令提示符,
        1、prompt;String,指定命令提示符
        2、length;Number,指定用户输入字符的起始位置,单位为字符
      7、intface.prompt();在一个新的行中指定命令提示符
        var readline = require("readline");
        var intface = readline.createInterface({
          input: process.stdin,
          output: process.stdout
        });
        intface.setPrompt("请输入:",7);
        intface.prompt();
        intface.on("line",function(line){
          if(line == "exit" || line == "quit" || line == "q"){
            intface.close();
          }else{
            console.log("已输入:"+line);
            intface.prompt();
          }
        });
        intface.on("close",function(){
          console.log("\r\n行数据读取操作被终止...");
        })
      8、intface.question(query,callback);在终端环境中显示一个问题,
        1、query;String,指定需要提问的问题,
        2、callback;function(answer){};处理用户的回答,
        intface.question("元芳,你怎么看?",function(answer){
          console.log("元芳的回答:"+answer);
          intface.close();
        })
    2、事件:
      1、line;当该对象读取到一个"\n"字符时,表示该行数据读取结束时触发,function(line){}
      var readline = require("readline");
      var intface = readline.createInterface({
        input:process.stdin,
        output:process.stdout
      });
      intface.on("line",function(line){
        if(line == "exit" || line == "quit" || line == "q"){
          intface.close();
        }else{
          console.log("已输入:"+line);
        }
      })
      2、close;
        当调用close方法时,该对象接收到一个EOL信号时,
        该对象接收到一个SIGINT信号时,该对象的input属性值对象的end事件触发时触发,function(){}
      3、pasue;当该对象暂停读取流数据时触发,
      4、resume,当该对象恢复读取流数据时触发,
      5、SIGINT;当该对象接收到input属性值对象的信号时触发,
        intface.on("SIGINT",function(){
          intface.question("Are you want to exit?",function(answer){
            answer.match(/^y(es)?$/i)) ? intface.close() : intface.pause();
          })
        })
  5、使用util模块提供的方法:
    1、util.format(format,[....]);将第一个参数作为格式化字符串,将其他参数作为格式化该字符串时的选项,
      util.format("呵呵%d哈哈%s哼哼%j",10,"hehe",{hello:"world"});
    2、util.debug(string);同步方法,阻塞当前线程,将参数作为标准错误输出流输出,
    3、util.error([...]);作用和debug方法的作用类似
    4、util.puts([...]);同步方法,阻塞当前线程,将参数作为标准输出流输出,会产生一个新行
    5、util.print([...]);同步方法,阻塞当前线程,将参数作为标准输出流输出,不会产生一个新行
    6、util.log(string);将一个字符串作为标准输出流输出,字符串前输出当前系统时间,
    7、util.inspect(object,[options]);返回一个字符串包含了该对象的信息,
      1、options;Object,
        1、showHidden;Boolean;default:false;为true时该对象信息包含该对象的不可枚举属性接属性值,
        2、depth;Number,default:2;指定被查看的对象信息的深度,
        3、colors;Boolean;default:false;为true时输出该对象信息时将该对象的各种属性值应用颜色
        4、customInspect;Boolean;default:true;为true时查看对象信息时将调用对于被查看信息的对象自定义的inspect方法
    8、util.inspect.styles对象定义对象属性值的样式
      1、number;default:yellow;定义数值类型属性值的颜色,
      2、boolean;default:yellow,定义布尔类型属性值的颜色,
      3、string;default:green;定义字符串类型属性值的颜色,
      4、date;default:magenta;定义日期类型属性值的颜色,
      5、regexp;default:red;定义正则表达式的颜色,
      6、null;default:bold;定义null值的字体,
      7、undefined;default:grey;定义undefined值的颜色,
      8、special;default:cyan;定义函数的颜色,
    9、util.inspect.colors对象:定义对象属性值的样式
      1、bold,italic,underline,white,grey,black,green,red,yellow
      2、cyan:青色,magenta,紫红色,
    10、util.isArray(object);Boolean,判断该参数是否为一个数组,
    11、util.isRegExp(object);Boolean,判断该参数是否为一个正则表达式
    12、util.isDate(object);Boolean,判断一个参数值是否为一个日期类型,
    13、util.isError(object);Boolean,判断一个参数值是否为一个错误对象,
    14、util.inherits(constructor,superConstructor);
      1、constructor;子类构造函数,
      2、superConstructor;父类构造函数,
  6、使用vm模块改变脚本运行环境:
    1、vm.runInThisContext(code,[filename]);作用和eval函数类似,在该上下文中不能访问任何模块中定义的本地变量,方法,对象,
      1、code;String,指定需要运行的代码,
      2、filename;记录代码运行时的堆栈信息,可以为空,
    2、vm.runInNewContext(code,[sandbox],[filename]);作用和1、类似,但是不能访问NodeJs中定义的全局变量、属性、方法
      1、code;String,指定需要运行的代码,
      2、sandbox;Object,指定独立的上下文环境,
      3、filename;记录代码运行时的堆栈信息,可以为空,
    3、vm.createContext([initSandbox]);根据初始化的上下文对象创建另一个上下文对象,
    4、vm.runInContext(code,[sandbox],[filename]);在该上下文环境中运行js代码,
      var vm = require("vm");
      var obj = {name:"Hello World"};
      var context1 = vm.createContext(obj);
      vm.runInContext("name = 'HeHe'",context1);
      console.log(context1.name);
      var context2 = vm.createContext(obj);
      vm.runInContext("name = 'HeiHei'",context2);
      console.log(context2.name);
    5、var script = vm.createScript(code,[filename]);创建一个script对象并保存一段编译后的js代码,
      1、code;String,指定需要编译的代码,
      2、filename;记录代码运行时的堆栈信息,可以为空
    5.1 script.runInThisContext();作用和vm.runInThisContext方法类似
      var vm = require("vm");
      var script = vm.createScript("globalVar += 1");
      for(var i=1;i<100;i++){
        script.runInThisContext();
        console.log(globalVar);
      }
    5.2 script.runInNewContext([sandbox]);作用和vm.runInNewContext方法类似
  7、自定义repl运行环境:
    1、repl.start(options);运行并返回一个repl的实例对象,
      1、options;Object,
        1、prompt;default:">";修改repl运行环境的命令提示符,
        2、input;default:"process.stin",指定需要用来读取流数据的对象,
        3、output;default:"process.stdout",指定需要用来写入输出流数据的对象,
        4、terminal;Boolean,为true时如果需要实时的将输入数据流进行输出,且需要在输出数据中写入ANST/VT100控制字符时,
        5、write;Function,指定在输出表达式运行结果时用于格式化运行结果以及对运行结果应用各种颜色的函数
        6、useColors;Boolean,指定在使用默认的writer属性时,输出表达式的结果是否使用颜色,
          如果默认的writer属性值被修改,则该属性值失效,
        7、useGlobal;Boolean,default:false;为true时当前上下文中的代码可以访问NodeJs中的全局变量、方法、对象
        8、eval;Function,指定对输入表达式的执行方法,
        9、ignoreUndefined;default:false;如果表达式的执行结果为undefined,则REPL环境不再显示该结果,
        var repl = require("repl");
        repl.start({useGlobal:false,ignoreUndefined:true});