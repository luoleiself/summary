/*
���಻����IO��ϵ�е����࣬���Ǽ̳���Object��
��������IO���еĳ�Ա����Ϊ���߱�����д�Ĺ��ܣ��ڲ���װ��һ�����飬����ͨ��ָ���������в�����
����ͨ��geiFilePointer��ȡָ��λ�ã�ͬʱ����ͨ��seek�ı�ָ���λ�á�

��ʵ��ɶ�д��ԭ������ڲ���װ���ֽ����������ֽ��������

ͨ�����캯�����Կ���������ֻ�ܲ����ļ������Ҳ����ļ�����ģʽ��r,w,rw,
���ģʽΪֻ�������ᴴ���ļ�����ȥ��ȡһ���Ѵ��ڵ��ļ���������ļ������ڣ��������쳣��
���ģʽΪ��д�������ļ������ڣ����Զ���������������򲻻Ḳ�ǡ�

RandomAccessFile
		���췽����
			RandomAccessFile(File file, String mode); mode������r,w,rw,rws,rwd,
				�������ж�ȡ��������д�루��ѡ������������ļ��������ļ��� File ����ָ���� 
			RandomAccessFile(String name, String mode); mode������r,w,rw,rws,rwd,
				�������ж�ȡ��������д�루��ѡ������������ļ��������ļ�����ָ�����ơ�
		����ժҪ�� 
			void close(); 
				�رմ���������ļ������ͷ����������������ϵͳ��Դ�� 
			FileChannel getChannel(); 
				��������ļ�������Ψһ FileChannel ���� 
			FileDescriptor getFD(); 
				��������������Ĳ�͸���ļ����������� 
			long getFilePointer(); 
				���ش��ļ��еĵ�ǰƫ������ 
			long length(); 
				���ش��ļ��ĳ��ȡ�
			int read(); 
				�Ӵ��ļ��ж�ȡһ�������ֽڡ�
			boolean readBoolean();�����ǰ��ֻ����������ͣ�readInt();readChar(); 
				�Ӵ��ļ���ȡһ�� boolean��
			void readFully(byte[] b); 
				�� b.length ���ֽڴӴ��ļ����� byte ���飬���ӵ�ǰ�ļ�ָ�뿪ʼ�� 
			void readFully(byte[] b, int off, int len); 
				������ len ���ֽڴӴ��ļ����� byte ���飬���ӵ�ǰ�ļ�ָ�뿪ʼ��
			String readLine(); 
				�Ӵ��ļ���ȡ�ı�����һ�С�
			int readUnsignedByte(); 
				�Ӵ��ļ���ȡһ���޷��ŵİ�λ���� 
			int readUnsignedShort(); 
				�Ӵ��ļ���ȡһ���޷��ŵ� 16 λ����
			String readUTF(); 
				�Ӵ��ļ���ȡһ���ַ����� 
			void seek(long pos); 
				���õ����ļ���ͷ���������ļ�ָ��ƫ�������ڸ�λ�÷�����һ����ȡ��д�������
			void setLength(long newLength); 
				���ô��ļ��ĳ��ȡ� 
			int skipBytes(int n); 
				������������� n ���ֽ��Զ����������ֽڡ�
			void write(byte[] b); 
				�� b.length ���ֽڴ�ָ�� byte ����д�뵽���ļ������ӵ�ǰ�ļ�ָ�뿪ʼ�� 
			void write(byte[] b, int off, int len); 
				�� len ���ֽڴ�ָ�� byte ����д�뵽���ļ�������ƫ���� off ����ʼ�� 
			void write(int b); 
				����ļ�д��ָ�����ֽڡ�
			void writeBoolean(boolean v); �����ǰ��ֻ����������ͣ�writeInt();writeChar();
				�����ֽ�ֵ�� boolean д����ļ���
			void writeUTF(String str); 
				ʹ�� modified UTF-8 ������������޹صķ�ʽ��һ���ַ���д����ļ��� 
*/
import java.io.*;
class  RandomAccessFileDemo1
{
	public static void main(String[] args)throws IOException 
	{
		writeFile();
	}
	public static void readFile()throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","r");
		
		//���������е�ָ�룬
		raf.seek(8);//����ȡ���������Ϣ��
		
		//����ָ�����ֽ�����
		raf.skipBytes(8);

		byte[] buf = new byte[4];
		raf.read(buf);

		String name = new String(buf);
		int age = raf.readInt();
		System.out.println("name=:"+name);
		System.out.println("age=:"+age);

		raf.close();
	}
	public static void writeFile_2()throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		
		raf.seek(8*3);//������ָ����λ����д���ݡ�
		raf.write("����".getBytes());
		raf.write(103);
		raf.close();
	}
	public static void writeFile()throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");

		raf.write("����".getBytes());
		raf.write(97);
		//raf.writeInt(258);

		raf.write("����".getBytes());
		raf.write(99);

		raf.close();
	}
}
