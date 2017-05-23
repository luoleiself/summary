1.函数参数的默认值:
  1.ES5中不允许给参数变量赋默认值,ES6中允许
  2.设置默认值的参数变量放在参数列表的最后
  3.函数的length属性:返回没有指定默认值的参数的个数
    eg:(function (a) {}).length // 1
      (function (a = 5) {}).length // 0
      (function (a, b, c = 5) {}).length // 2
2.rest参数:"...变量名",获取函数的多余参数,不需要使用arguments对象
  1.rest 参数之后不能再有其他参数(即只能是最后一个参数),否则会报错
  eg:function add(...values) {
      let sum = 0;
      for (var val of values) {
        sum += val;
      }
      return sum;
    }
    add(2, 5, 3) // 10
    // 报错
    function f(a, ...b, c) {
      // ...
    }
3.扩展运算符:'...',将一个数组转为用逗号分隔的参数序列
  1.替换数组的apply方法
  2.应用:
    1.合并数组:
      eg:// ES5
        [1, 2].concat(more)
        // ES6
        [1, 2, ...more]
        var arr1 = ['a', 'b'];
        var arr2 = ['c'];
        var arr3 = ['d', 'e'];
        // ES5的合并数组
        arr1.concat(arr2, arr3);
        // [ 'a', 'b', 'c', 'd', 'e' ]
        // ES6的合并数组
        [...arr1, ...arr2, ...arr3]
        // [ 'a', 'b', 'c', 'd', 'e' ]
    2.与解构赋值结合:
      eg:// ES5
        a = list[0], rest = list.slice(1)
        // ES6
        [a, ...rest] = list
        const [first, ...rest] = [1, 2, 3, 4, 5];
        first // 1
        rest  // [2, 3, 4, 5]
    3.函数的返回值:
      eg:var dateFields = readDateFields(database);
        var d = new Date(...dateFields);
    4.字符串:将字符串转为真正的数组
      eg:[...'hello']
        // [ "h", "e", "l", "l", "o" ]
    5.实现了Iterator接口的对象:
      eg:var nodeList = document.querySelectorAll('div');
        var array = [...nodeList];
    6.Map和Set结构,Generator函数:
      eg:let map = new Map([
          [1, 'one'],
          [2, 'two'],
          [3, 'three'],
        ]);
        let arr = [...map.keys()]; // [1, 2, 3]
  eg:console.log(...[1, 2, 3]) // 1 2 3
    console.log(1, ...[2, 3, 4], 5) // 1 2 3 4 5
    [...document.querySelectorAll('div')] // [<div>, <div>, <div>]
    function push(array, ...items) {
      array.push(...items);
    }
    function add(x, y) {
      return x + y;
    }
    var numbers = [4, 38];
    add(...numbers) // 42
4.严格模式:
  1.从ES5开始,函数内部可以设定严格模式
  2.ES6中,只要函数使用了默认值,解构赋值,扩展运算符,函数内部不能使用严格模式,否则报错
  eg:// 报错
    function doSomething(a, b = a) {
      'use strict';
      // code
    }
    // 报错
    const doSomething = function ({a, b}) {
      'use strict';
      // code
    };
    // 报错
    const doSomething = (...a) => {
      'use strict';
      // code
    };
    const obj = {
      // 报错
      doSomething({a, b}) {
        'use strict';
        // code
      }
    };
5.name属性:返回该函数的函数名;
  eg:function foo() {}
    foo.name // "foo"
6.箭头函数:
  1.如果没有参数或者不需要参数,使用小括号代替参数部分
    eg:var f = () => 5;
      // 等同于
      var f = function () { return 5 };
      var sum = (num1, num2) => num1 + num2;
      // 等同于
      var sum = function(num1, num2) {
        return num1 + num2;
      };
  2.如果箭头函数的代码块部分多于一条语句,就需要使用大括号并使用return语句返回;
    eg:var sum = (num1, num2) => { return num1 + num2; }
  3.如果箭头函数返回对象,必须使用小括号包含(大括号被解释成代码块);
    eg:var getTempItem = id => ({ id: id, name: "Temp" });
  4.箭头函数和变量解构结合使用:
    eg:const full = ({ first, last }) => first + ' ' + last;
      // 等同于
      function full(person) {
        return person.first + ' ' + person.last;
      }
      // 正常函数写法
      [1,2,3].map(function (x) {
        return x * x;
      });
      // 箭头函数写法
      [1,2,3].map(x => x * x);
      const numbers = (...nums) => nums;
      numbers(1, 2, 3, 4, 5)
      // [1,2,3,4,5]
  5.使用注意事项:
    1.函数体内的this对象,就是定义时所在的对象,而不是使用时所在的对象
    2.不可以当作构造函数,也就是说,不可以使用new命令,否则会抛出一个错误
    3.不可以使用arguments对象,该对象在函数体内不存在,如果要用,可以用Rest参数代替
    4.不可以使用yield命令,因此箭头函数不能用作Generator函数
7.绑定this:函数绑定运算符::,出现在ES7提案中,babel解析器目前已支持
  1.将::左边的对象绑定到右边的函数的上下文环境中,
    eg:foo::bar;
      // 等同于
      bar.bind(foo);
      foo::bar(...arguments);
      // 等同于
      bar.apply(foo, arguments);
      const hasOwnProperty = Object.prototype.hasOwnProperty;
      function hasOwn(obj, key) {
        return obj::hasOwnProperty(key);
      }
  2.双冒号左边为空时,右边是一个对象的方法,等于将该方法绑定在该对象上
    eg:var method = obj::obj.foo;
      // 等同于
      var method = ::obj.foo;
      let log = ::console.log;
      // 等同于
      var log = console.log.bind(console);
  3.双冒号运算符返回的还是原对象,因此可以采用链式写法
    eg:// 例一
      import { map, takeWhile, forEach } from "iterlib";
      getPlayers()
      ::map(x => x.character())
      ::takeWhile(x => x.strength > 100)
      ::forEach(x => console.log(x));
      // 例二
      let { find, html } = jake;
      document.querySelectorAll("div.myClass")
      ::find("p")
      ::html("hahaha");   
8.尾调用优化:函数执行的最后一步调用另一个函数->尾调用(Tail Call)
  eg:function f(x){
      return g(x);
    }
    // 以下非尾调用
    // 情况一
    function f(x){
      let y = g(x);
      return y;
    }
    // 情况二
    function f(x){
      return g(x) + 1;
    }
    // 情况三
    function f(x){
      g(x);
    }
9.函数参数的尾逗号:ES2017允许函数的最后一个参数有尾逗号
  eg:function clownsEverywhere(
      param1,
      param2,
    ) { /* ... */ }
    clownsEverywhere(
      'foo',
      'bar',
    );
