/*
������ѧ����
	ѧϰ��˯����
�߼���ѧ����
	ѧϰ��˯����

���Խ�������������г�ȡ��

�ܽ᣺
	�����й��е����Խ��в��ϵĳ�ȡ���������ԵĹ��ܷ���������װ��һ�����У�
	����Ҫ��ɹ��ܵķ������ж��嵽һ�����У�ͨ����������������Ҫ��ɹ��ܵķ����ĵ���ʵ����Ĺ��ܡ�
*/
abstract class Student
{
	public abstract void Study();
	public void Sleep()
	{
		System.out.println("����˯");
	}
}
class DoStudent
{
	public void doSome(Student stu) 
	{
		stu.Study();
		stu.Sleep();
	}
}
class BaseStudent extends Student
{
	public void Study()
	{
		System.out.println("Base Study");
	}
	public void Sleep()
	{
		System.out.println("ſ��˯");
	}
}
class AdvStudent extends Student
{
	public void Study()
	{
		System.out.println("Adv Study");
	}
}
class PolymorphismTest2
{
	public static void main(String[] args) 
	{
		//��һ�ַ�ʽ���ã�
		BaseStudent bs = new BaseStudent();
		bs.Study();
		bs.Sleep();
		AdvStudent as =  new AdvStudent();
		as.Study();
		as.Sleep();
		//�ڶ��ֵ��÷�ʽ��
		function(new BaseStudent());
		function(new AdvStudent());
		//�����ַ�ʽ���ã�
		//ͨ���Է������в��ϵĹ��Ե����ϳ�ȡ����������װ��һ�����У�ͨ����ĵ��ã�ʵ��ĳ�����ܡ�
		DoStudent ds = new DoStudent();
		ds.doSome(new BaseStudent());
		ds.doSome(new AdvStudent());
	}
	public void function(BaseStudent bs)
	{
		bs.Study();
		bs.Sleep();
	}
	public void function(AdvStudent as)
	{
		as.Study();
		as.Sleep();
	}
}
