/*
字符流的缓冲区：
			|--java.io.Object
				|--java.io.Writer
					|--java.io.BufferedWriter:
			|--java.io.Object
				|--java.io.Reader
					|--java.io.BufferedReader：

缓冲区的出现是为了提高流的操作效率而出现的，所以在创建缓冲区之前，必须要先有流对象。
		
		BufferedWriter:
				构造方法：
					BufferedWriter(Writer out);
							创建一个使用默认大小输出缓冲区的缓冲字符输出流。
					BufferedWriter(Writer out, int sz)；
							创建一个使用给定大小输出缓冲区的新缓冲字符输出流。
				void close();
					关闭此流，但要先刷新它。
				void flush();
					刷新该流的缓冲。
				void newLine();
					写入一个行分隔符。
				void write(char[] cbuf, int off, int len);
					写入字符数组的某一部分。
				void write(int c); 
					写入单个字符。
				void write(String s, int off, int len);
					写入字符串的某一部分。	
*/
import java.io.*;
class  BufferedWriterDemo1
{
	public static void main(String[] args) 
	{
		//创建一个字符写入流对象。
		FileWriter fw = new FileWriter("Demo.text");

		//为了提高字符写入流效率，加入了缓冲技术。
		//只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可。
		BufferedWriter bufw = new BufferedWriter(fw);

		bufw.write("java001");
		bufw.newLine();
		
		for (int x = 0;x<10 ;x++ )
		{
			bufw.write("java"+x);
			bufw.newLine();
			bufw.flush();
		}

		//记住，只要用到缓冲区，就要记得刷新。
		bufw.flush();

		//其实关闭缓冲区，就是在关闭缓冲区中的流对象。
		bufw.close();
	}
}
