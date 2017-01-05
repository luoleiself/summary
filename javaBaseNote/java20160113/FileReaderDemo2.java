/*
用第二种方式 ：通过字符数组进行读取。

*/
import java.io.*;
class  FileReaderDemo2
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		FileReader fr = new FileReader("Demo.txt");

		//定义一个字符数组，用于存储堵到的字符。
		//该read(char[])返回的是读到字符个数。
		char[] buf = new char[1024];
		int num = fr.read(buf);

		stringPrint("num:"+num"::::"+new String(buf));
		fr.close();


		int num = 0;
		while ((num = fr.read(buf))!=-1)
		{
			stringPrint(new String(buf,0,num));
		}
		fr.close();
	}
}
