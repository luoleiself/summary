/*
�ڲ��ඨ���ھֲ�ʱ��
				1�������Ա��Ա���η����Ρ�
				2������ֱ�ӷ����ⲿ���еĳ�Ա����Ϊ�������ⲿ���е����á�
					���ǲ����Է��������ڵľֲ��еı�����ֻ�ܷ��ʱ�final���εľֲ�������
*/

class Outer
{
	int x = 3;
	void method()
	{
		int y = 4;
		class Inner//�ڲ����ھֲ������ܱ�static���Σ�
		{
			void function()
			{
				System.out.println(Outer.this.x);
			}
		}
	}
}
class  InnerClassTest3
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
