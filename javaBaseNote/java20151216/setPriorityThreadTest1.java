/*
���ȼ�����10����Ĭ��Ϊ5����
toString() Thread���еķ�����ʾ����System.out.println(Thread.toString());
			���ظ��̵߳��ַ�����ʾ��ʽ�������߳����ơ����ȼ����߳��顣

 setPriority(int newPriority) Thread���еķ����������̵߳����ȼ���ʾ����t1.setPriority(Thread.MAX_PRIORITY);
			���������֣�MIN_PRIORITY���߳̿��Ծ��е�������ȼ���
						NORM_PRIORITY��������̵߳�Ĭ�����ȼ���
						MAX_PRIORITY���߳̿��Ծ��е�������ȼ���

yield()	Thread���еķ���.
			��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������̡߳�ʾ����Thread.yield();

*/
class StopThread implements Runnable
{
	int x = 0;
	public  void run()
	{
		while(x<=50)
		{	
			System.out.println(Thread.currentThread().getThrad()+"......run......."+x);//Thread.currentThread().toString()
			x++;
			Thread.yield();
		}
	}
	//public void changeFlag()
	//{
		//flag = false;
	//}
}
class  setPriorityThreadTest1
{
	public static void main(String[] args) 
	{
		StopTread st = new StopThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.start();

		t1.join();

		t2.start();
		
		t1.setPriority(Thread.MAX_PRIORITY);
		
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