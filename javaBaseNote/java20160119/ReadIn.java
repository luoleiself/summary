/*
读取键盘录入：
System.out.:对应的是标准输出设备，控制台。
System.out.:对应的是标准输入设备，键盘。

\r的阿斯克码表值为13.
\n的阿斯克码表值为10.

需求：
通过键盘录入数据。
当录入一行数据后，就将该行数据进行打印。
如果录入的数据时over，那么就停止录入。

*/
import java.io.*;
class  ReadIn
{
	public static void main(String[] args) throws IOException
	{
		InputStream in = System.in;
		/*
		int b = in.read();
		System.out.println(by);
		*/
		StringBuilder sb = new StringBuilder();

		while (true)
		{
			int ch = in.read();
			if (ch == 13)//if(ch == '\r');
			{
				continue;
			}
			else if (ch == 10)//if(ch == '\n');
			{
				String s = sb.toString();
				if ("over".equals(s))
				{
					break;
				}
				System.out.println(s.toUpperCase());//将获取的字符转换为大写输出，toLowerCase转换成小写。
				sb.delete(0,sb.length());//清空字符缓冲区。
			}
			else
			{
				sb.append((char)ch);
			}
		}
	}
}






