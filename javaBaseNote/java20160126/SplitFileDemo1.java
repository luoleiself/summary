/*

*/
import java.io.*;
import java.util.*;
class  SplitFileDemo1
{
	public static void main(String[] args) 
	{
		
	}
	public static void  splitFile()
	{
		FileInputStream fis = new FileInputStream("d:\\1.bmp");

		FileOutputStream fos = null;

		byte[] buf = new byte[1024*1024];
		int len = 0;
		int count = 1;
		while ((len = fis.read())!= -1)
		{
			fos = new FileOutputStream("d:\\splitfile\\"+(count++)+".part");
			fos.write(buf,0,len);
			fos.close();
		}
		fis.close();
	}
	public static void sequenceFile()
	{
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for (int x=1;x<=3 ;x++ )
		{
			al.add(new FileInputStream("d:\\splitfile\\"+x+".part"));
		}
		Iterator<FileInputStream> it = al.iterator();

		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>()
		{
			public boolean hasMoreElements()
			{
				return it.hasNext();
			}
			public FileInputStream nextElement()
			{
				return it.next();
			}
		};
		SequenceInputStream<FileInputStream> sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream("d:\\splitfile\\0.bmp");

		byte[] buf = new byte[1024];
		int len = 0;

		while ((len = sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}
}




