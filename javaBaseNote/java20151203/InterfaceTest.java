/*
接口：初期理解，可以认为是一个特殊的抽象类。
	   当抽象类中的方法都是抽象的，那么该类可以通过接口的形式来表示。

class 用于定义类，
interface 用于定义接口。

接口定义格式特点：
	1，接口中常见定义：常量，抽象方法。
	2，接口中的成员都有固定修饰符。
		常量：public static final
		方法：public abstract
	记住：接口的成员都是public的。

接口：是不可以创建对象的，因为有抽象方法。
	  需要被子类实现(implements),子类对接口中的抽象方法全都重写后，子类才可以实例化，
	  否则子类是一个抽象类。
	  
接口可以被类多实现，也是对多继承不支持的转换形式，java支持多实现。

接口与接口之间可以多继承，类与接口之间是实现(implements)关系，类与类之间是继承(extends)关系，
类与类之间不存在多继承(extends)，
*/
interface Inter 
{
	public static final int NUM = 5;
	public abstract void show();
}
interface InterA
{
	public abstract void method();
}
class Demo
{
	public void function(){}
}
class Test extends Demo implements Inter,InterA//Test类继承父类Demo实现Inter,InterA接口。
{
	public void show ()
	{
		System.out.println("haha");
	}
	public void method()
	{
		System.out.println("heihei");
	}
}
class InterfaceTest
{
	public static void main(String[] args)
	{
		Test t = new Test();
		System.out.println(t.NUM);
		System.out.println(Test.NUM);
		System.out.println(Inter.NUM);
		System.out.println("Hello World");
	}
}
//运行结果：5	5	5   Hello	World
/*
interface A
{
	void showA();
}
interface B //extends A
{
	void showB();
}
interface C extends B,A
{
	void showC();
}
class D implements  C
{
	public void showA(){};
	public void showB(){};
	public void showC(){};
}
*/
