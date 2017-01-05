/*
线程间通讯：
			其实就是多个线程在操作统一个资源，但是操作的动作不同。

提示：可以使用单例设计模式可以使类在内存中值存在一个对象，

问题一：出现安全问题；解决办法使用同步代码块加锁，前提条件要找出多线程共同操作的语句，并且保证锁的唯一性。

问题二：等待唤醒机制：使用wait(),notify();notifyAll();抛出异常。全部使用在同步里面。
		wait()
		notify()
		notifyAll()
		都使用在同步中，因为要对持有监视器(锁)的线程操作，所以要使用在同步中，因为只有同步才具有锁。

为什么这些操作线程的方法要定义在Object类中呢？
		因为这些方法在操作同步中线程时，都必须要标识他们所操作线程只有的锁，只有同一个锁上的被等待线程，
		可以被同一个锁上的notify唤醒。
		也就是说，等待和唤醒必须是同一个锁。而锁可以是任意对象，所以可以被任意对象调用的方法定义在Object类中。

*/
class Res
{
	private String name;
	private String sex;
	//隐藏了一个对对象初始化的构造函数，
	private boolean flag = false;
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
			synchronized(r)//使用同步代码块保证程序同一时间只能有一个线程有执行权。
			{
				if (r.flag)
				{
					try
					{
						r.wait();
					}
					catch (Exception e)
					{

					}
					if(x==0)
					{
						r.name="zhangsan";
						r.sex="man";
					}
					else
					{
						r.name="张三";
						r.sex="男";
					}
					x = (x+1)%2;//判断语句，对输入语句的切换。
					r.flag = true;
					r.notify();
				}
			}
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
			synchronized(r)//锁是Res对象，因为资源是唯一的。
			{
				if (!r.flag)
				{
					try
					{
						r.wait();
					}
					catch ()
					{

					}
				}
				System.out.println(r.name+"......"+r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}
class  InputOutputTest1 
{
	public static void main(String[] args) 
	{
		Res r = new Res();

		Input in = new Input(r);//建立一个Runnable接口就要建立一个类去实现接口，并将对象引用传进去，使类变量指向这个对象。
		Output out = new Output(r);//建立一个Runnable接口就要建立一个类去实现接口，并将对象引用传进去，使类变量指向这个对象。

		Thread t1 = new Thread(in);//建立两个线程操作同一个对象。
		Thread t2 = new Thread(out);//建立两个线程操作同一个对象。

		t1.start();
		t2.start();
	}
}
//=====================================================================================================================================
//代码优化；
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
				this.wait();
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