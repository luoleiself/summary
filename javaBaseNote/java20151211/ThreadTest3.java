/*
�������һ���򵥵���Ʊ������ϰ����̵߳�֪ʶ�㡣
˼·��
	��һ�ַ�ʽ��
			1�����ȳ�Ʊ��������Ψһ�ģ�����Ʊ�Ƕ��������ͬʱ��Ʊ��
			2�����Զ���һ����Ʊ��̳��߳��ࡣ
			3�����峵Ʊ������Ϊһ���̶�ֵ������Ϊ��̬�ġ�
			4������һ��ѭ���ж���䣬�����Ʊ����Ϊ0ʱ��ֹͣ��Ʊ��
	�ڶ��ַ�ʽ��
			1��������ʵ��Runable�ӿڡ�
			2������Runable�ӿ��е�run������
				���߳�Ҫ���еĴ����ŵ���run�����С�
			3��ͨ��Thread�ཨ���̶߳���
			4����Runable�ӿڵ����������Ϊʵ�ʲ������ݸ�Thread��Ĺ��캯����
				ΪʲôҪ��Runable�ӿڵ�������󴫵ݸ�Thread�Ĺ��캯������Ϊ��
				�Զ����run���������Ķ�����Runable�ӿڵ������������Ҫ���߳�ȥִ��ָ�������run������
				�ͱ�����ȷ��run���������Ķ���
			5������Thread���start���������̲߳�����Runable�ӿ�����ķ�����

ʵ�ַ�ʽ�ͼ̳з�ʽ��ʲô����
	ʵ�ַ�ʽ�������˵��̳еľ����ԣ��ڶ����߳�ʱ������ʹ��ʵ�ַ�ʽ��
	
	�̳�Thread:�̴߳�������Thread����run�����С�
	ʵ��Runable:�̴߳������ڽӿ������run�����С�

*/
//��һ�ַ�ʽ��
class Ticket extends Thread
{
	private static int tick=100;//������static�ؼ��ֵ�Ӧ�á�
	public void run()
	{
		while(true)
		{
			if (tick>0)
			{
				System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
			}
		}
	}
}
class  ThreadTest3 
{
	public static void main(String[] args) 
	{
		Ticket t1 = new Ticket();
		Ticket t2 = new Ticket();
		Ticket t3 = new Ticket();
		Ticket t4 = new Ticket();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
/*
�ܽ᣺
	static�ؼ��ֵ�Ӧ�ã�
					��Ա��static���κ󣬱�ɾ�̬�����Ա���������ں���һ�����洢��ջ�ڴ��С�
					�κζ��󶼿��Ե��ñ�static���εĳ�Ա��
*/
//�ڶ��ַ�ʽ��
class Ticket implements Runnable//�����̡߳�
{
	private  int tick=100;
	public void run()
	{
		while(true)
		{
			if (tick>0)
			{
				System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
			}
		}
	}
}
class  ThreadTest3 
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