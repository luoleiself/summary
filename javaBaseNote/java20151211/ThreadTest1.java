/*
进程：是一个正在执行中的程序。
		每一个进程执行都有一个执行顺序，该顺序是一个执行路径，或者叫一个控制单元。

线程：就是进程中的一个独立的控制单元。
		线程在控制着进程的执行。

一个进程中至少有一个线程。

java JVM 启动的时候会有一个进程java.exe
	该进程中至少有一个线程负责java程序的执行，而且这个线程运行运行的代码存在于main方法中。
	该线程称之为主线程。

扩展：其实更细节的说JVM启动不止一个线程，还启动了垃圾回收机制的线程。

多线程的运行状态：
				1，被创建
						|start()
				2，运行
						|sleep()
						|wait()/notify()
				3，冻结：放弃了执行资格。
					
				4，结束
						|stop()
						|run()运行结束。
				5，临时状态：具有执行资格，但是没有执行权。

问题一：如何在自定义的代码中，自定义一个线程？
		通过对API的查找，java已经提供了对线程这类食物的描述，就是thread类。
	创建线程的第一种方法：继承thread类，重写run方法。
			  第二种方法：实现Runable接口，重写run方法。		   
				1，定义类继承thread类
				2，复写thread类中的run方法。
						目的：将自定义的代码存储到run方法，让线程运行。
				3，调用线程的start方法。
						该方法两个作用：启动线程，调用run方法。

发现运行结果每一次都不同。因为多个线程都获取CPU的执行权，CPU执行到谁，谁就运行。
明确一点，在某一时刻，只能有一个程序在运行(多核除外)。
CPU在坐着快速切换的动作，以达到看上去是同时运行的效果。
我们可以形象的把多线程的运行形容为在互相抢夺CPU的执行权。

问题二：为什么要覆盖run方法呢？
		thread类用于描述线程，该类就定义了一个功能，用于存储线程要运行的代码。该存储功能就是run方法。
		
		也就是说thread类中的run方法是用于存储线程要运行的代码。
*/
class Demo extends Thread 
{
	public void run()
	{
		for (int x=0;x<100;x++)
		{
			System.out.println("Demo run"+x);
		}
	}
}
class  ThreadTest1
{
	public static void main(String[] args) 
	{
		Demo d = new Demo();
		d.start();//开启线程并执行该线程的run方法。
		//d.run();一般对象方法的调用，直接执行Demo类中的run方法。
		for (int x=0;x<100;x++)
		{
			System.out.println("Hello World!"+x);
		}
	}
}
