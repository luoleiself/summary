/*
java.lang.Object
	|--java.io.OutputStream
		|--java.io.FilterOutputStream
			|--java.io.PrintStream

��ӡ���������ṩ�˴�ӡ���������Խ������������͵����ݶ�ԭ����ӡ��

�ֽڴ�ӡ����PrintStream
		���캯�����Խ��յĲ������ͣ�
						1��file����File
						2���ַ���·����String
						3���ֽ��������Stream
 Ϊ�������������˹��ܣ�ʹ�����ܹ�����ش�ӡ��������ֵ��ʾ��ʽ�������ṩ��������ܡ��������������ͬ��PrintStream ��Զ�����׳� IOException��
 ���ǣ��쳣��������ÿ�ͨ�� checkError �������Ե��ڲ���־�����⣬Ϊ���Զ�ˢ�£����Դ���һ�� PrintStream��
 ����ζ�ſ���д�� byte ����֮���Զ����� flush �������ɵ�������һ�� println ��������д��һ�����з����ֽ� ('\n')��
 PrintStream ��ӡ�������ַ���ʹ��ƽ̨��Ĭ���ַ�����ת��Ϊ�ֽڡ�����Ҫд���ַ�������д���ֽڵ�����£�Ӧ��ʹ�� PrintWriter ��.
		���캯����
			PrintStream(File file)��
					��������ָ���ļ��Ҳ����Զ���ˢ�µ��´�ӡ����
			PrintStream(File file, String csn)�� 
					��������ָ���ļ����ƺ��ַ����Ҳ����Զ���ˢ�µ��´�ӡ���� 
			PrintStream(OutputStream out)���� 
					 �����µĴ�ӡ���� 
			PrintStream(OutputStream out, boolean autoFlush)�� 
					 �����µĴ�ӡ���� 
			PrintStream(OutputStream out, boolean autoFlush, String encoding)�� 
					 �����µĴ�ӡ���� 
			PrintStream(String fileName)�� 
					 ��������ָ���ļ������Ҳ����Զ���ˢ�µ��´�ӡ���� 
			PrintStream(String fileName, String csn)�� 
					 ��������ָ���ļ����ƺ��ַ����Ҳ����Զ���ˢ�µ��´�ӡ���� 
		һ�㷽�������˾߱�Stream�Ļ�����д��ˢ�·���֮�⣬
			PrintStream append(char c)�� 
					��ָ���ַ���ӵ���������� 
			PrintStream append(CharSequence csq)�� 
					��ָ���ַ�������ӵ���������� 
			PrintStream append(CharSequence csq, int start, int end)�� 
					��ָ���ַ����е���������ӵ���������� 
			boolean checkError()�� 
					ˢ��������������״̬�� 
			protected  void clearError()�� 
					����������ڲ�����״̬��
			PrintStream format(Locale l, String format, Object... args); 
					ʹ��ָ����ʽ�ַ����Ͳ�������ʽ���ַ���д���������С� 
			PrintStream format(String format, Object... args); 
					ʹ��ָ����ʽ�ַ����Ͳ�������ʽ���ַ���д���������С� 
			protected  void setError(); 
					�������Ĵ���״̬����Ϊ true��
			PrintStream printf(Locale l, String format, Object... args); 
					ʹ��ָ����ʽ�ַ����Ͳ�������ʽ�����ַ���д���������ı�ݷ����� 
			PrintStream printf(String format, Object... args); 
					ʹ��ָ����ʽ�ַ����Ͳ�������ʽ�����ַ���д���������ı�ݷ�����

�ַ���ӡ����PrintWriter
		���캯�����Խ��յĲ������ͣ�
						1��file����File
						2���ַ���·����String
						3���ֽ��������OutputStream
						4���ַ��������Writer
���ı��������ӡ����ĸ�ʽ����ʾ��ʽ������ʵ���� PrintStream �е����� print ������
������������д��ԭʼ�ֽڵķ�����������Щ�ֽڣ�����Ӧ��ʹ��δ������ֽ�������д�롣
�� PrintStream �಻ͬ������������Զ�ˢ�£���ֻ���ڵ��� println��printf �� format ������һ������ʱ�ſ�����ɴ˲�����
������ÿ������������з�ʱ����ɡ���Щ����ʹ��ƽ̨���е��зָ�����������ǻ��з��� 
�����еķ��������׳� I/O �쳣��������ĳЩ���췽�������׳��쳣���ͻ��˿��ܻ��ѯ���� checkError() �Ƿ���ִ���
		���캯����
			PrintWriter(File file); 
					ʹ��ָ���ļ������������Զ���ˢ�µ��� PrintWriter�� 
			PrintWriter(File file, String csn); 
					��������ָ���ļ����ַ����Ҳ����Զ�ˢ���µ��� PrintWriter�� 
			PrintWriter(OutputStream out); 
					�������е� OutputStream ���������Զ���ˢ�µ��� PrintWriter�� 
			PrintWriter(OutputStream out, boolean autoFlush); 
					ͨ�����е� OutputStream �����µ� PrintWriter�� 
			PrintWriter(String fileName); 
					��������ָ���ļ������Ҳ����Զ���ˢ�µ��� PrintWriter�� 
			PrintWriter(String fileName, String csn); 
					��������ָ���ļ����ƺ��ַ����Ҳ����Զ���ˢ�µ��� PrintWriter�� 
			PrintWriter(Writer out); 
					���������Զ���ˢ�µ��� PrintWriter�� 
			PrintWriter(Writer out, boolean autoFlush); 
					������ PrintWriter��
		һ�㷽����
			ͬ�ϡ�
*/
import java.io.*;
class  PrintStreamPrintWriterDemo1
{
	public static void main(String[] args) 
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//�ص��ס����һ�����캯������ֱ������ˢ�¡�
		PrintWriter out = new PrintWriter(System.out,true);//trueֻ�����ˢ�¡�
//		PrintWriter out = new PrintWriter("a.txt");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("a.txt")),true);
		//��д���ݱ�ˢ�£�
		
		String line = null;
		while ((line = bufr.readLine()!=null))
		{
			if ("over".equals(line))
			{
				break;
			}
			out.write(line.toUpperCase());
			//out.flush();ˢ���ǻ��������еķ�����
		}
		out.close();
		bufr.close();
	}
}
