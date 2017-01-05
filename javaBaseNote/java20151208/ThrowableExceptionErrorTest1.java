/*
Throwable:Throwable： 
	有两个重要的子类：Exception（异常）和 Error（错误），二者都是 Java 异常处理的重要子类，各自都包含大量子类。

Java的异常(包括Exception和Error)分为可查的异常（checked exceptions）和不可查的异常（unchecked exceptions）。
   
可查异常（编译器要求必须处置的异常）：
		正确的程序在运行中，很容易出现的、情理可容的异常状况。
		可查异常虽然是异常状况，但在一定程度上它的发生是可以预计的，而且一旦发生这种异常状况，就必须采取某种方式进行处理。

不可查异常(编译器不要求强制处置的异常):
		包括运行时异常（RuntimeException与其子类）和错误（Error）。

异常Exception与其子类:
		这种异常分两大类运行时异常和非运行时异常(编译异常)。程序中应当尽可能去处理这些异常。

运行时异常(RuntimeException)：
		都是RuntimeException类及其子类异常，如NullPointerException(空指针异常)、IndexOutOfBoundsException(下标越界异常)等，
		这些异常是不检查异常，程序中可以选择捕获处理，也可以不处理。
		这些异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生。
		运行时异常的特点是Java编译器不会检查它，
		也就是说，当程序中可能出现这类异常，即使没有用try-catch语句捕获它，也没有用throws子句声明抛出它，也会编译通过。

非运行时异常（编译异常）：
		是RuntimeException以外的异常，类型上都属于Exception类及其子类。
		从程序语法角度讲是必须进行处理的异常，如果不处理，程序就不能编译通过。
		如IOException、SQLException等以及用户自定义的Exception异常，一般情况下不自定义检查异常。

异常的处理机制：
		抛出异常：
				当一个方法出现错误引发异常时，方法创建异常对象并交付运行时系统，
				异常对象中包含了异常类型和异常出现时的程序状态等异常信息。
				运行时系统负责寻找处置异常的代码并执行。
		
		捕获异常：
				在方法抛出异常之后，运行时系统将转为寻找合适的异常处理器（exception handler）。
				潜在的异常处理器是异常发生时依次存留在调用栈中的方法的集合。
				当异常处理器所能处理的异常类型与方法抛出的异常类型相符时，即为合适 的异常处理器。

总结：一个方法所能捕捉的异常，一定是Java代码在某处所抛出的异常。简单地说，异常总是先被抛出，后被捕捉的。

1，异常：Exception
	就是程序在运行时出现不正常情况。
	这种异常分两大类运行时异常和非运行时异常(编译异常)。程序中应当尽可能去处理这些异常。

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
	
*/
class Demo
{
	public int div(int a,int b)//定义一个返回值类型为int类型的方法。
	{
		return a/b;
	}
}
class  ExceptionTest1
{
	public static void main(String[] args) 
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
	}
}
