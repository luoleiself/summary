/*
1，异常：Exception
	就是程序在运行时出现不正常情况。

把问题封装起来就叫异常。


抛出异常声明的情况：
				1，调用一个抛出已检查异常的方法，例如：FileInputStream构造器。
				2，程序运行过程中发现错误，并且利用throw语句抛出一个已检查异常。
				3，程序出现错误，例如：a[-1]=0会抛出一个ArrayIndexOutOfBoundsException这样的额未检查异常。
				4，java虚拟机和运行时库出现的内部异常。

原因：
	问题也是现实生活中一个具体的事物，也可以通过java的类的形式进行描述，并封装成对象。
	其实就是java对不正常情况进行描述后的对象体现。

对于问题的划分：
			一，严重的问题，
			二，非严重的问题。

对于严重的，java通过Error类进行描述。
		对于Error一般不编写针对性的代码对其处理。

对于非严重的，java通过Exception类进行描述。
		对于Exception可以使用针对性的处理方式进行处理。

无论Error或者Exception都具有一些共性内容。
比如：不正常情况的信息，引发原因等。

向上抽取后：Throwable
					|--Error
					|--Exception

2，异常的处理：
	java提供了特有的语句进行处理。

try
{
	需要被检测的代码;
}
catch(异常类 变量)
{
	处理异常的代码;(处理方式)
}
finally
{
	一定会执行的语句;
}

3，对捕获到的异常对象进行常见方法操作。
	getMessage();返回此 throwable 的详细消息字符串。
	toString();	 返回此 throwable 的简短描述。
	printStackTrace();  将此 throwable 及其追踪输出到指定的 PrintWriter。用在打印语句外面。

throws Exception//在功能上通过throws的关键字声明了该功能有可能会出现问题。

对多异常的处理：
			1，声明异常时，建议声明更为具体的异常，这样处理的可以更具体。
			2，对方声明几个异常，就对应有几个catch块，不要定义多余的catch块。
				如果多个catch块中的异常出现继承关系，父类异常catch块放在最下面。

建议在进行catch处理时，catch中一定要定义具体处理方式。
不要简单定义一句e.printStackTrace();
也不要简单的就书写一条输出语句。
*/
class Demo
{
	//定义一个返回值类型为int类型的方法。
	public int div(int a,int b)throws ArithmeticException,ArrayIndexOutOfBoundsException//在功能上通过throws的关键字声明了该功能有可能会出现问题。
	{
		int []arr = new int[a];
		System.out.println(arr[4]);
		return a/b;
	}
}
class  ExceptionTest3
{
	public static void main(String[] args) //throws Exception，继续抛出不做处理，下面的try是做处理方式。
	{
		Demo d = new Demo();
		try
		{
			int x = d.div(4,0);
			System.out.println("x="+x);
		}
		catch (Exception e)//Exception e = new ArithimeticException();多态。
		{
			System.out.println("除零了");
			System.out.println(e.getMessage());//by zero
			System.out.println(e.toString());//异常名称：异常信息。
			
			e.printStackTrace();//异常名称：异常信息，异常出现的位置。
								//其实jvm默认的异常处理机制，就是再调用printStackTrace方法。
								//打印异常的堆栈的跟踪信息。
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("角标越界了");
			System.out.println(e.getMessage());//by zero
			System.out.println(e.toString());//异常名称：异常信息。
			
			e.printStackTrace();//异常名称：异常信息，异常出现的位置。
								//其实jvm默认的异常处理机制，就是再调用printStackTrace方法。
								//打印异常的堆栈的跟踪信息。
		}
	}
}
