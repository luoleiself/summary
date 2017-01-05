/*
java.lang.System类：方法和属性都是静态的。
		1，最终类，不能被继承。
		2，不能被实例化，没有构造函数。

|--java.lang.Object
		|--java.util.Dictionary<K,V>
			|--java.util.Hashtable<Object,Object>
					|--java.util.Properties

System:
		描述系统的一些信息。

	方法：
		in：标准输入，默认是键盘。
		out：标准输出，默认是控制台。
		static void gc();
					启动垃圾回收器。
		static String setProperty(String key, String value);
					设置指定键指示的系统属性。
		static Properties getProperties();
					确定当前的系统属性。
					获取系统属性信息：Properties getProperties();
		static Console console();
					返回与当前 Java 虚拟机关联的唯一 Console 对象（如果有）。

	示例：Properties prop = System.getProperties();
*/
import java.util.*;
class  SystemDemo1
{
	public static void main(String[] args) 
	{
		Properties prop = System.getProperties();

		//因为Properties是Hashtable的子类，也就是Map集合的一个子类对象。
		//那么可以通过Map的方法去除该集合中的元素。
		//该集合中存储的都是字符串，没有泛型定义。

		//Set<Object> keySet = prop.keySet();
		//Iterator<Object> iter = ketSet.iterator();
		
		//获取所有属性信息。
		for (Object obj:prop.keySet())
		{
			String value = (String)prop.get(obj);
			System.out.println(obj+"::"+value);
		}
		
		//如何在系统中自定义一些特有信息呢？
		System.setProperty("myKey","myValue");


		//获取指定属性信息：
		String str1 = System.getProperty("os.name");
		System.out.println("str1="+str1);

		//可不可以在虚拟机启动时，动态的加载一些属性信息？
		java -D<name>=<value> ;
	}
}
