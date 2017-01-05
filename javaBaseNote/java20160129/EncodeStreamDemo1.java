/*
ASCII:������׼��Ϣ�����롣
		��һ���ֽڵ�7λ���Ա�ʾ��
ISO8859-1:�������ŷ�����
		��һ���ֽڵ�8λ��ʾ��
GB2312:�й������ı����
GBK���й������ı����
Unicode:���ʱ�׼�룬�ں��˶������֡�
		�������ֶ��������ֽ�����ʾ��java����ʹ�õľ���Unicode��
UTF-8:����������ֽ�����ʾһ���ַ���

���룺�ַ�������ֽ����顣

���룺�ֽ��������ַ�����

String-->byte[]; String.getBytes();

byte[]-->String; new String(byte[],charsetName);

*/
import java.io.*;
class  EncodeStreamDemo1
{
	public static void main(String[] args) 
	{
		
	}
	public static void readText()throws IOException
	{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"GBK");

		char[] cha = new char[10];

		int len = isr.read(cha);
		String str = new String(cha,0,len);
		
		System.out.println("str:"+str);
		isr.close();
	}
	public static void writeText()throws IOException
	{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"GBK");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"),"UTF-8");
		
		osw.write("���");
		osw.close();
	}
	public static void charsetName()throws IOException
	{
		String s = "���";

		byte[] byt = s.getBytes("GBK");

		System.out.println(Arrays.toString(byt));
	
		String str = new String(byt,"ISO8859-1");
		System.out.println("str:"+str);
		
		//��str����iso8859-1���롣
		byte[] byt1 = s.getBytes("ISO8859-1");
		System.out.println(Arrays.toString(byt1));

		String str1 = new String(byt1,"GBK");
		System.out.println("str1:"+str1);
	}
}
