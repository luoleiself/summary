/*
集合框架：Collection(接口)：根接口。
				|--List(接口)：元素是有序的，元素可以重复。因为该集合体系有索引。
					|--ArrayList(类)：底层的数据结构使用的数组结构。jDk1.2开始。特点：查询速度快，增删元素速度慢。线程不同步。数组长度可变百分之50延长，先copy后删除。
					|--LinkedList(类)：底层使用的链表数据结构。jdk1.2开始。线程不同步。特点：查询速度慢，增删元素速度快。
					|--Vector(类)：底层是数组数据结构。jDk1.0开始。线程同步。被ArrayList替代了。数组长度可变百分之100延长。

				|--Set(接口)：元素是无序的，元素不可以重复，该集合体系没有索引。
					|--HashSet(类)
					|--TreeSet(类)

LinkedList类：链接列表。
	构造方法：
		LinkedList();
				构造一个空列表。
		LinkedList(Collection<? extends E> c);
				构造一个包含指定 collection 中的元素的列表，这些元素按其 collection 的迭代器返回的顺序排列。
	特有方法：
		void addFirst(E e);
		void addLast(E e);
				将指定元素添加到此列表的(开始)结尾。jdk1.5开始，如果集合中为空，则抛出NoSuchElementException异常。
		E getFirst();
		E getLast();
				获取但不移除此列表的第一个(最后一个)元素。jdk1.5开始，如果集合中为空，则抛出NoSuchElementException异常。
		E removeFirst();
		E removeLast(); 
				获取并移除此列表的(第一个)最后一个元素。jdk1.5开始，如果集合中为空，则抛出NoSuchElementException异常。
		void offerFirst(E e);
		void offerLast(E e);
				将指定元素添加到此列表的(开始)结尾。jdk1.6开始，如果集合中为空，则抛出null。
		E peekFirst();
		E peekLast();
				获取但不移除此列表的第一个(最后一个)元素。jdk1.6开始，如果集合中为空，则抛出null。
		E pollFirst();
		E pollLast(); 
				获取并移除此列表的(第一个)最后一个元素。jdk1.6开始，如果集合中为空，则抛出null。

boolean removeFirstOccurrence(Object o);
				从此列表中移除第一次出现的指定元素（从头部到尾部遍历列表时）。jdk1.6开始。

boolean removeLastOccurrence(Object o);
				从此列表中移除最后一次出现的指定元素（从头部到尾部遍历列表时）。jdk1.6开始。
				
Iterator<E> descendingIterator();
				返回以逆向顺序在此双端队列的元素上进行迭代的迭代器。jdk1.6开始。

*/
import java.util.*;
class LinkedListDemo1 
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void method1()
	{
		LinkedList link = new LinkedList();

		link.addFirst("java01");//link.addLast("java01");jdk1.6开始后，使用offerFirst()和offerLast()。集合为空抛出null。
		link.addFirst("java02");//link.addLast("java02");jdk1.6开始后，使用offerFirst()和offerLast()。集合为空抛出null。
		link.addFirst("java03");//link.addLast("java03");jdk1.6开始后，使用offerFirst()和offerLast()。集合为空抛出null。
		link.addFirst("java04");//link.addLast("java04");jdk1.6开始后，使用offerFirst()和offerLast()。集合为空抛出null。
		
		link.getFirst("java01");//link.getLast("java01");jdk1.6开始后，使用peekFirst()和peekLast()。集合为空抛出null。
		link.getFirst("java02");//link.getLast("java02");jdk1.6开始后，使用peekFirst()和peekLast()。集合为空抛出null。
		link.getFirst("java03");//link.getLast("java03");jdk1.6开始后，使用peekFirst()和peekLast()。集合为空抛出null。
		link.getFirst("java04");//link.getLast("java04");jdk1.6开始后，使用peekFirst()和peekLast()。集合为空抛出null。
		
		link.removeFirst("java01");//link.removeLast("java01");jdk1.6开始后，使用pollFirst()和pollLast()。集合为空抛出null。
		link.removeFirst("java02");//link.removeLast("java02");jdk1.6开始后，使用pollFirst()和pollLast()。集合为空抛出null。
		link.removeFirst("java03");//link.removeLast("java03");jdk1.6开始后，使用pollFirst()和pollLast()。集合为空抛出null。
		link.removeFirst("java04");//link.removeLast("java04");jdk1.6开始后，使用pollFirst()和pollLast()。集合为空抛出null。
		
		link.removeFirstOccurrence("java06");//从列表中移除第一次出现的java06。
		link.removeLastOccurrence("java06");//从列表中移除最后一次出现的java06。
		
		Iterator it = link.descendingIterator();
		while (it.isEmpty())
		{
			stringPrtint(it.descendingIterator());
		}
	}
	public static void main(String[] args) 
	{

	}
}
