/*
��ά���飺
		�������� [] [] ������ = new �������� [��������ʽ1] [��������ʽ2];
		�������� [] [] ������ = {{},{},{}....{}};

��ά����ĸ�ʽ��
		��������ʽ1Ϊ��ά����ĳ��ȣ�
		��������ʽ2Ϊһά����ĳ��ȡ�
������
		int [][]arr = new int [3][3];//���������ں���ʱ���������Ͷ�������Ԫ�����ã�һ�㶼ʹ�ô˸�ʽ��
		
		int arr [][]= new int [3][3];//����������ǰ��ʱ���������Ͷ������������á�

		int [][]arr = {{0,1,2},{0,1,2,},{0,1,2}} ;
ע�⣺
		int [][]arr = new int [3][];//��ʾ��ά����ĳ�����ȷ����һά����ĳ���δȷ�����������͵ĳ�ʼֵarr[0][]=null;
		
��һά�����ʼ����
		arr[0]=new int [3];
		arr[1]=new int [2];
		arr[2]=new int [4];
*/
class  Arr2Test
{
	public static void main(String[] args) 
	{
		int [][]arr = new int [3][3];
		int [][]arr1 = {{0,1,2},{0,1,2,},{0,1,2}} ;
		System.out.println(arr.length);//��ӡ��ά����ĳ��ȡ�
		System.out.println(arr[1].length);//��ӡ�Ǳ�Ϊ1�Ķ�ά������һά����ĳ��ȣ�
		System.out.println("Hello World!");
	}
}