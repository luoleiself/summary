/*
练习三：获取一个字符串在另一个字符串中出现的次数。
思路：
	1，定义一个计数器。
	2，获取自定义字符第一次出现的位置。
	3，从第一次出现位置后剩余的字符串中继续获取自定义字符出现的位置。
		每获取一次就计数一次。
	4，当获取不到时，计数完成。
*/
class StringTest2 
{
	public static void main(String[] args) 
	{
		String str = "abkkcdkkefkkskk";

		stringPrint("count="+getSubCount_1(str,"kk"));

		System.out.println("===============================================");
		
		stringPrint("count="+getSubCount_2(str,"kk"));
	}
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	//练习三：第一种方式：
	public static int getSubCount_1(String str,String key)
	{
		int count = 0;
		int index = 0;
		while ((index=str.indexOf(key))!=-1)//判断要查找的字符串的角标值是否为正。
		{
			stringPrint("str="+str);
			str = str.substring(index+key.length());
			//从查找到位置的字符串的角标开始截取到字符串尾。每查找一次，字符串长度减少index+key.length()次。
			
			count++;
		}
		return count;
	}
	//练习三：第二种方式：
	public static int getSubCount_2(String str,String key)
	{
		int count = 0;
		int index = 0;
		while ((index=str.indexOf(key,index))!= -1)//indexOf方法的参数不同，使用方式也不同。
		{
			stringPrint("index="+index);
			index = index + key.length();
			
			count++;
		}
		return count;
	}
}
//不建议使用切割(split)的方式进行处理，如果字符串中的起始位有key的话，使用切割的方式容易产生空字符串。
