/*
集合框架工具类。
Arrays(类)：此类包含用来操作数组（比如排序和搜索）的各种方法。jdk1.2开始，
			此类还包含一个允许将数组作为列表来查看的静态工厂。
			除非特别注明，否则如果指定数组引用为 null，则此类中的方法都会抛出 NullPointerException。
		1，里面都是静态方法。
	static <T> List<T> asList(T... a);
				返回一个受指定数组支持的固定大小的列表。
	static int binarySearch(byte/char/double/float/int/long/short(object)[] a, byte key);
				使用二分搜索法来搜索指定的byte/char/double/float/int/long/short(object)型数组，以获得指定的值(object)。
	static ?[] copyOf(boolean/byte/char/double/float/int/long/short[] original, int newLength);
				复制指定的数组，截取或用 false 填充（如有必要），以使副本具有指定的长度。
	static ?[] copyOfRange(boolean[] original, int from, int to);
				将指定数组的指定范围复制到一个新数组。
	static boolean deepEquals(Object[] a1, Object[] a2);
				如果两个指定数组彼此是深层相等 的，则返回 true。
	static void fill(boolean[] a, boolean val);
				将指定的 boolean 值分配给指定 boolean 型数组的每个元素。
	static void sort(byte[] a);
				对指定的 byte 型数组按数字升序进行排序。
	static String toString(boolean[] a);
				返回指定数组内容的字符串表示形式。

如果数组中的元素都是对象那么变成集合时，数组中的元素就直接转成集合中的元素。
如果数组中的元素都是基本数据类型，那么会将该数组作为集合中的元素存在。

注意：将数组变成集合，不可以使用集合的增删方法，因为数组的长度是固定的。
	可以使用的方法：
					contains();
					get();
					indexOf();
					subList();
	  如果增删，将会发生UnsupportedOperationException不支持的操作异常。	
*/
import java.util.*;
class  ArraysDemo1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void asListMethod()
	{
//		String [] arr = {"aaa","dfsg","vcsad"};
	
//		stringPrint(arr);
//		List<String> list = Arrays.asList(arr);

//		stringPrint("contains:"+list.contains("cc"));

//		list.add("java001");
		//UnsupportedOperationException不支持的操作异常。

//		stringPrint(arr);
	}
	public static void main(String[] args) 
	{
		//asListMethod();
		int [] arr = {2,3,4,5};

		List<int[]> list = Arrays.asList(arr);
		
		stringPrint(arr);
		//输出结果为数组的哈希值。

		Integer [] arr1 = {2,3,4,5};

		List<Integer> list = Arrays.asList(arr1);//泛型为Integer类型。

		stringPrint(arr1);
		//输出结果为：[2,3,4,5]
	}
}
