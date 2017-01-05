/*


*/
package mymenu
import java.awt.*;
import java.awt.event.*;
class  MyMenuDemo1
{
	private Frame f;
	private MenuBar bar;
	private Menu fileMenu;
	private MenuItem openItem,saveItem,closeItem;
	private TextArea ta;
	private FileDialog openDia,saveDia;
	MyMenuDemo1()
	{
		init();
	}
	public void init()
	{
		f = new Frame("my menu");
		f.setBounds(300,100,650,600,);

		mb = new MenuBar();
		fileMenu = new Menu("�ļ�");

		openItem = new MenuItem("��");
		saveItem = new MenuItem("����");
		closeItem = new MenuItem("�˳�");
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(closeItem);
		bar.add(fileMenu);

		f.setMenuBar(bar);

		openDia = new FileDialog(f,"��Ҫ��",FileDialog.LOAD);
		saveDia = new FileDialog(f,"��Ҫ����",FileDialog.SAVE);
		
		f.add(ta);
		myEvent();
		f.setVisible(true);
	}
	private void myEvent()
	{
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();
				String fileName = openDia.getFile();
//				System.out.println(dirPath+"::"+fileName);
				if (dirPath == null || fileName == null)
				{
					return;
				}
				File file = new File(dirPath,FileName);
				try
				{
					BufferedReader bufr = new BufferedReader(new FileReader(file));
					String line = null;
					while ((line = bufr.readLine())!= null)
					{
						ta.append(line+"\r\n");
					}
				}
				catch (IOException e)
				{
					throw new RuntimeException("��ȡʧ��");
				}
				finally
				{
					try
					{
						if (bufr != null)
						{
							bufr.close();
						}
					}
					catch (IOException e)
					{
						throw new RuntimeException("�رն�ȡ��ʧ��");
					}
				}
			}
		});
		saveItem.addActionListener(new ActionListener()
		{
			public void actionPerFormed(ActionEvent a)
			{
				if (file==null)
				{
					saveDia.setVisible(true);
			
					String dirPath = openDia.getDirectory();
					String fileName = openDia.getFile();

					if (dirPath == null || fileName == null)
					{
						return;
					}
					file = new File(dirPath,fileName);
				}
				try
				{
					BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
					String text = ta.getText();
					
					bufw.write(text);
					bufw.flush();
					bufw.close();
				}
				catch (IOException e)
				{
					throw new RuntimeException("д���ļ�ʧ��");
				}
			}
		});
		closeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				System.exit(0);
			}
		});
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent w)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) 
	{
		
	}
}
