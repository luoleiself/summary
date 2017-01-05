/*
Lock接口:
	Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作。
	此实现允许更灵活的结构，可以具有差别很大的属性，可以支持多个相关的 Condition 对象。

Lock与Synchronized的区别：
	Synchronized方法或语句的使用提供了对与每个对象相关的隐式监视器锁的访问，但却强制所有锁获取和释放均要出现在一个块结构中：
	当获取了多个锁时，它们必须以相反的顺序释放，且必须在与所有锁被获取时相同的词法范围内释放所有锁。

Condition接口：
	Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，
	以便通过将这些对象与任意 Lock 实现组合使用，为每个对象提供多个等待 set（wait-set）。
	其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。

ReentrantLock类：一个可重入的互斥锁 Lock，
				它具有与使用 synchronized 方法和语句所访问的隐式监视器锁相同的一些基本行为和语义，但功能更强大。

Lock方法：
	void lock();
			获取锁。示例：Lock lock = new reentrantLock();
							lock.lock();
	void lockInterruptibly();
			如果当前线程未被中断，则获取锁。
	Condition newCondition();
			返回绑定到此 Lock 实例的新 Condition 实例。示例：Condition condition = lock.newCondition();
	boolean tryLock();
			仅在调用时锁为空闲状态才获取该锁。
	boolean tryLock(long time, TimeUnit unit);
			如果锁在给定的等待时间内空闲，并且当前线程未被中断，则获取锁。	
	void unlock();
			释放锁。

Condition方法：
	void await();
			造成当前线程在接到信号或被中断之前一直处于等待状态。
	boolean await(long time, TimeUnit unit);
			造成当前线程在接到信号、被中断或到达指定等待时间之前一直处于等待状态。
	long awaitNanos(long nanosTimeout);
			造成当前线程在接到信号、被中断或到达指定等待时间之前一直处于等待状态。
	void signal();
			唤醒一个等待线程。
	void signalAll();
			唤醒所有等待线程。
 
在Condition中，用await()替换wait()，用signal()替换notify()，用signalAll()替换notifyAll()，
传统线程的通信方式，Condition都可以实现，这里注意，Condition是被绑定到Lock上的，要创建一个Lock的Condition必须用newCondition()方法。

*/
class BoundedBuffer 
{  
	final Lock lock = new ReentrantLock();//锁对象  
	final Condition notFull  = lock.newCondition();//写线程条件   
	final Condition notEmpty = lock.newCondition();//读线程条件   
  
	final Object[] items = new Object[100];//缓存队列  
	int putptr/*写索引*/, takeptr/*读索引*/, count/*队列中存在的数据个数*/;  
	public static void main(String[] args)
	{

	}
	public void put(Object x) throws InterruptedException
	{  
		lock.lock();  
		try
		{  
			while (count == items.length)//如果队列满了   
			{
				notFull.await();//阻塞写线程 
			} 
			items[putptr] = x;//赋值   
			if (++putptr == items.length)  
			{
				putptr = 0;//如果写索引写到队列的最后一个位置了，那么置为0 
				++count;//个数++ 
			} 
			notEmpty.signal();//唤醒读线程  
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
			while (count == 0)//如果队列为空  
			{
				notEmpty.await();//阻塞读线程  
			}
			Object x = items[takeptr];//取值   
			if (++takeptr == items.length)   
			{
				takeptr = 0;//如果读索引读到队列的最后一个位置了，那么置为0
				--count;//个数--
			}  
			notFull.signal();//唤醒写线程  
			return x;  
		} 
		finally 
		{  
			lock.unlock();  
		}  
   }   
}  
