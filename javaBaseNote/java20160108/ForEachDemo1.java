/*
高级for循环；
		格式：
			for(数据类型 变量名：被遍历的集合(Collection)或者数组)	

for循环对集合进行遍历，只能获取元素，但是不能对集合进行过多操作。

迭代器除了遍历，还可以进行remove集合中元素的动作。
如果使用ListIterator，还可以在遍历过程中对集合进行增删改查的动作。

传统for循环和高级for循环的区别：
		1，高级for循环有一个局限性，必须有被遍历的目标。
			建议在遍历数组的时候使用传统for循环，因为传统for循环定义角标。
*/
import java.util.*;
class  ForEachDemo1
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("java001");
		al.add("java002");
		al.add("java003");
		al.add("java004");
		al.add("java005");

		for(String s: al)//for(Object s : al )前面没有指定泛型时。
		{
			s = "kk";
			System.out.println(s);
		}
		
		System.out.println("===============================================");
		
		HashMap<Integer,String> hm = new HashMap<Integer,String>();

		hm.put(1,"a");
		hm.put(2,"b");
		hm.put(3,"c");
		hm.put(4,"d");

		Set<Integer> keySet = hm.keySet();
		for (Integer i : keySet)
		{
			System.out.println(i+"::"+hm.get(i));
		}

		System.out.println("===============================================");

//		Set<Map.Entry<Integer,String>> entrySet = hm.entrySet();
//		for(Map.Entry<Integer,String> me : entrySet )

		for(Map.Entry<Integer,String> me : hm.entrySet())
		{
			System.out.println(me.getKey()+"======"+me.getValue());
		}	
	}
}
