/*
函数的特性：
		    1，封装:隐藏对象的属性和实现的细节，优点：1，将变化隔离，2，便于使用，3，提高重用性，4，提高安全性，
			
			private:权限修辞符，用于修辞类中的成员(成员变量，局部变量)
					私有只是封装的中表现形式。在成员函数中加入逻辑判断语句，提高程序的健壮性；

构造函数:对象一建立就会调用与之对应的构造函数，可以对对象进行初始化。
		 当一个类中没有定义构造函数时，系统会默认加载一个空参数的构造函数。
		 当自定义了构造函数，系统就不在定义构造函数。
		 特点:1,名字和类名一致;
			  2,不用定义返回值类型;和void定义的函数有区别;
			  3,不可以使用return语句;

构造函数和一般函数的区别:1,写法上不同：构造函数：类名(,){;} 一般函数：public static void Str(,){;}
						 2,运行上不同：构造函数是对象一建立就运行，只运行一次。
									   一般函数是对象调用才运行，是对象添加对象具备的功能。可以多次运行。
									 
构造函数时间：
			当分析事物时，该事物存在就具备一些特性或者行为，那么就将这些内容定义在构造函数中。

构造代码块：省略方法名{执行内容;}
			给对象进行初始化，对象一建立就运行，而且优先于构造函数执行，

和构造函数的区别：
			构造函数代码块是对所有对象进行统一初始化，
			构造函数是给对应的对象进行初始化。

构造代码块中定义的是不同对象共性的初始化内容。
*/
class Person
{
	private String name;//Person类中成员变量权限私有化，需要通过setName()和getName()进行修改;
	private int age;
	
	{
		System.out.println("person code run");//构造函数代码块;
	}

	Person()//构造函数格式;
	{
		System.out.println("A:name="+name+",age="+age);
	}
	Person(String a)//构造函数格式;
	{
		name = a;
		System.out.println("B:name="+name+",age="+age);
	}
	Person(String a,int b)//构造函数格式;多个重名的构造函数，参数列表不同就是函数的重载;
	{
		name = a;
		age = b;
		System.out.println("C:name="+name+",age="+age);
	}
	public void setName(String c)//set字段名和get字段名用于对private权限私有的成员进行赋值时调用的方法；
	{
		 name = c;
	}
	public String getName()
	{
		return name;
	}
}
class  ConstructorTest
{
	public static void main(String[] args) 
	{
		Person p = new Person();
		Person p1 = new Person("李四");
		Person p2 = new Person("李四",10);
		p2.setName("李成功");
		System.out.println(p2.getName());
		System.out.println("Hello World!");
	}
	/*
	总结：
		1,掌握什么是构造函数：对对象进行初始化,不可以使用return语句,不用定义返回值类型;和void定义的函数有区别。
		2,掌握构造函数的格式：名称与类名一致。
		3,掌握构造函数的使用和一般函数的区别：构造函数只在对象建立时运行一次，一般函数可以运行多次。
		4,掌握构造函数代码块的定义：(格式：省略方法名{执行内容;})对所有对象进行初始化，优先于构造函数运行。
	*/
}
