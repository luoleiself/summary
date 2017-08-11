1.Promise的含义:简单说就是一个容器，里面保存着某个未来才会结束的事件(通常是一个异步操作)的结果,从语法上说,Promise 是一个对象,从它可以获取异步操作的消息,Promise 提供统一的 API,各种异步操作都可以用同样的方法进行处理
  1. 特点:
    1. 对象的状态不受外界影响:Pending(进行中)、Fullfilled/Resolved(已成功)、Rejected(已失败)
    2. 一旦状态改变,就不会再变,任何时候都可以得到这个结果
  2. 缺点:
    1. 无法取消:一旦新建对象就会立即执行,无法中途取消
    2. 如果不设置回调函数,Promise内部抛出的错误,不会反应到外部
    3. 当处于Pending状态时,无法得知当前进展到哪一个阶段
  3. 方法:
    1. Promise(); // 构造函数
    2. Promise.prototype.then(callback,callback); // 原型对象方法,实例状态改变时的方法
    3. Promise.prototype.catch(callback); // 原型对象方法,实例状态为Rejected的方法
    4. Promise.all(); // 类方法,只有其中的promise实例状态全部为Fullfilled才为Fullfilled,否则为Rejected
    5. Promise.race(); // 类方法,只要其中一个promise实例发生变化即可
    6. Promise.resolve(); // 将现有对象转为Promise对象,
    7. Promise.reject(); // 将现有对象转为Promise对象,该状态为Rejected
    8. done(); // 需要自己实现
    9. finally(); // 需要自己实现
2.基本用法:
  var promise = new Promise(function(resolve,reject){
     true ? resolve(value) : reject(value);
  });
  promise.then(function(value){
    console.log(vlaue); // Promise实例的回调函数传递出来的值
  },function(value){
    console.warn(value); // Promise实例的回调函数传递出来的值
  })
  eg: // resolve 和 reject 为两个函数,由js引擎提供,不用自己部署,修改Promise对象的状态
    var promise = new Promise(function(resolve, reject) {
      // ... some code
      if (/* 异步操作成功 */){
        resolve(value);
      } else {
        reject(error);
      }
    });
    promise.then(function(value) { // 指定Promise实例的两个状态的回调函数
      // success
    }, function(error) {
      // failure
    });
  eg:let promise = new Promise(function(resolve, reject) {
      console.log('Promise');
      resolve();
    });
    promise.then(function() {
      console.log('Resolved.');
    });
    console.log('Hi!');
    // Promise
    // Hi!
    // Resolved
  eg:function loadImageAsync(url) { // 异步加载图片的例子
      return new Promise(function(resolve, reject) {
        var image = new Image();
        image.onload = function() {
          resolve(image);
        };
        image.onerror = function() {
          reject(new Error('Could not load image at ' + url));
        };
        image.src = url;
      });
    }
  eg:var getJSON = function(url) { // Ajax 的例子
      var promise = new Promise(function(resolve, reject){
        var client = new XMLHttpRequest();
        client.open("GET", url);
        client.onreadystatechange = handler;
        client.responseType = "json";
        client.setRequestHeader("Accept", "application/json");
        client.send();
        function handler() {
          if (this.readyState !== 4) {
            return;
          }
          if (this.status === 200) {
            resolve(this.response);
          } else {
            reject(new Error(this.statusText));
          }
        };
      });
      return promise;
    };
    getJSON("/posts.json").then(function(json) {
      console.log('Contents: ' + json);
    }, function(error) {
      console.error('出错了', error);
    });
    //如果调用resolve函数和reject函数时带有参数,那么它们的参数会被传递给回调函数
  eg:var p1 = new Promise(function (resolve, reject) {  // p1 的状态决定了p2 回调函数的调用
      setTimeout(() => reject(new Error('fail')), 3000)
    })
    var p2 = new Promise(function (resolve, reject) {
      setTimeout(() => resolve(p1), 1000)
    })
    p2.then(result => console.log(result)).catch(error => console.log(error))
    // Error: fail
3.Promise.prototype.then();返回的是一个新的Promise实例
  1.Promise实例的方法,两个参数为函数,第二个可选
  eg:getJSON("/post/1.json").then(
      post => getJSON(post.commentURL)
    ).then(
      comments => console.log("Resolved: ", comments),
      err => console.log("Rejected: ", err)
    );
    // 第一个then方法返回一个新的Promise实例,当状态为resolved时调用第二个then方法的第一个回调函数,否则调用第二个回调函数
4.Promise.prototype.catch();用于指定发生错误时的回调函数,捕获异常和错误
  1.Promise.prototype.catch方法是Promise.prototype.then(null, rejection)的别名
  eg:// 写法一
    var promise = new Promise(function(resolve, reject) {
      try {
        throw new Error('test');
      } catch(e) {
        reject(e);
      }
    });
    promise.catch(function(error) {
      console.log(error);
    });
    // 写法二
    var promise = new Promise(function(resolve, reject) {
      reject(new Error('test'));
    });
    promise.catch(function(error) {
      console.log(error);
    });

5.Promise.all();将多个 Promise 实例,包装成一个新的 Promise 实例
  var p = Promise.all([p1, p2, p3]);
  1.p的状态:
    1.只有p1、p2、p3的状态都变成fulfilled,p的状态才会变成fulfilled,此时p1、p2、p3的返回值组成一个数组,传递给p的回调函数
    2.只要p1、p2、p3之中有一个被rejected,p的状态就变成rejected,此时第一个被reject的实例的返回值,会传递给p的回调函数
    eg:// 生成一个Promise对象的数组
      var promises = [2, 3, 5, 7, 11, 13].map(function (id) {
        return getJSON('/post/' + id + ".json");
      });
      Promise.all(promises).then(function (posts) {
        // ...
      }).catch(function(reason){
        // ...
      });
    eg:const databasePromise = connectDatabase();
      const booksPromise = databasePromise.then(findAllBooks);
      const userPromise = databasePromise.then(getCurrentUser);
      Promise.all([
        booksPromise,
        userPromise
      ]).then(([books, user]) => pickTopRecommentations(books, user));
    eg:const p1 = new Promise((resolve, reject) => {
        resolve('hello');
      }).then(result => result).catch(e => e);
      const p2 = new Promise((resolve, reject) => {
        throw new Error('报错了');
      }).then(result => result).catch(e => e);
      Promise.all([p1, p2])
      .then(result => console.log(result))
      .catch(e => console.log(e));
      // ["hello", Error: 报错了]
6.Promise.race();将多个Promise实例,包装成一个新的Promise实例
  1.var p = Promise.race([p1, p2, p3]);
    // 只要p1、p2、p3之中有一个实例率先改变状态,p的状态就跟着改变,那个率先改变的 Promise 实例的返回值,就传递给p的回调函数
    eg:const p = Promise.race([ 
        fetch('/resource-that-may-take-a-while'),
        new Promise(function (resolve, reject) {
          setTimeout(() => reject(new Error('request timeout')), 5000)
        })
      ]);
      p.then(response => console.log(response));
      p.catch(error => console.log(error));
      // 如果5秒之内fetch方法无法返回结果,变量p的状态就会变为rejected,从而触发catch方法指定的回调函数
7.Promise.resolve();将现有对象转为Promise对象
  Promise.resolve('foo'); //等价于
  new Promise(resolve => resolve('foo'));
  1.参数是一个Promise实例:不做修改,原封不动返回实例
  2.参数是一个thenable对象:将这个对象转为Promise对象,然后就立即执行thenable对象的then方法
    eg:let thenable = {
        then: function(resolve, reject) {
          resolve(42);
        }
      };
      let p1 = Promise.resolve(thenable);
      p1.then(function(value) {
        console.log(value);  // 42
      });
  3.参数不是具有then方法的对象,或根本就不是对象:返回一个新的Promise对象,状态为Resolved
    eg:var p = Promise.resolve('Hello');
      p.then(function (s){
        console.log(s)
      });
      // Hello
  4.不带有任何参数:直接返回一个Resolved状态的Promise对象
8.Promise.reject();返回一个新的 Promise 实例,该实例的状态为rejected
  eg:var p = Promise.reject('出错了');
    // 等同于
    var p = new Promise((resolve, reject) => reject('出错了'))
    p.then(null, function (s) {
      console.log(s)
    });
    // 出错了
9.附加方法:
  1.done();处于回调链的尾端，保证抛出任何可能出现的错误
    eg:asyncFunc().then(f1).catch(r1).then(f2).done();
    eg:Promise.prototype.done = function (onFulfilled, onRejected) {
        this.then(onFulfilled, onRejected)
          .catch(function (reason) {
            // 抛出一个全局错误
            setTimeout(() => { throw reason }, 0);
          });
      };
  2.finally();指定不管Promise对象最后状态如何,都会执行的操作
    1.与done()的区别:接收一个回调函数,不管怎样都会执行
      eg:server.listen(0).then(function () {
          // run test
        }).finally(server.stop);
      eg:Promise.prototype.finally = function (callback) {
          let P = this.constructor;
          return this.then(
            value  => P.resolve(callback()).then(() => value),
            reason => P.resolve(callback()).then(() => { throw reason })
          );
        };
10.应用:
  1.加载图片:
    eg:const preloadImage = function (path) {
        return new Promise(function (resolve, reject) {
          var image = new Image();
          image.onload  = resolve;
          image.onerror = reject;
          image.src = path;
        });
      };
  2.Generator函数与Promise的结合:
    eg:function getFoo () {
        return new Promise(function (resolve, reject){
          resolve('foo');
        });
      }
      var g = function* () {
        try {
          var foo = yield getFoo();
          console.log(foo);
        } catch (e) {
          console.log(e);
        }
      };
      function run (generator) {
        var it = generator();
        function go(result) {
          if (result.done) return result.value;
          return result.value.then(function (value) {
            return go(it.next(value));
          }, function (error) {
            return go(it.throw(error));
          });
        }
        go(it.next());
      }
      run(g);
11.Promise.try();
