/*
���̵߳İ�ȫ���⣺
			����������ڲ���ͬһ���̹߳�������ʱ��һ���̶߳Զ������ִֻ����һ���֣���û��ִ���ꡣ
			��һ���̲߳������ִ�У����¹������ݵĴ���

����취��
		�Զ��������������ݵ���䣬ֻ����һ���̶߳�ִ������ִ�н����������̲߳����Բ���ִ�С�

ͬ������飺
			synchronized(����)
			{
				��Ҫ��ͬ���Ĵ����;
			}

ͬ����ǰ�᣺	
			1������Ҫ�����������������ϵ��̡߳�
			2�������Ƕ���߳�ʹ��ͬһ������
			3�����뱣֤ͬ����ֻ����һ���߳����С�

ͬ�������ĺô���������߳����й��̵İ�ȫ���⡣
			�׶ˣ�����̶߳���Ҫ���ж�����״̬��������Դ��


������ͬ�������������߳̿�����ͬ����ִ�У�û�г��������̼߳�ʹ��ȡ��CPU��ִ��ȨҲ����ȥ��
*/
class Ticket implements Runnable//�����̡߳�
{
	private  int tick=100;
	Object obj = new Object();
	public void run()
	{
		while(true)
		{
			synchronized(obj)//ͬ�������;
			{
				if (tick>0)
				{
					System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
				}
			}
		}
	}
}
class  SynchronizedTest4 
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
