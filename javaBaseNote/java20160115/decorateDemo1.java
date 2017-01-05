/*
装饰设计模式：
		当想要对已有的对象进行功能增强时，可以定义类，将已有对象传入，基于已有对象的功能，
并提供加强功能，那么自定义的该类就称为装饰类。

装饰类通常会通过构造方法接收被装饰的对象，并基于被装饰的对象的功能提供更强的功能。

装饰设计模式比继承要灵活，避免了继承体系的臃肿，而且降低了类于类之间的关系。

装饰类因为增强已有对象，具备的功能和已有对象是相同的，只不过提供了更强的功能，
所以装饰类和被装饰类都属于一个体系中。
*/
class Person
{
	public void chifan()
	{
		System.out.println("吃饭");
	}
}
class SuperPerson
{
	private Person p;
	SuperPerson(Person p)
	{
		this.p = p;
	}
	public void superChifan()
	{
		System.out.println("喝点小酒");
		p.chifan();
		System.out.println("饭后点心");
		System.out.println("抽支烟");
	}
}
class  decorateDemo1
{
	public static void main(String[] args) 
	{
		Person p = new Person();

		p.chifan();

		SuperPerson sp = new SuperPerson(p);
		sp.superChifan();
	}
}
