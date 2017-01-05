/*
ByteArrayInputStream:
	�ڹ����ʱ����Ҫ��������Դ����������Դ��һ���ֽ����顣
ByteArrayOutputStream��
	�ڹ����ʱ�򣬲��ö�������Ŀ�ģ���Ϊ�ö����Ѿ��ڲ���װ�˿ɱ䳤�ȵ��ֽ����顣
	��Ϊ�����������󶼲��������ֽ����飬��û��ʹ��ϵͳ��Դ�����Բ��ý���close�رա�

�ر� ByteArrayOutputStream ��Ч�������еķ����ڹرմ������Կɱ����ã�����������κ� IOException��

�����������ɽ���ʱ��
		Դ�豸��
			���̣�System.in, Ӳ�̣�FileStream, �ڴ棺ArrayStream,
		Ŀ���豸��
			����̨��System.out, Ӳ�̣�FileStream, �ڴ棺ArrayStream,
�����Ķ�д˼�����������顣

ByteArrayInputStream:
		����һ���ڲ����������û��������������ж�ȡ���ֽڡ��ڲ����������� read ����Ҫ�ṩ����һ���ֽڡ�
		�ر� ByteArrayInputStream ��Ч�������еķ����ڹرմ������Կɱ����ã�����������κ� IOException��

		���췽��:
			ByteArrayInputStream(byte[] buf); 
				����һ�� ByteArrayInputStream��ʹ�� buf ��Ϊ�仺�������顣 
			ByteArrayInputStream(byte[] buf, int offset, int length); 
				���� ByteArrayInputStream��ʹ�� buf ��Ϊ�仺�������顣 
		һ�㷽��: 
			int available(); 
				���ؿɴӴ���������ȡ������������ʣ���ֽ����� 
			void close(); 
				�ر� ByteArrayInputStream ��Ч�� 
			void mark(int readAheadLimit); 
				�������еĵ�ǰ���λ�á� 
			boolean markSupported(); 
				���Դ� InputStream �Ƿ�֧�� mark/reset�� 
			int read(); 
				�Ӵ��������ж�ȡ��һ�������ֽڡ� 
			int read(byte[] b, int off, int len); 
				����� len �������ֽڴӴ����������� byte ���顣 
			void reset(); 
				����������λ������Ϊ���λ�á� 
			long skip(long n); 
				�Ӵ������������� n �������ֽڡ� 

ByteArrayOutputStream:
		����ʵ����һ������������е����ݱ�д��һ�� byte ���顣���������������ݵĲ���д����Զ���������ʹ�� toByteArray() �� toString() ��ȡ���ݡ� 
		�ر� ByteArrayOutputStream ��Ч�������еķ����ڹرմ������Կɱ����ã�����������κ� IOException��

		���췽��: 
			ByteArrayOutputStream();
				����һ���µ� byte ����������� 
			ByteArrayOutputStream(int size); 
				����һ���µ� byte �����������������ָ����С�Ļ��������������ֽ�Ϊ��λ����
		һ�㷽��: 
			void close(); 
				�ر� ByteArrayOutputStream ��Ч�� 
			void reset(); 
				���� byte ����������� count �ֶ�����Ϊ�㣬�Ӷ������������Ŀǰ���ۻ������������ 
			int size(); 
				���ػ������ĵ�ǰ��С�� 
			byte[] toByteArray(); 
				����һ���·���� byte ���顣 
			String toString(); 
				ʹ��ƽ̨Ĭ�ϵ��ַ�����ͨ�������ֽڽ�����������ת��Ϊ�ַ����� 
			String toString(String charsetName); 
				ʹ��ָ���� charsetName��ͨ�������ֽڽ�����������ת��Ϊ�ַ����� 
			void write(byte[] b, int off, int len); 
				��ָ�� byte �����д�ƫ���� off ��ʼ�� len ���ֽ�д��� byte ����������� 
			void write(int b); 
				��ָ�����ֽ�д��� byte ����������� 
			void writeTo(OutputStream out); 
				���� byte �����������ȫ������д�뵽ָ��������������У�����ʹ�� out.write(buf, 0, count) ���ø�������� write ����Ч��һ���� 
*/
import java.io.*;
class  ByteArrayStreamDemo1
{
	public static void main(String[] args) 
	{
		
	}
	public static void readStream()
	{
		//����Դ
		ByteArrayInputStream bais = new ByteArrayInputStream("abcde".getBytes());
		
		//����Ŀ��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int by = 0;
		while ((by = bais.read())!=-1)
		{
			baos.write(by);
		}
		System.out.println(baos.size());
		System.out.println(baos.toString());
	}
}
