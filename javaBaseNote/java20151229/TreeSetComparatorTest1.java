/*
��ϰ�������ַ�����������

�ַ�������߱��Ƚ��ԣ��������ıȽϷ�ʽ��������Ҫ�ġ���ʱֻ��ʹ�ñȽ�����

֪ʶ����ʾ���������õ�֮ǰѧϰ�������ڲ��ࡣ
*/
import java.util.*;
class  TreeSetComparatorTest1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		TreeSet tr = new TreeSet(new StringLengthComparator());

		tr.add("ldasaojnb");
		tr.add("sfda");
		tr.add("lgaljfda");
		tr.add("tnnbjqp");
		tr.add("uriaun");
		tr.add("vdhi");

		Iterator it = tr.iterator();
		while (it.hasNext())//while(!(it.isEmpty()))
		{
			stringPrint(it.next());	
		}
		
		//�������������ڲ��ཫ����д��һ�𣬵��Ķ��Խϲ
		/*
		TreeSet tr = new TreeSet(new Comparator()
		{
			public int compare(Object o1,Object o2)
			{
				String s1 = (String)o1;
				String s2 = (String)o2;
		
				//��һ�ַ���������ֱ�ӽ��г��ȱȽ�Ȼ�󷵻�
		
				if (s1.length()>s2.length())
				{
					return 1;
				}
				if (s1.length()==s2.length())
				{
					return s1.compareTo(s2);
				}
				ruturn -1;
		
				//�ڶ��ַ��������Խ��ַ����ĳ��ȷ�װ�ɶ�����бȽϡ�
				int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
				
				if (num==0)
				{
					return s1.compareTo(s2);
				}
				return num;			
			}
		});
		*/
	}
}
class StringLengthComparator implements Comparator//ʵ��Comparator�ӿڣ���д(����)compare������
{
	public int compare(Object o1,Object o2)
	{
		String s1 = (String)o1;
		String s2 = (String)o2;
		
		//��һ�ַ���������ֱ�ӽ��г��ȱȽ�Ȼ�󷵻�
		/*
		if (s1.length()>s2.length())
		{
			return 1;
		}
		if (s1.length()==s2.length())
		{
			return s1.compareTo(s2);
		}
		ruturn -1;
		*/
		
		//�ڶ��ַ��������Խ��ַ����ĳ��ȷ�װ�ɶ�����бȽϡ�
		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if (num==0)
		{
			return s1.compareTo(s2);
		}
		return num;
	}
}
//�ܽ᣺1������Ԫ�صıȽ�Ҫ�ۺϿ��ǣ����Ԫ�صĵ�һ��������ͬ�Ļ���Ҫ�Ƚ�Ԫ�ص���һ���򼸸����ԡ�
//		2������Ԫ�صıȽϿ��Խ��Ƚϵ����Է�װ�ɶ�����бȽϣ��Ż�����ṹ��
//		3��ͬʱ����ʹ�õ�֮ǰѧϰ�Ķ��������ڲ���Ĺ��ܣ��ŵ�����ϰ��֪ʶ��࣬ȱ���ǳ�����Ķ��Բ
