/*
java中多态的实现方式：接口实现，继承父类进行方法重写，同一个类中进行方法重载。

在多态中成员函数的特点：在非静态情况下。
	在编译时期：参阅引用型变量所属的类中是否有调用的方法，如果有，编译成功，否则失败。
	在运行时期：参阅对象所属的类中是否有调用的方法。

简单总结就是：成员函数在多态调用时，编译看左边，运行看右边。

在多态中，成员变量的特点：
	无论编译和运行，都是参考左边(引用类型所属的类)。

在多态中，静态成员函数的特点：
	无论编译和运行，都参考左边。
*/
class Fu
{
	void method1()
	{
		System.out.println("Fu method_1");
	}
	void method2()
	{
		System.out.println("Fu method_2");
	}
}
class Zi extends Fu
{
	void method1()
	{
		System.out.println("Zi method_1");
	}
	void method3()
	{
		System.out.println("Zi method_3");
	}
}
class  PolymorphismTest3
{
	public static void main(String[] args) 
	{
		/*
		Zi z = new Zi();
		z.method1();
		z.method2();
		z.method3();
		Fu f = new Fu();
		f.method1();
		f.method2();
		f.method3();
		*/
		//父类的引用指向了自己的子类对象。
		//父类的引用也可以接收自己的子类对象。
		Fu f = new Zi();
		f.method1();
		f.method2();
	}
}
