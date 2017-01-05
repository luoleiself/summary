/*
|--java.lang.Object:
	|--java.io.Reader抽象类：
		|--java.io.InputStreamReader实例类:
			|--java.io.FileReader实例类:
	
Reader抽象类:
			构造函数：
				protected  Reader();
							创建一个新的字符流 reader，其重要部分将同步其自身的 reader。
				protected  Reader(Object lock);
							创建一个新的字符流 reader，其重要部分将同步给定的对象。
		abstract  void close();
					关闭该流并释放与之关联的所有资源。
		void mark(int readAheadLimit);
					标记流中的当前位置。
		boolean markSupported();
					判断此流是否支持 mark() 操作。
		int read();
					读取单个字符。
		int read(char[] cbuf);
					将字符读入数组。
		abstract  int read(char[] cbuf, int off, int len);
					将字符读入数组的某一部分。
		int read(CharBuffer target);
					试图将字符读入指定的字符缓冲区。
		boolean ready();
					判断是否准备读取此流。
		void reset();
					重置该流。
		long skip(long n);
					跳过字符。

InputStreamReader实例类:
			构造函数：
				InputStreamReader(InputStream in);
							创建一个使用默认字符集的 InputStreamReader。
				InputStreamReader(InputStream in, Charset cs);
							创建使用给定字符集的 InputStreamReader。
				InputStreamReader(InputStream in, CharsetDecoder dec);
							创建使用给定字符集解码器的 InputStreamReader。
				InputStreamReader(InputStream in, String charsetName);
							创建使用指定字符集的 InputStreamReader。
		String getEncoding();
					返回此流使用的字符编码的名称。

FileReader实例类:
			构造函数：
				FileReader(File file);
							在给定从中读取数据的 File 的情况下创建一个新 FileReader。
				FileReader(FileDescriptor fd);
							在给定从中读取数据的 FileDescriptor 的情况下创建一个新 FileReader。
				FileReader(String fileName);
							在给定从中读取数据的文件名的情况下创建一个新 FileReader。
*/
import java.io.*;
class  FileReaderDemo1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		//创建一个文件读取流对象，和指定名称的文件相关联。
		//要保证该文件是否已经存在的，如果不存在，会发生异常FileNotFoundException。
		FileReader fr = new FileReader("Demo.txt");
		
		//调用读取流对象的read方法。
		//read()；一次读一个字符，而且会自动往下读。如果达到流的末尾，则会返回-1.
		int ch = fr.read();
		stringPrint("ch:"+(char)ch);

		int ch = 0;
		while((ch = fr.read())!=-1)
		{
			stringPrint("ch:"+(char)ch);
		}	
	}
}
