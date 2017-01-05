/*
equals������
			1������ǻ������ͱȽϣ���ôֻ����==���Ƚϣ�������equals��
			2�����ڻ������͵İ�װ���ͣ�����Boolean��Character��Byte��Shot��Integer��Long��Float��Double�ȵ����ñ�����
				==�ǱȽϵ�ַ�ģ���equals�ǱȽ����ݵġ�
			3��ע�⣺����String(�ַ���)��StringBuffer(�̰߳�ȫ�Ŀɱ��ַ�����)��StringBuilder(�ɱ��ַ�����)������������һ����˵��:
				1,String�У�==�Ƚϵ��ǵ�ֵַ��equals�����Ƚϵ������ݡ�
				2,StringBuffer��û�����¶���equals�������������������������Object�࣬��Object���е�equals�����������Ƚϡ���ַ���ġ�
				3,StringBuilder��û�����¶���equals�������������������������Object�࣬��Object���е�equals�����������Ƚϡ���ַ���ġ�
*/
class  EqualsDemo
{
	public static void main(String[] args) 
	{
		int a = 3; 
		int b = 4; 
		int c = 3; 
		System.out.println(a == b);		//�����false 
		System.out.println(a == c);		//�����true 
		System.out.println(a.equals(c));//���󣬱��벻��ͨ����equals��������������������͵ıȽ� 

		//=============================================================

		Integer n1 = new Integer(30); 
		Integer n2 = new Integer(30); 
		Integer n3 = new Integer(31); 
		System.out.println(n1 == n2);//�����false,������ͬ��Integer���󣬹����ַ��ͬ�� 
		System.out.println(n1 == n3);//�����false,��ô������new Integer(30)����new Integer(31) �������ʾfalse 
		System.out.println(n1.equals(n2));//�����true ����jdk�ĵ��е�˵����n1��n2ָ��Ķ����е���������ȵģ�����30����equals�ȽϺ�����true 
		System.out.println(n1.equals(n3));//�����false ��������ݲ�һ����һ����30һ����31��

		//===============================================================

		String s1 = "123"; 
		String s2 = "123"; 
		String s3 = "abc"; 
		String s4 = new String("123"); 
		String s5 = new String("123"); 
		String s6 = new String("abc"); 

		System.out.println(s1 == s2);		//��1��true 
		System.out.println(s1.equals(s2));	//��2��true 
		System.out.println(s1 == s3);		//��3��flase 
		System.out.println(s1.equals(s3));	//��4��flase 

		System.out.println(s4 == s5);		//��5��flase 
		System.out.println(s4.equals(s5));	//��6��true 
		System.out.println(s4 == s6);		//��7��flase 
		System.out.println(s4.equals(s6));	//��8��flase 

		System.out.println(s1 == s4);		//��9��false 
		System.out.println(s1.equals(s4));	//��10��true 
	}
}
