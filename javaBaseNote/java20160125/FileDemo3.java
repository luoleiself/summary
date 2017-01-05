/*
��ΪĿ¼�л���Ŀ¼��ֻҪʹ��ͬһ���г�Ŀ¼���ܵķ�����ɼ��ɡ�
���г������г��ֵĻ���Ŀ¼�Ļ����������ٴε��ñ����ܣ�Ҳ���Ƿ��������������
���ֱ�����ʽ�����߱���ַ�����Ϊ�ݹ顣

�ݹ�ע�⣺
		1���޶�������
		2��Ҫע��ݹ�Ĵ��������������ڴ������
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
		sb.append("|--");//��ĩβ����ӣ�
		for (int x=0;x<level ;x++ )
		{
			sb.insert(0,"|  ");//�ӿ�ʼ�˿�ʼ��ӡ�
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
