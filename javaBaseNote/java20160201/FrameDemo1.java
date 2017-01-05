/*

*/
import java.awt.*;
import java.awt.event.*;
class  FrameDemo1
{
	//定义该图形中所需的组件的引用。
	private Frame f;
	private Button but;

	FrameDemo1()
	{
		init();
	}
	public void init()
	{
		f = new Frame("my frame");

		//对Frame进行基本设置
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());

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
		
		//让按钮具备退出程序的功能。
		/*
		按钮就是事件源，
		那么选择哪一个监听器呢？
		通过关闭窗体示例了解到想要知道哪个组件具备什么样的特有监听器。
		需要查看该组件对象的功能。
		通过查阅Button的描述，发现按钮支持一个特有监听：addActionListener();

		*/
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				System.out.println("退出，按钮干的");
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) 
	{
		new FrameDemo1();
	}
}
