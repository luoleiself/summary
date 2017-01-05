/*
需求：对学生对象的年龄进行升序排序。

	因为数据是以键值对形式存在的，
	所以要使用可以排序的map集合。TreeMap。
*/
import java.util.*;
class StuNameComparator implements Comparator<Student>
{
	public int compare(Student s1,Student s2)
	{
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0)
		{
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		}
		return num;
	}
}
class TreeMapEntrySetTest2
{
	public static void main(String[] args) 
	{
		TreeMap<Student,String> tm = new TreeMap<Student,String>(new StuNameComparator());
		
		tm.put(new Student("flisi4",24),"zhengzhou");
		tm.put(new Student("alisi2",22),"beijing");
		tm.put(new Student("lisi1",21),"shanghai");
		tm.put(new Student("dlisi6",26),"xinyang");
		tm.put(new Student("lisi3",23),"chongqing");
		tm.put(new Student("plisi5",25),"haerbing");

		Set<Map.Entry<Student,String>> entrySet = tm.entrySet();
		
		Iterator<Map.Entry<Student,String>> iter = entrySet.iterator();
		while (iter.hasNext())
		{
			Map.Entry<Student,String> me = iter.next();//此处应重点理解。
			Student stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu.getName()+":::"+stu.getAge()+"::::::"+addr);
		}
	}
}
