/*
ͨ������������һ��.java�ļ���
*/
class  CopyTextByBuffTest1
{
	public static void main(String[] args) 
	{
		BufferedWriter bufw = null;
		BufferedReader bufr = null;

		try
		{
			bufr = new BufferedReader(new FileReader("Demo.text"));
			bufw = new BufferedWriter(new FileWriter("Demo_Copy.text"));

			String line = null;

			while ((line = bufr.readLine())!=null)
			{
				bufw.write(line);
				bufw.newLine();
				bufw.flush();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("��д����");
		}
		finally
		{
			try
			{
				if (bufr!=null)
				{
					bufr.close();
				}
			}
			catch (IOException e)
			{
				throw new RuntimeException("��ȡ�ر�ʧ��");
			}
			try
			{
				if (bufw!=null)
				{
					bufw.close();
				}
			}
			catch (IOException e)
			{
				throw new RuntimeException("д��ر�ʧ��");
			}
		}
	}
}
