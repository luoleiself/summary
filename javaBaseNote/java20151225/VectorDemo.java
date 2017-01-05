/*
集合框架：Collection(接口)：根接口。
				|--List(接口)：元素是有序的，元素可以重复。因为该集合体系有索引。
					|--ArrayList(类)：底层的数据结构使用的数组结构。jDk1.2开始。特点：查询速度快，增删元素速度慢。线程不同步。数组长度可变百分之50延长，先copy后删除。
					|--LinkedList(类)：底层使用的链表数据结构。jdk1.2开始。线程不同步。特点：查询速度慢，增删元素速度快。
					|--Vector(类)：底层是数组数据结构。jDk1.0开始。线程同步。被ArrayList替代了。数组长度可变百分之100延长。

				|--Set(接口)：元素是无序的，元素不可以重复，该集合体系没有索引。
					|--HashSet(类)
					|--TreeSet(类)

枚举：Vector类的特有的取出方式。jDk1.0开始。
		发现枚举和迭代器很像，其实枚举和迭代是一样的，因为枚举的名称以及方法的名称都过长，所以被迭代器取代。

Vector方法：
		构造方法：
			Vector();
					构造一个空向量，使其内部数据数组的大小为 10，其标准容量增量为零。
			Vector(Collection<? extends E> c);
					构造一个包含指定 collection 中的元素的向量，这些元素按其 collection 的迭代器返回元素的顺序排列。
			Vector(int initialCapacity);
					使用指定的初始容量和等于零的容量增量构造一个空向量。
			Vector(int initialCapacity, int capacityIncrement);
					使用指定的初始容量和容量增量构造一个空的向量。
			void addElement(E obj);
					将指定的组件添加到此向量的末尾，将其大小增加 1。
		int capacity();
					返回此向量的当前容量。
		Enumeration<E> elements();
					返回此向量的组件的枚举。
		void copyInto(Object[] anArray);
					将此向量的组件复制到指定的数组中。
		E elementAt(int index);
					返回指定索引处的组件。
		void ensureCapacity(int minCapacity);
					增加此向量的容量（如有必要），以确保其至少能够保存最小容量参数指定的组件数。
		E firstElement();
					返回此向量的第一个组件（位于索引 0) 处的项）。
		void insertElementAt(E obj, int index);
					将指定对象作为此向量中的组件插入到指定的 index 处。
		E lastElement();
					返回此向量的最后一个组件。
		void setElementAt(E obj, int index);
					将此向量指定 index 处的组件设置为指定的对象。
		List<E> subList(int fromIndex, int toIndex);
					返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。
		void trimToSize();
					对此向量的容量进行微调，使其等于向量的当前大小。
	

Enumeration接口：jDK1.0开始
				实现 Enumeration 接口的对象，它生成一系列元素，一次生成一个。
				连续调用 nextElement 方法将返回一系列的连续元素。此接口的功能与 Iterator 接口的功能是重复的。
				此外，Iterator 接口添加了一个可选的移除操作，并使用较短的方法名。
				新的实现应该优先考虑使用 Iterator 接口而不是 Enumeration 接口。

Enumeration方法：
		boolean hasMoreElements();
				测试此枚举是否包含更多的元素。
		E nextElement();
				如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。
 
*/
import java.util.*;
class  VectorDemo
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void method1()
	{
		Vector v = new Vector();

		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");

		v.insertElementAt("java05",2);//和List中的add方法用法相似，添加元素。
		stringPrint("新集合是："+v);
		
		stringPrint(v.elementAt(3));//返回元素的索引。

		v.removeElement(3);//删除元素。

		v.setElementAt("java06",1);//和list中的set方法用法相似。修改元素，
		stringPrint("新集合是："+v);

		Enumeration en = v.elements();//此处需重点掌握，用法和Iterator i = v.iterator();ListIterator li = v.listiterator();相似，
		
		while (en.hasMoreElements())
		{
			stringPrint(en.nextElement());
		}
	}
	public static void main(String[] args) 
	{
		
	}
}
