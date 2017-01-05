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

接口的特点：
		1，接口是对外暴露的规则。
		2，接口是程序的功能扩展。
		3，接口可以用来多实现。

继承(extends)和接口(interface)的区别：
		继承表示子类属于父类这个体系之中，父类具备的方法，子类都具备。
		接口表示子类不属于接口这个体系之中，接口具备的方法，子类不一定具备。
*/
abstract class Student 
{
	abstract void study();
	void sleep()
	{
		System.out.println("sleep");
	}
}
interface Smoking
{
	void smoke();
}
class BaseStudent extends Student implements Smoking//基础班的学生有学习和睡觉的功能，也有抽烟的功能。
{
	void study(){}
	public void smoke(){}
}
class SubStudent extends Student//提升班的学生只有学习和睡觉的功能。
{
	void study(){}
}
class InterfaceTest1
{
	public static voia main(String[] args)
	{
		System.out.println("Hello World");
	}
}