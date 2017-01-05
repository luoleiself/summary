/*
练习：去除ArrayList集合中的重复元素。

思路：
	1，首先新建一个集合。从原集合中取出元素后和新集合中的元素进行比较，
	2，要使用到contains(判断元素在集合中是否存在)比较方法，如果元素不存在则存入到新集合中。
	3，判断原集合是否为空，最后将新集合返回。

*/
import java.util.*;
class  ArrayListTest1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		
		al.add("java001");
		al.add("java002");
		al.add("java003");
		al.add("java004");
		al.add("java003");
		al.add("java002");
		al.add("java004");
		al.add("java001");

		stringPrint(al);
		
		al = singleElement(al);
		stringPrint(al);
	}
	public static ArrayList singleElement(ArrayList al)
	{
		ArrayList al2 = new ArrayList();//新建一个数组集合，

		Iterator it = al.iterator();//新建一个迭代器指向接收的数组集合。
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
