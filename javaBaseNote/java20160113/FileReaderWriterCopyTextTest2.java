/*
��C�̵�һ���ļ����Ƶ�D�̡�

����ԭ��
		��ʵ���ǽ�C���µ��ļ����ݴ洢��D�̵�һ���ļ��С�

˼·��
	1����D�̴���һ���ļ������ڴ洢C���ļ��е����ݡ�
	2�������ȡ����C���ļ�������
	3��ͨ�����ϵĶ�д������ݴ洢��
	4���ر���Դ��
*/
import java.io.*;
class  FileReaderWriterCopyTextTest2
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
	//�ڶ��ַ�ʽ��
	public static void Copy_2()
	{
		//����Ŀ�ĵء�
		FileWriter fw = null;

		//�������ļ�������
		FileReader fr = null;

		try
		{
			fw = new FileWriter("DataDemo_Copy.java");
			fr = new FileReader("DataDemo.java");

			char[] buf = new char[1024];
			
			int len = 0;
			while ((len = fr.read(buf))!=-1)
			{
				fw.write(buf,0,len);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("��дʧ��");
		}
		finally
		{
			if(fr!=null)
				try
				{
					fr.close();
				}
				catch (IOException e)
				{

				}
			if (fw!=null)
			{
				try
				{
					fw.close();
				}
				catch (IOException e)
				{

				}
			}
		}

	}

	//��һ�ַ�ʽ��
	//��C�̶�һ���ַ�������D��дһ���ַ���
	public static void Copy_1() throws IOException
	{
		//����Ŀ�ĵء�
		FileWriter fw = new FileWriter("DataDemo_Copy.java");

		//�������ļ�������
		FileReader fr = new FileReader("DataDemo.java");

		int ch = 0;
		while ((ch = fr.read())!=-1)
		{
			fw.write(ch);
		}
		fw.close();
		fr.close();
	}
}
