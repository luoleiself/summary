1. 简介:是一个状态机,封装了多个内部状态,返回一个遍历器对象,调用next方法继续执行
  1. 特征:
    1. function关键字与函数名之间有一个星号
    2. 函数体内使用yield表达式,定义不同的内部状态
    eg:function* helloWorldGenerator() {
        yield 'hello';
        yield 'world';
        return 'ending';
      }
      var hw = helloWorldGenerator();
      // yield 表达式是暂停执行的标记
      // 调用Generator函数,返回一个遍历器对象,代表Generator函数的内部指针
  2. yield表达式:暂停标志,只有调用next方法才会遍历下一个内部状态,直到return语句
    eg:var arr = [1, [[2, 3], 4], [5, 6]];
      var flat = function* (a) {
        a.forEach(function (item) {
          if (typeof item !== 'number') {
            yield* flat(item);
          } else {
            yield item;
          }
        });
      };
      for (var f of flat(arr)){
        console.log(f);
      }
  3. 与Iterator接口的关系:
    eg:var myIterable = {};
      myIterable[Symbol.iterator] = function* () {
        yield 1;
        yield 2;
        yield 3;
      };
      [...myIterable] // [1, 2, 3]
2. next方法的参数:当作上一个yield表达式的返回值
  eg:function* f() {
      for(var i = 0; true; i++) {
        var reset = yield i;
        if(reset) { i = -1; }
      }
    }
    var g = f();
    g.next() // { value: 0, done: false }
    g.next() // { value: 1, done: false }
    g.next(true) // { value: 0, done: false }
3. for...of循环:不再需要next()方法;
4. Generator.prototype.throw():Generator 函数返回的遍历器对象,都有一个throw方法(抛出异常)
  eg:var g = function* () {
      try {
        yield;
      } catch (e) {
        console.log('内部捕获', e);
      }
    };
    var i = g();
    i.next();
    try {
      i.throw('a');
      i.throw('b');
    } catch (e) {
      console.log('外部捕获', e);
    }
    // 内部捕获 a
    // 外部捕获 b
5. Generator.prototype.return():返回给定的值,并且终结遍历Generator函数
  eg:function* gen() {
      yield 1;
      yield 2;
      yield 3;
    }
    var g = gen();
    g.next()        // { value: 1, done: false }
    g.return('foo') // { value: "foo", done: true }
    g.next()        // { value: undefined, done: true }
  1. 如果Generator函数内有try...finally代码块,return方法将推迟到finally代码块执行完后再执行
    eg:function* numbers () {
        yield 1;
        try {
          yield 2;
          yield 3;
        } finally {
          yield 4;
          yield 5;
        }
        yield 6;
      }
      var g = numbers();
      g.next() // { value: 1, done: false }
      g.next() // { value: 2, done: false }
      g.return(7) // { value: 4, done: false }
      g.next() // { value: 5, done: false }
      g.next() // { value: 7, done: true }
6. yield*表达式:
7. 作为对象属性的Genertor函数:
  eg:let obj = {
      * myGeneratorMethod() {
        ···
      }
    };
  eg:let obj = {
      myGeneratorMethod: function* () {
        // ···
      }
    };
8. Generator函数的this:
9. 含义:
10. 应用:

async:
1. 含义:
  eg:var fs = require('fs');
    var readFile = function (fileName) {
      return new Promise(function (resolve, reject) {
        fs.readFile(fileName, function(error, data) {
          if (error) reject(error);
          resolve(data);
        });
      });
    };
    var gen = function* () {
      var f1 = yield readFile('/etc/fstab');
      var f2 = yield readFile('/etc/shells');
      console.log(f1.toString());
      console.log(f2.toString());
    }; 
    // 下面方法和上面方法功能一样
  eg:var asyncReadFile = async function () {
      var f1 = await readFile('/etc/fstab');
      var f2 = await readFile('/etc/shells');
      console.log(f1.toString());
      console.log(f2.toString());
    };
  1. 内置执行器:和普通方法一样,只要一行代码执行
    var result = asyncReadFile();
  2. 更好的语义:async * ,await yield;
  3. 更广的适用性:co模块规定,yield命令后面只能是Thunk函数或者Promise对象,async函数的await命令可以是Promise对象和原始数据类型
  4. 返回值是Promise:
    1.async函数返回Promise对象,封装多个异步操作,await类似then方法
    2.Generator函数Iterator对象,调用next方法执行下一步操作
2. 用法:async函数返回一个Promise对象,可以用then方法添加回调函数
  eg:async function getStockPriceByName(name) {
      var symbol = await getStockSymbol(name);
      var stockPrice = await getStockPrice(symbol);
      return stockPrice;
    }
    getStockPriceByName('goog').then(function (result) {
      console.log(result);
    });
  eg:// 函数声明
    async function foo() {}
    // 函数表达式
    const foo = async function () {};
    // 对象的方法
    let obj = { async foo() {} };
    obj.foo().then(...)
    // Class 的方法
    class Storage {
      constructor() {
        this.cachePromise = caches.open('avatars');
      }
      async getAvatar(name) {
        const cache = await this.cachePromise;
        return cache.match(`/avatars/${name}.jpg`);
      }
    }
    const storage = new Storage();
    storage.getAvatar('jake').then(…);
    // 箭头函数
    const foo = async () => {};
3. 语法:语法规则总体上比较简单,难点是错误处理机制
  1. 返回一个Promise对象
    1.return返回值成为then方法的参数
      eg:async function f() {
          return 'hello world';
        }
        f().then(v => console.log(v))
        // "hello world"
    2. async函数内部的错误会改变Promise对象的状态reject
      eg:async function f() {
          throw new Error('出错了');
        }
        f().then(
          v => console.log(v),
          e => console.log(e)
        )
        // Error: 出错了
  2. Promise对象状态的变化:除非遇到return语句或者抛出错误,只有内部的await命令后的操作执行完毕后,才会调用then方法的回调函数
    eg:async function getTitle(url) {
        let response = await fetch(url);
        let html = await response.text();
        return html.match(/<title>([\s\S]+)<\/title>/i)[1];
      }
      getTitle('https://tc39.github.io/ecma262/').then(console.log)
      // "ECMAScript 2017 Language Specification
  3. await命令:后跟一个Promise对象,如果不是会调用resolve方法转换为Promise对象
    eg:async function f() {
        return await 123;
      }
      f().then(v => console.log(v))
      // 123
  4. 错误处理:await后面的异步操作出错,等同于async函数返回的Promise对象被reject
    eg:async function f() {
        await new Promise(function (resolve, reject) {
          throw new Error('出错了');
        });
      }
      f().then(v => console.log(v)).catch(e => console.log(e))
      // Error：出错了
  5. 使用注意点:
    1. await命令的Promise对象的运行结果有可能是rejected,最好放到try...catch代码块中
    2. 多个await命令后的异步操作不存在继发关系,最好同时触发
      eg:// 写法一
        let [foo, bar] = await Promise.all([getFoo(), getBar()]);
        // 写法二
        let fooPromise = getFoo();
        let barPromise = getBar();
        let foo = await fooPromise;
        let bar = await barPromise;
    3. await命令只能在async函数中,用在普通函数中会报错
4. async函数实现原理:就是将 Generator 函数和自动执行器，包装在一个函数里
  eg:async function fn(args) {
      // ...
    }
    // 等同于
    function fn(args) {
      return spawn(function* () {
        // ...
      });
    }
  eg:function spawn(genF) {
      return new Promise(function(resolve, reject) {
        var gen = genF();
        function step(nextF) {
          try {
            var next = nextF();
          } catch(e) {
            return reject(e);
          }
          if(next.done) {
            return resolve(next.value);
          }
          Promise.resolve(next.value).then(function(v) {
            step(function() { return gen.next(v); });
          }, function(e) {
            step(function() { return gen.throw(e); });
          });
        }
        step(function() { return gen.next(undefined); });
      });
    }
5. 与其他异步方法的比较:dom动画的操作:
  eg:function chainAnimationsPromise(elem, animations) { // Promise
      // 变量ret用来保存上一个动画的返回值
      var ret = null;
      // 新建一个空的Promise
      var p = Promise.resolve();
      // 使用then方法，添加所有动画
      for(var anim of animations) {
        p = p.then(function(val) {
          ret = val;
          return anim(elem);
        });
      }
      // 返回一个部署了错误捕捉机制的Promise
      return p.catch(function(e) {
        /* 忽略错误，继续执行 */
      }).then(function() {
        return ret;
      });
    }
  eg:function chainAnimationsGenerator(elem, animations) { // Generator
      return spawn(function*() {
        var ret = null;
        try {
          for(var anim of animations) {
            ret = yield anim(elem);
          }
        } catch(e) {
          /* 忽略错误，继续执行 */
        }
        return ret;
      });
    }
  eg:async function chainAnimationsAsync(elem, animations) { // async
      var ret = null;
      try {
        for(var anim of animations) {
          ret = await anim(elem);
        }
      } catch(e) {
        /* 忽略错误，继续执行 */
      }
      return ret;
    }
6. 实例:按顺序完成异步操作:// 依次远程读取一组url,然后按读取顺序输出
  eg:function logInOrder(urls) { // Promise
      // 远程读取所有URL
      const textPromises = urls.map(url => {
        return fetch(url).then(response => response.text());
      });
      // 按次序输出
      textPromises.reduce((chain, textPromise) => {
        return chain.then(() => textPromise)
          .then(text => console.log(text));
      }, Promise.resolve());
    }
  eg:async function logInOrder(urls) { //async,继发,效率差
      for (const url of urls) {
        const response = await fetch(url);
        console.log(await response.text());
      }
    }
  eg:async function logInOrder(urls) {
      // 并发读取远程URL
      const textPromises = urls.map(async url => {
        const response = await fetch(url);
        return response.text();
      });
      // 按次序输出
      for (const textPromise of textPromises) {
        console.log(await textPromise);
      }
    }
7. 异步遍历器:
  eg:const asyncIterable = createAsyncIterable(['a', 'b']);
      const asyncIterator = asyncIterable[Symbol.asyncIterator]();
      asyncIterator
      .next()
      .then(iterResult1 => {
        console.log(iterResult1); // { value: 'a', done: false }
        return asyncIterator.next();
      })
      .then(iterResult2 => {
        console.log(iterResult2); // { value: 'b', done: false }
        return asyncIterator.next();
      })
      .then(iterResult3 => {
        console.log(iterResult3); // { value: undefined, done: true }
      });
8. for await...of:遍历异步的Iterator接口
  eg:async function f() {
      for await (const x of createAsyncIterable(['a', 'b'])) {
        console.log(x);
      }
    }
    // a
    // b
  eg:async function () {
      try {
        for await (const x of createRejectingIterable()) {
          console.log(x);
        }
      } catch (e) {
        console.error(e);
      }
    }
