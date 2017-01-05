/*
��HashSet�����д����Զ������

HashSet����α�֤Ԫ��Ψһ�Ե��أ�
		��ͨ��Ԫ�ص�����������hashCode��equals����ɡ�
		���Ԫ�ص�HashCodeֵ��ͬ���Ż��ж�equals�Ƿ�Ϊtrue��
		���Ԫ�ص�HashCodeֵ��ͬ���������equals��

ע�⣺�����ж�Ԫ���Ƿ���ڣ��Լ�ɾ���Ȳ����������ķ�����Ԫ�ص�HashCode��equals������

ArrayList��ɾ���������equals������
HashSet��ɾ���������HashCode��equals������
*/
import java.util.*;
class Person // extends Object
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public void setName(String str)
	{
		this.name = str;
	}
	public void setAge(int in)
	{
		this.age = in;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public int hashCode()//�˷�������Ҫ��
	{
		System.out.println(this.name+".....hashCode");

		return name.hashCode()+age;
	}
	public boolean equals(Object obj)//�˷�������Ҫ��
	{
		if (!(obj instanceof Person))
		{
			return false;
		}
		Person p = (Person)obj;
		System.out.println(this.name+"...equals..."+p.name);
		
		return this.name.equals(p.name) && this.age == p.age;
	}
}
class HashSetTest
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		HashSet hs = new HashSet();
		
		hs.add(new Person("java01",11));
		hs.add(new Person("java02",12));
		hs.add(new Person("java02",12));
		hs.add(new Person("java03",13));
		hs.add(new Person("java04",14));
		hs.add(new Person("java04",14));

		stringPrint("java01:"+hs.contains(new Person("java01",11)));//�жϼ����Ƿ����Ԫ�أ��жϹ�ϣֵ��

		stringPrint("java03:"+hs.remove("java03",13));//ɾ��Ԫ�أ�

		Iterator it = hs.iterator();
		while (it.hasNext())
		{
			//Object obj = it.next();
			//Person p = (Person)obj;
			Person p = (Person)it.next();
			stringPrint(p.getName()+"::"+p.getAge());
		}
	}
}
