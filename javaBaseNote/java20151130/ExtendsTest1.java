/*
子父类出现后，类成员的特点：

类中成员：
	1，变量:如果子父类中出现了非私有的同名成员变量时，子类要访问本类中的成员用this，
			访问父类中的同名变量用super。
	2，函数。
	3，构造函数。

	this和super的区别：
		1，this是对本类对象的引用，super是对父类对象的引用;				
*/
class Fu
{
	int num = 4;
}
class Zi extends Fu
{
	int num = 5;
	void Show()
	{
		System.out.println(this.num);//打印显示的结果为本类中的num值；
		System.out.println(super.num);//如果想访问Fu类中的num的值用super.num；
	}
}
class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
