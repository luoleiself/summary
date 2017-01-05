/*
? 通配符。也可以理解为占位符。

泛型的限定：
			<? extends E>:可以接收E类型或者E的子类型。上限。
			<？super E>:可以接收E类型或者的E的父类型。下限。
*/
import java.util.*;
class  GenericExtendsSuperDemo6
{
	public static void main(String[] args) 
	{
		//示例一：
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
		
		//示例二：
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
	//示例二：
	public static void print(ArrayList<? extends Person> al)//可以接收Person类型或者Person的子类型。上限。
	{
		Iterator<? extends Person> it = al.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next().getName());
			
			//T t = it.next();
			//System.out.println(t);
		}
	}
	//示例一：使用？通配符可以同时调用一个方法打印两个集合中的元素。
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
//示例二：
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
