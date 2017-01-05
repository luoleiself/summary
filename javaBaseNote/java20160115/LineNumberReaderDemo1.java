/*
|--java.lang.Object:
	|--java.io.Reader抽象类：
		|--java.io.InputStreamReader实例类:
			|--java.io.FileReader实例类:
	|--java.io.BufferedReader实例类：
		|--java.io.LineNumberReader实例类：

LineNumberReader：		
		跟踪行号的缓冲字符输入流。此类定义了方法 setLineNumber(int) 和 getLineNumber()，
		它们可分别用于设置和获取当前行号。
		默认情况下，行编号从 0 开始。该行号随数据读取在每个行结束符处递增，并且可以通过调用 setLineNumber(int) 更改行号。
		但要注意的是，setLineNumber(int) 不会实际更改流中的当前位置；它只更改将由 getLineNumber() 返回的值。

LineNumberReader方法：
				构造方法：
					LineNumberReader(Reader in)；
							使用默认输入缓冲区的大小创建新的行编号 reader。
					LineNumberReader(Reader in, int sz)；
							创建新的行编号 reader，将字符读入给定大小的缓冲区。
				int getLineNumber();
						获得当前行号。
				void mark(int readAheadLimit);
						标记该流中的当前位置。
				int read();
						读取单个字符。
				int read(char[] cbuf, int off, int len);
						将字符读入数组中的某一部分。
				String readLine();
						读取文本行。
				void reset();
						将该流重新设置为最新的标记。
				void setLineNumber(int lineNumber);
						设置当前行号。
				long skip(long n);
						跳过字符。	
*/
import java.io.*;
class  LineNumberReaderDemo1
{
	public static void main(String[] args) 
	{
		FileReader fr = new FileReader("Demo.java");

		LineNumberReader lnr = new LineNumberReader(fr);

		String line = null;
		lnr.setLineNumber(100);
		while ((line = lnr.readLine())!=null)
		{
			System.out.println(lnr.getLineNumber()+"::"+line);
		}
		lnr.close();
	}
}
