/*
���͵�ת����
		ǧ��Ҫ���������Ĳ��������ǽ��������ת���������͡�
		������ת�����Ǹ�������ָ�����Լ����������ʱ�������ÿ��Ա�������Ҳ���Ա�ǿ��ת����
		��̬��ʼ���ն���������������ű仯��
		��������������ת�͡�Animal c = new Cat();//��������������ת�͡�
		���ͽ��ͣ�����ת�͡�//Cat c = (Cat)a;�����½�������ת�͡�
instanceof ��
			��Java��php��һ����Ԫ�������������������==��>��<��ͬһ�ණ����
			�����������ж�����߶����Ƿ�Ϊ���ұ����ʵ��������boolean���͵����ݡ�	
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
	//�����ֵ��÷�ʽ��
		//Animal c = new Cat();//��������������ת�͡�
		//c.eat();
	//�����Ҫ����è�����з���ʱ����β�����
	//ǿ�ƽ���������ã�ת���������ͣ�����ת�͡�
	//ǧ��Ҫ���������Ĳ��������ǽ��������ת���������͡�
	//������ת�����Ǹ�������ָ�����Լ����������ʱ�������ÿ��Ա�������Ҳ���Ա�ǿ��ת����
	//��̬��ʼ���ն���������������ű仯��
		//Cat c = (Cat)a;�����½�������ת�͡�
		//c.catchMouse();
		function(new Cat());
	}
	public static void function(Animal a)//Animal a = new Cat();
	{
		a.eat();
		/*
		if(a instanceof Cat)//instanceof �ж϶�������������Ƿ�һ�¡�
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