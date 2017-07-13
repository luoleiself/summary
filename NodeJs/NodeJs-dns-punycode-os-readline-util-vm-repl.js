1、第十二章:NodeJs其他模块
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

        