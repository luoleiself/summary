/*
1��
	Դ������¼�룬
   Ŀ�ģ�����̨��

2��������Ѽ���¼������ݴ洢��һ���ļ��С�
	Դ������¼�룬
   Ŀ�ģ��ļ���

3��������Ѽ���¼������ݴ洢��һ���ļ��С�
	Դ���ļ���
   Ŀ�ģ�����̨��

�������Ļ������ɣ�
		ͨ��������ȷ����ɣ�
			1����ȷԴ��Ŀ�ġ�
					Դ����������InputStream		Reader
					Ŀ�ģ��������OutputStream	Writer
			2����ȷ�����������Ƿ��Ǵ��ı���
					�ǣ��ַ�����
					���ֽ�����
			3������ϵ��ȷ������ȷҪʹ���ĸ�����Ķ���
					ͨ���豸���������֣�
					Դ�豸���ڴ棬Ӳ�̣����̡�
					Ŀ���豸���ڴ棬Ӳ�̣�����̨��

���������
1����һ���ı��ļ��е����ݴ洢����һ���ļ��С������ļ���
	Դ��
		1����Ϊ��Դ������ʹ�ö�ȡ����InputStream		Reader
			�ǲ��ǲ����ı��ļ����ǣ���ʱ�Ϳ���ѡ��Reader��
	
		2����ȷҪ�Ǹ���ϵ�е��ĸ�����
			��ȷ�豸��Ӳ�̣���һ���ļ���
			Reader��ϵ�п��Բ����ļ��Ķ�����FileReader
		
		3���Ƿ���Ҫ���Ч�ʣ��ǣ�����Reader��ϵ�еĻ�������BufferedReader
			
			FileReader fr = new FileReader("a.txt");
			BufferedReader bufr = new BufferedReader(fr);

	Ŀ�ģ�
		1��OutputStream	Writer
			Ŀ���Ƿ��Ǵ��ı����ǣ�Writer
		2,	�豸��Ӳ�̣�һ���ļ���
			Writer��ϵ�п��Բ����ļ��Ķ���FileWriter
		3���Ƿ���Ҫ���Ч�ʣ��ǣ�����Writer��ϵ�еĻ�������BufferedWriter
			
			FileWriter fw = new FileWriter("b.txt");
			BufferedWriter bufw = new BufferedWriter(fw);

====================================================================================

2�����󣺽�����¼������ݱ��浽һ���ļ��С�
	���������Դ��Ŀ�Ķ����ڡ���ô�ֱ������
	Դ��
		1��InputStream		Reader
			�ǲ��ǲ����ı��ļ����ǣ���ʱ�Ϳ���ѡ��Reader��
		2����ȷ�豸�����̣�System.in��
			Ϊ�˲������̵��ı����ݷ��㣬ת���ַ�����װ�ַ�������ʱ���ġ�
			��Ȼ��ȷ��Reader����ô�ͽ�System.in��ת�����ַ���Reader��
			�õ���Reader��ϵ�е�ת����InputStreamReader��
		3���Ƿ���Ҫ���Ч�����ǣ�ѡ��ʹ�û�����BufferedReader��
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader bufr = new BufferedReader(isr);
	Ŀ�ģ�
		1��OutputStream	 Writer
			�Ƿ��Ǵ��ı����ǣ�Writer
		2����ȷ�豸��Ӳ�̣�һ���ļ���ʹ��FileWriter		
		3���Ƿ���Ҫ���Ч�ʣ��ǣ�����Writer��ϵ�еĻ�������BufferedWriter

			FileWriter fw = new FileWriter("c.txt");
			BufferedWriter bufw = new BufferedWriter(fw);

**************************************************************************************************
		���Ǵ洢ʱ����Ҫ����ָ�������UTF-8����ָ���ı����ֻ��ת��������ָ����
		����Ҫʹ�õĶ�����OutputStreamWriter
		����ת��������Ҫ����һ���ֽ�����������һ����Բ������ļ����ֽ��������FileOutputStream.
		
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d.txt"),"UTF-8");
		�Ƿ���Ҫ���Ч�ʣ��ǣ�����Writer��ϵ�еĻ�������BufferedWriter

		BufferedWriter bufw = new BufferedWriter(osw);
		���ԣ���ס��ת����ʲôʱ��ʹ�ã��ַ����ֽ�֮���������ͨ������Ƶ��ַ������ת��ʱ��
		��Ҫ�õ�ת������
**************************************************************************************************
*/
import java.io.*;
class  TransStreamDemo2
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("haha.txt")));
		
		//BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("haha.txt")));
		
		//BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;
		while ((line = bufr.readLine())!=null)
		{
			if ("over".equals(line))
			{
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}
}
