/*
�ӿڣ�������⣬������Ϊ��һ������ĳ����ࡣ
	   ���������еķ������ǳ���ģ���ô�������ͨ���ӿڵ���ʽ����ʾ��

class ���ڶ����࣬
interface ���ڶ���ӿڡ�

�ӿڶ����ʽ�ص㣺
	1���ӿ��г������壺���������󷽷���
	2���ӿ��еĳ�Ա���й̶����η���
		������public static final
		������public abstract
	��ס���ӿڵĳ�Ա����public�ġ�

�ӿڣ��ǲ����Դ�������ģ���Ϊ�г��󷽷���
	  ��Ҫ������ʵ��(implements),����Խӿ��еĳ��󷽷�ȫ����д������ſ���ʵ������
	  ����������һ�������ࡣ
	  
�ӿڿ��Ա����ʵ�֣�Ҳ�ǶԶ�̳в�֧�ֵ�ת����ʽ��java֧�ֶ�ʵ�֡�

�ӿ���ӿ�֮����Զ�̳У�����ӿ�֮����ʵ��(implements)��ϵ��������֮���Ǽ̳�(extends)��ϵ��
������֮�䲻���ڶ�̳�(extends)��
*/
interface Inter 
{
	public static final int NUM = 5;
	public abstract void show();
}
interface InterA
{
	public abstract void method();
}
class Demo
{
	public void function(){}
}
class Test extends Demo implements Inter,InterA//Test��̳и���Demoʵ��Inter,InterA�ӿڡ�
{
	public void show ()
	{
		System.out.println("haha");
	}
	public void method()
	{
		System.out.println("heihei");
	}
}
class InterfaceTest
{
	public static void main(String[] args)
	{
		Test t = new Test();
		System.out.println(t.NUM);
		System.out.println(Test.NUM);
		System.out.println(Inter.NUM);
		System.out.println("Hello World");
	}
}
//���н����5	5	5   Hello	World
/*
interface A
{
	void showA();
}
interface B //extends A
{
	void showB();
}
interface C extends B,A
{
	void showC();
}
class D implements  C
{
	public void showA(){};
	public void showB(){};
	public void showC(){};
}
*/
