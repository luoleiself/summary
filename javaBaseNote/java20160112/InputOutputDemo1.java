/*
IO流(Input Output):		GB-2312		UniCode--UTF-8
			1，java对数据的操作时通过流的方式。
			2，java用于操作流的对象都在IO包中。
			3，按操作数据分为：字节流，字符流。
			4，按照流向分为：输入流，输出流。
					
字节流的抽象基类：
	InputStream; OutputStream;

字符流的抽象基类：
	Reader; Writer;

由这四个类派生出来的子类名称都是以其父类名称作为子类名称的后缀。
例如：
	|--InputStream;
		|--FileInputStream;
	|--Reader;
		|--FileReader;
*/
class  InputOutputDemo1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
