/*
通过缓冲区复制一个.java文件。
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
			throw new RuntimeException("读写错误");
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
				throw new RuntimeException("读取关闭失败");
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
				throw new RuntimeException("写入关闭失败");
			}
		}
	}
}
