/*
 Person p = new Person("zhangsan",20);

该语句在内存中的执行顺序：
	1,因为new用到了Person.class.所以会先找到Person.class文件并加载到内存中。
	2,执行该类中的static代码块，如果有的话，给Person.class类进行初始化。
	3,在堆内存中开辟空间，分配内存地址。
	4,在堆内存中建立对象的特有属性，并进行默认初始化。
	5,对属性进行显示初始化。
	6,对对象进行构造函数代码块初始化。
	7,对对象进行对应的构造函数初始化。
	8,将内存地址赋给栈内存中的p变量。
*/
class Person
{
	private String name;//Person类中成员变量权限私有化，需要通过setName()和getName()进行修改;
	private int age;
	//构造函数代码块;
	{
		System.out.println("person code run");
	}
	//构造函数格式;
	Person()
	{
		System.out.println("A:name="+name+",age="+age);
	}
	//带参数构造函数格式;
	Person(String a)
	{
		name = a;
		System.out.println("B:name="+name+",age="+age);
	}
	Person(String a,int b)//构造函数格式;多个重名的构造函数，参数列表不同就是函数的重载;
	{
		name = a;
		age = b;
		System.out.println("C:name="+name+",age="+age);
	}
	public void setName(String c)//set字段名和get字段名用于对private权限私有的成员进行赋值时调用的方法；
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
