/*
多线程的安全问题：
			当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，还没有执行完。
			另一个线程参与进来执行，导致共享数据的错误。

解决办法：
		对多条操作共享数据的语句，只能让一个线程都执行完再执行进程中其他线程不可以参与执行。

同步代码块：
			synchronized(对象)
			{
				需要被同步的代码块;
			}

同步的前提：	
			1，必须要有两个或者两个以上的线程。
			2，必须是多个线程使用同一个锁。
			3，必须保证同步中只能有一个线程运行。

同步代码块的好处：解决多线程运行过程的安全问题。
			弊端：多个线程都需要先判断锁的状态，消耗资源。


对象如同锁，持有锁的线程可以在同步中执行，没有持有锁的线程即使获取了CPU的执行权也进不去。
*/
class Ticket implements Runnable//不是线程。
{
	private  int tick=100;
	Object obj = new Object();
	public void run()
	{
		while(true)
		{
			synchronized(obj)//同步代码块;
			{
				if (tick>0)
				{
					System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
				}
			}
		}
	}
}
class  SynchronizedTest4 
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
