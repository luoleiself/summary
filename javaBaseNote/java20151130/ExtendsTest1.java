/*
�Ӹ�����ֺ����Ա���ص㣺

���г�Ա��
	1������:����Ӹ����г����˷�˽�е�ͬ����Ա����ʱ������Ҫ���ʱ����еĳ�Ա��this��
			���ʸ����е�ͬ��������super��
	2��������
	3�����캯����

	this��super������
		1��this�ǶԱ����������ã�super�ǶԸ�����������;				
*/
class Fu
{
	int num = 4;
}
class Zi extends Fu
{
	int num = 5;
	void Show()
	{
		System.out.println(this.num);//��ӡ��ʾ�Ľ��Ϊ�����е�numֵ��
		System.out.println(super.num);//��������Fu���е�num��ֵ��super.num��
	}
}
class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
