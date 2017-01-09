1、第十章:NodeJs中的错误处理与断言处理
  1、使用domain模块处理错误
    1、try...catch:只能捕获同步方法中抛出的异常,不能捕获异步方法中抛出的异常
      //同步方法可以使用try..catch方法捕获异常
      var fs = require("fs");
      try{
        var data = fs.createReadSync("test.txt","utf8");
        console.log(data);
      }catch(exception){
        console.log(exception);
      }
    2、方法:
      1、var domain = domain.create();返回一个Domain对象,该对象为继承EventEmitter类的实例对象
      2、domain.run(fn);指定该对象需要监听的代码,如果发生异常时,即捕获触发error事件,
      3、domain.add(emitter);值为一个需要被绑定的继承了EventEmitter类的实例对象,如果该实例对象发生异常则被捕获
        1、隐式绑定:run方法将所有的继承了EventEmitter类的实例对象隐式的绑定到domain对象上,
          如果任何对象发生异常都会被捕获
        2、显式绑定:add方法将指定的继承了EventEmitter类的实例对象显式的绑定到domain对象上,
      4、domain.remove(emitter);取消指定对象的绑定,
    3、事件:
      1、error:当该对象捕获到异常时触发,function(err){}
    4、属性:
      1、domain.name;设置或获取该domain对象的名称