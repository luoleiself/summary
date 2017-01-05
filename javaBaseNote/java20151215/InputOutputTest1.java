/*
�̼߳�ͨѶ��
			��ʵ���Ƕ���߳��ڲ���ͳһ����Դ�����ǲ����Ķ�����ͬ��

��ʾ������ʹ�õ������ģʽ����ʹ�����ڴ���ֵ����һ������

����һ�����ְ�ȫ���⣻����취ʹ��ͬ������������ǰ������Ҫ�ҳ����̹߳�ͬ��������䣬���ұ�֤����Ψһ�ԡ�

��������ȴ����ѻ��ƣ�ʹ��wait(),notify();notifyAll();�׳��쳣��ȫ��ʹ����ͬ�����档
		wait()
		notify()
		notifyAll()
		��ʹ����ͬ���У���ΪҪ�Գ��м�����(��)���̲߳���������Ҫʹ����ͬ���У���Ϊֻ��ͬ���ž�������

Ϊʲô��Щ�����̵߳ķ���Ҫ������Object�����أ�
		��Ϊ��Щ�����ڲ���ͬ�����߳�ʱ��������Ҫ��ʶ�����������߳�ֻ�е�����ֻ��ͬһ�����ϵı��ȴ��̣߳�
		���Ա�ͬһ�����ϵ�notify���ѡ�
		Ҳ����˵���ȴ��ͻ��ѱ�����ͬһ��������������������������Կ��Ա����������õķ���������Object���С�

*/
class Res
{
	private String name;
	private String sex;
	//������һ���Զ����ʼ���Ĺ��캯����
	private boolean flag = false;
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
			synchronized(r)//ʹ��ͬ������鱣֤����ͬһʱ��ֻ����һ���߳���ִ��Ȩ��
			{
				if (r.flag)
				{
					try
					{
						r.wait();
					}
					catch (Exception e)
					{

					}
					if(x==0)
					{
						r.name="zhangsan";
						r.sex="man";
					}
					else
					{
						r.name="����";
						r.sex="��";
					}
					x = (x+1)%2;//�ж���䣬�����������л���
					r.flag = true;
					r.notify();
				}
			}
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
			synchronized(r)//����Res������Ϊ��Դ��Ψһ�ġ�
			{
				if (!r.flag)
				{
					try
					{
						r.wait();
					}
					catch ()
					{

					}
				}
				System.out.println(r.name+"......"+r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}
class  InputOutputTest1 
{
	public static void main(String[] args) 
	{
		Res r = new Res();

		Input in = new Input(r);//����һ��Runnable�ӿھ�Ҫ����һ����ȥʵ�ֽӿڣ������������ô���ȥ��ʹ�����ָ���������
		Output out = new Output(r);//����һ��Runnable�ӿھ�Ҫ����һ����ȥʵ�ֽӿڣ������������ô���ȥ��ʹ�����ָ���������

		Thread t1 = new Thread(in);//���������̲߳���ͬһ������
		Thread t2 = new Thread(out);//���������̲߳���ͬһ������

		t1.start();
		t2.start();
	}
}
//=====================================================================================================================================
//�����Ż���
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
				this.wait();
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