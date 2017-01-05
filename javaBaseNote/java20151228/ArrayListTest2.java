/*
 练习：将制定一个对象作为元素存到ArrayList集合中，并去除重复元素。例如，存人对象，同名同年龄视为同一人，为重复。

 思路：
	1，对人描述，将这些数据封装进人对象。
	2，定义一个容器，将人对象存入。
	3，去除。
 

List集合判断元素是否相同，依据是元素的equals方法。

此练习必须掌握！
*/
import java.util.*;
class Person
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public void setName(String str)
	{
		this.name = str;
	}
	public void setAge(int in)
	{
		this.age = in;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public boolean equals(Object obj)//此方法很重要。
	{
		if (!(obj instanceof Person))
		{
			return false;
		}
		Person p = (Person)obj;
		System.out.println(this.name+"....."+p.name);
		
		return this.name.equals(p.name) && this.age == p.age;
	}
}
class  ArrayListTest2
{
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		al.add(new Person("lisi01",30));//al.add(Object obj);//Object obj = new Person("lisi01",30);
		al.add(new Person("lisi02",32));
		al.add(new Person("lisi02",32));
		al.add(new Person("lisi03",33));
		al.add(new Person("lisi04",35));
		al.add(new Person("lisi04",35));
		
		al = singleElement(al);

		Iterator it =al.iterator();

		while(it.hasNext())
		{
			//Object obj = it.next();
			//Person p = (Person)obj;
			Person p = (Person)it.next();
			stringPrint(p.getName()+"::"+p.getAge());
		}
	}
	public static ArrayList singleElement(ArrayList al)
	{
		ArrayList al2 = new ArrayList();//新建一个数组集合，

		Iterator it = al.iterator();//新建一个迭代器指向接收的数组集合。
		while(it.hasNext())
		{
			Object obj = it.next();
			if (!al2.contains(obj))
			{
				al2.add(obj);
			}
		}
		return al2;
	}
}
