/*
װ�����ģʽ��
		����Ҫ�����еĶ�����й�����ǿʱ�����Զ����࣬�����ж����룬�������ж���Ĺ��ܣ�
���ṩ��ǿ���ܣ���ô�Զ���ĸ���ͳ�Ϊװ���ࡣ

װ����ͨ����ͨ�����췽�����ձ�װ�εĶ��󣬲����ڱ�װ�εĶ���Ĺ����ṩ��ǿ�Ĺ��ܡ�

װ�����ģʽ�ȼ̳�Ҫ�������˼̳���ϵ��ӷ�ף����ҽ�����������֮��Ĺ�ϵ��

װ������Ϊ��ǿ���ж��󣬾߱��Ĺ��ܺ����ж�������ͬ�ģ�ֻ�����ṩ�˸�ǿ�Ĺ��ܣ�
����װ����ͱ�װ���඼����һ����ϵ�С�
*/
class Person
{
	public void chifan()
	{
		System.out.println("�Է�");
	}
}
class SuperPerson
{
	private Person p;
	SuperPerson(Person p)
	{
		this.p = p;
	}
	public void superChifan()
	{
		System.out.println("�ȵ�С��");
		p.chifan();
		System.out.println("�������");
		System.out.println("��֧��");
	}
}
class  decorateDemo1
{
	public static void main(String[] args) 
	{
		Person p = new Person();

		p.chifan();

		SuperPerson sp = new SuperPerson(p);
		sp.superChifan();
	}
}
