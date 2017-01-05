/*
������BufferedReader�������з���readLine��ԭ���
�����Զ���һ�����а���һ�����ܺ�readLineһ�µķ�����
��ģ��һ��BufferedReader��
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
		//����һ����ʱ������ԭBufferReader��װ�����ַ����顣
		//Ϊ����ʾ���㣬����һ��StringBuilder��������Ϊ���ջ���Ҫ�����ݱ���ַ�����
		
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
