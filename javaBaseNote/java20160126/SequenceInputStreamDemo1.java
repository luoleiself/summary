/*
|--java.lang.Object
	|--java.io.InputStream
		|--java.io.SequenceInputStream

��������SequenceInputStream
	SequenceInputStream ��ʾ�������������߼����������������������򼯺Ͽ�ʼ�����ӵ�һ����������ʼ��ȡ��
	ֱ�������ļ�ĩβ�����Ŵӵڶ�����������ȡ���������ƣ�ֱ��������������һ�����������ļ�ĩβΪֹ��	
	���캯����
	SequenceInputStream(Enumeration<? extends InputStream> e); 
          ͨ����ס��������ʼ���´����� SequenceInputStream���ò�����������������ʱ����Ϊ InputStream ����� Enumeration �Ͳ����� 
	SequenceInputStream(InputStream s1, InputStream s2); 
          ͨ����ס��������������ʼ���´����� SequenceInputStream������˳���ȡ�������������ȶ�ȡ s1��Ȼ���ȡ s2�������ṩ�Ӵ� SequenceInputStream ��ȡ���ֽڡ� 

*/
class  SequenceInputStreamDemo1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
