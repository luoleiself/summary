/*
��̬����飺

��ʽ��
static
{
	ִ�����;
}

�ص㣺��̬�����������ļ��ض�ִ�У�ִֻ��һ�Σ���������������ִ�С�

���ã����ڸ����ʼ����

DOS������������ʾ�У�
d:\>java\java1126>javac StaticCode.java
d:\>java\java1126>java  StaticCode
*/
class  StaticCode
{
	int num = 7;
	//��̬����飺�����ʼ���á�
	static
	{
		System.out.println("a");
	}
	//���캯������飺�������ʼ���ã����ȹ��캯��ִ�С�
	{
		System.out.println("b"+this.num);
	}
	//���캯���������ж����ʼ���á�
	StaticCode()
	{
		System.out.println("c");
	}
	//���������캯��������Ӧ�����ʼ���á�
	StaticCode(int x)
	{
		System.out.println("d"+this.num);
	}
}
class StaticCodeTest
{
	public static void main(String[] args) 
	{
		new StaticCode(3);
		System.out.println("Hello World!");
	}
	/*
	�ܽ᣺
		1,���н��Ϊa,b7,d7,Hello World!
		2,��̬����飺�����ʼ���á�
		  ���캯������飺�����ж����ʼ����,���ȹ��캯��ִ�С�
		  ���������캯��������Ӧ�����ʼ���á�
		  ���캯�����������ʼ����.
		3,�����⼸�ֺ���(�����)�������ص㣬����˳��
	*/
}
	

