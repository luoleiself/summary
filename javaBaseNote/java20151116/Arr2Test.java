/*
二维数组：
		数据类型 [] [] 数组名 = new 数据类型 [常量表达式1] [常量表达式2];
		数据类型 [] [] 数组名 = {{},{},{}....{}};

二维数组的格式：
		常量表达式1为二维数组的长度，
		常量表达式2为一维数组的长度。
举例：
		int [][]arr = new int [3][3];//数组名称在后面时，数据类型对数组中元素作用，一般都使用此格式。
		
		int arr [][]= new int [3][3];//数组名称在前面时，数据类型对数组名称作用。

		int [][]arr = {{0,1,2},{0,1,2,},{0,1,2}} ;
注意：
		int [][]arr = new int [3][];//表示二维数组的长度已确定，一维数组的长度未确定，引用类型的初始值arr[0][]=null;
		
对一维数组初始化：
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
		System.out.println(arr.length);//打印二维数组的长度。
		System.out.println(arr[1].length);//打印角标为1的二维数组中一维数组的长度；
		System.out.println("Hello World!");
	}
}
