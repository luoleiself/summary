/*
���ͣ�jdk1.5��ʼ���ֵ������ԣ����ڽ����ȫ���⣬��һ����ȫ���ơ�

	�ô���
		1��������ʱ�ڳ�������ClassCastException��ת�Ƶ��˱���ʱ�ڣ�
			�������Ա������⣬����������������٣���ȫ��
		2��������ǿ������ת�����鷳��

���͸�ʽ��ͨ��<>������Ҫ�����������������͡�

��ʹ��java�ṩ�Ķ���ʱ��ʲôʱ��ʹ�÷��ͣ�
	ͨ���ڼ��Ͽ���кܳ�����ֻҪ����<>����Ҫ���巺�͡�
	��ʵ<>���������������͵ġ�
	
	��ʹ�ü���ʱ����������Ҫ�洢������������Ϊ�������ݵ�<>�м��ɡ�
	
*/
import java.util.*;
class  GenericDemo1
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = nwe ArrayList<Stirng>();

		al.add("java001");
		al.add("java002");
		al.add("java003");
		al.add("java004");
		al.add(4);//a1.add(new Integer(4));
		
		Iterator<String> it = al.iterator();
		while (it.hasNext())//����������ת����
		{
			stringPrint(it.next());
		}
	}
}

