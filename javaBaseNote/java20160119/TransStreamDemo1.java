/*
字符流：
	FileReader
	FileWriter

	BufferedReader
	BufferedWriter

字节流：
	FileInputStream
	FileOutputStream

	BufferedInputStream
	BufferedOutputStream

通过刚才的键盘录入一行数据并打印其大写，发现其实就是读一行数据的原理，也就是readLine方法。

ReadLine方法是字符流BufferedReader类中的方法，键盘录入的read方法是字节流InputStrem的方法。

那么能不能将字节流转成字符流在使用字符流缓冲区的readLine方法呢？

InputStreamReader实例类：
				构造函数：
					InputStreamReader(InputStream in);
							创建一个使用默认字符集的 InputStreamReader。
					InputStreamReader(InputStream in, Charset cs) 
							创建使用给定字符集的 InputStreamReader。 
					InputStreamReader(InputStream in, CharsetDecoder dec) 
							创建使用给定字符集解码器的 InputStreamReader。 
					InputStreamReader(InputStream in, String charsetName) 
							创建使用指定字符集的 InputStreamReader。
				String getEncoding();
						返回此流使用的字符编码的名称。

OutputStreamWriter实例类：
				构造函数：
					OutputStreamWriter(OutputStream out) 
							创建使用默认字符编码的 OutputStreamWriter。 
					OutputStreamWriter(OutputStream out, Charset cs) 
							创建使用给定字符集的 OutputStreamWriter。 
					OutputStreamWriter(OutputStream out, CharsetEncoder enc) 
							创建使用给定字符集编码器的 OutputStreamWriter。 
					OutputStreamWriter(OutputStream out, String charsetName) 
							创建使用指定字符集的 OutputStreamWriter。
				String getEncoding() 
						返回此流使用的字符编码的名称。			
*/
import java.io.*;
class  TransStreamDemo1
{
	public static void main(String[] args) 
	{
		//获取键盘录入对象。
		//InputStream in = System.in;

		//将字节流对象转成字符流对象，使用转换流InputStreamReader
		//InputStreamReader isr = new InputStreamReader(in);

		//为了提高效率，将字符串进行缓冲区技术高效操作，使用BufferedReader
		//BufferedReader bufr = new BufferedReader(isr);
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//OutputStream out = System.out;
		//OutputStreamWriter osw = new OutputStreamWriter(out);
		//BufferedWriter bufw = new BufferedWriter(osw);
		
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

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
