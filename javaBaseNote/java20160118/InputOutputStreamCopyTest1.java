/*
����һ��ͼƬ��
˼·��
1�����ֽڶ�ȡ�������ͼƬ������
2�����ֽ�д�������󴴽�һ��ͼƬ�ļ������ڴ洢��ȡ����ͼƬ���ݡ�
3��ͨ��ѭ����д��������ݵĴ洢��
4���ر���Դ��

*/
import java.io.*;
class  InputOutputStreamCopyTest1
{
	public static void main(String[] args) 
	{
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try
		{
			fos = new FileOutputStream("2.bmp");
			fis = new FileInputStream("1.bmp");

			byte[] byt = new byte[1024];
			int len = 0;
			while ((len = fis.read(byt))!=-1)
			{
				fos.write(byt,0,len);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("�����ļ�ʧ��");
		}
		finally
		{
			try
			{
				if (fos!=null)
				{
					fos.close();
				}
			}
			catch (IOException e)
			{
				throw new RuntimeException("д��ر�ʧ��");
			}
			try
			{
				if (fis != null)
				{
					fis.close();
				}
			}
			catch (IOException e)
			{
				throw new RuntimeException("��ȡ�ر�ʧ��");
			}
		}
	}
}
