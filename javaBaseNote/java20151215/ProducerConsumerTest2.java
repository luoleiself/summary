/*
jdk1.5中提供了升级解决方案：
		将synchronizeed替换成现实Lock操作，将Object中的wait,notify,notifyAll,替换成Condition对象。
		该对象可以通过Lock锁进行获取。
*/
class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;

	private Lock lock = new ReentrantLock();//此处要重点掌握。

	private Condition condition_pro = lock.newCondition();//此处要重点掌握。
	private Condition condition_con = lock.newCondition();//此处要重点掌握。

	public void set(String name)throws InterruptedException
	{
		lock.lock();
		try
		{
			while (flag)
			{
				condition_pro.await();
			}
			this.name = name+"--"+count++;
			System.out.println(Tread.currentTread().getName()+"....生产者...."+this.name);
			flag = true;
			condition_con.signal();
		}	
		finally
		{
			lock.unlock();
		}
	}
	public  void out()throws InterruptedException
	{
		lock.lock()
		try
		{
			while(!flag)
			{
				condition_con.await();
			}
			System.out.println(Tread.currentTread().getName()+"....消费者...."+this.name);
			flag = false;
			condition_pro.signal();	
		}
		finally
		{
			lock.unlock();
		}
	}
}
class Producer implements Runnable
{	
	private Resource res;
	Producer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while (true)
		{
			try
			{
				res.set("+商品+");
			}
			catch (InterruptedException e)
			{
				//此处省略了解决方式代码块;
			}
		}
	}
}
class Consumer implements Runnable
{	
	private Resource res;
	Consumer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while (true)
		{
			try
			{
				res.out();
			}
			catch (InterruptedException e)
			{
				//此处省略了解决方式代码块;
			}
		}
	}
}
class ProducerConsumerTest2 
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();

		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);

		t1.start();
		t2.start();
		
		/*
		new Thread(new Producer(new Resource()).start());
		new Thread(new Consumer(new Resource()).start());
		*/
	}
}
