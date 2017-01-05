/*
|--java.lang.Object
	|--java.io.Fileʵ���ࣺ

File�ࣺ�ļ���Ŀ¼·�����ĳ����ʾ��ʽ�� 
	1���������ļ������ļ��з�װ�ɶ���
	2��������ļ����ļ��е�������Ϣ���в�����
	3��File���������Ϊ�������ݸ����Ĺ��캯����
	
	�ֶ�ժҪ��
		static String pathSeparator;
						��ϵͳ�йص�·���ָ�����Ϊ�˷��㣬������ʾΪһ���ַ�����
		static char pathSeparatorChar;
						��ϵͳ�йص�·���ָ�����
		static String separator;
						��ϵͳ�йص�Ĭ�����Ʒָ�����Ϊ�˷��㣬������ʾΪһ���ַ�����
		static char separatorChar;
						��ϵͳ�йص�Ĭ�����Ʒָ�����
	���췽����
		File(File parent, String child);
						���� parent ����·������ child ·�����ַ�������һ���� File ʵ����
		File(String pathname);
						ͨ��������·�����ַ���ת��Ϊ����·����������һ���� File ʵ����
		File(String parent, String child);
						���� parent ·�����ַ����� child ·�����ַ�������һ���� File ʵ����
		File(URI uri);
						ͨ���������� file: URI ת��Ϊһ������·����������һ���µ� File ʵ����
	���÷�����
		boolean canExecute();
						����Ӧ�ó����Ƿ����ִ�д˳���·������ʾ���ļ���
		boolean canRead(); 
						����Ӧ�ó����Ƿ���Զ�ȡ�˳���·������ʾ���ļ��� 
		boolean canWrite(); 
						����Ӧ�ó����Ƿ�����޸Ĵ˳���·������ʾ���ļ��� 
		int compareTo(File pathname); 
						����ĸ˳��Ƚ���������·������ 
		boolean createNewFile(); 
						���ҽ��������ھ��д˳���·����ָ�����Ƶ��ļ�ʱ�����ɷֵش���һ���µĿ��ļ��� 
						��ָ��λ�ô����ļ���������ļ��Ѿ����ڣ����ܴ���������false��
						���������һ�������������һ�����ʹ����ļ��������ļ���������򸲸ǡ�
		static File createTempFile(String prefix, String suffix); 
						��Ĭ����ʱ�ļ�Ŀ¼�д���һ�����ļ���ʹ�ø���ǰ׺�ͺ�׺���������ơ� 
		static File createTempFile(String prefix, String suffix, File directory); 
						��ָ��Ŀ¼�д���һ���µĿ��ļ���ʹ�ø�����ǰ׺�ͺ�׺�ַ������������ơ�
		boolean delete(); 
						ɾ���˳���·������ʾ���ļ���Ŀ¼��ɾ��ʧ�ܷ���false�� 
		void deleteOnExit(); 
						���������ֹʱ������ɾ���˳���·������ʾ���ļ���Ŀ¼�� �ڳ����˳�ʱɾ��ָ���ļ���
		boolean equals(Object obj); 
						���Դ˳���·��������������Ƿ���ȡ� 
		boolean exists(); 
						���Դ˳���·������ʾ���ļ���Ŀ¼�Ƿ���ڡ� 
		File getAbsoluteFile(); 
						���ش˳���·�����ľ���·������ʽ�� 
		String getAbsolutePath(); 
						���ش˳���·�����ľ���·�����ַ�����
		String getParent(); 
						���ش˳���·������Ŀ¼��·�����ַ����������·����û��ָ����Ŀ¼���򷵻� null�� 
		File getParentFile(); 
						���ش˳���·������Ŀ¼�ĳ���·�����������·����û��ָ����Ŀ¼���򷵻� null��
		String getPath(); 
						���˳���·����ת��Ϊһ��·�����ַ�����
		boolean isAbsolute(); 
						���Դ˳���·�����Ƿ�Ϊ����·������ 
		boolean isDirectory(); 
						���Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼�� File f = new File("�ļ���");�ļ�δ����������false��ʹ��boolean exists();�ж��Ƿ���ڡ�
		boolean isFile(); 
						���Դ˳���·������ʾ���ļ��Ƿ���һ����׼�ļ���File f = new File("�ļ���");�ļ�δ����������false��ʹ��boolean exists();�ж��Ƿ���ڡ� 
		boolean isHidden(); 
						���Դ˳���·����ָ�����ļ��Ƿ���һ�������ļ��� 
		long lastModified(); 
						���ش˳���·������ʾ���ļ����һ�α��޸ĵ�ʱ�䡣 
		boolean setLastModified(long time); 
						���ô˳���·����ָ�����ļ���Ŀ¼�����һ���޸�ʱ�䡣 
		long length(); 
						�����ɴ˳���·������ʾ���ļ��ĳ��ȡ� 
		boolean mkdir(); 
						�����˳���·����ָ����Ŀ¼�� 
		boolean mkdirs(); 
						�����˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��
		boolean renameTo(File dest); 
						���������˳���·������ʾ���ļ���
		boolean setExecutable(boolean executable); 
						���ô˳���·����������ִ��Ȩ�޵�һ����ݷ����� 
		boolean setExecutable(boolean executable, boolean ownerOnly); 
						���ô˳���·�����������߻������û���ִ��Ȩ�ޡ� 
		boolean setReadable(boolean readable); 
						���ô˳���·���������߶�Ȩ�޵�һ����ݷ����� 
		boolean setReadable(boolean readable, boolean ownerOnly); 
						���ô˳���·�����������߻������û��Ķ�Ȩ�ޡ� 
		boolean setReadOnly(); 
						��Ǵ˳���·����ָ�����ļ���Ŀ¼���Ӷ�ֻ�ܶ�����ж�������
		boolean setWritable(boolean writable); 
						���ô˳���·����������дȨ�޵�һ����ݷ����� 
		boolean setWritable(boolean writable, boolean ownerOnly); 
						���ô˳���·�����������߻������û���дȨ�ޡ� 
		URI toURI(); 
						����һ����ʾ�˳���·������ file: URI��
		static File[] listRoots();
						�г����õ��ļ�ϵͳ����ʾ����File files = File.listRoots();
		String[] list();
						����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼�е��ļ���Ŀ¼��		
		String[] list(FilenameFilter filter);
						����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼��
		File[] listFiles();
						����һ������·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼�е��ļ���
		File[] listFiles(FileFilter filter);
						���س���·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼��
		File[] listFiles(FilenameFilter filter);
						���س���·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼��
*/
import java.io.*;
class  FileDemo1
{
	public static void print(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
			
	}

	//����File����
	public static void consMethod()
	{
		//��a.txt��װ�ɶ��󣬿��Խ����еĺ�δ���ֵ��ļ������ļ��з�װ�ɶ���
		File f1 = new File("c:\\abc\\a.txt");
		//File f1 = new File("c:/abc/a.txt");
		
		//���Ϊ��Ŀ¼���ұ������ļ��С������ļ�������Ϊ������
		File f2 = new File("c:\\abc","b.txt");
		
		File d = new File("c:\\abc");
		File f3 = new File(d,"c.txt");

		File f4 = new File("c:"+File.separator+"abc"+File.separator+"a.txt");

		print("f1:"+f1);
		print("f2:"+f2);
		print("f3:"+f3);
	}
	public static void method_5()
	{
		File f = new File("file.txt");
		
		f.createNewFile();

		f.mkdir();

		//��ס���ж��ļ������Ƿ����ļ�����Ŀ¼ʱ������Ҫ���жϸ��ļ������װ�������Ƿ���ڡ�
		//ͨ��exists�жϡ�
		print("dir:"+f.isDirectory());
		//File f = new File("file.txt");���:false; f.createNewFile();���:false; f.mkdir();���:true;
		print("file:"+f.isFile());
		//File f = new File("file.txt");���:false; f.createNewFile();���:true; f.mkdir();���:false;
	
		print("isAbsolute:"+f.isAbsolute());//�ж��Ƿ�Ϊ����·����
	}
	public static void method_6()
	{
		File f = new File("a.txt");

		print("path:"+f.getPath());//��ȡ�ļ�·����
		print("Absolutepath:"+f.getAbsolutePath());//��ȡ�ļ��ľ���·��ȫ�ơ�
		
		//�÷������ص��Ǿ���·���еĸ�Ŀ¼�������ȡ�������·�����򷵻�null
		//������·��������һ��Ŀ¼����ô��Ŀ¼���Ƿ��ؽ����
		print("parent:"+f.getParent());//�����null
	}
	public static void method_7()
	{
		File f1 = new File("c:\\test.java");
		File f2 = new File("c:\\renameTotest.java");

		//���ļ���������������ļ��ڷ�Դ�ļ�Ŀ¼�£�����к������������������ڼ��С�
		print("renameTo:"+f1.renameTo(f2));
	}
	public static void method_1()
	{
		File f = new File("file1.txt");
		
		f.deleteOnExit();//�����˳�����ɾ���ļ���

		print("createNewFile:"+f.createNewFile());//�����ļ�������ļ��ѽ����򷵻�false��

		print("delete:"+f.delete());//ɾ����ǰ�ļ���
	}
	public static void method_2()
	{
		File f = new File("file2.txt");

		print("execute:"+f.canExecute());//�ж��ļ��Ƿ������С�
	}
	public static void method_3()
	{
		File f = new File("file3.txt");
		
		print("exists:"+f.exists());//�ж��ļ��Ƿ���ڡ�
	}
	public static void method_4()
	{
		File dir = new File("abc");

		print("mkdir:"+dir.mkdir());//�ڵ�ǰĿ¼�´����ļ��С�ֻ�ܴ���һ��Ŀ¼��
		print("mkdir:"+dir.mkdirs());//�ڵ�ǰĿ¼�´����ļ��С����Դ����༶Ŀ¼��
	}
}




