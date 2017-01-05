/*
Stop方法已过时：
		只有一种，Run方法结束。
		开启多线程运行，运行代码通常是循环结构。
	只要控制住循环，就可以让run方法结束，也就是线程结束。

特殊情况：
		当线程处于了冻结状态，就不会读取到标记，那么线程就不会结束。

当没有指定的方式让冻结的线程恢复到运行状态时，这时需要对冻结状态进行清除。
强制让线程恢复到运行状态中来，这样就可以操作标记，让线程结束。

Thread 类中提供了该方法interrupt();

setDaeMon(boolean on)：后台线程
			将该线程标记为守护线程或用户线程。当正在运行的线程都是守护线程时，Java 虚拟机退出。
			该方法必须在启动线程前调用。 
			该方法首先调用该线程的 checkAccess 方法，且不带任何参数。这可能抛出 SecurityException（在当前线程中）。 

join()	抢夺CPU执行权，抛出异常InterruptedException。
		等待该线程终止。如果任何线程中断了当前线程。当抛出该异常时，当前线程的中断状态 被清除。

		当A线程执行到了B线程的.join()方法时，A就会等待。等B线程执行完，A才会执行。
		join可以用来临时加入现场执行。

*/
class StopThread implements Runnable
{
	private boolean flag = true;
	public synchronized void run()
	{
		while(flag)
		{
			System.out.println(Thread.currentThread().getThrad()+"......run");
		}
	}
	public void changeFlag()
	{
		flag = false;
	}
}
class  StopThreadTest1
{
	public static void main(String[] args) 
	{
		StopTread st = new StopThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.start();
		t2.start();
		
		int x = 0;
		while(x<=50)
		{
			if (x==25)
			{
				st.changeFlag();
				st.setDaeMon();
				break;
			}
			System.out.println("Hello World!");
		}
	}
}
