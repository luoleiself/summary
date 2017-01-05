/*
����һ�����ж����˶��ٸ��������Է����������Ϊ���ಢû��ʹ��˵���顣

ע�⣺
	1,����һ����������ɰ����ĵ��Ļ���������Ҫȷ�����Ȩ��Ϊpublic����������ȡע�������ĵ���
	2,����һ�����еķ�����Ȩ�����Ϊprivate�Ļ���javadocҲ������ȡ�����е�ע�͡�
	3,���һ������Ĭ�ϻ���һ���ղ����Ĺ��캯�������Ĭ�ϵĹ��캯����Ȩ�޺��������һ�£�
	  ���Ȩ��Ϊpublic��Ĭ�Ϲ��캯����Ȩ��ҲΪpublic��

��ȡע�����
			javadoc	�洢·�� ����1-author   ����2-version ������.java

d:\>java\java1126>javadoc ToolInterpretation.java
*/
/**
����һ�����Զ�������в����Ĺ����࣬�������ṩ�˻�ȡ��ֵ������ȹ��ܡ�
@author ����
@version v1.1

*/
public class ToolInterpretation
{
	/**
	�Կղ������캯������˽�л�;�����û����ж���Ľ�����
	*/
	private ToolInterpretation()
	{

	}
	/*
	���캯������飺
	
	ʡ�Է�����
	{
		ִ�����;
	}
	
	���캯������������ڹ��캯��ִ�ж����ʼ��;
	*/
	/**
	��ȡһ�����������е����ֵ;
	@param arr ����һ��int���͵����顣
	@return �᷵��һ�������������ֵ��
	*/
	//ʹ��static��Ϊ��̬����֮���ý������������ֱ��ʹ���������÷���:����.��Ա();
	public static int getMax(int [] arr)
		int max = 0;
		for (int x=1;x<arr.length;x++)
		{
			if (arr[x]>arr[max])
			{
				max = x;
			}
		}
		return arr[max];
	}
	/**
	��ȡһ�����������е���Сֵ;
	@param arr ����һ��int���͵����顣
	@return �᷵��һ������������Сֵ��
	*/
	//ʹ��static��Ϊ��̬����֮���ý������������ֱ��ʹ���������÷���:����.��Ա();
	public static int getMin(int [] arr)
	{
		int min = 0;
		for (int x=1;x<arr.length;x++)
		{
			if (arr[x]<arr[min])
			{
				min = x;
			}
		}
		return arr[min];
	}
	/**
	��һ��int�͵��������ѡ������;
	@param arr ����һ��int���͵����顣
	*/
	//ʹ��static��Ϊ��̬����֮���ý������������ֱ��ʹ���������÷���:����.��Ա()
	public static void selectSort(int [] arr)
	{
		//���ѭ��������ĽǱ��ʼֵ0��ʼ��ȡԪ�أ���ȡ���һ��Ԫ�ص�ǰһ��Ԫ�غ����һ��Ԫ�رȽϣ�������arr.length-1;
		for (int x=0;x<arr.length-1;x++)
		{
			for (int y=x+1;y<arr.length;y++)//�ڲ�ѭ���ӵڶ���Ԫ�ؿ�ʼҲ���ǵ�һ��Ԫ�صĽǱ�ֵ+1;�����ظ��Ƚϣ�
			{
				if (arr[x]>arr[y])//��һ��Ԫ�غ��Ժ��ÿһ��Ԫ�ؽ��бȽϣ�
				{
					swap(arr,x,y);//��������Ԫ�ؽ�������;
				}
			}
		}
	}
	/**
	��һ��int�͵��������ð������;
	@param arr ����һ��int���͵����顣
	*/
	//ʹ��static��Ϊ��̬����֮���ý������������ֱ��ʹ���������÷���:����.��Ա()
	public static void bubbleSort(int [] arr)
	{
		//���ѭ���Ĺ��ܺ�ѡ������Ĺ���һ�£����ƶ�ȡԪ�ص�λ�ã�
		for (int x=0;x<arr.length-1;x++)
		{
			//arr.length-a-1�Ĺ����ǿ������鳤�ȣ���λ�������Ԫ�ز��ٲ���Ƚϣ������ظ��Ƚϣ�
			for (int y=0;y<arr.length-x-1;y++)
			{
				if (arr[y]>arr[y+1])//��һ��Ԫ�غ͵ڶ���Ԫ�ؽ��бȽϣ�
				{
					swap(arr,x,y+1);//��������Ԫ�ؽ�������;
				}
			}
		}
	}
	/**
	��һ��int�͵��������Ԫ��λ�õ���;
	@param arr ����һ��int���͵����顣
	@param a Ҫ����Ԫ�ص�λ�á�
	@param b Ҫ����Ԫ�ص�λ�á�
	*/
	//ʹ��static��Ϊ��̬����֮���ý������������ֱ��ʹ���������÷���:����.��Ա()
	//�˷���ֻ�ṩ����������ʹ�ã�û�б�Ҫչ�ָ�������֪�������Խ�����˽�л���ֻչ�����н���Ϳ����ˡ�
	private static void swap(int [] arr,int a,int b)
	{
		int temp =arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	��һ��int�͵�������д�ӡ���;
	@param arr ����һ��int���͵����顣
	��ӡ��ʽ�ǣ�[element1,element2.....]
	*/
	//ʹ��static��Ϊ��̬����֮���ý������������ֱ��ʹ���������÷���:����.��Ա()
	public static void printArray(int [] arr)
	{
		System.out.print("[");
		for (int x=0;x<arr.length;x++)
		{
			if(x!=arr.length-1)
			{
				System.out.print(arr[x]+",");
			}
			else
			{
				System.out.print(arr[x]+"]");
			}
		}
	}
}
