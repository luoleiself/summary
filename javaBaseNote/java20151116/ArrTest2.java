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

课后练习二：获取数组中的最大的值，以及最小的值。

思路：
	1,获取数组中的最大值需要明确方法返回值类型，
	2,问题二需要把数组中的元素进行比较才能获取最大值（最小值），使用if条件语句进行比较操作。
	3,数组中的元素个数未知，需要使用for循环语句进行顺序读取比较。
*/

class ArrTest2 
{	
	//解决方法一：读取数组中的元素进行比较
	public static int getArr(int [] arr)//此方法内定义的所有变量和数组的作用域只限于方法内，
	{	
		int max = arr[0];//首先将数组的第一个元素的值赋值给变量，
		for (int x=1;x<arr.length;x++)//此处需要注意比较的时候从数组的第二个元素开始比较，因此x的值定义为1，
		{
			if(arr[x]>max)
			{
				max =arr[x];
			}
		}
		return max;//此处需要注意因为方法明确有返回值类型，因此此处需要使用return返回值，
	}
	/*
	问题总结：
			1,方法中的定义变量需要先将数组中的第一个元素赋值给变量；
			  比较大小是两个数参与的注意角标是从第二个元素开始比较的。
			2,数组的角标和元素值容易出错，需注意。
	
	*/
	//解决方法二：可以使用数组的角标进行比较，定义变量指向数组的角标。
	public static int getArr1 (int [] arr)
	{	
		int max = 0;//此处定义的变量值对应数组的角标的初始值为0
		for (int x=1;x<arr.length;x++)
		{
			if(arr[x]>arr[max])
			{
				arr[max] =arr[x];
			}
		}
		return arr[max];
	}
	/*
	问题总结：
			1,方法中的if条件语句中的比较表达式书写错误：arr[x]>int [max];下次请仔细检查。		  
	*/
	
	/*拓展练习：方法的重载
	public static double getArr (double [] arr)//方法名称一致，参数列表不同可以使用重载
	{	
		int max = 0;//此处定义的变量值对应数组的角标的初始值为0
		for (int x=1;x<arr.length;x++)
		{
			if(arr[x]>arr[max])
			{
				arr[max] =arr[x];
			}
		}
		return arr[max];
	}
   */
	public static void main(String[] args) 
	{
		int [] arr = new int []{18,2,23,45,72,23,46};
		int max = getArr(arr);//定义方法返回的值需要定义一个变量接收，
		int max1 = getArr1(arr);
		//double max2 =getArr(arr);
		System.out.println("max="+max);
		System.out.println("max1="+max1);
		//System.out.println("max2="+max2);
	}
	
}
