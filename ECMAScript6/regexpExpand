1.RegExp构造函数:
  1.ES5中,第一个参数可以为字符串,第二个参数为正则表达式修饰符
    eg:var regex = new RegExp('xyz', 'i');
      // 等价于
      var regex = /xyz/i;
  2.ES5中,参数为一个正则表达式,此时不允许使用第二个参数
    eg:var regex = new RegExp(/xyz/i);
      // 等价于
      var regex = /xyz/i;
      var regex = new RegExp(/xyz/, 'i');
      // Uncaught TypeError: Cannot supply flags when constructing one RegExp from another
  3.ES6中,可以传入第二个参数覆盖第一个参数的修饰符
    eg:new RegExp(/abc/ig, 'i').flags
      // "i"
2.字符串的正则方法:ES6将这4个方法,在语言内部全部调用RegExp的实例方法,从而做到所有与正则相关的方法,全都定义在RegExp对象上
  String.prototype.match 调用 RegExp.prototype[Symbol.match]
  String.prototype.replace 调用 RegExp.prototype[Symbol.replace]
  String.prototype.search 调用 RegExp.prototype[Symbol.search]
  String.prototype.split 调用 RegExp.prototype[Symbol.split]
3.u修饰符:Unicode模式,用来处理码点大于\uFFFF的Unicode的字符
  eg:/^\uD83D/u.test('\uD83D\uDC2A')
    // false
    /^\uD83D/.test('\uD83D\uDC2A')
    // true
  1.点字符:含义是除了换行符以外的任意单个字符,对于码点大于0xFFFF的Unicode字符,点字符不能识别,必须加上u修饰符
    eg:var s = '𠮷';
      /^.$/.test(s) // false
      /^.$/u.test(s) // true
  2.Unicode字符表示法:ES6新增了使用大括号表示Unicode字符,这种表示法在正则表达式中必须加上u修饰符,才能识别
    eg:/\u{61}/.test('a') // false
      /\u{61}/u.test('a') // true
      /\u{20BB7}/u.test('𠮷') // true
  3.量词:使用u修饰符后,所有量词都会正确识别码点大于0xFFFF的Unicode字符
    eg:/a{2}/.test('aa') // true
      /a{2}/u.test('aa') // true
      /𠮷{2}/.test('𠮷𠮷') // false
      /𠮷{2}/u.test('𠮷𠮷') // true
  4.预定义模式:u修饰符也影响到预定义模式,能否正确识别码点大于0xFFFF的Unicode字符
    eg:/^\S$/.test('𠮷') // false
      /^\S$/u.test('𠮷') // true
4.y修饰符:粘连(sticky)修饰符
  1.和g修饰符的相同点:都是全局匹配,后一次匹配都从上一次匹配成功的下一个位置开始
  2.区别:
    1.g修饰符只要剩余位置中存在匹配就可
    2.y修饰符确保匹配必须从剩余的第一个位置开始,这也就是"粘连"的涵义
  eg:var s = 'aaa_aa_a';
    var r1 = /a+/g;
    var r2 = /a+/y;
    r1.exec(s) // ["aaa"]
    r2.exec(s) // ["aaa"]
    r1.exec(s) // ["aa"]
    r2.exec(s) // null
5.sticky属性:表示是否设置了y修饰符
  eg:var r = /hello\d/y;
    r.sticky // true
6.flags属性:返回正则表达式对象的修饰符
  eg:// ES5的source属性
    // 返回正则表达式的正文
    /abc/ig.source
    // "abc"
    // ES6的flags属性
    // 返回正则表达式的修饰符
    /abc/ig.flags
    // 'gi'
7.RegExp.escape():字符串转义,暂未列入标准
  eg:RegExp.escape('The Quick Brown Fox');
    // "The Quick Brown Fox"
    RegExp.escape('Buy it. use it. break it. fix it.');
    // "Buy it\. use it\. break it\. fix it\."
    RegExp.escape('(*.*)');
    // "\(\*\.\*\)"
8.s修饰符:dotAll模式,提案中
9.后行断言:
10.Unicode属性类:
