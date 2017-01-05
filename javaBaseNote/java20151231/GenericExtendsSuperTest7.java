/*
? ͨ�����Ҳ�������Ϊռλ����

���͵��޶���
			<? extends E>:���Խ���E���ͻ���E�������͡����ޡ�
			<��super E>:���Խ���E���ͻ��ߵ�E�ĸ����͡����ޡ�
*/
import java.util.*;
class  GenericExtendsSuperTest7
{
	public static void main(String[] args) 
	{
		//Person�ࣺ
		TreeSet<Person> al1 = new TreeSet<Person>(new Comp());
		al1.add(new Person("Pjava05"));
		al1.add(new Person("Pjava08"));
		al1.add(new Person("Pjava02"));
		al1.add(new Person("Pjava09"));
		
		Iterator<Person> it1 = al1.iterator();
		while (it1.hasNext())
		{
			System.out.println(it1.next().getName());
		}

		System.out.println("==========================================");
		
		//Student�ࣺ
		TreeSet<Student> al2 = new TreeSet<Student>(new Comp());
		al2.add(new Student("Sjava05"));
		al2.add(new Student("Sjava08"));
		al2.add(new Student("Sjava02"));
		al2.add(new Student("Sjava09"));

		Iterator<Student> it2 = al2.iterator();
		while (it2.hasNext())
		{
			System.out.println(it2.next().getName());
		}

		System.out.println("==========================================");
		
		//Worker�ࣺ
		TreeSet<Worker> al3 = new TreeSet<Worker>(new Comp());
		al3.add(new Worker("Wjava05"));
		al3.add(new Worker("Wjava08"));
		al3.add(new Worker("Wjava02"));
		al3.add(new Worker("Wjava09"));

		Iterator<Worker> it3 = al3.iterator();
		while (it3.hasNext())
		{
			System.out.println(it3.next().getName());
		}
	}
}
class Comp implements Comparator<Person>//���Ƚ����ķ��Ͷ���Ϊ������޶�ֵ�����Լ򻯴��롣
{
	public int compare(Person p1,Person p2)
	{
		return p1.getName().compareTo(p2.getName());
	}
}
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
class Worker extends Person
{
	Worker(String name)
	{
		super(name);
	}
}
