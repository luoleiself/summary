一、安装：偶数位为稳定版
二、启动Web服务器：启动服务器代码官网上有
  1、新建一个目录：
      node server.js (显示服务器网址和端口号）
  2、浏览器输入指定网址：
      nodejs和浏览器执行js的不同：浏览器内置对象window,nodejs内置对象proccess
  3、全局对象:
    1、global:表示Node所在的全局环境，类似于浏览器中的window对象
    2、process:指向Node内置的process模块，允许开发者与当前进程互动
      1、process.stdin(standard input)是标准输入流
      2、process.stderr是标准错误流
      3、process.cwd():表示当前文件的绝对路径
      4、process.on():事件代理机制
    3、console:指向Node内置的console模块，提供命令行环境中的标准输入、标准输出功能
  4、全局函数:
    1、定时器函数:setTimeout(),setInterval(),clearTimeout(),clearInterval()
    2、require:用于加载模块
      1、require():方法,加载指定模块文件
      2、require.resolve():方法,返回查询的模块文件的带有完整路径文件的文件名,查询时不会加载该模块
      3、require.cache:对象,查看当前缓冲区的内容.
  5、全局变量:
    1、_filename:获取当前文件的带有完整绝对路径的文件名
    2、_dirname:获取当前模块文件所在的带有完整绝对路径的目录
  6、准全局变量:模块内部的局部变量，指向的对象根据模块不同而不同，但是所有模块都适用，可以看作是伪全局变量
    1、module:变量指代当前模块
    2、module.exports:变量表示当前模块对外输出的接口，其他文件加载该模块，实际上就是读取module.exports变量
    3、module.id:模块的识别符，通常是模块的文件名
    4、module.filename:模块的文件名
    5、module.loaded:返回一个布尔值，表示模块是否已经完成加载
    6、module.parent:返回使用该模块的模块
    7、module.children:返回一个数组,表示该模块要用到的其他模块
  7、事件环机制:
    1、EventEmitter类:事件对象基类
      1、addListener(event,listener);//对指定事件绑定处理函数
      2、on(event,listener);//对指定事件绑定处理函数
      3、once(event,listener);//对指定事件只绑定一次处理函数
      4、removeListener(event,listener);//对指定事件移出处理函数
      5、removeAllListeners([event]);//对指定事件移出所有处理函数
      6、setMaxListeners(n);//指定事件处理函数的最大数量
      7、listeners(event);//获取指定事件的处理函数
      8、emit(event,[arg1],[agr2],[...]);//手动触发指定事件
      9、EventEmitter.listenerCount(emitter,event);//获取指定事件的事件处理函数的数量
        1、第一个参数指定需要获取哪个对象的事件处理函数的数量
        2、第二个参数指定需要获取哪个事件的事件处理函数的数量
      10、自身事件:
        1、EventEmitter.newListener
        2、EventEmitter.removeListener
  9、调试:
    1、node debug<需要执行的模块文件>
      1、c/continue:输出结果
      2、n/next:指向下一段代码
      3、s/step:进入函数内部
      4、o/out:立刻执行完函数内部代码并指向函数后第一句代码
      5、观察模式
        1、watch('指定表达式');//观察模式
        2、unwatch("指定表达式");//接触观察
      6、设置或者取消断点:
        1、setBreakPoint/sb(filename,line);//设置断点
        2、clearBreakPoint(filename,line);//取消断点
      7、backtrace/bt:调试深层函数内部后,可以查看该函数及外层各函数的返回位置,包括起始位置和行号
      8、list(n):用于查看当前行号前后各n行代码
      9、repl:退出调试模式
      10、restart:重新开始脚本测试
      11、kill:终止脚本测试
      12、run:重新开始脚本测试
      13、scripts:查看当前正在运行的文件及所有被加载的模块的文件名称(不包含nodjs内置的模块)
      14、version:显示当前nodejs所用的v8的引擎的版本号
    2、node-inspector:
  10、第六章:操作文件系统
    1、同步:fs.readFileSync();
        同步方法立即返回操作结果,在使用同步方法执行的操作结束之前,不能执行后续代码.
        var fs = require("fs");
        var data = fs.readFileSync('./test.txt',{flag:'r',encoding:'utf8'});
    2、异步:fs.readFile();
        异步方法将操作结果作为回调函数的参数返回,在方法调用之后,可立即执行后续代码
        var fs = require("fs");
        fs.readFile('./test.txt',{flag:'r',encoding:'utf8'},function(err,data){
          if(err){
            congole.lo('读取文件失败');
          }else{
            console.log(data);
          }
        })
    3、对文件读写操作方法:
      1、方法一:读取文件内容
        fs.readFile(filename,[options],callback);  // 以异步方式读取文件
        fs.readFileSync(filename,[options]);  // 以同步方式读取文件
        fs.ReadStream(filename);
        eg:fs.readFile("./test.txt",{flag:'r',encoding:'utf8'},function(err,data){
          console.log(data);
        })
          option值为对象;
          1、flag:对文件的操作权限
            r:默认值,读取文件,如果文件不存在则抛出异常
            r+:读取并写入文件,如果文件不存在则抛出异常
            rs:以同步方式读取文件并通知操作系统忽略本地文件系统缓存,不建议使用
            w:写入文件,如果文件不存在则创建文件,如果文件已存在则清空该文件内容
            wx:作用和w类似,使用排他方式写入文件
            w+:读取并写入文件,如果文件不存在则创建文件,如果文件已存在则清空该文件内容
            wx+:作用和w+类似,使用排他方式打开文件
            a:追加写入文件,如果该文件不存在则创建该文件
            ax:作用和a类似,使用排他方式写入文件
            a+:读取并追加写入文件,如果该文件不存在则创建该文件
            ax+:作用和a+类似,使用排他方式打开文件
          2、encoding:指定编码格式来读取该文件,
            读取文件时,不指定编码格式,该回调函数的第二个参数存储的实际是原始二进制内容的缓存区对象utf8,ascii,base64     
      2、方法二:向文件写入内容
        fs.writeFile(filename,data,[options],callback);  // 以异步方式写入文件
        fs.writeFileSync(filename,data,[options]);   // 以同步方式写入文件
        fs.WriteStream(filename);
        eg:fs.writeFile("./test.txt",data,{flag:'w',mode:'0666',encoding:'utf8',},function(err){
          if(err){
            console.log('写入文件失败');
          }
        })
          1、filename:指定需要被写入文件的完整路径及文件名
          2、data:指定需要写入的内容
          3、options:
            1、flag:默认值为w,使用方法和readFile的options的参数一致
            2、mode:指定当文件打开时对文件的读写权限,默认值为0666(可读写)
              第一个数字必须为0,
              第二个数字规定文件或者目录所有者的权限,
              第三个数字规定文件或者目录所有者所属用户组的权限
              第四个数字规定其他人的权限
              1:执行权限
              2:写权限
              4:读权限
              如果需要设置读写复合权限,可以对以上三个数字进行加运算:2+4=6;
      3、方法三:向文件尾部追加内容
        fs.appendFile(filename,data,[options],callback); // 以异步方式向文件末尾追加内容
        fs.appendFileSync(filename,data,[options]);  // 以同步方式向文件末尾追加内容
        eg:fs.appendFile("./test.txt",data,{flag:'a',mode:'0666',encoding:'utf8'},function(err){
          if(err){
            console.log('追加内容失败');
          }
        })
          1、options:
            1、flag:默认值为a
      4、方法四:打开文件
        fs.open(filename,flags,[mode],callback);  // 以异步方式打开文件
        fs.openSync(filename,flags,[mode]);  // 以同步方式打开文件
        eg:fs.open("./test.txt","r",function(err,fd){
          console.log(fd); // 打开文件时返回的文件描述符,文件句柄
        })
          1、filename|flags|mode:使用和readFile中的参数使用方式一致
          2、回调函数的第二个参数代表打开文件时返回的文件描述符
      5、方法五:读取文件指定内容
        fs.read(fd,buffer,offset,length,position,callback); // 以异步方式读取文件内容
        fs.readSync(fd,buffer,offset,length,position); // 以同步方式读取文件内容
          1、fd:必须是open/openSync方法中的回调函数中返回的文件描述符
          2、buffer:是一个Buffer对象,指定将文件数据读取到指定的缓存区对象中
          3、offset:指定向缓存区写入数据时开始写入的位置(以字节为单位)
          4、legnth:指定从文件读取的字节数
          5、position:指定读取文件时的开始位置(以字节为单位),如果值为null,则从当前文件被读取处开始读取
          6、callback(err):读取文件操作失败时返回的错误对象
          7、callback(bytesRead):实际读取的字节数
          8、callback(buffer):被读取的缓存区对象
        eg:var fs = require("fs");
          fs.open("./test.txt","r",function(err,fd){
            fs.read(fd,new Buffer(255),0,6,12,function(err,bytesRead,buffer){
              // 0:开始向缓冲区写入数据时的位置
              // 6:从文件中读取的字节数
              // 12:读取文件时开始位置
              console.log(buffer.slice(0,bytesRead).toString());
            })
          })
      6、方法六:向文件内写入指定内容
        fs.write(fd,buffer,offset,length,position,callback); // 以异步方式写入内容
        fs.writeSync(fd,buffer,offset,length,position);  // 以同步方式写入内容
          1、fd:必须是open/openSync方法中的回调函数中返回的文件描述符
          2、buffer:指定从哪个缓存区中读取数据
          3、offset:指定从缓存区中读取数据时的开始位置(以字节为单位)
          4、length:指定从缓存区中读取的字节数
          5、position:指定写入文件时的开始位置(以字节为单位),如果为null,则从文件的当前被写入处开始写入,以追加模式打开文件并指定文件的写入位置无效
          6、callback(err):写入文件操作失败时返回的错误对象
          7、callback(written):被写入的字节数
          8、callback(buffer):被读取的缓存区对象
          eg:var fs = require('fs');
             var buf = new Buffer('嘻嘻呵呵哈哈');
            fs.open("./message.txt","w",function(err,fd){
              fs.write(fd,buf,0,6,12,function(err,written,buffer){
                // 0:从缓冲区读取数据的开始位置
                // 6:从缓冲区读取的字节数
                // 12:写入文件时的开始位置
                console.log(written);
                console.log(buffer);
              })
            })
      7、方法七:关闭文件
        fs.close(fd,[callback])
        fs.closeSync(fd);
          1、fd:open方法打开文件时返回的文件操作符
        eg:fs.close(fd,function(err){
          if(err){
            console.log('关闭文件操作失败');
          }
        })
      8、方法八:对文件进行同步操作,将缓存区的剩下的所有数据全部写入到文件中
        fs.fsync(fd,[callback]);
        fs.fsyncSync(fd);
          1、fd:open方法打开文件时返回的文件操作符
        eg:fs.fsync(fd,function(err){})
          fs.close(fd);
    4、创建和读写目录方法:
      1、创建目录:
        fs.mkdir(path,[mode],callback);
        fs.mkdirSync(path,[mode]);
          1、path:指定需要被创建的目录的完整路径及文件名
          2、mode:指定该目录的权限,默认为0777
        eg:fs.mkdir('./testPath','0755',function(err){
          if(err){
            console.log('创建目录操作失败');
          }
        })
          
      2、读取目录方法:
        fs.readdir(path,callback);
        fs.readdirSync(path);
          1、path:指定需要被读取的目录的完整路径及目录名
          2、callback(err):读取目录失败返回的错误对象
          3、callback(files):返回读取到的文件中的所有文件名
        eg:fs.readdir('C:/Users/Administrator/Desktop/node/global', function(err, files) {
            console.log(files);
            // ['app.js','view','testPath','package.json']
        })
    5、查看、修改文件/目录信息
      1、查看文件或目录的信息
        fs.stat(path,callback); // 异步方式查看文件、目录的信息
        fs.statSync(path);  // 同步方式查看文件、目录的信息
        fs.lstat(path,callback); // 异步方式查看文件、目录、符号链接文件的信息
        fs.lstatSync(path);  // 同步方式查看文件、目录、符号链接文件的信息
        eg:fs.lstat(path,function(err,stats){
          console.dir(stats);
          // {dev:'',ino:'',mode:'',uid:'',nlink:'',gid:'',atime:'',mtime:'',ctime:''}
        })
          1、唯一区别:查看符号链接文件的信息时,必须使用lstat方法
          2、stats:是一个fs.Stats对象
            1、stats.isFile():判断被查看的对象是否是一个文件,boolean
            2、stats.isDirectory():判断被查看的对象是否是一个目录,boolean
            3、stats.isBlockDevice():判断被查看的文件是否是一个块设备文件,boolean,仅在unix操作系统有效
            4、stats.isCharacterDevice():判断被查看的文件是否是一个字符设备文件,boolean,仅在unix操作系统有效
            5、stats.isSymbolicLink():判断被查看的文件是否是一个符号链接文件,boolean,仅在lstat的回调函数中有效
            6、stats.isFIFO():判断被查看的文件是否是一个FIFO文件,boolean,仅在unix操作系统有效
            7、stats.isSocket():判断被查看的文件是否是一个socket文件,boolean,仅在unix操作系统有效
            8、stats.dev:该属性为文件或者目录所在设备ID,仅在unix操作系统有效
            9、stats.ino:该属性为文件或目录的索引编码,仅在unix操作系统有效
            10、stats.mode:该属性为使用数值形式表示的文件或目录的权限标志
            11、stats.nlink:该属性为文件或目录的硬连接数量
            12、stats.uid:该属性为文件或目录所有者的用户ID,仅在unix操作系统有效
            13、stats.gid:该属性为文件或目录所有者的组ID,仅在unix操作系统有效
            14、stats.rdev:该属性为字符设备文件或块设备文件所在设备ID,仅在unix操作系统有效
            15、stats.size:该属性为文件尺寸(文件的字节数)
            16、stats.atime:该属性为文件的访问时间
            17、stats.mtime:该属性为文件的修改时间
            18、stats.ctime:该属性为文件的创建时间
        1.1、使用open、openSync方法打开文件的查看文件信息方法
          fs.fstat(fd,callback);
          fs.fstatSync(fd);
          eg:fs.open("./test.txt","r",function(err,fd){
            fs.fstat(fd,function(err,stats){
              console.log(stats);
            });
          })
            1、fd:必须是打开文件返回的文件描述符
      2、检查文件或者目录是否存在
        fs.exists(path,callback);
        fs.existsSync(path);
        eg:fs.exists(path,function(exists){})
      3、获取文件的绝对路径
        fs.realpath(path,[cache],callback);
        fs.realpathSync(ptah,[cache]);
        eg:fs.realpath(path,{"/etc":"/private/etc"},function(err,resolvePath){})
          1、cahce:对象,存放一些预定义的路径
          2、resolvePath:获取文件或目录的绝对路径
      4、修改文件访问时间及修改时间
        fs.utimes(path,atime,mtime,callback);
        fs.utimesSync(path,atime,mtime);
        eg:fs.utimes(path,atime,mtime,function(err){})
          1、atime:修改后的访问时间
          2、mtime:修改后的修改时间
        4.1、使用open、openSync方法打开文件的修改文件访问及修改时间
          fs.futimes(fd,atime,mtime,callback);
          fs.futimesSync(fd,atime,mtime);
          e.g:fs.futimes(fd,atime,mtime,function(err){}) 
      5、修改文件或目录的读取权限
        fs.chmod(path,mode,callback);
        fs.chmodSync(path,mode);
        eg:fs.chmod(path,mode,function(err){});
        5.1、使用open、openSync方法打开文件的修改权限
          fs.fchmod(fd,mode,callback);
          fs.fchmodSync(fd,mode);
          e.g:fs.fchmod(fd,mode,function(err){})
    6、对文件或目录执行的其他操作
      1、移动文件或目录:
        fs.rename(oldepath,newpath,function(err){});
        fs.renameSync(oldpath,newpath);  
      2、创建或删除文件的硬连接:操作系统中的文件的一个或多个文件名,
          类似于文件副本,操作任意一个文件,其他文件都会修改
        fs.link(srcpath,dstpath,function(err){})
        fs.linkSync(srcpath,dstpath);
          1、srcpath:指定需要被创建硬连接的文件的完整路径及文件名
          2、dstpath:指定被创建硬链接的完整路径及文件名(程序运行前不存在),该连接文件与源文件必须位于同一卷中,
        fs.unlink(path,function(err){});删除硬链接同时会删除该文件
        fs.unlinkSync(path);
      3、创建和查看符号链接:符号链接是一种特殊的文件,这个文件中仅包含了另一个文件或目录的路径及文件名或目录名
        fs.symlink(srcpath,dstpath,[type],function(err){})
        fs.symlinkSync(srcpath,dstpath,[type])
        1、type:指定为文件创建符号链接还是为目录创建符号链接,默认值:file,[dir,junction]
        2、读取符号链接包含的另一个文件或目录的信息
          fs.readlink(path,function(err,linkString){}) 
      4、截断文件:
        fs.truncate(filename,len,function(){})
        fs.truncateSync(filename,len)
          1、len:指定被截断后的文件的尺寸(以字节为单位)
        4.1、使用open、openSync方法打开文件的截断文件
          fs.ftruncate(fd,len,function(err){})
          fs.ftruncateSync(fd,len)
      5、删除空目录:
        fs.rmdir(path,function(err){})
        fs.rmdirSync(path)
      6、监视文件或目录
        fs.watchFile(filename,[options],listener)
        fs.unwatchFile(filename,[listener])
          1、options:
            1、persistent:指定当指定了被监视的文件发生变化后是否停止当前正在运行的应用程序,默认值为true
            2、interval:指定每隔多少毫秒监视一次文件是否发生改变以及发生了什么改变
          2、listener:当监视文件发生变化后的回调函数
            function(curr,prev){}
            1、curr:为一个fs.Stats对象,代表修改之后的当前文件
            2、prev:为一个fs.stats对象,代表修改之前的当前文件
        var watcher = fs.watch(filename,[options],[listener]);
          1、对文件或者目录进行监视
          2、watcher.close();
    7、使用文件流:
      1、流是一组有序的、有起点的和终点的字节数据的传输手段
      2、概念:read/readSync、write/writeSync:在文件读写的过程中不允许Nodejs执行其他任何处理
        1、将需要读写的数据写到一个内存缓冲区
        2、待缓冲区写满后再将缓冲区中的内容写入到文件中，
        3、重复执行以上步骤
      3、读取数据的对象
          1、fs.ReadStream、http.IncomingMessage、net.Socket、
              child.stdout、child.stderr、process.stdin
          2、Gzip、Deflate、DeflateRaw;用于实现数据压缩,
        3.1、读取数据的对象触发事件
            readable、data、end、error、close
        3.2、读取数据的对象的方法
            read、setEncoding、pause、resume、pipe、unpipe、unshift
      4、写入数据的对象
          1、fs.WriteStream、http.ClientRequest、http.ServerResponse、net.Socket、
              child.stdin、process.stdout、process.stderr、
          2、Gunzip、Inflate、InflateRaw
        4.1、写入数据的对象的事件
            drain、finish、pipe、unpipe、error
        4.2、写入数据的对象的方法
            write、end
      5、使用ReadStream对象读取文件
        fs.createReadStream(path,[options]);创建一个将文件内容读取为流数据的ReadSteam对象
          1、options:
            flags:默认值为r
            encoding:utf8/ascii/base64,默认值为null
            autoClose:指定是否关闭在读取文件时操作系统内部使用的文件描述符,默认值为true
            start:使用整数值指定文件的开始读取位置(以字节为单位)
            end:使用整数值指定文件的结束读取位置(以字节为单位)
          var file = fs.createReadStream(path,{encoding:"utf8",start:6,end:15});
      6、使用WriteStream对象写入文件
        fs.createWriteStream(path,[options]);创建一个将流数据写入到文件的WriteStream对象
          1、options:
            flags:默认值为w
            encoding:utf8/ascii/base64,默认值为null
            start:指定文件的开始写入位置(以字节为单位)
          var wf = fs.createWriteStream(path,{encoding:"utf8",start:0});
          wf.write(chunk,[encoding],[callback]);
            1、chunk:Buffer对象或字符串,指定需要写入的数据
          wf.end([chunk],[encoding],[callback]);
            1、当没有数据被写入到流中时可调用该方法关闭文件，同时迫使操作系统将所有缓存区的数据立刻写入文件中
      7、对路径的操作
        1、normalize();将非标准路径字符串转换成标准路径字符串//path.normalize(p);
        2、join();将多个参数值字符串结合为一个路径字符串//path.join([path1],[path2],[...]);path.join(_dirname,"/ab/c/d");
        3、resolve();以应用程序根目录为起点,根据所有的参数值字符串解析出一个绝对路径//path.resolve(path,[path1],[path2])
        4、relative(from,to);获取两个路径之间的相对关系//path.relative("./././","././././")
        5、dirname(path);获取一个路径中的目录名//path.dirname("d:/nodejs/test/test.txt");d:/nodejs/test/
        6、basename(path,[ext]);获取一个路径中的文件名,ext去除返回的文件名的扩展名//path.basename("d:/nodejs/test/test.txt");test.txt
        7、extname(path);获取一个路径中的扩展名,如果没有指定则返回空字符串//path.extname("d:/nodejs/test/test.txt");".txt"
        8、path.sep:属性值为操作系统指定的文件分隔符
        9、path.delimiter:属性值为操作系统指定的路径分隔符
  12、NodeJs追加的类、函数和对象:
    1、Buffer类:为二进制数据的存储提供一个缓冲区
      1、var buf = new Buffer(size);//指定缓冲区的大小(以字节为单位)
      2、var buf = new Buffer([value,[offset],[end]]);//使用数组初始化缓冲区
      3、var buf = new Buffer(string,[encoding]);//使用字符串初始化缓冲区,默认为 `utf8`
      4、方法:
        1、buf.fill(value,[offset],[end]); //初始化缓冲区中的所有内容
      5、字符串长度和缓存区的长度不一样;
        1、buf.slice(start,end);//字符串截取,缓存区截取后,缓存区将会改变
      6、Buffer与String的转换
        1、buf.toString([encoding],[start],[end]);
        2、buf.write(str,[offset],[length],[encoding]); // 替换原缓冲区中的字节数据
        3、//使用NodeJs模块:stringDecoder对象
      7、Buffer与Number的转换
        1、buf.readUInt8()/buf.writeUInt8();
      8、Buffer与Json的转换
        1、JSON.stringify(buf); // 结果为一个json字符串数组
        2、JSON.parse(jsonBuf); // 将json字符串数组转换为数组
      9、复制缓存数据
        1、buf.copy(targetBuffer,[targetStart],[sourceStart],[sourceEnd]);
      10、类方法:
        1、Buffer.isBuffer(obj);//判断一个对象是不是Buffer对象
        2、Buffer.byteLength(string,[encoding]);//计算一个指定字符串的字节数
        3、Buffer.concat(list,[totallength]);//将几个Buffer对象结合创建一个新的Buffer对象
        4、Buffer.isEncoding(str);//检测一个字符串是否为一个有效编码格式的字符串
    2、setTimeout(),setInterval(),clearInterval(),clearTimeout(),
        timer.unref(),timer.ref()//取消/恢复定时器中的回调函数的触发
    3、require函数:用于加载模块
      1、require():方法,加载指定模块文件
      2、require.resolve():方法,返回查询的模块文件的带有完整路径文件的文件名,查询时不会加载该模块
      3、require.cache:对象,查看当前缓冲区的内容.
    4、module对象:访问模块信息
    5、process对象:访问进程信息

