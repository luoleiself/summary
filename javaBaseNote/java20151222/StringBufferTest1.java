/*
JDK�����������أ�
				1�����Ч�ʡ�
				2������д��
				3����߰�ȫ�ԡ�

�ڻ�jdk1.5�汾֮�������StringBuilder��
		
		���𣺶���һ���ɱ���ַ����С�
			StringBuffer���߳�ͬ�������ڵ��̳߳��򣬱�֤����İ�ȫ�ԡ�
			StringBuilder���̲߳�ͬ�������ڶ��̳߳��򣬲��ܱ�֤����İ�ȫ�ԡ�
		
�� StringBuilder ��ʵ�����ڶ���߳��ǲ���ȫ�ġ������Ҫ������ͬ��������ʹ�� StringBuffer��

������������sb.append(34).append(true).append(34);

StringBuffer�����ַ�������������һ����������final���Σ����ܱ��̳С�
		�ص㣺
			1�����ҳ����ǿɱ仯�ģ�
			2���������ɲ�������������͡�
			3�����ջ�ͨ��toString����ת�����ַ�����

CURD�� create  update  read  delete

StringBuffer���StringBuilder�಻�ܲ��������������ͣ�short,byte.

���췽����
		StringBuffer();
				����һ�����в����ַ����ַ�������������ʼ����Ϊ 16 ���ַ���
		StringBuffer(CharSequence seq);
				����һ���ַ�������������������ָ���� CharSequence ��ͬ���ַ���
		StringBuffer(int capacity);
				����һ�������ַ���������ָ����ʼ�������ַ�����������
		StringBuffer(String str);
				����һ���ַ��������������������ݳ�ʼ��Ϊָ�����ַ������ݡ�
		CURD�� create  update  read  delete
			
			1���洢��
				StringBuffer append();��ָ��������Ϊ������ӵ��������ݵĽ�β����
				StringBuffer insert(index,����);���Խ����ݲ���ָ��λ�á�
			2��ɾ����
				StringBuffer delete(int start,int end);ɾ���������е����ݣ�����strat������end��
				StringBuffer deleteCharAt(index);ɾ����������ָ��λ�õ��ַ���
			3����ȡ��
				int indexOf(String str):�������ַ����ַ����е�һ�γ��ֵ�λ�á�
				char charAt(int index):���ص����ַ�������Ϊ�������ݡ�
				int lastIndexOf(String str);����ָ�����ַ����ڴ��ַ��������ұ߳��ִ���������
				int length();
				String substring(gegin,end);//��ȡ�ַ���������ͷ������β��
			4���޸ġ�
				void setCharAt(int index, char ch);�滻��������ĳһλ�ַ���
				StringBuffer replace(int start, int end, String str);�滻�������е�ָ���ַ���������strat������end��
			5����ת��
				StringBuffer reverse();�����������ַ������з�ת;
			6�����������е�ָ�����ݴ洢��ָ���ַ������С�
				void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin);
				ʾ����
					StringBuffer sb = new StringBuffer("abcde");
					char [] arr = new char[6];
					sb.getChars(1,4,arr,2);//���ַ����Ǳ�ֵ1��ʼ��ȡ���Ǳ�ֵΪ3(������end)ֹͣ�����ַ�����Ǳ�ֵ2��ʼ�洢��arr�ַ������С�

*/
class  StringBufferTest1
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void main(String[] args)
	{
		
	}
	public static void method_getChar()
	{
		StringBuffer sb = new StringBuffer("abcde");
		char [] arr = new char[6];
		
		sb.getChars(1,4,arr,2);//���ַ����Ǳ�ֵ1��ʼ��ȡ���Ǳ�ֵΪ3(������end)ֹͣ�����ַ�����Ǳ�ֵ2��ʼ�洢��arr�ַ������С�

		System.out.println("arr["+x+"]"+arr[x]);
	}
	public static void method_add() 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("abcd");

		sb.append(34).append(true).append(34);//����������;

		stringPrint(sb);
	}
	public static void method_insert()
	{	
		StringBuffer sb = new StringBuffer("abcde");
		sb.insert(3,"ggg");//�ڽǱ�ֵΪ3λ�ò������ݡ�
		stringPrint(sb);
	}
	public static void method_del_deleteCharAt()
	{
		StringBuffer sb = new StringBuffer("abcde");

		sb.delete(1,3);//ɾ��sb���������ַ�bc;

		sb.delete(0,sb.length());//��ջ�����;

		sb.deleteCharAt(2);//ɾ��sb���������ַ�c;
		stringPrint(sb);
	}
	public static void method_setCharAt_replace()
	{
		StringBuffer sb = new StringBuffer("abcde");

		sb.replace(1,4,"ggg");//�滻�Ǳ�ֵ��1��ʼ��4����������4�����ݡ�

		sb.setCharAt(0,'g');//�滻�Ǳ�ֵΪ0�����ݡ�

		stringPrint(sb);
	}
}
