/*
��ϰһ�����û���������ַ��������ж�ȥ�����˵Ŀո�
˼·��
	1���ж��ַ�����һλ���Ƿ��ǿո�����Ǽ��������жϣ�ֱ�����ǿո�Ϊֹ��
		��β���жϿո�Ҳ����ˡ�
	2������ʼ�ͽ�β���жϵ����ǿո�ʱ������Ҫ��ȡ���ַ�����

��ϰ������һ���ַ������з�ת�����ַ������ƶ����ֽ��з�ת��	
˼·��
	1������ѧϰ���������Ԫ�ؽ��з�ת��
	2�����ַ���������飬��������з�ת��
	3������ת�������ת�����ַ�����
	4��ֻҪ����ת�Ĳ��ֵĿ�ʼ�ͽ���λ����Ϊ�������ݼ��ɡ�

*/
class  StringTest1
{
	public static void main(String[] args) 
	{
		String s = "      ab cd     ";
		stringPrint("("+s+")");
		//s = myTrim(s);
		//stringPrint("("+s+")");

		stringPrint("("+reverseString(s)+")");//��ϰ����
	}
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	//��ϰһ��ȥ�����˵Ŀո�
	public static String myTrim(String str)
	{
		int start = 0,end = str.length()-1;
		while(start<=end && str.charAt(start)==' ')
			start++;
		while(start<=end && str.charAt(end)==' ')
			end--;
		return str.substring(start,end+1);
	}
	//��ϰ������һ���ַ������з�ת��
	public static String reverseString(String s,int start,int end)
	{
		char [] arr = s.toCharArray();

		reverse(arr,start,end);

		return new String(arr);
	}
	public static String reverseString(String s)//���������ء�
	{
		return reverseString(s,0,s.length());
	}
	public static void reverse(char[] arr,int x,int y)
	{
		for (int start=x,end=y-1;start<end ;start++,end--)
		{
			swap(arr,start,end);
		}
	}
	private static void swap(char[] arr,int x,int y)
	{
		char temp = arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
}
