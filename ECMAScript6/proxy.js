1.概述:用于修改某些操作的默认行为,等同于在语言层面作出修改,对编程语言进行编程
  1.构造函数:var proxy = new Proxy(target,handle);
    1.target:表示要拦截的目标对象
    2.handle:用来定制拦截行为
  eg:var obj = new Proxy({}, {
    get: function (target, key, receiver) {
      console.log(`getting ${key}!`);
      return Reflect.get(target, key, receiver);
    },
    set: function (target, key, value, receiver) {
      console.log(`setting ${key}!`);
      return Reflect.set(target, key, value, receiver);
    }
  });
  2.get(target,propKey,receiver);拦截对象属性的获取
  3.set(target,propKey,value,receiver);拦截对象属性的设置,返回一个bool值
  4.has(target,propKey);拦截propKey in proxy的操作,返回一个bool值
  5.deleteProperty(target,propKey);拦截delete proxy[propKey]的操作,返回一个bool值
  6.ownKeys(target);拦截获取自身属性的操作,返回一个数组,包含目标对象自身的属性的属性名
  7.getOwnPropertyDescriptor(target,propKey);拦截获取目标对象属性描述,返回属性的描述对象
  8.defineProperty(target,propKey,propDesc);拦截对象的定义属性操作,返回一个bool值
  9.preventExtensions(target);拦截Object.preventExtensions(proxy),返回一个bool值
  10.getPrototypeOf(target);拦截Object.getPrototypeOf(proxy);返回一个对象
  11.isExtensible(target);拦截Object.isExtensible(proxy);返回一个bool值
  12.setPrototypeOf(target,proto);拦截Object.setPrototypeOf(proxy,proto);返回一个bool值
  13.apply(target,object,args);拦截Proxy实例作为函数调用的操作
  14.construct(target,args);拦截Proxy实例作为构造函数调用的操作,eg:new Proxy(...args);
2.Proxy的实例方法:
  1.get():
    eg:var proxy = new Proxy({name:"张三"}, {
        get: function(target, property) {
          if (property in target) {
            return target[property];
          } else {
            throw new ReferenceError("Property \"" + property + "\" does not exist.");
          }
        }
      });
      proxy.name // "张三"
      proxy.age // 抛出一个错误
  2.set():
    eg:let validator = {
      set: function(obj, prop, value) {
        if (prop === 'age') {
          if (!Number.isInteger(value)) {
            throw new TypeError('The age is not an integer');
          }
          if (value > 200) {
            throw new RangeError('The age seems invalid');
          }
        }
        // 对于age以外的属性，直接保存
        obj[prop] = value;
      }
    };
    let person = new Proxy({}, validator);
    person.age = 100;
    person.age // 100
    person.age = 'young' // 报错
    person.age = 300 // 报错
  3.apply():
    eg:var target = function () { return 'I am the target'; };
      var handler = {
        apply: function () {
          return 'I am the proxy';
        }
      };
      var p = new Proxy(target, handler);
      p()
      // "I am the proxy"
  4.has():
    eg:var handler = {
      has (target, key) {
        if (key[0] === '_') {
          return false;
        }
        return key in target;
      }
    };
    var target = { _prop: 'foo', prop: 'foo' };
    var proxy = new Proxy(target, handler);
    '_prop' in proxy // false
  5.construct():
    eg:var p = new Proxy(function () {}, {
      construct: function(target, args) {
        console.log('called: ' + args.join(', '));
        return { value: args[0] * 10 };
      }
    });
    (new p(1)).value
    // "called: 1"
    // 10
  6.deleteProperty():
    eg:var handler = {
        deleteProperty (target, key) {
          invariant(key, 'delete');
          return true;
        }
      };
      function invariant (key, action) {
        if (key[0] === '_') {
          throw new Error(`Invalid attempt to ${action} private "${key}" property`);
        }
      }
      var target = { _prop: 'foo' };
      var proxy = new Proxy(target, handler);
      delete proxy._prop
      // Error: Invalid attempt to delete private "_prop" property
  7.defineProperty():
    eg:var handler = {
        defineProperty (target, key, descriptor) {
          return false;
        }
      };
      var target = {};
      var proxy = new Proxy(target, handler);
      proxy.foo = 'bar'
      // TypeError: proxy defineProperty handler returned false for property '"foo"'
  8.getOwnPropertyDescriptor():
    eg:var handler = {
        getOwnPropertyDescriptor (target, key) {
          if (key[0] === '_') {
            return;
          }
          return Object.getOwnPropertyDescriptor(target, key);
        }
      };
      var target = { _foo: 'bar', baz: 'tar' };
      var proxy = new Proxy(target, handler);
      Object.getOwnPropertyDescriptor(proxy, 'wat')
      // undefined
      Object.getOwnPropertyDescriptor(proxy, '_foo')
      // undefined
      Object.getOwnPropertyDescriptor(proxy, 'baz')
      // { value: 'tar', writable: true, enumerable: true, configurable: true }
  9.getPrototypeOf():
    eg:var proto = {};
      var p = new Proxy({}, {
        getPrototypeOf(target) {
          return proto;
        }
      });
      Object.getPrototypeOf(p) === proto // true
  10.isExtensible():
    eg:var p = new Proxy({}, {
        isExtensible: function(target) {
          console.log("called");
          return true;
        }
      });
      Object.isExtensible(p)
      // "called"
      // true
  11.ownKeys():
    eg:let target = {
        a: 1,
        b: 2,
        c: 3
      };
      let handler = {
        ownKeys(target) {
          return ['a'];
        }
      };
      let proxy = new Proxy(target, handler);
      Object.keys(proxy)
      // [ 'a' ]
  12.preventExtensions():
    eg:var p = new Proxy({}, {
        preventExtensions: function(target) {
          return true;
        }
      });
      Object.preventExtensions(p) // 报错
  13.setPrototypeOf():
    eg:var handler = {
        setPrototypeOf (target, proto) {
          throw new Error('Changing the prototype is forbidden');
        }
      };
      var proto = {};
      var target = function () {};
      var proxy = new Proxy(target, handler);
      Object.setPrototypeOf(proxy, proto);
      // Error: Changing the prototype is forbidden
3.Proxy.revocable():返回一个可取消的 Proxy 实例
  eg:let target = {};
    let handler = {};
    let {proxy, revoke} = Proxy.revocable(target, handler);
    proxy.foo = 123;
    proxy.foo // 123
    revoke();
    proxy.foo // TypeError: Revoked
4.this 问题:目标对象内部的this关键字会指向 Proxy 代理
5.实例: we服务器客户端:对象可以拦截目标对象的任意属性
