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

	3，构造函数。

	
*/
class Tel
{
	void show()
	{
		System.out.println("number");
	}
}
class NewTel extends Tel
{
	void show()
	{
		System.out.println("number");//子类中的方法对父类中的方法进行的重写(覆盖);
		System.out.println("name");//子类中的方法对父类中的方法进行的重写(覆盖);
		System.out.println("pic");//子类中的方法对父类中的方法进行的重写(覆盖);
	}
}

class  ExtendsTest2
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
