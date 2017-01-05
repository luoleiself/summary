/*
有一个圆形和长方形。都可以获取面积，对于面积如果出现非法值，视为是获取面积出现问题。
问题通过异常来表示。
现有对这个程序基本设计。
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
			throw new NoValueException("边长出现非法值");//此处可以写RuntimeException()。
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
			throw new RuntimeException("半径出现非法值");//此处可以写NoValueException()，名称更直观。
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
