/*
Properties是hashtable的子类，
也就是说它具备map集合的特点，而且它里面存储的键值对都是字符串。不需要泛型。

是集合中和IO技术相结合的集合容器，

该对象的特点：可以用于键值对形式的配置文件。

那么在加载数据时，需要数据有固定格式：键=值。

java.lang.Object
	|--java.util.Dictionary<K,V>
		|--java.util.Hashtable<Object,Object>
			|--java.util.Properties

Properties实例类：
			字段摘要：
			protected  Properties defaults;
					一个属性列表，包含属性列表中所有未找到值的键的默认值 。
			构造函数：
			Properties(); 
					创建一个无默认值的空属性列表。 
			Properties(Properties defaults); 
					创建一个带有指定默认值的空属性列表。
			一般方法：
			String getProperty(String key);
					用指定的键在此属性列表中搜索属性。
			String getProperty(String key, String defaultValue);
					用指定的键在属性列表中搜索属性。
			void list(PrintStream out); 
					将属性列表输出到指定的输出流。 
			void list(PrintWriter out); 
					将属性列表输出到指定的输出流。 
			void load(InputStream inStream); 
					从输入流中读取属性列表（键和元素对）。 
			void load(Reader reader); 
					按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。
			void loadFromXML(InputStream in); 
					将指定输入流中由 XML 文档所表示的所有属性加载到此属性表中。
			Enumeration<?> propertyNames(); 
					返回属性列表中所有键的枚举，如果在主属性列表中未找到同名的键，则包括默认属性列表中不同的键。 
			Object setProperty(String key, String value); 
					调用 Hashtable 的方法 put。 
			void store(OutputStream out, String comments); 
					以适合使用 load(InputStream) 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。 
			void store(Writer writer, String comments); 
					以适合使用 load(Reader) 方法的格式，将此 Properties 表中的属性列表（键和元素对）写入输出字符。
			void storeToXML(OutputStream os, String comment); 
					发出一个表示此表中包含的所有属性的 XML 文档。 
			void storeToXML(OutputStream os, String comment, String encoding); 
					使用指定的编码发出一个表示此表中包含的所有属性的 XML 文档。
			Set<String> stringPropertyNames(); 
					返回此属性列表中的键集，其中该键及其对应值是字符串，如果在主属性列表中未找到同名的键，则还包括默认属性列表中不同的键。 
			
*/
import java.io.*;
import java.util.*;
class  PropertiesDemo1
{
	public static void main(String[] args)throws IOException
	{
		
	}
	//设置和获取元素：
	public static void setAndGetMethod()throws IOException
	{
		Properties prop = new Properties();

		prop.setProperty("zhangsan","30");
		prop.setProperty("lisi","25");

		System.out.println(prop);
		
		//获取元素：
		String str = prop.getProperty("lisi");
		System.out.println(str);

		Set<String> names = prop.stringPropertyNames();
		for (String s :names)
		{
			Sytem.out.println(s+"::"+prop.getProperty(s));
		}
	}
	public static void loadDemo()throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("inf.txt");
		//将流中的数据加载进集合；
		prop.load(fis);
		
		System.out.println(prop);
		//prop.list(System.out);

		FileOutputStream fos = new FileOutputStream("info.txt");
		prop.store(fos,"hello world");
		
		System.out.println(prop);
		fis.close();
		fos.close();
	}
	/*
	如何将流中的数据存储到集合中，
	1，用一个流和info.txt文件关联
	2，读取一行数据，将该行数据用"="切割。
	3，等号左边作为键，右边作为值，存入到properties集合中即可。
	*/
	public static void  readerPropertiesMethod()throws IOException
	{
		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));
		String line = null;
		while ((line = bufr.readLine())!=null)
		{
			String[] arr = line.split("=");
			prop.setProperty(arr[0],arr[1]);
		}
		bufr.close();
		System.out.println(prop);
	}
}
