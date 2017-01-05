/*
Lock�ӿ�:
	Lock ʵ���ṩ�˱�ʹ�� synchronized ���������ɻ�õĸ��㷺������������
	��ʵ����������Ľṹ�����Ծ��в��ܴ�����ԣ�����֧�ֶ����ص� Condition ����

Lock��Synchronized������
	Synchronized����������ʹ���ṩ�˶���ÿ��������ص���ʽ���������ķ��ʣ���ȴǿ����������ȡ���ͷž�Ҫ������һ����ṹ�У�
	����ȡ�˶����ʱ�����Ǳ������෴��˳���ͷţ��ұ�����������������ȡʱ��ͬ�Ĵʷ���Χ���ͷ���������

Condition�ӿڣ�
	Condition �� Object ������������wait��notify �� notifyAll���ֽ�ɽ�Ȼ��ͬ�Ķ���
	�Ա�ͨ������Щ���������� Lock ʵ�����ʹ�ã�Ϊÿ�������ṩ����ȴ� set��wait-set����
	���У�Lock ����� synchronized ����������ʹ�ã�Condition ����� Object ������������ʹ�á�

ReentrantLock�ࣺһ��������Ļ����� Lock��
				��������ʹ�� synchronized ��������������ʵ���ʽ����������ͬ��һЩ������Ϊ�����壬�����ܸ�ǿ��

Lock������
	void lock();
			��ȡ����ʾ����Lock lock = new reentrantLock();
							lock.lock();
	void lockInterruptibly();
			�����ǰ�߳�δ���жϣ����ȡ����
	Condition newCondition();
			���ذ󶨵��� Lock ʵ������ Condition ʵ����ʾ����Condition condition = lock.newCondition();
	boolean tryLock();
			���ڵ���ʱ��Ϊ����״̬�Ż�ȡ������
	boolean tryLock(long time, TimeUnit unit);
			������ڸ����ĵȴ�ʱ���ڿ��У����ҵ�ǰ�߳�δ���жϣ����ȡ����	
	void unlock();
			�ͷ�����

Condition������
	void await();
			��ɵ�ǰ�߳��ڽӵ��źŻ��ж�֮ǰһֱ���ڵȴ�״̬��
	boolean await(long time, TimeUnit unit);
			��ɵ�ǰ�߳��ڽӵ��źš����жϻ򵽴�ָ���ȴ�ʱ��֮ǰһֱ���ڵȴ�״̬��
	long awaitNanos(long nanosTimeout);
			��ɵ�ǰ�߳��ڽӵ��źš����жϻ򵽴�ָ���ȴ�ʱ��֮ǰһֱ���ڵȴ�״̬��
	void signal();
			����һ���ȴ��̡߳�
	void signalAll();
			�������еȴ��̡߳�
 
��Condition�У���await()�滻wait()����signal()�滻notify()����signalAll()�滻notifyAll()��
��ͳ�̵߳�ͨ�ŷ�ʽ��Condition������ʵ�֣�����ע�⣬Condition�Ǳ��󶨵�Lock�ϵģ�Ҫ����һ��Lock��Condition������newCondition()������

*/
class BoundedBuffer 
{  
	final Lock lock = new ReentrantLock();//������  
	final Condition notFull  = lock.newCondition();//д�߳�����   
	final Condition notEmpty = lock.newCondition();//���߳�����   
  
	final Object[] items = new Object[100];//�������  
	int putptr/*д����*/, takeptr/*������*/, count/*�����д��ڵ����ݸ���*/;  
	public static void main(String[] args)
	{

	}
	public void put(Object x) throws InterruptedException
	{  
		lock.lock();  
		try
		{  
			while (count == items.length)//�����������   
			{
				notFull.await();//����д�߳� 
			} 
			items[putptr] = x;//��ֵ   
			if (++putptr == items.length)  
			{
				putptr = 0;//���д����д�����е����һ��λ���ˣ���ô��Ϊ0 
				++count;//����++ 
			} 
			notEmpty.signal();//���Ѷ��߳�  
		}
		finally 
		{  
			lock.unlock();  
		}  
	}  
	public Object take() throws InterruptedException 
	{  
		lock.lock();  
		try 
		{  
			while (count == 0)//�������Ϊ��  
			{
				notEmpty.await();//�������߳�  
			}
			Object x = items[takeptr];//ȡֵ   
			if (++takeptr == items.length)   
			{
				takeptr = 0;//����������������е����һ��λ���ˣ���ô��Ϊ0
				--count;//����--
			}  
			notFull.signal();//����д�߳�  
			return x;  
		} 
		finally 
		{  
			lock.unlock();  
		}  
   }   
}  
