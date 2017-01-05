/*
Properties��hashtable�����࣬
Ҳ����˵���߱�map���ϵ��ص㣬����������洢�ļ�ֵ�Զ����ַ���������Ҫ���͡�

�Ǽ����к�IO�������ϵļ���������

�ö�����ص㣺�������ڼ�ֵ����ʽ�������ļ���

��ô�ڼ�������ʱ����Ҫ�����й̶���ʽ����=ֵ��

java.lang.Object
	|--java.util.Dictionary<K,V>
		|--java.util.Hashtable<Object,Object>
			|--java.util.Properties

Propertiesʵ���ࣺ
			�ֶ�ժҪ��
			protected  Properties defaults;
					һ�������б����������б�������δ�ҵ�ֵ�ļ���Ĭ��ֵ ��
			���캯����
			Properties(); 
					����һ����Ĭ��ֵ�Ŀ������б� 
			Properties(Properties defaults); 
					����һ������ָ��Ĭ��ֵ�Ŀ������б�
			һ�㷽����
			String getProperty(String key);
					��ָ���ļ��ڴ������б����������ԡ�
			String getProperty(String key, String defaultValue);
					��ָ���ļ��������б����������ԡ�
			void list(PrintStream out); 
					�������б������ָ����������� 
			void list(PrintWriter out); 
					�������б������ָ����������� 
			void load(InputStream inStream); 
					���������ж�ȡ�����б�����Ԫ�ضԣ��� 
			void load(Reader reader); 
					���򵥵������еĸ�ʽ�������ַ����ж�ȡ�����б�����Ԫ�ضԣ���
			void loadFromXML(InputStream in); 
					��ָ������������ XML �ĵ�����ʾ���������Լ��ص������Ա��С�
			Enumeration<?> propertyNames(); 
					���������б������м���ö�٣�������������б���δ�ҵ�ͬ���ļ��������Ĭ�������б��в�ͬ�ļ��� 
			Object setProperty(String key, String value); 
					���� Hashtable �ķ��� put�� 
			void store(OutputStream out, String comments); 
					���ʺ�ʹ�� load(InputStream) �������ص� Properties ���еĸ�ʽ������ Properties ���е������б�����Ԫ�ضԣ�д��������� 
			void store(Writer writer, String comments); 
					���ʺ�ʹ�� load(Reader) �����ĸ�ʽ������ Properties ���е������б�����Ԫ�ضԣ�д������ַ���
			void storeToXML(OutputStream os, String comment); 
					����һ����ʾ�˱��а������������Ե� XML �ĵ��� 
			void storeToXML(OutputStream os, String comment, String encoding); 
					ʹ��ָ���ı��뷢��һ����ʾ�˱��а������������Ե� XML �ĵ���
			Set<String> stringPropertyNames(); 
					���ش������б��еļ��������иü������Ӧֵ���ַ�����������������б���δ�ҵ�ͬ���ļ����򻹰���Ĭ�������б��в�ͬ�ļ��� 
			
*/
import java.io.*;
import java.util.*;
class  PropertiesDemo1
{
	public static void main(String[] args)throws IOException
	{
		
	}
	//���úͻ�ȡԪ�أ�
	public static void setAndGetMethod()throws IOException
	{
		Properties prop = new Properties();

		prop.setProperty("zhangsan","30");
		prop.setProperty("lisi","25");

		System.out.println(prop);
		
		//��ȡԪ�أ�
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
		//�����е����ݼ��ؽ����ϣ�
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
	��ν����е����ݴ洢�������У�
	1����һ������info.txt�ļ�����
	2����ȡһ�����ݣ�������������"="�и
	3���Ⱥ������Ϊ�����ұ���Ϊֵ�����뵽properties�����м��ɡ�
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
