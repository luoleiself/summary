/*
? ͨ�����Ҳ�������Ϊռλ����

���͵��޶���
			<? extends E>:���Խ���E���ͻ���E�������͡����ޡ�
			<��super E>:���Խ���E���ͻ��ߵ�E�ĸ����͡����ޡ�
*/
import java.util.*;
class  GenericExtendsSuperDemo6
{
	public static void main(String[] args) 
	{
		//ʾ��һ��
		/*
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("java01");
		al1.add("java02");
		al1.add("java03");
		al1.add("java04");

		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(4);
		al2.add(3);
		al2.add(2);
		al2.add(1);
		
		print(al1);
		print(al2);
		*/
		
		//ʾ������
		ArrayList<Person> al1 = new ArrayList<Person>();
		al1.add(new Person("java01"));
		al1.add(new Person("java02"));
		al1.add(new Person("java03"));
		al1.add(new Person("java04"));
		
		ArrayList<Student> al2 = new ArrayList<Student>();
		al2.add(new Student("j01"));
		al2.add(new Student("j02"));
		al2.add(new Student("j03"));
		al2.add(new Student("j04"));
		
		print(al1);
		print(al2);
	}
	//ʾ������
	public static void print(ArrayList<? extends Person> al)//���Խ���Person���ͻ���Person�������͡����ޡ�
	{
		Iterator<? extends Person> it = al.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next().getName());
			
			//T t = it.next();
			//System.out.println(t);
		}
	}
	//ʾ��һ��ʹ�ã�ͨ�������ͬʱ����һ��������ӡ���������е�Ԫ�ء�
	/*
	public static void print(ArrayList<?> al)//public static<T> void print(ArrayList<T> al)
	{
		Iterator<?> it = al.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
			
			//T t = it.next();
			//System.out.println(t);
		}
	}
	*/
}
//ʾ������
class Person
{
	private String name;
	Person(String str)
	{
		this.name = str;
	}
	public String getName()
	{
		return name;
	}
}
class Student extends Person
{
	Student(String name)
	{
		super(name);
	}
}
