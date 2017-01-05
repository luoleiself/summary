/*
StaticImport 静态导入。
		1，当类名重名时，需要指定具体的包名。
		2，当方法重名时，制定具体所属的对象或者类。
			
*/
import java.util.*;
import static java.util.Arrays.*;//导入的是Arrays这个类中的所有静态成员。
import static java.lang.*;//导入System类中所有的静态成员。
class  StaticImportDemo1
{
	public static void main(String[] args) 
	{
		int[] arr = {0,1,2,3,4,5};

		sort(arr);

		int index = binarySearch(arr,3);
		out.println(Arrays.toString(arr));
		System.out.println("index=:"+index);
	}
}
