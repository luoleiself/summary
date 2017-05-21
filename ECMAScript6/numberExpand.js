1.二进制和八进制的表示法:ES6提供的二进制和八进制数值新的写法
  1.二进制:0b/0B
  2.八进制:0o/0O
  eg:0b111110111 === 503 // true
    0o767 === 503 // true
  3.转十进制:
    eg:Number('0b111')  // 7
      Number('0o10')  // 8
2.Number.isFinite(),Number.isNan():
  1.Number.isFinite():用来检查一个数值是否为有限的(finite);
    eg:Number.isFinite(15); // true
      Number.isFinite(0.8); // true
      Number.isFinite(NaN); // false
      Number.isFinite(Infinity); // false
      Number.isFinite(-Infinity); // false
      Number.isFinite('foo'); // false
      Number.isFinite('15'); // false
      Number.isFinite(true); // false
  2.Number.isNaN():用来检查一个值是否为NaN;
    eg:Number.isNaN(NaN) // true
      Number.isNaN(15) // false
      Number.isNaN('15') // false
      Number.isNaN(true) // false
      Number.isNaN(9/NaN) // true
      Number.isNaN('true'/0) // true
      Number.isNaN('true'/'true') // true
3.Number.parseInt(),Number.parseFloat():ES6将全局方法parseInt()和parseFloat(),移植到Number对象上面,行为完全保持不变,逐步减少全局性方法,使得语言逐步模块化
  eg:// ES5的写法
    parseInt('12.34') // 12
    parseFloat('123.45#') // 123.45
    // ES6的写法
    Number.parseInt('12.34') // 12
    Number.parseFloat('123.45#') // 123.45
4.Number.isInteger():用来判断一个值是否为整数
  eg:Number.isInteger(25) // true
    Number.isInteger(25.0) // true
    Number.isInteger(25.1) // false
    Number.isInteger("15") // false
    Number.isInteger(true) // false
5.Number.EPSILON:常量,为浮点数计算，设置一个误差范围
6.安全整数和Number.isSafeInteger():
  1.js整数的精确表示范围:-2^53 ~ 2^53
  2.Number.isSafeInteger():用来判断一个整数是否落在这个范围之内
    eg:Number.isSafeInteger('a') // false
      Number.isSafeInteger(null) // false
      Number.isSafeInteger(NaN) // false
      Number.isSafeInteger(Infinity) // false
      Number.isSafeInteger(-Infinity) // false
      Number.isSafeInteger(3) // true
      Number.isSafeInteger(1.2) // false
      Number.isSafeInteger(9007199254740990) // true
      Number.isSafeInteger(9007199254740992) // false
7.Math对象的扩展:
  1.Math.trunc():去除一个数的小数部分,返回整数部分,首先调用Number方法,对于不能正常转换的值返回NAN
    eg:Math.trunc(4.1) // 4
      Math.trunc(4.9) // 4
      Math.trunc(-4.1) // -4
      Math.trunc(-4.9) // -4
      Math.trunc(-0.1234) // -0
      Math.trunc('123.456')
      // 123
      Math.trunc(NaN);      // NaN
      Math.trunc('foo');    // NaN
      Math.trunc();         // NaN
  2.Math.sign():用来判断一个数到底是正数、负数、还是零
    eg:Math.sign(-5) // -1
      Math.sign(5) // +1
      Math.sign(0) // +0
      Math.sign(-0) // -0
      Math.sign(NaN) // NaN
      Math.sign('foo'); // NaN
      Math.sign();      // NaN
  3.Math.cbrt():计算一个数的立方根
    eg:Math.cbrt(-1) // -1
      Math.cbrt(0)  // 0
      Math.cbrt(1)  // 1
      Math.cbrt(2)  // 1.2599210498948734
      Math.cbrt('8') // 2
      Math.cbrt('hello') // NaN
  4.Math.clz32():返回一个数的32位无符号整数形式有多少个前导0,只考虑整数部分
    eg:Math.clz32(0) // 32
      Math.clz32(1) // 31
      Math.clz32(1000) // 22
      Math.clz32(0b01000000000000000000000000000000) // 1
      Math.clz32(0b00100000000000000000000000000000) // 2
      Math.clz32() // 32
      Math.clz32(NaN) // 32
      Math.clz32(Infinity) // 32
      Math.clz32(null) // 32
      Math.clz32('foo') // 32
      Math.clz32([]) // 32
      Math.clz32({}) // 32
      Math.clz32(true) // 31
  5.Math.imul():返回两个数以32位带符号整数形式相乘的结果,返回的也是一个32位的带符号整数
    eg:Math.imul(2, 4)   // 8
      Math.imul(-1, 8)  // -8
      Math.imul(-2, -2) // 4
  6.Math.fround():返回一个数的单精度浮点数形式
    eg:Math.fround(0)     // 0
      Math.fround(1)     // 1
      Math.fround(1.337) // 1.3370000123977661
      Math.fround(1.5)   // 1.5
      Math.fround(NaN)   // NaN
  7.Math.hypot():返回所有参数的平方和的平方根
    eg:Math.hypot(3, 4);        // 5
      Math.hypot(3, 4, 5);     // 7.0710678118654755
      Math.hypot();            // 0
      Math.hypot(NaN);         // NaN
      Math.hypot(3, 4, 'foo'); // NaN
      Math.hypot(3, 4, '5');   // 7.0710678118654755
      Math.hypot(-3);          // 3
  8.对数方法:
    1.Math.expm1():返回ex - 1,即Math.exp(x) - 1
      eg:Math.expm1(-1) // -0.6321205588285577
        Math.expm1(0)  // 0
        Math.expm1(1)  // 1.718281828459045
    2.Math.log1p():方法返回1 + x的自然对数,即Math.log(1 + x).如果x小于-1,返回NaN
      eg:Math.log1p(1)  // 0.6931471805599453
        Math.log1p(0)  // 0
        Math.log1p(-1) // -Infinity
        Math.log1p(-2) // NaN
    3.Math.log10():返回以10为底的x的对数,如果x小于0,则返回NaN
      eg:Math.log10(2)      // 0.3010299956639812
        Math.log10(1)      // 0
        Math.log10(0)      // -Infinity
        Math.log10(-2)     // NaN
        Math.log10(100000) // 5
    4.Math.log2():返回以2为底的x的对数,如果x小于0,则返回NaN
      eg:Math.log2(3)       // 1.584962500721156
        Math.log2(2)       // 1
        Math.log2(1)       // 0
        Math.log2(0)       // -Infinity
        Math.log2(-2)      // NaN
        Math.log2(1024)    // 10
        Math.log2(1 << 29) // 29
  9.三角函数方法:
    Math.sinh(x) 返回x的双曲正弦（hyperbolic sine）
    Math.cosh(x) 返回x的双曲余弦（hyperbolic cosine）
    Math.tanh(x) 返回x的双曲正切（hyperbolic tangent）
    Math.asinh(x) 返回x的反双曲正弦（inverse hyperbolic sine）
    Math.acosh(x) 返回x的反双曲余弦（inverse hyperbolic cosine）
    Math.atanh(x) 返回x的反双曲正切（inverse hyperbolic tangent）
8.Math.signbit():判断一个数的符号位是否设置
  eg:Math.signbit(2) //false
    Math.signbit(-2) //true
    Math.signbit(0) //false
    Math.signbit(-0) //true
9.指数运算符:**
  eg:2 ** 2 // 4
    2 ** 3 // 8
    let a = 1.5;
    a **= 2;
    // 等同于 a = a * a;
    let b = 4;
    b **= 3;
    // 等同于 b = b * b * b;
    
