/*
��ȡ����¼�룺
System.out.:��Ӧ���Ǳ�׼����豸������̨��
System.out.:��Ӧ���Ǳ�׼�����豸�����̡�

\r�İ�˹�����ֵΪ13.
\n�İ�˹�����ֵΪ10.

����
ͨ������¼�����ݡ�
��¼��һ�����ݺ󣬾ͽ��������ݽ��д�ӡ��
���¼�������ʱover����ô��ֹͣ¼�롣

*/
import java.io.*;
class  ReadIn
{
	public static void main(String[] args) throws IOException
	{
		InputStream in = System.in;
		/*
		int b = in.read();
		System.out.println(by);
		*/
		StringBuilder sb = new StringBuilder();

		while (true)
		{
			int ch = in.read();
			if (ch == 13)//if(ch == '\r');
			{
				continue;
			}
			else if (ch == 10)//if(ch == '\n');
			{
				String s = sb.toString();
				if ("over".equals(s))
				{
					break;
				}
				System.out.println(s.toUpperCase());//����ȡ���ַ�ת��Ϊ��д�����toLowerCaseת����Сд��
				sb.delete(0,sb.length());//����ַ���������
			}
			else
			{
				sb.append((char)ch);
			}
		}
	}
}






