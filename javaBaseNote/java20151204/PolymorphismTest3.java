/*
java�ж�̬��ʵ�ַ�ʽ���ӿ�ʵ�֣��̳и�����з�����д��ͬһ�����н��з������ء�

�ڶ�̬�г�Ա�������ص㣺�ڷǾ�̬����¡�
	�ڱ���ʱ�ڣ����������ͱ��������������Ƿ��е��õķ���������У�����ɹ�������ʧ�ܡ�
	������ʱ�ڣ����Ķ��������������Ƿ��е��õķ�����

���ܽ���ǣ���Ա�����ڶ�̬����ʱ�����뿴��ߣ����п��ұߡ�

�ڶ�̬�У���Ա�������ص㣺
	���۱�������У����ǲο����(����������������)��

�ڶ�̬�У���̬��Ա�������ص㣺
	���۱�������У����ο���ߡ�
*/
class Fu
{
	void method1()
	{
		System.out.println("Fu method_1");
	}
	void method2()
	{
		System.out.println("Fu method_2");
	}
}
class Zi extends Fu
{
	void method1()
	{
		System.out.println("Zi method_1");
	}
	void method3()
	{
		System.out.println("Zi method_3");
	}
}
class  PolymorphismTest3
{
	public static void main(String[] args) 
	{
		/*
		Zi z = new Zi();
		z.method1();
		z.method2();
		z.method3();
		Fu f = new Fu();
		f.method1();
		f.method2();
		f.method3();
		*/
		//���������ָ�����Լ����������
		//���������Ҳ���Խ����Լ����������
		Fu f = new Zi();
		f.method1();
		f.method2();
	}
}
