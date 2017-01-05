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
				|--List(�ӿ�)��Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ��������
					|--ArrayList(��)���ײ�����ݽṹʹ�õ�����ṹ��jDk1.2��ʼ���ص㣺��ѯ�ٶȿ죬��ɾԪ���ٶ������̲߳�ͬ�������鳤�ȿɱ�ٷ�֮50�ӳ�����copy��ɾ����
					|--LinkedList(��)���ײ�ʹ�õ��������ݽṹ��jdk1.2��ʼ���̲߳�ͬ�����ص㣺��ѯ�ٶ�������ɾԪ���ٶȿ졣
					|--Vector(��)���ײ����������ݽṹ��jDk1.0��ʼ���߳�ͬ������ArrayList����ˡ����鳤�ȿɱ�ٷ�֮100�ӳ���

				|--Set(�ӿ�)��Ԫ��������ģ�Ԫ�ز������ظ����ü�����ϵû��������
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
		//����һ������������ʹ��Collection�ӿڵ����࣬ArrayList
		ArrayList al = new ArrayList();

		//1�����Ԫ�ء�
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");

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
}
