1.Set:类似于数组的数据结构,其中的成员的值都是唯一的,没有重复的值
  1.构造函数:const s = new Set();
    eg:const s = new Set();
      [2, 3, 5, 4, 5, 2, 2].forEach(x => s.add(x));
      for (let i of s) {
        console.log(i);
      }
      // 2 3 5 4
      // 例一:参数为数组
      const set = new Set([1, 2, 3, 4, 4]); 
      [...set]
      // [1, 2, 3, 4]
      // 例二:参数为数组
      const items = new Set([1, 2, 3, 4, 5, 5, 5, 5]);
      items.size // 5
      // 例三:参数为类数组对象
      function divs () {
        return [...document.querySelectorAll('div')];
      }
      const set = new Set(divs());
      set.size // 56
      // 类似于
      divs().forEach(div => set.add(div));
      set.size // 56
  2.属性和方法:
    1.属性:
      Set.prototype.constructor:构造函数
      Set.prototype.size:返回Set实例的成员总数
    2.方法:
      1.操作方法:
        Set add(value):添加某个值,返回Set结构本身
        boolean delete(value):删除某个值,返回一个布尔值,表示是否删除成功
        boolean has(value):返回一个布尔值,表示该值是否为Set结构的成员
        null clear();清除所有成员,没有返回值
        eg:s.add(1).add(2).add(2);
            // 注意2被加入了两次
            s.size // 2
            s.has(1) // true
            s.has(2) // true
            s.has(3) // false
            s.delete(2);
            s.has(2) // false
      2.遍历方法:
        keys():返回键名的遍历器
        values():返回键值的遍历器
        entries():返回键值对的遍历器
        forEach():使用回调函数遍历每个成员
        eg:let set = new Set(['red', 'green', 'blue']);
          // Set结构没有键名,keys和values方法的行为完全一样
          for (let item of set.keys()) {
            console.log(item);
          }
          // red
          // green
          // blue
          for (let item of set.values()) {
            console.log(item);
          }
          // red
          // green
          // blue
          for (let item of set.entries()) {
            console.log(item);
          }
          // ["red", "red"]
          // ["green", "green"]
          // ["blue", "blue"]
          let set = new Set([1, 2, 3]);
          set.forEach((value, key) => console.log(value * 2) )
          // 2
          // 4
          // 6
    3.遍历的应用:
      1.... 和 for...of
        eg:let set = new Set(['red', 'green', 'blue']);
          let arr = [...set];
          // ['red', 'green', 'blue']
          // 扩展运算符和Set结构结合,可以去除数组中的重复成员
          let arr = [3, 5, 2, 2, 5, 5];
          let unique = [...new Set(arr)];
          // [3, 5, 2]
      2.数组的map和filter方法也可以用在Set结构中
        eg:let set = new Set([1, 2, 3]);
          set = new Set([...set].map(x => x * 2));
          // 返回Set结构：{2, 4, 6}
          let set = new Set([1, 2, 3, 4, 5]);
          set = new Set([...set].filter(x => (x % 2) == 0));
          // 返回Set结构：{2, 4}
2.WeakSet:与Set结构类似;
  1.区别:
    1.WeakSet的成员只能是对象,而不能是其他类型的值
    2.不计入垃圾回收机制
  2.构造函数:
    eg:const a = [[1, 2], [3, 4]];
      const ws = new WeakSet(a);
      // WeakSet {[1, 2], [3, 4]} ,数组a的成员是对象,成为weakSet的成员
      const b = [3, 4];
      const ws = new WeakSet(b); // b的成员不是对象,加入weakSet报错
      // Uncaught TypeError: Invalid value used in weak set(…)
  3.方法:
    1.WeakSet.prototype.add(value);向WeakSet实例添加一个新成员
    2.WeakSet.prototype.delete(value);清除WeakSet实例的指定成员
    3.WeakSet.prototype.has(value);判断WeakSet实例是否包含指定成员
      eg:const ws = new WeakSet();
        const obj = {};
        const foo = {};
        ws.add(window);
        ws.add(obj);
        ws.has(window); // true
        ws.has(foo);    // false
        ws.delete(window);
        ws.has(window);    // false 
  4.不能遍历:因为成员都是弱引用,随时可能消失,遍历机制无法保证成员的存在 
    eg:const foos = new WeakSet()
        class Foo {
          constructor() {
            foos.add(this)
          }
          method () {
            if (!foos.has(this)) {
              throw new TypeError('Foo.prototype.method 只能在Foo的实例上调用！');
            }
          }
        }
3.Map:Object只支持使用字符串作为键名,Map提供了'值-值'的对应关系
  1.构造函数:
    eg:const m = new Map();
      const o = {p: 'Hello World'};
      m.set(o, 'content')
      m.get(o) // "content"
      m.has(o) // true
      m.delete(o) // true
      m.has(o) // false
      // 参数接收一个二维数组,该数组的成员是一个个表示键值对的数组
      const map = new Map([
        ['name', '张三'],
        ['title', 'Author']
      ]);
      map.size // 2
      map.has('name') // true
      map.get('name') // "张三"
      map.has('title') // true
      map.get('title') // "Author"、
      // set和map可以生成新的map
      const set = new Set([
        ['foo', 1],
        ['bar', 2]
      ]);
      const m1 = new Map(set);
      m1.get('foo') // 1
      const m2 = new Map([['baz', 3]]);
      const m3 = new Map(m2);
      m3.get('baz') // 3
  2.属性和操作方法:
    Map.prototype.size;返回Map结构的成员总数;
      eg:const map = new Map();
        map.set('foo', true);
        map.set('bar', false);
        map.size // 2
    Map.prototype.set(key,value);设置键名并返回Map结构
      eg:const m = new Map();
        m.set('edition', 6)        // 键是字符串
        m.set(262, 'standard')     // 键是数值
        m.set(undefined, 'nah')    // 键是 undefined
    Map.prototype.get(key);获取指定key对应的value,未找到返回undefined
      eg:const m = new Map();
        const hello = function() {console.log('hello');};
        m.set(hello, 'Hello ES6!') // 键是函数
        m.get(hello)  // Hello ES6!
    Map.prototype.has(key);判断Map结构是否包含指定key;返回boolean
      eg:const m = new Map();
        m.set('edition', 6);
        m.set(262, 'standard');
        m.set(undefined, 'nah');
        m.has('edition')     // true
        m.has('years')       // false
        m.has(262)           // true
        m.has(undefined)     // true
    Map.prototype.delete(key);删除指定key,返回boolean
      eg:const m = new Map();
        m.set(undefined, 'nah');
        m.has(undefined)     // true
        m.delete(undefined)
        m.has(undefined)       // false
    Map.prototype.clear();清除所有成员;
      eg:let map = new Map();
        map.set('foo', true);
        map.set('bar', false);
        map.size // 2
        map.clear()
        map.size // 0
  3.遍历方法:
    keys();返回键名的遍历器;
    values();返回键值的遍历器;
    entries();返回所有成员的遍历器;
    forEach();遍历Map结构的所有成员;
    Map结构转为数组结构:使用扩展运算符...
      eg:const map = new Map([
          [1, 'one'],
          [2, 'two'],
          [3, 'three'],
        ]);
        [...map.keys()]
        // [1, 2, 3]
        [...map.values()]
        // ['one', 'two', 'three']
        [...map.entries()]
        // [[1,'one'], [2, 'two'], [3, 'three']]
        [...map]
        // [[1,'one'], [2, 'two'], [3, 'three']]      
  4.与其他数据结构的互相转换:
    1.Map结构转为数组:使用扩展运算符...
      eg:const myMap = new Map()
          .set(true, 7)
          .set({foo: 3}, ['abc']);
        [...myMap]
        // [ [ true, 7 ], [ { foo: 3 }, [ 'abc' ] ] ]
    2.数组转为Map:使用Map构造函数
      eg:new Map([
          [true, 7],
          [{foo: 3}, ['abc']]
        ])
        // Map {
        //   true => 7,
        //   Object {foo: 3} => ['abc']
        // }
    3.Map结构转为对象:如果Map的键都是字符串可以转为对象
      eg:function strMapToObj(strMap) {
          let obj = Object.create(null);
          for (let [k,v] of strMap) {
            obj[k] = v;
          }
          return obj;
        }
        const myMap = new Map()
          .set('yes', true)
          .set('no', false);
        strMapToObj(myMap)
        // { yes: true, no: false }
    4.对象转为Map结构:
      eg:function objToStrMap(obj) {
          let strMap = new Map();
          for (let k of Object.keys(obj)) {
            strMap.set(k, obj[k]);
          }
          return strMap;
        }
        objToStrMap({yes: true, no: false})
        // Map {"yes" => true, "no" => false}
    5.Map结构转为JSON:
      1.Object(JSON):Map结构的键名都是字符串
        eg:function strMapToJson(strMap) {
            return JSON.stringify(strMapToObj(strMap));
          }
          let myMap = new Map().set('yes', true).set('no', false);
          strMapToJson(myMap)
          // '{"yes":true,"no":false}'
      2.Array(JSON):Map结构的键名有非字符串
        eg:function mapToArrayJson(map) {
            return JSON.stringify([...map]);
          }
          let myMap = new Map().set(true, 7).set({foo: 3}, ['abc']);
          mapToArrayJson(myMap)
          // '[[true,7],[{"foo":3},["abc"]]]'
    6.JSON转为Map:
      1.正常情况:所有键名都是字符串
        eg:function jsonToStrMap(jsonStr) {
            return objToStrMap(JSON.parse(jsonStr));
          }
          jsonToStrMap('{"yes": true, "no": false}')
          // Map {'yes' => true, 'no' => false}
      2.特殊情况:JSON为数组,每个成员又是一个有两个成员的数组;
        eg:function jsonToMap(jsonStr) {
            return new Map(JSON.parse(jsonStr));
          }
          jsonToMap('[[true,7],[{"foo":3},["abc"]]]')
          // Map {true => 7, Object {foo: 3} => ['abc']}
4.WeakMap:与Map结构类似;
  1.区别:
    1.WeakMap只接受对象作为键名(null除外),不接受其他类型的值作为键名
    2.WeakMap的键名所指向的对象,不计入垃圾回收机制
  1.构造函数:
    eg:// WeakMap 可以使用 set 方法添加成员
      const wm1 = new WeakMap();
      const key = {foo: 1};
      wm1.set(key, 2);
      wm1.get(key) // 2
      // WeakMap 也可以接受一个数组，
      // 作为构造函数的参数
      const k1 = [1, 2, 3];
      const k2 = [4, 5, 6];
      const wm2 = new WeakMap([[k1, 'foo'], [k2, 'bar']]);
      wm2.get(k2) // "bar"
      const map = new WeakMap();
      map.set(1, 2)
      // TypeError: 1 is not an object!
      map.set(Symbol(), 2)
      // TypeError: Invalid value used as weak map key
      map.set(null, 2)
      // TypeError: Invalid value used as weak map key
  2.方法:
    Map get(key);获取指定key对应的value
    Map set(key,value);添加某个值
    boolean has(key);判断Map结构是否包含指定key
    boolean delete(key);删除指定key
  3.用途:Dom节点作为键名,绑定监听事件更新状态,Dom节点删除,该状态自动消失
    eg:let myElement = document.getElementById('logo');
      let myWeakmap = new WeakMap();
      myWeakmap.set(myElement, {timesClicked: 0});
      myElement.addEventListener('click', function() {
        let logoData = myWeakmap.get(myElement);
        logoData.timesClicked++;
      }, false);
