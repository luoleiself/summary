/*
因为目录中还有目录，只要使用同一个列出目录功能的方法完成即可。
在列出过程中出现的还是目录的话，还可以再次调用本功能，也就是方法自身调用自身。
这种表现形式，或者编程手法，称为递归。

递归注意：
		1，限定条件。
		2，要注意递归的次数，尽量避免内存溢出。
*/
import java.io.*;
class  FileDemo3
{
	public static void main(String[] args) 
	{
		File dir = new File("d:\\java");
		showDir(dir,0);
	}
	public static String getLevel(int level)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("|--");//在末尾处添加，
		for (int x=0;x<level ;x++ )
		{
			sb.insert(0,"|  ");//从开始端开始添加。
		}
		return sb.toString();
	}
	public static void showDir(File dir,int level)
	{
		System.out.println(getLevel(level)+dir.getName());
		
		level++;
		File[] files = dir.listFiles();
		for (int x=0;x<files.length;x++ )
		{
			if (files[x].isDirectory())
			{
				showDir(files[x],level);
			}
			else
			{
				System.out.println(getLevel(level)+files[x]);
			}
		}
	}
}
