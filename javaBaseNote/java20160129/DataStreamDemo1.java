/*
可以用来操作基本数据类型的数据的流对象。
DataInputStream:
		数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。
		应用程序可以使用数据输出流写入稍后由数据输入流读取的数据。
DataOutputStream:
		数据输出流允许应用程序以适当方式将基本 Java 数据类型写入输出流中。
		然后，应用程序可以使用数据输入流将数据读入。

DataInputStream:
		构造方法: 
			DataInputStream(InputStream in); 
				使用指定的底层 InputStream 创建一个 DataInputStream。
		一般方法：
			int readUnsignedByte(); 
				参见 DataInput 的 readUnsignedByte 方法的常规协定。 
			int readUnsignedShort(); 
				参见 DataInput 的 readUnsignedShort 方法的常规协定。 
			String readUTF(); 
				参见 DataInput 的 readUTF 方法的常规协定。 
			static String readUTF(DataInput in); 
				从流 in 中读取用 UTF-8 修改版格式编码的 Unicode 字符格式的字符串；然后以 String 形式返回此字符串。 
			int skipBytes(int n); 
				参见 DataInput 的 skipBytes 方法的常规协定。
			void readFully(byte[] b); 
				参见 DataInput 的 readFully 方法的常规协定。 
			void readFully(byte[] b, int off, int len); 
				参见 DataInput 的 readFully 方法的常规协定。 
			int readInt(); 可以是八种基本数据类型，readShort();readLong();readBoolean();
				参见 DataInput 的 readInt 方法的常规协定。
DataOutputStream:
		构造方法:
			DataOutputStream(OutputStream out); 
				创建一个新的数据输出流，将数据写入指定基础输出流。
		一般方法：
			void flush(); 
				清空此数据输出流。 
			int size(); 
				返回计数器 written 的当前值，即到目前为止写入此数据输出流的字节数。
			void writeShort(int v); 可以是八种基本数据类型，writeInt();writeBoolean();writeBytes();
				将一个 short 值以 2-byte 值形式写入基础输出流中，先写入高字节。 
			void writeUTF(String str); 
				以与机器无关方式使用 UTF-8 修改版编码将一个字符串写入基础输出流。 			
*/
import java.io.*;
class  DataStreamDemo1
{
	public static void main(String[] args)throws IOException 
	{
			
	}
	public static void readUTFDemo()throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("utfdata.txt"));
		
		String s = dis.readUTF();
		System.out.println("s:"+s);
		dis.close();
	}
	public static void writeUTFDemo()throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("utfdata.txt"));

		dos.writeUTF("你好");
		dos.close();
	}
	public static void writeData()throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

		dos.writeInt(234);
		dos.writeBoolean(true);
		dos.writeDouble(98898.12345);

		dos.close();
	}
	public static void readData()throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		
		int num = dis.readInt();
		boolean boo = dis.readBoolean();
		double dou = dis.readDouble();

		System.out.println("num:"+num);
		System.out.println("boo:"+boo);
		System.out.println("dou:"+dou);

		dis.close();
	}
}

