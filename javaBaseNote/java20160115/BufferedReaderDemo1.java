/*
�ַ����Ļ�������
			|--java.io.Object
				|--java.io.Writer
					|--java.io.BufferedWriter:
			|--java.io.Object
				|--java.io.Reader
					|--java.io.BufferedReader��

�������ĳ�����Ϊ��������Ĳ���Ч�ʶ����ֵģ������ڴ���������֮ǰ������Ҫ����������
�û������ṩ��һ��һ�ζ�һ�еķ���readLine�������ڶ��ı����ݵĻ�ȡ��
������nullʱ����ʾ�����ļ�ĩβ��

readerLine�������ص�ʱ��ֻ���ػس���֮ǰ���������ݣ��������ػس�����
		
		BufferedReader:
				���췽����
					BufferedReader(Reader in);
								����һ��ʹ��Ĭ�ϴ�С���뻺�����Ļ����ַ���������
					BufferedReader(Reader in, int sz);
								����һ��ʹ��ָ����С���뻺�����Ļ����ַ���������
				void close();
						�رո������ͷ���֮������������Դ��
				void mark(int readAheadLimit);
						������еĵ�ǰλ�á�
				boolean markSupported();
						�жϴ����Ƿ�֧�� mark() ��������һ��֧�֣���
				int read();
						��ȡ�����ַ���
				int read(char[] cbuf, int off, int len);
						���ַ����������ĳһ���֡�
				String readLine();
						��ȡһ���ı��С�
				boolean ready();
						�жϴ����Ƿ���׼���ñ���ȡ��
				void reset();
						�������õ����µı�ǡ�
				long skip(long n);
						�����ַ���
*/
import java.io.*;
class  BufferedReaderDemo1
{
	public static void main(String[] args) 
	{
		//����һ���ַ����Ķ��������ļ��������
		FileReader fr = new FileReader("Demo.text");

		//Ϊ�����Ч�ʣ����뻺�弼�������ַ���ȡ��������Ϊ�������ݸ��������Ĺ��캯��;
		BufferedReader bufr = new BufferedReader(fr);

		String line = null;
		while ((line = bufr.readLine())!=null)
		{
			System.out.println(line);
		}
		bufr.close();
	}
}
