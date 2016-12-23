一、安装：偶数位为稳定版
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
  10、NodeJs追加的类、函数和对象:
    1、Buffer类:为二进制数据的存储提供一个缓冲区
      1、var buf = new Buffer(size);//指定缓冲区的大小(以字节为单位)
      2、var buf = new Buffer([value,[offset],[end]]);//使用数组初始化缓冲区
      3、var buf = new Buffer(string,[encoding]);//使用字符串初始化缓冲区
      4、方法:
        1、fill(value,[offset],[end]);//初始化缓冲区中的所有内容
      5、字符串长度和缓存区的长度不一样;
        1、slice();//字符串截取,缓存区截取后,缓存区将会改变
      6、Buffer与String的转换
        1、buf.stoString([encoding],[start],[end]);
        2、buf.write(str,[offset],[length],[encoding]);
        3、//使用NodeJs模块:stringDecoder对象
    2、setTimeout(),setInterval(),clearInterval(),clearTimeout(),timer.unref(),timer.ref(),
    3、require函数:用于加载模块
      1、require():方法,加载指定模块文件
      2、require.resolve():方法,返回查询的模块文件的带有完整路径文件的文件名,查询时不会加载该模块
      3、require.cache:对象,查看当前缓冲区的内容.
    4、module对象:访问模块信息
    5、process对象:访问进程信息