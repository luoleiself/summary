1.Iterator的概念:是一种接口,为各种不同的数据结构提供统一的访问机制
  1.为各种数据结构,提供一个统一的、简便的访问接口;
  2.使得数据结构的成员能够按某种次序排列;
  3.主要供for...of消费;
2.数据结构的默认Iterator接口:默认的Iterator接口部署在数据结构的Symbol.iterator属性;
  eg:let arr = ['a', 'b', 'c'];
    let iter = arr[Symbol.iterator]();
    iter.next() // { value: 'a', done: false }
    iter.next() // { value: 'b', done: false }
    iter.next() // { value: 'c', done: false }
    iter.next() // { value: undefined, done: true }
    // 每一次调用next方法,返回数据结构的当前成员的信息,value属性是当前成员的值,done属性表示遍历是否结束
3.调用Iterator接口的场合:
  1.解构赋值:对数组和Set结构进行解构赋值时,会默认调用Symbol.iterator方法
    eg:let set = new Set().add('a').add('b').add('c');
      let [x,y] = set;
      // x='a'; y='b'
      let [first, ...rest] = set;
      // first='a'; rest=['b','c'];
  2.扩展运算符（...）也会调用默认的iterator接口:
    eg:// 例一
      var str = 'hello';
      [...str] //  ['h','e','l','l','o']
      // 例二
      let arr = ['b', 'c'];
      ['a', ...arr, 'd']
      // ['a', 'b', 'c', 'd']
  3.yield*:yield*后面跟的是一个可遍历的结构，它会调用该结构的遍历器接口
    eg:let generator = function* () {
        yield 1;
        yield* [2,3,4];
        yield 5;
      };
      var iterator = generator();
      iterator.next() // { value: 1, done: false }
      iterator.next() // { value: 2, done: false }
      iterator.next() // { value: 3, done: false }
      iterator.next() // { value: 4, done: false }
      iterator.next() // { value: 5, done: false }
      iterator.next() // { value: undefined, done: true }
  4.其他场合:数组的遍历会调用遍历器接口,
    eg:for...of
      Array.from()
      Map(), Set(), WeakMap(), WeakSet()（比如new Map([['a',1],['b',2]])）
      Promise.all()
      Promise.race()
4.字符串的Iterator接口:一个类似数组的对象,也原生具有Iterator接口
  eg:var someString = "hi";
    typeof someString[Symbol.iterator]
    // "function"
    var iterator = someString[Symbol.iterator]();
    iterator.next()  // { value: "h", done: false }
    iterator.next()  // { value: "i", done: false }
    iterator.next()  // { value: undefined, done: true }
5.Iterator接口与Generator函数:
6.遍历器对象的return(),throw();
  1.如果一个对象在完成遍历前,需要清理或释放资源,就可以部署return方法
    eg:function readLinesSync(file) {
        return {
          next() {
            if (file.isAtEndOfFile()) {
              file.close();
              return { done: true };
            }
          },
          return() {
            file.close();
            return { done: true };
          },
        };
      }
7.for...of循环:for...of循环内部调用的是数据结构的Symbol.iterator方法

