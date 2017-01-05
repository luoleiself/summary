/*
public static void main(String[] args)

主函数：是一个特殊的函数，作为程序的入口，可以被JVM调用。

主函数的定义：
	public :代表着该函数访问权限是最大的。
	static：代表主函数随着类的加载就已经存在了。
	void：主函数没有具体的返回值。 
	main：不是关键字，但是是一个特殊的单词，可以被JVM识别。
	(String [] args):参数类型是一个数组，该数组中的元素是字符串，字符串类型的数组。
					 args(arguments:参数)是变量名，可以更改，只要符合变量命名规则。

//String [] arr = new String[3];
//String [] arr = null;			参数列表中的字符串类型数组有两个值，

主函数是固定格式的：JVM识别。

JVM调用主函数时，传入的是new String[0];

*/
/*class  MainTest
{
	public static void main(String[] args) //函数能存在，但是重载。
	{
		System.out.println("Hello World!");
	}
	public static void main(int x)//函数能存在，但是重载。
	{
		System.out.println("Hello World!");
	}
}
*/
//下面有两个主函数，执行顺序谁在前面执行谁。
//功能：可以将打印主函数中的参数列表中字符串类型数组的长度，
//可以自定义一个数组，将数组传递给主函数进行打印。
class MainTest
{
	public static void main (String[] args)
	{
		String [] arr = {"haha","hehe","heihei","hiahia","xixi"};
		System.out.println(args.length);
		MainTest.main(arr);
	}
}
class MainTest1
{
	public static void main (String[] args)
	{
		for (int x=0;x<args.length;x++)
		{
			System.out.println(args[x]);
		}
	}
}
