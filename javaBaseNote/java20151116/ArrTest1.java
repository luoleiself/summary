/*
数组概念：同一种类型的数据的集合，其实数组就是一个容器。
		  按使用方式可以分为一维数组，二维数组，多维数组。
数组的定义格式：

元素类型 [] 数组名 = new 元素类型[元素个数或者元素长度];

注意细节：	1,数组占用内存为堆内存，
			2,数组以地址赋值给数组，
			3,初次定义数组的初始化值默认为0，
			4,数组的角标默认值从0开始;
			5,垃圾回收机制，堆内存中丢弃的垃圾系统自动不定时的自动清理，栈内存中的不会。
			6,常量null只有引用类型才能使用，例如，类，接口，数组。
			7,数组在运作时才会在堆内存中开辟存储空间;
			8,Boolean型数组的默认值为false;

数组的属性：.length;自动获取数组的元素个数;
格式：		数组名称.length = 数组长度;

编译问题：
			1,ArrayInderOutOfBoundException;角标越界，角标值不存在;
			2,NullPointerException;空指针异常;

数组的定义格式：
		int [] arr = new int [];
		int arr [] = new int [];
		
		int [] arr = new int [3];
		int [] arr = new int []{1,2,3,4,5,6,7,8,9,};
		int [] arr = {1,2,3,4,5,6,7,8,9,};

课后练习一：打印一个数组，使用自定义函数（方法）;

思路：
	1,首先数组是一组数据，其中的元素个数未知，打印数组是一个独立的功能，不需要返回值类型，
	  其次，参与运算的数组是一个未知内容。
	2,打印数组中的元素需要使用循环语句多次读取数组。
步骤：
	1,首先定义一个不需要返回值类型的方法，public static void printArray();
	2,使用for循环语句进行读取数组中的元素进行打印;可以使用length获取数组的元素个数;
*/

class ArrTest1 
{
	public static void printArray(int [] arr)
	{
		System.out.print("arr[]=arr{");
		for (int x=0;x<arr.length;x++)//使用arr.length可以获取当前数组的元素个数；
		{
			if (x!=arr.length-1)//判断数组角标的位置，确定逗号的输出位置;
			{
				System.out.print(arr[x]+",");
			}
			else
			{
				System.out.print(arr[x]);
			}
		}
		System.out.print("}");
		System.out.println();
	}
	/*
	问题汇总：
			1,定义方法的参数列表掌握不熟练,
			2,在for循环语句中需要判断输出的元素是否为最后一个，
			3,if条件语句中的不等于用错;
	*/
	public static void main(String[] args) 
	{
		int [] arr = new int []{1,2,3,4,5,6,7,8,9};
		printArray(arr);
		
	}
}
	/*
	总结：
		1,区分开数组的初始值和角标的初始值;
		2,定义方法和方法之间的重载需要多加练习;
	*/
