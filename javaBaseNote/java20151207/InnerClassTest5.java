//�����ڲ���������ϰ��
interface Inter
{
	//public static final int x = 8;��֮ǰѧϰ�ĽӿڵĶ������ϰ��
	public abstract void method();
}
class Test
{
	/*
	static class Inner implements Inter
	{
		public void method()
		{
			System.out.println("Test.function().method();");
		}
	};
	*/
	static Inter function()
	{
		return new Inter()
		{
			public void method()
			{
				System.out.println("Test.function().method();");
			}
		};
	}
}
class InnerClassTest5 
{
	public static void main(String[] args) 
	{
		//Test.function():Test������һ����̬�ķ���function.
		//.method():function������������Ľ����һ�����󣬶�����һ������ֵ����ΪInter���͵Ķ���
		//��Ϊֻ����Inter���͵Ķ��󣬲ſ��Ե���method������
		Test.function().method();
		/*
		Inter in = Test.function();
		in.method();
		*/

		//��һ�������а����ķ���������3��������ͨ�������ڲ�������ʵ�֡�
		/*
		show(new Inter())
		{
			public void method()
			{
				System.out.println("Test.function().method();");
			}
		});
		//�����Ŵ�����������ݷ�Χ��С���Ŵ��������Χ���ֺŴ������Ľ�����
		*/
	}
	/*
	public static void show (Inter in)
	{
		in.method();
	}
	*/
}
