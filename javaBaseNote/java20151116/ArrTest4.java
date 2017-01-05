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


折半查找:通过对键入的数值在数组中首先进行数组中间值比较，判断大小后，对数组角标进行折半，缩小查找范围。
		 优点：可以提高程序的执行效率，缺点：数组中的元素必须是有序的。
		 折半查找需要定义的方法明确返回值类型，并且有未知的内容参与运算。

课后练习一：有一个有序的数组，想要将一个元素插入到该数组中，并保证数组是有序的。

思路：
	1，定义一个方法，执行完成后需要明确返回值类型，并且方法中有未知的内容参与了运算。
	2，查找一个数值，首先从数组的中间元素开始比较，如果大于数组元素，首角标则自动取中间角标值+1，缩小查找范围。
	3，当数值小于数组元素时，尾角标自动取中间值-1，因为中间值角标已经排除可能性。
*/
class  ArrTest4
{
	//折半查找示例：
	//第一种方式：以键入值为基础，和数组中的中间元素比较。
	public static int searchArray(int [] arr,int key)
	{
		int min =0 ;
		int max =arr.length-1;
		int mid=(min+max)/2;
		while(key!=arr[mid])//当键入的值不等于数组中间的元素的时候，
		{
			if(key>arr[mid])//如果键入数值大于中间值时，则首角标取中间角标值加1，
			{min=mid+1;}
			else if(key<arr[mid])//如果键入数值小于中间值时，则尾角标取中间角标值减1，
			{max=mid-1;}
			if(min>max)//判断如果角标值范围错误则自动退出查找，返回错误值；
			{return -1;}
			mid=(min+max)/2;//在每一次查找完毕后，中间角标值要重新计算中间元素值；
		}
		return mid;//当以上循环没有执行，表示方法已经找到数组中对应的键入数值的元素的角标值；
	}
	//第二种方式：首先确定角标值的范围，当角标值范围错误时，退出查找方法；
	public static int searchArray_1(int [] arr,int key)
	{
		int min =0 ,max =arr.length-1,mid;
		while(min<max)
		{
			mid=(min+max)>>1;//小技巧，通过移位操作符也可以实现除以2；mid=(min+max)/2;
			if(key>arr[mid])//如果键入数值大于中间值时，则首角标取中间角标值加1，
			{min=mid+1;}
			else if(key<arr[mid])//如果键入数值小于中间值时，则尾角标取中间角标值减1，
			{max=mid-1;}
			else
			{return mid;}
		}
		return -1;
	}
	// 练习一：键入一个数值插入到数组中，并保证数组是有序的。
	public static int searchArray_2(int [] arr,int key)
	{
		int min =0 ,max =arr.length-1,mid;
		while(min<max)
		{
			mid=(min+max)>>1;//小技巧，通过移位操作符也可以实现除以2；mid=(min+max)/2;
			if(key>arr[mid])//如果键入数值大于中间值时，则首角标取中间角标值加1，
			{
				min=mid+1;
			}
			else if(key<arr[mid])//如果键入数值小于中间值时，则尾角标取中间角标值减1，
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
	 总结：折半查找，首先数组必须是有序的，
		1，以键入值为基础，和数组中的中间元素比较，缩小查找范围，
		2，首先确定角标值的范围，当角标值范围错误时，退出查找方法；否则执行判断键入值的大小；
	*/
}
