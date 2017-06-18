1.概述：将大程序拆分成互相依赖的小文件,import和export命令只能在模块的顶层,不能被任何代码块包含
  eg:// ES6模块,import命令编译时加载(静态加载)
    import { stat, exists, readFile } from 'fs';
2.严格模式:ES6默认采用严格模式;
3.export:规定模块对外的接口
  eg:// profile.js
    var firstName = 'Michael';
    var lastName = 'Jackson';
    var year = 1958;
    export {firstName, lastName, year};
  1.使用as重命名
    eg:function v1() { ... }
      function v2() { ... }
      export {
        v1 as streamV1,
        v2 as streamV2,
        v2 as streamLatestVersion
      };
4.import:用于输入其他模块提供的功能
  eg:// main.js
    import {firstName, lastName, year} from './profile';
    function setName(element) {
      element.textContent = firstName + ' ' + lastName;
    }
  1.使用as关键字重命名
    eg:import { lastName as surname } from './profile';
5.模块的整体加载:用星号（*）指定一个对象，所有输出值都加载在这个对象上面
  eg:// circle.js
    export function area(radius) {
      return Math.PI * radius * radius;
    }
    export function circumference(radius) {
      return 2 * Math.PI * radius;
    }
    import * as circle from './circle';
    console.log('圆面积：' + circle.area(4));
    console.log('圆周长：' + circle.circumference(14));
6.export default:为模块指定默认输出,本质上export default就是输出一个叫做default的变量或方法，然后系统允许你为它取任意名字 
  eg:// export-default.js
    export default function () {
      console.log('foo');
    }
    // export-default.js
    export default function foo() {
      console.log('foo');
    }
    // 或者写成
    function foo() {
      console.log('foo');
    }
    export default foo;
  eg:// 第一组
    export default function crc32() { // 输出
      // ...
    }
    import crc32 from 'crc32'; // 输入
    // 第二组
    export function crc32() { // 输出
      // ...
    };
    import {crc32} from 'crc32'; // 输入
7.export 与 import的复合写法:
  eg:export { foo, bar } from 'my_module';
    // 等同于
    import { foo, bar } from 'my_module';
    export { foo, bar };
8.模块的继承:
  eg:// circleplus.js
    export * from 'circle';
    export var e = 2.71828182846;
    export default function(x) {
      return Math.exp(x);
    }
    // 覆盖circle模块的e变量和default方法
9.跨模块常量:
  eg:// constants.js 模块
    export const A = 1;
    export const B = 3;
    export const C = 4;
    // test1.js 模块
    import * as constants from './constants';
    console.log(constants.A); // 1
    console.log(constants.B); // 3
    // test2.js 模块
    import {A, B} from './constants';
    console.log(A); // 1
    console.log(B); // 3
10.import():
  1.适用场合:
    1.按需加载:
      eg:button.addEventListener('click', event => {
          import('./dialogBox.js')
          .then(dialogBox => {
            dialogBox.open();
          })
          .catch(error => {
            /* Error handling */
          })
        });
    2.条件加载:
      eg:if (condition) {
          import('moduleA').then(...);
        } else {
          import('moduleB').then(...);
        }
    3.动态的模块路径:
      eg:import(f()).then(...);
      
11.浏览器加载:
  1.defer:渲染完再执行;<script type='application/javascript' defer></script>
  2.async:下载完就执行;<script type='application/javascript' async></script>
  3.加载ES6:
    eg:<script type="module" src="foo.js"></script>
      <!-- 等同于 -->
      <script type="module" src="foo.js" defer></script>
12.ES6模块和CommonJs模块的差异:
  1.CommonJS 模块输出的是一个值的拷贝,ES6 模块输出的是值的引用
  2.CommonJS 模块是运行时加载，ES6 模块是编译时输出接口
  3.ES6 模块之中，顶层的this指向undefined,CommonJS 模块的顶层this指向当前模块
    eg:// CommonJs加载方式
      // lib.js
      var counter = 3;
      function incCounter() {
        counter++;
      }
      module.exports = {
        counter: counter,
        incCounter: incCounter,
      };
      // main.js
      var mod = require('./lib');
      console.log(mod.counter);  // 3
      mod.incCounter();
      console.log(mod.counter); // 3
    eg:// CommonJs加载方式修改
      // lib.js
      var counter = 3;
      function incCounter() {
        counter++;
      }
      module.exports = {
        get counter() { // 取值器函数
          return counter;
        },
        set counter(val) { // 设值器函数
          counter = val;
        },
        incCounter: incCounter
      }
      // main.js
      var mod = require("./lib.js");
      console.log(mod.counter); // 3
      mod.incCounter();
      console.log(mod.counter); // 4
      console.log(__dirname); // 执行js文件的目录的绝对路径
      console.log(__filename); // 执行js文件的文件名的绝对路径
      console.log(process.cwd()); // 执行node命令的目录的绝对路径
      mod.counter = 10;
      console.log(mod.counter); // 10
      mod.incCounter();
      console.log(mod.counter); // 11
    eg: // ES6加载方式
      // lib.js
      export let counter = 3;
      export function incCounter() {
        counter++;
      }
      // main.js
      import { counter, incCounter } from './lib';
      console.log(counter); // 3
      incCounter();
      console.log(counter); // 4
13.Node加载:
  1.Node加载ES6模块:
    eg:export {};不输出任何接口
  2.import加载CommonJs模块:module.exports 被当作默认输出
    eg:// a.js
      module.exports = {
        foo: 'hello',
        bar: 'world'
      };
      // 等同于
      export default {
        foo: 'hello',
        bar: 'world'
      };
  3.reuqire加载ES6模块:ES6 模块的所有输出接口，会成为输入对象的属性
    eg:// es.js
      let foo = {bar:'my-default'};
      export default foo;
      foo = null;
      // cjs.js
      const es_namespace = require('./es');
      console.log(es_namespace.default);
      // {bar:'my-default'}
14.循环记载:
15.ES6模块的转码:
  1.ES6 module transpiler
  2.SystemJS
