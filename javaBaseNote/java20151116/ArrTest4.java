/*
������ͬһ�����͵����ݵļ��ϣ���ʵ�������һ��������
		  ��ʹ�÷�ʽ���Է�Ϊһά���飬��ά���飬��ά���顣
����Ķ����ʽ��

Ԫ������ [] ������ = new Ԫ������[Ԫ�ظ�������Ԫ�س���];

ע��ϸ�ڣ�	1,����ռ���ڴ�Ϊ���ڴ棬
			2,�����Ե�ַ��ֵ�����飬
			3,���ζ�������ĳ�ʼ��ֵĬ��Ϊ0��
			4,����ĽǱ�Ĭ��ֵ��0��ʼ;
			5,�������ջ��ƣ����ڴ��ж���������ϵͳ�Զ�����ʱ���Զ�������ջ�ڴ��еĲ��ᡣ
			6,����nullֻ���������Ͳ���ʹ�ã����磬�࣬�ӿڣ����顣
			7,����������ʱ�Ż��ڶ��ڴ��п��ٴ洢�ռ�;
			8,Boolean�������Ĭ��ֵΪfalse;

��������ԣ�.length;�Զ���ȡ�����Ԫ�ظ���;
��ʽ��		��������.length = ���鳤��;

�������⣺
			1,ArrayInderOutOfBoundException;�Ǳ�Խ�磬�Ǳ�ֵ������;
			2,NullPointerException;��ָ���쳣;

����Ķ����ʽ��
		int [] arr = new int [];
		int arr [] = new int [];
		
		int [] arr = new int [3];
		int [] arr = new int []{1,2,3,4,5,6,7,8,9,};
		int [] arr = {1,2,3,4,5,6,7,8,9,};


�۰����:ͨ���Լ������ֵ�����������Ƚ��������м�ֵ�Ƚϣ��жϴ�С�󣬶�����Ǳ�����۰룬��С���ҷ�Χ��
		 �ŵ㣺������߳����ִ��Ч�ʣ�ȱ�㣺�����е�Ԫ�ر���������ġ�
		 �۰������Ҫ����ķ�����ȷ����ֵ���ͣ�������δ֪�����ݲ������㡣

�κ���ϰһ����һ����������飬��Ҫ��һ��Ԫ�ز��뵽�������У�����֤����������ġ�

˼·��
	1������һ��������ִ����ɺ���Ҫ��ȷ����ֵ���ͣ����ҷ�������δ֪�����ݲ��������㡣
	2������һ����ֵ�����ȴ�������м�Ԫ�ؿ�ʼ�Ƚϣ������������Ԫ�أ��׽Ǳ����Զ�ȡ�м�Ǳ�ֵ+1����С���ҷ�Χ��
	3������ֵС������Ԫ��ʱ��β�Ǳ��Զ�ȡ�м�ֵ-1����Ϊ�м�ֵ�Ǳ��Ѿ��ų������ԡ�
*/
class  ArrTest4
{
	//�۰����ʾ����
	//��һ�ַ�ʽ���Լ���ֵΪ�������������е��м�Ԫ�رȽϡ�
	public static int searchArray(int [] arr,int key)
	{
		int min =0 ;
		int max =arr.length-1;
		int mid=(min+max)/2;
		while(key!=arr[mid])//�������ֵ�����������м��Ԫ�ص�ʱ��
		{
			if(key>arr[mid])//���������ֵ�����м�ֵʱ�����׽Ǳ�ȡ�м�Ǳ�ֵ��1��
			{min=mid+1;}
			else if(key<arr[mid])//���������ֵС���м�ֵʱ����β�Ǳ�ȡ�м�Ǳ�ֵ��1��
			{max=mid-1;}
			if(min>max)//�ж�����Ǳ�ֵ��Χ�������Զ��˳����ң����ش���ֵ��
			{return -1;}
			mid=(min+max)/2;//��ÿһ�β�����Ϻ��м�Ǳ�ֵҪ���¼����м�Ԫ��ֵ��
		}
		return mid;//������ѭ��û��ִ�У���ʾ�����Ѿ��ҵ������ж�Ӧ�ļ�����ֵ��Ԫ�صĽǱ�ֵ��
	}
	//�ڶ��ַ�ʽ������ȷ���Ǳ�ֵ�ķ�Χ�����Ǳ�ֵ��Χ����ʱ���˳����ҷ�����
	public static int searchArray_1(int [] arr,int key)
	{
		int min =0 ,max =arr.length-1,mid;
		while(min<max)
		{
			mid=(min+max)>>1;//С���ɣ�ͨ����λ������Ҳ����ʵ�ֳ���2��mid=(min+max)/2;
			if(key>arr[mid])//���������ֵ�����м�ֵʱ�����׽Ǳ�ȡ�м�Ǳ�ֵ��1��
			{min=mid+1;}
			else if(key<arr[mid])//���������ֵС���м�ֵʱ����β�Ǳ�ȡ�м�Ǳ�ֵ��1��
			{max=mid-1;}
			else
			{return mid;}
		}
		return -1;
	}
	// ��ϰһ������һ����ֵ���뵽�����У�����֤����������ġ�
	public static int searchArray_2(int [] arr,int key)
	{
		int min =0 ,max =arr.length-1,mid;
		while(min<max)
		{
			mid=(min+max)>>1;//С���ɣ�ͨ����λ������Ҳ����ʵ�ֳ���2��mid=(min+max)/2;
			if(key>arr[mid])//���������ֵ�����м�ֵʱ�����׽Ǳ�ȡ�м�Ǳ�ֵ��1��
			{
				min=mid+1;
			}
			else if(key<arr[mid])//���������ֵС���м�ֵʱ����β�Ǳ�ȡ�м�Ǳ�ֵ��1��
			{
				max=mid-1;
			}
			else
			{
				return mid;
			}
		}
		return min;
	}
	public static void main(String[] args) 
	{
		int [] arr={2,4,5,7,9,12,18,23,45,66,85};//2,4,5,7,9
		//int index = searchArray(arr,45);
		//int index = searchArray_1(arr,99);
		int index = searchArray_2(arr,15);
		System.out.println("index="+index);
	}
	/*
	 �ܽ᣺�۰���ң������������������ģ�
		1���Լ���ֵΪ�������������е��м�Ԫ�رȽϣ���С���ҷ�Χ��
		2������ȷ���Ǳ�ֵ�ķ�Χ�����Ǳ�ֵ��Χ����ʱ���˳����ҷ���������ִ���жϼ���ֵ�Ĵ�С��
	*/
}