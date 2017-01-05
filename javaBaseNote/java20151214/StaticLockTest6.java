/*
如果同步函数被静态static修饰后，使用的锁是什么？
		通过验证发现，被静态修饰后的同步方法的锁不是this，因为静态方法中不可以定义this。

静态进内存时，内存中没有本类对象，但是一定有该类对应的字节码文件对象:类名.class。该对象的类型是Class。

静态的同步方法，使用的锁是该方法所在类的字节码文件对象:类名.class。

*/
class Ticket implements Runnable//不是线程。
{
	private  int tick=100;
	Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(this)//同步代码块的锁是this。
				{	
					if (tick>0)
					{
						System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
					}
				}
			}
		}
		else
		{
			while(true)
			{
				show();
			}
		}
	}
	public static synchronized void show()//同步代码块的锁是this。
	{
		if (tick>0)
		{
			System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
		}
	}
}
class  StaticLockTest6 
{
	public static void main(String[] args) 
	{
		Ticket t = new Ticket();
		Thread t1=new Thread(t);//创建一个线程类;
		Thread t2=new Thread(t);//创建一个线程类;
		Thread t3=new Thread(t);//创建一个线程类;
		Thread t4=new Thread(t);//创建一个线程类;
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
