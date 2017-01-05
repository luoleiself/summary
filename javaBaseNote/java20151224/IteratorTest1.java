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
						|--List(接口)
								|--ArrayList(类)
								|--LinkedList(类)
								|--Vector(类)
						|--Set(接口)
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
Iterator<E>接口:
				Iterator iterator();
						返回在此 collection 的元素上进行迭代的迭代器。
						boolean hasNext();
							如果仍有元素可以迭代，则返回 true。
						 E next();
							返回迭代的下一个元素。
						void remove();
							从迭代器指向的 collection 中移除迭代器返回的最后一个元素（可选操作）。

把取出方式定义在集合的内部，这样取出方式就可以直接访问集合内部的元素。
那么取出方式就被定义成了内部类，而每一个容器的数据结构不同，所以取出的动作细节不一样，
但是都有共性内容判断和取出，那么就可以将共性内容抽取。这些内部类都符合一个规则：Iterator。

如何获取集合的去处对象？
		通过一个对外提供的方法：iterator();
*/
import Java.util.*;
class  IteratorTest1
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void iteratorMethod()
	{
		ArrayList al = new ArrayList();

		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");

		Iterator it = al.iterator();//获取迭代器，用于取出集合中的元素。
		 while (al.hasNext())
		 {
			 stringPrint(al.next());
		 }
		 //下面使用for循环和使用while循环区别不大，主要区别是while循环在内存中对象的生存周期长，不易节省内存空间。
		 /*
		 for (Iterator it = al.iterator();al.hasNext(); )
		 {
			 stringPrint(al.next());
		 }
		 */
	}
	public static void base_method()
	{
		ArrayList al = new ArrayList();

		//1，添加元素。
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		//创建一个集合容器，使用Collection接口的子类，ArrayList

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
	public static void main(String[] args) 
	{
		//演示列表迭代器：
		ArrayList al = new ArrayList();

		//1，添加元素。
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		//在迭代过程中，准备添加或者删除元素。
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if (obj.equals("java02"))
			{
				it.set("java09");
				//容易抛出运行异常：ConcurrentModificationException。因为迭代器时并发操作。
			}
			stringPrint("al.next:"+it.next());
		}
		
		//程序修改后：系列表迭代器。
		ListIterator it = al.listIterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if (obj.equals("java02"))
			{
				it.set("java09");
			}
			stringPrint("al.next:"+it.next());
		}
	}
}
