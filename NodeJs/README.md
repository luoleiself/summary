#### NodeJs的环境变量配置：
  1. 计算机 -> 属性 -> 高级系统设置 -> 高级 -> 环境变量
      1. 修改用户变量PATH:
        * D:\nodeJs\node_global -> 安装的全局模块的执行命令在此目录下,不修改报错"xxx不是内部或外部命令，也不是可运行的程序或批处理文件"
      2. 新建系统环境变量NODE_PATH:
        * D:\nodeJs\node_global\node_modules ->全局模块的安装路径,使用时nodeJs会从此路径下加载
  2. 安装anywhere全局模块测试:
#### npm命令:
* npm install modulesName@version  //安装版本
* npm install modulesName -S/--save //生产阶段依赖;
* npm install modulesName -D/--save-dev   //开发阶段依赖;
* npm install modulesName -O/--save-optional  //可选阶段的依赖;
* npm install modulesName -E/--save-exact     //安装指定版本;
* npm uninstall modulesName       //卸载指定模块
* npm outdated                    //检测模块是否过时
* npm ls -g --depth 0          //查看安装的模块
* npm init        //初始化项目，创建package.json文件，保存安装包的信息
* npm help        //查看某条命令的详细帮助 
* npm root  -g  //查看系统包的安装路径
* npm config  list  -l  //查看config配置列表详情
* npm start       //启动模块
* npm cache      //管理模块的缓存
* npm stop        //停止模块
* npm restart    //重新启动模块
* npm test       //测试模块
* npm version    //查看模块版本
* npm view       //查看模块的注册信息
* npm publish     //发布模块
* npm config set prefix "globalDirPath"
* npm config set cache "cacheDirPath"
### [README_E.md](https://github.com/luoleiself/summary/blob/master/NodeJs/README_E.md)