/*
���Ͽ�ܹ����ࡣ
Collections(��)��������ȫ���� collection �Ͻ��в����򷵻� collection �ľ�̬������ɡ�jdk1.2��ʼ��
					���಻��ʵ����������һ�������࣬������Java��Collection��ܡ�
	static <T> boolean addAll(Collection<? super T> c, T... elements);
						������ָ��Ԫ����ӵ�ָ�� collection �С�
	static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key);
						ʹ�ö�������������ָ���б��Ի��ָ������
	static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c);
						ʹ�ö�������������ָ���б��Ի��ָ������
	static <K,V> SortedMap<K,V> checkedSortedMap(SortedMap<K,V> m, Class<K> keyType, Class<V> valueType);
						����ָ������ӳ���һ����̬���Ͱ�ȫ��ͼ��
	static <T> void copy(List<? super T> dest, List<? extends T> src);
						������Ԫ�ش�һ���б��Ƶ���һ���б�
	static <T> void fill(List<? super T> list, T obj);
						ʹ��ָ��Ԫ���滻ָ���б��е�����Ԫ�ء�
	static int indexOfSubList(List<?> source, List<?> target);
						����ָ��Դ�б��е�һ�γ���ָ��Ŀ���б����ʼλ�ã����û�г����������б��򷵻� -1��
	static int lastIndexOfSubList(List<?> source, List<?> target);
						����ָ��Դ�б������һ�γ���ָ��Ŀ���б����ʼλ�ã����û�г����������б��򷵻� -1��
	static <T> ArrayList<T> list(Enumeration<T> e);
						����һ�������б���������˳�����ָ��ö�ٷ��ص�Ԫ�ء�
	static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp);
						����ָ���Ƚ���������˳�򣬷��ظ��� collection �����Ԫ�ء�
	static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp);
						����ָ���Ƚ���������˳�򣬷��ظ��� collection ����СԪ�ء�
	static <T> boolean replaceAll(List<T> list, T oldVal, T newVal);
						ʹ����һ��ֵ�滻�б��г��ֵ�����ĳһָ��ֵ��
	static void reverse(List<?> list);
						��תָ���б���Ԫ�ص�˳��
	static <T> Comparator<T> reverseOrder();
						����һ���Ƚ�������ǿ����תʵ���� Comparable �ӿڵĶ��� collection ����Ȼ˳��
	static <T> Comparator<T> reverseOrder(Comparator<T> cmp);
						����һ���Ƚ�������ǿ����תָ���Ƚ�����˳��
	static void shuffle(List<?> list);
						ʹ��Ĭ�����Դ��ָ���б�����û���
	static void shuffle(List<?> list, Random rnd);
						ʹ��ָ�������Դ��ָ���б�����û���
	static <T extends Comparable<? super T>> void sort(List<T> list);
						����Ԫ�ص���Ȼ˳�� ��ָ���б������������
	static <T> void sort(List<T> list, Comparator<? super T> c);
						����ָ���Ƚ���������˳���ָ���б��������
	static void swap(List<?> list, int i, int j);
						��ָ���б��ָ��λ�ô�����Ԫ�ء�
	static <T> Collection<T> synchronizedCollection/List/Map/set(Collection<T> c);
						����ָ�� collection /List/Map/set ֧�ֵ�ͬ�����̰߳�ȫ�ģ�collection/List/Map/set��
*/
import java.util.*;
import java.lang.*;
class StrLenComparator implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		if (s1.length()>s2.length())
		{
			return 1;
		}
		else if (s1.length()<s2.length())
		{
			return -1;
		}
		return s1.compareTo(s2);
	}
}
class  CollectionsDemo1 
{
	public static void main(String[] args) 
	{
		
		reverseOrderMethod();
	}
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void reverseOrderMethod()//����һ���Ƚ�������ǿ����תָ���Ƚ�����˳��
	{
		TreeSet<String> tr = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator()));

		tr.add("abcdfg");
		tr.add("dkhghja");
		tr.add("dn");
		tr.add("cfg");

		Iterator it = tr.iterator();
		while (it.hasNext())
		{
			stringPrint(it.next());
		}
	}
	/*
	��������
			dkhghja
			abcdfg
			cfg
			dn
	*/
	public static void collectionsMethod()
	{
		List<String> list = new ArrayList<String>();

		list.add("abcdfg");
		list.add("dkhghja");
		list.add("dn");
		list.add("cfg");
		
		//���Ԫ�أ�
		stringPrint(list);
		Collections.addAll(list,"java001");
		stringPrint(list);

		//��������������Ԫ�أ�
		stringPrint(list);
		Collections.binarySearch(list,"dn");

		//ȫ���滻Ԫ�أ�
		Collections.fill(list,"hahaha");
		stringPrint(list);

		//�����滻Ԫ�أ�
		Collections.replaceAll(list,"cfg","Hello Java");
		stringPrint(list);

		//Ԫ��˳��ת��
		Collections.reverse(list);
		stringPrint(list);

		//�漴�û�Ԫ��˳��
		Collections.shuffle(list);
		stringPrint(list);

		//Ԫ������
		stringPrint(list);
		Collections.sort(list);
		stringPrint(list);

		//ָ��Ԫ��λ���û���
		stringPrint(list);
		Collections.swap(list,"dn","cfg");
		stringPrint(list);
	}
}
