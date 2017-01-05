/*

*/
import java.io.*;
class MyBufferedInputStream
{
	private InputStream in;
	private byte[] byt = new byte[1024];
	private int pos = 0,count = 0;
	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}
	//一次读一个字节，从缓冲区(字节数组)获取。
	public int myRead()throws IOException
	{
		//通过in对象读取硬盘上的数据，并存储byt中。
		if (count == 0)
		{
			count = in.read(byt);
			if (count<0)
			{
				return -1;
			}
			pos = 0;
			byte b = byt[pos];
			count--;
			pos++;
			return b
		}
		else if(count>0)
		{
			byte b = byt[pos];
			count--;
			pos++;
			return b
		}
		return -1;
	}
	public void myClose()throws IOException
	{
		in.close();
	}
}
class  MyBufferedStream1
{
	public static void main(String[] args)throws IOException 
	{
		copy_2();
	}
	public static void copy_2()throws IOException
	{
		MyBufferedInputStream bufis = new MyBufferedInputStream(new FileInputStream("1.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("2.mp3"));

		int byt = 0;
		while ((byt = bufis.myRead())!=-1)
		{
			bufos.write(byt);
		}
		bufos.close();
		bufis.myClose();
	}
}
