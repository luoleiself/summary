/*
需求：获取一段程序运行的时间;
原理：获取程序开始和结束的时间并相减即可。

获取时间：System.currentTimeMillis();

当代码完成优化后，就可以解决这类问题，这种方式，模板方法设计模式。

什么是模板方法呢？
	在定义功能(方法)时，功能(方法)的一部分是确定的，但是有一部分是不确定，而确定的部分在使用不确定的部分，
	那么这时就将不确定的部分暴露出去，由该类的子类去完成。
	(继承,抽象,最终方法的加强练习)。
*/
class GetTime
{
	public void getTime()
	{
		long start = System.currentTimeMillis();
		for (int x =0;x<1000;x++)//控制程序的执行时间以便currentTimeMillis()方法对程序执行时间的计算。
		{
			System.out.print(x);
		}
		long end = System.currentTimeMillis();
		System.out.println("毫秒："+(end-start));
	}
}
class  TemplateTest
{
	public static void main(String[] args) 
	{
		GetTime gt = new GetTime();
		//SubTime gt = new SubTime();
		gt.getTime();
		System.out.println("Hello World!");
	}
}
/*
模板方法模式：
abstract class GetTime
{
	public final void getTime()//使用final关键修饰方法使方法为最终版，不能被重载和重写。
	{
		long start = System.currentTimeMillis();
		runCode();
		long end = System.currentTimeMillis();
		System.out.println("毫秒："+(end-start));
	}
	public abstract void runCode();//将方法定义为抽象方法后，由子类去重写执行体然后运行程序。
}
class SubTime extends GetTime//定义子类，让子类去重写父类抽象函数执行体内容,执行体内容为不确定内容。
{
	public void runCode()
	{
		for (int x =0;x<1000;x++)
		{
			System.out.print(x);
		}
	}
}
class  TemplateTest
{
	public static void main(String[] args) 
	{
		//GetTime gt = new GetTime();
		SubTime gt = new SubTime();
		gt.getTime();
		System.out.println("Hello World!");
	}
}
*/
