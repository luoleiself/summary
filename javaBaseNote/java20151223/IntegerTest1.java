/*
JDK1.5�汾�Ժ���ֵ������ԣ�
	����֪ʶ�㣺
		Integer m = 128;
		Integer n = 128;
		stringPrint("m==n:"+(m==n));//���Ϊfalse��

		Integer a = 127;
		Integer b = 127;
		stringPrint("a==b:"+(a==b));//���Ϊtrue����Ϊa��bָ����ͬһ��Integer����
									//��Ϊ����ֵ��byte��Χ���У����������ԣ��������ֵ�Ѿ����ڣ��򲻻Ὺ�ٵ��µĿռ䡣
*/
class  IntegerTest1
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void method()
	{
		Integer x = new Integer("123");

		Integer y = new Integer(123);

		stringPrint("x==y:"+(x==y));//����false���Ƚ�������ֵ��
		stringPrint("x.equals(y):"+x.equals(y));//����true������Ƚϵ�����������
	}
	public static void main(String[] args) 
	{
		Integer x = new Integer(4);
		Integer x = 4;//�Զ�װ��;Integer x = new Integer(4);

		x = x + 2;//x �������Զ����䣬�����int���ͣ���2���мӷ����㣬Ȼ���ٽ��ͽ���װ�丳��x��
		//x = x.intValue() + 2;
		
		Integer m = 128;
		Integer n = 128;
		stringPrint("m==n:"+(m==n));//���Ϊfalse��

		Integer a = 127;
		Integer b = 127;
		stringPrint("a==b:"+(a==b));//���Ϊtrue����Ϊa��bָ����ͬһ��Integer����
									//��Ϊ����ֵ��byte��Χ���У����������ԣ��������ֵ�Ѿ����ڣ��򲻻Ὺ�ٵ��µĿռ䡣
	}
}
