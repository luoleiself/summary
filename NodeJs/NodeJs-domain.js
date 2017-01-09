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
      2、domain.run(fn);指定该对象需要监听的代码,如果发生异常时,即捕获触发error事件
    3、事件:
      1、error:当该对象捕获到异常时触发,function(err){}
    4、属性:
      1、domain.name;设置或获取该domain对象的名称