/*
���ڶ�������ߺ������ߣ�ΪʲôҪ����while�жϱ�ǣ�
		ԭ���ñ����ѵ��߳���һ���жϱ�ǡ�

ΪʲôҪ����notifyAll��
		��Ϊ��Ҫ���ѶԷ��̣߳���Ϊֻ��notify�����׳���ֻ���ѱ����̵߳���������³����е������̶߳��ȴ���
*/
class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;
	public void set(String name)
	{
		while (flag)//��ʹ��ѭ�����ʱ�����߳�ִ��ʱ���׵����߳�ȫ���ȴ���
		{
			try
			{
				wait();
			}
			catch (Exception e)
			{
				//�˴�ʡ���˽����ʽ�����;
			}
		}
		this.name = name+"--"+count++;
		System.out.println(Tread.currentTread().getName()+"....������...."+this.name);
		flag = true;
		this.notifyAll();//�˴�����ʹ��Object���е�ȫ�����ѷ�������̵߳ȴ������⡣
	}
	public synchronized void out()
	{
		while(!flag)//��ʹ��ѭ�����ʱ�����߳�ִ��ʱ���׵����߳�ȫ���ȴ���
		{
			try
			{
				wait();
			}
			catch (Exception e)
			{
				//�˴�ʡ���˽����ʽ�����;
			}
		}
		System.out.println(Tread.currentTread().getName()+"....������...."+this.name);
		flag = false;
		this.notifyAll();//�˴�����ʹ��Object���е�ȫ�����ѷ�������̵߳ȴ������⡣
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
			res.set("+��Ʒ+");
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
