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
2.WeakSet:
3.Map:
4.WeakMap:
