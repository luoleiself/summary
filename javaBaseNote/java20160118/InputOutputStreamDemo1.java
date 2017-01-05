/*
字符流：
	FileReader
	FileWriter

	BufferedReader
	BufferedWriter

字节流：
	FileInputStream
	FileOutputStream

	BufferedInputStream
	BufferedOutputStream

字节流：
	|--java.lang.Object:
		|--java.io.InputStream抽象类
			|--java.io.FilterInputStream实例类
				|--java.io.BufferedInputStream实例类
	|--java.lang.Object:
		|--java.io.OutputStream抽象类
			|--java.io.FilterOutputStream实例类
				|--java.io.BufferedOutputStream实例类

需求：想要操作图片数据，就要用到字节流。

BufferedOutputStream实例类
				字段摘要：
					protected  byte[] buf
								存储数据的内部缓冲区。
					protected  int count 
								缓冲区中的有效字节数。
 
				构造方法：
					BufferedOutputStream(OutputStream out);
								创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
					BufferedOutputStream(OutputStream out, int size);
								创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。
				void flush();
						刷新此缓冲的输出流。
				void write(byte[] b, int off, int len);
						将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此缓冲的输出流。
				void write(int b);
						将指定的字节写入此缓冲的输出流。

BufferedInputStream实例类
				字段摘要：
					protected  byte[] buf 
								存储数据的内部缓冲区数组。
					protected  int count 
								比缓冲区中最后一个有效字节的索引大 1 的索引。
					protected  int marklimit 
								调用 mark 方法后，在后续调用 reset 方法失败之前所允许的最大提前读取量。
					protected  int markpos 
								最后一次调用 mark 方法时 pos 字段的值。
					protected  int pos 
								缓冲区中的当前位置。
				构造函数：
					BufferedInputStream(InputStream in);
								创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
					BufferedInputStream(InputStream in, int size);
								创建具有指定缓冲区大小的 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
				int available();
						返回可以从此输入流读取（或跳过）、且不受此输入流接下来的方法调用阻塞的估计字节数。
				void close();
						关闭此输入流并释放与该流关联的所有系统资源。
				void mark(int readlimit);
						参见 InputStream 的 mark 方法的常规协定。
				boolean markSupported();
						测试此输入流是否支持 mark 和 reset 方法。
				int read();
						参见 InputStream 的 read 方法的常规协定。
				int read(byte[] b, int off, int len);
						从此字节输入流中给定偏移量处开始将各字节读取到指定的 byte 数组中。
				void reset();
						参见 InputStream 的 reset 方法的常规协定.
				long skip(long n);
						参见 InputStream 的 skip 方法的常规协定。
*/
import java.io.*;
class  InputOutputStreamDemo1
{
	public static void main(String[] args) 
	{
		
	}
	public static void writeFile_3()throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] byt = new byte[fis.available()];

		fis.read(byt);

		System.out.println(new String(byt));

		fis.close();
		
	}
	public static void writeFile_2()throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");

		byte[] but = new byte[1024];
		int len = 0;
		while ((len = fis.read(but))!=-1)
		{
			System.out.println(new String(but,0,len));
		}
		fis.close();
	}
	public static void writeFile_1()throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");

		int ch = 0;
		while ((ch = fis.read())!=-1)
		{
			System.out.println((char)ch);
		}
		fis.close();
	}
	public static void writeFile()throws IOException
	{
		FileOutputStream fos = new FileOutputStream("fos.txt");

		fos.write("abcde".getBytes());
		fos.close();
	}
}
