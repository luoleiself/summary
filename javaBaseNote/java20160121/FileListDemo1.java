/*
static File[] listRoots();
				列出可用的文件系统根。示例：File files = File.listRoots();
String[] list();
				返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。返回的名称，		
String[] list(FilenameFilter filter);
				返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录。
File[] listFiles();
				返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。返回的对象，可以通过获取对象的名称返回值。
File[] listFiles(FileFilter filter);
				返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
File[] listFiles(FilenameFilter filter);
				返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。

FilenameFilter接口：
			实现此接口的类实例可用于过滤器文件名。
			Abstract Window Toolkit 的文件对话框组件使用这些实例过滤 File 类的 list 方法中的目录清单。
		方法：
		boolean accept(File dir, String name)；
				测试指定文件是否应该包含在某一文件列表中。

*/
import java.io.*;
class	FileListDemo1
{
	public static void main(String[] args) 
	{
		
	}
	public static void FilenameFilterMethod2()
	{
		File dir = new File("c:\\");
		File[] files = dir.listFiles();

		for(File f:files)
		{
			System.out.println(f.getName()+"::"f.length());
		}
	}
	public static void FilenameFilterMethod1()
	{
		File dir = new File("d:\\java");
		
		//匿名内部类：
		String [] arr = dir.list(new FilenameFilter()
		{
			public boolean accept(File dir,String name)
			{
				System.out.println("dir:"+dir+"....name::"+name);

				/*
				if (name.endsWith(".bmp"))
				{
					return true;
				}
				else
					return false;
				*/

				return name.endsWith(".bmp");
			}
		});
		//匿名内部类的作用是以返回值为条件进行过滤，如果为真，则过滤0个，如果为假，则过滤全部。
		//如果过滤后缀为.bmp的文件则以.bmp为判断条件返回真或假。
		for(String name : dir)
		{
			System.out.println(name);
		}
	}
	public static void listDemo()//列出当前盘符下的所有文件名。
	{
		File f = new File("c:\\");

		String [] names = f.list();
		//调用list方法的file对象必须是封装了一个目录。该目录还必须存在。
		for (String name: names)
		{
			System.out.println(name);
		}
	}
	public static void listRootDemo()//列出当前电脑所有的盘符。
	{
		File[] files = File.listRoots();
		 for (File f: files)
		 {
			 System.out.println(f);
		 }
	}
	//运行结果：输出当前电脑的所有盘符。C:\ 
}
