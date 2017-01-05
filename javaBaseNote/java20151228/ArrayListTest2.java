/*
 ��ϰ�����ƶ�һ��������ΪԪ�ش浽ArrayList�����У���ȥ���ظ�Ԫ�ء����磬���˶���ͬ��ͬ������Ϊͬһ�ˣ�Ϊ�ظ���

 ˼·��
	1����������������Щ���ݷ�װ���˶���
	2������һ�����������˶�����롣
	3��ȥ����
 

List�����ж�Ԫ���Ƿ���ͬ��������Ԫ�ص�equals������

����ϰ�������գ�
*/
import java.util.*;
class Person
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
	public boolean equals(Object obj)//�˷�������Ҫ��
	{
		if (!(obj instanceof Person))
		{
			return false;
		}
		Person p = (Person)obj;
		System.out.println(this.name+"....."+p.name);
		
		return this.name.equals(p.name) && this.age == p.age;
	}
}
class  ArrayListTest2
{
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		al.add(new Person("lisi01",30));//al.add(Object obj);//Object obj = new Person("lisi01",30);
		al.add(new Person("lisi02",32));
		al.add(new Person("lisi02",32));
		al.add(new Person("lisi03",33));
		al.add(new Person("lisi04",35));
		al.add(new Person("lisi04",35));
		
		al = singleElement(al);

		Iterator it =al.iterator();

		while(it.hasNext())
		{
			//Object obj = it.next();
			//Person p = (Person)obj;
			Person p = (Person)it.next();
			stringPrint(p.getName()+"::"+p.getAge());
		}
	}
	public static ArrayList singleElement(ArrayList al)
	{
		ArrayList al2 = new ArrayList();//�½�һ�����鼯�ϣ�

		Iterator it = al.iterator();//�½�һ��������ָ����յ����鼯�ϡ�
		while(it.hasNext())
		{
			Object obj = it.next();
			if (!al2.contains(obj))
			{
				al2.add(obj);
			}
		}
		return al2;
	}
}
