/*
RuntimeException运行时异常：
	1，ArithmeticException extends RuntimeException
	
	2，Exception中有一个特殊的子类异常RuntimeException运行时异常。
	
	3，如果在函数内抛出该异常，函数上可以不用声明，编译一样通过。
	
	4，如果在函数上声明了该异常，调用者可以不用进行处理。编译一样通过。

runtimeException子类:
					1、 java.lang.ArrayIndexOutOfBoundsException
						数组索引越界异常。当对数组的索引值为负数或大于等于数组大小时抛出。
					2、java.lang.ArithmeticException
						算术条件异常。譬如：整数除零等。
					3、java.lang.NullPointerException
						空指针异常。当应用试图在要求使用对象的地方使用了null时，抛出该异常。
						譬如：调用null对象的实例方法、访问null对象的属性、计算null对象的长度、使用throw语句抛出null等等
					4、java.lang.ClassNotFoundException
						找不到类异常。当应用试图根据字符串形式的类名构造类，
						而在遍历CLASSPAH之后找不到对应名称的class文件时，抛出该异常。
					5、java.lang.NegativeArraySizeException  
						数组长度为负异常
					6、java.lang.ArrayStoreException 
						数组中包含不兼容的值抛出的异常
					7、java.lang.SecurityException 
						安全性异常
					8、java.lang.IllegalArgumentException 
						非法参数异常

IOException:
					1、IOException：
						操作输入流和输出流时可能出现的异常。
					2、EOFException   
						文件已结束异常
					3、FileNotFoundException  
						文件未找到异常

其他：
					1、ClassCastException    
						类型转换异常类
					2、ArrayStoreException  
						数组中包含不兼容的值抛出的异常
					3、SQLException   
						操作数据库异常类
					4、NoSuchFieldException  
						字段未找到异常
					5、NoSuchMethodException   
						方法未找到抛出的异常
					6、NumberFormatException    
						字符串转换为数字抛出的异常
					7、StringIndexOutOfBoundsException 
						字符串索引超出范围抛出的异常
					8、IllegalAccessException  
						不允许访问某类异常
					9、InstantiationException  
						当应用程序试图使用Class类中的newInstance()方法创建一个类的实例，
						而指定的类对象无法被实例化时，抛出该异常

之所以不用在函数上声明，是因为不需要让调用者处理，当该异常发生，希望程序停止。
因为在运行时，出现了无法继续运算的情况，希望停止程序后，对代码进行修正。

自定义异常时：
			如果该异常的发生，无法在继续运行时，就让自定义继承RuntimeException。

对于异常分两种：
			1，编译时被检测的异常。
			2，编译时不被检测的异常(运行时异常：RuntimeException以及其子类)

finally代码块：定义一定执行的代码，通常用于关闭资源。
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
		finally
		{
			System.out.println("finally一定会执行");
		}
	}
}
