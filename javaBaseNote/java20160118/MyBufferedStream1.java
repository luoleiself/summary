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
	//һ�ζ�һ���ֽڣ��ӻ�����(�ֽ�����)��ȡ��
	public int myRead()throws IOException
	{
		//ͨ��in�����ȡӲ���ϵ����ݣ����洢byt�С�
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
