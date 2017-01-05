/*
演示MP3的复制，通过缓冲区。
BufferedOutputStream
BufferedInputStream

*/
import java.io.*;
class  BufferedStreamCopyMP3
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();
		copy_1();
		long end = System.currentTimeMillis();
		System.out.println((end - start)+"毫秒");
	}
	public static void copy_1()
	{
		BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("1.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("2.mp3"));

		int byt = 0;
		while ((byt = bufis.read())!=-1)
		{
			bufos.write(byt);
		}
		bufos.close();
		bufis.close();
	}
}
