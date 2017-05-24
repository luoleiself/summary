1.属性的简洁表示法:ES6允许直接写入变量和函数,作为对象的属性和方法
  eg:var foo = 'bar';
    var baz = {foo};
    baz // {foo: "bar"}
    // 等同于
    var baz = {foo: foo};
    var o = {
      method() {
        return "Hello!";
      }
    };
    // 等同于
    var o = {
      method: function() {
        return "Hello!";
      }
    };
    var birth = '2000/01/01';
    var Person = {
      name: '张三',
      //等同于birth: birth
      birth,
      // 等同于hello: function ()...
      hello() { console.log('我的名字是', this.name); }
    };
2.属性名表达式:ES6中支持两种写法,5仅支持1,属性表达式和简洁表示法不能同时使用
  1.标识符属性:
  2.表达式属性:
    eg:let propKey = 'foo';
      let obj = {
        [propKey]: true,
        ['a' + 'bc']: 123
      };
      let obj = {
        ['h' + 'ello']() {
          return 'hi';
        }
      };
      obj.hello() // hi
3.方法的neme属性:返回方法名;
  eg:const person = {
      sayName() {
        console.log('hello!');
      },
    };
    person.sayName.name   // "sayName"
4.Object.is():判断两个值是否相等
  eg:Object.is('foo', 'foo')
    // true
    Object.is({}, {})
    // false
5.Object.assign():将源对象（source）的所有可枚举属性,复制到目标对象（target）
  1.用途:
    1.为对象添加属性
    2.为对象添加方法
    3.克隆对象
    4.合并多个对象
    5.为属性指定默认值
    eg:var target = { a: 1 };
      var source1 = { b: 2 };
      var source2 = { c: 3 };
      Object.assign(target, source1, source2);
      target // {a:1, b:2, c:3}
6.属性的可枚举性:
  1.ES5中三个操作会忽略enumerable为false的属性
    1.for...in循环：只遍历对象自身的和继承的可枚举的属性
    2.Object.keys()：返回对象自身的所有可枚举的属性的键名
    3.JSON.stringify()：只串行化对象自身的可枚举的属性
7.属性的遍历:
  1.for..in:循环遍历对象自身和继承的可枚举的属性
  2.Object.keys(obj):返回一个数组,包括对象自身的(不含继承)所有可枚举属性
  3.Object.getOwnPropertyNames(obj):返回一个数组,包含对象自身的所有可枚举属性(包含继承)
  4.Object.getOwnPropertySymbols(obj):返回一个数组,包含对象自身所有的Symbol属性
  5.Reflect.ownKeys(obj):返回一个数组,包含自身所有属性(包含Symbol、不可枚举属性)
8.__proto___属性,Object.setPrototypeOf(),Object.getPrototypeOf():
  1.__proto__:读取或设置当前对象的prototype对象
  2.Object.setPrototypeOf():设置一个对象的prototype对象;
  3.Object.getPrototypeOf():获取一个对象的prototype对象;
9.Object.keys(),Object.values(),Object.entries():
  1.Object.keys():返回一个数组,包含对象自身(不含继承)的所有可遍历的属性的键名
    eg:var obj = { foo: 'bar', baz: 42 };
      Object.keys(obj)
      // ["foo", "baz"]
  2.Object.values():返回一个数组,包含对象自身(不含继承)的所有可遍历的属性的键值
    eg:var obj = { 100: 'a', 2: 'b', 7: 'c' };
      Object.values(obj)
      // ["b", "c", "a"]
  3.Object.entries():返回一个数组,包含对象自身(不含继成)所有可遍历属性的键值对数组
10.对象的扩展运算符:...
  1.解构赋值:
    eg:let { x, y, ...z } = { x: 1, y: 2, a: 3, b: 4 };
      x // 1
      y // 2
      z // { a: 3, b: 4 }
  2.取出对象所有可遍历属性,拷贝到当前对象
    eg:let aClone = { ...a };
      // 等同于
      let aClone = Object.assign({}, a);
11.Object.getOwnPropertyDescriptors():返回指定对象所有自身属性（非继承属性）的描述对象
  eg:const obj = {
      foo: 123,
      get bar() { return 'abc' }
    };
    Object.getOwnPropertyDescriptors(obj)
    // { foo:
    //    { value: 123,
    //      writable: true,
    //      enumerable: true,
    //      configurable: true },
    //   bar:
    //    { get: [Function: bar],
    //      set: undefined,
    //      enumerable: true,
    //      configurable: true } }
12.Null传导运算符:判断对象属性是否存在(提案)
  eg:const firstName = (message
      && message.body
      && message.body.user
      && message.body.user.firstName) || 'default';
    const firstName = message?.body?.user?.firstName || 'default';
