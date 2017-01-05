//十进制转(二进制，八进制，十六进制)数值中的进制转换方法：
//下面方法需要确定要转换的数值，转换的基数base(1,7,15)，往右便宜的位数offset(1,3,15)

class  IntTo
{
	//十进制转(二进制，八进制，十六进制)数值中的进制转换方法：
	//下面方法需要确定要转换的数值，转换的基数base(1,7,15)，往右便宜的位数offset(1,3,15)
	public static void trans(int num,int base,int offset)
	{
		if(num==0)
		{
			System.out.println(0);
			return ;
		}
		char [] chs={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char [] arr=new char [32];//因为数值的在内存中占用的最大位为32位，
		int pos =arr.length;
		while(num!=0)
		{
			int temp =num & base;
			arr[--pos]=chs[temp];
			num=num>>>offset;//无符号右移offset位。
		}
		for (int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);//注意ln换行符的使用方法，
		}
	}
	//十进制-->二进制;
	public static void toBin(int num)
	{
		trans(num,1,1);
	}
	//十进制-->八进制;
	public static void toOct(int num)
	{
		trans(num,7,3);
	}
	//十进制-->十六进制;
	public static void toHex(int num)
	{
		trans(num,15,4);
	}
	public static void main(String[] args) 
	{
		toBin(99);
		System.out.println();
		toOct(99);
		System.out.println();
		toHex(99);
		System.out.println();
		System.out.println("Hello World!");
	}
}
