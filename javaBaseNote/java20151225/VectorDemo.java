/*
���Ͽ�ܣ�Collection(�ӿ�)�����ӿڡ�
				|--List(�ӿ�)��Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ��������
					|--ArrayList(��)���ײ�����ݽṹʹ�õ�����ṹ��jDk1.2��ʼ���ص㣺��ѯ�ٶȿ죬��ɾԪ���ٶ������̲߳�ͬ�������鳤�ȿɱ�ٷ�֮50�ӳ�����copy��ɾ����
					|--LinkedList(��)���ײ�ʹ�õ��������ݽṹ��jdk1.2��ʼ���̲߳�ͬ�����ص㣺��ѯ�ٶ�������ɾԪ���ٶȿ졣
					|--Vector(��)���ײ����������ݽṹ��jDk1.0��ʼ���߳�ͬ������ArrayList����ˡ����鳤�ȿɱ�ٷ�֮100�ӳ���

				|--Set(�ӿ�)��Ԫ��������ģ�Ԫ�ز������ظ����ü�����ϵû��������
					|--HashSet(��)
					|--TreeSet(��)

ö�٣�Vector������е�ȡ����ʽ��jDk1.0��ʼ��
		����ö�ٺ͵�����������ʵö�ٺ͵�����һ���ģ���Ϊö�ٵ������Լ����������ƶ����������Ա�������ȡ����

Vector������
		���췽����
			Vector();
					����һ����������ʹ���ڲ���������Ĵ�СΪ 10�����׼��������Ϊ�㡣
			Vector(Collection<? extends E> c);
					����һ������ָ�� collection �е�Ԫ�ص���������ЩԪ�ذ��� collection �ĵ���������Ԫ�ص�˳�����С�
			Vector(int initialCapacity);
					ʹ��ָ���ĳ�ʼ�����͵������������������һ����������
			Vector(int initialCapacity, int capacityIncrement);
					ʹ��ָ���ĳ�ʼ������������������һ���յ�������
			void addElement(E obj);
					��ָ���������ӵ���������ĩβ�������С���� 1��
		int capacity();
					���ش������ĵ�ǰ������
		Enumeration<E> elements();
					���ش������������ö�١�
		void copyInto(Object[] anArray);
					����������������Ƶ�ָ���������С�
		E elementAt(int index);
					����ָ���������������
		void ensureCapacity(int minCapacity);
					���Ӵ����������������б�Ҫ������ȷ���������ܹ�������С��������ָ�����������
		E firstElement();
					���ش������ĵ�һ�������λ������ 0) �������
		void insertElementAt(E obj, int index);
					��ָ��������Ϊ�������е�������뵽ָ���� index ����
		E lastElement();
					���ش����������һ�������
		void setElementAt(E obj, int index);
					��������ָ�� index �����������Ϊָ���Ķ���
		List<E> subList(int fromIndex, int toIndex);
					���ش� List �Ĳ�����ͼ��Ԫ�ط�ΧΪ�� fromIndex���������� toIndex������������
		void trimToSize();
					�Դ���������������΢����ʹ����������ĵ�ǰ��С��
	

Enumeration�ӿڣ�jDK1.0��ʼ
				ʵ�� Enumeration �ӿڵĶ���������һϵ��Ԫ�أ�һ������һ����
				�������� nextElement ����������һϵ�е�����Ԫ�ء��˽ӿڵĹ����� Iterator �ӿڵĹ������ظ��ġ�
				���⣬Iterator �ӿ������һ����ѡ���Ƴ���������ʹ�ý϶̵ķ�������
				�µ�ʵ��Ӧ�����ȿ���ʹ�� Iterator �ӿڶ����� Enumeration �ӿڡ�

Enumeration������
		boolean hasMoreElements();
				���Դ�ö���Ƿ���������Ԫ�ء�
		E nextElement();
				�����ö�ٶ������ٻ���һ�����ṩ��Ԫ�أ��򷵻ش�ö�ٵ���һ��Ԫ�ء�
 
*/
import java.util.*;
class  VectorDemo
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void method1()
	{
		Vector v = new Vector();

		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");

		v.insertElementAt("java05",2);//��List�е�add�����÷����ƣ����Ԫ�ء�
		stringPrint("�¼����ǣ�"+v);
		
		stringPrint(v.elementAt(3));//����Ԫ�ص�������

		v.removeElement(3);//ɾ��Ԫ�ء�

		v.setElementAt("java06",1);//��list�е�set�����÷����ơ��޸�Ԫ�أ�
		stringPrint("�¼����ǣ�"+v);

		Enumeration en = v.elements();//�˴����ص����գ��÷���Iterator i = v.iterator();ListIterator li = v.listiterator();���ƣ�
		
		while (en.hasMoreElements())
		{
			stringPrint(en.nextElement());
		}
	}
	public static void main(String[] args) 
	{
		
	}
}
