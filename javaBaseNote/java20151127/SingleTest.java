/*
设计模式:解决某一类问题最行之有效的方法。
java中有23种设计模式：
单例设计模式：解决一个类在内存中只存在一个对象。

想要保证对象唯一：
		1,为了避免其他程序过多建立该类对象，先禁止其他程序建立该类对象。
		2,还为了让其他程序可以访问到该类对象，只好在本类中，自定义一个对象。
		3,为了方便其他程序对自定义对象的访问，可以对外提供一些访问方式。
	
步骤代码实现：
		1,将构造函数私有化。
		2,在类中创建一个本类对象。
		3,提供一个方法可以获取到该对象。

对于事物该怎么描述，还怎么描述。
当需要将该事物的对象保证在内存中唯一时，就将以上的三步加上即可。
*/
//饿汉式：
class Single
{
	private single()//构造函数私有化，不让其他人对对象进行私有化。
	{

	}
	//方法的调用有两种方法；对象.方法名和类名.方法名。
	//对象已经不能被再次建立，因此调用方法只能在方法为静态时：类名.方法名
	//静态方法只能调用静态成员，因此类中新建对象的变量为静态变量。
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
//举例：
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
	//以下代码实现一个类能保证对象的唯一性，不能再新建其他对象。
	//即使新建多个类类型变量，也指向同一个堆内存中的对象。
	private  static Student s = new Student();
	private Student()
	{
	
	}
	public static Student getInstance()
	{
		return s;
	}
}
