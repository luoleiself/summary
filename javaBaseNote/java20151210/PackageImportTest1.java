/*
包：Package
	1，用来对类文件进行分类管理。
	2，给类提供多层命名(名称)空间。
	3，写在程序文件的第一行。
	4，类名的全称：包名.类名。
	5，包也是一种封装形式。

包名的定义原则：
				建立包名不要重复，可以使用url来完成定义，URL是唯一的。
				格式：package cn.itcast.pack;

编译时：	
		格式：javac  -d . //当前目录下为点  packageTest.java
		格式：javac  -d c:\myclass packageTest.java //将class文件存放到C盘myclass文件下。
运行时：
		格式：java  pack.packageTest

总结：
	1，包与包之间进行访问，被访问的包中的类以及类中的成员，需要public修饰。
	2，不同包中的子类，还可以直接访问父类中被proctected权限修饰的成员。

包与包之间可以使用的权限两种：public  protected
			public	protected	default		private
同一个类中	  ok		ok		  ok		  ok
同一个包中	  ok		ok		  ok		 
子类		  ok        ok		  
不同包中	  ok				  


为了简化类名的书写，使用一个关键字import。
建议：不要写通配符*。需要用到包中的哪个类就导入哪个类，这样最好。


*/
package pack.pack1.pack2.pack3.pack4;//多层包。
import	pack.pack1.pack2.pack3.pack4.*;//星号为把导入当前目录下所有的类。

public class PackageTest1 
{
	public static void main(String[] args) 
	{
		//pack.pack1.pack2.pack3.pack4.Demo d = new pack.pack1.pack2.pack3.pack4.Demo();
		System.out.println("Hello package!");
	}
}

