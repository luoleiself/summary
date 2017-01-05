/*
jar包双击执行：

jar  -cvf  my.jar  myMenu
(jar  -cvfm  my.jar 1.txt myMenu)

配置执行jar包环境：
1,打开我的电脑，点击工具菜单，选择文件夹选项。
2,在文件夹选项对话框中选择文件类型，选择jar类型。
3,如果jar类型文件不存在，则点击新建，文件扩展名为jar。然后确定。
4,如果存在jar文件类型，则选择高级按钮。
5,在操作下面的文本框中如果有则选择编辑，(如果没有则选择新建，操作名字修改为open，然后关闭。)
6,选择浏览，找到D:\jdk1.6.0_43\bin\javaw.exe文件，并在后面加上-jar.然后关闭保存。

*/

Main-Class: MyMenuDemo1.myMenu

import java.awt.*;
import java.awt.event.*;
class JarDemo1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
