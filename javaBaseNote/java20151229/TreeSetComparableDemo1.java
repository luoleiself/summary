/*
���Ͽ�ܣ�Collection(�ӿ�)�����ӿڡ�
				|--List(�ӿ�)��Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ��������
					|--ArrayList(��)���ײ�����ݽṹʹ�õ�����ṹ��jDk1.2��ʼ���ص㣺��ѯ�ٶȿ죬��ɾԪ���ٶ������̲߳�ͬ�������鳤�ȿɱ�ٷ�֮50�ӳ�����copy��ɾ����
					|--LinkedList(��)���ײ�ʹ�õ��������ݽṹ��jdk1.2��ʼ���̲߳�ͬ�����ص㣺��ѯ�ٶ�������ɾԪ���ٶȿ졣
					|--Vector(��)���ײ����������ݽṹ��jDk1.0��ʼ���߳�ͬ������ArrayList����ˡ����鳤�ȿɱ�ٷ�֮100�ӳ���
						
				|--Set(�ӿ�)��Ԫ���������(�����ȡ����˳��һ��һ��)��Ԫ�ز������ظ����ü�����ϵû��������
								Set���ϵĹ��ܺ�Collection���ϵĹ�����һ�µġ�
					|--HashSet(��)���ײ����ݽṹ�ǹ�ϣ��
								
					|--TreeSet(��)���ײ����ݽṹ�Ƕ�������
									���Զ�Set�����е�Ԫ�ؽ�������
									��֤Ԫ�ص�Ψһ�Ե����ݣ�CompareTo���� return 0;

TreeSet����ĵ�һ�ַ�ʽ����Ԫ������߱��Ƚ��ԣ�Ԫ����Ҫʵ��Comparable�ӿڣ�
						 ����compareTo���������߽���Ĭ��˳��

����ʲô����ʽ������Ҫ������ͬʱ��һ��Ҫ�ж�һ�δ�Ҫ������			

Comparable(�ӿ�)������
					int compareTo(T o);
								�Ƚϴ˶�����ָ�������˳��
 
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

