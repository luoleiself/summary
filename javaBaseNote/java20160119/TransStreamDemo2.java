/*
1，
	源：键盘录入，
   目的：控制台。

2，需求：想把键盘录入的数据存储到一个文件中。
	源：键盘录入，
   目的：文件。

3，需求：想把键盘录入的数据存储到一个文件中。
	源：文件，
   目的：控制台。

流操作的基本规律：
		通过三个明确来完成；
			1，明确源和目的。
					源：输入流。InputStream		Reader
					目的：输出流。OutputStream	Writer
			2，明确操作的数据是否是纯文本。
					是：字符流。
					否：字节流。
			3，当体系明确后，再明确要使用哪个具体的对象。
					通过设备来进行区分；
					源设备：内存，硬盘，键盘。
					目的设备：内存，硬盘，控制台。

需求分析：
1，将一个文本文件中的数据存储到另一个文件中。复制文件。
	源：
		1，因为是源，所以使用读取流：InputStream		Reader
			是不是操作文本文件，是！这时就可以选择Reader。
	
		2，明确要是该体系中的哪个对象。
			明确设备：硬盘，上一个文件。
			Reader体系中可以操作文件的对象是FileReader
		
		3，是否需要提高效率：是！加入Reader体系中的缓冲区，BufferedReader
			
			FileReader fr = new FileReader("a.txt");
			BufferedReader bufr = new BufferedReader(fr);

	目的：
		1，OutputStream	Writer
			目的是否是纯文本，是！Writer
		2,	设备：硬盘，一个文件。
			Writer体系中可以操作文件的对象FileWriter
		3，是否需要提高效率，是！加入Writer体系中的缓冲区，BufferedWriter
			
			FileWriter fw = new FileWriter("b.txt");
			BufferedWriter bufw = new BufferedWriter(fw);

====================================================================================

2，需求：将键盘录入的数据保存到一个文件中。
	这个需求中源和目的都存在。那么分别分析。
	源：
		1，InputStream		Reader
			是不是操作文本文件，是！这时就可以选择Reader。
		2，明确设备：键盘，System.in。
			为了操作键盘的文本数据方便，转成字符流安装字符串操作时最方便的。
			既然明确了Reader，那么就将System.in。转换成字符流Reader。
			用到了Reader体系中的转换流InputStreamReader。
		3，是否需要提高效率吗？是！选择使用缓冲区BufferedReader。
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader bufr = new BufferedReader(isr);
	目的：
		1，OutputStream	 Writer
			是否是纯文本？是！Writer
		2，明确设备：硬盘，一个文件，使用FileWriter		
		3，是否需要提高效率？是！加入Writer体系中的缓冲区，BufferedWriter

			FileWriter fw = new FileWriter("c.txt");
			BufferedWriter bufw = new BufferedWriter(fw);

**************************************************************************************************
		但是存储时，需要加入指定编码表UTF-8，而指定的编码表只有转换流可以指定。
		所以要使用的对象是OutputStreamWriter
		而该转换流对象要接收一个字节输出流，而且还可以操作的文件的字节输出流，FileOutputStream.
		
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d.txt"),"UTF-8");
		是否需要提高效率？是！加入Writer体系中的缓冲区，BufferedWriter

		BufferedWriter bufw = new BufferedWriter(osw);
		所以，记住：转换流什么时候使用？字符和字节之间的桥梁，通常，设计到字符编码表转换时。
		需要用到转换流。
**************************************************************************************************
*/
import java.io.*;
class  TransStreamDemo2
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("haha.txt")));
		
		//BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("haha.txt")));
		
		//BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;
		while ((line = bufr.readLine())!=null)
		{
			if ("over".equals(line))
			{
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}
}
