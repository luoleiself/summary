/*
�ַ����Ļ�������
			|--java.io.Object
				|--java.io.Writer
					|--java.io.BufferedWriter:
			|--java.io.Object
				|--java.io.Reader
					|--java.io.BufferedReader��

�������ĳ�����Ϊ��������Ĳ���Ч�ʶ����ֵģ������ڴ���������֮ǰ������Ҫ����������
		
		BufferedWriter:
				���췽����
					BufferedWriter(Writer out);
							����һ��ʹ��Ĭ�ϴ�С����������Ļ����ַ��������
					BufferedWriter(Writer out, int sz)��
							����һ��ʹ�ø�����С������������»����ַ��������
				void close();
					�رմ�������Ҫ��ˢ������
				void flush();
					ˢ�¸����Ļ��塣
				void newLine();
					д��һ���зָ�����
				void write(char[] cbuf, int off, int len);
					д���ַ������ĳһ���֡�
				void write(int c); 
					д�뵥���ַ���
				void write(String s, int off, int len);
					д���ַ�����ĳһ���֡�	
*/
import java.io.*;
class  BufferedWriterDemo1
{
	public static void main(String[] args) 
	{
		//����һ���ַ�д��������
		FileWriter fw = new FileWriter("Demo.text");

		//Ϊ������ַ�д����Ч�ʣ������˻��弼����
		//ֻҪ����Ҫ�����Ч�ʵ���������Ϊ�������ݸ��������Ĺ��캯�����ɡ�
		BufferedWriter bufw = new BufferedWriter(fw);

		bufw.write("java001");
		bufw.newLine();
		
		for (int x = 0;x<10 ;x++ )
		{
			bufw.write("java"+x);
			bufw.newLine();
			bufw.flush();
		}

		//��ס��ֻҪ�õ�����������Ҫ�ǵ�ˢ�¡�
		bufw.flush();

		//��ʵ�رջ������������ڹرջ������е�������
		bufw.close();
	}
}
