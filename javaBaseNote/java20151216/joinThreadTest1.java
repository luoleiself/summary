/*
setDaeMon(boolean on)����̨�߳�
			�����̱߳��Ϊ�ػ��̻߳��û��̡߳����������е��̶߳����ػ��߳�ʱ��Java ������˳���
			�÷��������������߳�ǰ���á� 
			�÷������ȵ��ø��̵߳� checkAccess �������Ҳ����κβ�����������׳� SecurityException���ڵ�ǰ�߳��У���

join()	����CPUִ��Ȩ���׳��쳣InterruptedException��
		�ȴ����߳���ֹ������κ��߳��ж��˵�ǰ�̡߳����׳����쳣ʱ����ǰ�̵߳��ж�״̬ �������
		
		��A�߳�ִ�е���B�̵߳�.join()����ʱ��A�ͻ�ȴ�����B�߳�ִ���꣬A�Ż�ִ�С�
		join����������ʱ�����ֳ�ִ�С�
*/
class StopThread implements Runnable
{
	int x = 0;
	public  void run()
	{
		while(x<=50)
		{	
			System.out.println(Thread.currentThread().getThrad()+"......run......."+x);
			x++;
		}
	}
	//public void changeFlag()
	//{
		//flag = false;
	//}
}
class  joinThreadTest1
{
	public static void main(String[] args) 
	{
		StopTread st = new StopThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.start();

		t1.join();

		t2.start();
		
		int x = 0;
		while(x<=50)
		{
			//if (x==25)
			//{
				//st.changeFlag();
				//st.setDaeMon();
				//break;
			//}
			System.out.println(Thread.currentThread().getThrad()+"......main......"+x);
		}
	}
}
