/*
���󣺻�ȡһ�γ������е�ʱ��;
ԭ����ȡ����ʼ�ͽ�����ʱ�䲢������ɡ�

��ȡʱ�䣺System.currentTimeMillis();

����������Ż��󣬾Ϳ��Խ���������⣬���ַ�ʽ��ģ�巽�����ģʽ��

ʲô��ģ�巽���أ�
	�ڶ��幦��(����)ʱ������(����)��һ������ȷ���ģ�������һ�����ǲ�ȷ������ȷ���Ĳ�����ʹ�ò�ȷ���Ĳ��֣�
	��ô��ʱ�ͽ���ȷ���Ĳ��ֱ�¶��ȥ���ɸ��������ȥ��ɡ�
	(�̳�,����,���շ����ļ�ǿ��ϰ)��
*/
class GetTime
{
	public void getTime()
	{
		long start = System.currentTimeMillis();
		for (int x =0;x<1000;x++)//���Ƴ����ִ��ʱ���Ա�currentTimeMillis()�����Գ���ִ��ʱ��ļ��㡣
		{
			System.out.print(x);
		}
		long end = System.currentTimeMillis();
		System.out.println("���룺"+(end-start));
	}
}
class  TemplateTest
{
	public static void main(String[] args) 
	{
		GetTime gt = new GetTime();
		//SubTime gt = new SubTime();
		gt.getTime();
		System.out.println("Hello World!");
	}
}
/*
ģ�巽��ģʽ��
abstract class GetTime
{
	public final void getTime()//ʹ��final�ؼ����η���ʹ����Ϊ���հ棬���ܱ����غ���д��
	{
		long start = System.currentTimeMillis();
		runCode();
		long end = System.currentTimeMillis();
		System.out.println("���룺"+(end-start));
	}
	public abstract void runCode();//����������Ϊ���󷽷���������ȥ��дִ����Ȼ�����г���
}
class SubTime extends GetTime//�������࣬������ȥ��д���������ִ��������,ִ��������Ϊ��ȷ�����ݡ�
{
	public void runCode()
	{
		for (int x =0;x<1000;x++)
		{
			System.out.print(x);
		}
	}
}
class  TemplateTest
{
	public static void main(String[] args) 
	{
		//GetTime gt = new GetTime();
		SubTime gt = new SubTime();
		gt.getTime();
		System.out.println("Hello World!");
	}
}
*/
