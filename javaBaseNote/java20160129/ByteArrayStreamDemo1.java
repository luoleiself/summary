/*
ByteArrayInputStream:
	在构造的时候，需要接收数据源，而且数据源是一个字节数组。
ByteArrayOutputStream：
	在构造的时候，不用定义数据目的，因为该对象已经内部封装了可变长度的字节数组。
	因为这两个流对象都操作的是字节数组，并没有使用系统资源，所以不用进行close关闭。

关闭 ByteArrayOutputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。

在流操作规律讲解时：
		源设备：
			键盘：System.in, 硬盘：FileStream, 内存：ArrayStream,
		目的设备：
			控制台：System.out, 硬盘：FileStream, 内存：ArrayStream,
用流的读写思想来操作数组。

ByteArrayInputStream:
		包含一个内部缓冲区，该缓冲区包含从流中读取的字节。内部计数器跟踪 read 方法要提供的下一个字节。
		关闭 ByteArrayInputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。

		构造方法:
			ByteArrayInputStream(byte[] buf); 
				创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组。 
			ByteArrayInputStream(byte[] buf, int offset, int length); 
				创建 ByteArrayInputStream，使用 buf 作为其缓冲区数组。 
		一般方法: 
			int available(); 
				返回可从此输入流读取（或跳过）的剩余字节数。 
			void close(); 
				关闭 ByteArrayInputStream 无效。 
			void mark(int readAheadLimit); 
				设置流中的当前标记位置。 
			boolean markSupported(); 
				测试此 InputStream 是否支持 mark/reset。 
			int read(); 
				从此输入流中读取下一个数据字节。 
			int read(byte[] b, int off, int len); 
				将最多 len 个数据字节从此输入流读入 byte 数组。 
			void reset(); 
				将缓冲区的位置重置为标记位置。 
			long skip(long n); 
				从此输入流中跳过 n 个输入字节。 

ByteArrayOutputStream:
		此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。 
		关闭 ByteArrayOutputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。

		构造方法: 
			ByteArrayOutputStream();
				创建一个新的 byte 数组输出流。 
			ByteArrayOutputStream(int size); 
				创建一个新的 byte 数组输出流，它具有指定大小的缓冲区容量（以字节为单位）。
		一般方法: 
			void close(); 
				关闭 ByteArrayOutputStream 无效。 
			void reset(); 
				将此 byte 数组输出流的 count 字段重置为零，从而丢弃输出流中目前已累积的所有输出。 
			int size(); 
				返回缓冲区的当前大小。 
			byte[] toByteArray(); 
				创建一个新分配的 byte 数组。 
			String toString(); 
				使用平台默认的字符集，通过解码字节将缓冲区内容转换为字符串。 
			String toString(String charsetName); 
				使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串。 
			void write(byte[] b, int off, int len); 
				将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此 byte 数组输出流。 
			void write(int b); 
				将指定的字节写入此 byte 数组输出流。 
			void writeTo(OutputStream out); 
				将此 byte 数组输出流的全部内容写入到指定的输出流参数中，这与使用 out.write(buf, 0, count) 调用该输出流的 write 方法效果一样。 
*/
import java.io.*;
class  ByteArrayStreamDemo1
{
	public static void main(String[] args) 
	{
		
	}
	public static void readStream()
	{
		//数据源
		ByteArrayInputStream bais = new ByteArrayInputStream("abcde".getBytes());
		
		//数据目的
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int by = 0;
		while ((by = bais.read())!=-1)
		{
			baos.write(by);
		}
		System.out.println(baos.size());
		System.out.println(baos.toString());
	}
}
