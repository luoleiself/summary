/*
String�������������ַ��������ô�����ṩ�˶���������ַ������в�����
�����Ĳ�����
		1����ȡ��
			1.1���ַ����а������ַ�����Ҳ�����ַ����ĳ��ȡ�
					int length()����ȡ�ַ����ĳ��ȡ�	
			1.2������λ�û�ȡλ���ϵ�ĳ���ַ���
					char charAt(int index):���ص����ַ�������Ϊ�������ݡ�		
			1.3�������ַ���ȡ���ַ����ַ����е�λ�á�
					int indexOf(int ch):���ص���ch���ַ����е�һ�γ��ֵ�λ�á�
					int indexOf(int ch, int fromIndex):��fromIndexָ��λ�ÿ�ʼ����ȡch���ַ����г��ֵ�λ�á�
					ʾ����
					int indexOf(String str):���ص������ַ����ַ����е�һ�γ��ֵ�λ�á�
					int indexOf(String str, int fromIndex):��fromIndexָ��λ�ÿ�ʼ����ȡ���ַ����ַ����г��ֵ�λ�á�
			1.4�������ַ���ȡ���ַ����ַ����е�λ�á�
					int lastIndexOf(int ch);
							����ָ���ַ��ڴ��ַ��������һ�γ��ִ���������	
					int lastIndexOf(int ch,int fromIndex);
							����ָ���ַ��ڴ��ַ��������һ�γ��ִ�����������ָ������������ʼ���з���������
					int lastIndexOf(String str);
							����ָ�����ַ����ڴ��ַ��������ұ߳��ִ���������
					int lastIndexOf(String str,int fromIndex);
							����ָ�����ַ����ڴ��ַ��������һ�γ��ִ�����������ָ����������ʼ����������
		2���жϣ�
			2.1���ַ������Ƿ����ĳһ���Ӵ���
					boolean contains(CharSequence s);���ҽ������ַ�������ָ���� char ֵ����ʱ������ true��
					����֮����indexOf(str):��������str��һ�γ���λ�ã��������-1����ʾ��str�����ַ����д��ڡ�
							���ԣ�Ҳ�������ڶ�ָ���ж��Ƿ���������Ҹ÷����ȿ����жϣ��ֿ��Ի�ȡ���ֵ�λ�á�
			2.2���ַ������Ƿ������ݡ�
					boolean isEmpty();ԭ������жϳ����Ƿ�Ϊ0��"" null
			2.3���ַ����Ƿ���ָ�����ݿ�ͷ��
					boolean startsWith(str);
			2.4���ַ����Ƿ���ָ�����ݽ�β��
					boolean endsWith(str);
			2.5���ж������Ƿ���ͬ�������Դ�Сд��
					boolean equalsIgnoreCase();
			2.6���ж������ַ����Ĵ�С���������ִ�Сд��
					boolean equalsToIgnoreCase(String str);���ֵ�˳��Ƚ������ַ����������Ǵ�Сд��
		3��ת����
			3.1�����ַ�����ת�����ַ�����
					���캯����String(char[]);
							  String(char[],int offset,int count);���ַ������е�һ�����ַ�ת�����ַ�����				
					��̬������
							  static String copyValueOf(char[]);
							  static String copyValueOf(char[] data,int offset, int count);
							  static String valueOf(char[]);
			3.2�����ַ���ת�����ַ����顣
					char[] toCharArray();
			3.3�����ֽ�����ת�����ַ�����
					String(byte[]);
					String(byte[],int offset,int count);			
			3.4�����ַ���ת�����ֽ����顣
					byte[] getBytes();
			3.5����������������ת�����ַ�����
					static	String valueOf(int);
					static	String valueOf(double);
					//3+"";//String.valueOf(3);
			���⣺�ַ������ֽ�������ת�������У��ǿ���ָ�������ġ�
		4���滻��
					String replace(char oldChar,char newChar);//���Ҫ�滻���ַ������ڣ����صĻ���ԭ����
		5���и
					String [] split(regex);//��Ŀ���ַ����ָ�ɶ���ַ�����ʾ����String [] arr = s.split(",");
		6����ȡ�Ӵ�����ȡ�ַ����е�һ���֡�
					String substring(gebin);
					String substring(gegin,end);//��ȡ�ַ���������ͷ������β��
		7��ת����ȥ���ո񣬱Ƚϣ�
			7.1�����ַ���ת���ɴ�д����Сд��
					String toUpperCase();
					String toLowerCase();
			7.2�����ַ������˵Ķ���ո�ȥ����
					String trim();
			7.3���������ַ���������Ȼ˳��ıȽϡ�
					int compareTo(string);//
*/
class  StringMethodTest1
{
	public static void method_compareTo()
	{
		String s1 = "abcdefg";
		String s2 = "abccefg";

		s1.compareTo(s2);//���s1λ��s2ǰ���򷵻ظ����������s1λ��s2�����򷵻��������������򷵻�0��
	}
	public static void method_to_trim()
	{
		String s = "   Hello  Java";
		
		s.toUpperCase();//��Сд�ַ�ת���ɴ�д��ʽ��

		s.toLowerCase();//��Сд�ַ�ת���ɴ�д��ʽ��

		s.trim();//���ַ�������ͷ�Ŀո�ȥ����
	}
	public static void metod_substring()
	{
		String s = "falsdjgjla";
		
		s.substring(2);

		s.substring(2,6);//��ȡ�ַ���������ͷ������β��
	}
	public static void main(String[] args) 
	{
		
		String  str = "asgfafgdcdgakgsgljg";
		//String str = new String("asgfafgdcdgakgsgljg");
		
		char [] arr = {'a','b','c','d','e','f','g'};

		str.length();//�����ַ����ĳ��ȣ�

		str.charAt(4);//�����ַ���str�нǱ�ֵΪ4���ַ���

		str.indexOf('g');//�����ַ�g�ڴ��ַ���str�������һ�γ��ִ���������

		str.indexOf('g',5);//���ַ���str�нǱ�ֵΪ5��ʼ��ȡG���ַ����г��ֵ�λ�á�

		str.lastIndexOf('g');//����ָ���ַ�'g'�ڴ��ַ���str�����һ�γ��ִ���������

		str.lastIndexOf('g',8);//����ָ���ַ�'g'�ڴ��ַ���str�����һ�γ��ִ�����������ָ���ĽǱ�ֵΪ8����ʼ���з���������

		str.startsWith("asg");//�ж��ַ���str���Ƿ���"asg"��ͷ��

		str.endsWith("ljg");//�ж��ַ���str���Ƿ���"ljg"��β��

		str.contains("gdcdg");//�ж��ַ�����str���Ƿ����"gdcdg"��

		str.toCharArray();//���ַ���ת�����ַ����顣
		
		str.getBytes();//���ַ���ת�����ֽ����顣
		
		arr.String()////���ַ�����ת�����ַ�����

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
