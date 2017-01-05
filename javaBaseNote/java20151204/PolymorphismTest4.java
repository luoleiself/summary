/*
����
��������ʵ����
�����������л������塣
*/
interface PCI
{
	public abstract void open();
	public abstract void close();
}
class MainBoard
{
	public void run()
	{
		System.out.println("mainboard run");
	}
	public void UsePCI(PCI p)//PCI p = new NetCard() �ӿ�������ָ���Լ����������
	{
		if (p!=null)
		{
			p.open();
			p.close();
		}
	}
}
class NetCard implements PCI
{
	public void open()
	{
		System.out.println("NetCard run");
	}
	public void close()
	{
		System.out.println("NetCard close");
	}
}
class SoundCard implements PCI
{
	public void open()
	{
		System.out.println("SoundCard run");
	}
	public void close()
	{
		System.out.println("SoundCard close");
	}
}
class  PolymorphismTest4
{
	public static void main(String[] args) 
	{
		MainBoard mb = new MainBoard();
		mb.run();
		mb.UsePCI(null);
		mb.UsePCI(new NetCard());
		mb.UsePCI(new SoundCard());
		System.out.println("Hello World!");
	}
}
