/*
管道流：
PipedInputStream
	管道输入流应该连接到管道输出流；管道输入流提供要写入管道输出流的所有数据字节。
	字段摘要： 
		protected  byte[] buffer; 
				放置传入数据的循环缓冲区。 
		protected  int in; 
				循环缓冲区中位置的索引，当从连接的管道输出流中接收到下一个数据字节时，会将其存储到该位置。 
		protected  int out; 
				循环缓冲区中位置的索引，此管道输入流将从该位置读取下一个数据字节。 
		protected static int PIPE_SIZE; 
				管道循环输入缓冲区的默认大小。
	构造方法:
		PipedInputStream(); 
				创建尚未连接的 PipedInputStream。 
		PipedInputStream(int pipeSize); 
				创建一个尚未连接的 PipedInputStream，并对管道缓冲区使用指定的管道大小。 
		PipedInputStream(PipedOutputStream src); 
				创建 PipedInputStream，使其连接到管道输出流 src。 
		PipedInputStream(PipedOutputStream src, int pipeSize); 
				创建一个 PipedInputStream，使其连接到管道输出流 src，并对管道缓冲区使用指定的管道大小。 
	一般方法：
		int available(); 
				返回可以不受阻塞地从此输入流中读取的字节数。 
		void close(); 
				关闭此管道输入流并释放与该流相关的所有系统资源。 
		void connect(PipedOutputStream src); 
				使此管道输入流连接到管道输出流 src。 
		int read(); 
				读取此管道输入流中的下一个数据字节。 
		int read(byte[] b, int off, int len); 
				将最多 len 个数据字节从此管道输入流读入 byte 数组。 
		protected  void receive(int b); 
				接收数据字节。 
PipedOutputStream
	构造方法: 
		PipedOutputStream(); 
				创建尚未连接到管道输入流的管道输出流。 
		PipedOutputStream(PipedInputStream snk); 
				创建连接到指定管道输入流的管道输出流。 
  方法摘要: 
		 void close(); 
				关闭此管道输出流并释放与此流有关的所有系统资源。 
		 void connect(PipedInputStream snk); 
				将此管道输出流连接到接收者。 
		 void flush(); 
				刷新此输出流并强制写出所有缓冲的输出字节。 
		 void write(byte[] b, int off, int len); 
				将 len 字节从初始偏移量为 off 的指定 byte 数组写入该管道输出流。 
		 void write(int b); 
				将指定 byte 写入传送的输出流。 
*/
import java.io.*;
class Read implements Runnable
{
	private PipedInputStream in;
	Read(PipedInputStream in)
	{
		this.in = in;
	}
	public void run()
	{
		try
		{
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			
			String s = new String(buf,0,len);
			System.out.println(s);
			in.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("管道读取流失败");
		}
	}
}
class Write implements Runnable
{
	private PipedOutputStream out;
	Write(PipedOutputStream out)
	{
		this.out= out;
	}
	public void run()
	{
		try
		{
			out.write("piped lai le".getBytes());//获取字节数组。
			out.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("管道输出流失败");
		}
	}
}
class PipedStreamDemo1
{
	public static void main(String[] args) 
	{
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);

		Read r = new Read();
		Write w = new Write();

		new thread(r).start();
		new thread(r).start();
	}
}
