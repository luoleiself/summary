/*
ͬ�������õ����ĸ�һ������
		������Ҫ���������ã���ô��������һ�������������ã�����this��
		����ͬ������ʹ�õ�����this��
*/
class Ticket implements Runnable//�����̡߳�
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
				synchronized(this)//ͬ������������this��
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
	public synchronized void show()//ͬ������������this��
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
		Thread t1=new Thread(t);//����һ���߳���;
		Thread t2=new Thread(t);//����һ���߳���;
		Thread t3=new Thread(t);//����һ���߳���;
		Thread t4=new Thread(t);//����һ���߳���;
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
