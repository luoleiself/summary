/*
RuntimeException����ʱ�쳣��
	1��ArithmeticException extends RuntimeException
	
	2��Exception����һ������������쳣RuntimeException����ʱ�쳣��
	
	3������ں������׳����쳣�������Ͽ��Բ�������������һ��ͨ����
	
	4������ں����������˸��쳣�������߿��Բ��ý��д�������һ��ͨ����

runtimeException����:
					1�� java.lang.ArrayIndexOutOfBoundsException
						��������Խ���쳣���������������ֵΪ��������ڵ��������Сʱ�׳���
					2��java.lang.ArithmeticException
						���������쳣��Ʃ�磺��������ȡ�
					3��java.lang.NullPointerException
						��ָ���쳣����Ӧ����ͼ��Ҫ��ʹ�ö���ĵط�ʹ����nullʱ���׳����쳣��
						Ʃ�磺����null�����ʵ������������null��������ԡ�����null����ĳ��ȡ�ʹ��throw����׳�null�ȵ�
					4��java.lang.ClassNotFoundException
						�Ҳ������쳣����Ӧ����ͼ�����ַ�����ʽ�����������࣬
						���ڱ���CLASSPAH֮���Ҳ�����Ӧ���Ƶ�class�ļ�ʱ���׳����쳣��
					5��java.lang.NegativeArraySizeException  
						���鳤��Ϊ���쳣
					6��java.lang.ArrayStoreException 
						�����а��������ݵ�ֵ�׳����쳣
					7��java.lang.SecurityException 
						��ȫ���쳣
					8��java.lang.IllegalArgumentException 
						�Ƿ������쳣

IOException:
					1��IOException��
						�����������������ʱ���ܳ��ֵ��쳣��
					2��EOFException   
						�ļ��ѽ����쳣
					3��FileNotFoundException  
						�ļ�δ�ҵ��쳣

������
					1��ClassCastException    
						����ת���쳣��
					2��ArrayStoreException  
						�����а��������ݵ�ֵ�׳����쳣
					3��SQLException   
						�������ݿ��쳣��
					4��NoSuchFieldException  
						�ֶ�δ�ҵ��쳣
					5��NoSuchMethodException   
						����δ�ҵ��׳����쳣
					6��NumberFormatException    
						�ַ���ת��Ϊ�����׳����쳣
					7��StringIndexOutOfBoundsException 
						�ַ�������������Χ�׳����쳣
					8��IllegalAccessException  
						���������ĳ���쳣
					9��InstantiationException  
						��Ӧ�ó�����ͼʹ��Class���е�newInstance()��������һ�����ʵ����
						��ָ����������޷���ʵ����ʱ���׳����쳣

֮���Բ����ں���������������Ϊ����Ҫ�õ����ߴ��������쳣������ϣ������ֹͣ��
��Ϊ������ʱ���������޷���������������ϣ��ֹͣ����󣬶Դ������������

�Զ����쳣ʱ��
			������쳣�ķ������޷��ڼ�������ʱ�������Զ���̳�RuntimeException��

�����쳣�����֣�
			1������ʱ�������쳣��
			2������ʱ���������쳣(����ʱ�쳣��RuntimeException�Լ�������)

finally����飺����һ��ִ�еĴ��룬ͨ�����ڹر���Դ��
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
		finally
		{
			System.out.println("finallyһ����ִ��");
		}
	}
}
