/*
final：最终，作为一个修饰符。
	1，可以修饰类，函数(方法)，变量。
	2，被final修饰的类不可以被继承,为了避免被继承，被子类重写功能。
	3，被final修饰的方法不可以被重写。
	4，被final修饰的变量是一个常量只能赋值一次，既可以修饰成员变量，也可以修饰局部变量。
		当描述事物时，一些数据的出现值是固定的，那么这时为了增强阅读性，都给这些值起个名字，方便阅读。
		这个值不需要改变，所以使用final修饰。
	作为常量：常量的书写规范是所有字母都大写，如果有多个单词组成，单词间通过下划线连接。

	5，内部类定义在类中的局部位置上时，只能访问该局部被final修饰的局部变量。
		修饰类的修饰符：final 和 public 


*/
final class Final//被final修饰的类不可以被重写。
{
	void show1()//可以将方法定义为final void show1();让方法不能被重写。
	{
		System.out.println("haha");
	}
	void show2()
	{
		final int x = 5;//x从变量变成常量使用，只能被赋值一次。
		//public static final int  X = 5;权限最大的任何人都可以访问的常量X。
		System.out.println("xixi");
	}
}
class FinalTest 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
