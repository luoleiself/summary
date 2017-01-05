/*
字符串： public static final String 字符串类为最终类，不能被继承，字符串类中的方法不能被重写。
		String s = new String();
		String s1 = "";

重点：1，字符串类为最终类，不能被继承，其中的方法不能被重写。
	  2，字符串一旦初始化就不可以被改变。
	  3，字符串有自己的判断方法equals方法，String类重写了Object类中equals方法。
	  4，s1和s2的区别：s1代表内存中有一个对象，s2代表内存中有两个对象。
*/
class  StringDemo
{
	public static void main(String[] args) 
	{
		String s1 = "abc";//s1是一个类类型变量，"abc"是一个对象。
						//字符串最大特点：一旦被初始化就不可以被改变。
		String s2 = new String("abc");
		//区别：
		//s1在内存中有一个对象，
		//s2在内存中有两个对象。

		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));//String类重写了Object类中equals方法。
	}
}
