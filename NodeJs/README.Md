### NodeJs
    npm install modulesName@version  //安装版本
    npm install modulesName -S/--save //生产阶段依赖;
    npm install modulesName -D/--save-dev   //开发阶段依赖;
    npm install modulesName -O/--save-optional  //可选阶段的依赖;
    npm install modulesName -E/--save-exact     //安装指定版本;
    npm uninstall modulesName       //卸载指定模块
    npm outdated                    //检测模块是否过时
    npm ls -g --depth 0          //查看安装的模块
    npm init        //初始化项目，创建package.json文件，保存安装包的信息
    npm help        //查看某条命令的详细帮助 
    npm root        //查看包的安装路径
    npm config      //管理npm的配置路径
    npm start       //启动模块
    npm cache      //管理模块的缓存
    npm stop        //停止模块
    npm restart    //重新启动模块
    npm test       //测试模块
    npm version    //查看模块版本
    npm view       //查看模块的注册信息
    npm publish     //发布模块
### fs模块:
    1、方法一:读取文件内容
      fs.readFile(filename,[options],callback);
      fs.readFileSync(filename,[options]);
      e.g:fs.readFile("./test.txt","utf8",function(err,data){})
    2、方法二:向文件写入内容
      fs.writeFile(filename,data,[options],callback);
      fs.writeFileSync(filename,data,[options]);
      e.g:fs.writeFile("./test.txt","这是写入的内容\n","utf8",function(err){})
    3、方法三:向文件尾部追加内容
      fs.appendFile(filename,data,[options],callback);
      fs.appendFileSync(filename,data,[options]);
      e.g:fs.appendFile("./test.txt","这是追加的内容\n","utf8",function(err){})
    4、方法四:打开文件
      fs.open(filename,flags,[mode],callback);
      fs.open(filename,flags,[mode]);
      e.g:fs.open("./test.txt","utf8",function(err,fd){})
    5、方法五:读取文件指定内容
      fs.read(fd,buffer,offset,length,position,callback);
      fs.read(fd,buffer,offset,length,position);
      e.g:fs.read(fd,buf,0,9,3,function(err,byteRead,buffer){})
    6、方法六:向文件内写入指定内容
      fs.write(fd,buffer,offset,length,position,callback);
      fs.write(fd,buffer,offset,length,position);
      e.g:fs.write(fd,buf,0,9,3,function(err,written,buffer){})
    7、方法七:关闭文件
      fs.close(fd,[callback])
      fs.closeSync(fd);
      e.g:fs.close(fd,function(err){})
    8、方法八:对文件进行同步操作,将缓存区的剩下的所有数据全部写入到文件中
      fs.fsync(fd,[callback]);
      fs.fsyncSync(fd);







