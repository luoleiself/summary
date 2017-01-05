/*
CharArrayReader
CharArrayWriter

StringReader
StringWriter

CharArrayReader:����ʵ��һ���������ַ����������ַ���������
		���췽��: 
			CharArrayReader(char[] buf); 
				����ָ���� char ���鴴��һ�� CharArrayReader�� 
			CharArrayReader(char[] buf, int offset, int length); 
				����ָ���� char ���鴴��һ�� CharArrayReader�� 
		����ժҪ: 
			void close();
				�رո������ͷ���֮����������ϵͳ��Դ�� 
			void mark(int readAheadLimit); 
				������еĵ�ǰλ�á� 
			boolean markSupported(); 
				�жϴ����Ƿ�֧�� mark() ��������һ��֧�֣��� 
			int read(); 
				��ȡ�����ַ��� 
			int read(char[] b, int off, int len); 
				���ַ����������ĳһ���֡� 
			boolean ready(); 
				�жϴ����Ƿ���׼���ñ���ȡ�� 
			void reset(); 
				����������Ϊ���µı�ǣ������δ��ǹ����������õ���ͷ�� 
			long skip(long n); 
				�����ַ��� 

CharArrayWriter:
		����ʵ��һ�������� Writer ���ַ�������������������������д�����ݶ��Զ���������ʹ�� toCharArray() �� toString() ��ȡ���ݡ� 
		ע���ڴ����ϵ��� close() ��Ч�������ڹرո�������Ե��ô����еĸ�������������������κ� IOException��
		���췽��:
			CharArrayWriter(); 
				����һ���µ� CharArrayWriter�� 
			CharArrayWriter(int initialSize); 
				����һ������ָ����ʼ��С���� CharArrayWriter�� 
		����ժҪ: 
			CharArrayWriter append(char c); 
				��ָ���ַ���ӵ��� writer�� 
			CharArrayWriter append(CharSequence csq); 
				��ָ�����ַ�������ӵ��� writer�� 
			CharArrayWriter append(CharSequence csq, int start, int end); 
				��ָ���ַ����е���������ӵ��� writer�� 
			void close(); 
				�رո����� 
			void flush(); 
				ˢ�¸����Ļ��塣 
			void reset(); 
				���øû��������Ա��ٴ�ʹ���������趪���ѷ���Ļ������� 
			int size(); 
				���ػ������ĵ�ǰ��С�� 
			char[] toCharArray(); 
				�����������ݵĸ����� 
			String toString(); 
				����������ת��Ϊ�ַ����� 
			void write(char[] c, int off, int len); 
				���ַ�д�뻺������ 
			void write(int c); 
				��һ���ַ�д�뻺������ 
			void write(String str, int off, int len); 
				�ַ�����ĳһ����д�뻺������ 
			void writeTo(Writer out); 
				��������������д����һ���ַ����� 

StringReader:��ԴΪһ���ַ������ַ�����
		���췽��: 
			StringReader(String s); 
				����һ�����ַ��� reader�� 
		����ժҪ: 
			void close(); 
				�رո������ͷ���֮����������ϵͳ��Դ�� 
			void mark(int readAheadLimit); 
				������еĵ�ǰλ�á� 
			boolean markSupported(); 
				�жϴ����Ƿ�֧�� mark() �����Լ�֧����һ������� 
			int read(); 
				��ȡ�����ַ��� 
			int read(char[] cbuf, int off, int len); 
				���ַ����������ĳһ���֡� 
			boolean ready(); 
				�жϴ����Ƿ��Ѿ�׼�������ڶ�ȡ�� 
			void reset(); 
				����������Ϊ���µı�ǣ������δ��ǹ����������õ����ַ����Ŀ�ͷ�� 
			long skip(long ns); 
				��������ָ���������ַ��� 
	
StringWriter:
		һ���ַ�������������������ַ����������е�����������ַ����� 
		�ر� StringWriter ��Ч�������еķ����ڹرո������Կɱ����ã�����������κ� IOException��
		���췽��: 
			StringWriter(); 
				ʹ��Ĭ�ϳ�ʼ�ַ�����������С����һ�����ַ��� writer�� 
			StringWriter(int initialSize); 
				ʹ��ָ����ʼ�ַ�����������С����һ�����ַ��� writer�� 
		����ժҪ: 
			StringWriter append(char c); 
				��ָ���ַ���ӵ��� writer�� 
			StringWriter append(CharSequence csq); 
				��ָ�����ַ�������ӵ��� writer�� 
			StringWriter append(CharSequence csq, int start, int end); 
				��ָ���ַ����е���������ӵ��� writer�� 
			void close(); 
				�ر� StringWriter ��Ч�� 
			void flush(); 
				ˢ�¸����Ļ��塣 
			StringBuffer getBuffer(); 
				���ظ��ַ������������� 
			String toString(); 
				���ַ�������ʽ���ظû������ĵ�ǰֵ�� 
			void write(char[] cbuf, int off, int len); 
				д���ַ������ĳһ���֡� 
			void write(int c); 
				д�뵥���ַ��� 
			void write(String str); 
				д��һ���ַ����� 
			void write(String str, int off, int len); 
				д���ַ�����ĳһ���֡� 
*/
import java.io.*;
class  CharArrayStringReaderWriterDemo1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
