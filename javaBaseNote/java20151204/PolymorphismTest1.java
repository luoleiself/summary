/*
类型的转换：
		千万不要出现这样的操作：就是将父类对象转成子类类型。
		我们能转换的是父类引用指向了自己的子类对象时，该引用可以被提升，也可以被强制转换。
		多态自始自终都是子类对象在做着变化。
		类型提升，向上转型。Animal c = new Cat();//类型提升，向上转型。
		类型降低，向下转型。//Cat c = (Cat)a;类型下降，向下转型。
instanceof ：
			是Java、php的一个二元操作符（运算符），和==，>，<是同一类东西。
			它的作用是判断其左边对象是否为其右边类的实例，返回boolean类型的数据。	
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
	//第三种调用方式：
		//Animal c = new Cat();//类型提升，向上转型。
		//c.eat();
	//如果想要调用猫的特有方法时，如何操作？
	//强制将父类的引用，转成子类类型，向下转型。
	//千万不要出现这样的操作：就是将父类对象转成子类类型。
	//我们能转换的是父类引用指向了自己的子类对象时，该引用可以被提升，也可以被强制转换。
	//多态自始自终都是子类对象在做着变化。
		//Cat c = (Cat)a;类型下降，向下转型。
		//c.catchMouse();
		function(new Cat());
	}
	public static void function(Animal a)//Animal a = new Cat();
	{
		a.eat();
		/*
		if(a instanceof Cat)//instanceof 判断对象的数据类型是否一致。
		{
			Cat c = (Cat)a;
			c.catchMouse();
		}
		else if (a instanceof Dog)
		{
			Dog d = (Dog)a;
			d.kanJia();
		}
		else
		{
			Pig p = (Pig)a;
			p.gongDi();
		}
		*/
	}	
}