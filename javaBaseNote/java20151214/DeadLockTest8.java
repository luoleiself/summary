/*
死锁：
	同步中嵌套同步。
	
*/
class Test implements Runnable
{
	private boolean flag;
	Test(boolean flag)
	{
		this.flag = flag;
	}
	public void run()
	{
		if (flag)
		{
			synchronized(MyLock.locka)
			{
				System.out.println("if locka");
				synchronized(MyLock.lockb)
				{
					System.out.println("if lockb");
				}
			}
		}
		else
		{	
			synchronized(MyLock.lockb)
			{
				System.out.println("else lockb");
				synchronized(MyLock.locka)
				{
					System.out.println("else locka");
				}
			}
		}
	}
}
class MyLock
{
	static Object locka = new Object();
	static Object lockb = new Object();
}
class DeadLockTest
{
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new Test(true));
		Thread t2 = new Thread(new Test(false));
		t1.start();
		t2.start();
	}
}