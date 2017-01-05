/*
集合变成数组：
	Collection接口中的toArray方法。

注意：
	1,指定类型的数组到底要定义多长呢？
		当指定类型的数组长度小于了集合的size，那么该方法内部会创建一个新的数组，长度为集合的size。
		当指定类型的数组长度大于了集合的size，就不会新建了数组，而是使用传递进来的数组。
		所以创建一个刚刚好的数组最优。变量.size();
	
	2,为什么要将集合变成数组？
		为了限定对元素的操作，不需要进行增删操作。
*/
import java.util.*;
class  CollectionToArrayDemo1
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("java001");
		al.add("java002");
		al.add("java003");
		al.add("java004");
		al.add("java005");

		String[] arr1 = al.toArray(new String[1]);
		String[] arr2 = al.toArray(new String[8]);
		String[] arr3 = al.toArray(new String[al.size()]);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
	}
}
/*
输出结果：
		[java001，java002，java003，java004，java005]
		[java001，java002，java003，java004，java005，null，null，null]
		[java001，java002，java003，java004，java005]
*/
