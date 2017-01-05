/*
练习：创建一个多线程执行语句。

Thread currentThread()获取当前线程对象的引用，是静态的可以直接使用类名调用。
getName():获取线程的名称。
setName():设置线程的名称。
*/
class Demo extends Thread
{
	private String name;
	Demo(String name)
	{
		this.name=name;//super(name);将名称传递给父类构造函数进行初始化。
	}
	public void run()
	{
		for (int x=0;x<50;x++)
		{
			//this.name = Thread.currentThread().getName()
			System.out.println(this.name+"...run..."+this.x);
		}
	}
}
class  ThreadTest2
{
	public static void main(String[] args) 
	{
		Demo d1=new Demo("张三");
		Demo d2=new Demo("李四");
		d1.start();
		d2.start();
		for (int x=0;x<50;x++)
		{
			System.out.println("main...run..."+x);
		}
	}
}
//注意：此处应注意d1.start()和d1.run()方法调用的区别。