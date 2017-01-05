/*
字符流的缓冲区：
			|--java.io.Object
				|--java.io.Writer
					|--java.io.BufferedWriter:
			|--java.io.Object
				|--java.io.Reader
					|--java.io.BufferedReader：

缓冲区的出现是为了提高流的操作效率而出现的，所以在创建缓冲区之前，必须要先有流对象。
该缓冲区提供了一个一次读一行的方法readLine，方便于对文本数据的获取。
当返回null时，表示读到文件末尾。

readerLine方法返回的时候只返回回车符之前的数据内容，并不返回回车符。
		
		BufferedReader:
				构造方法：
					BufferedReader(Reader in);
								创建一个使用默认大小输入缓冲区的缓冲字符输入流。
					BufferedReader(Reader in, int sz);
								创建一个使用指定大小输入缓冲区的缓冲字符输入流。
				void close();
						关闭该流并释放与之关联的所有资源。
				void mark(int readAheadLimit);
						标记流中的当前位置。
				boolean markSupported();
						判断此流是否支持 mark() 操作（它一定支持）。
				int read();
						读取单个字符。
				int read(char[] cbuf, int off, int len);
						将字符读入数组的某一部分。
				String readLine();
						读取一个文本行。
				boolean ready();
						判断此流是否已准备好被读取。
				void reset();
						将流重置到最新的标记。
				long skip(long n);
						跳过字符。
*/
import java.io.*;
class  BufferedReaderDemo1
{
	public static void main(String[] args) 
	{
		//创建一个字符流的读对象与文件相关联；
		FileReader fr = new FileReader("Demo.text");

		//为了提高效率，加入缓冲技术，将字符读取流对象作为参数传递给缓冲对象的构造函数;
		BufferedReader bufr = new BufferedReader(fr);

		String line = null;
		while ((line = bufr.readLine())!=null)
		{
			System.out.println(line);
		}
		bufr.close();
	}
}
