/*
向HashSet集合中存入自定义对象。

HashSet是如何保证元素唯一性的呢？
		是通过元素的两个方法：hashCode和equals来完成。
		如果元素的HashCode值相同，才会判断equals是否为true。
		如果元素的HashCode值不同，不会调用equals。

注意：对于判断元素是否存在，以及删除等操作，依赖的方法是元素的HashCode和equals方法。

ArrayList增删查改依赖于equals方法。
HashSet增删查改依赖于HashCode和equals方法。
*/
import java.util.*;
class Person // extends Object
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
	public int hashCode()//此方法很重要。
	{
		System.out.println(this.name+".....hashCode");

		return name.hashCode()+age;
	}
	public boolean equals(Object obj)//此方法很重要。
	{
		if (!(obj instanceof Person))
		{
			return false;
		}
		Person p = (Person)obj;
		System.out.println(this.name+"...equals..."+p.name);
		
		return this.name.equals(p.name) && this.age == p.age;
	}
}
class HashSetTest
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		HashSet hs = new HashSet();
		
		hs.add(new Person("java01",11));
		hs.add(new Person("java02",12));
		hs.add(new Person("java02",12));
		hs.add(new Person("java03",13));
		hs.add(new Person("java04",14));
		hs.add(new Person("java04",14));

		stringPrint("java01:"+hs.contains(new Person("java01",11)));//判断集合是否包含元素，判断哈希值。

		stringPrint("java03:"+hs.remove("java03",13));//删除元素，

		Iterator it = hs.iterator();
		while (it.hasNext())
		{
			//Object obj = it.next();
			//Person p = (Person)obj;
			Person p = (Person)it.next();
			stringPrint(p.getName()+"::"+p.getAge());
		}
	}
}
