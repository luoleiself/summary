/*
集合框架：Collection(接口)：根接口。
				|--List(接口)：元素是有序的，元素可以重复。因为该集合体系有索引。
					|--ArrayList(类)：底层的数据结构使用的数组结构。jDk1.2开始。特点：查询速度快，增删元素速度慢。线程不同步。数组长度可变百分之50延长，先copy后删除。
					|--LinkedList(类)：底层使用的链表数据结构。jdk1.2开始。线程不同步。特点：查询速度慢，增删元素速度快。
					|--Vector(类)：底层是数组数据结构。jDk1.0开始。线程同步。被ArrayList替代了。数组长度可变百分之100延长。
						
				|--Set(接口)：元素是无序的(存入和取出的顺序不一定一致)，元素不可以重复，该集合体系没有索引。
								Set集合的功能和Collection集合的功能是一致的。
					|--HashSet(类)：底层数据结构是哈希表。
								
					|--TreeSet(类)：底层数据结构是二叉树，
									可以对Set集合中的元素进行排序。
									保证元素的唯一性的依据：CompareTo方法 return 0;

TreeSet排序的第一种方式：让元素自审具备比较性，元素需要实现Comparable接口，
						 覆盖compareTo方法，或者叫做默认顺序。

不管什么排序方式：当主要条件相同时，一定要判断一次次要条件。	

TreeSet排序的第二种方式：当元素自审不具备比较性，或者具备的比较性不是所需要的，
						 这时就需要让集合自身具备比较性。在集合初始化时就有了比较方式。
		
当元素自身不具备比较性，或者具备的比较性不是所需要的，这时就需要让容器自身具备比较性，
定义了比较器，将比较器对象作为参数传递给TreeSet集合的构造函数。

当两种排序都存在时，以比较器为主。

定义比较器：
			定义一个类，实现Comparator接口，重写compare方法。

Comparator(接口)方法：
					int compare(T o1, T o2);
									比较用来排序的两个参数。
					boolean equals(Object obj);
									指示某个其他对象是否“等于”此 Comparator。
*/
import java.util.*;
class  TreeSetComparatorDemo1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		method1();
	}
	public static void  method1()
	{
		TreeSet tr = new TreeSet(new MyCompare());

		tr.add(new Student("lisi007",22));
		tr.add(new Student("lisi002",25));
		tr.add(new Student("lisi005",20));
		tr.add(new Student("lisi001",27));
		tr.add(new Student("lisi009",19));
		tr.add(new Student("lisi008",19));
		

		Iterator it = tr.iterator();
		while (it.hasNext())
		{
			Sutdent stu = (Student)it.next();
			stringPrint(stu.getName()+"......"+stu.getAge());
		}
	}
}
class Student implements Comparable //该接口强制让学生具备比较性。
{
	private String name;
	private int age;
	Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public void setName(String str)
	{
		name = str;
	}
	public void setAge(int in)
	{
		age = in;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public int compareTo(Object obj)//此方法重点掌握
	{
		if (!(obj instanceof Student))
		{
			throw new RuntimeException("不是学生对象");
		}
		Student stu = (Student)obj;
		stringPrint(this.name+"......compareTo....."+s.name);
		if (this.age>s.age)//以年龄当做第一条件进行判断。
		{
			return 1;
		}
		else if (this.age==s.age)
		{
			return this.name.compareTo(s.name);//此条件当年龄相同时按照姓名判断排序。
		}
		else
		{
			return -1;
		}
	}
}
class MyCompare implements Comparator//实现Comparator接口，重写compare方法。
{
	public int compare(Object o1,Object o2)
	{
		Student s1 = (Student)o1;//类型向下转换。
		Student s2 = (Student)o2;

		//因为年龄是一个整数，整数自身具备顺序，将年龄封装成对象进行比较。
		//return new Integer(s1.getAge().compareTo(new Integer(s2.getAge())));
		
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0)
		{
			if (s1.getAge()>s2.getAge())
			{
				return 1;
			}
			if (s1.getAge()==s2.getAge())
			{
				return 0;
			}
			return -1;
		}
	}
}

