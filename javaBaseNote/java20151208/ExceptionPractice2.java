/*
���ܽ���ǣ�
			��Ա�����ڶ�̬����ʱ�����뿴��ߣ����п��ұߡ�

�ڶ�̬�У���Ա�������ص㣺
						���۱�������У����ǲο����(����������������)��

�ڶ�̬�У���̬��Ա�������ص㣺
							���۱�������У����ο���ߡ�
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
	void show()//��������д(����)
	{
		System.out.println("show Zi");
	}
}
class  
{
	public static void main(String[] args) 
	{
		Fu f = new Zi();//��̬����������ָ���������
		Zi z = new Zi();
		System.out.println(f.num);
		System.out.println(z.num);
		f.show();
		z.show();
	}
}
//4			��Ա�������۱�������У����ǲο����(����������������)��
//5			��Ա�������۱�������У����ǲο����(����������������)��
//show Zi	��Ա�����ڶ�̬����ʱ�����뿴��ߣ����п��ұߡ�
//show Zi	��Ա�����ڶ�̬����ʱ�����뿴��ߣ����п��ұߡ�
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
		//������룻��������������Ҫ���������ڲ��ࡣ
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
//����ʧ�ܣ��Ǿ�̬�ڲ����в����Զ��徲̬��Ա��
//=======================================================================================
interface Test
{
	public abstract void func();
}
class Demo 
{
	public static void main(String[] args)
	{
		//�������;(�����ڲ���)
		new Demo().show(new Test()//��̬�����ͷǾ�̬�����ķ��ʼ��������ڲ����ʹ��
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
//����ʧ�ܣ����catchʱ�������catchҪ�������档
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
//���н����13423
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
		//������룬��ʵ�������������е����ֵ��
		int max = 0;//double max = cir[0].radius;
		for (int x=1;x<cir.length;x++)
		{
			if (cir[x].radius>cir[max].radius)//�����ܲ���Ƚϣ�ֻ�ж�������Բ��ܲ���Ƚϡ�
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
		Circle [] cir = new Circle[3];//������һ�����������顣
		cir[0]=new Circle(1.0);
		cir[1]=new Circle(2.0);
		cir[2]=new Circle(4.0);
		System.out.println("���İ뾶ֵ�ǣ�"+Circle.compare(cir));
	}
}
//ע�⣬�����ܲ���Ƚϣ�ֻ�ж�������Բ��ܲ���Ƚϡ�
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
		b = i < 10 || methodB(8);//����߽��Ϊ��ʱ���ұߵķ���û��ִ�С�
	}
	public static void main(String[] args)
	{
		methodA(0);
		System.out.println(j);
	}
}
//��ӡ���Ϊ4.
//=======================================================================================
/*
��һ�����б�дһ�������������������һ���ַ��������Ƿ����ĳ���ַ���������ڣ�
�򷵻�����ַ��������е�һ�γ��ֵ�λ�ã���Ŵ�0��ʼ���㣬�����򣬷���-1��
Ҫ�������ַ�������ַ����Բ�����ʽ���ݸ��÷������������������Ϊnull��
Ӧ�׳�IllegalArgumentException�쳣��
�����main�������Ը��ֿ��ܳ��ֵ����������֤�÷�����д�Ƿ���ȷ��
*/
public int getIndex(char[] arr,char key)
{
	if(arr==null)
		throw new IllegalArgumentException("����Ϊ��");
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
		return(this.radius>cir.radius)?this:cir;//��Ԫ���������ϰ��
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
			System.out.println("Բ1�İ뾶�Ƚϴ�");
		}
		else
		{
			System.out.println("Բ2�İ뾶�Ƚϴ�");
		}

	}
}
//=======================================================================================