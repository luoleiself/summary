<?php 
1.数据类型:
	1.标量类型:
		1.boolean:true,false //不区分大小写
			false,0,0.0,"","0",[],{},NULL => false
		2.integer:
			NAN:is_NAN();
		3.float:
		4.string:
			1.'';单引号中的变量和特殊字符的转义序列不会被替换
			2."";
			3.heredoc: //PHP5.0
			$str = <<< "eot"
				this is a heredoc string ,$str variabled analysis;
eot
			4.nowdoc:结构类似于heredoc,其中不会被解析,适合嵌入PHP代码或大段文字,初始化类的属性或常量
			$str = <<< 'eot'
				this is a nowdoc string ,$str variable not analysis;
eot
			5.{} // PHP5.0
				1."{$str}";
				2."${str}";
				3."{$square->width}00"
				4."{$arr['key']}"; != "{$arr[key]}" //无效
				5."{${$name}}";
				6."{${getName()}}";
			6.可以用用花括号访问:
				$str = "foo";
				echo $str{2};
				echo $str[2];
	2.复合类型:
		1.array:一个有序映射,PHP不区分索引数组和关联数组
			1.定义:key:只能为integer/string,其他类型被强制类型转换,float舍去小数部分,boolean转换1/0,不合法的十进制数不会被转换,重复key名前面会被覆盖,
				1. $arr = array("foo" => "bar","bar" => "foo");
				2. $arr = ["foo" => "bar","bar" => "foo"]; //PHP 5.4
				3. $arr = [1 => "a","1" => "b",1.0 => "c",true => "d"]; //$arr[1] => "d"
				4. $arr = ["foo" => "bar","bar" => "foo",100 => -100,-100 => 100]; //索引数组和关联数组可以同时存在
				5. $arr = ["a","b",6 => "c","d"]; // 0 => "a",1 => "b",6 => "c",7 => "d" 
				6. $arr = ["a","b",6 => "c","d"]; // $arr[6] == $arr{6};
				7. $arr = ["a","b","c","d"]; // unset($arr[2]); // This removes the element from the array
				8. $arr = [1 => "a",2 => "b",3 => "c"]; // unset($arr[2]); $arr(1 => "a",2 => "c")  array_values($arr); //重建数组索引 $arr(0 => "a",1 => "c");
				9. $arr1 = &$arr; // 引用赋值
			2. function:
				1. unset($arr[2]);// 删除数组中指定的元素
				2. $arr1 = array_values($arr); // 重置数组的索引
				3. foreach ($arr as $key => $value) {} // 遍历数组
				4. $arr3 =  array_diff($arr1,$arr2); // 比较多个数组中的差异,返回值为一未包含值的数组,
		2.object: new obj;
	3.特殊类型:
		1.resource:是一种特殊变量,保存了到外部资源的一个引用,其他类型的值转换成资源类型没有意义,系统自动释放
		2.NULL:表示一个变量没有值,null
			1.(unset)$var; // 将一个变量转换为null但不会删除该变量或者unset其值,只是返回null
	4.伪类型:
		1.mixed:混合类型
		2.number:数字类型
		3.callback:回调类型
2.查看数据类型:
	1.var_dump(var);获取表达式的值和类型,返回值和数据类型
	2.gettype(var);获取表达式的类型,返回值为数据类型名
	3.is_int(var);判断表达式的数据类型,返回值为boolean
	4.settype(var);设置变量的数据类型,
3.全局变量:
	1. 全局变量
	2. 局部变量: 局部变量使用全局变量中的值,需要先声明局部变量为全局变量,global $a, $b;
	3. 超全局变量: $GLOBALS //$GLOBALS["$a"];// 获取全局变量$a的值
	4. 静态变量: 静态变量仅在局部函数域中存在,但当程序执行离开此作用域时,其值并不丢失,静态声明是在编译时解析的. // static $c;
		// static $a = 1+2; //报错,
	5.可变变量:	$a = "hello"; $$a = " World!"; echo "$a ${$a}"; // hello world!;
		var_dump($_SERVER["SERVER_NAME"]); // 请求地址名称
		echo "<br>";
		var_dump($_SERVER["SERVER_PORT"]); // 请求端口号
		echo "<br>";
		var_dump($_SERVER["SERVER_PROTOCOL"]); // 请求协议类型
		echo "<br>";
		var_dump($_SERVER["REQUEST_METHOD"]); // 请求方法
		echo "<br>";
		var_dump($_SERVER["QUERY_STRING"]); // 请求数据
		echo "<br>";
		var_dump($_SERVER["SCRIPT_NAME"]); // 脚本名称
4.常量:只能通过define定义,不能被重新定义或取消定义,没有作用域限制
	1. defined(name,value); // 定义常量,可以在程序任何地方定义常量,
	2. const CONSTANT = "hello world!"; // PHP 5.3， 只能用在程序开始之前,不能放在函数内定义,
	3. constant(name); // 获取指定常量的值,返回值为该常量值;
	4. defined(name); // 判断该常量是否被定义,返回值为boolean;
	5. get_defined_constants(); // 获取所有已经定义的常量的列表;返回值为array
	6. 预定义常量:
		1. __LINE__:文件中的当前行号;
		2. __FILE__:文件的完整路径及文件名;
		3. __DIR__:文件的目录;
		4. __FUNCTION__:函数名称
		5. __CLASS__:类的名称
		6. __TRAIT__:Trait的名字
		7. __METHOD__:类的方法名称
		8. __NAMESPACE__:当前命名空间名称
7. 运算符:
	1. 算术运算,位运算,逻辑运算,关系运算,赋值运算
	2. @错误控制符: $a = @3 / 0; // 忽略错误信息;
	3. 执行运算符: ``;将反引号中的内容作为外壳命令执行,并将输出信息返回,作用等同于shell_exec();不能再双引号中使用
	4. 字符串运算符: .;
	5. 数组运算符: +,== ,!=,<>,===,!==, // $a + $b;
	6. 类型运算符: instanceof: 判断当前对象是不是另一个对象的一个实例; $a instanceof MyClass;
8. 流程控制:
	1. declare:设定一段代码的执行指令,
	2. require:
	3. include:
	4. require_once:
	5. include_once:
	6. goto:
	7. 流程控制的替代语法:
		`<?php if ($a == 5): ?>
			A is equal to 5
		<?php endif; ?>`
9. 函数: PHP不支持函数重载,也不可能取消定义或者重定义已声明的函数,
	1. 用户自定义函数:
	2. 参数:按值传递,引用传递(&),默认参数(默认参数必须放在所有参数的最后面定义)
	3. 引用函数: function &fun(){}; $arr = &fun();
	4. 可变函数: $foo = "bar"; function bar(){}; $foo();
	5. 匿名函数:
10. 类和对象:


