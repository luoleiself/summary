/*
��ϰ������һ�����߳�ִ����䡣

Thread currentThread()��ȡ��ǰ�̶߳�������ã��Ǿ�̬�Ŀ���ֱ��ʹ���������á�
getName():��ȡ�̵߳����ơ�
setName():�����̵߳����ơ�
*/
class Demo extends Thread
{
	private String name;
	Demo(String name)
	{
		this.name=name;//super(name);�����ƴ��ݸ����๹�캯�����г�ʼ����
	}
	public void run()
	{
		for (int x=0;x<50;x++)
		{
			//this.name = Thread.currentThread().getName()
			System.out.println(this.name+"...run..."+this.x);
		}
	}
}
class  ThreadTest2
{
	public static void main(String[] args) 
	{
		Demo d1=new Demo("����");
		Demo d2=new Demo("����");
		d1.start();
		d2.start();
		for (int x=0;x<50;x++)
		{
			System.out.println("main...run..."+x);
		}
	}
}
//ע�⣺�˴�Ӧע��d1.start()��d1.run()�������õ�����