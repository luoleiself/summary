/*
一、this:区分成员变量和局部变量。
		代表本类的对象，它所在函数所属对象的引用，
		哪个对象在调用this所在的函数，this就代表哪个对象。		

this的应用：当定义类中功能时，该函数内部要用到调用该函数的对象时，这时用this来表示这个对象。
			但凡本类功能(方法，函数)内部使用了本类对象，都用this表示。

二、this语句只能用于构造函数之间互相调用，一般函数和构造函数之间不能使用this语句;
	格式：this(参数);
	
三、this语句只能定义在构造函数的第一行;

四、当对象在同一类中，可以省略this.

课后练习一：给人定义一个用于比较年龄是否相同的功能，也就是是否是同龄人。

*/
class This
{
	private String name;
	private int age;
	This(int age)
	{
		this.age=age;
	}
	This(String name)
	{
		this.name=name;//哪个对象调用这个函数，this就代表哪个对象的name;
	}
	This(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public void speak()
	{
		System.out.println("name="+this.name+",age="+this.age);//省略了this.
		this.show();	
	}
	public void show()
	{
		System.out.println(this.name);//当对象在同一类中，可以省略this.
	}
	//课后练习一：
	//比较两个人的年龄的大小，返回值类型为布尔型数据(是，否);有未知的元素参与运算;
	public boolean compare (This t)
	{
		return this.name==t.name;//this.谁调用的这个函数，this就代表这个对象的引用是t1;
	}
}
class  ThisTest
{
	public static void main(String[] args) 
	{
		//This t= new This("zhangsan");
		This t1 =new This(20);
		This t2 =new This(40);
		boolean b = t1.compare(t2);//t1调用了comparative函数，把t2的值传给了t;
		System.out.println(b);

		System.out.println("Hello World!");
	}
	/*
	总结：
		this的使用；1,this:区分成员变量和局部变量。
					2,当定义类中功能时，该函数内部要用到调用该函数的对象时，这时用this来表示这个对象。
					  格式：this.成员;
					3,this语句只能用于构造函数之间互相调用，一般函数和构造函数之间不能使用this语句;
					  格式：this(参数);
					4,this语句只能定义在构造函数的第一行;
					5,当对象在同一类中，可以省略this.
	*/
}
