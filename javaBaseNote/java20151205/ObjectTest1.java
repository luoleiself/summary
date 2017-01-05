/*
object:是所有对象的直接后者间接父亲，传说的上帝。
	   该类中定义的肯定是所有对象都具备的方法，

Object 类中已经提供了对对象是否相同的比较方法equals();
如果自定义类中也有比较相同的方法，没有必要重新定义。
只要沿袭父类中的方法，建立自己特有比较内容即可，这就是重写(覆盖)。

Object方法：
			boolean equals(Object obj);
						指示其他某个对象是否与此对象“相等”。
			Class<?> getClass();
						返回此 Object 的运行时类。
			int hashCode();
						返回该对象的哈希码值。
			void notify();
						唤醒在此对象监视器上等待的单个线程。
			void notifyAll();
						唤醒在此对象监视器上等待的所有线程。
			String toString();
						返回该对象的字符串表示。
			void wait();
						在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
			void wait(long timeout);
						在其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过指定的时间量前，导致当前线程等待。
			void wait(long timeout, int nanos);
						在其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量前，导致当前线程等待。						
			
对象方法 String getName();  
						以 String 的形式返回此 Class 对象所表示的实体（类、接口、数组类、基本类型或 void）名称。
对象方法 Method getMethod(String name, Class<?>... parameterTypes); 
						返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。
*/
class Demo//extends Object
{
	//此类中包含了一个系统给的隐藏的构造函数。
}
class  ObjectTest1
{
	public static void main(String[] args) 
	{
		Demo d = new Demo();
		System,.out.println(getClass().getName() +'@'+ Integer.toHexString(hashCode(d)));
		System.out.println("Hello World!");
	}
}
