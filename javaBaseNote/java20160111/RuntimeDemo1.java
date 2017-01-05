/*
|--java.lang.Object
	|--java.lang.Runtime类：
该类中并没有提供构造函数。说明不可以new对象，那么会直接想到该类中的方法都是静态的。
发现该类中还有非静态方法，说明该类肯定会提供了方法获取本类对象，
而且该方法是静态的，并且返回值类型是本类类型。

有这个特点可以看出该类使用了单例设计模式。

		方法：
		Process exec(String command)；
					在单独的进程中执行指定的字符串命令。
		static Runtime getRuntime();
					返回与当前 Java 应用程序相关的运行时对象。

java.lang.Process抽象类：
		abstract  void destroy();
					杀掉子进程。		
*/
import java.util.*;
class  RuntimeDemo1
{
	public static void main(String[] args) 
	{
		Runtime r = Runtime.getRuntime();
		//反斜杠为转义字符，下面应该多加一个反斜杠。
		Process p = r.exec("c:\\winmine.exe");
		r.exec("D:\\BaiduYunGuanjia\\BaiduYunGuanjia.exe");

		r.exec("EditPlus.exe  SystemDemo.java");//用记事本打开java文档。

		//杀掉子进程。
		p.detroy();
	}
}
