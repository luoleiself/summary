/*
集合框架工具类。
Collections(类)：此类完全由在 collection 上进行操作或返回 collection 的静态方法组成。jdk1.2开始。
					此类不能实例化，就像一个工具类，服务于Java的Collection框架。
	static <T> boolean addAll(Collection<? super T> c, T... elements);
						将所有指定元素添加到指定 collection 中。
	static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key);
						使用二分搜索法搜索指定列表，以获得指定对象。
	static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c);
						使用二分搜索法搜索指定列表，以获得指定对象。
	static <K,V> SortedMap<K,V> checkedSortedMap(SortedMap<K,V> m, Class<K> keyType, Class<V> valueType);
						返回指定有序映射的一个动态类型安全视图。
	static <T> void copy(List<? super T> dest, List<? extends T> src);
						将所有元素从一个列表复制到另一个列表。
	static <T> void fill(List<? super T> list, T obj);
						使用指定元素替换指定列表中的所有元素。
	static int indexOfSubList(List<?> source, List<?> target);
						返回指定源列表中第一次出现指定目标列表的起始位置；如果没有出现这样的列表，则返回 -1。
	static int lastIndexOfSubList(List<?> source, List<?> target);
						返回指定源列表中最后一次出现指定目标列表的起始位置；如果没有出现这样的列表，则返回 -1。
	static <T> ArrayList<T> list(Enumeration<T> e);
						返回一个数组列表，它按返回顺序包含指定枚举返回的元素。
	static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp);
						根据指定比较器产生的顺序，返回给定 collection 的最大元素。
	static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp);
						根据指定比较器产生的顺序，返回给定 collection 的最小元素。
	static <T> boolean replaceAll(List<T> list, T oldVal, T newVal);
						使用另一个值替换列表中出现的所有某一指定值。
	static void reverse(List<?> list);
						反转指定列表中元素的顺序。
	static <T> Comparator<T> reverseOrder();
						返回一个比较器，它强行逆转实现了 Comparable 接口的对象 collection 的自然顺序。
	static <T> Comparator<T> reverseOrder(Comparator<T> cmp);
						返回一个比较器，它强行逆转指定比较器的顺序。
	static void shuffle(List<?> list);
						使用默认随机源对指定列表进行置换。
	static void shuffle(List<?> list, Random rnd);
						使用指定的随机源对指定列表进行置换。
	static <T extends Comparable<? super T>> void sort(List<T> list);
						根据元素的自然顺序 对指定列表按升序进行排序。
	static <T> void sort(List<T> list, Comparator<? super T> c);
						根据指定比较器产生的顺序对指定列表进行排序。
	static void swap(List<?> list, int i, int j);
						在指定列表的指定位置处交换元素。
	static <T> Collection<T> synchronizedCollection/List/Map/set(Collection<T> c);
						返回指定 collection /List/Map/set 支持的同步（线程安全的）collection/List/Map/set。
*/
import java.util.*;
import java.lang.*;
class StrLenComparator implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		if (s1.length()>s2.length())
		{
			return 1;
		}
		else if (s1.length()<s2.length())
		{
			return -1;
		}
		return s1.compareTo(s2);
	}
}
class  CollectionsDemo1 
{
	public static void main(String[] args) 
	{
		
		reverseOrderMethod();
	}
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void reverseOrderMethod()//返回一个比较器，它强行逆转指定比较器的顺序。
	{
		TreeSet<String> tr = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator()));

		tr.add("abcdfg");
		tr.add("dkhghja");
		tr.add("dn");
		tr.add("cfg");

		Iterator it = tr.iterator();
		while (it.hasNext())
		{
			stringPrint(it.next());
		}
	}
	/*
	输出结果：
			dkhghja
			abcdfg
			cfg
			dn
	*/
	public static void collectionsMethod()
	{
		List<String> list = new ArrayList<String>();

		list.add("abcdfg");
		list.add("dkhghja");
		list.add("dn");
		list.add("cfg");
		
		//添加元素：
		stringPrint(list);
		Collections.addAll(list,"java001");
		stringPrint(list);

		//二分搜索法查找元素：
		stringPrint(list);
		Collections.binarySearch(list,"dn");

		//全部替换元素；
		Collections.fill(list,"hahaha");
		stringPrint(list);

		//部分替换元素：
		Collections.replaceAll(list,"cfg","Hello Java");
		stringPrint(list);

		//元素顺序反转：
		Collections.reverse(list);
		stringPrint(list);

		//随即置换元素顺序：
		Collections.shuffle(list);
		stringPrint(list);

		//元素排序：
		stringPrint(list);
		Collections.sort(list);
		stringPrint(list);

		//指定元素位置置换；
		stringPrint(list);
		Collections.swap(list,"dn","cfg");
		stringPrint(list);
	}
}
