/*
��ϰ�ģ���ȡ�����ַ����������ͬ�Ӵ�����һ�����������̵��Ǹ������г���һ�εݼ����Ӵ���ӡ��
˼·��
	1������һ����������Ҫ����ֵ����Ϊ�ַ������ͣ���δ֪�����ݲ������㣬�����б���������ʽ������
	2����ȡ�����Ӵ��е���ͬ�Ӵ������õ����ַ������еķ���contains()�ж��ַ������Ƿ����ĳһ���Ӵ���
	3����ȡ��ͬ�Ӵ����Դ��Ӵ�����󳤶ȿ�ʼ�Ƚϣ�����˳��������Ч�ʣ�
		�����ͷ��ʼ�Ƚϣ������������ѡ�������ð������Ļ�������ʹ��������Ч�ʱ�����
	4�������Ӵ���ͷ�Ǳ��β�Ǳ���Զ�ȡ�Ƚϣ���β�Ǳ�����һλ��ȡ�Ƚϲ�����ʱ��
		������Ҫע��һ������ ������ж�������ַ����ĳ������⡣
		ͷ�Ǳ��β�Ǳ�ͬʱ��һ��ȡ�Ƚϡ�
	5������ʹ��˫��ѭ����䣬��ѭ������ѭ����������ѭ�����ƶ�ȡ���Ӵ����ȡ�
*/
class  StringTest3
{
	public static void main(String[] args) 
	{
		String str1 = "abcwerthelloyuiodef";
		String str2 = "cvhellobnm";
		
		stringPrint(getMaxSubString(str1,str2));
	}
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static String getMaxSubString(String str1,String str2)
	{
		String max="",min="";//��Ϊ���������ַ������Ȳ�ȷ���������������ַ������ڴ洢���ݵ��ַ�����
		max = (str1.length()>str2.length())?str1:str2;//�ж���佫���ȳ����ַ�����ֵ�����ַ���max.
		min = (max==str1)?str2:str1;//�ж����max�ǳ����ַ���ʱ����ô�ͽ��̵��ַ�����ֵ��min��
		
		for (int x=0;x<min.length();x++)
		{
			//z=min.length()-x;����Ϊ�Ǳ�ֵ����xѭ��һ�κ�Ϊ�Ǳ�ֵ���Ϊ�ַ������ȼ�ȥx��
			//z!=min.length()+1;Ϊ�˷�ֹΪ�Ǳ�ֵԽ�硣
			//y++,z++;β�Ǳ��һ֮���ȡ�ַ����Ƚϣ���������㣬���׽Ǳ��β�Ǳ�ͬʱ��һ��ȡ�ַ����Ƚϡ�
			for (int y=0,z=min.length()-x;z!=min.length()+1;y++,z++)
			{
				String temp = min.substring(y,z);
				if (max.contains(temp))//ʹ��contains()�����ж��ַ������Ƿ����ĳһ���Ӵ���
				{
					return temp;
				}
			}
		}
		return "";
	}
}
