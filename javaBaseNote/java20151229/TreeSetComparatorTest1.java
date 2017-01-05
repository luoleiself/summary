/*
练习：按照字符串长度排序。

字符串本身具备比较性，但是它的比较方式不是所需要的。这时只能使用比较器。

知识点提示：可以运用到之前学习的匿名内部类。
*/
import java.util.*;
class  TreeSetComparatorTest1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		TreeSet tr = new TreeSet(new StringLengthComparator());

		tr.add("ldasaojnb");
		tr.add("sfda");
		tr.add("lgaljfda");
		tr.add("tnnbjqp");
		tr.add("uriaun");
		tr.add("vdhi");

		Iterator it = tr.iterator();
		while (it.hasNext())//while(!(it.isEmpty()))
		{
			stringPrint(it.next());	
		}
		
		//可以运用匿名内部类将程序写在一起，但阅读性较差。
		/*
		TreeSet tr = new TreeSet(new Comparator()
		{
			public int compare(Object o1,Object o2)
			{
				String s1 = (String)o1;
				String s2 = (String)o2;
		
				//第一种方法：可以直接进行长度比较然后返回
		
				if (s1.length()>s2.length())
				{
					return 1;
				}
				if (s1.length()==s2.length())
				{
					return s1.compareTo(s2);
				}
				ruturn -1;
		
				//第二种方法：可以将字符串的长度封装成对象进行比较。
				int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
				
				if (num==0)
				{
					return s1.compareTo(s2);
				}
				return num;			
			}
		});
		*/
	}
}
class StringLengthComparator implements Comparator//实现Comparator接口，重写(覆盖)compare方法。
{
	public int compare(Object o1,Object o2)
	{
		String s1 = (String)o1;
		String s2 = (String)o2;
		
		//第一种方法：可以直接进行长度比较然后返回
		/*
		if (s1.length()>s2.length())
		{
			return 1;
		}
		if (s1.length()==s2.length())
		{
			return s1.compareTo(s2);
		}
		ruturn -1;
		*/
		
		//第二种方法：可以将字符串的长度封装成对象进行比较。
		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if (num==0)
		{
			return s1.compareTo(s2);
		}
		return num;
	}
}
//总结：1，进行元素的比较要综合考虑，如果元素的第一个属性相同的话，要比较元素的下一个或几个属性。
//		2，进行元素的比较可以将比较的属性封装成对象进行比较，优化代码结构。
//		3，同时可以使用到之前学习的定义匿名内部类的功能，优点是练习的知识点多，缺点是程序的阅读性差。
