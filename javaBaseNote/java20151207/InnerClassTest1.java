/*
java�ڲ����Ϊ����Ա�ڲ��ࡢ��̬Ƕ���ࡢ�����ڲ��ࡢ�����ڲ��ࡣ

�����ڲ����ǰ��������
			1������̳�һ�������ʵ��һ���ӿڡ�

�����ڲ����ԭ��
			1�������ڲ��಻���й��췽����
			2�������ڲ��಻�ܶ����κξ�̬��Ա����̬������
			3�������ڲ��಻����public,protected,private,static��
			4��ֻ�ܴ��������ڲ����һ��ʵ����
			5��һ�������ڲ���һ������new�ĺ��棬��������ʵ��һ���ӿڻ�ʵ��һ����
			6���������ڲ���Ϊ�ֲ��ڲ��࣬���Ծֲ��ڲ�����������ƶ�������Ч��
			7�������ڲ��಻���ǳ���ģ�������Ҫʵ�ּ̳е������ʵ�ֵĽӿڵ����г��󷽷���

�ڲ�����ʹ���
			1���ڲ������ֵ�����ⲿ���еĳ�Ա�������ⲿ���е�˽�г�Ա��
				֮���Կ���ֱ�ӷ����ⲿ���еĳ�Ա������Ϊ�ڲ����г�����һ���ⲿ������ã�
				��ʽ	�ⲿ��.this
			2���ⲿ��Ҫ�����ڲ��࣬����Ҫ�����ڲ������

priavate class Inner ֻ�����ⲿ���еĳ�Աλ���ϲ��ܽ��ڲ���˽�л���

���ʸ�ʽ��
  1,���ڲ��ඨ�����ⲿ��ĳ�Աλ���ϣ����ҷ�˽�У��������ⲿ���������С�
	����ֱ�ӽ����ڲ������
	��ʽ
		�ⲿ����.�ڲ����� ������ = �ⲿ�����.�ڲ������;
		Outer.Inner in = new Outer().new Inner();
  
  2,���ڲ������ⲿ���Աλ���ϣ��Ϳ��Ա���Ա���η������Ρ�
	���磺private�����ڲ������ⲿ���н��з�װ��
		  static���ڲ���;߱�static�����ԡ�
		  ���ڲ��౻static���κ�ֻ��ֱ�ӷ����ⲿ���е�static��Ա�������˷��ʾ��ޡ�

		 1,���ⲿ�������У����ֱ�ӷ���static�ڲ���ķǾ�̬��Ա�أ�
		  new Outer.Inner().function();

		 2,���ⲿ�������У����ֱ�ӷ���static�ڲ���ľ�̬��Ա�أ�
		  Outer.Inner().function()
	
	ע�⣺���ڲ����ж����˾�̬��Ա�����ڲ�������Ǿ�̬static�ġ�
		  ���ⲿ���еľ�̬���������ڲ���ʱ���ڲ���Ҳ�����Ǿ�̬static�ġ�

�ڲ��ඨ��ԭ��
			����������ʱ��������ڲ�����������������ڲ�����������
			��Ϊ�ڲ�������ʹ���ⲿ��������ݡ�

*/
class Outer
{
	private int x = 3;
	class Inner //priavate class Inner ֻ�����ⲿ���еĳ�Աλ�ô����ܽ��ڲ���˽�л���
	{
		void function()
		{
			System.out.println("Inner:"+x);
		}
	}
	void method()
	{
		Inner in = new Inner();
		in.function();
	}
}
class  InnerClssTest1
{
	public static void main(String[] args) 
	{
		Outer.Inner in = new Outer().new Inner();//�ڲ���ķǾ�̬�ķ����ĵ�������Ҫʵ�����ڲ��ࡣ
		in.function();
		System.out.println("Hello World!");
	}
}
//ʾ����
class Outer
{
	private int x = 3;
	class Inner //priavate class Inner ֻ�����ⲿ���еĳ�Աλ�ô����ܽ��ڲ���˽�л���
	{
		int x = 4;
		void function()
		{	
			int x = 5;
			System.out.println("x:"+Outer.this.x);//ʡ��Outer��ӡ����4��ʡ��Outer.this��ӡ����5��
		}
	}
	void method()
	{
		Inner in = new Inner();
		in.function();
	}
}
class  InnerClssTest1
{
	public static void main(String[] args) 
	{
		Outer.Inner in = new Outer().new Inner();//�ڲ���ķǾ�̬�ķ����ĵ�������Ҫʵ�����ڲ��ࡣ
		in.function();
		System.out.println("Hello World!");
	}
}

