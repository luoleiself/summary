/*
�����ڲ��ࣺ
		1�������ڲ�����ʵ�����ڲ���ļ�д��ʽ��
		2�����������ڲ����ǰ�᣺
			 �ڲ�������Ǽ̳�һ�������ʵ�ֽӿڡ�
		3�������ڲ���ĸ�ʽ��new  ������߽ӿ�(){�������������}
		4����ʵ�����ڲ������һ������������󡣶�����������е��֡��������Ϊ�����ݵĶ���
		5�������ڲ����ж���ķ�����ò�Ҫ����3����
		6�������ڲ���ͨ�����ഴ���Ķ������������еķ����ĵ���ֻ��һ�Ρ��������ö�����ظ���һ�ε��ò��衣
*/
abstract class AbsDemo
{
	abstract void show();
}
class Outer
{
	int x = 3;
	/*
	class Inner extends AbsDemo
	{
		void show()
		{
			System.out.println(Outer.this.x);
		}
	}
	*/
	public void function()
	{
		//new Inner().show();
		
		//����һ��AbsDemo����Ķ��󣬶�������ɫ���ֵļ�д����
		new AbsDemo()//�������ڲ�����һ�����ָ�ʽ��AbsDemo  a = new AbsDemo()�����½�����Ķ�̬��
		{
			void show()
			{
				System.out.println(Outer.this.x);
			}
		}.show();//���������Inner��show�����ĵ��á�
	}
}
class  InnerClassTest4
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
