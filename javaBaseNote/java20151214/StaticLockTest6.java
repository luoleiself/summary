/*
���ͬ����������̬static���κ�ʹ�õ�����ʲô��
		ͨ����֤���֣�����̬���κ��ͬ��������������this����Ϊ��̬�����в����Զ���this��

��̬���ڴ�ʱ���ڴ���û�б�����󣬵���һ���и����Ӧ���ֽ����ļ�����:����.class���ö����������Class��

��̬��ͬ��������ʹ�õ����Ǹ÷�����������ֽ����ļ�����:����.class��

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
	public static synchronized void show()//ͬ������������this��
	{
		if (tick>0)
		{
			System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
		}
	}
}
class  StaticLockTest6 
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
