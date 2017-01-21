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
    npm config set prefix "globalDirPath"
    npm config set cache "cacheDirPath"
### 硬链接:
    操作系统中的文件的一个或多个文件名,类似于创建文件副本,操作任意一个文件,其他文件都会修改
    fs.link(srcpath,dstpath,function(err){})
    fs.unlink(path,function(err){})
### 符号链接:
    符号链接是一种特殊的文件,这个文件中仅包含了另一个文件或目录的路径及文件名或目录名
    fs.symlink(srcpath,dstpath,[type],function(err){});
        type:指定为文件创建符号链接还是为目录创建符号链接,默认值:file,[dir,junction] 
    fs.readlink(path,function(err,linkString){}) 
### path:
    1、normalize();将非标准路径字符串转换成标准路径字符串//path.normalize(p);
    2、join();将多个参数值字符串结合为一个路径字符串
        //path.join([path1],[path2],[...]);path.join(_dirname,"/ab/c/d");
    3、resolve();以应用程序根目录为起点,根据所有的参数值字符串解析出一个绝对路径
        //path.resolve(path,[path1],[path2])
    4、relative(from,to);获取两个路径之间的相对关系
        //path.relative("./././","././././")
    5、dirname(path);获取一个路径中的目录名
        //path.dirname("d:/nodejs/test/test.txt");d:/nodejs/test/
    6、basename(path,[ext]);获取一个路径中的文件名,ext去除返回的文件名的扩展名
        //path.basename("d:/nodejs/test/test.txt");test.txt
    7、extname(path);获取一个路径中的扩展名,如果没有指定则返回空字符串
        //path.extname("d:/nodejs/test/test.txt");".txt"
    8、path.sep:属性值为操作系统指定的文件分隔符
    9、path.delimiter:属性值为操作系统指定的路径分隔符
    
    
    
