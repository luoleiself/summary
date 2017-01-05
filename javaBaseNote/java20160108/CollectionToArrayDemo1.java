/*
���ϱ�����飺
	Collection�ӿ��е�toArray������

ע�⣺
	1,ָ�����͵����鵽��Ҫ����೤�أ�
		��ָ�����͵����鳤��С���˼��ϵ�size����ô�÷����ڲ��ᴴ��һ���µ����飬����Ϊ���ϵ�size��
		��ָ�����͵����鳤�ȴ����˼��ϵ�size���Ͳ����½������飬����ʹ�ô��ݽ��������顣
		���Դ���һ���ոպõ��������š�����.size();
	
	2,ΪʲôҪ�����ϱ�����飿
		Ϊ���޶���Ԫ�صĲ���������Ҫ������ɾ������
*/
import java.util.*;
class  CollectionToArrayDemo1
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("java001");
		al.add("java002");
		al.add("java003");
		al.add("java004");
		al.add("java005");

		String[] arr1 = al.toArray(new String[1]);
		String[] arr2 = al.toArray(new String[8]);
		String[] arr3 = al.toArray(new String[al.size()]);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
	}
}
/*
��������
		[java001��java002��java003��java004��java005]
		[java001��java002��java003��java004��java005��null��null��null]
		[java001��java002��java003��java004��java005]
*/
