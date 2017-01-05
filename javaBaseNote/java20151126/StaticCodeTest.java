/*
静态代码块：

格式：
static
{
	执行语句;
}

特点：静态代码块随着类的加载而执行，只执行一次，并优先于主函数执行。

作用：用于给类初始化。

DOS窗口下命令提示行：
d:\>java\java1126>javac StaticCode.java
d:\>java\java1126>java  StaticCode
*/
class  StaticCode
{
	int num = 7;
	//静态代码块：给类初始化用。
	static
	{
		System.out.println("a");
	}
	//构造函数代码块：给对象初始化用，优先构造函数执行。
	{
		System.out.println("b"+this.num);
	}
	//构造函数：对所有对象初始化用。
	StaticCode()
	{
		System.out.println("c");
	}
	//带参数构造函数：给对应对象初始化用。
	StaticCode(int x)
	{
		System.out.println("d"+this.num);
	}
}
class StaticCodeTest
{
	public static void main(String[] args) 
	{
		new StaticCode(3);
		System.out.println("Hello World!");
	}
	/*
	总结：
		1,运行结果为a,b7,d7,Hello World!
		2,静态代码块：给类初始化用。
		  构造函数代码块：对所有对象初始化用,优先构造函数执行。
		  带参数构造函数：给对应对象初始化用。
		  构造函数：给对象初始化用.
		3,掌握这几种函数(代码块)的区分特点，运行顺序。
	*/
}
	

