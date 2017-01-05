/*
对于多个生产者和消费者：为什么要定义while判断标记？
		原因：让被唤醒的线程再一次判断标记。

为什么要定义notifyAll？
		因为需要唤醒对方线程，因为只用notify，容易出现只唤醒本方线程的情况，导致程序中的所有线程都等待。
*/
class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;
	public void set(String name)
	{
		while (flag)//当使用循环语句时，多线程执行时容易导致线程全部等待。
		{
			try
			{
				wait();
			}
			catch (Exception e)
			{
				//此处省略了解决方式代码块;
			}
		}
		this.name = name+"--"+count++;
		System.out.println(Tread.currentTread().getName()+"....生产者...."+this.name);
		flag = true;
		this.notifyAll();//此处可以使用Object类中的全部唤醒方法解决线程等待的问题。
	}
	public synchronized void out()
	{
		while(!flag)//当使用循环语句时，多线程执行时容易导致线程全部等待。
		{
			try
			{
				wait();
			}
			catch (Exception e)
			{
				//此处省略了解决方式代码块;
			}
		}
		System.out.println(Tread.currentTread().getName()+"....消费者...."+this.name);
		flag = false;
		this.notifyAll();//此处可以使用Object类中的全部唤醒方法解决线程等待的问题。
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
		whoile (true)
		{
			res.set("+商品+");
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
		whoile (true)
		{
			res.out();
		}
	}
}
class ProducerConsumerTest1 
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
