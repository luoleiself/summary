/*
UDP
	1,将数据及源和目的封装成数据包中，不需要建立连接
	2,每个数据包的大小都限制在64K内
	3,因无连接，是不可靠协议
	4,不需要建立连接，速度快。
TCP
	1,建立连接，形成传输数据的通道。
	2,在连接中进行大数据量传输。
	3,通过三次握手完成连接，是可靠协议
	4,必须建立连接，效率会稍低。

Socket
	|--DatagramSocket

需求：通过UDP传输方式，将一段文字数据发送出去。
思路：
	1，建立udpsocket服务。
	2，提供数据，并将数据封装到数据包中。
	3，通过socket服务的发送功能，将数据包发出去。
	4，关闭资源。
*/
import java.net.*;
class  UDPSend
{
	public static void main(String[] args) throws Exception
	{
		//创建udp服务，通过DatagramSocket对象。
		DatagramSocket ds = new DatagramSocket();

		//确定数据，并封装成数据包。
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.127"),10000);
		
		//通过Socket服务，将已有的数据包发送出去，通过send方法，
		ds.send(dp);

		//关闭资源；
		ds.close();		
	}
}
/*
需求：定义一个应用程序，用于接收UDP协议传输的数据并处理
思路：
	1，定义UDPsocket服务，通常会监听一个接口，其实就是给这个接收网络应用程序定义数字标识。
		方便于明确哪些数据过来该应用程序可以处理。
	2，定义一个数据包，因为要存储接收到的字节数据。
		因为数据包中对象中有更多能可以提取字节数据中的不同数据信息。
	3，通过socket服务的receive方法将接收到的数据存入已定义好的数据包中。
	4，通过数据包对象的特有功能，将这些不同的数据取出，打印在控制台上。
	5，关闭资源。

*/
class UDPReceive
{
	public static void main(Strring[] args)
	{
		//创建UDPsocket服务，建立端点。
		DatagramSocket ds = new DatagramSocket(10000);
		
		while
		//定义数据包，用于存储数据。
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);

		//通过服务的receive方法将接收到数据存入到数据包中。
		ds.receive(dp);

		//通过数据包的方法取出数据。
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(),0,dp.getLength());
		int port = dp.getPort();
		System.out.println(ip+"::"+data+"::"+"port");

		//关闭资源
		ds.close();
	}
}