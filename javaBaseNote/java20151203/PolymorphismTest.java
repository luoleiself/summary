/*
��̬���������Ϊ������ڵĶ���������̬��

java�ж�̬��ʵ�ַ�ʽ���ӿ�ʵ�֣��̳и�����з�����д��ͬһ�����н��з������ء�

�ˣ����ˣ�Ů�ˡ�
���è������

è x = new è();
���� x = new è();

1����̬�����֣�
		���������ָ�����Լ����������
		���������Ҳ���Խ����Լ����������
			��̬���ڵ�������Ҫ����
			һ��Ҫ�м̳У�
			����Ҫ����д��
			������������ָ���������;
2����̬��ǰ�᣺
		������������֮���й�ϵ��Ҫô�̳У�Ҫôʵ�֡�
		ͨ������һ��ǰ�᣺������д(����)��
3����̬�ĺô���
		��̬�ĳ��ִ�������˳������չ�ԡ�
		���滻�ԣ�substitutability��:��̬���Ѵ��ڴ�����п��滻�ԡ�
		�������ԣ�extensibility��:��̬�Դ�����п������ԡ�
			�����µ����಻Ӱ���Ѵ�����Ķ�̬�ԡ��̳��ԣ��Լ��������Ե����кͲ�����
		�ӿ��ԣ�interface-ability��:��̬�ǳ���ͨ������ǩ�����������ṩ��һ����ͬ�ӿڣ������������ƻ��߸�������ʵ�ֵġ�
		����ԣ�flexibility��:����Ӧ�����������������Ĳ����������ʹ��Ч�ʡ�
		���ԣ�simplicity��:��̬�򻯶�Ӧ������Ĵ����д���޸Ĺ��̣������ڴ���������������Ͳ���ʱ������ص���Ϊͻ������Ҫ��
4����̬�ı׶ˣ�
		�������չ�ԣ�����ֻ��ʹ�ø�������÷��ʸ����еĳ�Ա��
5����̬��Ӧ�ã�

6����̬�ĳ��ִ����е��ص�(��̬ʹ�õ�ע������)��

*/
abstract class Animal
{
	public abstract void eat();
}
class Cat extends Animal
{
	public void eat()
	{
		System.out.println("����");
	}
	public void catchMouse()
	{
		System.out.println("ץ����");
	}
}
class Dog extends Animal
{
	public void eat()
	{
		System.out.println("�Թ�ͷ");
	}
	public void kanJia()
	{
		System.out.println("����");
	}
}
class Pig extends Animal
{
	public void eat()
	{
		System.out.println("������");
	}
	public void gongDi()
	{
		System.out.println("����");
	}
}
class PolymorphismTest
{
	public static void main(String[] args)
	{
		//��һ�ֵ��÷�ʽ���½�������з������á�
		/*
		//Cat c = new Cat();
		//c.eat();
		//Dog d = new Dog();
		//d.eat();
		//Pig p = new Pig();
		//p.eat();
		*/
	//�ڶ��ֵ��÷�ʽ��������������Զ����еķ������е��á�
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
	//�����ֵ��÷�ʽ��
		//Animal c = new Cat();
		//c.eat();
		function(new Cat());//��������ĵ��á�
		function(new Dog());
		function(new Pig());
	}
	public static void function(Animal a)//Animal a = new Cat();
	{
		a.eat();
	}	
}