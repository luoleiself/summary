/*
���Ͽ�ܹ����ࡣ
Arrays(��)��������������������飨����������������ĸ��ַ�����jdk1.2��ʼ��
			���໹����һ������������Ϊ�б����鿴�ľ�̬������
			�����ر�ע�����������ָ����������Ϊ null��������еķ��������׳� NullPointerException��
		1�����涼�Ǿ�̬������
	static <T> List<T> asList(T... a);
				����һ����ָ������֧�ֵĹ̶���С���б�
	static int binarySearch(byte/char/double/float/int/long/short(object)[] a, byte key);
				ʹ�ö���������������ָ����byte/char/double/float/int/long/short(object)�����飬�Ի��ָ����ֵ(object)��
	static ?[] copyOf(boolean/byte/char/double/float/int/long/short[] original, int newLength);
				����ָ�������飬��ȡ���� false ��䣨���б�Ҫ������ʹ��������ָ���ĳ��ȡ�
	static ?[] copyOfRange(boolean[] original, int from, int to);
				��ָ�������ָ����Χ���Ƶ�һ�������顣
	static boolean deepEquals(Object[] a1, Object[] a2);
				�������ָ������˴��������� �ģ��򷵻� true��
	static void fill(boolean[] a, boolean val);
				��ָ���� boolean ֵ�����ָ�� boolean �������ÿ��Ԫ�ء�
	static void sort(byte[] a);
				��ָ���� byte �����鰴���������������
	static String toString(boolean[] a);
				����ָ���������ݵ��ַ�����ʾ��ʽ��

��������е�Ԫ�ض��Ƕ�����ô��ɼ���ʱ�������е�Ԫ�ؾ�ֱ��ת�ɼ����е�Ԫ�ء�
��������е�Ԫ�ض��ǻ����������ͣ���ô�Ὣ��������Ϊ�����е�Ԫ�ش��ڡ�

ע�⣺�������ɼ��ϣ�������ʹ�ü��ϵ���ɾ��������Ϊ����ĳ����ǹ̶��ġ�
	����ʹ�õķ�����
					contains();
					get();
					indexOf();
					subList();
	  �����ɾ�����ᷢ��UnsupportedOperationException��֧�ֵĲ����쳣��	
*/
import java.util.*;
class  ArraysDemo1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void asListMethod()
	{
//		String [] arr = {"aaa","dfsg","vcsad"};
	
//		stringPrint(arr);
//		List<String> list = Arrays.asList(arr);

//		stringPrint("contains:"+list.contains("cc"));

//		list.add("java001");
		//UnsupportedOperationException��֧�ֵĲ����쳣��

//		stringPrint(arr);
	}
	public static void main(String[] args) 
	{
		//asListMethod();
		int [] arr = {2,3,4,5};

		List<int[]> list = Arrays.asList(arr);
		
		stringPrint(arr);
		//������Ϊ����Ĺ�ϣֵ��

		Integer [] arr1 = {2,3,4,5};

		List<Integer> list = Arrays.asList(arr1);//����ΪInteger���͡�

		stringPrint(arr1);
		//������Ϊ��[2,3,4,5]
	}
}
