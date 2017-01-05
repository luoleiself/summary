/*
网络编程：
	OSi参考模型
	TCP/IP参考模型

网络通讯要素：
		IP地址：
		端口号：
		传输协议：
*/
import java.net.*;
class  IPDemo1
{
	public static void main(String[] args)throws Exception
	{
		//容易抛出异常unKnownHostException
		InetAddress i = InetAddress.getLocalHost();
		
		System.out.println(i.toString());
		System.out.println("address"+i.getHostAddress());
		System.out.println("name"+i.getHostName());

		InetAddress ia = InetAddress.getByName("192.168.1.127");
		System.out.println("address"+ia.getHostAddress());
		System.out.println("name"+ia.getHostName()); 
	}
}
