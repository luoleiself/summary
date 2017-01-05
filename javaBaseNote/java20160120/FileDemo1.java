/*
|--java.lang.Object
	|--java.io.File实例类：

File类：文件和目录路径名的抽象表示形式。 
	1，用来将文件或者文件夹封装成对象。
	2，方便对文件和文件夹的属性信息进行操作。
	3，File对象可以作为参数传递给流的构造函数。
	
	字段摘要：
		static String pathSeparator;
						与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
		static char pathSeparatorChar;
						与系统有关的路径分隔符。
		static String separator;
						与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
		static char separatorChar;
						与系统有关的默认名称分隔符。
	构造方法：
		File(File parent, String child);
						根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
		File(String pathname);
						通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
		File(String parent, String child);
						根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
		File(URI uri);
						通过将给定的 file: URI 转换为一个抽象路径名来创建一个新的 File 实例。
	常用方法：
		boolean canExecute();
						测试应用程序是否可以执行此抽象路径名表示的文件。
		boolean canRead(); 
						测试应用程序是否可以读取此抽象路径名表示的文件。 
		boolean canWrite(); 
						测试应用程序是否可以修改此抽象路径名表示的文件。 
		int compareTo(File pathname); 
						按字母顺序比较两个抽象路径名。 
		boolean createNewFile(); 
						当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。 
						在指定位置创建文件，如果该文件已经存在，则不能创建，返回false。
						和输出流不一样，输出流对象一建立就创建文件，而且文件如果存在则覆盖。
		static File createTempFile(String prefix, String suffix); 
						在默认临时文件目录中创建一个空文件，使用给定前缀和后缀生成其名称。 
		static File createTempFile(String prefix, String suffix, File directory); 
						在指定目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称。
		boolean delete(); 
						删除此抽象路径名表示的文件或目录。删除失败返回false。 
		void deleteOnExit(); 
						在虚拟机终止时，请求删除此抽象路径名表示的文件或目录。 在程序退出时删除指定文件。
		boolean equals(Object obj); 
						测试此抽象路径名与给定对象是否相等。 
		boolean exists(); 
						测试此抽象路径名表示的文件或目录是否存在。 
		File getAbsoluteFile(); 
						返回此抽象路径名的绝对路径名形式。 
		String getAbsolutePath(); 
						返回此抽象路径名的绝对路径名字符串。
		String getParent(); 
						返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。 
		File getParentFile(); 
						返回此抽象路径名父目录的抽象路径名；如果此路径名没有指定父目录，则返回 null。
		String getPath(); 
						将此抽象路径名转换为一个路径名字符串。
		boolean isAbsolute(); 
						测试此抽象路径名是否为绝对路径名。 
		boolean isDirectory(); 
						测试此抽象路径名表示的文件是否是一个目录。 File f = new File("文件名");文件未创建，返回false，使用boolean exists();判断是否存在。
		boolean isFile(); 
						测试此抽象路径名表示的文件是否是一个标准文件。File f = new File("文件名");文件未创建，返回false，使用boolean exists();判断是否存在。 
		boolean isHidden(); 
						测试此抽象路径名指定的文件是否是一个隐藏文件。 
		long lastModified(); 
						返回此抽象路径名表示的文件最后一次被修改的时间。 
		boolean setLastModified(long time); 
						设置此抽象路径名指定的文件或目录的最后一次修改时间。 
		long length(); 
						返回由此抽象路径名表示的文件的长度。 
		boolean mkdir(); 
						创建此抽象路径名指定的目录。 
		boolean mkdirs(); 
						创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
		boolean renameTo(File dest); 
						重新命名此抽象路径名表示的文件。
		boolean setExecutable(boolean executable); 
						设置此抽象路径名所有者执行权限的一个便捷方法。 
		boolean setExecutable(boolean executable, boolean ownerOnly); 
						设置此抽象路径名的所有者或所有用户的执行权限。 
		boolean setReadable(boolean readable); 
						设置此抽象路径名所有者读权限的一个便捷方法。 
		boolean setReadable(boolean readable, boolean ownerOnly); 
						设置此抽象路径名的所有者或所有用户的读权限。 
		boolean setReadOnly(); 
						标记此抽象路径名指定的文件或目录，从而只能对其进行读操作。
		boolean setWritable(boolean writable); 
						设置此抽象路径名所有者写权限的一个便捷方法。 
		boolean setWritable(boolean writable, boolean ownerOnly); 
						设置此抽象路径名的所有者或所有用户的写权限。 
		URI toURI(); 
						构造一个表示此抽象路径名的 file: URI。
		static File[] listRoots();
						列出可用的文件系统根。示例：File files = File.listRoots();
		String[] list();
						返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。		
		String[] list(FilenameFilter filter);
						返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录。
		File[] listFiles();
						返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
		File[] listFiles(FileFilter filter);
						返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
		File[] listFiles(FilenameFilter filter);
						返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
*/
import java.io.*;
class  FileDemo1
{
	public static void print(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
			
	}

	//创建File对象。
	public static void consMethod()
	{
		//将a.txt封装成对象，可以将已有的和未出现的文件或者文件夹封装成对象。
		File f1 = new File("c:\\abc\\a.txt");
		//File f1 = new File("c:/abc/a.txt");
		
		//左边为父目录，右边是子文件夹。传递文件名可以为变量。
		File f2 = new File("c:\\abc","b.txt");
		
		File d = new File("c:\\abc");
		File f3 = new File(d,"c.txt");

		File f4 = new File("c:"+File.separator+"abc"+File.separator+"a.txt");

		print("f1:"+f1);
		print("f2:"+f2);
		print("f3:"+f3);
	}
	public static void method_5()
	{
		File f = new File("file.txt");
		
		f.createNewFile();

		f.mkdir();

		//记住在判断文件对象是否是文件或者目录时，必须要先判断该文件对象封装的内容是否存在。
		//通过exists判断。
		print("dir:"+f.isDirectory());
		//File f = new File("file.txt");结果:false; f.createNewFile();结果:false; f.mkdir();结果:true;
		print("file:"+f.isFile());
		//File f = new File("file.txt");结果:false; f.createNewFile();结果:true; f.mkdir();结果:false;
	
		print("isAbsolute:"+f.isAbsolute());//判断是否为绝对路径。
	}
	public static void method_6()
	{
		File f = new File("a.txt");

		print("path:"+f.getPath());//获取文件路径。
		print("Absolutepath:"+f.getAbsolutePath());//获取文件的绝对路径全称。
		
		//该方法返回的是绝对路径中的父目录，如果获取的是相对路径，则返回null
		//如果相对路径中有上一层目录，那么该目录就是返回结果。
		print("parent:"+f.getParent());//结果：null
	}
	public static void method_7()
	{
		File f1 = new File("c:\\test.java");
		File f2 = new File("c:\\renameTotest.java");

		//将文件重命名。如果新文件在非源文件目录下，则剪切后重命名，功能类似于剪切。
		print("renameTo:"+f1.renameTo(f2));
	}
	public static void method_1()
	{
		File f = new File("file1.txt");
		
		f.deleteOnExit();//程序退出立刻删除文件。

		print("createNewFile:"+f.createNewFile());//创建文件，如果文件已建立则返回false。

		print("delete:"+f.delete());//删除当前文件。
	}
	public static void method_2()
	{
		File f = new File("file2.txt");

		print("execute:"+f.canExecute());//判断文件是否能运行。
	}
	public static void method_3()
	{
		File f = new File("file3.txt");
		
		print("exists:"+f.exists());//判断文件是否存在。
	}
	public static void method_4()
	{
		File dir = new File("abc");

		print("mkdir:"+dir.mkdir());//在当前目录下创建文件夹。只能创建一级目录。
		print("mkdir:"+dir.mkdirs());//在当前目录下创建文件夹。可以创建多级目录。
	}
}




