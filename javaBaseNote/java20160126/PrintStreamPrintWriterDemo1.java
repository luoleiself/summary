/*
java.lang.Object
	|--java.io.OutputStream
		|--java.io.FilterOutputStream
			|--java.io.PrintStream

打印流：该流提供了打印方法，可以将各种数据类型的数据都原样打印。

字节打印流：PrintStream
		构造函数可以接收的参数类型：
						1，file对象。File
						2，字符串路径。String
						3，字节输出流。Stream
 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。它还提供其他两项功能。与其他输出流不同，PrintStream 永远不会抛出 IOException；
 而是，异常情况仅设置可通过 checkError 方法测试的内部标志。另外，为了自动刷新，可以创建一个 PrintStream；
 这意味着可在写入 byte 数组之后自动调用 flush 方法，可调用其中一个 println 方法，或写入一个换行符或字节 ('\n')。
 PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类.
		构造函数：
			PrintStream(File file)；
					创建具有指定文件且不带自动行刷新的新打印流。
			PrintStream(File file, String csn)； 
					创建具有指定文件名称和字符集且不带自动行刷新的新打印流。 
			PrintStream(OutputStream out)；； 
					 创建新的打印流。 
			PrintStream(OutputStream out, boolean autoFlush)； 
					 创建新的打印流。 
			PrintStream(OutputStream out, boolean autoFlush, String encoding)； 
					 创建新的打印流。 
			PrintStream(String fileName)； 
					 创建具有指定文件名称且不带自动行刷新的新打印流。 
			PrintStream(String fileName, String csn)； 
					 创建具有指定文件名称和字符集且不带自动行刷新的新打印流。 
		一般方法：除了具备Stream的基本读写，刷新方法之外，
			PrintStream append(char c)； 
					将指定字符添加到此输出流。 
			PrintStream append(CharSequence csq)； 
					将指定字符序列添加到此输出流。 
			PrintStream append(CharSequence csq, int start, int end)； 
					将指定字符序列的子序列添加到此输出流。 
			boolean checkError()； 
					刷新流并检查其错误状态。 
			protected  void clearError()； 
					清除此流的内部错误状态。
			PrintStream format(Locale l, String format, Object... args); 
					使用指定格式字符串和参数将格式化字符串写入此输出流中。 
			PrintStream format(String format, Object... args); 
					使用指定格式字符串和参数将格式化字符串写入此输出流中。 
			protected  void setError(); 
					将该流的错误状态设置为 true。
			PrintStream printf(Locale l, String format, Object... args); 
					使用指定格式字符串和参数将格式化的字符串写入此输出流的便捷方法。 
			PrintStream printf(String format, Object... args); 
					使用指定格式字符串和参数将格式化的字符串写入此输出流的便捷方法。

字符打印流：PrintWriter
		构造函数可以接收的参数类型：
						1，file对象。File
						2，字符串路径。String
						3，字节输出流。OutputStream
						4，字符输出流。Writer
向文本输出流打印对象的格式化表示形式。此类实现在 PrintStream 中的所有 print 方法。
它不包含用于写入原始字节的方法，对于这些字节，程序应该使用未编码的字节流进行写入。
与 PrintStream 类不同，如果启用了自动刷新，则只有在调用 println、printf 或 format 的其中一个方法时才可能完成此操作，
而不是每当正好输出换行符时才完成。这些方法使用平台自有的行分隔符概念，而不是换行符。 
此类中的方法不会抛出 I/O 异常，尽管其某些构造方法可能抛出异常。客户端可能会查询调用 checkError() 是否出现错误。
		构造函数：
			PrintWriter(File file); 
					使用指定文件创建不具有自动行刷新的新 PrintWriter。 
			PrintWriter(File file, String csn); 
					创建具有指定文件和字符集且不带自动刷行新的新 PrintWriter。 
			PrintWriter(OutputStream out); 
					根据现有的 OutputStream 创建不带自动行刷新的新 PrintWriter。 
			PrintWriter(OutputStream out, boolean autoFlush); 
					通过现有的 OutputStream 创建新的 PrintWriter。 
			PrintWriter(String fileName); 
					创建具有指定文件名称且不带自动行刷新的新 PrintWriter。 
			PrintWriter(String fileName, String csn); 
					创建具有指定文件名称和字符集且不带自动行刷新的新 PrintWriter。 
			PrintWriter(Writer out); 
					创建不带自动行刷新的新 PrintWriter。 
			PrintWriter(Writer out, boolean autoFlush); 
					创建新 PrintWriter。
		一般方法：
			同上。
*/
import java.io.*;
class  PrintStreamPrintWriterDemo1
{
	public static void main(String[] args) 
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//重点记住：有一个构造函数可以直接设置刷新。
		PrintWriter out = new PrintWriter(System.out,true);//true只针对流刷新。
//		PrintWriter out = new PrintWriter("a.txt");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("a.txt")),true);
		//边写数据边刷新，
		
		String line = null;
		while ((line = bufr.readLine()!=null))
		{
			if ("over".equals(line))
			{
				break;
			}
			out.write(line.toUpperCase());
			//out.flush();刷新是缓冲区才有的方法。
		}
		out.close();
		bufr.close();
	}
}
