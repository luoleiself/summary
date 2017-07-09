  一、第六章:操作文件系统
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
          fs.fstat(fd,callback); // 以异步方式查看文件的信息
          fs.fstatSync(fd);  // 以同步方式查看文件的信息
          eg:fs.open("./test.txt","r",function(err,fd){
            fs.fstat(fd,function(err,stats){
              console.log(stats);
              // {dev:'',ino:'',mode:'',uid:'',gid:'',atime:'',mtime:'',ctime:''}
            });
          })
            1、fd:必须是打开文件时返回的文件描述符
            2、stats:和stat、lstat方法中的回调函数参数使用方式相同
      2、检查文件或者目录是否存在
        fs.exists(path,callback); // 以异步方式检查文件或者目录是否存在
        fs.existsSync(path);  // 以同步方式检查文件或者目录是否存在
        eg:fs.exists(path,function(exists){
          console.log(exists); // boolean
        })
            1、path:指定需要被检查的文件或者目录的完整路径的文件名或者目录名
            2、exists:返回一个布尔值代表当前文件、目录是否存在
      3、获取文件或者目录的绝对路径
        fs.realpath(path,[cache],callback); // 以异步方式获取文件或目录的绝对路径
        fs.realpathSync(ptah,[cache]);  // 以同步方式获取文件或目录的绝对路径
        eg:fs.realpath(path,{"/etc":"/private/etc"},function(err,resolvePath){
          console.log(resolvePath); // String,返回文件或者目录的绝对路径
        })
          1、path:指定需要获取绝对路径的文件名或者目录名
          2、cahce:对象,存放一些预定义的路径
          3、resolvePath:获取文件或目录的绝对路径
      4、修改文件访问时间及修改时间
        fs.utimes(path,atime,mtime,callback); // 以异步方式修改文件的访问时间及修改时间
        fs.utimesSync(path,atime,mtime);  // 以同步方式修改文件的访问时间及修改时间
        eg:fs.utimes(path,atime,mtime,function(err){
          if(err){
            console.log('修改文件的访问时间和修改时间操作失败');
          }
        })
          1、path:指定需要修改的文件名
          2、atime:修改后的访问时间
          3、mtime:修改后的修改时间
          4、callback(err):修改操作失败时返回的错误对象
        4.1、使用open、openSync方法打开文件的修改文件访问及修改时间
          fs.futimes(fd,atime,mtime,callback);  // 以异步方式修改打开文件的访问时间及修改时间
          fs.futimesSync(fd,atime,mtime);  // 以同步方式修改打开文件的访问时间及修改时间
          eg:fs.open('./test.txt','r',function(err,fd){
              fs.futimes(fd,atime,mtime,function(err){
                if(err){
                  console.log('修改文件的访问时间和修改时间操作失败');
                }
              })
          })
            1、fd:使用open、openSync方法打开文件时返回的文件操作符
            2、atime:和utimes、utimesSync方法的使用方式相同
            3、mtime:和utimes、utimesSync方法的使用方式相同
            4、callback(err):和utimes、utimesSync方法的使用方式相同
      5、修改文件或目录的读取权限
        fs.chmod(path,mode,callback); // 以异步方式修改文件或目录的读取权限
        fs.chmodSync(path,mode);  // 以同步方式修改文件或目录的读取权限
        eg:fs.chmod(path,'0754',function(err){
          if(err){
            console.log('修改文件或者目录的读取权限失败');
            // 所有者可读可写可执行,所有者所在组可读可执行,其他人可读
          }
        });
          1、path:指定需要修改操作权限的文件名或者目录名
          2、mode:指定修改后的文件或者目录的操作权限
          3、callback(err):修改文件或者目录的操作权限的操作失败时返回的错误信息对象
        5.1、使用open、openSync方法打开文件的修改权限
          fs.fchmod(fd,mode,callback);  // 以异步方式修改打开文件的操作权限
          fs.fchmodSync(fd,mode);  // 以同步方式修改打开文件的操作权限
          eg:fs.open('./test.txt','r',function(err,fd){
             fs.fchmod(fd,'0754',function(err){
              if(err){
                console.log('修改文件权限操作失败');
              }
             })
          });
            1、fd:使用open、openSync方法打开文件时返回的文件操作符
            2、mode:和chmod、chmodSync方法的使用方式相同
            3、callback(err): 和chmod、chmodSync方法的使用方式相同
    6、对文件或目录执行的其他操作
      1、移动文件或目录:
        fs.rename(oldepath,newpath,callback); // 以异步方式移动文件或目录
        fs.renameSync(oldpath,newpath);  // 以同步方式移动文件或目录
        eg:fs.rename('./test.txt','./message.txt',function(err){
          if(err){
            console.log('移动文件或目录操作失败');
          }
        })
          1、oldPath:指定被移动的文件或目录的完整路径的文件名或目录名
          2、newPath:指定移动后的文件或目录的完整路径的文件名或目录名
          3、callback(err):移动文件或目录操作失败时的错误信息对象
      2、创建或删除文件的硬连接:操作系统中的文件的一个或多个文件名,类似于文件副本,操作任意一个文件,其他文件都会修改
        fs.link(srcpath,dstpath,callback); // 以异步方式创建文件的硬链接
        fs.linkSync(srcpath,dstpath);  // 以同步方式创建文件的硬链接
        eg:fs.link('./test.txt','./test/test.txt',function(err){
          if(err){
            console.log('创建文件的硬链接操作失败');
          }
        })
          1、srcpath:指定需要被创建硬连接的文件的完整路径及文件名
          2、dstpath:指定被创建硬链接的完整路径及文件名(程序运行前不存在),该连接文件与源文件必须位于同一卷中,
          3、callback(err):创建文件硬链接操作失败时返回的错误信息对象
        fs.unlink(path,callback); // 以异步方式删除文件的硬链接,同时会删除该文件,多个硬链接之间关系相互独立
        fs.unlinkSync(path); // 以同步方式删除文件的硬链接
        eg:fs.unlink('./test/test.txt',function(err){
          if(err){
            console.log('删除文件硬链接操作失败');
          }
        })
          1、path:指定被删除的硬链接的完整路径及文件名
          2、callback(err):删除文件硬链接操作失败的错误信息对象
      3、创建和查看符号链接:符号链接是一种特殊的文件,这个文件中仅包含了另一个文件或目录的路径及文件名或目录名
        fs.symlink(srcpath,dstpath,[type],callback); // 以异步方式创建文件或者目录的的符号链接
        fs.symlinkSync(srcpath,dstpath,[type]);  // 以同步方式创建文件或者目录的符号链接\
        eg:fs.symlink('./test.txt','./test/test.txt',function(err){
          if(err){
            console.log('创建符号链接操作失败');
          }
        })
          1、type:指定为文件创建符号链接还是为目录创建符号链接,默认值:file,[dir,junction]
          2、读取符号链接包含的另一个文件或目录的信息
          3、callback(err):创建符号链接操作失败时返回的错误信息对象
        fs.readlink(path,callback); // 以异步方式读取符号链接
        fs.readlinkSync(path); // 以同步方式读取符号链接
          1、path:指定获取符号链接的文件名
          2、callback(err):获取文件的符号链接操作失败时返回的错误信息对象
          3、callback(linkstring):返回的符号字符串,包含了另一个文件或目录的路径及文件名或目录名
      4、截断文件:清除文件内容,修改文件尺寸
        fs.truncate(filename,len,callback); // 以异步方式截断文件
        fs.truncateSync(filename,len); // 以同步方式截断文件
        eg:fs.truncate('./test.txt',10,function(err){
          if(err){
            console.log('截断文件操作失败');
          }
        })
          1、fileName:指定被截断文件的完整路径及文件名 
          2、len:指定被截断后的文件的尺寸(以字节为单位),Number
          3、callback(err):截断文件操作失败时返回的错误信息对象
        4.1、使用open、openSync方法打开文件的截断文件
          fs.ftruncate(fd,len,callback); // 以异步方式截断open方法打开的文件
          fs.ftruncateSync(fd,len); //  以同步方式截断open方法打开的文件
          eg:fs.open('./test.txt','r',function(err,fd){
            fs.ftruncate(fd,10,function(err){
              if(err){
                console.log('截断文件操作失败');
              }
            })
          })
            1、fd:使用open、openSync方法打开文件返回的文件操作符
            2、len:和truncate方法的使用方式相同
            3、callback(err):和truncate方法的使用方式相同
      5、删除空目录:
        fs.rmdir(path,callback); // 以异步方式删除空目录
        fs.rmdirSync(path); // 以同步方式删除空目录
        eg:fs.rmdir('./test',function(err){
          if(err){
            console.log('删除空目录操作失败');
          }
        })
          1、path:指定需要删除目录的完整路径的目录名
          2、callback(err):删除目录操作失败时返回的错误信息对象
      6、监视文件或目录
        fs.watchFile(filename,[options],listener); // 监视文件变化
        fs.unwatchFile(filename,[listener]); // 取消文件监视变化操作
        fs.watch(filename,[options],[listener]); // 对文件、目录监视变化
        eg:fs.watchFile('./test.txt',{persistent:false,interval:5000},function(curr,prev){
          curr:fs.Stats对象,代表修改之后的文件
          prev:fs.Stats对象,代表修改之前的文件
        })
          1、fileName:指定被监视文件的完整路径的文件名
          2、options:
            1、persistent:指定当指定了被监视的文件发生变化后是否停止当前正在运行的应用程序,默认值为true
            2、interval:指定每隔多少毫秒监视一次文件是否发生改变以及发生了什么改变
          3、listener:当监视文件发生变化后的回调函数
            function(curr,prev){}
            1、curr:为一个fs.Stats对象,代表修改之后的当前文件
            2、prev:为一个fs.stats对象,代表修改之前的当前文件
        var watcher = fs.watch('./test.txt',{persistent:false},function(event,fileName){
          console.log(event);
          console.log(fileName);
        });
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
