/*
֪ʶ�㣺
	һ�������ඨ��ķ��ͣ�������������Ч�����������ʹ�ã���ô������Ķ�����ȷҪ�����ľ������ͺ�
����Ҫ���������;��Ѿ��̶��ˡ�
		Ϊ���ò�ͬ�������Բ�����ͬ���ͣ��������ͻ���ȷ������ô���Է��Ͷ����ڷ����ϡ�

ע�⣺���Ͷ����ڷ����ϣ�����Ӧ�ŵ�����ֵ���͵�ǰ�档

����֮����
		��̬���������Է������϶���ķ��ͣ������̬����������Ӧ���������Ͳ�ȷ�������Խ����Ͷ����ڷ����ϡ�
*/
class Demo1<T>//�������ڳ�ʼ��ʱȷ�������������ͺ����еķ���Ҳȷ���������������͡�
{
	public void show(T t)
	{
		System.out.println("show:"+t);
	}
	public void print(T t)
	{
		System.out.println("print:"+t);
	}
	public static <T> void println(T t)//��̬�������ڶ���Ľ��������أ��޷����ʷǾ�̬��Ա��
	{
		System.out.println("print:"+t);
	}

}
//============================================================
class Demo2
{
	public <T> void show(T t)//���������巺�ͺ󣬷������ÿ��ǵ����ߵ��������͡�
	{
		System.out.println("show:"+t);
	}
	public <T> void print(T t)
	{
		System.out.println("print:"+t);
	}
}
class  GenericStaticDemo4
{
	public static void main(String[] args) 
	{
		/*
		Demo1<Integer> d1 = new Demo1<Integer>();
		d1.show(new Integer(4));
		d1.print(4);

		Demo1<String> d2 = new Demo1<String>();
		d2.show("abc");
		d2.print('4');
		*/

		Demo2 d1 = new Demo2();
		d1.show("abcdefg");
		d1.show(new Integer(4));
		d1.print("heihei");
	}
}
