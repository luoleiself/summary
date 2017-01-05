/*
演示客户端和服务端。
1，
客户端：浏览器（Telnet）
服务端：自定义

2，
客户端：浏览器
服务端：tomcat

3，
客户端：自定义
服务端：tomcat



*/
import java.io.*;
import java.net.*;
class  ServerDemo
{
	public static void main(String[] args) 
	{
		ServerSocket ss = new ServerSocket(11100);

		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress());

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);
		System.out.println(new String(buf,0,len));

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		out.println("<font color='red' size='10' >客户端你好</font>");

		s.close();
		ss.close();
	}
}
