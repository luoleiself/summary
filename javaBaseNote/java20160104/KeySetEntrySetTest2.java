/*
ÿһ��ѧ�����ж�Ӧ�Ĺ����ء�
ѧ��Student����ַString��
ѧ�����ԣ����������䡣
ע�⣺�������������ͬ����Ϊͬһ��ѧ������֤ѧ����Ψһ�ԡ�

˼·��
	1������ѧ����
	2������map��������ѧ����Ϊ������ַ��Ϊֵ�����롣
	3����ȡmap�����е�Ԫ�ء�
*/
import java.util.*;
class Student implements Comparable<Student>
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
	public int compareTo(Student s)//ʵ��Comparable�ӿڣ���дcompareTo������ѧ������߱��Ƚ��ԡ�
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if (num == 0)
		{
			return this.name.compareTo(s.name);
		}
		return num;
	}
	public int hashCode()
	{
		return name.hashCode()+age*34;
	}
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Student))
		{
			throw new ClassCastException("�������Ͳ�ƥ��");
		}
		Student s = (Student)obj;
		return this.name.equals(s.name) && this.age == s.age;
	}
}
class KeySetEntrySetTest2
{
	public static void main(String[] args) 
	{
		HashMap<Student,String> hm = new HashMap<Student,String>();
		
		hm.put(new Student("lisi1",21),"shanghai");
		hm.put(new Student("lisi2",22),"beijing");
		hm.put(new Student("lisi3",23),"chongqing");
		hm.put(new Student("lisi4",24),"zhengzhou");
		hm.put(new Student("lisi5",25),"haerbing");
		hm.put(new Student("lisi6",26),"xinyang");

		//��һ��ȡ����ʽ��keySet
		Set<Student> keySet = hm.keySet();

		Iterator<Student> it = keySet.iterator();
		while (it.hasNext())
		{
			Student stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu.getName()+"..."+stu.getAge()+"......"+addr);
		}

		System.out.println("==============================================");
		
		//�ڶ���ȡ����ʽ��entrySet
		Set<Map.Entry<Student,String>> entrySet = hm.entrySet();
		
		Iterator<Map.Entry<Student,String>> iter = entrySet.iterator();
		while (iter.hasNext())
		{
			Map.Entry<Student,String> me = iter.next();//�˴�Ӧ�ص���⡣
			Student stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu.getName()+":::"+stu.getAge()+"::::::"+addr);
		}
	}
}
