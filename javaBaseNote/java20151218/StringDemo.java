/*
�ַ����� public static final String �ַ�����Ϊ�����࣬���ܱ��̳У��ַ������еķ������ܱ���д��
		String s = new String();
		String s1 = "";

�ص㣺1���ַ�����Ϊ�����࣬���ܱ��̳У����еķ������ܱ���д��
	  2���ַ���һ����ʼ���Ͳ����Ա��ı䡣
	  3���ַ������Լ����жϷ���equals������String����д��Object����equals������
	  4��s1��s2������s1�����ڴ�����һ������s2�����ڴ�������������
*/
class  StringDemo
{
	public static void main(String[] args) 
	{
		String s1 = "abc";//s1��һ�������ͱ�����"abc"��һ������
						//�ַ�������ص㣺һ������ʼ���Ͳ����Ա��ı䡣
		String s2 = new String("abc");
		//����
		//s1���ڴ�����һ������
		//s2���ڴ�������������

		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));//String����д��Object����equals������
	}
}
