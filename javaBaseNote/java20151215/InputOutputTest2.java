/*
代码优化：
*/
class Res
{
	private String name;
	private String sex;
	//隐藏了一个对对象初始化的构造函数，
	private boolean flag = false;
	public void set(String name,String sex)
	{
		if (flag)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{

			}
		}
		this.name=name;
		this.sex=sex;
		flag = true;
		this.notify();
	}
	public void out()
	{
		if (!flag)
		{
			try
			{
				r.wait();
			}
			catch (Exception e)
			{

			}
		}
		System.out.println(this.name+"......"+this.sex);
		flag = false;
		this.notify();
	}
}
class Input implements Runnable
{
	private Res r;
	Input(Res r)
	{
		this.r=r;
	}
	public void run()//throws Exception
	{
		int x=0;
		while(true)
		{
			if(x==0)
			{
				r.set("zhangsan","man";)
			}
			else
			{
				r.set("张三","男";)
			}
			x = (x+1)%2;//判断语句，对输入语句的切换。
		}
	}
}
class Output implements Runnable
{
	private Res r;
	Output(Res r)
	{
		this.r=r;
	}
	public void run()//throws Exception
	{
		while(true)
		{
			r.out();
		}
	}
}
class  InputOutputTest2 
{
	public static void main(String[] args) 
	{
		Res r = new Res();
			
		new Thread(new Input(r).start());
		new Thread(new Output(r).start());

		/*
		Input in = new Input(r);//建立一个Runnable接口就要建立一个类去实现接口，并将对象引用传进去，使类变量指向这个对象。
		Output out = new Output(r);//建立一个Runnable接口就要建立一个类去实现接口，并将对象引用传进去，使类变量指向这个对象。

		Thread t1 = new Thread(in);//建立两个线程操作同一个对象。
		Thread t2 = new Thread(out);//建立两个线程操作同一个对象。

		t1.start();
		t2.start();
		*/	
	}
}

