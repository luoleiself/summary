/*
��ʾ�ͻ��˺ͷ���ˡ�
1��
�ͻ��ˣ��������Telnet��
����ˣ��Զ���

2��
�ͻ��ˣ������
����ˣ�tomcat

3��
�ͻ��ˣ��Զ���
����ˣ�tomcat



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

		out.println("<font color='red' size='10' >�ͻ������</font>");

		s.close();
		ss.close();
	}
}
