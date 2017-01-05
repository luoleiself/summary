/*
将C盘的一个文件复制到D盘。

复制原理：
		其实就是讲C盘下的文件数据存储到D盘的一个文件中。

思路：
	1，在D盘创建一个文件，用于存储C盘文件中的数据。
	2，定义读取流和C盘文件关联。
	3，通过不断的读写完成数据存储。
	4，关闭资源。
*/
import java.io.*;
class  FileReaderWriterCopyTextTest2
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
	//第二种方式：
	public static void Copy_2()
	{
		//创建目的地。
		FileWriter fw = null;

		//与已有文件关联。
		FileReader fr = null;

		try
		{
			fw = new FileWriter("DataDemo_Copy.java");
			fr = new FileReader("DataDemo.java");

			char[] buf = new char[1024];
			
			int len = 0;
			while ((len = fr.read(buf))!=-1)
			{
				fw.write(buf,0,len);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("读写失败");
		}
		finally
		{
			if(fr!=null)
				try
				{
					fr.close();
				}
				catch (IOException e)
				{

				}
			if (fw!=null)
			{
				try
				{
					fw.close();
				}
				catch (IOException e)
				{

				}
			}
		}

	}

	//第一种方式：
	//从C盘读一个字符，就往D盘写一个字符。
	public static void Copy_1() throws IOException
	{
		//创建目的地。
		FileWriter fw = new FileWriter("DataDemo_Copy.java");

		//与已有文件关联。
		FileReader fr = new FileReader("DataDemo.java");

		int ch = 0;
		while ((ch = fr.read())!=-1)
		{
			fw.write(ch);
		}
		fw.close();
		fr.close();
	}
}
