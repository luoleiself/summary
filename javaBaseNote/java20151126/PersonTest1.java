/*
 Person p = new Person("zhangsan",20);

��������ڴ��е�ִ��˳��
	1,��Ϊnew�õ���Person.class.���Ի����ҵ�Person.class�ļ������ص��ڴ��С�
	2,ִ�и����е�static����飬����еĻ�����Person.class����г�ʼ����
	3,�ڶ��ڴ��п��ٿռ䣬�����ڴ��ַ��
	4,�ڶ��ڴ��н���������������ԣ�������Ĭ�ϳ�ʼ����
	5,�����Խ�����ʾ��ʼ����
	6,�Զ�����й��캯��������ʼ����
	7,�Զ�����ж�Ӧ�Ĺ��캯����ʼ����
	8,���ڴ��ַ����ջ�ڴ��е�p������
*/
class Person
{
	private String name;//Person���г�Ա����Ȩ��˽�л�����Ҫͨ��setName()��getName()�����޸�;
	private int age;
	//���캯�������;
	{
		System.out.println("person code run");
	}
	//���캯����ʽ;
	Person()
	{
		System.out.println("A:name="+name+",age="+age);
	}
	//���������캯����ʽ;
	Person(String a)
	{
		name = a;
		System.out.println("B:name="+name+",age="+age);
	}
	Person(String a,int b)//���캯����ʽ;��������Ĺ��캯���������б�ͬ���Ǻ���������;
	{
		name = a;
		age = b;
		System.out.println("C:name="+name+",age="+age);
	}
	public void setName(String c)//set�ֶ�����get�ֶ������ڶ�privateȨ��˽�еĳ�Ա���и�ֵʱ���õķ�����
	{
		 name = c;
	}
	public String getName()
	{
		return name;
	}
}
class  PersonTest1
{
	public static void main(String[] args) 
	{
		Person p = new Person("zhangsan",20);
		System.out.println("Hello World!");
	}
}
