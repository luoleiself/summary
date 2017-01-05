/*
该类不算是IO体系中的子类，而是继承自Object。
但是它是IO包中的成员，因为它具备读和写的功能，内部封装了一个数组，而且通过指针对数组进行操作。
可以通过geiFilePointer获取指针位置，同时可以通过seek改变指针的位置。

其实完成读写的原理就是内部封装了字节输入流和字节输出流。

通过构造函数可以看出，该类只能操作文件，而且操作文件还有模式：r,w,rw,
如果模式为只读，不会创建文件，会去读取一个已存在的文件，如果该文件不存在，则会出现异常。
如果模式为读写，操作文件不存在，会自动创建，如果存在则不会覆盖。

RandomAccessFile
		构造方法：
			RandomAccessFile(File file, String mode); mode可以是r,w,rw,rws,rwd,
				创建从中读取和向其中写入（可选）的随机访问文件流，该文件由 File 参数指定。 
			RandomAccessFile(String name, String mode); mode可以是r,w,rw,rws,rwd,
				创建从中读取和向其中写入（可选）的随机访问文件流，该文件具有指定名称。
		方法摘要： 
			void close(); 
				关闭此随机访问文件流并释放与该流关联的所有系统资源。 
			FileChannel getChannel(); 
				返回与此文件关联的唯一 FileChannel 对象。 
			FileDescriptor getFD(); 
				返回与此流关联的不透明文件描述符对象。 
			long getFilePointer(); 
				返回此文件中的当前偏移量。 
			long length(); 
				返回此文件的长度。
			int read(); 
				从此文件中读取一个数据字节。
			boolean readBoolean();可以是八种基本数据类型，readInt();readChar(); 
				从此文件读取一个 boolean。
			void readFully(byte[] b); 
				将 b.length 个字节从此文件读入 byte 数组，并从当前文件指针开始。 
			void readFully(byte[] b, int off, int len); 
				将正好 len 个字节从此文件读入 byte 数组，并从当前文件指针开始。
			String readLine(); 
				从此文件读取文本的下一行。
			int readUnsignedByte(); 
				从此文件读取一个无符号的八位数。 
			int readUnsignedShort(); 
				从此文件读取一个无符号的 16 位数。
			String readUTF(); 
				从此文件读取一个字符串。 
			void seek(long pos); 
				设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作。
			void setLength(long newLength); 
				设置此文件的长度。 
			int skipBytes(int n); 
				尝试跳过输入的 n 个字节以丢弃跳过的字节。
			void write(byte[] b); 
				将 b.length 个字节从指定 byte 数组写入到此文件，并从当前文件指针开始。 
			void write(byte[] b, int off, int len); 
				将 len 个字节从指定 byte 数组写入到此文件，并从偏移量 off 处开始。 
			void write(int b); 
				向此文件写入指定的字节。
			void writeBoolean(boolean v); 可以是八种基本数据类型，writeInt();writeChar();
				按单字节值将 boolean 写入该文件。
			void writeUTF(String str); 
				使用 modified UTF-8 编码以与机器无关的方式将一个字符串写入该文件。 
*/
import java.io.*;
class  RandomAccessFileDemo1
{
	public static void main(String[] args)throws IOException 
	{
		writeFile();
	}
	public static void readFile()throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","r");
		
		//调整对象中的指针，
		raf.seek(8);//可以取出王五的信息。
		
		//调过指定的字节数。
		raf.skipBytes(8);

		byte[] buf = new byte[4];
		raf.read(buf);

		String name = new String(buf);
		int age = raf.readInt();
		System.out.println("name=:"+name);
		System.out.println("age=:"+age);

		raf.close();
	}
	public static void writeFile_2()throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		
		raf.seek(8*3);//可以在指定的位置上写数据。
		raf.write("周琦".getBytes());
		raf.write(103);
		raf.close();
	}
	public static void writeFile()throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");

		raf.write("李四".getBytes());
		raf.write(97);
		//raf.writeInt(258);

		raf.write("王五".getBytes());
		raf.write(99);

		raf.close();
	}
}
