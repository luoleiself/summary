/*
ɾ��һ�������ݵ�Ŀ¼��
˼·��ɾ��ԭ��
��Windows�У�ɾ��Ŀ¼�Ǵ���������ɾ���ġ�

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
