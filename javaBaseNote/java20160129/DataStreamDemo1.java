/*
�����������������������͵����ݵ�������
DataInputStream:
		��������������Ӧ�ó�����������޹ط�ʽ�ӵײ��������ж�ȡ���� Java �������͡�
		Ӧ�ó������ʹ�����������д���Ժ���������������ȡ�����ݡ�
DataOutputStream:
		�������������Ӧ�ó������ʵ���ʽ������ Java ��������д��������С�
		Ȼ��Ӧ�ó������ʹ�����������������ݶ��롣

DataInputStream:
		���췽��: 
			DataInputStream(InputStream in); 
				ʹ��ָ���ĵײ� InputStream ����һ�� DataInputStream��
		һ�㷽����
			int readUnsignedByte(); 
				�μ� DataInput �� readUnsignedByte �����ĳ���Э���� 
			int readUnsignedShort(); 
				�μ� DataInput �� readUnsignedShort �����ĳ���Э���� 
			String readUTF(); 
				�μ� DataInput �� readUTF �����ĳ���Э���� 
			static String readUTF(DataInput in); 
				���� in �ж�ȡ�� UTF-8 �޸İ��ʽ����� Unicode �ַ���ʽ���ַ�����Ȼ���� String ��ʽ���ش��ַ����� 
			int skipBytes(int n); 
				�μ� DataInput �� skipBytes �����ĳ���Э����
			void readFully(byte[] b); 
				�μ� DataInput �� readFully �����ĳ���Э���� 
			void readFully(byte[] b, int off, int len); 
				�μ� DataInput �� readFully �����ĳ���Э���� 
			int readInt(); �����ǰ��ֻ����������ͣ�readShort();readLong();readBoolean();
				�μ� DataInput �� readInt �����ĳ���Э����
DataOutputStream:
		���췽��:
			DataOutputStream(OutputStream out); 
				����һ���µ������������������д��ָ�������������
		һ�㷽����
			void flush(); 
				��մ������������ 
			int size(); 
				���ؼ����� written �ĵ�ǰֵ������ĿǰΪֹд���������������ֽ�����
			void writeShort(int v); �����ǰ��ֻ����������ͣ�writeInt();writeBoolean();writeBytes();
				��һ�� short ֵ�� 2-byte ֵ��ʽд�����������У���д����ֽڡ� 
			void writeUTF(String str); 
				��������޹ط�ʽʹ�� UTF-8 �޸İ���뽫һ���ַ���д������������ 			
*/
import java.io.*;
class  DataStreamDemo1
{
	public static void main(String[] args)throws IOException 
	{
			
	}
	public static void readUTFDemo()throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("utfdata.txt"));
		
		String s = dis.readUTF();
		System.out.println("s:"+s);
		dis.close();
	}
	public static void writeUTFDemo()throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("utfdata.txt"));

		dos.writeUTF("���");
		dos.close();
	}
	public static void writeData()throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

		dos.writeInt(234);
		dos.writeBoolean(true);
		dos.writeDouble(98898.12345);

		dos.close();
	}
	public static void readData()throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		
		int num = dis.readInt();
		boolean boo = dis.readBoolean();
		double dou = dis.readDouble();

		System.out.println("num:"+num);
		System.out.println("boo:"+boo);
		System.out.println("dou:"+dou);

		dis.close();
	}
}

