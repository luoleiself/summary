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
		1.array:
		2.object:
	3.特殊类型:
		1.resource:
		2.NULL:
	4.伪类型:
		1.mixed:混合类型
		2.number:数字类型
		3.callback:回调类型
2.查看数据类型:
	1.var_dump(var);获取表达式的值和类型,返回值和数据类型
	2.gettype(var);获取表达式的类型,返回值为数据类型名
	3.is_int(var);判断表达式的数据类型,返回值为boolean
	4.settype(var);设置变量的数据类型,




