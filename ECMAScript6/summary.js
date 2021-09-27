1.使用let代替var
2.静态字符串一律使用单引号或反引号，不使用双引号。动态字符串使用反引号
  eg:// bad
    const a = "foobar";
    const b = 'foo' + a + 'bar';
    // acceptable
    const c = `foobar`;
    // good
    const a = 'foobar';
    const b = `foo${a}bar`;
    const c = 'foobar';
3.解构赋值:
  1.使用数组成员对变量赋值时,优先使用解构赋值
    eg:const arr = [1, 2, 3, 4];
      // bad
      const first = arr[0];
      const second = arr[1];
      // good
      const [first, second] = arr;
  2.函数的参数如果是对象的成员,优先使用解构赋值
    eg:// bad
      function getFullName(user) {
        const firstName = user.firstName;
        const lastName = user.lastName;
      }
      // good
      function getFullName(obj) {
        const { firstName, lastName } = obj;
      }
      // best
      function getFullName({ firstName, lastName }) {
      }
4.对象:
  1.单行定义的对象，最后一个成员不以逗号结尾。多行定义的对象，最后一个成员以逗号结尾
  2.对象尽量静态化，一旦定义，就不得随意添加新的属性。如果添加属性不可避免，要使用Object.assign方法
5.数组:
  1.使用扩展运算符（...）拷贝数组
    eg:// bad
      const len = items.length;
      const itemsCopy = [];
      let i;
      for (i = 0; i < len; i++) {
        itemsCopy[i] = items[i];
      }
      // good
      const itemsCopy = [...items];
  2.使用Array.from方法，将类似数组的对象转为数组
    eg:const foo = document.querySelectorAll('.foo');
      const nodes = Array.from(foo);
6.函数:
  eg:(() => {
      console.log('Welcome to the Internet.');
    })();
7.Map:
  1.描述现实世界的实体对象时,使用Object
    eg:let map = new Map(arr);
      for (let key of map.keys()) {
        console.log(key);
      }
      for (let value of map.values()) {
        console.log(value);
      }
      for (let item of map.entries()) {
        console.log(item[0], item[1]);
      }
8.module:
  1.使用import代替require
    eg:// bad
      const moduleA = require('moduleA');
      const func1 = moduleA.func1;
      const func2 = moduleA.func2;
      // good
      import { func1, func2 } from 'moduleA';
  2.使用export代替module.exports
    eg:// commonJS的写法
      var React = require('react');
      var Breadcrumbs = React.createClass({
        render() {
          return <nav />;
        }
      });
      module.exports = Breadcrumbs;
      // ES6的写法
      import React from 'react';
      class Breadcrumbs extends React.Component {
        render() {
          return <nav />;
        }
      };
      export default Breadcrumbs;
9. 指数运算符 **
10. 链判断运算符 ?.
11. null判断运算符 ??
12. 逻辑赋值运算符 &&= ||=  ??=
13. 管道运算符 |>
14. 双冒号运算符 ::
