变量的解构赋值:从数组和对象中提取值,对变量进行赋值,这被称为解构(Destructuring)
	1.只要等号右边的值不是对象或数组,就先将其转为对象
	2.等号右侧必须为可遍历的结构,否则报错
1.数组的解构赋值:
	1.本质上,这种写法属于'模式匹配',只要等号两边的模式相同,左边的变量就会被赋予对应的值
		eg:let [ a, b, c] = [ 1, 2, 3];
				a // 1
				b // 2
				c // 3
			let [ , , third] = [ 1, 2, 3];
				third // 3
			let [head, ...tail] = [1, 2, 3, 4];
				head // 1
				tail // [2, 3, 4]
			let [x, y, ...z] = ['a'];
				x // "a"
				y // undefined
				z // []
	2.不完全解构:即等号左边的模式,只匹配一部分的等号右边的数组
		eg:let [x, y] = [1, 2, 3];
				x // 1
				y // 2
			let [a, [b], d] = [1, [2, 3], 4];
				a // 1
				b // 2
				d // 4  
	3.如果解构不成功,变量的值为undefined
		eg:let [foo] = [];
				foo // undefined
			let [bar, foo] = [1];
				foo // undefined
	4.默认值:解构赋值允许指定默认值
		eg:let [foo = true] = [];
				foo // true
			let [x, y = 'b'] = ['a']; // x='a', y='b'
			let [x, y = 'b'] = ['a', undefined]; // x='a', y='b'
2.对象的解构赋值:
	1.变量名必须和对象的属性名相同:
		eg:let { bar, foo } = { foo: "aaa", bar: "bbb" };
				foo // "aaa"
				bar // "bbb"
			let { baz } = { foo: "aaa", bar: "bbb" };
				baz // undefined
	2.变量名和属性名不一致:foo是匹配的模式,baz才是变量
		eg:var { foo: baz } = { foo: 'aaa', bar: 'bbb' };
				baz // "aaa"
			let obj = { first: 'hello', last: 'world' };
			let { first: f, last: l } = obj;
				f // 'hello'
				l // 'world'
	3.解构的分解步骤:
		eg:let foo;
			let {foo} = {foo: 1}; // SyntaxError: Duplicate declaration "foo"
			let baz;
      let {bar: baz} = {bar: 1}; // SyntaxError: Duplicate declaration "baz"
    eg:let foo;
				({foo} = {foo: 1}); // 成功,此处被解析为一个代码块
			let baz;
				({bar: baz} = {bar: 1}); // 成功,此处被解析为一个代码块
	4.默认值:
		eg:var {x, y = 5} = {x: 1};
				x // 1
				y // 5
			var {x:y = 3} = {};
				y // 3
			var {x:y = 3} = {x: 5};
				y // 5			
3.字符串的解构赋值:解构之后被转换成一个类数组对象
	eg:const [a, b, c, d, e] = 'hello';
			a // "h"
			b // "e"
			c // "l"
			d // "l"
			e // "o"
		let {length : len} = 'hello';
			len // 5	
4.数值和布尔值的解构赋值:
	1.等号右边是数值和布尔值,则会先转为对象
		eg:let {toString: s} = 123;
				s === Number.prototype.toString // true
			let {toString: s} = true;
				s === Boolean.prototype.toString // true
	2.undefined 和 null:
		eg:let { prop: x } = undefined; // TypeError
			let { prop: y } = null; // TypeError
5.函数参数的解构赋值:
	1.正常模式:
		eg:function add([x, y]){
  			return x + y;
			}
			add([1, 2]); // 3
	2.默认值:
		eg:function move({x = 0, y = 0} = {}) {
  			return [x, y];
			}
			move({x: 3, y: 8}); // [3, 8]
			move({x: 3}); // [3, 0]
			move({}); // [0, 0]
			move(); // [0, 0]
6.圆括号问题:解构赋值中的圆括号的使用
	1.ES6的规则是,只要有可能导致解构的歧义,就不得使用圆括号
		1.变量声明语句中,不能带有圆括号
			eg:// 全部报错
				let [(a)] = [1];
				let {x: (c)} = {};
				let ({x: c}) = {};
				let {(x: c)} = {};
				let {(x): c} = {};
				let { o: ({ p: p }) } = { o: { p: 2 } };
		2.函数参数中,模式不能带有圆括号
			eg:// 报错
				function f([(z)]) { return z; }
		3.赋值语句中,不能将整个模式,或嵌套模式中的一层,放在圆括号之中
			eg:// 全部报错
				({ p: a }) = { p: 42 };
				([a]) = [5];
	2.可以使用圆括号的情况:
		1.赋值语句的非模式部分,可以使用圆括号
			eg:[(b)] = [3]; // 正确
				({ p: (d) } = {}); // 正确
				[(parseInt.prop)] = [3]; // 正确
			1.首先它们都是赋值语句,而不是声明语句
			2.它们的圆括号都不属于模式的一部分
			3.第一行语句中,模式是取数组的第一个成员,跟圆括号无关;第二行语句中,模式是p,而不是d;第三行语句与第一行语句的性质一致
7.用途:
	1.交换变量的值:
		eg:let x = 1;
			let y = 2;
			[x, y] = [y, x];
	2.从函数返回多个值:
		eg:// 返回一个数组
			function example() {
  			return [1, 2, 3];
			}
			let [a, b, c] = example();
			// 返回一个对象
			function example() {
			  return {
			    foo: 1,
			    bar: 2
			  };
			}
			let { foo, bar } = example();
	3.函数参数的定义:
		eg:// 参数是一组有次序的值
			function f([x, y, z]) { ... }
			f([1, 2, 3]);
			// 参数是一组无次序的值
			function f({x, y, z}) { ... }
			f({z: 3, y: 2, x: 1});
	4.提取JSON数据:
		eg:let jsonData = {
  			id: 42,
  			status: "OK",
  			data: [867, 5309]
			};
			let { id, status, data: number } = jsonData;
			console.log(id, status, number);
			// 42, "OK", [867, 5309]
	5.函数参数的默认值:
		eg:jQuery.ajax = function (url, {
			  async = true,
			  beforeSend = function () {},
			  cache = true,
			  complete = function () {},
			  crossDomain = false,
			  global = true,
			  // ... more config
			}) {
			  // ... do stuff
			};
	6.遍历Map结构:
		eg:var map = new Map();
			map.set('first', 'hello');
			map.set('second', 'world');
			for (let [key, value] of map) {
			  console.log(key + " is " + value);
			}
			// first is hello
			// second is worldeg:
	7.输入模块的指定方法:
		eg:const { SourceMapConsumer, SourceNode } = require("source-map");
