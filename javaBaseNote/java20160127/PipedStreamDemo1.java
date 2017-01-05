/*
�ܵ�����
PipedInputStream
	�ܵ�������Ӧ�����ӵ��ܵ���������ܵ��������ṩҪд��ܵ�����������������ֽڡ�
	�ֶ�ժҪ�� 
		protected  byte[] buffer; 
				���ô������ݵ�ѭ���������� 
		protected  int in; 
				ѭ����������λ�õ��������������ӵĹܵ�������н��յ���һ�������ֽ�ʱ���Ὣ��洢����λ�á� 
		protected  int out; 
				ѭ����������λ�õ��������˹ܵ����������Ӹ�λ�ö�ȡ��һ�������ֽڡ� 
		protected static int PIPE_SIZE; 
				�ܵ�ѭ�����뻺������Ĭ�ϴ�С��
	���췽��:
		PipedInputStream(); 
				������δ���ӵ� PipedInputStream�� 
		PipedInputStream(int pipeSize); 
				����һ����δ���ӵ� PipedInputStream�����Թܵ�������ʹ��ָ���Ĺܵ���С�� 
		PipedInputStream(PipedOutputStream src); 
				���� PipedInputStream��ʹ�����ӵ��ܵ������ src�� 
		PipedInputStream(PipedOutputStream src, int pipeSize); 
				����һ�� PipedInputStream��ʹ�����ӵ��ܵ������ src�����Թܵ�������ʹ��ָ���Ĺܵ���С�� 
	һ�㷽����
		int available(); 
				���ؿ��Բ��������شӴ��������ж�ȡ���ֽ����� 
		void close(); 
				�رմ˹ܵ����������ͷ��������ص�����ϵͳ��Դ�� 
		void connect(PipedOutputStream src); 
				ʹ�˹ܵ����������ӵ��ܵ������ src�� 
		int read(); 
				��ȡ�˹ܵ��������е���һ�������ֽڡ� 
		int read(byte[] b, int off, int len); 
				����� len �������ֽڴӴ˹ܵ����������� byte ���顣 
		protected  void receive(int b); 
				���������ֽڡ� 
PipedOutputStream
	���췽��: 
		PipedOutputStream(); 
				������δ���ӵ��ܵ��������Ĺܵ�������� 
		PipedOutputStream(PipedInputStream snk); 
				�������ӵ�ָ���ܵ��������Ĺܵ�������� 
  ����ժҪ: 
		 void close(); 
				�رմ˹ܵ���������ͷ�������йص�����ϵͳ��Դ�� 
		 void connect(PipedInputStream snk); 
				���˹ܵ���������ӵ������ߡ� 
		 void flush(); 
				ˢ�´��������ǿ��д�����л��������ֽڡ� 
		 void write(byte[] b, int off, int len); 
				�� len �ֽڴӳ�ʼƫ����Ϊ off ��ָ�� byte ����д��ùܵ�������� 
		 void write(int b); 
				��ָ�� byte д�봫�͵�������� 
*/
import java.io.*;
class Read implements Runnable
{
	private PipedInputStream in;
	Read(PipedInputStream in)
	{
		this.in = in;
	}
	public void run()
	{
		try
		{
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			
			String s = new String(buf,0,len);
			System.out.println(s);
			in.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("�ܵ���ȡ��ʧ��");
		}
	}
}
class Write implements Runnable
{
	private PipedOutputStream out;
	Write(PipedOutputStream out)
	{
		this.out= out;
	}
	public void run()
	{
		try
		{
			out.write("piped lai le".getBytes());//��ȡ�ֽ����顣
			out.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("�ܵ������ʧ��");
		}
	}
}
class PipedStreamDemo1
{
	public static void main(String[] args) 
	{
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);

		Read r = new Read();
		Write w = new Write();

		new thread(r).start();
		new thread(r).start();
	}
}
