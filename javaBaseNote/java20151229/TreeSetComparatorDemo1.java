/*
���Ͽ�ܣ�Collection(�ӿ�)�����ӿڡ�
				|--List(�ӿ�)��Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ��������
					|--ArrayList(��)���ײ�����ݽṹʹ�õ�����ṹ��jDk1.2��ʼ���ص㣺��ѯ�ٶȿ죬��ɾԪ���ٶ������̲߳�ͬ�������鳤�ȿɱ�ٷ�֮50�ӳ�����copy��ɾ����
					|--LinkedList(��)���ײ�ʹ�õ��������ݽṹ��jdk1.2��ʼ���̲߳�ͬ�����ص㣺��ѯ�ٶ�������ɾԪ���ٶȿ졣
					|--Vector(��)���ײ����������ݽṹ��jDk1.0��ʼ���߳�ͬ������ArrayList����ˡ����鳤�ȿɱ�ٷ�֮100�ӳ���
						
				|--Set(�ӿ�)��Ԫ���������(�����ȡ����˳��һ��һ��)��Ԫ�ز������ظ����ü�����ϵû��������
								Set���ϵĹ��ܺ�Collection���ϵĹ�����һ�µġ�
					|--HashSet(��)���ײ����ݽṹ�ǹ�ϣ��
								
					|--TreeSet(��)���ײ����ݽṹ�Ƕ�������
									���Զ�Set�����е�Ԫ�ؽ�������
									��֤Ԫ�ص�Ψһ�Ե����ݣ�CompareTo���� return 0;

TreeSet����ĵ�һ�ַ�ʽ����Ԫ������߱��Ƚ��ԣ�Ԫ����Ҫʵ��Comparable�ӿڣ�
						 ����compareTo���������߽���Ĭ��˳��

����ʲô����ʽ������Ҫ������ͬʱ��һ��Ҫ�ж�һ�δ�Ҫ������	

TreeSet����ĵڶ��ַ�ʽ����Ԫ�����󲻾߱��Ƚ��ԣ����߾߱��ıȽ��Բ�������Ҫ�ģ�
						 ��ʱ����Ҫ�ü�������߱��Ƚ��ԡ��ڼ��ϳ�ʼ��ʱ�����˱ȽϷ�ʽ��
		
��Ԫ�������߱��Ƚ��ԣ����߾߱��ıȽ��Բ�������Ҫ�ģ���ʱ����Ҫ����������߱��Ƚ��ԣ�
�����˱Ƚ��������Ƚ���������Ϊ�������ݸ�TreeSet���ϵĹ��캯����

���������򶼴���ʱ���ԱȽ���Ϊ����

����Ƚ�����
			����һ���࣬ʵ��Comparator�ӿڣ���дcompare������

Comparator(�ӿ�)������
					int compare(T o1, T o2);
									�Ƚ��������������������
					boolean equals(Object obj);
									ָʾĳ�����������Ƿ񡰵��ڡ��� Comparator��
*/
import java.util.*;
class  TreeSetComparatorDemo1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		method1();
	}
	public static void  method1()
	{
		TreeSet tr = new TreeSet(new MyCompare());

		tr.add(new Student("lisi007",22));
		tr.add(new Student("lisi002",25));
		tr.add(new Student("lisi005",20));
		tr.add(new Student("lisi001",27));
		tr.add(new Student("lisi009",19));
		tr.add(new Student("lisi008",19));
		

		Iterator it = tr.iterator();
		while (it.hasNext())
		{
			Sutdent stu = (Student)it.next();
			stringPrint(stu.getName()+"......"+stu.getAge());
		}
	}
}
class Student implements Comparable //�ýӿ�ǿ����ѧ���߱��Ƚ��ԡ�
{
	private String name;
	private int age;
	Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public void setName(String str)
	{
		name = str;
	}
	public void setAge(int in)
	{
		age = in;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public int compareTo(Object obj)//�˷����ص�����
	{
		if (!(obj instanceof Student))
		{
			throw new RuntimeException("����ѧ������");
		}
		Student stu = (Student)obj;
		stringPrint(this.name+"......compareTo....."+s.name);
		if (this.age>s.age)//�����䵱����һ���������жϡ�
		{
			return 1;
		}
		else if (this.age==s.age)
		{
			return this.name.compareTo(s.name);//��������������ͬʱ���������ж�����
		}
		else
		{
			return -1;
		}
	}
}
class MyCompare implements Comparator//ʵ��Comparator�ӿڣ���дcompare������
{
	public int compare(Object o1,Object o2)
	{
		Student s1 = (Student)o1;//��������ת����
		Student s2 = (Student)o2;

		//��Ϊ������һ����������������߱�˳�򣬽������װ�ɶ�����бȽϡ�
		//return new Integer(s1.getAge().compareTo(new Integer(s2.getAge())));
		
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0)
		{
			if (s1.getAge()>s2.getAge())
			{
				return 1;
			}
			if (s1.getAge()==s2.getAge())
			{
				return 0;
			}
			return -1;
		}
	}
}

