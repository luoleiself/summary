/*
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
	int x = 0;
	public  void run()
	{
		while(x<=50)
		{	
			System.out.println(Thread.currentThread().getThrad()+"......run......."+x);
			x++;
		}
	}
	//public void changeFlag()
	//{
		//flag = false;
	//}
}
class  joinThreadTest1
{
	public static void main(String[] args) 
	{
		StopTread st = new StopThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.start();

		t1.join();

		t2.start();
		
		int x = 0;
		while(x<=50)
		{
			//if (x==25)
			//{
				//st.changeFlag();
				//st.setDaeMon();
				//break;
			//}
			System.out.println(Thread.currentThread().getThrad()+"......main......"+x);
		}
	}
}
