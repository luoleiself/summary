/*
�쳣�����า���е����֣�
		1�������ڸ��Ǹ���ʱ���������ķ����׳��쳣����ô����ĸ��Ƿ�����ֻ���׳�������쳣���߸��쳣�����ࡣ
		2��������෽���׳�����쳣����ô�����ڸ��Ǹ÷���ʱ��ֻ���׳������쳣���Ӽ���
		3�����������߽ӿڵķ�����û���쳣�׳�����ô�����ڸ��Ƿ���ʱ��Ҳ�������׳��쳣��
			������෽���������쳣���ͱ���Ҫ����try�������Բ����׳���
*/
class AException extends Exception
{

}
class BException extends AException
{

}
class CException extends BException
{

}
class Fu
{
	public void method()throws AException
	{

	}
}
class Zi extends Fu
{
	public void method()throws BException
	{

	}
}
class  ExceptionTest7
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
