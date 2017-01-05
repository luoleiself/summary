/*
��ϰ��
���ڼ�¼Ӧ�ó����д��������ʹ�ô����ѵ�����ô����ע����ʾ��

�������뵽���ǣ���������
���Ǹü����������ڳ����У����ų�������ж����ڴ��д��ڣ�������������
�������Ÿ�Ӧ�ó�����˳����ü�����Ҳ���ڴ�����ʧ�ˡ�

��һ���������ó��������¿�ʼ��0��������������������Ҫ�ġ�

����ʹ�������ü�������ֵҲ���ڡ�
�´γ��������ڻ��ȼ��ؼ�������ֵ����1�������´洢������
����Ҫ����һ�������ļ������ڼ�¼�������ʹ�ô�����

�������ļ�ʹ�ü�ֵ�Ե���ʽ�����������Ķ����ݣ����������ݡ�

��ֵ��������map���ϡ����������ļ���ʽ�洢��ʹ��IO������
��ôMap+IO����properties��

�����ļ�����ʵ��Ӧ�ó������ݵĹ���
*/
import java.io.*;
import java.util.*;
class  RunCountTest1
{
	public static void main(String[] args) 
	{
		Properties prop = new Properties();

		File file = new File("count.ini");
		if (!file.exists())
		{
			file.createNewFile();
		}

		FileInputStream fis = new FileInputStream(file);

		prop.load(fis);
		
		int count = 0;
		String value = prop.getProperty("time");

		if (value!=null)
		{
			count = Integer.parseInt(value);
			if (count>=5)
			{
				System.out.println("����,ʹ�ô����ѵ�");
				return ;
			}
		}
		count++;
		prop.setProperty("time",count+"");

		FileOutputStream fos = new FileOutputStream(file);

		prop.store(fos,"");
		fis.close();
		fos.close();
	}
}
dom4j : dom  for java
