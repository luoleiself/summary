/*
�õڶ��ַ�ʽ ��ͨ���ַ�������ж�ȡ��

*/
import java.io.*;
class  FileReaderDemo2
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		FileReader fr = new FileReader("Demo.txt");

		//����һ���ַ����飬���ڴ洢�µ����ַ���
		//��read(char[])���ص��Ƕ����ַ�������
		char[] buf = new char[1024];
		int num = fr.read(buf);

		stringPrint("num:"+num"::::"+new String(buf));
		fr.close();


		int num = 0;
		while ((num = fr.read(buf))!=-1)
		{
			stringPrint(new String(buf,0,num));
		}
		fr.close();
	}
}
