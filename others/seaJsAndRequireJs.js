1.seajs.define: //主要用于定义模块
  define(function(require,exports,module){
    /* 定义模块方式一 */
    var a = require("a");
    var b = require("b");
    var data1 = 1; // 私有数据
    var func1 = function(){ // 私有方法
      return a.run(data1);
    };
    exports.data2 = 2; // 公共数据
    exports.func2 = function(){ //　公共方法
      return "hello";
    };
    /* 定义模块方式二 */
    var a = require("a");
    var b = require("b");
    var data1 = 1; // 私有数据
    var func1 = function(){
      return a.run(data1);
    }
    return {
      data2: 2,
      func2: function(){
        return "hello";
      }
    };
  })  
  /* 定义模块方式三 */
  // 只返回一个对象
  define({
    data: 1,
    func: function(){
      return "hello";
    }
  })
2.seajs.use: //主要用于载入入口模块,一般只用在页面载入入口模块
  // 单一模式
  seajs.use("./a");
  // 回调模式
  seajs.use("./a",function(a){
    a.run();
  })
  // 多模块模式
  seajs.use(["./a","./b"],function(a,b){
    a.run();
    b.run();
  })
3.seajs.require: //主要用于模块加载方法,
  var a = require("./a");
4.require.async: //实现javascript文件的按需加载
  require.async("/fileName",function(fileName){
    /* do something */
  })
5.seajs.config: //全局配置,接收一个配置对象
  seajs.config({
    base: "path/js/lib/", // 基址寻址时的基址路径, 
    //var $ = require("jquery"); path/js/lib/jquery.js
    alias: { // 对较长的常用路径设置缩写
      app: "path/js/app/"
    },
    charset:"utf-8", // 设置下载js时script标签的charset属性
    timeout:20000, // 下载文件的最大时长,以毫秒为单位
    debug:false // 是否工作在调试模式下
  })


1.requireJs: 
  <script src='./js/require.js' defer async="true"></script>
  <script src='./js/require.js' data-main="./js/main"></script>
2.require: // 异步加载模块,浏览器不会失去响应,当所有模块加载成功才会执行
  require(["moduleA","moduleB"],function(moduleA,moduleB){
    /* do something */
  })
3.require.config: // 对模块的加载行为自定义,
  require.config({
    baseUrl:"src/js/lib", // 配置模块基目录
    paths:{
      jquery:"lib/jquery.min", // 配置模块路径的缩写
      underscore:"lib/underscore.min",
      backbone:"lib/backbone.min"
    },
    shim:{ // 配置未遵循AMD规范的模块
      underscore:{
        exports:"_"
      },
      backbone:{
        deps:["underscore"], // 表明该模块的依赖性
        exports:"Backbone" // 外部调用该模块时的名称
      }
    }
  })
4.define: // 定义模块
  define(["moduleA"],function(moduleA){
    /* do something */
    return {}
  })
5.requireJs插件:
  define(["text!review.txt","image!cat.jpg"],function(review,cat){
    console.log(review);
  })

