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

ͨ���ղŵļ���¼��һ�����ݲ���ӡ���д��������ʵ���Ƕ�һ�����ݵ�ԭ��Ҳ����readLine������

ReadLine�������ַ���BufferedReader���еķ���������¼���read�������ֽ���InputStrem�ķ�����

��ô�ܲ��ܽ��ֽ���ת���ַ�����ʹ���ַ�����������readLine�����أ�

InputStreamReaderʵ���ࣺ
				���캯����
					InputStreamReader(InputStream in);
							����һ��ʹ��Ĭ���ַ����� InputStreamReader��
					InputStreamReader(InputStream in, Charset cs) 
							����ʹ�ø����ַ����� InputStreamReader�� 
					InputStreamReader(InputStream in, CharsetDecoder dec) 
							����ʹ�ø����ַ����������� InputStreamReader�� 
					InputStreamReader(InputStream in, String charsetName) 
							����ʹ��ָ���ַ����� InputStreamReader��
				String getEncoding();
						���ش���ʹ�õ��ַ���������ơ�

OutputStreamWriterʵ���ࣺ
				���캯����
					OutputStreamWriter(OutputStream out) 
							����ʹ��Ĭ���ַ������ OutputStreamWriter�� 
					OutputStreamWriter(OutputStream out, Charset cs) 
							����ʹ�ø����ַ����� OutputStreamWriter�� 
					OutputStreamWriter(OutputStream out, CharsetEncoder enc) 
							����ʹ�ø����ַ����������� OutputStreamWriter�� 
					OutputStreamWriter(OutputStream out, String charsetName) 
							����ʹ��ָ���ַ����� OutputStreamWriter��
				String getEncoding() 
						���ش���ʹ�õ��ַ���������ơ�			
*/
import java.io.*;
class  TransStreamDemo1
{
	public static void main(String[] args) 
	{
		//��ȡ����¼�����
		//InputStream in = System.in;

		//���ֽ�������ת���ַ�������ʹ��ת����InputStreamReader
		//InputStreamReader isr = new InputStreamReader(in);

		//Ϊ�����Ч�ʣ����ַ������л�����������Ч������ʹ��BufferedReader
		//BufferedReader bufr = new BufferedReader(isr);
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//OutputStream out = System.out;
		//OutputStreamWriter osw = new OutputStreamWriter(out);
		//BufferedWriter bufw = new BufferedWriter(osw);
		
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;
		while ((line = bufr.readLine())!=null)
		{
			if ("over".equals(line))
			{
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}
}
