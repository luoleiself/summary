/*
|--java.lang.Object:
	|--java.io.Reader�����ࣺ
		|--java.io.InputStreamReaderʵ����:
			|--java.io.FileReaderʵ����:
	|--java.io.BufferedReaderʵ���ࣺ
		|--java.io.LineNumberReaderʵ���ࣺ

LineNumberReader��		
		�����кŵĻ����ַ������������ඨ���˷��� setLineNumber(int) �� getLineNumber()��
		���ǿɷֱ��������úͻ�ȡ��ǰ�кš�
		Ĭ������£��б�Ŵ� 0 ��ʼ�����к������ݶ�ȡ��ÿ���н����������������ҿ���ͨ������ setLineNumber(int) �����кš�
		��Ҫע����ǣ�setLineNumber(int) ����ʵ�ʸ������еĵ�ǰλ�ã���ֻ���Ľ��� getLineNumber() ���ص�ֵ��

LineNumberReader������
				���췽����
					LineNumberReader(Reader in)��
							ʹ��Ĭ�����뻺�����Ĵ�С�����µ��б�� reader��
					LineNumberReader(Reader in, int sz)��
							�����µ��б�� reader�����ַ����������С�Ļ�������
				int getLineNumber();
						��õ�ǰ�кš�
				void mark(int readAheadLimit);
						��Ǹ����еĵ�ǰλ�á�
				int read();
						��ȡ�����ַ���
				int read(char[] cbuf, int off, int len);
						���ַ����������е�ĳһ���֡�
				String readLine();
						��ȡ�ı��С�
				void reset();
						��������������Ϊ���µı�ǡ�
				void setLineNumber(int lineNumber);
						���õ�ǰ�кš�
				long skip(long n);
						�����ַ���	
*/
import java.io.*;
class  LineNumberReaderDemo1
{
	public static void main(String[] args) 
	{
		FileReader fr = new FileReader("Demo.java");

		LineNumberReader lnr = new LineNumberReader(fr);

		String line = null;
		lnr.setLineNumber(100);
		while ((line = lnr.readLine())!=null)
		{
			System.out.println(lnr.getLineNumber()+"::"+line);
		}
		lnr.close();
	}
}
