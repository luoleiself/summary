/*
Map接口：Map<K,V>
				K--此映射所维护的键的类型。
				V--映射值的类型。
	特点：
		1，该集合存储键值对，一对一对往里存，而且要保证键的唯一性。
	
 Map方法：
		1,添加：
			V put(K key, V value);
					将指定的值与此映射中的指定键关联（可选操作）。
			void putAll(Map<? extends K,? extends V> m);
					从指定映射中将所有映射关系复制到此映射中（可选操作）。
		2,删除：
			void clear()；
					从此映射中移除所有映射关系（可选操作）。
			V remove(Object key);
					如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
		3,判断：
			boolean containsKey(Object key);
					如果此映射包含指定键的映射关系，则返回 true。
			boolean containsValue(Object value);
					如果此映射将一个或多个键映射到指定值，则返回 true。
			boolean isEmpty();
					如果此映射未包含键-值映射关系，则返回 true。	
		4,获取：
			V get(Object key);
					返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
			int size();
					返回此映射中的键-值映射关系数。
			Collection<V> values();
					返回此映射中包含的值的 Collection 视图。示例：Collection<String> coll = map.values();
 

			Set<K> keySet();
					返回此映射中包含的键的 Set 视图。
					示例：Set<String> keySet = map.keySet();
							Iterator<String> it2 = keySet.iterator();
			Set<Map.Entry<K,V>> entrySet();
					返回此映射中包含的映射关系的 Set 视图。
					示例：Set<Map.Entry<String,String>> entrySet = map.entrySet();
							Iterator<Map.Entry<String,String>> it1 = entrySet.iterator();

Map:(面试)
	|--Hashtable类：底层是哈希表数据结构，不可以存入null键和null值，该集合是线程同步的。jdk1.0开始。效率低。	
	|--HashMap类：底层是哈希表数据结构，可以使用null键和null键，该集合是线程不同步的。jdk1.2开始。效率高。
	|--TreeMap：底层是二叉树数据结构，线程不同步，可以用于给Map集合中的键进行排序。

和Set很像。底层调用了Set方法。
*/
import java.util.*;
class  MapDemo1
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
		
		stringPrint("put:"+map.put("01","JAVA01"));//键值相同则覆盖并返回原来的值。
		stringPrint("put:"+map.put("01","PJAVA01"));
		//添加元素时，如果出现添加相同的键值，那么后添加的映射关系就会覆盖原有键值对应的映射关系。
		//并put方法会返回被覆盖的值。
		stringPrint("containsKy:"+map.containsKey("02"));//判断是否包含键值的映射关系，返回值类型为布尔型。
		stringPrint("remove:"+map.remove("03"));//(显示)移除键值的映射关系。

		stringPrint("get:"+map.get("01"));//返回(显示)键值的映射关系。
		
		map.put(null,"java04");
		stringPrint("get:"+map.get(null));//返回(显示)键值的映射关系。
		//可以通过get方法的返回值来判断一个键是否存在，通过返回的null判断。
		
		//获取map集合中所有的值。
		Collection<String> coll = map.values();//返回此映射中包含的值的 Collection 视图。

		stringPrint(coll);
		stringPrint(map);//返回兼职和映射的关系。
	}
}
/*输出结果：
			put:java01
			put:JAVA01
			containsKy:true
			remove:java03
			get:PJAVA01
			get:java04
			[java04, PJAVA01, java02]
			{null=java04, 01=PJAVA01, 02=java02}
*/