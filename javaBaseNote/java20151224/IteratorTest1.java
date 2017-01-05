/*
�����ࣺ����������Զ���������ֶ����Զ������ʽ��Ϊ�˷���Զ������Ĳ������ͶԶ�����д洢��
		�����Ǵ洢�����쳣�õ�һ�ַ�ʽ��

����ͼ�����ͬ��������
				����
					1��������Դ洢���󣬵��ǳ����ǹ̶��ģ�������Դ洢�����������͡�
					2������ֻ�ܴ洢����
				
				�ص㣺
					1��ֻ�ܴ洢����
					2�����ϳ����ǿɱ�ģ�
					3�����Ͽ��Դ洢��ͬ�������͵Ķ���

Ϊʲô�������ô���������
	��Ϊÿһ�����������ݵĴ洢��ʽ����ͬ������洢��ʽ��֮Ϊ�����ݽṹ��
		
���Ͽ�ܣ�Collection(�ӿ�)�����ӿڡ�
						|--List(�ӿ�)
								|--ArrayList(��)
								|--LinkedList(��)
								|--Vector(��)
						|--Set(�ӿ�)
								|--HashSet(��)
								|--TreeSet(��)

1��add�����Ĳ���������Objecr,�Ա��ڽ����������Ͷ���
2�������д洢�Ķ��Ƕ��������(��ַ)��

Collection�еķ�����
				boolean add(E e);
						��ָ����Ԫ����ӵ����б��β����
				void add(int index, E element);
						��ָ����Ԫ�ز�����б��е�ָ��λ�á�
				boolean addAll(Collection<? extends E> c);
						����ָ�� collection �ĵ����������ص�Ԫ��˳�򣬽��� collection �е�����Ԫ����ӵ����б��β����
				boolean addAll(int index, Collection<? extends E> c);
						��ָ����λ�ÿ�ʼ����ָ�� collection �е�����Ԫ�ز��뵽���б��С�
				void clear();
						�Ƴ����б��е�����Ԫ�ء�
				boolean contains(Object o);
						������б��а���ָ����Ԫ�أ��򷵻� true��
				boolean isEmpty(); 
						������б���û��Ԫ�أ��򷵻� true��
				Object remove(int index);
						�Ƴ����б���ָ��λ���ϵ�Ԫ�ء�
				boolean remove(Object o);
						�Ƴ����б����״γ��ֵ�ָ��Ԫ�أ�������ڣ���
				boolean removeAll(Collection<?> c);
						���б����Ƴ�ָ�� collection �а�����������Ԫ�أ���ѡ�����������������al1��ֻ�ᱣ����al2�в���ͬ��Ԫ�ء�
				boolean retainAll(Collection<?> c);
						 �����б��б���ָ�� collection ����������Ԫ�أ���ѡ������������������al1��ֻ�ᱣ����al2����ͬ��Ԫ�ء�
				int size();
						�����б��е�Ԫ������
				E set(int index, E element);
						��ָ����Ԫ��������б���ָ��λ���ϵ�Ԫ�ء�
Iterator<E>�ӿ�:
				Iterator iterator();
						�����ڴ� collection ��Ԫ���Ͻ��е����ĵ�������
						boolean hasNext();
							�������Ԫ�ؿ��Ե������򷵻� true��
						 E next();
							���ص�������һ��Ԫ�ء�
						void remove();
							�ӵ�����ָ��� collection ���Ƴ����������ص����һ��Ԫ�أ���ѡ��������

��ȡ����ʽ�����ڼ��ϵ��ڲ�������ȡ����ʽ�Ϳ���ֱ�ӷ��ʼ����ڲ���Ԫ�ء�
��ôȡ����ʽ�ͱ���������ڲ��࣬��ÿһ�����������ݽṹ��ͬ������ȡ���Ķ���ϸ�ڲ�һ����
���Ƕ��й��������жϺ�ȡ������ô�Ϳ��Խ��������ݳ�ȡ����Щ�ڲ��඼����һ������Iterator��

��λ�ȡ���ϵ�ȥ������
		ͨ��һ�������ṩ�ķ�����iterator();
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

		Iterator it = al.iterator();//��ȡ������������ȡ�������е�Ԫ�ء�
		 while (al.hasNext())
		 {
			 stringPrint(al.next());
		 }
		 //����ʹ��forѭ����ʹ��whileѭ�����𲻴���Ҫ������whileѭ�����ڴ��ж�����������ڳ������׽�ʡ�ڴ�ռ䡣
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

		//1�����Ԫ�ء�
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		//����һ������������ʹ��Collection�ӿڵ����࣬ArrayList

		//��ӡ����;
		stringPrint(al);

		//2����ȡ���������ϳ��ȡ�
		stringPrint("size:"+al.size());

		//3��ɾ��Ԫ��
		stringPrint(al.remove("Java02"));
		stringPrint(al.clear());

		//4���ж�Ԫ��
		stringPrint("java02�Ƿ���ڣ�"+al.contains("java02"));
		stringPrint("�����Ƿ�Ϊ�գ�"+al.isEmpty());
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
		
		al1.removeAll(al2);//���������al1��ֻ�ᱣ����al2�в���ͬ��Ԫ�ء�
		//al1.retainAll(al2);//����������al1��ֻ�ᱣ����al2����ͬ��Ԫ�ء�

		stringPrint("al1:"+al1);
		stringPrint("al2:"+al2);
	}
	public static void main(String[] args) 
	{
		//��ʾ�б��������
		ArrayList al = new ArrayList();

		//1�����Ԫ�ء�
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		//�ڵ��������У�׼����ӻ���ɾ��Ԫ�ء�
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if (obj.equals("java02"))
			{
				it.set("java09");
				//�����׳������쳣��ConcurrentModificationException����Ϊ������ʱ����������
			}
			stringPrint("al.next:"+it.next());
		}
		
		//�����޸ĺ�ϵ�б��������
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
