import java.util.*;
class MyLinkedList
{
	private LinkedList link;
	MyLinkedList()
	{
		link = new LinkedList();
	}
	public void myAdd(Object obj)
	{
		link.addFirst(obj);
	}
	public Object myGet()
	{
		return link.removeLast();
	}
	public boolean isNull()
	{
		return link.isEmpty();
	}
}
class LinkedListTest1 
{
	public static void main(String[] args) 
	{
		MyLinkedList ml = new MyLinkedList();
		
		ml.myAdd("java001");
		ml.myAdd("java002");
		ml.myAdd("java003");
		ml.myAdd("java004");
		ml.myAdd("java005");
		ml.myAdd("java006");
		while (!ml.isNull())
		{
			System.out.println(ml.myGet());
		}
	}
}
