一、安装：偶数位为稳定版
  1、Windows：
    1、下载git bash
    2、下载nodejs.org
    3、如何调试失败，需要设置环境变量。
  2、Linux：
    1、首先安装gcc，gc++插件。
    2、操作系统的发行版本不同，安装命令不同。
  3、Mac：
    1、首先升级安装Xcode：Xcode-select --install
    2、检查是python -V
    3、安装homebrew：官网上有命令。
    4、brew install git node #(node -v)
      4.1、node版本的升级：npm install -g n
      4.2、安装指定版本：n 0.10.22
      4.3、版本切换: n（上下键）
二、启动Web服务器：启动服务器代码官网上有
  1、新建一个目录：
      node server.js (显示服务器网址和端口号）
  2、浏览器输入指定网址：
      nodejs和浏览器执行js的不同：浏览器内置对象window,nodejs内置对象proccess

      npm install modulesName@version  //安装版本
      npm install modulesName -S/--save //生产阶段依赖;
      npm install modulesName -D/--save-dev   //开发阶段依赖;
      npm install modulesName -O/--save-optional  //可选阶段的依赖;
      npm install modulesName -E/--save-exact     //安装指定版本;
      npm uninstall modulesName       //卸载指定模块
      npm outdated                    //检测模块是否过时
      npm ls                          //查看安装的模块
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
  5、全局变量:
    1、_filename:指向当前运行的脚本文件名
    2、_dirname:指向当前运行的脚本所在的目录
  6、准全局变量:模块内部的局部变量，指向的对象根据模块不同而不同，但是所有模块都适用，可以看作是伪全局变量
    1、module:变量指代当前模块
    2、module.exports:变量表示当前模块对外输出的接口，其他文件加载该模块，实际上就是读取module.exports变量
    3、module.id:模块的识别符，通常是模块的文件名
    4、module.filename:模块的文件名
    5、module.loaded:返回一个布尔值，表示模块是否已经完成加载
    6、module.parent:返回使用该模块的模块
    7、module.children:返回一个数组,表示该模块要用到的其他模块

