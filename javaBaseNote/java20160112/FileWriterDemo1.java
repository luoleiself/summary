/*
|--java.lang.Object:
	|--java.io.Writer抽象类：
		|--java.io.OutpuWriter实例类:
			|--java.io.FileWriter实例类:
Writer抽象类：
			构造函数：
					protected  Writer()；
							创建一个新的字符流 writer，其关键部分将同步 writer 自身。
					protected  Writer(Object lock)；
							创建一个新的字符流 writer，其关键部分将同步给定的对象。
			Writer append(char c)；
					将指定字符添加到此 writer。
			Writer append(CharSequence csq)；
					将指定字符序列添加到此 writer。
			Writer append(CharSequence csq, int start, int end)；
					将指定字符序列的子序列添加到此 writer.Appendable。
			abstract  void close()；
					关闭此流，但要先刷新它。
			abstract  void flush();
					刷新该流的缓冲。
			void write(char[] cbuf);
					写入字符数组的某一部分。
			void write(String str, int off, int len);
					写入字符串的某一部分。
	OutpuWriter实例类:
			构造函数：
					OutputStreamWriter(OutputStream out);
							创建使用默认字符编码的 OutputStreamWriter。
					OutputStreamWriter(OutputStream out, Charset cs);
							创建使用给定字符集的 OutputStreamWriter。
					OutputStreamWriter(OutputStream out, CharsetEncoder enc);
							创建使用给定字符集编码器的 OutputStreamWriter。
					OutputStreamWriter(OutputStream out, String charsetName);
							创建使用指定字符集的 OutputStreamWriter。
			void close();
					关闭此流，但要先刷新它。
			void flush();
					刷新该流的缓冲。
			String getEncoding();
					返回此流使用的字符编码的名称。
			void write(char[] cbuf, int off, int len);
					写入字符数组的某一部分。
			void write(String str, int off, int len);
					写入字符串的某一部分。
	FileWriter实例类:
			构造函数：
					FileWriter(File file);
							根据给定的 File 对象构造一个 FileWriter 对象。
					FileWriter(File file, boolean append);
							根据给定的 File 对象构造一个 FileWriter 对象。
					FileWriter(FileDescriptor fd);
							构造与某个文件描述符相关联的 FileWriter 对象。
					FileWriter(String fileName);
							根据给定的文件名构造一个 FileWriter 对象。
					FileWriter(String fileName, boolean append);
							根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。
*/
import java.io.*;
class  FileWriterDemo1
{
	public static void main(String[] args) 
	{
		//创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。
		//而且该文件会被创建到指定目录下，如果该目录已有同名文件，则覆盖原文件。
		//其实该步就是再明确数据要存放的目的地。
		FileWriter fw = new FileWriter("d:\\java\\java20160112 Demo.txt");
		
		fw.write("java001");
		fw.flush();
		//刷新流对象中的缓冲中的数据；
		//将数据刷到目的地中。

		fw.write("+java002");
		fw.flush();

		//关闭流资源，但是关闭之前会刷新一次内部的缓冲中的数据。
		//将数据刷到目的地中。
		//和flush的区别：flush刷新后，流可以继续使用，close刷新后，会降流关闭。

		fw.close();
		fw.write("+java002+java003");
	}
}
