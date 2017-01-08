/*
��дһ���������
�������ݵĲ��ֺͷ����ݵĲ��֣�������������Ҫͬʱִ�С�
�Ǿ���Ҫ�õ����̼߳�����һ���߳̿����գ�һ���߳̿��Ʒ���

��Ϊ�պͷ������ǲ�һ�µģ�����Ҫ��������run��������������������Ҫ��װ����ͬ�����С���
*/
import java.io.*;
import java.net.*;
class Send implements Runnable
{
	private DatagramSocket ds;
	public Send (DatagramSocket ds)
	{
		this.ds = ds;
	}
	public void run()
	{
		try
		{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;

			while ((line = bufr.readLine())!=null)
			{
				if ("886".equals(line))
				{
					break;
				}
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf,length,InetAddress.getByName("192.168.1.255"),10002);

				ds.send(dp);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("���Ͷ�ʧ��");
		}
	}
}
class Rece implements Runnable
{
	private DatagramSocket ds;
	public Rece(private DatagramSocket ds)
	{
		this.ds = ds;
	}
	public void run()
	{
		try
		{
			while (true)
			{
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf,length);
				ds.receive(dp);

				String ip = dp.getAddress().getHostAddress();

				String data = new String(dp.getData(),0,dp.getLength());
				System.out.println(ip+"::"+data);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("���Ͷ�ʧ��");
		}
	}
}
class  ChatDemo
{
	public static void main(String[] args) 
	{
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10002);

		new Thread(new Send(sendSocket())).start();
		new Thread(new Rece(receSocket())).start();
	}
}