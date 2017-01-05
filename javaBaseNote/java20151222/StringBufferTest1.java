/*
JDK升级三个因素：
				1，提高效率。
				2，简化书写。
				3，提高安全性。

在机jdk1.5版本之后出现了StringBuilder。
		
		区别：都是一个可变的字符序列。
			StringBuffer是线程同步，用于单线程程序，保证程序的安全性。
			StringBuilder是线程不同步，用于多线程程序，不能保证程序的安全性。
		
将 StringBuilder 的实例用于多个线程是不安全的。如果需要这样的同步，则建议使用 StringBuffer。

方法调用链：sb.append(34).append(true).append(34);

StringBuffer：是字符串缓冲区，是一个容器，被final修饰，不能被继承。
		特点：
			1，而且长度是可变化的，
			2，可以自由操作多个数据类型。
			3，最终会通过toString方法转换成字符串。

CURD： create  update  read  delete

StringBuffer类和StringBuilder类不能操作基本数据类型：short,byte.

构造方法：
		StringBuffer();
				构造一个其中不带字符的字符串缓冲区，初始容量为 16 个字符。
		StringBuffer(CharSequence seq);
				构造一个字符串缓冲区，它包含与指定的 CharSequence 相同的字符。
		StringBuffer(int capacity);
				构造一个不带字符，但具有指定初始容量的字符串缓冲区。
		StringBuffer(String str);
				构造一个字符串缓冲区，并将其内容初始化为指定的字符串内容。
		CURD： create  update  read  delete
			
			1，存储。
				StringBuffer append();将指定数据作为参数添加到已有数据的结尾处。
				StringBuffer insert(index,数据);可以将数据插入指定位置。
			2，删除。
				StringBuffer delete(int start,int end);删除缓冲区中的数据，包含strat不包含end。
				StringBuffer deleteCharAt(index);删除缓冲区中指定位置的字符。
			3，获取。
				int indexOf(String str):返回子字符在字符串中第一次出现的位置。
				char charAt(int index):返回的是字符，参数为整型数据。
				int lastIndexOf(String str);返回指定子字符串在此字符串中最右边出现处的索引。
				int length();
				String substring(gegin,end);//截取字符串。包含头不包含尾。
			4，修改。
				void setCharAt(int index, char ch);替换缓冲区的某一位字符。
				StringBuffer replace(int start, int end, String str);替换缓冲区中的指定字符串，包含strat不包含end。
			5，反转。
				StringBuffer reverse();将缓冲区的字符串进行反转;
			6，将缓冲区中的指定数据存储到指定字符数组中。
				void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin);
				示例：
					StringBuffer sb = new StringBuffer("abcde");
					char [] arr = new char[6];
					sb.getChars(1,4,arr,2);//从字符串角标值1开始读取到角标值为3(不包含end)停止，从字符数组角标值2开始存储到arr字符数组中。

*/
class  StringBufferTest1
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void main(String[] args)
	{
		
	}
	public static void method_getChar()
	{
		StringBuffer sb = new StringBuffer("abcde");
		char [] arr = new char[6];
		
		sb.getChars(1,4,arr,2);//从字符串角标值1开始读取到角标值为3(不包含end)停止，从字符数组角标值2开始存储到arr字符数组中。

		System.out.println("arr["+x+"]"+arr[x]);
	}
	public static void method_add() 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("abcd");

		sb.append(34).append(true).append(34);//方法调用链;

		stringPrint(sb);
	}
	public static void method_insert()
	{	
		StringBuffer sb = new StringBuffer("abcde");
		sb.insert(3,"ggg");//在角标值为3位置插入数据。
		stringPrint(sb);
	}
	public static void method_del_deleteCharAt()
	{
		StringBuffer sb = new StringBuffer("abcde");

		sb.delete(1,3);//删除sb缓冲区的字符bc;

		sb.delete(0,sb.length());//清空缓冲区;

		sb.deleteCharAt(2);//删除sb缓冲区的字符c;
		stringPrint(sb);
	}
	public static void method_setCharAt_replace()
	{
		StringBuffer sb = new StringBuffer("abcde");

		sb.replace(1,4,"ggg");//替换角标值从1开始，4结束不包含4的内容。

		sb.setCharAt(0,'g');//替换角标值为0的内容。

		stringPrint(sb);
	}
}
