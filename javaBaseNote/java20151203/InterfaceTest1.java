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

�ӿڵ��ص㣺
		1���ӿ��Ƕ��Ⱪ¶�Ĺ���
		2���ӿ��ǳ���Ĺ�����չ��
		3���ӿڿ���������ʵ�֡�

�̳�(extends)�ͽӿ�(interface)������
		�̳б�ʾ�������ڸ��������ϵ֮�У�����߱��ķ��������඼�߱���
		�ӿڱ�ʾ���಻���ڽӿ������ϵ֮�У��ӿھ߱��ķ��������಻һ���߱���
*/
abstract class Student 
{
	abstract void study();
	void sleep()
	{
		System.out.println("sleep");
	}
}
interface Smoking
{
	void smoke();
}
class BaseStudent extends Student implements Smoking//�������ѧ����ѧϰ��˯���Ĺ��ܣ�Ҳ�г��̵Ĺ��ܡ�
{
	void study(){}
	public void smoke(){}
}
class SubStudent extends Student//�������ѧ��ֻ��ѧϰ��˯���Ĺ��ܡ�
{
	void study(){}
}
class InterfaceTest1
{
	public static voia main(String[] args)
	{
		System.out.println("Hello World");
	}
}