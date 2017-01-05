/*
|--java.lang.Object:
	|--java.io.Reader�����ࣺ
		|--java.io.InputStreamReaderʵ����:
			|--java.io.FileReaderʵ����:
	
Reader������:
			���캯����
				protected  Reader();
							����һ���µ��ַ��� reader������Ҫ���ֽ�ͬ��������� reader��
				protected  Reader(Object lock);
							����һ���µ��ַ��� reader������Ҫ���ֽ�ͬ�������Ķ���
		abstract  void close();
					�رո������ͷ���֮������������Դ��
		void mark(int readAheadLimit);
					������еĵ�ǰλ�á�
		boolean markSupported();
					�жϴ����Ƿ�֧�� mark() ������
		int read();
					��ȡ�����ַ���
		int read(char[] cbuf);
					���ַ��������顣
		abstract  int read(char[] cbuf, int off, int len);
					���ַ����������ĳһ���֡�
		int read(CharBuffer target);
					��ͼ���ַ�����ָ�����ַ���������
		boolean ready();
					�ж��Ƿ�׼����ȡ������
		void reset();
					���ø�����
		long skip(long n);
					�����ַ���

InputStreamReaderʵ����:
			���캯����
				InputStreamReader(InputStream in);
							����һ��ʹ��Ĭ���ַ����� InputStreamReader��
				InputStreamReader(InputStream in, Charset cs);
							����ʹ�ø����ַ����� InputStreamReader��
				InputStreamReader(InputStream in, CharsetDecoder dec);
							����ʹ�ø����ַ����������� InputStreamReader��
				InputStreamReader(InputStream in, String charsetName);
							����ʹ��ָ���ַ����� InputStreamReader��
		String getEncoding();
					���ش���ʹ�õ��ַ���������ơ�

FileReaderʵ����:
			���캯����
				FileReader(File file);
							�ڸ������ж�ȡ���ݵ� File ������´���һ���� FileReader��
				FileReader(FileDescriptor fd);
							�ڸ������ж�ȡ���ݵ� FileDescriptor ������´���һ���� FileReader��
				FileReader(String fileName);
							�ڸ������ж�ȡ���ݵ��ļ���������´���һ���� FileReader��
*/
import java.io.*;
class  FileReaderDemo1
{
	public static void stringPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		//����һ���ļ���ȡ�����󣬺�ָ�����Ƶ��ļ��������
		//Ҫ��֤���ļ��Ƿ��Ѿ����ڵģ���������ڣ��ᷢ���쳣FileNotFoundException��
		FileReader fr = new FileReader("Demo.txt");
		
		//���ö�ȡ�������read������
		//read()��һ�ζ�һ���ַ������һ��Զ����¶�������ﵽ����ĩβ����᷵��-1.
		int ch = fr.read();
		stringPrint("ch:"+(char)ch);

		int ch = 0;
		while((ch = fr.read())!=-1)
		{
			stringPrint("ch:"+(char)ch);
		}	
	}
}
