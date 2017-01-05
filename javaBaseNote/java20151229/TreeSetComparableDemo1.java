/*
集合框架：Collection(接口)：根接口。
				|--List(接口)：元素是有序的，元素可以重复。因为该集合体系有索引。
					|--ArrayList(类)：底层的数据结构使用的数组结构。jDk1.2开始。特点：查询速度快，增删元素速度慢。线程不同步。数组长度可变百分之50延长，先copy后删除。
					|--LinkedList(类)：底层使用的链表数据结构。jdk1.2开始。线程不同步。特点：查询速度慢，增删元素速度快。
					|--Vector(类)：底层是数组数据结构。jDk1.0开始。线程同步。被ArrayList替代了。数组长度可变百分之100延长。
						
				|--Set(接口)：元素是无序的(存入和取出的顺序不一定一致)，元素不可以重复，该集合体系没有索引。
								Set集合的功能和Collection集合的功能是一致的。
					|--HashSet(类)：底层数据结构是哈希表。
								
					|--TreeSet(类)：底层数据结构是二叉树，
									可以对Set集合中的元素进行排序。
									保证元素的唯一性的依据：CompareTo方法 return 0;

TreeSet排序的第一种方式：让元素自审具备比较性，元素需要实现Comparable接口，
						 覆盖compareTo方法，或者叫做默认顺序。

不管什么排序方式：当主要条件相同时，一定要判断一次次要条件。			

Comparable(接口)方法：
					int compareTo(T o);
								比较此对象与指定对象的顺序。
 
*/
import java.util.*;
class  TreeSetComparableDemo1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		method1();
	}
	public static void  method1()
	{
		TreeSet tr = new TreeSet();

		tr.add("cbda");
		tr.add("adcb");
		tr.add("dacb");
		tr.add("cabd");
		tr.add("bcad");
		tr.add("dcba");
		tr.add("abcd");
		tr.add("badc");

		Iterator it = tr.iterator();
		while (it.hasNext())
		{
			stringPrint(it.next());
		}
	}
}

