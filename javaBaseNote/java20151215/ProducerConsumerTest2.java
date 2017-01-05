/*
jdk1.5���ṩ���������������
		��synchronizeed�滻����ʵLock��������Object�е�wait,notify,notifyAll,�滻��Condition����
		�ö������ͨ��Lock�����л�ȡ��
*/
class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;

	private Lock lock = new ReentrantLock();//�˴�Ҫ�ص����ա�

	private Condition condition_pro = lock.newCondition();//�˴�Ҫ�ص����ա�
	private Condition condition_con = lock.newCondition();//�˴�Ҫ�ص����ա�

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
			System.out.println(Tread.currentTread().getName()+"....������...."+this.name);
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
			System.out.println(Tread.currentTread().getName()+"....������...."+this.name);
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
				res.set("+��Ʒ+");
			}
			catch (InterruptedException e)
			{
				//�˴�ʡ���˽����ʽ�����;
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
				//�˴�ʡ���˽����ʽ�����;
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
