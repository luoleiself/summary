/*
�Զ����쳣��
		��Ϊ��Ŀ�л�������е����⣬����Щ���Ⲣδ��java����������װ����
		���Զ�����Щ���е�������԰���java�Ķ������װ��˼�룬�����е����⣬�����Զ�����쳣��װ��

����
	�ڱ������У����ڳ�����-1��Ҳ��Ϊ�Ǵ�������޷���������ģ�
	��ô����Ҫ�������������Զ����������

���ں����ڲ�������throw�׳��쳣������ô�ͱ���Ҫ������Ӧ�Ĵ�������
		1��Ҫô���ڲ�try catch����
		2��Ҫô�ں����������õ����ߴ���

��ζ����쳣��Ϣ�أ�
		��Ϊ�������Ѿ����쳣��Ϣ�Ĳ���������ˣ���������ֻҪ�ڹ���ʱ�����쳣��Ϣ���ݸ�����ͨ��super��䡣
		��ô�Ϳ���ֱ��ͨ��gerMessage�����쳣��Ϣ��

�Զ����쳣��
		�������Զ�����̳�Exception��

�̳�Exceptionԭ��
		�쳣��ϵ��һ���ص㣺��Ϊ�쳣����쳣���󶼱��׳������Ƕ��߱������ԣ�
		�����������Throwable�����ϵ�ж����ص㡣

ֻ�������ϵ�е���Ͷ���ſ��Ա�throws��throw������

throws��throw������
					1��throwsʹ���ں����ϡ�
					2��throwʹ���ں����ڡ�
					3��throws����������쳣�࣬���Ը�����������ö��Ÿ�����
					4��throw��������쳣����throw new �쳣������()
*/
class FuShuException extends Exception
{
	private int value;
	FuShuException()//���캯����
	{
		super();
	}
	FuShuException(String msg,int value)//���캯����
	{
		super(msg);
		this.value = value;
	}
	public int getValue()
	{
		return value;
	}
}
class Demo
{
	int div(int a,int b)throws FuShuException
	{
		if(b<0)
		{
			throw new FuShuException("�����˳����Ǹ��������",b);//�ֶ�ͨ��throw�ؼ����׳�һ���Զ����쳣�ࡣ
		}
		return a/b;
	}
}
class  ExceptionTest4
{
	public static void main(String[] args) //throws Exception�������׳��������������try��������ʽ��
	{
		Demo d = new Demo();
		try
		{
			int x = d.div(4,-2);
			System.out.println("x="+x);
		}
		catch (FuShuException e)
		{
			System.out.println(e.toString());
			System.out.println("����ĸ����ǣ�"+e.getValue());
		}
	}
}
