1.字符串的Unicode表示法:仅限于\u0000 ~ \uFFFF之间的字符,超出范围需要使用两个双字节表示
2.codePointAt();返回超出\uFFFF表示范围的字符,
  1.charAt();无法读取整个字符
  2.charCodeAt();只能返回两个字节的值
    eg:var s = "𠮷";
      s.length // 2
      s.charAt(0) // ''
      s.charAt(1) // ''
      s.charCodeAt(0) // 55362
      s.charCodeAt(1) // 57271
      s.codePointAt(0) // 134071
3.String.fromCodePoint();从码点返回对应字符
  1.fromCharCode();
    eg:String.fromCodePoint(0x20BB7) // "𠮷"
      String.fromCodePoint(0x78, 0x1f680, 0x79) === 'x\uD83D\uDE80y' // true
4.字符串遍历器接口:for...of -> 能够识别大于\uFFFF范围的码点
  eg:for (let codePoint of 'foo') {
      console.log(codePoint)
    }
    // "f"
    // "o"
    // "o"
5.at();返回字符串中指定位置的字符,能够识别码点大于\uFFFF范围的字符;
  1.charAt();返回字符串指定位置的字符;
    eg:'abc'.charAt(0) // "a"
      '𠮷'.charAt(0) // "\uD842"
      'abc'.at(0) // "a"
      '𠮷'.at(0) // "𠮷"
6.normalize();用来将字符的不同表示方法统一为同样的形式,这称为Unicode正规化
  eg:'\u01D1'.normalize() === '\u004F\u030C'.normalize()  // true
7.includes(),startsWith(),endsWith(),
  1.indexOf();
  2.includes();返回布尔值,表示是否找到了参数字符串,支持第二个参数,表示开始搜索的位置
  3.startsWith();返回布尔值,表示参数字符串是否在源字符串的头部,支持第二个参数,表示开始搜索的位置
  4.endsWith();返回布尔值,表示参数字符串是否在源字符串的尾部,支持第二个参数,表示开始搜索的位置
    eg:var s = 'Hello world!';
      s.startsWith('world', 6) // true
      s.endsWith('Hello', 5) // true
      s.includes('Hello', 6) // false
8.repeat();返回一个新字符串,表示将原字符串重复n次
  1.参数如果是小数,则下取整
  2.参数如果是负数或者Ifinity,会报错
    eg:'x'.repeat(3) // "xxx"
      'hello'.repeat(2) // "hellohello"
      'na'.repeat(0) // ""
      'na'.repeat(2.9) // "nana"
      'na'.repeat(Infinity) // RangeError
      'na'.repeat(-1) // RangeError
9.padStart(),padEnd();字符串补全长度
  1.第一个参数指定字符串的最小长度,如果该参数小于或等于原字符串的长度,则返回原字符串
  2.第二个参数为用来补全的字符串,如果省略则默认使用空格补全长度
    eg:'x'.padStart(5, 'ab') // 'ababx'
      'x'.padStart(4, 'ab') // 'abax'
      'x'.padEnd(5, 'ab') // 'xabab'
      'x'.padEnd(4, 'ab') // 'xaba'
      'xxx'.padStart(2, 'ab') // 'xxx'
      'xxx'.padEnd(2, 'ab') // 'xxx'
      'abc'.padStart(10, '0123456789') // '0123456abc'
      'x'.padStart(4) // '   x'
      'x'.padEnd(4) // 'x   '
      '12'.padStart(10, 'YYYY-MM-DD') // "YYYY-MM-12"
      '09-12'.padStart(10, 'YYYY-MM-DD') // "YYYY-09-12"
10.模版字符串:增强版的字符串,用反引号(``)标识它可以当作普通字符串使用,也可以用来定义多行字符串,或者在字符串中嵌入变量
  eg:// 普通字符串
      `In JavaScript '\n' is a line-feed.`
      // 多行字符串
      `In JavaScript this is
        not legal.`
      console.log(`string text line 1
      string text line 2`);
      // 字符串中嵌入变量
      var name = "Bob", time = "today";
      `Hello ${name}, how are you ${time}?`
11.模版编译:			
12.标签模版:
13.String.raw();模版字符串转义
  eg:String.raw`Hi\n${2+3}!`;
    // "Hi\\n5!"
    String.raw`Hi\u000A!`;
    // 'Hi\\u000A!'
    String.raw`Hi\\n`
    // "Hi\\n"
