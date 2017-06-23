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
    
