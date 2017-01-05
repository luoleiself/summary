/*
GUI:
	Graphical User Interface	图形用户接口。
	用图形的方式，来显示计算机操作的界面，这样更方便更直观。

CLI:
	Command line User Interface	命令行用户接口
	常见的Dos命令行操作。

java.Awt:
		Abstract Window ToolKit(抽象窗口工具包)
		需要调用本地系统方法实现功能，属于重量级控件。

javax.Swing:
		在AWT的基础上，建立的一套图形界面系统。
		提供了更多的控件，而且完全由JAV实现，增强了移值性，属于轻量级控件。
Component
|--Button
|--Lable
|--Checkbox
|--TextComponent
	|--TextArea
	|--TextField
|--Container:是一个特殊的组件，该组件中可以通过add方法添加其他组件进来。
	|--Panel
	|--Window
		|--Frame
		|--Dialog
			|--FileDialog

布局管理器：容器中的组件的排放方式，就是布局。
	1,FlowLayout(流式布局管理器)
		从左到右的顺序排列。
		Panel默认的布局管理器。
	2,BorderLayout(边界布局管理器)
		东，南，西，北，中，
		Frame默认的布局管理器。
	3,GridLayout(网格布局管理器)
		规则的矩阵。
	4,CardLayout(卡片布局管理器)
		选项卡。
	5,GridBagLayout(网格包布局管理器)
		非规则的矩阵。

创建图形化界面：
		1,创建Frame窗体，
		2，对窗体进行基本设置。
			定义大小，位置，颜色等。
		3，定义组件。
		4，将组件通过窗体的add方法添加到窗体中，
		5，让窗体显示，通过setVisible(true);

事件监听机制：
		1，事件源(组件):Awt包或者Swing包中的那些图形界面组件。
		2，事件(event):每一个事件源都有自己特有的对应事件和共性事件。
		3，监听器(Listener):将可以触发某一个事件的动作(不止一个动作)都已经封装到了监听器中。
			以上三者在java中都已经定义好了，直接获取其对象来用就可以了。
		4，事件处理(引发事件后处理方法):
*/
import java.awt.*;
import java.awt.event.*;
class  AwtDemo1
{
	public static void main(String[] args) 
	{
		Frame f = new Frame("my awt");

		//设置窗体的大小：横坐标，纵坐标。
		f.setSize(500,400);
		//设置窗体显示的位置；横坐标，纵坐标。
		f.setLocation(300,200);
		//设置窗体为可见。
		f.setVisible(new FlowLayout());
		

		Button b = new Button("我是一个按钮");
		f.add(b);
		//f.addWindowListener(new MyWin());
		
		//匿名内部类：
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				System.exit(0);
			}
		});

		f.setVisible(true);

		//System.out.println("Hello World!");
	}
}
//因为WindowListener的子类WindowAdapter已经实现了WindowListener接口，
//并覆盖了其中的所有方法，那么我只要继承WindowAdapter覆盖我需要的方法即可。

/*
class MyWin extends WindowAdapter//可以使用匿名内部类的方式。
{
	public void windowClosing(WindowEvent w)
	{
		System.exit(0);
	}
}
*/