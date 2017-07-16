#### [NodeJs-API](http://nodejs.cn/api/)
#### 非阻塞型I/O:回调函数
#### 事件环机制:
   >  在NodeJs中，在一个时刻只能执行一个事件回调函数，但是在执行一个事件回调函数的中途可以转而处理其他事件（触发新的事件、声明该事件的回调函数等），然后返回继续执行原事件回调函数。
### REPL
  * .break(Ctrl+C):重新书写多行函数时返回起始点
  * .clear:清楚REPL运行环境的上下文对象中保存的所有的变量和函数
  * .exit:退出REPL运行环境
  * .help:显示REPL运行环境的所有基础命令
  * .save:将REPL运行环境中所有输入的表达式保存到一个文件中,可以指定文件路径
  * .load:将某个文件中包含的所有的表达式加载REPL运行环境中,可以指定文件路径
### console: 
  * node fileName.js 1>fileName => 标准输出流(输出到指定文件中)
  * node fileName.js 2>fileName => 标准错误输出流(输出到指定文件中)
  * console.log(); <=> console.info();
  * console.error(); => 输出错误信息
  * console.dir(); => 查看并打印一个对象的内容
  * console.time();console.timeEnd(); => 统计一段代码的执行时间
  * console.trace(); => 将当前位置处的栈信息作为标准错误信息输出
  * console.assert(); => 对一个表达式的结果进行评估
### global:
  * Buffer;module;process;
  * var timer = setInterval(callback,time,args,[...]);clearInterval(timer);timer.unref();timer.ref();
  * var timer = setTimeout(callback,time,args,[...]);clearTimeout(timer);timer.unref();timer.ref();
  * require.resolve('moduleName'); => 获取指定模块文件的带有完整绝对路径的文件名
  * require.cache; => 缓存所有已被加载的模块文件的缓存区
    * {filePath:module}
  * __filename:获取当前模块文件的带有完整绝对路径的文件名
  * __dirname:获取当前模块文件的带有完整绝对路径的目录名
  * EventEmitter:
    * emitter.addListener(event,listener); => 对指定事件绑定事件及事件处理函数
    * emitter.on(event,listener); => addListener的别名
    * emitter.once(event,listener); => 绑定只执行一次的事件
    * emitter.removeListener(event,listener); => 对指定事件解除事件处理函数
    * emitter.removeAllListeners([event]); => 对指定事件解除所有事件处理函数
    * emitter.setMaxListeners(number); => 指定事件的事件处理函数的个数,默认最大绑定10个
    * emitter.listeners(event); => 获取指定事件的所有事件处理函数
    * emitter.emit(event,[arg1],[...]); => 手动触发指定事件
    * EventEmitter.listenerCount(emitter,event); => 获取某个对象的指定事件的事件处理函数的数量
    * newListener => 对继承了EventEmitter类的子类的实例对象绑定事件处理函数时触发该事件
    * removeListener => 对继承了EventEmitter类的子类的实例对象解除事件处理函数时触发该事件
  * debug:
    * node debug/inspect filename => 启动debug模式
    * c => 继续执行剩余代码;n => 下一步;s => 进行方法内部执行;o => 退出
    * sb/setBreakPoint([filename],number) => 设置断点;cb/clearBreakPoint([filename],number) => 清除断点
    * bt/backtrace => 查看该函数及外层各函数的返回位置;
    * list(number) => 查看当前行的前后的指定行的代码;
    * repl => 进入交互环境
    * restart =>　重新开始调试
    * kill => 终止脚本调试
    * run => kill命令执行后,重新开始脚本调试
    * scripts => 查看加载的模块文件名称(不包含NodeJs内置模块)
    * version => 显示Js引擎版本号
