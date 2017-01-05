/*
泛型：jdk1.5开始出现的新特性，用于解决安全问题，是一个安全机制。

	好处：
		1，将运行时期出现问题ClassCastException，转移到了编译时期，
			方便程序员解决问题，让运行事情问题减少，安全。
		2，避免了强制类型转换的麻烦。

泛型格式：通过<>来定义要操作的引用数据类型。

在使用java提供的对象时，什么时候使用泛型？
	通常在集合框架中很常见，只要看到<>，就要定义泛型。
	其实<>就是用来接收类型的。
	
	当使用集合时，将集合中要存储的数据类型作为参数传递到<>中即可。
	
*/
import java.util.*;
class  GenericDemo1
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = nwe ArrayList<Stirng>();

		al.add("java001");
		al.add("java002");
		al.add("java003");
		al.add("java004");
		al.add(4);//a1.add(new Integer(4));
		
		Iterator<String> it = al.iterator();
		while (it.hasNext())//不用再类型转换。
		{
			stringPrint(it.next());
		}
	}
}

