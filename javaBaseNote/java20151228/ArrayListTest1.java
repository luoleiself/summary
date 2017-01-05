/*
��ϰ��ȥ��ArrayList�����е��ظ�Ԫ�ء�

˼·��
	1�������½�һ�����ϡ���ԭ������ȡ��Ԫ�غ���¼����е�Ԫ�ؽ��бȽϣ�
	2��Ҫʹ�õ�contains(�ж�Ԫ���ڼ������Ƿ����)�ȽϷ��������Ԫ�ز���������뵽�¼����С�
	3���ж�ԭ�����Ƿ�Ϊ�գ�����¼��Ϸ��ء�

*/
import java.util.*;
class  ArrayListTest1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		
		al.add("java001");
		al.add("java002");
		al.add("java003");
		al.add("java004");
		al.add("java003");
		al.add("java002");
		al.add("java004");
		al.add("java001");

		stringPrint(al);
		
		al = singleElement(al);
		stringPrint(al);
	}
	public static ArrayList singleElement(ArrayList al)
	{
		ArrayList al2 = new ArrayList();//�½�һ�����鼯�ϣ�

		Iterator it = al.iterator();//�½�һ��������ָ����յ����鼯�ϡ�
		while(it.hasNext())
		{
			Object obj = it.next();
			if (!al2.contains(obj))
			{
				al2.add(obj);
			}
		}
		return al2;
	}
}
