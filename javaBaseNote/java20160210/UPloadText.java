import java.io.*;
import java.net.*;
class  TextClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("192.468.1.254",10006);

		BufferedReader bufr = new BufferedReader(new FileReader("IPDemo.java"));

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		
		
		String line = null;
		while ((line = bufr.readLine())!=null)
		{
			out.println(line);
		}
//		out.println("over");
		s.shutdownOutput();//关闭客户端的输出流，相当于给流中加入一个结束标记-1；

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = bufIn.readLine();
		System.out.println(str);
		
		bufr.close();
		s.close();
	}
}
class  TextServer
{
	public static void main(String[] args) throws Exception
	{
		Socket ss = new Socket(10006);

		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"........connected");

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		PrintWriter out = new PrintWriter(new FileWriter("server.txt"),true);

		String line = null;
		while ((line = bufIn.readLine())!=null)
		{
//			if ("over".equals(line))
//			{
//				break;
//			}
			out.println(line);
		}
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("shang chuan cheng gong ");

		out.close();
		s.close();
		ss.close();
	}
}
