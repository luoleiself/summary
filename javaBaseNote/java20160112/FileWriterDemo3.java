/*
��ʾ�������ļ���������д��

*/
import java.io.*;
class  FileWriterDemo3
{
	public static void main(String[] args) 
	{
		//����һ��true�����������������е��ļ������������ļ���ĩβ������������д��
		FileWriter fw = new FileWriter("Demo.txt",true);
		
		//\r\n��winϵͳ�µĹ����ǻ��С�
		fw.write("java001\r\njava002");
		fw.flush();
	}
}
