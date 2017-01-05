/*
匿名内部类：
		1，匿名内部类其实就是内部类的简写格式。
		2，定义匿名内部类的前提：
			 内部类必须是继承一个类或者实现接口。
		3，匿名内部类的格式：new  父类或者接口(){定义子类的内容}
		4，其实匿名内部类就是一个匿名子类对象。而且这个对象有点胖。可以理解为带内容的对象。
		5，匿名内部类中定义的方法最好不要超过3个。
		6，匿名内部类通过父类创建的对象对子类对象中的方法的调用只能一次。如果想调用多个，重复上一次调用步骤。
*/
abstract class AbsDemo
{
	abstract void show();
}
class Outer
{
	int x = 3;
	/*
	class Inner extends AbsDemo
	{
		void show()
		{
			System.out.println(Outer.this.x);
		}
	}
	*/
	public void function()
	{
		//new Inner().show();
		
		//创建一个AbsDemo子类的对象，对上面绿色部分的简化写法。
		new AbsDemo()//对匿名内部类起一个名字格式：AbsDemo  a = new AbsDemo()这是新建对象的多态。
		{
			void show()
			{
				System.out.println(Outer.this.x);
			}
		}.show();//对子类对象Inner的show方法的调用。
	}
}
class  InnerClassTest4
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
