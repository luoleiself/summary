/*
��ȡһ��.java�ļ�������ӡ�ڿ���̨�ϡ�

*/
import java.io.*;
class  FileReaderArraysTest1
{
	public static void main(String[] args) 
	{
		FileReader re = new FileReader("DataDemo.java");

		char[] buf = new char[1024];
		int num = 0;
		while ((num = fr.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,num));
		}
		fr.close();
	}
}
