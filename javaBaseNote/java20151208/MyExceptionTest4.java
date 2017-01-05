/*
自定义异常：
		因为项目中会出现特有的问题，而这些问题并未被java所描述并封装对象。
		所以对于这些特有的问题可以按照java的对问题封装的思想，将特有的问题，进行自定义的异常封装。

需求：
	在本程序中，对于除数是-1，也视为是错误的是无法进行运算的，
	那么就需要对这个问题进行自定义的描述。

当在函数内部出现了throw抛出异常对象，那么就必须要给出对应的处理动作。
		1，要么在内部try catch处理。
		2，要么在函数上声明让调用者处理。

如何定义异常信息呢？
		因为父类中已经把异常信息的操作都完成了，所以子类只要在构造时，将异常信息传递给父类通过super语句。
		那么就可以直接通过gerMessage调用异常信息。

自定义异常：
		必须是自定义类继承Exception。

继承Exception原因；
		异常体系有一个特点：因为异常类和异常对象都被抛出，他们都具备可抛性，
		这个可抛性是Throwable这个体系中独有特点。

只有这个体系中的类和对象才可以被throws和throw操作。

throws和throw的区别：
					1，throws使用在函数上。
					2，throw使用在函数内。
					3，throws后面跟的是异常类，可以跟多个，后面用逗号隔开。
					4，throw后跟的是异常对象，throw new 异常对象名()
*/
class FuShuException extends Exception
{
	private int value;
	FuShuException()//构造函数。
	{
		super();
	}
	FuShuException(String msg,int value)//构造函数。
	{
		super(msg);
		this.value = value;
	}
	public int getValue()
	{
		return value;
	}
}
class Demo
{
	int div(int a,int b)throws FuShuException
	{
		if(b<0)
		{
			throw new FuShuException("出现了除数是负数的情况",b);//手动通过throw关键字抛出一个自定义异常类。
		}
		return a/b;
	}
}
class  ExceptionTest4
{
	public static void main(String[] args) //throws Exception，继续抛出不做处理，下面的try是做处理方式。
	{
		Demo d = new Demo();
		try
		{
			int x = d.div(4,-2);
			System.out.println("x="+x);
		}
		catch (FuShuException e)
		{
			System.out.println(e.toString());
			System.out.println("错误的负数是："+e.getValue());
		}
	}
}
