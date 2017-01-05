/*
子父类出现后，类成员的特点：

类中成员：
	1，变量:如果子父类中出现了非私有的同名成员变量时，子类要访问本类中的成员用this，
			访问父类中的同名变量用super。
		this和super的区别：this是对本类对象的引用，super是对父类对象的引用;	

	2，函数:1，当子类出现和父类一模一样的函数时，当子类对象调用该函数，会运行子类函数的内容。
			如同父类的函数被覆盖一样，
			这种情况是函数的另一个特性：重写(覆盖)【函数的第一个特性：重载】。
			2，当子类继承父类，沿袭了父类的功能到子类中，但是子类虽具备该功能，
			但是功能的内容却和父类不一致，这时，没有必要定义新功能，而是使用覆盖功能，
			保留父类的功能，并重写子类的功能的内容。
		覆盖：1,子类覆盖父类，必须保证子类权限大于等于父类权限，才可以覆盖，否则编译失败。
			  2,静态只能覆盖静态。

		重载：只看同名函数的参数列表。
		重写：子父类方法要一模一样。

	3，构造函数(方法名与类名一致):在对子类对象进行初始化时，父类的构造函数也会运行，
				那是因为子类的构造函数默认第一行有一条隐式的语句：super();
				super()：会访问父类中空参数的构造函数，而且子类中所有的构造函数默认第一行都是super();

		为什么子类一定要访问父类中的构造函数？
				因为父类中的数据子类可以直接获取，所以子类对象在建立时需要先查看父类是如何对这些数据进行初始化的，
				所以子类在对象初始化时，要先访问一下父类中的构造函数;
				如果要访问父类中指定的构造函数，可以通过手动定义super语句来指定访问。
		
		注意：super语句一定要定义在子类构造函数的第一行。

子类的实例化过程：
		结论：
			子类的所有的构造函数，默认都会访问父类中空参数的构造函数，
			因为子类每一个构造函数内的第一行都有一句隐式super()语句;

			当父类中没有空参数的构造函数时，子类必须手动通过super(参数)语句形式来指定要访问父类的构造函数。

			当然子类的构造函数第一行也可以手动指定this语句来访问本类中的构造函数，
			子类的构造函数中至少会有一个构造函数去访问父类中的构造函数。

为什么this语句和super语句不能同时出现在构造函数中？
		因为this语句和super语句只能写在构造函数内的第一行;
		而且构造函数的初始化要先做。
*/
/*
利用父类对子类中的name进行赋值操作：
class Person
{
	private String name;//定义一个私有字符串变量，
	Person(String name)//Person父类构造函数
	{
		this.name = name;//使用构造函数对变量进行赋值，
	}
	void show()
	{
		System.out.println("name"+name);
	}
}
class Student extends Person//Student子类继承Person父类，
{
	Sutent(String name)
	{
		super(name);//可以通过super()调用父类方法进行name赋值;
	}
	void method()
	{
		super.show();//可以通过super()调用父类方法进行打印;
	}
}
*/
class Fu //此处隐藏了一个继承父类：extends Object
{
	Fu()
	{
		//super();
		System.out.println("Fu fun");
	}
	Fu(int x)
	{
		//super();
		System.out.println("x"+x+"....."+"Fu fun fun");
	}
}
class Zi extends Fu
{
	Zi()
	{
		super(); 
		System.out.println("Zi fun");
	}
	Zi(int x)
	{
		//可以通过this()语句访问本类中的构造函数，
		//本类中的构造函数中至少会有一个构造函数super()语句去访问父类构造函数;
		super();
		System.out.println("x"+x+"....."+"Zi fun fun");
	}
}
class  ExtendsTest3
{
	public static void main(String[] args) 
	{
		Zi z = new Zi(20);
		Zi z1 = new Zi();
		System.out.println("Hello World!");
	}
}
