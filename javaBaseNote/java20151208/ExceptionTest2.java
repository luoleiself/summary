/*
1���쳣��Exception
	���ǳ���������ʱ���ֲ����������

�������װ�����ͽ��쳣��

�׳��쳣�����������
				1������һ���׳��Ѽ���쳣�ķ��������磺FileInputStream��������
				2���������й����з��ִ��󣬲�������throw����׳�һ���Ѽ���쳣��
				3��������ִ������磺a[-1]=0���׳�һ��ArrayIndexOutOfBoundsException�����Ķ�δ����쳣��
				4��java�����������ʱ����ֵ��ڲ��쳣��

ԭ��
	����Ҳ����ʵ������һ����������Ҳ����ͨ��java�������ʽ��������������װ�ɶ���
	��ʵ����java�Բ������������������Ķ������֡�

��������Ļ��֣�
			һ�����ص����⣬
			���������ص����⡣

�������صģ�javaͨ��Error�����������
		����Errorһ�㲻��д����ԵĴ�����䴦����

���ڷ����صģ�javaͨ��Exception�����������
		����Exception����ʹ������ԵĴ�����ʽ���д�����

����Error����Exception������һЩ�������ݡ�
���磺�������������Ϣ������ԭ��ȡ�

���ϳ�ȡ��Throwable
					|--Error
					|--Exception

2���쳣�Ĵ�����
	java�ṩ�����е������д�����

try
{
	��Ҫ�����Ĵ���;
}
catch(�쳣�� ����)
{
	�����쳣�Ĵ���;(������ʽ)
}
finally
{
	һ����ִ�е����;
}

3���Բ��񵽵��쳣������г�������������
	getMessage();���ش� throwable ����ϸ��Ϣ�ַ�����
	toString();	 ���ش� throwable �ļ��������
	printStackTrace();  ���� throwable ����׷�������ָ���� PrintWriter�����ڴ�ӡ������档

throws Exception//�ڹ�����ͨ��throws�Ĺؼ��������˸ù����п��ܻ�������⡣
*/
class Demo
{
	//����һ������ֵ����Ϊint���͵ķ�����
	public int div(int a,int b)throws Exception//�ڹ�����ͨ��throws�Ĺؼ��������˸ù����п��ܻ�������⡣
	{
		return a/b;
	}
}
class  ExceptionTest2
{
	public static void main(String[] args) //throws Exception�������׳����������������try����������ʽ��
	{
		Demo d = new Demo();
		try
		{
			int x = d.div(4,0);
			System.out.println("x="+x);
		}
		catch (Exception e)//Exception e = new ArithimeticException();��̬��
		{
			System.out.println("������");
			System.out.println(e.getMessage());//by zero
			System.out.println(e.toString());//�쳣���ƣ��쳣��Ϣ��
			
			e.printStackTrace();//�쳣���ƣ��쳣��Ϣ���쳣���ֵ�λ�á�
								//��ʵjvmĬ�ϵ��쳣�������ƣ������ٵ���printStackTrace������
								//��ӡ�쳣�Ķ�ջ�ĸ�����Ϣ��
		}
	}
}