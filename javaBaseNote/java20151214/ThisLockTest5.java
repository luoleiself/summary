/*
同步函数用的是哪个一个锁？
		函数需要被对象条用，那么函数都有一个所属对象引用，就是this。
		所以同步函数使用的锁是this。
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
	public synchronized void show()//同步代码块的锁是this。
	{
		if (tick>0)
		{
			System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
		}
	}
}
class  ThisLockTest5 
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
