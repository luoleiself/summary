/*
�����Ż���
*/
class Res
{
	private String name;
	private String sex;
	//������һ���Զ����ʼ���Ĺ��캯����
	private boolean flag = false;
	public void set(String name,String sex)
	{
		if (flag)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{

			}
		}
		this.name=name;
		this.sex=sex;
		flag = true;
		this.notify();
	}
	public void out()
	{
		if (!flag)
		{
			try
			{
				r.wait();
			}
			catch (Exception e)
			{

			}
		}
		System.out.println(this.name+"......"+this.sex);
		flag = false;
		this.notify();
	}
}
class Input implements Runnable
{
	private Res r;
	Input(Res r)
	{
		this.r=r;
	}
	public void run()//throws Exception
	{
		int x=0;
		while(true)
		{
			if(x==0)
			{
				r.set("zhangsan","man";)
			}
			else
			{
				r.set("����","��";)
			}
			x = (x+1)%2;//�ж���䣬�����������л���
		}
	}
}
class Output implements Runnable
{
	private Res r;
	Output(Res r)
	{
		this.r=r;
	}
	public void run()//throws Exception
	{
		while(true)
		{
			r.out();
		}
	}
}
class  InputOutputTest2 
{
	public static void main(String[] args) 
	{
		Res r = new Res();
			
		new Thread(new Input(r).start());
		new Thread(new Output(r).start());

		/*
		Input in = new Input(r);//����һ��Runnable�ӿھ�Ҫ����һ����ȥʵ�ֽӿڣ������������ô���ȥ��ʹ�����ָ���������
		Output out = new Output(r);//����һ��Runnable�ӿھ�Ҫ����һ����ȥʵ�ֽӿڣ������������ô���ȥ��ʹ�����ָ���������

		Thread t1 = new Thread(in);//���������̲߳���ͬһ������
		Thread t2 = new Thread(out);//���������̲߳���ͬһ������

		t1.start();
		t2.start();
		*/	
	}
}

