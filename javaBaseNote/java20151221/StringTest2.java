/*
��ϰ������ȡһ���ַ�������һ���ַ����г��ֵĴ�����
˼·��
	1������һ����������
	2����ȡ�Զ����ַ���һ�γ��ֵ�λ�á�
	3���ӵ�һ�γ���λ�ú�ʣ����ַ����м�����ȡ�Զ����ַ����ֵ�λ�á�
		ÿ��ȡһ�ξͼ���һ�Ρ�
	4������ȡ����ʱ��������ɡ�
*/
class StringTest2 
{
	public static void main(String[] args) 
	{
		String str = "abkkcdkkefkkskk";

		stringPrint("count="+getSubCount_1(str,"kk"));

		System.out.println("===============================================");
		
		stringPrint("count="+getSubCount_2(str,"kk"));
	}
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	//��ϰ������һ�ַ�ʽ��
	public static int getSubCount_1(String str,String key)
	{
		int count = 0;
		int index = 0;
		while ((index=str.indexOf(key))!=-1)//�ж�Ҫ���ҵ��ַ����ĽǱ�ֵ�Ƿ�Ϊ����
		{
			stringPrint("str="+str);
			str = str.substring(index+key.length());
			//�Ӳ��ҵ�λ�õ��ַ����ĽǱ꿪ʼ��ȡ���ַ���β��ÿ����һ�Σ��ַ������ȼ���index+key.length()�Ρ�
			
			count++;
		}
		return count;
	}
	//��ϰ�����ڶ��ַ�ʽ��
	public static int getSubCount_2(String str,String key)
	{
		int count = 0;
		int index = 0;
		while ((index=str.indexOf(key,index))!= -1)//indexOf�����Ĳ�����ͬ��ʹ�÷�ʽҲ��ͬ��
		{
			stringPrint("index="+index);
			index = index + key.length();
			
			count++;
		}
		return count;
	}
}
//������ʹ���и�(split)�ķ�ʽ���д�������ַ����е���ʼλ��key�Ļ���ʹ���и�ķ�ʽ���ײ������ַ�����
