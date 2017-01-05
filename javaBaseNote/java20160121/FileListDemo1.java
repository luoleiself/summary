/*
static File[] listRoots();
				�г����õ��ļ�ϵͳ����ʾ����File files = File.listRoots();
String[] list();
				����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼�е��ļ���Ŀ¼�����ص����ƣ�		
String[] list(FilenameFilter filter);
				����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼��
File[] listFiles();
				����һ������·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼�е��ļ������صĶ��󣬿���ͨ����ȡ��������Ʒ���ֵ��
File[] listFiles(FileFilter filter);
				���س���·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼��
File[] listFiles(FilenameFilter filter);
				���س���·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼��

FilenameFilter�ӿڣ�
			ʵ�ִ˽ӿڵ���ʵ�������ڹ������ļ�����
			Abstract Window Toolkit ���ļ��Ի������ʹ����Щʵ������ File ��� list �����е�Ŀ¼�嵥��
		������
		boolean accept(File dir, String name)��
				����ָ���ļ��Ƿ�Ӧ�ð�����ĳһ�ļ��б��С�

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
		
		//�����ڲ��ࣺ
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
		//�����ڲ�����������Է���ֵΪ�������й��ˣ����Ϊ�棬�����0�������Ϊ�٣������ȫ����
		//������˺�׺Ϊ.bmp���ļ�����.bmpΪ�ж������������١�
		for(String name : dir)
		{
			System.out.println(name);
		}
	}
	public static void listDemo()//�г���ǰ�̷��µ������ļ�����
	{
		File f = new File("c:\\");

		String [] names = f.list();
		//����list������file��������Ƿ�װ��һ��Ŀ¼����Ŀ¼��������ڡ�
		for (String name: names)
		{
			System.out.println(name);
		}
	}
	public static void listRootDemo()//�г���ǰ�������е��̷���
	{
		File[] files = File.listRoots();
		 for (File f: files)
		 {
			 System.out.println(f);
		 }
	}
	//���н���������ǰ���Ե������̷���C:\ 
}
