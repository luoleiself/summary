/*
练习四：获取两个字符串中最大相同子串，第一个动作：将短的那个串进行长度一次递减的子串打印。
思路：
	1，定义一个方法，需要返回值类型为字符串类型，有未知的内容参与运算，参数列表有两个形式参数。
	2，获取两个子串中的相同子串，运用到了字符串类中的方法contains()判断字符串中是否包含某一个子串。
	3，获取相同子串可以从子串的最大长度开始比较，提高了程序的运行效率，
		如果从头开始比较，类似于数组的选择排序和冒泡排序的话，容易使程序运行效率变慢。
	4，利用子串的头角标和尾角标相对读取比较，当尾角标左移一位读取比较不满足时，
		这里需要注意一个问题 ，如何判断输入的字符串的长短问题。
		头角标和尾角标同时加一读取比较。
	5，可以使用双重循环语句，外循环控制循环次数，内循环控制读取的子串长度。
*/
class  StringTest3
{
	public static void main(String[] args) 
	{
		String str1 = "abcwerthelloyuiodef";
		String str2 = "cvhellobnm";
		
		stringPrint(getMaxSubString(str1,str2));
	}
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static String getMaxSubString(String str1,String str2)
	{
		String max="",min="";//因为传进来的字符串长度不确定。定义两个空字符串用于存储传递的字符串。
		max = (str1.length()>str2.length())?str1:str2;//判断语句将长度长的字符串赋值给空字符串max.
		min = (max==str1)?str2:str1;//判断如果max是长的字符串时，那么就将短的字符串赋值给min。
		
		for (int x=0;x<min.length();x++)
		{
			//z=min.length()-x;控制为角标值，当x循环一次后，为角标值最大为字符串长度减去x，
			//z!=min.length()+1;为了防止为角标值越界。
			//y++,z++;尾角标减一之后截取字符串比较，如果不满足，则首角标和尾角标同时加一截取字符串比较。
			for (int y=0,z=min.length()-x;z!=min.length()+1;y++,z++)
			{
				String temp = min.substring(y,z);
				if (max.contains(temp))//使用contains()方法判断字符串中是否包含某一个子串。
				{
					return temp;
				}
			}
		}
		return "";
	}
}
