/*
Map�ӿڣ�Map<K,V>
				K--��ӳ����ά���ļ������͡�
				V--ӳ��ֵ�����͡�
	�ص㣺
		1���ü��ϴ洢��ֵ�ԣ�һ��һ������棬����Ҫ��֤����Ψһ�ԡ�
	
 Map������
		1,��ӣ�
			V put(K key, V value);
					��ָ����ֵ���ӳ���е�ָ������������ѡ��������
			void putAll(Map<? extends K,? extends V> m);
					��ָ��ӳ���н�����ӳ���ϵ���Ƶ���ӳ���У���ѡ��������
		2,ɾ����
			void clear()��
					�Ӵ�ӳ�����Ƴ�����ӳ���ϵ����ѡ��������
			V remove(Object key);
					�������һ������ӳ���ϵ������Ӵ�ӳ�����Ƴ�����ѡ��������
		3,�жϣ�
			boolean containsKey(Object key);
					�����ӳ�����ָ������ӳ���ϵ���򷵻� true��
			boolean containsValue(Object value);
					�����ӳ�佫һ��������ӳ�䵽ָ��ֵ���򷵻� true��
			boolean isEmpty();
					�����ӳ��δ������-ֵӳ���ϵ���򷵻� true��	
		4,��ȡ��
			V get(Object key);
					����ָ������ӳ���ֵ�������ӳ�䲻�����ü���ӳ���ϵ���򷵻� null��
			int size();
					���ش�ӳ���еļ�-ֵӳ���ϵ����
			Collection<V> values();
					���ش�ӳ���а�����ֵ�� Collection ��ͼ��ʾ����Collection<String> coll = map.values();
 

			Set<K> keySet();
					���ش�ӳ���а����ļ��� Set ��ͼ��
					ʾ����Set<String> keySet = map.keySet();
							Iterator<String> it2 = keySet.iterator();
			Set<Map.Entry<K,V>> entrySet();
					���ش�ӳ���а�����ӳ���ϵ�� Set ��ͼ��
					ʾ����Set<Map.Entry<String,String>> entrySet = map.entrySet();
							Iterator<Map.Entry<String,String>> it1 = entrySet.iterator();

Map:(����)
	|--Hashtable�ࣺ�ײ��ǹ�ϣ�����ݽṹ�������Դ���null����nullֵ���ü������߳�ͬ���ġ�jdk1.0��ʼ��Ч�ʵ͡�	
	|--HashMap�ࣺ�ײ��ǹ�ϣ�����ݽṹ������ʹ��null����null�����ü������̲߳�ͬ���ġ�jdk1.2��ʼ��Ч�ʸߡ�
	|--TreeMap���ײ��Ƕ��������ݽṹ���̲߳�ͬ�����������ڸ�Map�����еļ���������

��Set���񡣵ײ������Set������
*/
import java.util.*;
class  MapDemo1
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
		
		stringPrint("put:"+map.put("01","JAVA01"));//��ֵ��ͬ�򸲸ǲ�����ԭ����ֵ��
		stringPrint("put:"+map.put("01","PJAVA01"));
		//���Ԫ��ʱ��������������ͬ�ļ�ֵ����ô����ӵ�ӳ���ϵ�ͻḲ��ԭ�м�ֵ��Ӧ��ӳ���ϵ��
		//��put�����᷵�ر����ǵ�ֵ��
		stringPrint("containsKy:"+map.containsKey("02"));//�ж��Ƿ������ֵ��ӳ���ϵ������ֵ����Ϊ�����͡�
		stringPrint("remove:"+map.remove("03"));//(��ʾ)�Ƴ���ֵ��ӳ���ϵ��

		stringPrint("get:"+map.get("01"));//����(��ʾ)��ֵ��ӳ���ϵ��
		
		map.put(null,"java04");
		stringPrint("get:"+map.get(null));//����(��ʾ)��ֵ��ӳ���ϵ��
		//����ͨ��get�����ķ���ֵ���ж�һ�����Ƿ���ڣ�ͨ�����ص�null�жϡ�
		
		//��ȡmap���������е�ֵ��
		Collection<String> coll = map.values();//���ش�ӳ���а�����ֵ�� Collection ��ͼ��

		stringPrint(coll);
		stringPrint(map);//���ؼ�ְ��ӳ��Ĺ�ϵ��
	}
}
/*��������
			put:java01
			put:JAVA01
			containsKy:true
			remove:java03
			get:PJAVA01
			get:java04
			[java04, PJAVA01, java02]
			{null=java04, 01=PJAVA01, 02=java02}
*/