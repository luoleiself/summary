/*
CharArrayReader
CharArrayWriter

StringReader
StringWriter

CharArrayReader:此类实现一个可用作字符输入流的字符缓冲区。
		构造方法: 
			CharArrayReader(char[] buf); 
				根据指定的 char 数组创建一个 CharArrayReader。 
			CharArrayReader(char[] buf, int offset, int length); 
				根据指定的 char 数组创建一个 CharArrayReader。 
		方法摘要: 
			void close();
				关闭该流并释放与之关联的所有系统资源。 
			void mark(int readAheadLimit); 
				标记流中的当前位置。 
			boolean markSupported(); 
				判断此流是否支持 mark() 操作（它一定支持）。 
			int read(); 
				读取单个字符。 
			int read(char[] b, int off, int len); 
				将字符读入数组的某一部分。 
			boolean ready(); 
				判断此流是否已准备好被读取。 
			void reset(); 
				将该流重置为最新的标记，如果从未标记过，则将其重置到开头。 
			long skip(long n); 
				跳过字符。 

CharArrayWriter:
		此类实现一个可用作 Writer 的字符缓冲区。缓冲区会随向流中写入数据而自动增长。可使用 toCharArray() 和 toString() 获取数据。 
		注：在此类上调用 close() 无效，并且在关闭该流后可以调用此类中的各个方法，而不会产生任何 IOException。
		构造方法:
			CharArrayWriter(); 
				创建一个新的 CharArrayWriter。 
			CharArrayWriter(int initialSize); 
				创建一个具有指定初始大小的新 CharArrayWriter。 
		方法摘要: 
			CharArrayWriter append(char c); 
				将指定字符添加到此 writer。 
			CharArrayWriter append(CharSequence csq); 
				将指定的字符序列添加到此 writer。 
			CharArrayWriter append(CharSequence csq, int start, int end); 
				将指定字符序列的子序列添加到此 writer。 
			void close(); 
				关闭该流。 
			void flush(); 
				刷新该流的缓冲。 
			void reset(); 
				重置该缓冲区，以便再次使用它而无需丢弃已分配的缓冲区。 
			int size(); 
				返回缓冲区的当前大小。 
			char[] toCharArray(); 
				返回输入数据的副本。 
			String toString(); 
				将输入数据转换为字符串。 
			void write(char[] c, int off, int len); 
				将字符写入缓冲区。 
			void write(int c); 
				将一个字符写入缓冲区。 
			void write(String str, int off, int len); 
				字符串的某一部分写入缓冲区。 
			void writeTo(Writer out); 
				将缓冲区的内容写入另一个字符流。 

StringReader:其源为一个字符串的字符流。
		构造方法: 
			StringReader(String s); 
				创建一个新字符串 reader。 
		方法摘要: 
			void close(); 
				关闭该流并释放与之关联的所有系统资源。 
			void mark(int readAheadLimit); 
				标记流中的当前位置。 
			boolean markSupported(); 
				判断此流是否支持 mark() 操作以及支持哪一项操作。 
			int read(); 
				读取单个字符。 
			int read(char[] cbuf, int off, int len); 
				将字符读入数组的某一部分。 
			boolean ready(); 
				判断此流是否已经准备好用于读取。 
			void reset(); 
				将该流重置为最新的标记，如果从未标记过，则将其重置到该字符串的开头。 
			long skip(long ns); 
				跳过流中指定数量的字符。 
	
StringWriter:
		一个字符流，可以用其回收在字符串缓冲区中的输出来构造字符串。 
		关闭 StringWriter 无效。此类中的方法在关闭该流后仍可被调用，而不会产生任何 IOException。
		构造方法: 
			StringWriter(); 
				使用默认初始字符串缓冲区大小创建一个新字符串 writer。 
			StringWriter(int initialSize); 
				使用指定初始字符串缓冲区大小创建一个新字符串 writer。 
		方法摘要: 
			StringWriter append(char c); 
				将指定字符添加到此 writer。 
			StringWriter append(CharSequence csq); 
				将指定的字符序列添加到此 writer。 
			StringWriter append(CharSequence csq, int start, int end); 
				将指定字符序列的子序列添加到此 writer。 
			void close(); 
				关闭 StringWriter 无效。 
			void flush(); 
				刷新该流的缓冲。 
			StringBuffer getBuffer(); 
				返回该字符串缓冲区本身。 
			String toString(); 
				以字符串的形式返回该缓冲区的当前值。 
			void write(char[] cbuf, int off, int len); 
				写入字符数组的某一部分。 
			void write(int c); 
				写入单个字符。 
			void write(String str); 
				写入一个字符串。 
			void write(String str, int off, int len); 
				写入字符串的某一部分。 
*/
import java.io.*;
class  CharArrayStringReaderWriterDemo1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
