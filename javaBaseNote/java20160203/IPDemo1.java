/*
�����̣�
	OSi�ο�ģ��
	TCP/IP�ο�ģ��

����ͨѶҪ�أ�
		IP��ַ��
		�˿ںţ�
		����Э�飺
*/
import java.net.*;
class  IPDemo1
{
	public static void main(String[] args)throws Exception
	{
		//�����׳��쳣unKnownHostException
		InetAddress i = InetAddress.getLocalHost();
		
		System.out.println(i.toString());
		System.out.println("address"+i.getHostAddress());
		System.out.println("name"+i.getHostName());

		InetAddress ia = InetAddress.getByName("192.168.1.127");
		System.out.println("address"+ia.getHostAddress());
		System.out.println("name"+ia.getHostName()); 
	}
}
