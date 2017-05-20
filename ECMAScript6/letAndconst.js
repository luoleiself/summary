1.let:  // 块变量声明
  1.块级变量: {	let a = 10;	}
  2.不存在声明提前:
    // var 的情况
    console.log(foo);
    var foo = 2;	// 输出undefined;
    // let 的情况
    console.log(bar);
    let bar = 2; // 报错ReferenceError
  3.暂时性死区:只要块级作用域内存在let命令,它所声明的变量就'绑定'(binding)这个区域,不再受外部的影响
    var temp = 123;
    if (true) {
      temp = 'abcd'; // ReferenceError
      let temp;
    }
  4.不允许重复声明:let不允许在相同作用域内,重复声明同一个变量
    function(){ // 报错
      let a = 10;
      var a = 1;
    }
    function func(arg) {	let arg; } // 报错
    function func(arg) {
      {	let arg; } // 不报错
    }	
  5.允许在块级作用域中声明函数:
    if(true){
      function func(){}
    }
2.do:块级作用域是一个语句,将多个操作封装在一起,没有返回值,do表达式可以获取结果
    let x = do{
      let t = 2;
      t * t + 1;
    }
3.const:声明一个只读的常量;
  1.一旦声明,常量的值不可改变
    const PI = 3.1415;
    PI // 3.1415
    PI = 3; // TypeError:  Assignment to constant variable
  2.一旦声明,就必须初始化值
    const foo; // SyntaxError: Missing initializer in const declaration
  3.声明复合类型:
    const foo = {};
    foo.prop = 123; // 添加属性;
  4.和let的意义相同:
    1.块级作用域
    2.不存在声明提前
	
