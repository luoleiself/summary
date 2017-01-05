/*
JDK1.5版本以后出现的新特性：
	面试知识点：
		Integer m = 128;
		Integer n = 128;
		stringPrint("m==n:"+(m==n));//结果为false，

		Integer a = 127;
		Integer b = 127;
		stringPrint("a==b:"+(a==b));//结果为true，因为a和b指向了同一个Integer对象，
									//因为当数值在byte范围内中，对于新特性，如果该数值已经存在，则不会开辟的新的空间。
*/
class  IntegerTest1
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void method()
	{
		Integer x = new Integer("123");

		Integer y = new Integer(123);

		stringPrint("x==y:"+(x==y));//答案是false，比较两个数值。
		stringPrint("x.equals(y):"+x.equals(y));//答案是true，这个比较的是两个对象。
	}
	public static void main(String[] args) 
	{
		Integer x = new Integer(4);
		Integer x = 4;//自动装箱;Integer x = new Integer(4);

		x = x + 2;//x 进行了自动拆箱，变成了int类型，和2进行加法运算，然后再将和进行装箱赋给x。
		//x = x.intValue() + 2;
		
		Integer m = 128;
		Integer n = 128;
		stringPrint("m==n:"+(m==n));//结果为false。

		Integer a = 127;
		Integer b = 127;
		stringPrint("a==b:"+(a==b));//结果为true，因为a和b指向了同一个Integer对象，
									//因为当数值在byte范围内中，对于新特性，如果该数值已经存在，则不会开辟的新的空间。
	}
}
