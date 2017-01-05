/*


*/
import java.awt.*;
import java.awt.event.*;
class  MyWindowDemo1
{
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;
	
	private Dialog d;
	private Label lab;
	private Button okBut;

	MyWindowDemo1()
	{
		init();
	}
	public void init()
	{
		f = new Frame("my window");
		f.setBounds(300,100,600,500,);
		f.setLayout(new FlowLayout());

		tf = new TextField(60);
		but = new Button("转到");
		ta = new TextArea(25,70);

		f.add(tf);
		f.add(but);
		f.add(ta);

		d = new Dialog(f,"提示信息:",true);
		d.setBounds(400,200,240,150);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBut = new Button("确定");

		d.add(lab);
		d.add(okBut);

		myEvent();
		f.setVisible(true);
	}
	private void myEvent()
	{
		okBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				d.setVisible(false);
			}
		});
		d.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				d.setVisible(false);
			}
		});
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				System.exit(0);
			}
		});
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent k)
			{
				if (k.getKeyCode()==KeyEvent.VK_ENTER)
				{
					showDir();
				}
			}
		});
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				showDir();
			}
		});
	}
	//共有方法进行封装，简化代码书写。提高阅读性。
	private void showDir()
	{
		String dirPath = tf.getText();
		File dir = new File(dirPath);

		if (dir.exists() && dir.isDirectory())
		{
			ta.setText("");
			String[] names = dir.list();
			for (String name: names)
			{
				ta.append(name+"\r\n");
			}
		}
		else
		{
			String info = "您输入的信息："+dirPath+"是错误的,请重新输入";
			lab.setText(info);
			d.setVisible(true);
		}
	}
	public static void main(String[] args) 
	{
		
	}
}
