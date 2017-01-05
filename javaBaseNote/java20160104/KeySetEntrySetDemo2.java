/*
map集合的两种取出方式：
	1，keySet:
			Set<K> keySet();
					返回此映射中包含的键的 Set 视图。
					示例：Set<String> keySet = map.keySet();
							Iterator<String> it2 = keySet.iterator();
		将map中所有的键存入到Set集合中，因为set具备迭代器，所以可以迭代方式取出所有的键，
		在根据get方法，获取每一个键对应的值。
		
	特点：Map集合的取出原理：将map集合转成set集合，再通过迭代器取出。
	
	2，entrySet:
			Set<Map.Entry<K,V>> entrySet();
					返回此映射中包含的映射关系的 Set 视图。
					示例：Set<Map.Entry<String,String>> entrySet = map.entrySet();
							Iterator<Map.Entry<String,String>> it1 = entrySet.iterator();
			
	特点：将map集合中的映射关系存入到了set集合中，而这个关系的数据类型就是：map.Entry。

Map.Entry 其实Entry也是一个接口，它是map接口的一个内部接口。
		interface Map
		{
			public static interface Entry
			{	
				public abstract Object getKey();
				public abstract Object getValue();
			}
		}
		class HashMap implements Map
		{
			class Hash implements Map.Entry
			{
				public  Object getKey()
				{

				}
				public  Object getValue()
				{

				}
			}
		}
*/
import java.util.*;
class KeySetEntrySetDemo2 
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		Map<String,String> map = new HashMap<String,String>();

		map.put("01","java01");
		map.put("02","java02");
		map.put("03","java03");
		map.put("04","java04");
		
		//使用EntrySet方式：
		Set<Map.Entry<String,String>> entrySet = map.entrySet();//将map集合中的映射关系取出，存入到set集合中。

		Iterator<Map.Entry<String,String>> it1 = entrySet.iterator();
		while (it1.hasNext())
		{
			Map.Entry<String,String> me = it1.next();
			String key1 = me.getKey();
			String value1 = me.getValue();
			stringPrint("key1:"+key1+",value1:"+value1);
		}
		stringPrint("===============================================");
		
		//使用KeySet方式：
		Set<String> keySet = map.keySet();//先获取map集合中的所有键值的Set集合：keySet()
		
		Iterator<String> it2 = keySet.iterator();//有了Set集合，就可以获取迭代器。
		while (it2.hasNext())
		{
			String key2 = it2.next();
			
			//有了键值就可以通过map集合中的get方法获取其键值对应的值。
			String value2 = map.get(key2);
			stringPrint("key2:"+key2+",value2:"+value2);
		}
		
	}
}
/*
输出结果：
		key1:04,value1:java04
		key1:01,value1:java01
		key1:02,value1:java02
		key1:03,value1:java03
		====================================
		key2:04,value2:java04
		key2:01,value2:java01
		key2:02,value2:java02
		key2:03,value2:java03
*/