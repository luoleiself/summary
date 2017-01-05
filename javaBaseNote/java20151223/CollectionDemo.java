/*
集合类：面向对象语言对事物的体现都是以对象的形式，为了方便对多个对象的操作，就对对象进行存储。
		集合是存储对象嘴常用的一种方式。

数组和集合类同是容器。
				区别：
					1，数组可以存储对象，但是长度是固定的，数组可以存储基本数据类型。
					2，集合只能存储对象。
				
				特点：
					1，只能存储对象，
					2，集合长度是可变的，
					3，集合可以存储不同数据类型的对象。

为什么会出现这么多的容器？
	因为每一个容器对数据的存储方式都不同。这个存储方式称之为：数据结构。
		
集合框架：Collection(接口)：根接口。
				|--List(接口)：元素是有序的，元素可以重复。因为该集合体系有索引。
					|--ArrayList(类)：底层的数据结构使用的数组结构。jDk1.2开始。特点：查询速度快，增删元素速度慢。线程不同步。数组长度可变百分之50延长，先copy后删除。
					|--LinkedList(类)：底层使用的链表数据结构。jdk1.2开始。线程不同步。特点：查询速度慢，增删元素速度快。
					|--Vector(类)：底层是数组数据结构。jDk1.0开始。线程同步。被ArrayList替代了。数组长度可变百分之100延长。

				|--Set(接口)：元素是无序的，元素不可以重复，该集合体系没有索引。
					|--HashSet(类)
					|--TreeSet(类)

1，add方法的参数类型是Objecr,以便于接收任意类型对象。
2，集合中存储的都是对象的引用(地址)。

Collection中的方法：
				boolean add(E e);
						将指定的元素添加到此列表的尾部。
				void add(int index, E element);
						将指定的元素插入此列表中的指定位置。
				boolean addAll(Collection<? extends E> c);
						按照指定 collection 的迭代器所返回的元素顺序，将该 collection 中的所有元素添加到此列表的尾部。
				boolean addAll(int index, Collection<? extends E> c);
						从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。
				void clear();
						移除此列表中的所有元素。
				boolean contains(Object o);
						如果此列表中包含指定的元素，则返回 true。
				boolean isEmpty(); 
						如果此列表中没有元素，则返回 true。
				Object remove(int index);
						移除此列表中指定位置上的元素。
				boolean remove(Object o);
						移除此列表中首次出现的指定元素（如果存在）。
				boolean removeAll(Collection<?> c);
						从列表中移除指定 collection 中包含的其所有元素（可选操作）。清除交集，al1中只会保留和al2中不相同的元素。
				boolean retainAll(Collection<?> c);
						 仅在列表中保留指定 collection 中所包含的元素（可选操作）。保留交集，al1中只会保留和al2中相同的元素。
				int size();
						返回列表中的元素数。
				E set(int index, E element);
						用指定的元素替代此列表中指定位置上的元素。

*/
import Java.util.*;
class  CollectionDemo
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		base_method();
		method2();
	}
	public static void base_method()
	{
		//创建一个集合容器，使用Collection接口的子类，ArrayList
		ArrayList al = new ArrayList();

		//1，添加元素。
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");

		//打印集合;
		stringPrint(al);

		//2，获取个数，集合长度。
		stringPrint("size:"+al.size());

		//3，删除元素
		stringPrint(al.remove("Java02"));
		stringPrint(al.clear());

		//4，判断元素
		stringPrint("java02是否存在："+al.contains("java02"));
		stringPrint("集合是否为空："+al.isEmpty());
	}
	public static void method2()
	{
		ArrayList al1 = new ArrayList();
		al1.add("java01");
		al1.add("java02");
		al1.add("java03");
		al1.add("java04");

		ArrayList al2 = new ArrayList();
		al2.add("java03");
		al2.add("java04");
		al2.add("java05");
		al2.add("java06");
		
		al1.removeAll(al2);//清除交集，al1中只会保留和al2中不相同的元素。
		//al1.retainAll(al2);//保留交集，al1中只会保留和al2中相同的元素。

		stringPrint("al1:"+al1);
		stringPrint("al2:"+al2);
	}
}
