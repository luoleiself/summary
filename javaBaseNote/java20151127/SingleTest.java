/*
���ģʽ:���ĳһ����������֮��Ч�ķ�����
java����23�����ģʽ��
�������ģʽ�����һ�������ڴ���ֻ����һ������

��Ҫ��֤����Ψһ��
		1,Ϊ�˱�������������ཨ����������Ƚ�ֹ�����������������
		2,��Ϊ��������������Է��ʵ��������ֻ���ڱ����У��Զ���һ������
		3,Ϊ�˷�������������Զ������ķ��ʣ����Զ����ṩһЩ���ʷ�ʽ��
	
�������ʵ�֣�
		1,�����캯��˽�л���
		2,�����д���һ���������
		3,�ṩһ���������Ի�ȡ���ö���

�����������ô����������ô������
����Ҫ��������Ķ���֤���ڴ���Ψһʱ���ͽ����ϵ��������ϼ��ɡ�
*/
//����ʽ��
class Single
{
	private single()//���캯��˽�л������������˶Զ������˽�л���
	{

	}
	//�����ĵ��������ַ���������.������������.��������
	//�����Ѿ����ܱ��ٴν�������˵��÷���ֻ���ڷ���Ϊ��̬ʱ������.������
	//��̬����ֻ�ܵ��þ�̬��Ա����������½�����ı���Ϊ��̬������
	private static Single s = new Single();
	public static Single getInstance()
	{
		return s;
	}
}
class  SingleTest
{
	public static void main(String[] args) 
	{
		Single ss = Single.getInstance();
		System.out.println("Hello World!");
	}
}
//������
class Student
{
	private int age;
	public void setAge(int age)
	{
		this.age=age;
	}
	public int getAge()
	{
		return age;
	}
	//���´���ʵ��һ�����ܱ�֤�����Ψһ�ԣ��������½���������
	//��ʹ�½���������ͱ�����Ҳָ��ͬһ�����ڴ��еĶ���
	private  static Student s = new Student();
	private Student()
	{
	
	}
	public static Student getInstance()
	{
		return s;
	}
}
