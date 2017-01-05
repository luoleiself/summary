/*
演示TCP传输
1，TCP分客户端和服务端，
2，客户端对应的是对象是socket。
	服务端对应的对象是serversocket。

客户端：
	通过查阅socket对象，发现在该对象建立时，就可以去连接指定主机。
	因为TCP是面向连接的，所以在建立socket服务时，
	就要有服务端存在，并连接成功，形成通路后，在该通道进行数据的传输。

需求：给服务端发送一个文本数据。

步骤：
	1，创建socket服务，并指定要连接的主机和端口。



*/
import java.io.*;
import java.net.*;
class  TcpClient
{
	public static void main(String[] args) 
	{
		//创建客户端的socket服务，指定目的主机和端口。
		Socket s = new Socket("192.168.1.254",10003);
		
		//为了发送数据，应该获取socket流中的输出流。
		OutputStream out = s.getOutputStream();

		out.write("tcp ge men lai le ".getBytes());

		s,close();
	}
}
/*
需求：定义端点接收数据并打印在控制台上。

服务端：
	1，建立服务端的socket服务。ServerSocket();
		并监听一个端口。
	2，获取连接过来的客户端对象。
		通过ServerSocket的accept方法，没有连接就会等，所以这个方法是阻塞式的。
	3，客户端如果发过来数据，那么服务端要使用对应的客户端对象，并获取该客户端对象的读取流来读取发过来的数据。
		并打印在控制台上，
	4，关闭服务端（可选）
*/
class  TcpServer
{
	public static void main(String[] args) 
	{
		//建立服务端的socket服务，并监听一个端口。
		ServerSocket ss = new ServerSocket(10003);

		//通过accept方法获取连接过来的客户端对象。
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"........connected");

		//获取客户端发送过来的数据，那么要使用客户端对象的读取流来读取数据。
		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));

		s.close();
	}
}