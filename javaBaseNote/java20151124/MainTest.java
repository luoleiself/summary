/*
public static void main(String[] args)

����������һ������ĺ�������Ϊ�������ڣ����Ա�JVM���á�

�������Ķ��壺
	public :�����Ÿú�������Ȩ�������ġ�
	static������������������ļ��ؾ��Ѿ������ˡ�
	void��������û�о���ķ���ֵ�� 
	main�����ǹؼ��֣�������һ������ĵ��ʣ����Ա�JVMʶ��
	(String [] args):����������һ�����飬�������е�Ԫ�����ַ������ַ������͵����顣
					 args(arguments:����)�Ǳ����������Ը��ģ�ֻҪ���ϱ�����������

//String [] arr = new String[3];
//String [] arr = null;			�����б��е��ַ�����������������ֵ��

�������ǹ̶���ʽ�ģ�JVMʶ��

JVM����������ʱ���������new String[0];

*/
/*class  MainTest
{
	public static void main(String[] args) //�����ܴ��ڣ��������ء�
	{
		System.out.println("Hello World!");
	}
	public static void main(int x)//�����ܴ��ڣ��������ء�
	{
		System.out.println("Hello World!");
	}
}
*/
//������������������ִ��˳��˭��ǰ��ִ��˭��
//���ܣ����Խ���ӡ�������еĲ����б����ַ�����������ĳ��ȣ�
//�����Զ���һ�����飬�����鴫�ݸ����������д�ӡ��
class MainTest
{
	public static void main (String[] args)
	{
		String [] arr = {"haha","hehe","heihei","hiahia","xixi"};
		System.out.println(args.length);
		MainTest.main(arr);
	}
}
class MainTest1
{
	public static void main (String[] args)
	{
		for (int x=0;x<args.length;x++)
		{
			System.out.println(args[x]);
		}
	}
}
