/*
equals方法：
			1，如果是基本类型比较，那么只能用==来比较，不能用equals。
			2，对于基本类型的包装类型，比如Boolean、Character、Byte、Shot、Integer、Long、Float、Double等的引用变量，
				==是比较地址的，而equals是比较内容的。
			3，注意：对于String(字符串)、StringBuffer(线程安全的可变字符序列)、StringBuilder(可变字符序列)这三个类作进一步的说明:
				1,String中，==比较的是地址值，equals方法比较的是内容。
				2,StringBuffer中没有重新定义equals这个方法，因此这个方法就来自Object类，而Object类中的equals方法是用来比较“地址”的。
				3,StringBuilder中没有重新定义equals这个方法，因此这个方法就来自Object类，而Object类中的equals方法是用来比较“地址”的。
*/
class  EqualsDemo
{
	public static void main(String[] args) 
	{
		int a = 3; 
		int b = 4; 
		int c = 3; 
		System.out.println(a == b);		//结果是false 
		System.out.println(a == c);		//结果是true 
		System.out.println(a.equals(c));//错误，编译不能通过，equals方法不能运用与基本类型的比较 

		//=============================================================

		Integer n1 = new Integer(30); 
		Integer n2 = new Integer(30); 
		Integer n3 = new Integer(31); 
		System.out.println(n1 == n2);//结果是false,两个不同的Integer对象，故其地址不同， 
		System.out.println(n1 == n3);//结果是false,那么不管是new Integer(30)还是new Integer(31) 结果都显示false 
		System.out.println(n1.equals(n2));//结果是true 根据jdk文档中的说明，n1与n2指向的对象中的内容是相等的，都是30，故equals比较后结果是true 
		System.out.println(n1.equals(n3));//结果是false 因对象内容不一样，一个是30一个是31。

		//===============================================================

		String s1 = "123"; 
		String s2 = "123"; 
		String s3 = "abc"; 
		String s4 = new String("123"); 
		String s5 = new String("123"); 
		String s6 = new String("abc"); 

		System.out.println(s1 == s2);		//（1）true 
		System.out.println(s1.equals(s2));	//（2）true 
		System.out.println(s1 == s3);		//（3）flase 
		System.out.println(s1.equals(s3));	//（4）flase 

		System.out.println(s4 == s5);		//（5）flase 
		System.out.println(s4.equals(s5));	//（6）true 
		System.out.println(s4 == s6);		//（7）flase 
		System.out.println(s4.equals(s6));	//（8）flase 

		System.out.println(s1 == s4);		//（9）false 
		System.out.println(s1.equals(s4));	//（10）true 
	}
}
