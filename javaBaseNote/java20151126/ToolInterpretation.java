/*
对于一个类中定义了多少个方法，对方不清楚，因为该类并没有使用说明书。

注意：
	1,对于一个类如果生成帮助文档的话，首先需要确定类的权限为public，否则不能提取注释生成文档。
	2,对于一个类中的方法，权限如果为private的话，javadoc也不会提取程序中的注释。
	3,如果一个类中默认会有一个空参数的构造函数，这个默认的构造函数的权限和所属类的一致，
	  类的权限为public，默认构造函数的权限也为public。

提取注释命令；
			javadoc	存储路径 参数1-author   参数2-version 程序名.java

d:\>java\java1126>javadoc ToolInterpretation.java
*/
/**
这是一个可以对数组进行操作的工具类，该类中提供了获取最值，排序等功能。
@author 张三
@version v1.1

*/
public class ToolInterpretation
{
	/**
	对空参数构造函数进行私有化;不让用户进行对象的建立。
	*/
	private ToolInterpretation()
	{

	}
	/*
	构造函数代码块：
	
	省略方法名
	{
		执行语句;
	}
	
	构造函数代码块优先于构造函数执行对象初始化;
	*/
	/**
	获取一个整形数组中的最大值;
	@param arr 接收一个int类型的数组。
	@return 会返回一个该数组中最大值。
	*/
	//使用static变为静态方法之后不用建立对象可以用直接使用类名调用方法:类名.成员();
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
	获取一个整形数组中的最小值;
	@param arr 接收一个int类型的数组。
	@return 会返回一个该数组中最小值。
	*/
	//使用static变为静态方法之后不用建立对象可以用直接使用类名调用方法:类名.成员();
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
	对一个int型的数组进行选择排序;
	@param arr 接收一个int类型的数组。
	*/
	//使用static变为静态方法之后不用建立对象可以用直接使用类名调用方法:类名.成员()
	public static void selectSort(int [] arr)
	{
		//外层循环从数组的角标初始值0开始读取元素，读取最后一个元素的前一个元素和最后一个元素比较，所以是arr.length-1;
		for (int x=0;x<arr.length-1;x++)
		{
			for (int y=x+1;y<arr.length;y++)//内层循环从第二个元素开始也就是第一个元素的角标值+1;避免重复比较；
			{
				if (arr[x]>arr[y])//第一个元素和以后的每一个元素进行比较；
				{
					swap(arr,x,y);//调用数组元素交换方法;
				}
			}
		}
	}
	/**
	对一个int型的数组进行冒泡排序;
	@param arr 接收一个int类型的数组。
	*/
	//使用static变为静态方法之后不用建立对象可以用直接使用类名调用方法:类名.成员()
	public static void bubbleSort(int [] arr)
	{
		//外层循环的功能和选择排序的功能一致，控制读取元素的位置；
		for (int x=0;x<arr.length-1;x++)
		{
			//arr.length-a-1的功能是控制数组长度，移位到后面的元素不再参与比较；避免重复比较；
			for (int y=0;y<arr.length-x-1;y++)
			{
				if (arr[y]>arr[y+1])//第一个元素和第二个元素进行比较，
				{
					swap(arr,x,y+1);//调用数组元素交换方法;
				}
			}
		}
	}
	/**
	对一个int型的数组进行元素位置调换;
	@param arr 接收一个int类型的数组。
	@param a 要调换元素的位置。
	@param b 要调换元素的位置。
	*/
	//使用static变为静态方法之后不用建立对象可以用直接使用类名调用方法:类名.成员()
	//此方法只提供给数组排序使用，没有必要展现给所有人知道，可以将方法私有化，只展现运行结果就可以了。
	private static void swap(int [] arr,int a,int b)
	{
		int temp =arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	/**
	对一个int型的数组进行打印输出;
	@param arr 接收一个int类型的数组。
	打印形式是：[element1,element2.....]
	*/
	//使用static变为静态方法之后不用建立对象可以用直接使用类名调用方法:类名.成员()
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
