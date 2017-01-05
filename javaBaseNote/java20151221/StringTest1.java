/*
练习一：对用户的输入的字符串进行判断去掉两端的空格。
思路：
	1，判断字符串第一位置是否是空格，如果是继续向下判断，直到不是空格为止，
		结尾处判断空格也是如此。
	2，当开始和结尾都判断到不是空格时，就是要获取的字符串。

练习二：将一个字符串进行反转，将字符串中制定部分进行反转。	
思路：
	1，曾经学习过对数组的元素进行反转，
	2，将字符串变成数组，对数组进行反转。
	3，将反转后的数组转换成字符串。
	4，只要将反转的部分的开始和结束位置作为参数传递即可。

*/
class  StringTest1
{
	public static void main(String[] args) 
	{
		String s = "      ab cd     ";
		stringPrint("("+s+")");
		//s = myTrim(s);
		//stringPrint("("+s+")");

		stringPrint("("+reverseString(s)+")");//练习二：
	}
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	//练习一：去掉两端的空格。
	public static String myTrim(String str)
	{
		int start = 0,end = str.length()-1;
		while(start<=end && str.charAt(start)==' ')
			start++;
		while(start<=end && str.charAt(end)==' ')
			end--;
		return str.substring(start,end+1);
	}
	//练习二：将一个字符串进行反转。
	public static String reverseString(String s,int start,int end)
	{
		char [] arr = s.toCharArray();

		reverse(arr,start,end);

		return new String(arr);
	}
	public static String reverseString(String s)//函数的重载。
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
