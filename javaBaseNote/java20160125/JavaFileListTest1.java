/*
��ϰ��
��һ��ָ��Ŀ¼�µ�java�ļ��ľ���·�����洢��һ���ı��ļ��С�����һ��java�ļ��б��ļ���

˼·��
	1����ָ����Ŀ¼���еݹ顣
	2����ȡ�ݹ���������е�java�ļ���·����
	3������Щ·���洢�������С�
	4���������е�����д�뵽һ���ļ��С�
*/
import java.io.*;
import java.util.*;
class  JavaFileListTest1
{
	public static void print(Object obj)throws IOException
	{
		System.out.println(obj);
	}
	public static void main(String[] args)throws IOException 
	{
		File dir = new File("d:\\java");
		List<File> list = new ArrayList<File>();
		fileToList(dir,list);
		
		File file = new File(dir,"javalistFile.txt");
		writeToFile(list,file.toString());
	}
	public static void fileToList(File dir,List<File> list)throws IOException
	{
	
		File[] files = dir.listFiles();
		for (File file:files)
		{
			if (file.isDirectory())
			{
				fileToList(file,list);
			}
			else
			{
				if (file.getName().endsWith(".java") || file.getName().endsWith(".jpg") || file.getName().endsWith(".txt"))
				{
					list.add(file);
				}
			}
		}
	}
	public static void writeToFile(List<File> list,String javaListFile)throws IOException
	{
		BufferedWriter bufw = null;
		try
		{
			bufw = new BufferedWriter(new FileWriter(javaListFile));
			for(File f:list)
			{
				String path = f.getAbsolutePath();
				bufw.write(path);
				bufw.newLine();
				bufw.flush();
			}
		}
		catch (IOException e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if (bufw!=null)
				{
					bufw.close();
				}
			}
			catch (IOException e)
			{
				throw e;
			}
		}
	}
}
