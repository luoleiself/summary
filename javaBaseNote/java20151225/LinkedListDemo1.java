/*
���Ͽ�ܣ�Collection(�ӿ�)�����ӿڡ�
				|--List(�ӿ�)��Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ��������
					|--ArrayList(��)���ײ�����ݽṹʹ�õ�����ṹ��jDk1.2��ʼ���ص㣺��ѯ�ٶȿ죬��ɾԪ���ٶ������̲߳�ͬ�������鳤�ȿɱ�ٷ�֮50�ӳ�����copy��ɾ����
					|--LinkedList(��)���ײ�ʹ�õ��������ݽṹ��jdk1.2��ʼ���̲߳�ͬ�����ص㣺��ѯ�ٶ�������ɾԪ���ٶȿ졣
					|--Vector(��)���ײ����������ݽṹ��jDk1.0��ʼ���߳�ͬ������ArrayList����ˡ����鳤�ȿɱ�ٷ�֮100�ӳ���

				|--Set(�ӿ�)��Ԫ��������ģ�Ԫ�ز������ظ����ü�����ϵû��������
					|--HashSet(��)
					|--TreeSet(��)

LinkedList�ࣺ�����б�
	���췽����
		LinkedList();
				����һ�����б�
		LinkedList(Collection<? extends E> c);
				����һ������ָ�� collection �е�Ԫ�ص��б���ЩԪ�ذ��� collection �ĵ��������ص�˳�����С�
	���з�����
		void addFirst(E e);
		void addLast(E e);
				��ָ��Ԫ����ӵ����б��(��ʼ)��β��jdk1.5��ʼ�����������Ϊ�գ����׳�NoSuchElementException�쳣��
		E getFirst();
		E getLast();
				��ȡ�����Ƴ����б�ĵ�һ��(���һ��)Ԫ�ء�jdk1.5��ʼ�����������Ϊ�գ����׳�NoSuchElementException�쳣��
		E removeFirst();
		E removeLast(); 
				��ȡ���Ƴ����б��(��һ��)���һ��Ԫ�ء�jdk1.5��ʼ�����������Ϊ�գ����׳�NoSuchElementException�쳣��
		void offerFirst(E e);
		void offerLast(E e);
				��ָ��Ԫ����ӵ����б��(��ʼ)��β��jdk1.6��ʼ�����������Ϊ�գ����׳�null��
		E peekFirst();
		E peekLast();
				��ȡ�����Ƴ����б�ĵ�һ��(���һ��)Ԫ�ء�jdk1.6��ʼ�����������Ϊ�գ����׳�null��
		E pollFirst();
		E pollLast(); 
				��ȡ���Ƴ����б��(��һ��)���һ��Ԫ�ء�jdk1.6��ʼ�����������Ϊ�գ����׳�null��

boolean removeFirstOccurrence(Object o);
				�Ӵ��б����Ƴ���һ�γ��ֵ�ָ��Ԫ�أ���ͷ����β�������б�ʱ����jdk1.6��ʼ��

boolean removeLastOccurrence(Object o);
				�Ӵ��б����Ƴ����һ�γ��ֵ�ָ��Ԫ�أ���ͷ����β�������б�ʱ����jdk1.6��ʼ��
				
Iterator<E> descendingIterator();
				����������˳���ڴ�˫�˶��е�Ԫ���Ͻ��е����ĵ�������jdk1.6��ʼ��

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

		link.addFirst("java01");//link.addLast("java01");jdk1.6��ʼ��ʹ��offerFirst()��offerLast()������Ϊ���׳�null��
		link.addFirst("java02");//link.addLast("java02");jdk1.6��ʼ��ʹ��offerFirst()��offerLast()������Ϊ���׳�null��
		link.addFirst("java03");//link.addLast("java03");jdk1.6��ʼ��ʹ��offerFirst()��offerLast()������Ϊ���׳�null��
		link.addFirst("java04");//link.addLast("java04");jdk1.6��ʼ��ʹ��offerFirst()��offerLast()������Ϊ���׳�null��
		
		link.getFirst("java01");//link.getLast("java01");jdk1.6��ʼ��ʹ��peekFirst()��peekLast()������Ϊ���׳�null��
		link.getFirst("java02");//link.getLast("java02");jdk1.6��ʼ��ʹ��peekFirst()��peekLast()������Ϊ���׳�null��
		link.getFirst("java03");//link.getLast("java03");jdk1.6��ʼ��ʹ��peekFirst()��peekLast()������Ϊ���׳�null��
		link.getFirst("java04");//link.getLast("java04");jdk1.6��ʼ��ʹ��peekFirst()��peekLast()������Ϊ���׳�null��
		
		link.removeFirst("java01");//link.removeLast("java01");jdk1.6��ʼ��ʹ��pollFirst()��pollLast()������Ϊ���׳�null��
		link.removeFirst("java02");//link.removeLast("java02");jdk1.6��ʼ��ʹ��pollFirst()��pollLast()������Ϊ���׳�null��
		link.removeFirst("java03");//link.removeLast("java03");jdk1.6��ʼ��ʹ��pollFirst()��pollLast()������Ϊ���׳�null��
		link.removeFirst("java04");//link.removeLast("java04");jdk1.6��ʼ��ʹ��pollFirst()��pollLast()������Ϊ���׳�null��
		
		link.removeFirstOccurrence("java06");//���б����Ƴ���һ�γ��ֵ�java06��
		link.removeLastOccurrence("java06");//���б����Ƴ����һ�γ��ֵ�java06��
		
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
