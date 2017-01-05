/*
map���ϵ�����ȡ����ʽ��
	1��keySet:
			Set<K> keySet();
					���ش�ӳ���а����ļ��� Set ��ͼ��
					ʾ����Set<String> keySet = map.keySet();
							Iterator<String> it2 = keySet.iterator();
		��map�����еļ����뵽Set�����У���Ϊset�߱������������Կ��Ե�����ʽȡ�����еļ���
		�ڸ���get��������ȡÿһ������Ӧ��ֵ��
		
	�ص㣺Map���ϵ�ȡ��ԭ����map����ת��set���ϣ���ͨ��������ȡ����
	
	2��entrySet:
			Set<Map.Entry<K,V>> entrySet();
					���ش�ӳ���а�����ӳ���ϵ�� Set ��ͼ��
					ʾ����Set<Map.Entry<String,String>> entrySet = map.entrySet();
							Iterator<Map.Entry<String,String>> it1 = entrySet.iterator();
			
	�ص㣺��map�����е�ӳ���ϵ���뵽��set�����У��������ϵ���������;��ǣ�map.Entry��

Map.Entry ��ʵEntryҲ��һ���ӿڣ�����map�ӿڵ�һ���ڲ��ӿڡ�
		interface Map
		{
			public static interface Entry
			{	
				public abstract Object getKey();
				public abstract Object getValue();
			}
		}
		class HashMap implements Map
		{
			class Hash implements Map.Entry
			{
				public  Object getKey()
				{

				}
				public  Object getValue()
				{

				}
			}
		}
*/
import java.util.*;
class KeySetEntrySetDemo2 
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		Map<String,String> map = new HashMap<String,String>();

		map.put("01","java01");
		map.put("02","java02");
		map.put("03","java03");
		map.put("04","java04");
		
		//ʹ��EntrySet��ʽ��
		Set<Map.Entry<String,String>> entrySet = map.entrySet();//��map�����е�ӳ���ϵȡ�������뵽set�����С�

		Iterator<Map.Entry<String,String>> it1 = entrySet.iterator();
		while (it1.hasNext())
		{
			Map.Entry<String,String> me = it1.next();
			String key1 = me.getKey();
			String value1 = me.getValue();
			stringPrint("key1:"+key1+",value1:"+value1);
		}
		stringPrint("===============================================");
		
		//ʹ��KeySet��ʽ��
		Set<String> keySet = map.keySet();//�Ȼ�ȡmap�����е����м�ֵ��Set���ϣ�keySet()
		
		Iterator<String> it2 = keySet.iterator();//����Set���ϣ��Ϳ��Ի�ȡ��������
		while (it2.hasNext())
		{
			String key2 = it2.next();
			
			//���˼�ֵ�Ϳ���ͨ��map�����е�get������ȡ���ֵ��Ӧ��ֵ��
			String value2 = map.get(key2);
			stringPrint("key2:"+key2+",value2:"+value2);
		}
		
	}
}
/*
��������
		key1:04,value1:java04
		key1:01,value1:java01
		key1:02,value1:java02
		key1:03,value1:java03
		====================================
		key2:04,value2:java04
		key2:01,value2:java01
		key2:02,value2:java02
		key2:03,value2:java03
*/