
线程的起动并不是简单的调用了你的RUN方法,而是由一个线程调度器来分别调用你的所有线程的RUN方法,
我们普通的RUN方法如果没有执行完是不会返回的,也就是会一直执行下去,这样RUN方法下面的方法就不可能会执行了,可是线程里的RUN方法却不一样,它只有一定的CPU时间,执行过后就给别的线程了,这样反复的把CPU的时间切来切去,因为切换的速度很快,所以我们就感觉是很多线程在同时运行一样.

你简单的调用run方法是没有这样效果的,所以你必须调用Thread类的start方法来启动你的线程.所以你启动线程有两种方法

一是写一个类继承自Thread类,然后重写里面的run方法,用start方法启动线程。
二是写一个类实现Runnable接口,实现里面的run方法,用new Thread(Runnable target).start()方法来启动。

这两种方法都必须实现RUN方法,这样线程起动的时候,线程管理器好去调用你的RUN方法.

你的TestThread没有继承自Thread类,怎么可能会有start方法呢?


在java中可有两种方式实现多线程，一种是继承Thread类，一种是实现Runnable接口；
Thread类是在java.lang包中定义的。一个类只要继承了Thread类同时覆写了本类中的
run()方法就可以实现多线程操作了，但是一个类只能继承一个父类，这是此方法的局限，

采用继承Thread类方式：
	（1）优点：编写简单，如果需要访问当前线程，无需使用Thread.currentThread()方法，直接使用this，即可获得当前线程。
	（2）缺点：因为线程类已经继承了Thread类，所以不能再继承其他的父类。
采用实现Runnable接口方式：
	（1）优点：线程类只是实现了Runable接口，还可以继承其他的类。在这种方式下，可以多个线程共享同一个目标对象，所以非常适合多个相同线程来处理同一份资源的情况，从而可以将CPU代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。
	（2）缺点：编程稍微复杂，如果需要访问当前线程，必须使用Thread.currentThread()方法。

下面看例子：
package org.thread.demo;
class MyThread extends Thread
{
　　private String name;
　　public MyThread(String name)
	{
　　	super();
　　	this.name = name;
　　}
　　public void run()
	{
　　	for(int i=0;i<10;i++)
		{
　　		System.out.println("线程开始："+this.name+",i="+i);
　　	}
　　}
}
package org.thread.demo;
public class ThreadDemo01
{
　　public static void main(String[] args)
	{
　　	MyThread mt1=new MyThread("线程a");
　　	MyThread mt2=new MyThread("线程b");
		 // thread1，thread2，按顺序进行
　　	mt1.run();
　　	mt2.run();
　　}
}
　　但是，此时结果很有规律，先第一个对象执行，然后第二个对象执行，并没有相互运行。在JDK的文档中可以发现，一旦调用start()方法，则会通过JVM找到run()方法。下面启动
　　start()方法启动线程：
package org.thread.demo;
public class ThreadDemo01 
{
	public static void main(String[] args)
	{
　　	MyThread mt1=new MyThread("线程a");
　　	MyThread mt2=new MyThread("线程b");
　　	//乱序进行
		 mt1.start();
　　	mt2.start();
　　}
}
      这样程序可以正常完成交互式运行。那么为啥非要使用start()方法启动多线程呢？
　　在JDK的安装路径下，src.zip是全部的java源程序，通过此代码找到Thread中的start()方法的定义，可以发现此方法中使用了private native void start0();其中native关键字表示可以调用操作系统的底层函数，那么这样的技术成为JNI技术（java Native Interface）
　　·Runnable接口
　　在实际开发中一个多线程的操作很少使用Thread类，而是通过Runnable接口完成。
　　public interface Runnable{
　　public void run();
　　}
　　例子：
　　package org.runnable.demo;
　　class MyThread implements Runnable{
　　private String name;
　　public MyThread(String name) {
　　this.name = name;
　　}
　　public void run(){
　　for(int i=0;i<100;i++){
　　System.out.println("线程开始："+this.name+",i="+i);
　　}
　　}
　　};

但是在使用Runnable定义的子类中没有start()方法，只有Thread类中才有。此时观察Thread类，有一个构造方法：public Thread(Runnable target)
　　此构造方法接受Runnable的子类实例，也就是说可以通过Thread类来启动Runnable实现的多
　　线程。（start()可以协调系统的资源）:
　　package org.runnable.demo;
　　import org.runnable.demo.MyThread;
　　public class ThreadDemo01 {
　　public static void main(String[] args) {
　　MyThread mt1=new MyThread("线程a");
　　MyThread mt2=new MyThread("线程b");
　　new Thread(mt1).start();
　　new Thread(mt2).start();
　　}
　　}
　　· 两种实现方式的区别和联系：
　　在程序开发中只要是多线程肯定永远以实现Runnable接口为主，因为实现Runnable接口相比
　　继承Thread类有如下好处：
　　->避免点继承的局限，一个类可以继承多个接口。
　　->适合于资源的共享
　　以卖票程序为例，通过Thread类完成：
　　package org.demo.dff;
　　class MyThread extends Thread{
　　private int ticket=10;
　　public void run(){
　　for(int i=0;i<20;i++){
　　if(this.ticket>0){
　　System.out.println("卖票：ticket"+this.ticket--);
　　}
　　}
　　}
　　};
　　下面通过三个线程对象，同时卖票：
　　package org.demo.dff;
　　public class ThreadTicket {
　　public static void main(String[] args) {
　　MyThread mt1=new MyThread();
　　MyThread mt2=new MyThread();
　　MyThread mt3=new MyThread();
　　mt1.start();//每个线程都各卖了10张，共卖了30张票
　　mt2.start();//但实际只有10张票，每个线程都卖自己的票
　　mt3.start();//没有达到资源共享
　　}
　　}
　　如果用Runnable就可以实现资源共享，下面看例子：
　　package org.demo.runnable;
　　class MyThread implements Runnable{
　　private int ticket=10;
　　public void run(){
　　for(int i=0;i<20;i++){
　　if(this.ticket>0){
　　System.out.println("卖票：ticket"+this.ticket--);
　　}
　　}
　　}
　　}
　　package org.demo.runnable;
　　public class RunnableTicket {
　　public static void main(String[] args) {
　　MyThread mt=new MyThread();
　　new Thread(mt).start();//同一个mt，但是在Thread中就不可以，如果用同一
　　new Thread(mt).start();//个实例化对象mt，就会出现异常
　　new Thread(mt).start();
　　}
　　};
　　虽然现在程序中有三个线程，但是一共卖了10张票，也就是说使用Runnable实现多线程可以达到资源共享目的。
　　Runnable接口和Thread之间的联系：
　　public class Thread extends Object implements Runnable
　　发现Thread类也是Runnable接口的子类。
