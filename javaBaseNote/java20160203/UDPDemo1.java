/*
UDP
	1,�����ݼ�Դ��Ŀ�ķ�װ�����ݰ��У�����Ҫ��������
	2,ÿ�����ݰ��Ĵ�С��������64K��
	3,�������ӣ��ǲ��ɿ�Э��
	4,����Ҫ�������ӣ��ٶȿ졣
TCP
	1,�������ӣ��γɴ������ݵ�ͨ����
	2,�������н��д����������䡣
	3,ͨ����������������ӣ��ǿɿ�Э��
	4,���뽨�����ӣ�Ч�ʻ��Ե͡�

Socket
	|--DatagramSocket

����ͨ��UDP���䷽ʽ����һ���������ݷ��ͳ�ȥ��
˼·��
	1������udpsocket����
	2���ṩ���ݣ��������ݷ�װ�����ݰ��С�
	3��ͨ��socket����ķ��͹��ܣ������ݰ�����ȥ��
	4���ر���Դ��
*/
import java.net.*;
class  UDPSend
{
	public static void main(String[] args) throws Exception
	{
		//����udp����ͨ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket();

		//ȷ�����ݣ�����װ�����ݰ���
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.127"),10000);
		
		//ͨ��Socket���񣬽����е����ݰ����ͳ�ȥ��ͨ��send������
		ds.send(dp);

		//�ر���Դ��
		ds.close();		
	}
}
/*
���󣺶���һ��Ӧ�ó������ڽ���UDPЭ�鴫������ݲ�����
˼·��
	1������UDPsocket����ͨ�������һ���ӿڣ���ʵ���Ǹ������������Ӧ�ó��������ֱ�ʶ��
		��������ȷ��Щ���ݹ�����Ӧ�ó�����Դ���
	2������һ�����ݰ�����ΪҪ�洢���յ����ֽ����ݡ�
		��Ϊ���ݰ��ж������и����ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ��
	3��ͨ��socket�����receive���������յ������ݴ����Ѷ���õ����ݰ��С�
	4��ͨ�����ݰ���������й��ܣ�����Щ��ͬ������ȡ������ӡ�ڿ���̨�ϡ�
	5���ر���Դ��

*/
class UDPReceive
{
	public static void main(Strring[] args)
	{
		//����UDPsocket���񣬽����˵㡣
		DatagramSocket ds = new DatagramSocket(10000);
		
		while
		//�������ݰ������ڴ洢���ݡ�
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);

		//ͨ�������receive���������յ����ݴ��뵽���ݰ��С�
		ds.receive(dp);

		//ͨ�����ݰ��ķ���ȡ�����ݡ�
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(),0,dp.getLength());
		int port = dp.getPort();
		System.out.println(ip+"::"+data+"::"+"port");

		//�ر���Դ
		ds.close();
	}
}