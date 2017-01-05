/*
�ַ�����
	FileReader
	FileWriter

	BufferedReader
	BufferedWriter

�ֽ�����
	FileInputStream
	FileOutputStream

	BufferedInputStream
	BufferedOutputStream

�ֽ�����
	|--java.lang.Object:
		|--java.io.InputStream������
			|--java.io.FilterInputStreamʵ����
				|--java.io.BufferedInputStreamʵ����
	|--java.lang.Object:
		|--java.io.OutputStream������
			|--java.io.FilterOutputStreamʵ����
				|--java.io.BufferedOutputStreamʵ����

������Ҫ����ͼƬ���ݣ���Ҫ�õ��ֽ�����

BufferedOutputStreamʵ����
				�ֶ�ժҪ��
					protected  byte[] buf
								�洢���ݵ��ڲ���������
					protected  int count 
								�������е���Ч�ֽ�����
 
				���췽����
					BufferedOutputStream(OutputStream out);
								����һ���µĻ�����������Խ�����д��ָ���ĵײ��������
					BufferedOutputStream(OutputStream out, int size);
								����һ���µĻ�����������Խ�����ָ����������С������д��ָ���ĵײ��������
				void flush();
						ˢ�´˻�����������
				void write(byte[] b, int off, int len);
						��ָ�� byte �����д�ƫ���� off ��ʼ�� len ���ֽ�д��˻�����������
				void write(int b);
						��ָ�����ֽ�д��˻�����������

BufferedInputStreamʵ����
				�ֶ�ժҪ��
					protected  byte[] buf 
								�洢���ݵ��ڲ����������顣
					protected  int count 
								�Ȼ����������һ����Ч�ֽڵ������� 1 ��������
					protected  int marklimit 
								���� mark �������ں������� reset ����ʧ��֮ǰ������������ǰ��ȡ����
					protected  int markpos 
								���һ�ε��� mark ����ʱ pos �ֶε�ֵ��
					protected  int pos 
								�������еĵ�ǰλ�á�
				���캯����
					BufferedInputStream(InputStream in);
								����һ�� BufferedInputStream ��������������������� in���Ա㽫��ʹ�á�
					BufferedInputStream(InputStream in, int size);
								��������ָ����������С�� BufferedInputStream ��������������������� in���Ա㽫��ʹ�á�
				int available();
						���ؿ��ԴӴ���������ȡ�������������Ҳ��ܴ��������������ķ������������Ĺ����ֽ�����
				void close();
						�رմ����������ͷ����������������ϵͳ��Դ��
				void mark(int readlimit);
						�μ� InputStream �� mark �����ĳ���Э����
				boolean markSupported();
						���Դ��������Ƿ�֧�� mark �� reset ������
				int read();
						�μ� InputStream �� read �����ĳ���Э����
				int read(byte[] b, int off, int len);
						�Ӵ��ֽ��������и���ƫ��������ʼ�����ֽڶ�ȡ��ָ���� byte �����С�
				void reset();
						�μ� InputStream �� reset �����ĳ���Э��.
				long skip(long n);
						�μ� InputStream �� skip �����ĳ���Э����
*/
import java.io.*;
class  InputOutputStreamDemo1
{
	public static void main(String[] args) 
	{
		
	}
	public static void writeFile_3()throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] byt = new byte[fis.available()];

		fis.read(byt);

		System.out.println(new String(byt));

		fis.close();
		
	}
	public static void writeFile_2()throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");

		byte[] but = new byte[1024];
		int len = 0;
		while ((len = fis.read(but))!=-1)
		{
			System.out.println(new String(but,0,len));
		}
		fis.close();
	}
	public static void writeFile_1()throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");

		int ch = 0;
		while ((ch = fis.read())!=-1)
		{
			System.out.println((char)ch);
		}
		fis.close();
	}
	public static void writeFile()throws IOException
	{
		FileOutputStream fos = new FileOutputStream("fos.txt");

		fos.write("abcde".getBytes());
		fos.close();
	}
}
