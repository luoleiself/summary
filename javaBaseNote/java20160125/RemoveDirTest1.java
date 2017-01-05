/*
删除一个带内容的目录。
思路：删除原理：
在Windows中，删除目录是从里面往外删除的。

*/
import java.io.*;
class  RemoveDirTest1
{
	public static void main(String[] args) 
	{
		File dir = new File("d:\\java");
		removeDir(dir);
	}
	public static void removeDir(File dir)
	{
		File[] files = dir.listFiles();
		for (int x=0;x<files.length;x++)
		{
			if (files[x].isDirectory())
			{
				removeDir(files[x]);
			}
			else
			{
				System.out.println(files[x].toString()+"::"+files[x].delete());
			}
		}
		System.out.println(dir+"::"+dir.delete());
	}
}
