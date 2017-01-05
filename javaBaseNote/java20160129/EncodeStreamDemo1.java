/*
ASCII:美国标准信息交换码。
		用一个字节的7位可以表示。
ISO8859-1:拉丁码表，欧洲码表
		用一个字节的8位表示。
GB2312:中国的中文编码表。
GBK：中国的中文编码表。
Unicode:国际标准码，融合了多种文字。
		所有文字都用两个字节来表示，java语言使用的就是Unicode。
UTF-8:最多用三个字节来表示一个字符。

编码：字符串变成字节数组。

解码：字节数组变成字符串。

String-->byte[]; String.getBytes();

byte[]-->String; new String(byte[],charsetName);

*/
import java.io.*;
class  EncodeStreamDemo1
{
	public static void main(String[] args) 
	{
		
	}
	public static void readText()throws IOException
	{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"GBK");

		char[] cha = new char[10];

		int len = isr.read(cha);
		String str = new String(cha,0,len);
		
		System.out.println("str:"+str);
		isr.close();
	}
	public static void writeText()throws IOException
	{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"GBK");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"),"UTF-8");
		
		osw.write("你好");
		osw.close();
	}
	public static void charsetName()throws IOException
	{
		String s = "你好";

		byte[] byt = s.getBytes("GBK");

		System.out.println(Arrays.toString(byt));
	
		String str = new String(byt,"ISO8859-1");
		System.out.println("str:"+str);
		
		//对str进行iso8859-1编码。
		byte[] byt1 = s.getBytes("ISO8859-1");
		System.out.println(Arrays.toString(byt1));

		String str1 = new String(byt1,"GBK");
		System.out.println("str1:"+str1);
	}
}
