/*
将学生和工人的共性描述提取出来，单独进行描述。
只要让学生和工人与单独描述的这个类有关系，就可以了。

继承：继承是面向对象最显著的一个特性。继承是从已有的类中派生出新的类，新的类能吸收已有类的数据属性和行为，并能扩展新的能力,但不能选择性地继承父类。
	....... extends 类名

特点：
	1,提高了代码的复用性。
	2,让类于类之间产生了关系，有了这个关系，才有了多态的特性。

注意：千万不要为了获取其他类的功能，简化代码而继承，
	   必须是类与类之间有所属关系才可以继承，所属关系 is  a ;

//B类和A类继承C类的属性：找到B类和A类的共性提取出来之类变成父类。
class C
{
	void demo1(){}
}

class A extends C
{
	//void demo1(){}
	void demo2(){}
}
clas B extends C
{
	//void demo1(){}
	void demo3(){}
}

JAVA语言中：java只支持单继承，不支持多继承。

单继承：一个类只能继承一个类。例如学生类继承人类。

多继承：一个类可以继承多个不同的类。
		缺点：
			多继承容易带来安全隐患：当多个父类定义了相同功能，当功能不同时，子类不知道执行哪一个。
			但是java保留了这种机制，并用另一种体现形式来完成表示：多实现。

JAVA支持多层继承:也就是一个继承体系。

如何使用一个继承体系中的功能：
	想要使用体系，先查阅体系中父类的描述，因为父类体系中定义的是该体系中的共性功能，
	通过了解共性功能，就可以知道该体系的基本功能。
	那么这个体系已经基本可以使用了。

具体调用时：一，因为有可能父类不能创建对象。
			二，创建子类对象可以使用更多的功能，包括基本的也包括特有的。
			简单一句：查阅父类功能，创建子类对象使用共能。

class A
{
	void demo1(){}
}

class B extends A
{
	//void demo1(){}
	//void demo2(){}
}
clas C extends B
{
	//void demo2(){}
	void demo3(){}
}
*/

class Person
{
	String name;
	int age;
}
class Student extends Person
{
	//String name;
	//int age;
	void study()
	{
		System.out.println("good study");
	}
}
class Worker extends Person
{
	//String name;
	//int age;
	void work()
	{
		System.out.println("good work");
	}
}
class  ExtendsTest  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
