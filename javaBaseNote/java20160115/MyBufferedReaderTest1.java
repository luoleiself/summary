/*
明白了BufferedReader类中特有方法readLine的原理后，
可以自定义一个类中包含一个功能和readLine一致的方法。
来模拟一下BufferedReader。
*/
import java.io.*;
class MyBufferedReader //extends Reader
{
	private FileReader r;
	MyBufferedReader(FileReader r)//(Reader r)
	{
		this.r = r;
	}
	public String myReadLine()throws IOException
	{
		//定义一个临时容器，原BufferReader封装的是字符数组。
		//为了演示方便，定义一个StringBuilder容器，因为最终还是要将数据变成字符串。
		
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while ((ch = r.read())!=-1)
		{
			if (ch == '\r')
			{
				continue;
			}
			if (ch == '\n')
			{
				return sb.toString();
			}
			else
			{
				sb.append((char)ch);
			}
		}
		if (sb.lengeth()!=0)
		{
			return sb.toString();
		}
		return null;
	}
	public void myClose()throws IOException
	{
		r.close();
	}
}
class  MyBufferedReaderTest1
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("Demo.text");

		MyBufferedReader mybuff = new MyBufferedReader(fr);

		String line = null;
		while ((line = mybuff.myReadLine())!=null)
		{
			System.out.println(line);
		}
		mybuff.myClose();
	}
}
