/*
GUI:
	Graphical User Interface	ͼ���û��ӿڡ�
	��ͼ�εķ�ʽ������ʾ����������Ľ��棬�����������ֱ�ۡ�

CLI:
	Command line User Interface	�������û��ӿ�
	������Dos�����в�����

java.Awt:
		Abstract Window ToolKit(���󴰿ڹ��߰�)
		��Ҫ���ñ���ϵͳ����ʵ�ֹ��ܣ������������ؼ���

javax.Swing:
		��AWT�Ļ����ϣ�������һ��ͼ�ν���ϵͳ��
		�ṩ�˸���Ŀؼ���������ȫ��JAVʵ�֣���ǿ����ֵ�ԣ������������ؼ���
Component
|--Button
|--Lable
|--Checkbox
|--TextComponent
	|--TextArea
	|--TextField
|--Container:��һ������������������п���ͨ��add��������������������
	|--Panel
	|--Window
		|--Frame
		|--Dialog
			|--FileDialog

���ֹ������������е�������ŷŷ�ʽ�����ǲ��֡�
	1,FlowLayout(��ʽ���ֹ�����)
		�����ҵ�˳�����С�
		PanelĬ�ϵĲ��ֹ�������
	2,BorderLayout(�߽粼�ֹ�����)
		�����ϣ����������У�
		FrameĬ�ϵĲ��ֹ�������
	3,GridLayout(���񲼾ֹ�����)
		����ľ���
	4,CardLayout(��Ƭ���ֹ�����)
		ѡ���
	5,GridBagLayout(��������ֹ�����)
		�ǹ���ľ���

����ͼ�λ����棺
		1,����Frame���壬
		2���Դ�����л������á�
			�����С��λ�ã���ɫ�ȡ�
		3�����������
		4�������ͨ�������add������ӵ������У�
		5���ô�����ʾ��ͨ��setVisible(true);

�¼��������ƣ�
		1���¼�Դ(���):Awt������Swing���е���Щͼ�ν��������
		2���¼�(event):ÿһ���¼�Դ�����Լ����еĶ�Ӧ�¼��͹����¼���
		3��������(Listener):�����Դ���ĳһ���¼��Ķ���(��ֹһ������)���Ѿ���װ���˼������С�
			����������java�ж��Ѿ�������ˣ�ֱ�ӻ�ȡ��������þͿ����ˡ�
		4���¼�����(�����¼�������):
*/
import java.awt.*;
import java.awt.event.*;
class  AwtDemo1
{
	public static void main(String[] args) 
	{
		Frame f = new Frame("my awt");

		//���ô���Ĵ�С�������꣬�����ꡣ
		f.setSize(500,400);
		//���ô�����ʾ��λ�ã������꣬�����ꡣ
		f.setLocation(300,200);
		//���ô���Ϊ�ɼ���
		f.setVisible(new FlowLayout());
		

		Button b = new Button("����һ����ť");
		f.add(b);
		//f.addWindowListener(new MyWin());
		
		//�����ڲ��ࣺ
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
//��ΪWindowListener������WindowAdapter�Ѿ�ʵ����WindowListener�ӿڣ�
//�����������е����з�������ô��ֻҪ�̳�WindowAdapter��������Ҫ�ķ������ɡ�

/*
class MyWin extends WindowAdapter//����ʹ�������ڲ���ķ�ʽ��
{
	public void windowClosing(WindowEvent w)
	{
		System.exit(0);
	}
}
*/