//匿名内部类代码的练习：
interface Inter
{
	//public static final int x = 8;对之前学习的接口的定义的练习。
	public abstract void method();
}
class Test
{
	/*
	static class Inner implements Inter
	{
		public void method()
		{
			System.out.println("Test.function().method();");
		}
	};
	*/
	static Inter function()
	{
		return new Inter()
		{
			public void method()
			{
				System.out.println("Test.function().method();");
			}
		};
	}
}
class InnerClassTest5 
{
	public static void main(String[] args) 
	{
		//Test.function():Test类中有一个静态的方法function.
		//.method():function这个方法运算后的结果是一个对象，而且是一个返回值类型为Inter类型的对象。
		//因为只有是Inter类型的对象，才可以调用method方法。
		Test.function().method();
		/*
		Inter in = Test.function();
		in.method();
		*/

		//当一个子类中包括的方法不超过3个，可以通过匿名内部类代码块实现。
		/*
		show(new Inter())
		{
			public void method()
			{
				System.out.println("Test.function().method();");
			}
		});
		//大括号代表子类的内容范围，小括号代表参数范围，分号代表语句的结束。
		*/
	}
	/*
	public static void show (Inter in)
	{
		in.method();
	}
	*/
}
