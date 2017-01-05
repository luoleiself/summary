/**
需求：定义两个变量，并且分别给两个变量赋值，在不使用第三方变量的前提下，交换两个变量的值并输出打印出来，用不同的方法。
思想：
方法一：使用算术运算符进行加减乘除运算进行赋值交换。
方法二：使用逻辑运算符异或进行赋值交换。
步骤：
方法一：
1、首先使用class定义一个类，类名为Data1，
2、定义main主函数，在主函数中用int定义两个变量a,b，并分别给变量a,b赋值为3,5.
3、将两个变量相加并把结果赋值给变量a，
4、将变量a-b的值赋值b，再将a-b的值赋值给a，
5、最后将变量a和b的值输出打印出来。
方法二：
1、首先定义两个变量c,d，并分别给c,d赋值。
2、使用逻辑运算符异或运算符'^'对c,d进行异或预算并将值赋值给c,
3、同上使用异或运算符'^'对c,d进行异或预算并将值赋值给d,
*/
class  Data1 
{       //定义一个类，类名为Data1,并在类中定义一个主函数保证类的正常运行。
	public static void main(String[] args)
	{	
		
		int a = 3 , b = 5;  //定义两个变量，将两个变量的值进行算术运算，然后输出结果。
		System.out.println("a="+a+",b="+b);
		a = a + b;
		b = a - b;
		a = a - b;           
		System.out.println("a="+a+",b="+b);
		
		
		int  c = 66 , d = 99;//定义两个变量，使用异或运算符'^'进行赋值的交换，然后输出结果。
		System.out.println("c="+c+",d="+c);
		c = c ^ d; 
		d = c ^ d;//d = ( c ^ d ) ^ d; 
		c = c ^ d;//c = c ^ ( c ^ d );
		System.out.println("c="+c+",d="+d);
		
		System.out.println(Integer.toBinaryString(6));//练习十进制转换二进制的输出；
		System.out.println(Integer.toBinaryString(-6));
		System.out.println(Integer.toBinaryString(99));
		System.out.println(Integer.toBinaryString(-99));
		
		int i=1000;              //练习计算机语言中的各种进制的转换；
		String binStr=Integer.toBinaryString(i);
		String octStr=Integer.toOctalString(i);
		String hexStr=Integer.toHexString(i);
		
		System.out.println("binStr="+binStr);
		System.out.println("octStr="+octStr);
		System.out.println("hexStr="+hexStr);

		
	}
}