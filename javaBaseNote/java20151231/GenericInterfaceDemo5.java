/*
���Ͷ����ڽӿ���
	��һ�ַ�ʽ����ʵ�ַ��ͽӿڵ�ͬʱ��ȷ�����ͣ������Ķ���Ҳֻ��ʹ����Է��Ͷ�������͡�
	
	�ڶ��ַ�ʽ����ʵ�ַ��ͽӿڵ�ͬʱ����ȷʵ�����ͣ������ڽ��������ʱ����ȷ�����͡�
*/
interface Inter<T>
{
	public static final  int NUM = 10;//�ӿڵĶ����ʽ�� 
	public abstract void show (T t);
}

//��һ�ַ�ʽ������ȷʵ�ַ��ͽӿڵ������͡�
class InterImpl implements	Inter<String>
{
	public void show(String t)
	{
		System.out.println("show:"+t);
	}
}

//�ڶ��ַ�ʽ������ȷʵ�ַ��ͽӿڵ������ͣ��ڽ��������ʱ������ȷ��
class InterImpl<T> implements Inter<T>
{
	public void show(T t)
	{
		System.out.println("show:"+t);
	}
}
class  GenericInterfaceDemo5
{
	public static void main(String[] args) 
	{
		//InterImpl i = new InterImpl();
		//i.show("hahaha");

		InterImpl<Integer> i = new InterImpl<Integer>();
		i.show(4);
	}
}
