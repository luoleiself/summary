/*
��һ��Բ�κͳ����Ρ������Ի�ȡ������������������ַǷ�ֵ����Ϊ�ǻ�ȡ����������⡣
����ͨ���쳣����ʾ��
���ж�������������ơ�
*/
interface Shape
{
	public abstract void getArea();
}
class NoValueException extends RuntimeException
{
	NoValueException(String message)
	{
		super(message);
	}
}
class Rec implements Shape
{
	private double len,wid;
	Rec(double len,double wid)
	{
		if (len<=0||wid<=0)
		{
			throw new NoValueException("�߳����ַǷ�ֵ");//�˴�����дRuntimeException()��
		}
		this.len = len;
		this.wid = wid;
	}
	public void getArea()
	{
		System.out.println(len*wid);
	}
}
class Circle implements Shape
{	
	private double radius;
	public static final double PI=3.14;
	Circle(double radius)
	{
		if (radius<=0)
		{
			throw new RuntimeException("�뾶���ַǷ�ֵ");//�˴�����дNoValueException()�����Ƹ�ֱ�ۡ�
		}
		this.radius = radius;
	}
	public void getArea()
	{
		System.out.println(radius*radius*PI);
	}
}
class ExceptionPractice1 
{
	public static void main(String[] args) 
	{
		Rec r = new Rec(-4,6);
		r.getArea();
		Circle c = new Circle(-10);
		c.getArea();
		System.out.println("Hello World!");
	}
}
