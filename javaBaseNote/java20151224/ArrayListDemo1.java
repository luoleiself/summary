/*
集合框架：Collection(接口)：根接口。
						|--List(接口)：元素是有序的，元素可以重复。因为该集合体系有索引。
								|--ArrayList(类)：底层的数据结构使用的数组结构。jDk1.2开始。特点：查询速度快，增删元素速度慢。线程不同步。数组长度可变百分之50延长，先copy后删除。
								|--LinkedList(类)：底层使用的链表数据结构。jdk1.2开始。线程不同步。特点：查询速度慢，增删元素速度快。
								|--Vector(类)：底层是数组数据结构。jDk1.0开始。线程同步。被ArrayList替代了。数组长度可变百分之100延长。
						|--Set(接口)：元素是无序的，元素不可以重复，该集合体系没有索引。
								|--HashSet(类)
								|--TreeSet(类)

List：
	集合特有方法：凡是可以操作角标的方法都是该体系特有的方法。
		增：
			add(index,element);
			addAll(index,Collection);
		删：
			remove(index);
		改：
			set(index,element);
		查：
			get(ine index);
			subList(int fromindex,int toindex);
			
			listIterator();

ArrayList类：
			List 接口的大小可变数组的实现。实现了所有可选列表操作，并允许包括 null 在内的所有元素。
			除了实现 List 接口外，此类还提供一些方法来操作内部用来存储列表的数组的大小。
			此类大致上等同于 Vector 类，除了此类是不同步的。

每个 ArrayList 实例都有一个容量。该容量是指用来存储列表元素的数组的大小。它总是至少等于列表的大小。
随着向 ArrayList 中不断添加元素，其容量也自动增长。并未指定增长策略的细节，因为这不只是添加元素会带来分摊固定时间开销那样简单。

注意，此实现不是同步的。如果多个线程同时访问一个 ArrayList 实例，而其中至少一个线程从结构上修改了列表，那么它必须 保持外部同步。
（结构上的修改是指任何添加或删除一个或多个元素的操作，或者显式调整底层数组的大小；仅仅设置元素的值不是结构上的修改。）
这一般通过对自然封装该列表的对象进行同步操作来完成。如果不存在这样的对象，则应该使用 Collections.synchronizedList 方法将该列表“包装”起来。
这最好在创建时完成，以防止意外对列表进行不同步的访问：List list = Collections.synchronizedList(new ArrayList(...)); 

ArrayList方法：
			构造方法：
					ArrayList();
							构造一个初始容量为 10 的空列表。
					ArrayList(Collection<? extends E> c);
							构造一个包含指定 collection 的元素的列表，这些元素是按照该 collection 的迭代器返回它们的顺序排列的。
					ArrayList(int initialCapacity);
							构造一个具有指定初始容量的空列表。
			void trimToSize();
					将此 ArrayList 实例的容量调整为列表的当前大小。
*/
import Java.util.*;
class  ArrayListDemo1
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void method()
	{
		ArrayList al = new ArrayList();

		//1，添加元素。
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		

		//在指定位置插入元素：
		stringPrint("原集合是："+al);
		al.add(1,"java08");
		stringPrint("新集合是："+al);

		//删除指定位置的元素：
		stringPrint("原集合是："+al);
		al.remove(2);
		stringPrint("新集合是："+al);

		//修改元素：
		stringPrint("原集合是："+al);
		al.set(3,"java05");
		stringPrint("新集合是："+al);

		//获取元素：
		stringPrint("原集合是："+al);
		al.get(1);
		stringPrint("新集合是："+al);

		//第一种方式：循环语句获取所有元素：
		for (int x=0;x<al.size();x++)//size和length的意思是一样的，但是用法不一样。
		{
			stringPrint("al("+x+")="+al.get(x));
		}

		//第二种方式：可以使用迭代器进行操作：
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			stringPrint("al.next:"+it.next());
		}

		//通过idexOf获取对象的位置：
		stringPrint("al.indexOf:"+it.indexOf("java03"));

		List sub = al.subList(1,3);
		stringPrint("sub="+sub);
	}
	public static void main(String[] args) 
	{
		
	}
}
