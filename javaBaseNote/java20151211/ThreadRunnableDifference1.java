
�̵߳��𶯲����Ǽ򵥵ĵ��������RUN����,������һ���̵߳��������ֱ������������̵߳�RUN����,
������ͨ��RUN�������û��ִ�����ǲ��᷵�ص�,Ҳ���ǻ�һֱִ����ȥ,����RUN��������ķ����Ͳ����ܻ�ִ����,�����߳����RUN����ȴ��һ��,��ֻ��һ����CPUʱ��,ִ�й���͸�����߳���,���������İ�CPU��ʱ��������ȥ,��Ϊ�л����ٶȺܿ�,�������Ǿ͸о��Ǻܶ��߳���ͬʱ����һ��.

��򵥵ĵ���run������û������Ч����,������������Thread���start��������������߳�.�����������߳������ַ���

һ��дһ����̳���Thread��,Ȼ����д�����run����,��start���������̡߳�
����дһ����ʵ��Runnable�ӿ�,ʵ�������run����,��new Thread(Runnable target).start()������������

�����ַ���������ʵ��RUN����,�����߳��𶯵�ʱ��,�̹߳�������ȥ�������RUN����.

���TestThreadû�м̳���Thread��,��ô���ܻ���start������?


��java�п������ַ�ʽʵ�ֶ��̣߳�һ���Ǽ̳�Thread�࣬һ����ʵ��Runnable�ӿڣ�
Thread������java.lang���ж���ġ�һ����ֻҪ�̳���Thread��ͬʱ��д�˱����е�
run()�����Ϳ���ʵ�ֶ��̲߳����ˣ�����һ����ֻ�ܼ̳�һ�����࣬���Ǵ˷����ľ��ޣ�

���ü̳�Thread�෽ʽ��
	��1���ŵ㣺��д�򵥣������Ҫ���ʵ�ǰ�̣߳�����ʹ��Thread.currentThread()������ֱ��ʹ��this�����ɻ�õ�ǰ�̡߳�
	��2��ȱ�㣺��Ϊ�߳����Ѿ��̳���Thread�࣬���Բ����ټ̳������ĸ��ࡣ
����ʵ��Runnable�ӿڷ�ʽ��
	��1���ŵ㣺�߳���ֻ��ʵ����Runable�ӿڣ������Լ̳��������ࡣ�����ַ�ʽ�£����Զ���̹߳���ͬһ��Ŀ��������Էǳ��ʺ϶����ͬ�߳�������ͬһ����Դ��������Ӷ����Խ�CPU��������ݷֿ����γ�������ģ�ͣ��Ϻõ���������������˼�롣
	��2��ȱ�㣺�����΢���ӣ������Ҫ���ʵ�ǰ�̣߳�����ʹ��Thread.currentThread()������

���濴���ӣ�
package org.thread.demo;
class MyThread extends Thread
{
����private String name;
����public MyThread(String name)
	{
����	super();
����	this.name = name;
����}
����public void run()
	{
����	for(int i=0;i<10;i++)
		{
����		System.out.println("�߳̿�ʼ��"+this.name+",i="+i);
����	}
����}
}
package org.thread.demo;
public class ThreadDemo01
{
����public static void main(String[] args)
	{
����	MyThread mt1=new MyThread("�߳�a");
����	MyThread mt2=new MyThread("�߳�b");
		 // thread1��thread2����˳�����
����	mt1.run();
����	mt2.run();
����}
}
�������ǣ���ʱ������й��ɣ��ȵ�һ������ִ�У�Ȼ��ڶ�������ִ�У���û���໥���С���JDK���ĵ��п��Է��֣�һ������start()���������ͨ��JVM�ҵ�run()��������������
����start()���������̣߳�
package org.thread.demo;
public class ThreadDemo01 
{
	public static void main(String[] args)
	{
����	MyThread mt1=new MyThread("�߳�a");
����	MyThread mt2=new MyThread("�߳�b");
����	//�������
		 mt1.start();
����	mt2.start();
����}
}
      �����������������ɽ���ʽ���С���ôΪɶ��Ҫʹ��start()�����������߳��أ�
������JDK�İ�װ·���£�src.zip��ȫ����javaԴ����ͨ���˴����ҵ�Thread�е�start()�����Ķ��壬���Է��ִ˷�����ʹ����private native void start0();����native�ؼ��ֱ�ʾ���Ե��ò���ϵͳ�ĵײ㺯������ô�����ļ�����ΪJNI������java Native Interface��
������Runnable�ӿ�
������ʵ�ʿ�����һ�����̵߳Ĳ�������ʹ��Thread�࣬����ͨ��Runnable�ӿ���ɡ�
����public interface Runnable{
����public void run();
����}
�������ӣ�
����package org.runnable.demo;
����class MyThread implements Runnable{
����private String name;
����public MyThread(String name) {
����this.name = name;
����}
����public void run(){
����for(int i=0;i<100;i++){
����System.out.println("�߳̿�ʼ��"+this.name+",i="+i);
����}
����}
����};

������ʹ��Runnable�����������û��start()������ֻ��Thread���в��С���ʱ�۲�Thread�࣬��һ�����췽����public Thread(Runnable target)
�����˹��췽������Runnable������ʵ����Ҳ����˵����ͨ��Thread��������Runnableʵ�ֵĶ�
�����̡߳���start()����Э��ϵͳ����Դ��:
����package org.runnable.demo;
����import org.runnable.demo.MyThread;
����public class ThreadDemo01 {
����public static void main(String[] args) {
����MyThread mt1=new MyThread("�߳�a");
����MyThread mt2=new MyThread("�߳�b");
����new Thread(mt1).start();
����new Thread(mt2).start();
����}
����}
������ ����ʵ�ַ�ʽ���������ϵ��
�����ڳ��򿪷���ֻҪ�Ƕ��߳̿϶���Զ��ʵ��Runnable�ӿ�Ϊ������Ϊʵ��Runnable�ӿ����
�����̳�Thread�������ºô���
����->�����̳еľ��ޣ�һ������Լ̳ж���ӿڡ�
����->�ʺ�����Դ�Ĺ���
��������Ʊ����Ϊ����ͨ��Thread����ɣ�
����package org.demo.dff;
����class MyThread extends Thread{
����private int ticket=10;
����public void run(){
����for(int i=0;i<20;i++){
����if(this.ticket>0){
����System.out.println("��Ʊ��ticket"+this.ticket--);
����}
����}
����}
����};
��������ͨ�������̶߳���ͬʱ��Ʊ��
����package org.demo.dff;
����public class ThreadTicket {
����public static void main(String[] args) {
����MyThread mt1=new MyThread();
����MyThread mt2=new MyThread();
����MyThread mt3=new MyThread();
����mt1.start();//ÿ���̶߳�������10�ţ�������30��Ʊ
����mt2.start();//��ʵ��ֻ��10��Ʊ��ÿ���̶߳����Լ���Ʊ
����mt3.start();//û�дﵽ��Դ����
����}
����}
���������Runnable�Ϳ���ʵ����Դ�������濴���ӣ�
����package org.demo.runnable;
����class MyThread implements Runnable{
����private int ticket=10;
����public void run(){
����for(int i=0;i<20;i++){
����if(this.ticket>0){
����System.out.println("��Ʊ��ticket"+this.ticket--);
����}
����}
����}
����}
����package org.demo.runnable;
����public class RunnableTicket {
����public static void main(String[] args) {
����MyThread mt=new MyThread();
����new Thread(mt).start();//ͬһ��mt��������Thread�оͲ����ԣ������ͬһ
����new Thread(mt).start();//��ʵ��������mt���ͻ�����쳣
����new Thread(mt).start();
����}
����};
������Ȼ���ڳ������������̣߳�����һ������10��Ʊ��Ҳ����˵ʹ��Runnableʵ�ֶ��߳̿��Դﵽ��Դ����Ŀ�ġ�
����Runnable�ӿں�Thread֮�����ϵ��
����public class Thread extends Object implements Runnable
��������Thread��Ҳ��Runnable�ӿڵ����ࡣ
