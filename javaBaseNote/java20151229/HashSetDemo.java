/*
集合框架：Collection(接口)：根接口。
						|--List(接口)：元素是有序的，元素可以重复。因为该集合体系有索引。
								|--ArrayList(类)：底层的数据结构使用的数组结构。jDk1.2开始。特点：查询速度快，增删元素速度慢。线程不同步。数组长度可变百分之50延长，先copy后删除。
								|--LinkedList(类)：底层使用的链表数据结构。jdk1.2开始。线程不同步。特点：查询速度慢，增删元素速度快。
								|--Vector(类)：底层是数组数据结构。jDk1.0开始。线程同步。被ArrayList替代了。数组长度可变百分之100延长。
						
						|--Set(接口)：元素是无序的(存入和取出的顺序不一定一致)，元素不可以重复，该集合体系没有索引。
										Set集合的功能和Collection集合的功能是一致的。
								|--HashSet(类)：底层数据结构是哈希表。
								|--TreeSet(类)：

HashSet(类)：
			HashSet是如何保证元素唯一性的呢？
					是通过元素的两个方法：hashCode和equals来完成。
					如果元素的HashCode值相同，才会判断equals是否为true。
					如果元素的HashCode值不同，不会调用equals。

			注意：对于判断元素是否存在，以及删除等操作，依赖的方法是元素的HashCode和equals方法。

ArrayList增删查改依赖于equals方法。
HashSet增删查改依赖于HashCode和equals方法。
*/
class  HashSetDemo
{
	public static void strinPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		
		HashSet hs = new HashSet();

		stringPrint(hs.add("java01"));
		stringPrint(hs.add("java01"));//存入两个哈希值时先判断哈希值是否一致，如果是则判断元素
		hs.add("java02");
		stringPrint(hs.add("java03"));
		stringPrint(hs.add("java03"));
		hs.add("java04");

		//取出元素也使用迭代器；
		Iterator it = hs.iterator();

		while(it.hasNext())
		{
			stringPrint(it.next());
		}
	}
}
