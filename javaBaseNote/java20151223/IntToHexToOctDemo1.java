/*
基本数据类型对象包装类。

	 数据类型		类名
		byte		Byte 
		short		Short
		int			Integer
		boolean		Boolean
		float		Float
		double		Double
		char		Character

基本数据类型对象包装类的最常见作用，就是用于基本数据类型和字符串类型之间做转换。
	1，基本数据类型转换成字符串：
			1,基本数据类型+"";
			2,基本数据类型.toString(基本数据类型值);
					示例：Integer.toString(34);将34整型数据转换成字符串"34";
	
	2，字符串转换成基本数据类型：
			1，静态方法调用方式：
			   xxx a = Xxx.parseXxx(String str);
			   int a = Integer.parseInt("123");
			   long a = Long.parseLong("123");
			   double a = Double.parseDouble("12.23");
			   boolean a = Boolean.parseBoolean("true");
			2，对象调用方式：
					Integer i = new Integer("123");
					int num = i.intValue();

	3，十进制转换成其他进制：
				toBinaryString();
				toHexString();
				toOctalString();

	4，其他进制转换成十进制：
				parseInt(String str,int radix);
					示例：int x = Integer.parseInt("3c",16);将3c转换成十六进制数据类型。

*/
class  IntToHexToOctDemo1
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		//整数类型的最值：
		stringPrint("int max:"+Integer.MAX_VALUE);//整形类型的最大值;MAX_VALUE为字段属性;
		stringPrint("int max:"+Integer.MIN_VALUE);//整形类型的最小值;MIN_VALUE为字段属性;

		//将一个字符串转换成整数：
		int in = Integer.parseInt("123");
		long lon = Long.parseLong("123");
		float floa = Float.parseFloat("123.123");
		double doubl = Double.parseDouble("123123.123123");
		stringPrint("in="+in);
		stringPrint("lon="+lon);
		stringPrint("floa="+lon);
		stringPrint("doubl="+doubl);

		//十进制转换成其他进制：
		stringPrint(Integer.toBinaryString(100));
		stringPrint(Integer.toHexString(100));
		stringPrint(Integer.toOctalString(100));
		
		//其他进制转换成十进制：
		int in1 = Integer.parseInt("110",2);
		int in2 = Integer.parseInt("F6c",16);
		int in3 = Integer.parseInt("107",8);
		stringPrint("in1="+in1);
		stringPrint("in2="+in2);
		stringPrint("in3="+in3);
	}
}
