/*
简单总结就是：
			成员函数在多态调用时，编译看左边，运行看右边。

在多态中，成员变量的特点：
						无论编译和运行，都是参考左边(引用类型所属的类)。

在多态中，静态成员函数的特点：
							无论编译和运行，都参考左边。
*/
class Fu
{
	int num = 4;
	void show()
	{
		System.out.println("show Fu");
	}
}
class Zi extends Fu
{
	int num = 5;
	void show()//方法的重写(覆盖)
	{
		System.out.println("show Zi");
	}
}
class  
{
	public static void main(String[] args) 
	{
		Fu f = new Zi();//多态，父类引用指向子类对象。
		Zi z = new Zi();
		System.out.println(f.num);
		System.out.println(z.num);
		f.show();
		z.show();
	}
}
//4			成员变量无论编译和运行，都是参考左边(引用类型所属的类)。
//5			成员变量无论编译和运行，都是参考左边(引用类型所属的类)。
//show Zi	成员函数在多态调用时，编译看左边，运行看右边。
//show Zi	成员函数在多态调用时，编译看左边，运行看右边。
//=======================================================================================
interface Inter
{
	public static void show(int a, int b);
	public static void func();
}
class Demo
{
	public static void main(String[] args)
	{
		//补足代码；调用两个函数，要求用匿名内部类。
		Inner in = new Inner()
		{
			public void show (int a,int b)
			{

			}
			public void func()
			{

			}
		};
		in.show();
		in.func();
	}
}
//=======================================================================================
class TD
{
	int y = 6;
	class Inner
	{
		static int y = 3;
		void show()
		{
			System.out.println(y);
		}
	}
}
class TC
{
	public static void main(String[] args)
	{
		TD.Inner ti = new TD().new Inner();
		ti.show();
	}
}
//编译失败，非静态内部类中不可以定义静态成员。
//=======================================================================================
interface Test
{
	public abstract void func();
}
class Demo 
{
	public static void main(String[] args)
	{
		//补足代码;(匿名内部类)
		new Demo().show(new Test()//静态方法和非静态方法的访问加上匿名内部类的使用
		{
			public void func()
			{

			}
		});
	}
	void show(Test t)
	{
		t.func();
	}
}
//=======================================================================================
class Exc0 extends Exception
{

}
class Exc1 extends Exc0
{

}
class Demo
{
	public static void main(String[] args)
	{
		try
		{
			throw new Exc1();
		}
		catch (Exception e)
		{
			System.out.println("Exception");
		}
		catch(Exc0 e)
		{
			System.out.println("Exc0");
		}
	}
}
//编译失败：多个catch时，父类的catch要放在下面。
//=======================================================================================
class Test
{
	public static String output="";
	public static void foo(int i)
	{
		try
		{
			if (i==1)
			{
				throw new Exception();
			}
			output+="1";
		}
		catch(Exception e)
		{
			output+="2";
			return;
		}
		finally
		{
			output+="3";
		}
		output+="4";
		
	}
	public static void main(String[] args)
	{
		foo(0);
		System.out.println(output);
		foo(1);
		System.out.println(output);
	}
}
//运行结果：13423
//=======================================================================================
class Circle
{
	private static double PI=3.14;
	private double radius;
	public Circle(double r)
	{
		radius = r;
	}
	public static double compare(Circle[] cir)
	{
		//程序代码，其实就是在求数组中的最大值。
		int max = 0;//double max = cir[0].radius;
		for (int x=1;x<cir.length;x++)
		{
			if (cir[x].radius>cir[max].radius)//对象不能参与比较，只有对象的属性才能参与比较。
			{
				max=x;
			}
		}
		return cir[max].radius;
	}
}
class TC
{
	public static void main(String[] args)
	{
		Circle [] cir = new Circle[3];//创建了一个类类型数组。
		cir[0]=new Circle(1.0);
		cir[1]=new Circle(2.0);
		cir[2]=new Circle(4.0);
		System.out.println("最大的半径值是："+Circle.compare(cir));
	}
}
//注意，对象不能参与比较，只有对象的属性才能参与比较。
//=======================================================================================
public class Demo
{
	private static int j = 0;
	private static boolean methodB(int k)
	{
		j+=k;
		return true;
	}
	public static void methodA(int i)
	{
		boolean b;
		b = i < 10 | methodB(4);
		b = i < 10 || methodB(8);//当左边结果为真时，右边的方法没有执行。
	}
	public static void main(String[] args)
	{
		methodA(0);
		System.out.println(j);
	}
}
//打印结果为4.
//=======================================================================================
/*
在一个类中编写一个方法，这个方法搜索一个字符数组中是否存在某个字符，如果存在，
则返回这个字符在数组中第一次出现的位置（序号从0开始计算，）否则，返回-1，
要搜索的字符数组和字符都以参数形式传递给该方法，若果传入的数组为null，
应抛出IllegalArgumentException异常。
在类的main方法中以各种可能出现的情况测试验证该方法编写是否正确。
*/
public int getIndex(char[] arr,char key)
{
	if(arr==null)
		throw new IllegalArgumentException("数组为空");
	for (int x=0;x<arr.length;x++)
	{
		if (arr[x]==key)
		{
			return x;
		}
	}
}
//=======================================================================================
class Cirlce 
{
	private double radius;
	public Circle(double r)
	{
		radius = r;
	}
	public Circle compare(Circle cir)
	{
		/*
		if (this.radius>cir.radius)
		{
			return this;
		}
		return cir;
		*/
		return(this.radius>cir.radius)?this:cir;//多元运算符的练习。
	}
}
class TC
{
	public static void main(String[] args)
	{
		Circle cir1=new Circle(1.0);
		Circle cir2=new Circle(2.0);
		Circle cir;
		cir=cir1.compare(cir2);
		if (cir1==cir)
		{
			System.out.println("圆1的半径比较大");
		}
		else
		{
			System.out.println("圆2的半径比较大");
		}

	}
}
//=======================================================================================