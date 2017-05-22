1.Array.from():将两类对象转换成真正的数组:类数组对象和可遍历的对象(ES6新增的set和map)
  eg:let arrayLike = {
      '0': 'a',
      '1': 'b',
      '2': 'c',
      length: 3
    };
    // ES5的写法
    var arr1 = [].slice.call(arrayLike); // ['a', 'b', 'c']
    // ES6的写法
    let arr2 = Array.from(arrayLike); // ['a', 'b', 'c']
2.Array.of():将一组值转换为数组;
  eg:Array.of(3, 11, 8) // [3,11,8]
      Array.of(3) // [3]
      Array.of(3).length // 1
3.数组示例的copyWithin:在当前数组内部,将指定位置的成员复制到其他位置(会覆盖原有成员),然后返回当前数组
  eg:Array.prototype.copyWithin(target, start = 0, end = this.length);
    1.target(必需):从该位置开始替换数据,
    2.start(可选):从该位置开始读取数据,默认为0,如果为负值,表示倒数。
    3.end (可选):到该位置前停止读取数据,默认等于数组长度,如果为负值,表示倒数
   [1, 2, 3, 4, 5].copyWithin(0, 3)
    // [4, 5, 3, 4, 5] 
4.数组实例的find()和findIndex():
  1.Array.prototype.find():找出第一个符合条件的数组成员
    eg:[1, 5, 10, 15].find(function(value, index, arr) {
        return value > 9;
      }) // 10
  2.Array.prototype.findIndex():返回第一个符合条件的数组成员的位置,如果所有成员都不符合条件,则返回-1
    eg:[1, 5, 10, 15].findIndex(function(value, index, arr) {
        return value > 9;
      }) // 2
5.数组实例的fill():使用给定值,填充一个数组
  eg:['a', 'b', 'c'].fill(7) // [7, 7, 7]
    new Array(3).fill(7)  // [7, 7, 7]
    ['a', 'b', 'c'].fill(7, 1, 2)  // ['a', 7, 'c']
    // 从1号位开始,向原数组填充7,到2号位之前结束
6.数组实例的entries()、keys()、values():遍历数组的方法
  1.Array.prototype.entries():对键值对的遍历
  2.Array.prototype.keys():对键的遍历
  3.Array.prototype.values():对值的遍历
  eg:for (let index of ['a', 'b'].keys()) {
      console.log(index);
    } // 0  // 1
    for (let elem of ['a', 'b'].values()) {
      console.log(elem);
    } // 'a' // 'b'
    for (let [index, elem] of ['a', 'b'].entries()) {
      console.log(index, elem);
    } // 0 "a" // 1 "b"
7.数组实例的includes():判断数组是否包含指定值;
  1.第二个参数可选,指定搜索的起始位置,默认从0开始,如果为负数,则倒数的位置,如果此时大于数组的长度,则重置为0
  eg:[1, 2, 3].includes(2);     // true
    [1, 2, 3].includes(4);     // false
    [1, 2, NaN].includes(NaN); // true
    [1, 2, 3].includes(3, 3);  // false
    [1, 2, 3].includes(3, -1); // true
8.数组的空位:数组的空位指,数组的某一个位置没有任何值
  1.ES5对空位的处理:
    forEach(), filter(), every() 和some()都会跳过空位。
    map()会跳过空位，但会保留这个值
    join()和toString()会将空位视为undefined,而undefined和null会被处理成空字符串
    eg:// forEach方法
      [,'a'].forEach((x,i) => console.log(i)); // 1
      // filter方法
      ['a',,'b'].filter(x => true) // ['a','b']
      // every方法
      [,'a'].every(x => x==='a') // true
      // some方法
      [,'a'].some(x => x !== 'a') // false
      // map方法
      [,'a'].map(x => 1) // [,1]
      // join方法
      [,'a',undefined,null].join('#') // "#a##"
      // toString方法
      [,'a',undefined,null].toString() // ",a,,"
  2.ES6则是明确将空位转为undefined