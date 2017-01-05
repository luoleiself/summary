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

		//对Frame行基本设置
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());

		tf = new TextField(20);

		 but = new Button("my button");

		 //将组件天剑到frame中。
		 f.add(but);

		 //显示窗体：
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
		//判断文本框中输入的是否为0-9以内的数字，不是则输出非法，并屏蔽。
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent k)
			{
				int code = k.getKeyCode();
				if (!(k.getKeyCode()>=KeyEvent.VK_0 && code<=KeyEvent.VK_9))
				{
					System.out.println(code+"::::是非法的");
					k.consume();
				}
			}
		});
		//给But添加一个键盘监听。
		but.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent k)
			{
				if (k.isControlDown() && k.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					System.exit(0);//判断按下Ctrl和esc键退出。
				}
				if (k.getKeyCode()==KeyEvent.VK_ESCAPE)//判断如果按键是esc则退出。
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
				System.out.println("鼠标进入到该组件："+count++);
			}
			public void mouseClicked(MouseEvent m)
			{
				if (m.getClickCount() == 2)
				{
					System.out.println("双击动作："+clickCount++)；
				}
			}
		});
	}
	public static void main(String[] args) 
	{
		
	}
}
