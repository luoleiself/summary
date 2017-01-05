/*
抽象：abstract
	1，当多个类中出现相同功能，但是功能主体不同，这时也可以进行向上抽取，这时，只抽取功能定义，而不抽取功能主体。

抽象类的特点：
			1，抽象方法一定定义在抽象类中，
			2，抽象方法和抽象类都必须被abstract关键字修饰。
			3，抽象类不可以被new创建对象，因为调用抽象方法没有意义。
			4，抽象类中的抽象方法要被使用，必须由子类重写其所有的抽象方法后，建立子类对象调用。
				如果子类只重写了部分抽象方法，那么该子类还是一个抽象类。

区别:1,抽象类和一般类没有太大的不同，该如何描述事物就如何描述事物，只不过该事物中出现了一些看不懂的东西，
	   这些不确定的部分也是该事物的功能，需要明确出现，但是无法定义主体。通过抽象方法来表示;

	 2,抽象类比一般类多了个抽象方法;就是可以在类中可以定义抽象方法;
	   抽象类不可以实例化;

特殊：抽象类中可以不定义抽象方法，这样做仅仅是不让该类建立对象。

课后练习：
		假如我们在开发一个系统时需要对员工进行建模，员工包含3个属性：姓名，工号以及工资，经理也是员工，
		除了含有员工的属性外，另外还有一个奖金属性在，请使用继承的思想设计出员工类和经理类。
		要求类中提供必要的方法进行属性访问。

分析：
	1，首先系统中包括两个类，一个是员工类，一个是经理类;
	2，员工类中包含私有(private)属性姓名，工号和工资，经理也是员工的一种，这里用到继承(extends)关系。
	   经理类继承员工类的私有(private)属性外，同时经理还具有特有(private)属性奖金。
	3，员工和经理都有工作内容，同时经理继承员工，但是，经理和员工的工作内容不同，因此，这里用到抽象(abstracr)关系。
	   因为员工和经理具体的工作内容不确定，这里只需要定义员工的工作(work())方法即可，经理的工作在子类中实例化。
	   员工包括了普通员工，技术员工，各种职能的经理，对普通员工类的理解和经理类的理解意思相近。
	
	员工类：name,id,pay;

	经理类：继承了员工类，并有自己特有的bonus;
*/
abstract class Employee//定义一个员工类，类中的属性为私有属性，
{
	private String name;
	private String id;//员工号不一定全部都为数字，此处定义为字符串类型数据;例如：yf1203，wh1212.
	private double pay;
	Employee(String name,String id,double pay)//此处定义构造函数与类名相同，作用对对象进行初始化操作。
	{
		this.name = name;//this指向本类对象引用。
		this.id = id;
		this.pay = pay;
	}
	public abstract void work();//抽象方法格式，只抽取员工类的功能定义，不抽取功能主体。
}
class Manager extends Employee//定义经理类继承员工类的属性;
{
	private int bonus;
	Manager(String name,String id,double pay,int bonus)
	{
		super(name,id,pay);//使用构造函数第一行的super()方法访问父类中的构造函数对属性初始化。
		this.bonus = bonus;
	}
	public void work()//对父类中的抽象方法进行实例化。
	{
		System.out.println("Manager work");
	}
}
class ProEmployee extends Employee//专业员工继承员工的属性。
{
	ProEmployee(String name,String id,double pay)
	{
		super(name,id,pay);//使用构造函数第一行的super()方法访问父类中的构造函数对属性初始化。
	}
	public void work()//对父类中的抽象方法进行实例化。
	{
		System.out.println("ProEmployee work");
	}
}
class  AbstractTest1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
