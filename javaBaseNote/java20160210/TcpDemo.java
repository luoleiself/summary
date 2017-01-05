/*
��ʾTCP����
1��TCP�ֿͻ��˺ͷ���ˣ�
2���ͻ��˶�Ӧ���Ƕ�����socket��
	����˶�Ӧ�Ķ�����serversocket��

�ͻ��ˣ�
	ͨ������socket���󣬷����ڸö�����ʱ���Ϳ���ȥ����ָ��������
	��ΪTCP���������ӵģ������ڽ���socket����ʱ��
	��Ҫ�з���˴��ڣ������ӳɹ����γ�ͨ·���ڸ�ͨ���������ݵĴ��䡣

���󣺸�����˷���һ���ı����ݡ�

���裺
	1������socket���񣬲�ָ��Ҫ���ӵ������Ͷ˿ڡ�



*/
import java.io.*;
import java.net.*;
class  TcpClient
{
	public static void main(String[] args) 
	{
		//�����ͻ��˵�socket����ָ��Ŀ�������Ͷ˿ڡ�
		Socket s = new Socket("192.168.1.254",10003);
		
		//Ϊ�˷������ݣ�Ӧ�û�ȡsocket���е��������
		OutputStream out = s.getOutputStream();

		out.write("tcp ge men lai le ".getBytes());

		s,close();
	}
}
/*
���󣺶���˵�������ݲ���ӡ�ڿ���̨�ϡ�

����ˣ�
	1����������˵�socket����ServerSocket();
		������һ���˿ڡ�
	2����ȡ���ӹ����Ŀͻ��˶���
		ͨ��ServerSocket��accept������û�����Ӿͻ�ȣ������������������ʽ�ġ�
	3���ͻ���������������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͻ��˶��󣬲���ȡ�ÿͻ��˶���Ķ�ȡ������ȡ�����������ݡ�
		����ӡ�ڿ���̨�ϣ�
	4���رշ���ˣ���ѡ��
*/
class  TcpServer
{
	public static void main(String[] args) 
	{
		//��������˵�socket���񣬲�����һ���˿ڡ�
		ServerSocket ss = new ServerSocket(10003);

		//ͨ��accept������ȡ���ӹ����Ŀͻ��˶���
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"........connected");

		//��ȡ�ͻ��˷��͹��������ݣ���ôҪʹ�ÿͻ��˶���Ķ�ȡ������ȡ���ݡ�
		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));

		s.close();
	}
}