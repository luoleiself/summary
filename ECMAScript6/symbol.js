1.概述:原始数据类型(类似字符串),表示独一无二的值,(javascript的第七种数据类型)
  1.Symbol值不能和其他类型的值进行运算
  2.Symbol值可以转换为字符串,布尔值,不能为转换为数字
  3.Symbol函数不能使用new命令,Symbol生成的是一个原始类型的值
  4.Symbol函数如果接收一个参数为对象,则显式调用该对象的tostring方法转换为字符串
  5.对象的属性名现在有两种表示方式:
    1.字符串类型
    2.Symbol类型
  eg:let s = Symbol();
    typeof s
    // "Symbol"var s1 = Symbol('foo');
    var s2 = Symbol('bar');
    s1 // Symbol(foo)
    s2 // Symbol(bar)
    s1.toString() // "Symbol(foo)"
    s2.toString() // "Symbol(bar)"
    const obj = {
      toString() {
        return 'abc';
      }
    };
    const sym = Symbol(obj);
    sym // Symbol(abc)
2.作为属性名的Symbol:
  1.Symbol值作为对象的属性名时,不能使用点运算符,点运算符后面是字符串,
  2.在对象内部使用Symbol定义属性名时,必须放到中括号内(属性名是字符串),
  eg:var mySymbol = Symbol();
    // 第一种写法
    var a = {};
    a[mySymbol] = 'Hello!';
    // 第二种写法
    var a = {
      [mySymbol]: 'Hello!'
    };
    // 第三种写法
    var a = {};
    Object.defineProperty(a, mySymbol, { value: 'Hello!' });
    // 以上写法都得到同样结果
    a[mySymbol] // "Hello!"
3.实例:消除魔术字符串:在代码之中多次出现、与代码形成强耦合的某一个具体的字符串或者数值
  eg:function getArea(shape, options) {
      var area = 0;
      switch (shape) {
        case 'Triangle': // 魔术字符串
          area = .5 * options.width * options.height;
          break;
        /* ... more code ... */
      }
      return area;
    }
    getArea('Triangle', { width: 100, height: 100 }); // 魔术字符串
4.属性名的遍历:Symbol作为属性名,不会出现在for...of(),for...of()循环中,不能被Object.keys()、Object.getOwnPropertyNames()、JSON.stringify()返回,
  1.Object.getOwnPropertySymbols():返回一个数组,包含当前对象的所有用作属性名的Symbol值
    eg:var obj = {};
      var foo = Symbol("foo");
      Object.defineProperty(obj, foo, {
        value: "foobar",
      });
      for (var i in obj) {
        console.log(i); // 无输出
      }
      Object.getOwnPropertyNames(obj)
      // []
      Object.getOwnPropertySymbols(obj)
      // [Symbol(foo)]
    2.Reflect.ownKeys():返回所有的键名,包含常规键名和Symbol键名
      eg:let obj = {
        [Symbol('my_key')]: 1,
        enum: 2,
        nonEnum: 3
      };
      Reflect.ownKeys(obj)
      //  ["enum", "nonEnum", Symbol(my_key)]
5.Symbol.for(),Symbol.keyFor():
  1.Symbol.for(str):重新使用同一个Symbol值,搜索是否存在,如果存在则返回,否则重新创建
    eg:var s1 = Symbol.for('foo');
      var s2 = Symbol.for('foo');
      s1 === s2 // true
      Symbol.for("bar") === Symbol.for("bar")
      // true
      Symbol("bar") === Symbol("bar")
      // false
    和Symbol()的区别:前者会被登记在全局环境中供搜索,后者不会,后者每次返回一个新的Symbol值
  2.Symbol.keyFor():已登记的 Symbol 类型值的key
    eg:var s1 = Symbol.for("foo");
      Symbol.keyFor(s1) // "foo"
      var s2 = Symbol("foo");
      Symbol.keyFor(s2) // undefined
6.实例:模版的singleton模式:调用一个类,任何时候返回的都是同一个实例
  eg:// mod.js
    const FOO_KEY = Symbol.for('foo');
    function A() {
      this.foo = 'hello';
    }
    if (!global[FOO_KEY]) {
      global[FOO_KEY] = new A();
    }
    module.exports = global[FOO_KEY];

    var a = require('./mod.js');
    global[Symbol.for('foo')] = 123;
7.内置的Symbol值:
  1.Symbol.hasInstance
  2.Symbol.isConcatSpreadable
  3.Symbol.species
  4.Symbol.match
  5.Symbol.replace
  6.Symbol.search
  7.Symbol.split
    eg:String.prototype.split(separator, limit)
    // 等同于
    separator[Symbol.split](this, limit)
  8.Symbol.iterator
  9.Symbol.toPrimitive
  10.Symbol.toStringTag
  11.Symbol.unscopables
  