/*
优先级：共10级，默认为5级。
toString() Thread类中的方法。示例：System.out.println(Thread.toString());
			返回该线程的字符串表示形式，包括线程名称、优先级和线程组。

 setPriority(int newPriority) Thread类中的方法，更改线程的优先级。示例：t1.setPriority(Thread.MAX_PRIORITY);
			参数有三种：MIN_PRIORITY：线程可以具有的最低优先级。
						NORM_PRIORITY：分配给线程的默认优先级。
						MAX_PRIORITY：线程可以具有的最高优先级。

yield()	Thread类中的方法.
			暂停当前正在执行的线程对象，并执行其他线程。示例：Thread.yield();

*/
class StopThread implements Runnable
{
	int x = 0;
	public  void run()
	{
		while(x<=50)
		{	
			System.out.println(Thread.currentThread().getThrad()+"......run......."+x);//Thread.currentThread().toString()
			x++;
			Thread.yield();
		}
	}
	//public void changeFlag()
	//{
		//flag = false;
	//}
}
class  setPriorityThreadTest1
{
	public static void main(String[] args) 
	{
		StopTread st = new StopThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.start();

		t1.join();

		t2.start();
		
		t1.setPriority(Thread.MAX_PRIORITY);
		
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