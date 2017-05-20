### NodeJs的安装:
    1.首先从官网上下载安装包(window.msi):http://nodejs.cn/download/
    2.启动安装程序:根据提示下一步操作
    3.修改NodeJs的主程序路径:D:\nodeJs
    4.cmd：
        node -v # 查看nodejs版本号
        npm -v #查看npm版本号
    5.上面成功显示表示nodejs安装成功
    6.修改全局配置:nodejs的全局模块和缓存都默认在c盘,容易c盘的空间占用问题
    7.修改全局模块的安装路径:npm config set prefix D:\nodeJs\node_global   -> 在nodeJs安装目录中多了这两个文件
    8.修改全局模块的缓存路径:npm config set cache D:\nodeJs\node_cache
    9.修改镜像资源地址:npm config set registry https://registry.npm.taobao.org
    10.cmd:npm config list -l ->查看nodeJs配置文件详情/c:\Users\Administrator\.npmrc
    11.设置系统环境变量:
        1.计算机 -> 属性 -> 高级系统设置 -> 高级 -> 环境变量
        2.修改用户变量PATH:D:\nodeJs\node_global -> 安装的全局模块的执行命令在此目录下,不修改报错"xxx不是内部或外部命令，也不是可运行的程序或批处理文件"
        3.新建系统环境变量NODE_PATH:D:\nodeJs\node_global\node_modules ->全局模块的安装路径,使用时nodeJs会从此路径下加载
    12.安装anywhere全局模块测试:
### npm命令:
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
    npm root  -g  //查看系统包的安装路径
    npm config  list  -l  //查看config配置列表详情
    npm start       //启动模块
    npm cache      //管理模块的缓存
    npm stop        //停止模块
    npm restart    //重新启动模块
    npm test       //测试模块
    npm version    //查看模块版本
    npm view       //查看模块的注册信息
    npm publish     //发布模块
    npm config set prefix "globalDirPath"
    npm config set cache "cacheDirPath"
