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
			7. strlen($str); // 获取字符串的长度
			8. mb_strlen($str,encoding); // 获取字符串中中文长度,中文编码格式
			9. substr($str,startInd,length); // 字符串截取函数
			10. mb_substr(str, start,length, encoding); // 中文字符串的截取
			11. strpos($str,$searchStr,startInd,); // 字符串查找函数
			12. str_replace(要查找的字符串, 要替换的字符串, 被搜索的字符串, 替换进行计数[可选]); // 字符串替换函数
			13. sprintf(格式,要转化的字符串); //　字符串格式化
				eg:echo sprintf("%07.3f","100.1"); // 100.100;
			14. implode(分隔符[可选], 数组); // 字符串合并函数
				eg:implode(" ", ["hello","world"]); // "hello world"
			15. explode(分隔符[可选], 字符串); // 字符串分割函数
				eg:explode(",", "apple,banana"); // ["apple","banana"]
			16. addslashes($str); // 字符串转义函数;
				eg:echo addslashes("what's your name"); // waht\'s your name;
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
				10. array_change_key_case(array,[case]); // 将数组的所有的 KEY 都转换为大写或小写,case => CASE_LOWER(default),CASE_UPPER
					 eg:$a=array("a"=>"Cat","b"=>"Dog","c"=>"Horse");  
    					print_r(array_change_key_case($a,CASE_UPPER));
    		11. array_chunk(array,size,[preserve_key]); // 把一个数组分成新的数组块
    			// array:必需
    			// size:必需，规定每个新数组包括多少元素
    			// preserve_key:可选，true(保留键名），false(新索引）
    			eg:$a1=array("a"=>"Cat","b"=>"Dog","c"=>"Horse","d"=>"Cow");  
    				print_r(array_chunk($a1,2));  
    				$a2=array("a"=>"Cat","b"=>"Dog","c"=>"Horse","d"=>"Cow");  
    				print_r(array_chunk($a2,2,true));
			2. function:
				1. unset($arr[2]);// 删除数组中指定的元素
				2. $arr1 = array_values($arr); // 重置数组的索引
				3. foreach ($arr as $key => $value) {} // 遍历数组
				4. $arr3 =  array_diff($arr1,$arr2); // 比较多个数组中的差异,返回值为一未包含值的数组,
		2.object: new obj;
			1. 和数组的使用区别:
				1. 如果有两个变量同时赋值同一个数组时,只有使用引用赋值才能操作一个数组,才能保证数组的同一性,
				2. 如果有两个变量同时赋值同一个对象时,两个变量中存储的是同一个对象的物理地址标识符,
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
	<?php endif; ?>
`
9. 函数: PHP不支持函数重载,也不可能取消定义或者重定义已声明的函数,
	1. 用户自定义函数:
	2. 参数:按值传递,引用传递(&),默认参数(默认参数必须放在所有参数的最后面定义)
	3. 引用函数: function &fun(){}; $arr = &fun();
	4. 可变函数: $foo = "bar"; function bar(){}; $foo();
	5. 匿名函数:
10. 类和对象:
	1. 关键字:
		1. public:被定义的类成员可以在任何地方被访问,可以在子类中重新定义,
		2. protected:被定义的类成员可以被其自身以及子类和父类访问,可以在子类中重新定义
		3. private:被定义的类成员只能在被其定义的所在的类访问,不能子类中重新定义
			eg: class MyClass{
				public $public = "Public";
				protected $protected = "Protected";
				private $private = "Private";
				function propertyPrint(){
					echo $this -> public;
					echo $this -> protected;
					echo $this -> private;
				}
			}
			$obj = new MyClass();
			echo $obj -> public;
			echo $obj -> protected;
			echo $obj -> private;
			$obj -> propertyPrint();
		4. static:声明类属性和方法为静态,可以不实例化类而直接访问,
			1. 静态属性不能通过一个类已实例化的对象来访问(静态方法可以)
			2. 静态属性不能通过对象操作符访问:->
				eg:className::方法名/属性名
			3. 静态属性只能被初始化为文件或者常量,不能使用表达式,不能为一个变量或函数的返回值,不能指向一个对象
			4. 静态方法不需要实例化类就可以调用,伪变量$this在静态方法中不可用.
			5. 用静态方式调用一个非静态方法会导致E_STRICT级别的错误
			6. 静态方法中,$this伪变量不允许使用.可以使用self，parent，static在内部调用静态方法与属性。
				eg:class Car {
			    private static $speed = 10;
			    public static function getSpeed() {return self::$speed;}
			    public static function speedUp() {return self::$speed+=10;}
				}
				class BigCar extends Car {
			    public static function start() {
			        parent::speedUp();
			    }
				}
				BigCar::start();
				echo BigCar::getSpeed();
	2. 属性:类的变量成员,由public,protected,private关键字开头,然后跟一个普通的变量声明来组成,属性变量可以初始化,但必须是常数,
		eg:class Car{
			private function __construct(){ //将构造函数定义为私有
				echo "object create";
			}
			private static $_object = null;
			public static function getInstance(){// 内部方法可以调用私有方法,通过内部方法创建对象
				if(empty(self::$_object)){
					self::$_object = new Car();
				}
				return self::$_object;
			}
		}
		// $car = new Car(); // 这里不允许直接实例化对象
		$car = Car::getInstance(); //通过静态方法来获得一个实例
	3. 伪变量:$this:是一个到主叫对象的引用(通常是该方法所从属的对象,但如果是从第二个对象静态调用时也可能是另一个对象).
	4. 类常量:类中定义始终保持不变的值,在定义和使用时不需要使用$符号;
	5. ->:对象运算符,$this -> property;访问非静态属性;
	6. :: 范围解析操作符(Paamayim Nekudotayim),可以用于访问静态成员,类常量,覆盖类中的属性和方法
			eg:在类外部使用
				class MyClass{
					const CONST_VALUE = "A constant value";
				}
				$className = "MyClass";
				echo $className::CONST_VALUE; //PHP 5.3
				echo MyClass::CONST_VALUE;
			eg:在类内部使用
				class OtherClass extends MyClass{
					public static $my_static = 'static var';
					public static function doubleColon(){
						echo parent::CONST_VALUE . "\n";
						echo self::$my_static . "\n";
					}
				}
				$otherClass = "OtherClass";
				echo $otherClass::doubleColon(); // PHP 5.3
				OtherClass::doubleColon();
	7. extends:PHP 不支持多继承,一个类只能继承一个基类
	8. 构造函数和析构函数:
		1. 具有构造函数的类每次使用新对象时优先调用构造函数进行初始化工作,
			eg:class BaseClass{
				function __construct(){
					print "In BaseClass contructor\n";
				}
			}
			class SubClass extends BaseClass {
			  function __construct() {
		      parent::__construct();
		      print "In SubClass constructor\n";
			  }
			}
			class OtherSubClass extends BaseClass{}
			$obj1 = new BaseClass(); // In BaseClass contructor;
			$obj2 = new SubClass(); // In BaseClass contructor;// In SubClass contructor;
			$obj3 = new OtherSubClass(); // In BaseClass contructor;
		2. 析构函数:在某个对象的所有引用都被删除或者当对象被显式销毁时执行.
			eg:class MyDestructableClass{
				function __construct(){
					print "In constructor\n";
					$this -> name = "MyDestructableClass";
				}
				function __destruct(){
					print "Destroying" . $this -> name . "\n";
				}
			}
			$obj = new MyDestructableClass();
	9. 抽象类和抽象方法:任何一个类至少有一个方法为抽象方法,则该类就必须声明为抽象类,
			被定义为抽象的方法只是声明了其调用方式(参数),不能定义其具体的功能实现,
			子类继承抽象父类定义抽象方法并可以声明父类抽象方法中不存在的可选参数
			eg:abstract class AbstractClass{
				abstract protected function getValue();
				abstract protected function preFixValue($prefix);
				public function printOut(){
					echo $this -> getValue() . "\n";
				}
			}
			class ConcreateClass1 extends AbstractClass{
				protected function getValue(){
					return "ConcreateClass1";
				}
				protected function preFixValue($prefix,$gg){
					return "{$prefix}ConcreateClass1";
				}
			}
			class ConcreateClass2 extends AbstractClass{
				protected function getValue(){
					return "ConcreateClass2";
				}
				protected function preFixValue($prefix,$gg){
					return "{$prefix}ConcreateClass1";
				}
			}
			$class1 = new ConcreateClass1();
			$class1 -> print();
			echo $class1 -> preFixValue("FOO1_")."\n";
			$class2 = new ConcreateClass1();
			$class2 -> print();
			echo $class2 -> preFixValue("FOO2_")."\n";
	10. 抽象接口: 可以指定某个类必须实现哪些方法,但不需要定义这些方法的具体内容,所有的接口定义的方法都是公有的.
			1. 类中必须实现接口中定义的所有的方法,否则会报错.
			2. 类实现接口,必须使用和接口中定义的方法完全一致的方式,否则会报错.
			3. 类实现多个接口时,接口的方法不能重名.
			4. 接口中可以定义常量,接口常量和类常量的使用完全相同,但是不能被子类或子接口所覆盖.
				eg:interface iTemplate{
					public function setVariable($name,$var);
					public function getHtml($template);
				}
				class Template implements iTemplate{
					private $vars = [];
					public function setVariable($name,$var){
						$this -> $vars[$name] = $var;
					}
					public function getHtml($template){
						foreach ($this -> vars as $name => $value) {
							$template = str_replace('{'.$name.'}',$value,$template,$count);
						}
						return $template;
					}
				}
	11. Traits:是一种为类似 PHP 的单继承语言而准备的代码复用机制,应用类的成员不需要继承,
		1. trait不能通过它自身来实例化
		2. 从基类继承的成员被 trait 插入的成员所覆盖.优先顺序是来自当前类的成员覆盖了 trait 的方法,而 trait 则覆盖了被继承的方法
		  eg:class Base{
		  	public function sayHello(){echo "Hello";}
		  }
		  trait sayWorld{
		  	public function sayHello(){
		  		parent::sayHello();
		  		echo "World!";
		  	}
		  }
		  class　MyHelloWorld extends Base{
		  	use sayWorld;
		  }
		  $o = new MyHelloWorld();
		  $o -> sayHello();
		3. 冲突的解决:
			1. 使用 insteadof 操作符来明确指定使用冲突方法中的哪一个,允许排除掉其它方法.
			2. as 操作符可以将其中一个冲突的方法以另一个名称来引入.
				eg:trait A {
			    public function smallTalk() {echo 'a';}
			    public function bigTalk() {echo 'A';}
				}
				trait B {
			    public function smallTalk() {echo 'b';}
			    public function bigTalk() {echo 'B';}
				}
				class Talker {
			    use A, B {
			      B::smallTalk insteadof A;
			      A::bigTalk insteadof B;
			    }
				}
				class Aliased_Talker {
			    use A, B {
			      B::smallTalk insteadof A;
			      A::bigTalk insteadof B;
			      B::bigTalk as talk;
			    }
				}
			3. 使用as调整方法的访问控制.
				eg:trait HelloWorld {
			    public function sayHello() {echo 'Hello World!';}
				}
				// 修改 sayHello 的访问控制
				class MyClass1 {
			    use HelloWorld { sayHello as protected;}
				}
				// 给方法一个改变了访问控制的别名
				// 原版 sayHello 的访问控制则没有发生变化
				class MyClass2 {
				  use HelloWorld { sayHello as private myPrivateHello;}
				}
			4. trait 来组成 trait
				eg:trait Hello {
				  public function sayHello() {echo 'Hello ';}
				}
				trait World {
				  public function sayWorld() {echo 'World!';}
				}
				trait HelloWorld {use Hello, World;}
				class MyHelloWorld{use HelloWorld;}
				$o = new MyHelloWorld();
				$o->sayHello();
				$o->sayWorld();	
			5. trait 的抽象成员	
				trait Hello {
			    public function sayHelloWorld() {
			      echo 'Hello'.$this->getWorld();
			    }
			    abstract public function getWorld();
				}
				class MyHelloWorld {
			    private $world;
			    use Hello;
			    public function getWorld() {
			      return $this->world;
			    }
			    public function setWorld($val) {
			      $this->world = $val;
			    }
				}
			6. trait 的静态成员
				trait StaticExample {
				  public static function doSomething() {
				    return 'Doing something';
				  }
				  public function ionic(){
				  	static $i = 0;
				  	$c += 1;
				  	echo $c;
				  }
				}
				class Example {
				  use StaticExample;
				}
				Example::doSomething();
			7. trait 定义属性
				trait PropertiesTrait {
    			public $x = 1;
				}
				class PropertiesExample {
	    		use PropertiesTrait;
				}
				$example = new PropertiesExample;
				$example->x;
	12. spl_autoload_register():自动加载,
	13. 重载:动态的创建类的属性和方法,所有的重载方法都必须声明为public,(传统的重载:提供多个同名的类方法,但各方法的参数类型和个数不同)
		1. 属性重载只能在对象中进行.在静态方法中,这些魔术方法将不会被调用.
		2. 属性重载使用__set,__get,__isset,__unset这些魔术方法动态创建.
		3. 在对象中调用一个不可访问方法时,__call()会被调用.
			 用静态方式调用一个不可访问方法时,__callStatic()会被调用.
		eg1:class Car{
			private $ary = array();
			public function __set($key,$val){
				$this -> ary[$key] = $val;
			}
			public function __get($key){
				if(isset($this -> ary[$key])){
					return $this -> ary[$key]
				}
				return null;
			}
			public function __isset($key){
				if (isset($this -> ary[$key])) {
					return true;
				}
				return false;
			}
			public function __unset($key){
				unset($this -> ary[$key]);
			}
		}
		$car = new Car();
		$car -> name = "汽车";
		echo $car -> name;
		eg2:class Car{
			public $speed = 10;
			public function __call($name,$args){
				if($name == "speedUp"){
					$this -> speed += 10;
				}
			}
		}
		$car = new Car();
		$car -> speedUp(); // 调用不存在的方法会使用重载
		echo $car -> speed;
	14. final:属性不能被final修饰,如果父类中的方法被声明为 final,则子类无法覆盖该方法.如果一个类被声明为 final,则不能被继承.
  15. 对象克隆、对象比较: clone(), ==,判断两个对象是否是同一个类的实例, ===,判断两个对象的引用变量是否一样
  	eg:class Car{
  		public $name = "car";
  		public function __clone(){
  			$obj = new Car();
  			$obj -> name = $this -> name;
  		}
  	}
  	$a = new Car();
  	$a -> name = "new Car";
  	$b = clone $a;
  	var_dump($b);
  	echo $a == $b;
  16. 类型约束: 不能用于标量类型,int,string,boolean,float.traits也不行
  17. 转发调用(forwarding call)指的是通过以下几种方式进行的静态调用：self::,parent::,static:: 以及 forward_static_call();
  18. 序列化对象: serialize($obj);unserialize($str);
  eg:class Car{
  	public $name = "car";
  }
  $a = new Car();
  $str = serialize($a); // 对象序列化成字符串
  echo $str."<br>";  // {s:4:"name";s:3:"car";}
  $o = unserialize($str); // 反序列化为对象
  var_dump($o); // object(Car)#2 (1) {["name"]=>string(3) "car"}
11. 命名空间:是一种封装事物的方法,用来解决在编写类库或应用程序时创建可重用的代码如类或函数时碰到的两类问题:
	1. 用户编写的代码与PHP内部的类/函数/常量或第三方类/函数/常量之间的名字冲突
	2. 为很长的标识符名称(通常是为了缓解第一类问题而定义的)创建一个别名(或简短)的名称，提高源代码的可读性
	3. 如果一个文件中包含命名空间,则必须在其他代码之前声明.
	4. 所有非PHP代码包括空白字符都不能出现在命名空间之前;
	5. 一个文件中定义多个命名空间时,使用大括号语法区分,
		eg:namespace MyProject\Sub\Level{// 分层次的子命名空间
			class MyClass{/*....*/}
			function myFunction(){/*....*/}
			const MY_CONST = "My_Constant";
		} 
		eg: '<html>
				<?php 
					namespace MyProject; // 声明错误,
				?>'
	6. 命名空间的限定方式:
		1. 非限定名称:不包含任何前缀的类名称,被解析为currentNamespace\Foo();
		2. 限定名称:包含前缀的类名称,被解析为currentNamespace\subNamespace\Foo();
		3. 完全限定名称:包含了全局前缀操作符的名称:被解析为(literal name)currentnamespace\foo();
			eg:namespace Foo\Bar\subnamespace{// file1.php
				const FOO = 1;
				function foo() {}
				class foo{
				  static function staticmethod() {}
				}
			}
			namespace Foo\Bar{// file2.php
				include 'file1.php';
				const FOO = 2;
				function foo() {}
				class foo
				{
				  static function staticmethod() {}
				}
			}
			/*非限定名称*/
			foo(); // 解析为 Foo\Bar\foo resolves to function Foo\Bar\foo
			foo::staticmethod(); // 解析为类 Foo\Bar\foo的静态方法staticmethod。resolves to class Foo\Bar\foo, method staticmethod
			echo FOO; // resolves to constant Foo\Bar\FOO
			/* 限定名称 */
			subnamespace\foo(); // 解析为函数 Foo\Bar\subnamespace\foo
			subnamespace\foo::staticmethod(); // 解析为类 Foo\Bar\subnamespace\foo,
			                                  // 以及类的方法 staticmethod
			echo subnamespace\FOO; // 解析为常量 Foo\Bar\subnamespace\FOO
			/* 完全限定名称 */
			\Foo\Bar\foo(); // 解析为函数 Foo\Bar\foo
			\Foo\Bar\foo::staticmethod(); // 解析为类 Foo\Bar\foo, 以及类的方法 staticmethod
			echo \Foo\Bar\FOO; // 解析为常量 Foo\Bar\FOO
12. 超全局变量:
	1. $GLOBALS:包含了全部变量的全局组合数组,变量的名字就是数组的键
	2. $_SERVER:包含了诸如头信息(header)、路径(path)、以及脚本位置(script locations)等等信息的数组
	3. $_GET:通过 URL 参数传递给当前脚本的变量的数组
	4. $_POST:通过 HTTP POST 方法传递给当前脚本的变量的数组
	5. $_FILES:通过 HTTP POST 方式上传到当前脚本的项目的数组
	6. $_REQUEST:默认情况下包含了 $_GET、$_POST 和 $_COOKIE 的数组
	7. $_SESSION:当前脚本可用 SESSION 变量的数组
	8. $_ENV:通过环境方式传递给当前脚本的变量的数组
	9. $_COOKIE:通过 HTTP Cookies 方式传递给当前脚本的变量的数组
	10. $php_errormsg:变量包含由 PHP 生成的最新错误信息
	11. $HTTP_RAW_POST_DATA:包含 POST 提交的原始数据
	12. $http_response_header:HTTP 响应头
	13. $argc:传递给脚本的参数数目
	14. $argv:传递给脚本的参数数组
13. 正则表达式:
	1. 语法
		1.\ 一般用于转义字符
			^ 断言目标的开始位置(或在多行模式下是行首)
			$ 断言目标的结束位置(或在多行模式下是行尾)
			. 匹配除换行符外的任何字符(默认)
			[ 开始字符类定义
			] 结束字符类定义
			| 开始一个可选分支
			( 子组的开始标记
			) 子组的结束标记
			? 作为量词，表示 0 次或 1 次匹配。位于量词后面用于改变量词的贪婪特性。 (查阅量词)
			* 量词，0 次或多次匹配
			+ 量词，1 次或多次匹配
			{ 自定义量词开始标记
			} 自定义量词结束标记
	2. 函数
		1. reg:preg_match($reg,$str,$matches); // 判断一类字符模式是否存在,return boolean;
		2. preg_match_all($reg,$str,$matches);  // 匹配返回所有的结果
		3. preg_replace($pattern, $replacement, $string); // 字符串替换
14. Cookies:
	1. setcookie(name,value,expire,path,domain);
15. $_SESSION:
	1. session_start(oid); // 开启session
	2. session_destroy(); // 销毁当前session
16. File:
	1. 文件名不能包含\/:?*"<>|	





