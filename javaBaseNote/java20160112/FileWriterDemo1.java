/*
|--java.lang.Object:
	|--java.io.Writer�����ࣺ
		|--java.io.OutpuWriterʵ����:
			|--java.io.FileWriterʵ����:
Writer�����ࣺ
			���캯����
					protected  Writer()��
							����һ���µ��ַ��� writer����ؼ����ֽ�ͬ�� writer ����
					protected  Writer(Object lock)��
							����һ���µ��ַ��� writer����ؼ����ֽ�ͬ�������Ķ���
			Writer append(char c)��
					��ָ���ַ���ӵ��� writer��
			Writer append(CharSequence csq)��
					��ָ���ַ�������ӵ��� writer��
			Writer append(CharSequence csq, int start, int end)��
					��ָ���ַ����е���������ӵ��� writer.Appendable��
			abstract  void close()��
					�رմ�������Ҫ��ˢ������
			abstract  void flush();
					ˢ�¸����Ļ��塣
			void write(char[] cbuf);
					д���ַ������ĳһ���֡�
			void write(String str, int off, int len);
					д���ַ�����ĳһ���֡�
	OutpuWriterʵ����:
			���캯����
					OutputStreamWriter(OutputStream out);
							����ʹ��Ĭ���ַ������ OutputStreamWriter��
					OutputStreamWriter(OutputStream out, Charset cs);
							����ʹ�ø����ַ����� OutputStreamWriter��
					OutputStreamWriter(OutputStream out, CharsetEncoder enc);
							����ʹ�ø����ַ����������� OutputStreamWriter��
					OutputStreamWriter(OutputStream out, String charsetName);
							����ʹ��ָ���ַ����� OutputStreamWriter��
			void close();
					�رմ�������Ҫ��ˢ������
			void flush();
					ˢ�¸����Ļ��塣
			String getEncoding();
					���ش���ʹ�õ��ַ���������ơ�
			void write(char[] cbuf, int off, int len);
					д���ַ������ĳһ���֡�
			void write(String str, int off, int len);
					д���ַ�����ĳһ���֡�
	FileWriterʵ����:
			���캯����
					FileWriter(File file);
							���ݸ����� File ������һ�� FileWriter ����
					FileWriter(File file, boolean append);
							���ݸ����� File ������һ�� FileWriter ����
					FileWriter(FileDescriptor fd);
							������ĳ���ļ�������������� FileWriter ����
					FileWriter(String fileName);
							���ݸ������ļ�������һ�� FileWriter ����
					FileWriter(String fileName, boolean append);
							���ݸ������ļ����Լ�ָʾ�Ƿ񸽼�д�����ݵ� boolean ֵ������ FileWriter ����
*/
import java.io.*;
class  FileWriterDemo1
{
	public static void main(String[] args) 
	{
		//����һ��FileWriter���󣬸ö���һ����ʼ���ͱ���Ҫ��ȷ���������ļ���
		//���Ҹ��ļ��ᱻ������ָ��Ŀ¼�£������Ŀ¼����ͬ���ļ����򸲸�ԭ�ļ���
		//��ʵ�ò���������ȷ����Ҫ��ŵ�Ŀ�ĵء�
		FileWriter fw = new FileWriter("d:\\java\\java20160112 Demo.txt");
		
		fw.write("java001");
		fw.flush();
		//ˢ���������еĻ����е����ݣ�
		//������ˢ��Ŀ�ĵ��С�

		fw.write("+java002");
		fw.flush();

		//�ر�����Դ�����ǹر�֮ǰ��ˢ��һ���ڲ��Ļ����е����ݡ�
		//������ˢ��Ŀ�ĵ��С�
		//��flush������flushˢ�º������Լ���ʹ�ã�closeˢ�º󣬻ή���رա�

		fw.close();
		fw.write("+java002+java003");
	}
}
