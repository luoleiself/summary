/*


*/
import java.awt.*;
import java.awt.event.*;
class  MouseAndKeyEventDemo1
{
	private Frame f;
	private Button but;
	MouseAndKeyEventDemo1()
	{
		init();
	}
	public void init()
	{
		f = new Frame("my frame");

		//��Frame�л�������
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());

		tf = new TextField(20);

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
		//�ж��ı�����������Ƿ�Ϊ0-9���ڵ����֣�����������Ƿ��������Ρ�
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent k)
			{
				int code = k.getKeyCode();
				if (!(k.getKeyCode()>=KeyEvent.VK_0 && code<=KeyEvent.VK_9))
				{
					System.out.println(code+"::::�ǷǷ���");
					k.consume();
				}
			}
		});
		//��But���һ�����̼�����
		but.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent k)
			{
				if (k.isControlDown() && k.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					System.exit(0);//�жϰ���Ctrl��esc���˳���
				}
				if (k.getKeyCode()==KeyEvent.VK_ESCAPE)//�ж����������esc���˳���
				{
					System.out.exit(0);
				}
				System.out.println(k.getKeyChar()+"::"+k.getKeyCode());
				System.out.println(KeyEvent.getKeyText(k.getKeyChar())+"::"+k.getKeyCode());
			}
		});

		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				System.out.println("action ok");
			}
		});
		but.addMouseListener(new MouseAdapter()
		{
			private int count = 1;
			private int clickCount = 1;
			public void mousEntered(MouseEvent m)
			{
				System.out.println("�����뵽�������"+count++);
			}
			public void mouseClicked(MouseEvent m)
			{
				if (m.getClickCount() == 2)
				{
					System.out.println("˫��������"+clickCount++)��
				}
			}
		});
	}
	public static void main(String[] args) 
	{
		
	}
}
