/*
�߼�forѭ����
		��ʽ��
			for(�������� ���������������ļ���(Collection)��������)	

forѭ���Լ��Ͻ��б�����ֻ�ܻ�ȡԪ�أ����ǲ��ܶԼ��Ͻ��й��������

���������˱����������Խ���remove������Ԫ�صĶ�����
���ʹ��ListIterator���������ڱ��������жԼ��Ͻ�����ɾ�Ĳ�Ķ�����

��ͳforѭ���͸߼�forѭ��������
		1���߼�forѭ����һ�������ԣ������б�������Ŀ�ꡣ
			�����ڱ��������ʱ��ʹ�ô�ͳforѭ������Ϊ��ͳforѭ������Ǳꡣ
*/
import java.util.*;
class  ForEachDemo1
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("java001");
		al.add("java002");
		al.add("java003");
		al.add("java004");
		al.add("java005");

		for(String s: al)//for(Object s : al )ǰ��û��ָ������ʱ��
		{
			s = "kk";
			System.out.println(s);
		}
		
		System.out.println("===============================================");
		
		HashMap<Integer,String> hm = new HashMap<Integer,String>();

		hm.put(1,"a");
		hm.put(2,"b");
		hm.put(3,"c");
		hm.put(4,"d");

		Set<Integer> keySet = hm.keySet();
		for (Integer i : keySet)
		{
			System.out.println(i+"::"+hm.get(i));
		}

		System.out.println("===============================================");

//		Set<Map.Entry<Integer,String>> entrySet = hm.entrySet();
//		for(Map.Entry<Integer,String> me : entrySet )

		for(Map.Entry<Integer,String> me : hm.entrySet())
		{
			System.out.println(me.getKey()+"======"+me.getValue());
		}	
	}
}
