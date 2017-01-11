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
