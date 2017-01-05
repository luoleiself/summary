/*
集合框架：Collection(接口)：根接口。
						|--List(接口)：元素是有序的，元素可以重复。因为该集合体系有索引。
								|--ArrayList(类)
								|--LinkedList(类)
								|--Vector(类)
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

系列表迭代器listIterator();
			
					boolean hasNext();				
						Iterator<E>接口中的方法，如果仍有元素可以迭代，则返回 true。示例：al.hasNext();
					E next();														
						Iterator<E>接口中的方法，返回迭代的下一个元素。		
					boolean hasPrevious();
						如果以逆向遍历列表，列表迭代器有多个元素，则返回 true。
					 E previous();
						返回列表中的前一个元素。
 

List特有的迭代器：ListIterator是Iterator的子接口。

在迭代时，不可以通过集合对对象的方法操作集合中的元素。因为会发生ConcurrentModificationException异常。
所以，在迭代器时，只能用迭代器的方法操作元素，可是Iterator方法是有限的，只能对元素进行判断，取出，删除的操作。
如果想要其他的操作例如添加，修改等，就需要使用其子接口ListIterator。

该接口只能通过List集合的listIterator方法获取。

*/
import Java.util.*;
class  ListIteratorTest1
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
		
		//程序修改后：
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

		//系列表迭代器：
		ListIterator it = al.listIterator();

		stringPrint("hasPrevious():"+it.hasPrevious());//正向遍历。
		while(it.hasNext())
		{
			stringPrint("next():"+it.next());
		}
		stringPrint("hasNext():"+it.hasNext());
		stringPrint("hasPrevious():"+it.hasPrevious());
		
		System.out.println("=======================================");
		
		stringPrint("hasNext():"+it.hasNext());//逆向遍历。
		while(it.hasPrevious())
		{
			stringPrint("Previous():"+it.Previous());
		}
		stringPrint("hasNext():"+it.hasNext());
		stringPrint("hasPrevious():"+it.hasPrevious());
	}
}
