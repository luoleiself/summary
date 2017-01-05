/*
需求：设计一个简单的卖票程序，练习多个线程的知识点。
思路：
	第一种方式；
			1，首先车票的数量是唯一的，卖车票是多个窗口在同时卖票。
			2，可以定义一个车票类继承线程类。
			3，定义车票的数量为一个固定值，并且为静态的。
			4，利用一个循环判断语句，如果车票数量为0时，停止卖票。
	第二种方式：
			1，定义类实现Runable接口。
			2，覆盖Runable接口中的run方法。
				将线程要运行的代码存放到该run方法中。
			3，通过Thread类建立线程对象。
			4，将Runable接口的子类对象作为实际参数传递给Thread类的构造函数。
				为什么要将Runable接口的子类对象传递给Thread的构造函数，因为，
				自定义的run方法所属的对象是Runable接口的子类对象。所以要让线程去执行指定对象的run方法。
				就必须明确该run方法所属的对象。
			5，调用Thread类的start方法开启线程并调用Runable接口子类的方法。

实现方式和继承方式有什么区别？
	实现方式：避免了单继承的局限性，在定义线程时，建议使用实现方式。
	
	继承Thread:线程代码存放在Thread子类run方法中。
	实现Runable:线程代码存放在接口子类的run方法中。

*/
//第一种方式；
class Ticket extends Thread
{
	private static int tick=100;//考察了static关键字的应用。
	public void run()
	{
		while(true)
		{
			if (tick>0)
			{
				System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
			}
		}
	}
}
class  ThreadTest3 
{
	public static void main(String[] args) 
	{
		Ticket t1 = new Ticket();
		Ticket t2 = new Ticket();
		Ticket t3 = new Ticket();
		Ticket t4 = new Ticket();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
/*
总结：
	static关键字的应用：
					成员被static修饰后，变成静态共享成员，生命周期和类一样，存储在栈内存中。
					任何对象都可以调用被static修饰的成员。
*/
//第二种方式：
class Ticket implements Runnable//不是线程。
{
	private  int tick=100;
	public void run()
	{
		while(true)
		{
			if (tick>0)
			{
				System.out.println(Thread.currentThread().getName()+"..sale:"+tick--);
			}
		}
	}
}
class  ThreadTest3 
{
	public static void main(String[] args) 
	{
		Ticket t = new Ticket();
		Thread t1=new Thread(t);//创建一个线程类;
		Thread t2=new Thread(t);//创建一个线程类;
		Thread t3=new Thread(t);//创建一个线程类;
		Thread t4=new Thread(t);//创建一个线程类;
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}