/*
演示对已有文件的数据续写。

*/
import java.io.*;
class  FileWriterDemo3
{
	public static void main(String[] args) 
	{
		//传递一个true参数，代表不覆盖已有的文件，并在已有文件的末尾处进行数据续写。
		FileWriter fw = new FileWriter("Demo.txt",true);
		
		//\r\n在win系统下的功能是换行。
		fw.write("java001\r\njava002");
		fw.flush();
	}
}
