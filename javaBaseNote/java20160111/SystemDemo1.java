/*
java.lang.System�ࣺ���������Զ��Ǿ�̬�ġ�
		1�������࣬���ܱ��̳С�
		2�����ܱ�ʵ������û�й��캯����

|--java.lang.Object
		|--java.util.Dictionary<K,V>
			|--java.util.Hashtable<Object,Object>
					|--java.util.Properties

System:
		����ϵͳ��һЩ��Ϣ��

	������
		in����׼���룬Ĭ���Ǽ��̡�
		out����׼�����Ĭ���ǿ���̨��
		static void gc();
					����������������
		static String setProperty(String key, String value);
					����ָ����ָʾ��ϵͳ���ԡ�
		static Properties getProperties();
					ȷ����ǰ��ϵͳ���ԡ�
					��ȡϵͳ������Ϣ��Properties getProperties();
		static Console console();
					�����뵱ǰ Java �����������Ψһ Console ��������У���

	ʾ����Properties prop = System.getProperties();
*/
import java.util.*;
class  SystemDemo1
{
	public static void main(String[] args) 
	{
		Properties prop = System.getProperties();

		//��ΪProperties��Hashtable�����࣬Ҳ����Map���ϵ�һ���������
		//��ô����ͨ��Map�ķ���ȥ���ü����е�Ԫ�ء�
		//�ü����д洢�Ķ����ַ�����û�з��Ͷ��塣

		//Set<Object> keySet = prop.keySet();
		//Iterator<Object> iter = ketSet.iterator();
		
		//��ȡ����������Ϣ��
		for (Object obj:prop.keySet())
		{
			String value = (String)prop.get(obj);
			System.out.println(obj+"::"+value);
		}
		
		//�����ϵͳ���Զ���һЩ������Ϣ�أ�
		System.setProperty("myKey","myValue");


		//��ȡָ��������Ϣ��
		String str1 = System.getProperty("os.name");
		System.out.println("str1="+str1);

		//�ɲ����������������ʱ����̬�ļ���һЩ������Ϣ��
		java -D<name>=<value> ;
	}
}
