/*
知识点：变量名1.append() 将结果存储在一个容器里面，首先定义变量名1必须是一个容器，
		变量名1.reverse() 将结果反转输出(可以理解为倒序打印输出);
		StringBuffer 变量名 关键字定义可变属性的字符串变量名;

使用查表法：练习进制转换;	
*/
class  IntToBin
{	//十进制转二进制：
	public static void toBin(int num)
	{
		StringBuffer sb = new StringBuffer();//定义一个字符串变量，
		while(num>0)
		{
			sb.append(num%2);//sb.append()方法是将结果值存储在一个容器内，
			num=num/2;
		}
		System.out.println(sb.reverse());// sb.reverse()是将容器内的数据反转输出。
	}
	//十进制转十六进制：
	public static void toHex(int num)
	{
		StringBuffer sb = new StringBuffer();//定义一个字符串变量，
		for (int x=0;x<8;x++)
		{ 
			int temp = num & 15;//因为十六进制数最大取值范围为15即F，二进制位表示为4位，
			if (temp>9)
			{
				sb.append((char)(temp-10+'A'));//当该数与上15的余数大于9时，需要加上A对应的数值65，
			}
			else
				sb.append(temp);
			num=num>>>4;
		}
		System.out.println(sb.reverse());//sb.reverse()是将容器内的数据反转输出;
	}
	//十进制转八进制：
	public static void toOct(int num)
	{
		StringBuffer sb = new StringBuffer();//定义一个字符串变量，
		while(num!=0)
		{
			int temp=num&7;//八进制数最大值为7，
			sb.append(temp);
			num=num>>>3;//八进制数对应的二进制数位为3位;
		}
		System.out.println(sb.reverse());//sb.reverse()是将容器内的数据反转输出;
	}
	
	//查表法进行进制转换：
	/*
	思路：查表法首先需要定义两个数组，一个用于查询对应值，另外一个需要存储转换后的数值，同时需要定义一个指针，
		  指向该十六进制数值，用于后面的元素的读取。
	
	步骤：    
		  1,首先定一个字符型数组chs，包含了从0到F的元素，另外在定义一个字符型数组arr用于存放与15之后的数值，
		    定义的字符型数组arr，因为十六进制数值中有字符，一个int型数据在内存中占用4个字节共32位，
			转换十六进制时需要同时取4位，因此需要定义的字符型数组长度为8，

		  2,将chs数组中存放的角标为temp的字符赋值给arr数组角标为pos的元素；
		  3,使用for循环语句进行倒序取值，打印输出arr数组中的元素，
	*/
	public static void toHex1(int num)
	{	
		char [] chs={'0','1','2','3','4','5','6','7','8','9', 'A', 'B','C', 'D', 'E', 'F'};//定义一个数组进行比较查找，
	  //char [] chs={'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15'};角标值和十六进制数最大值一致。
		
		char [] arr=new char [8];//长度为什么取8？因为十六进制一次取4位，共8个4位。
		int pos =0;
		while(num!=0)
		{
			int temp =num&15;
			arr[pos++]=chs[temp];//将与15的值作为角标从参考数组中的对应的元素赋值给新定义的指针的数组。
			num=num>>>4;
		}
		for (int x=pos-1;x>=0;x--)//用for循环语句进行数组元素倒序打印输出；
		{
			System.out.print(arr[x]+",");//注意换行符的用法;
		}
	}
	/*
	以上代码可以进行演化：
	public static void toHex1(int num)
	{
		char [] chs={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char [] arr=new char [8];
		int pos =arr.length;//首先将定义的指针的值赋值为定义字符型数组的长度，为了后面了正序打印输出；
		while(num!=0)
		{
			int temp =num&15;
			arr[--pos]=chs[temp];//先执行自减1，例如：当角标为8时，自减1后为7进行赋值操作。
			num=num>>>4;
		}
		for (int x=pos;x<arr.length;x++)//从指针pos开始输出打印。
		{
			System.out.print(arr[x]+",");
		}
	}
	*/
	
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		toBin(60);
		toHex(60);
		toHex1(60);
	}
	/*
	总结：
		利用查表法进行进制转换，首先需要明确借助参考值进行比较，并将参考值赋值给新定义的容器，然后打输出。
		转换后的数值要注意取值的顺序。
	*/
}
