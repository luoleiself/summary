/*
基础班学生：
	学习，睡觉。
高级版学生：
	学习，睡觉。

可以将这两类事物进行抽取。

总结：
	对类中共有的特性进行不断的抽取，并将共性的功能方法单独封装在一个类中，
	将需要完成功能的方法集中定义到一个类中，通过主函数对类中需要完成功能的方法的调用实现类的功能。
*/
abstract class Student
{
	public abstract void Study();
	public void Sleep()
	{
		System.out.println("躺着睡");
	}
}
class DoStudent
{
	public void doSome(Student stu) 
	{
		stu.Study();
		stu.Sleep();
	}
}
class BaseStudent extends Student
{
	public void Study()
	{
		System.out.println("Base Study");
	}
	public void Sleep()
	{
		System.out.println("趴着睡");
	}
}
class AdvStudent extends Student
{
	public void Study()
	{
		System.out.println("Adv Study");
	}
}
class PolymorphismTest2
{
	public static void main(String[] args) 
	{
		//第一种方式调用：
		BaseStudent bs = new BaseStudent();
		bs.Study();
		bs.Sleep();
		AdvStudent as =  new AdvStudent();
		as.Study();
		as.Sleep();
		//第二种调用方式：
		function(new BaseStudent());
		function(new AdvStudent());
		//第三种方式调用：
		//通过对方法进行不断的共性的向上抽取，并单独封装在一个类中，通过类的调用，实现某个功能。
		DoStudent ds = new DoStudent();
		ds.doSome(new BaseStudent());
		ds.doSome(new AdvStudent());
	}
	public void function(BaseStudent bs)
	{
		bs.Study();
		bs.Sleep();
	}
	public void function(AdvStudent as)
	{
		as.Study();
		as.Sleep();
	}
}
