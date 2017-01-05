/*
静态的使用时机：因为静态修饰的内容有成员变量和成员方法;
				1,当对象中出现共享数据时，该数据被静态所修饰;对象的特有数据定义为非静态存在于堆内存中。
				2,当功能内部没有访问到非静态数据(对象的特有数据),该功能可以定义成静态的。

静态的应用：
				每一个应用程序都有共性的功能，可以将这些功能进行抽取，独立封装，以便复用。
				
静态的注意：	  虽然可以使用建立对象来使用这些方法，对数组进行操作。
				1,对象时用于封装数据的，但是，建立的对象并没有封装特有数据。
				2,自定义类中没有一个方法用到对象中的特有数据。
			
				可以直接将自定义类中的方法都定义为静态之后，直接通过类名调用即可。

构造函数私有化：将方法定义都静态后，可以方便使用，但是该类还是可以被其他程序建立对象。
				为了更为严谨，强制让该类不能建立对象，可以通过构造函数私有化完成。
		  格式：  
				  private 类名() {}

*/
class MainTest
{
	//对构造函数进行私有化;不让用户进行对象的建立。
	private MainTest()
	{

	}
	/*
	构造函数代码块：
	
	省略方法名
	{执行语句;}
	
	构造函数代码块优先于构造函数执行对象初始化;
	*/
	//当将public关键字改为private时，该方法将被隐藏(私有化)，不会被用户所知道;
	//当方法前被static定义后，该方法当变成静态方法，有两种调用方式(1,通过建立对象调用.2,通过类名调用)
	public static void printArray(int [] arr)//private static void printArray(int[] arr)静态方法私有化。
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
}
class  MainTest1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
