/*
�����������Ͷ����װ�ࡣ

	 ��������		����
		byte		Byte 
		short		Short
		int			Integer
		boolean		Boolean
		float		Float
		double		Double
		char		Character

�����������Ͷ����װ���������ã��������ڻ����������ͺ��ַ�������֮����ת����
	1��������������ת�����ַ�����
			1,������������+"";
			2,������������.toString(������������ֵ);
					ʾ����Integer.toString(34);��34��������ת�����ַ���"34";
	
	2���ַ���ת���ɻ����������ͣ�
			1����̬�������÷�ʽ��
			   xxx a = Xxx.parseXxx(String str);
			   int a = Integer.parseInt("123");
			   long a = Long.parseLong("123");
			   double a = Double.parseDouble("12.23");
			   boolean a = Boolean.parseBoolean("true");
			2��������÷�ʽ��
					Integer i = new Integer("123");
					int num = i.intValue();

	3��ʮ����ת�����������ƣ�
				toBinaryString();
				toHexString();
				toOctalString();

	4����������ת����ʮ���ƣ�
				parseInt(String str,int radix);
					ʾ����int x = Integer.parseInt("3c",16);��3cת����ʮ�������������͡�

*/
class  IntToHexToOctDemo1
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		//�������͵���ֵ��
		stringPrint("int max:"+Integer.MAX_VALUE);//�������͵����ֵ;MAX_VALUEΪ�ֶ�����;
		stringPrint("int max:"+Integer.MIN_VALUE);//�������͵���Сֵ;MIN_VALUEΪ�ֶ�����;

		//��һ���ַ���ת����������
		int in = Integer.parseInt("123");
		long lon = Long.parseLong("123");
		float floa = Float.parseFloat("123.123");
		double doubl = Double.parseDouble("123123.123123");
		stringPrint("in="+in);
		stringPrint("lon="+lon);
		stringPrint("floa="+lon);
		stringPrint("doubl="+doubl);

		//ʮ����ת�����������ƣ�
		stringPrint(Integer.toBinaryString(100));
		stringPrint(Integer.toHexString(100));
		stringPrint(Integer.toOctalString(100));
		
		//��������ת����ʮ���ƣ�
		int in1 = Integer.parseInt("110",2);
		int in2 = Integer.parseInt("F6c",16);
		int in3 = Integer.parseInt("107",8);
		stringPrint("in1="+in1);
		stringPrint("in2="+in2);
		stringPrint("in3="+in3);
	}
}
