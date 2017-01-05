/*
静态:static
用法:是一个修饰符，用于修饰成员(成员变量，成员函数)。
	 被static修饰后，成员被共享，谁都可以访问成员。

	 当成员被静态修饰后，就多了一个调用方式，除了可以被对象调用外，还可以直接被类名调用。
	 格式：类名.静态成员。

特有数据随着对象存储，在堆内存中。

方法区，共享区，数据区：独立于栈内存和堆内存之外，

static特点：
	1,随着类的加载而加载，也就是说静态会随着类的消失而消失，说明它的声明周期最长。
	2,优先于对象存在。静态是先存在，对象是后存在的。
	3,被所有对象所共享。
	4,可以直接被类名调用。

实例变量和类变量的区别：
	1,存放位置：
		类变量随着类的加载而存在于方法区中。
		实例变量随着对象的建立而存在于堆内存中。
	2,生命周期：
		类变量生命周期最长，随着类的消失而消失。
		实例变量生命周期随着对象的消失而消失。

使用注意事项：
	1,静态方法只能访问静态成员(成员方法，成员变量)。
	2,非静态方法既可以访问静态成员也可以访问非静态成员。
	3,静态方法中不可以定义this,super关键字。
		因为静态优先于对象存在，所以静态方法中不可以出现this,super关键字。
	4,主函数是静态的。

优缺点：
	优点:对对象的共享数据进行单独空间大额存储，节省空间，没有必要对每个对象中都存储一份。
		 可以直接被类名调用。
	缺点:生命周期过长，访问出现局限性(静态只能访问静态)。
*/
class StaticDemo
{
	 private String name;//成员变量/实例变量权限变成私有化。
	 static String country="CN";//静态成员变量country已改为static，可以通过静态方法调用，也可以通过对象调用。
	 public void show()
	{
		System.out.println(name+":::"+country);
	}
	public void setName(String name)//需要setName方法和getName方法进行修改返回。
	{
		this.name=name;
	}
	public String getName()//需要setName方法和getName方法进行修改返回。
	{
		return name;
	}
}
class  StaticTest
{
	public static void main(String[] args) 
	{
		StaticDemo st = new StaticDemo();//建立对象
		st.setName("zhangsan");
		st.show();
		System.out.println("Hello World!");
		//System.out.println(StaticDemo.country);静态成员变量另一种方式能直接被类调用，格式：类名.静态成员
	}
	/*
	总结：
		static修饰符:是一个修饰符，用于修饰成员(成员变量，成员函数)。
					 被static修饰后，成员被共享，谁都可以访问成员。
					 静态方法中不可以定义this,super关键字。
					 静态方法只能访问静态成员(成员方法，成员变量)。
					 非静态方法既可以访问静态成员也可以访问非静态成员。
		  static特点：
					1,随着类的加载而加载，也就是说静态会随着类的消失而消失，说明它的声明周期最长。
					2,优先于对象存在。静态是先存在，对象是后存在的。
					3,被所有对象所共享。
					4,可以直接被类名调用。
					 
	*/
}
