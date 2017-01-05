/*
IO异常的处理方式。

*/
import java.io.*;
class  FileWriterExceptionDemo2
{
	public static void main(String[] args) 
	{
		FileWriter fw = null;
		try
		{
			fw = new FileWriter("Demo.txt");
			fw.write("java001");	
		}
		catch (IOException  e)
		{
			System.out.println("catch1:"+e.toString())
		}
		finally
		{
			try
			{
				if (fw!=null)
				{
					fw.close();
				}
			}
			catch (IOException  e)
			{
				System.out.println("catch2:"+e.toString())
			}
		}
	}
}
