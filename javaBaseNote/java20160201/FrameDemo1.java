/*

*/
import java.awt.*;
import java.awt.event.*;
class  FrameDemo1
{
	//�����ͼ�����������������á�
	private Frame f;
	private Button but;

	FrameDemo1()
	{
		init();
	}
	public void init()
	{
		f = new Frame("my frame");

		//��Frame���л�������
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());

		 but = new Button("my button");

		 //������콣��frame�С�
		 f.add(but);

		 //��ʾ���壺
		 f.setVisible(true);
	}
	private void myEvent()
	{
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				System.exit(0);
			}
		});
		
		//�ð�ť�߱��˳�����Ĺ��ܡ�
		/*
		��ť�����¼�Դ��
		��ôѡ����һ���������أ�
		ͨ���رմ���ʾ���˽⵽��Ҫ֪���ĸ�����߱�ʲô�������м�������
		��Ҫ�鿴���������Ĺ��ܡ�
		ͨ������Button�����������ְ�ť֧��һ�����м�����addActionListener();

		*/
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				System.out.println("�˳�����ť�ɵ�");
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) 
	{
		new FrameDemo1();
	}
}
