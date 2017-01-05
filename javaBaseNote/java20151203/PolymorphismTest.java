/*
多态：可以理解为事物存在的多种体现形态。

java中多态的实现方式：接口实现，继承父类进行方法重写，同一个类中进行方法重载。

人：男人，女人。
动物：猫，狗。

猫 x = new 猫();
动物 x = new 猫();

1，多态的体现：
		父类的引用指向了自己的子类对象。
		父类的引用也可以接收自己的子类对象。
			多态存在的三个必要条件
			一、要有继承；
			二、要有重写；
			三、父类引用指向子类对象;
2，多态的前提：
		必须是类与类之间有关系，要么继承，要么实现。
		通常还有一个前提：存在重写(覆盖)。
3，多态的好处：
		多态的出现大大的提高了程序的扩展性。
		可替换性（substitutability）:多态对已存在代码具有可替换性。
		可扩充性（extensibility）:多态对代码具有可扩充性。
			增加新的子类不影响已存在类的多态性、继承性，以及其他特性的运行和操作。
		接口性（interface-ability）:多态是超类通过方法签名，向子类提供了一个共同接口，由子类来完善或者覆盖它而实现的。
		灵活性（flexibility）:它在应用中体现了灵活多样的操作，提高了使用效率。
		简化性（simplicity）:多态简化对应用软件的代码编写和修改过程，尤其在处理大量对象的运算和操作时，这个特点尤为突出和重要。
4，多态的弊端：
		提高了扩展性，但是只能使用父类的引用访问父类中的成员。
5，多态的应用：

6，多态的出现代码中的特点(多态使用的注意事项)：

*/
abstract class Animal
{
	public abstract void eat();
}
class Cat extends Animal
{
	public void eat()
	{
		System.out.println("吃鱼");
	}
	public void catchMouse()
	{
		System.out.println("抓老鼠");
	}
}
class Dog extends Animal
{
	public void eat()
	{
		System.out.println("吃骨头");
	}
	public void kanJia()
	{
		System.out.println("看家");
	}
}
class Pig extends Animal
{
	public void eat()
	{
		System.out.println("吃饲料");
	}
	public void gongDi()
	{
		System.out.println("拱地");
	}
}
class PolymorphismTest
{
	public static void main(String[] args)
	{
		//第一种调用方式：新建对象进行方法调用。
		/*
		//Cat c = new Cat();
		//c.eat();
		//Dog d = new Dog();
		//d.eat();
		//Pig p = new Pig();
		//p.eat();
		*/
	//第二种调用方式：利用匿名对象对对象中的方法进行调用。
	/*
		function(new Cat());
		function(new Dog());
		function(new Pig());
	public static void function(Cat c)
	{
		c.eat();
	}
	public static void function(Dog d)
	{
		d.eat();
	}
	public static void function(Pig p)
	{
		p.eat();
	}
	*/
	//第三种调用方式：
		//Animal c = new Cat();
		//c.eat();
		function(new Cat());//匿名对象的调用。
		function(new Dog());
		function(new Pig());
	}
	public static void function(Animal a)//Animal a = new Cat();
	{
		a.eat();
	}	
}