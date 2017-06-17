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
      
