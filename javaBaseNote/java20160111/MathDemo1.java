/*
java.lang.Object
	|--java.lang.Math类：最终类
			static double ceil(double a);
					返回最小的（最接近负无穷大）double 值，该值大于等于参数，并等于某个整数。
			static double floor(double a);
					返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数。
			static double exp(double a);
					返回欧拉数 e 的 double 次幂的值。
			static double random();
					返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。
			static double cbrt(double a);
					返回 double 值的立方根。jdk1.5开始。
			static double log(double a);
					返回 double 值的自然对数（底数是 e）。
*/
import java.util.*;
class  MathDemo1
{
	public static void main(String[] args) 
	{
		double d1 = Math.ceil(16.34);
		double d2 = Math.ceil(-16.34);//ceil返回大于指定数据的最小整数。
	
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);

		double d3 = Math.floor(16.34);
		double d4 = Math.floor(-16.34);//floor返回小于于指定数据的最大整数。
	
		System.out.println("d3="+d3);
		System.out.println("d4="+d4);

		double d5 = Math.round(16.34);
		double d6 = Math.round(-16.34);//round四舍五入。
	
		System.out.println("d5="+d5);
		System.out.println("d6="+d6);

		double d7 = Math.pow(16.34);
		double d8 = Math.pow(-16.34);//pow幂运算。
	
		System.out.println("d7="+d7);
		System.out.println("d8="+d8);
	}
	public static void randomMerhod()
	{
		for (int x=0;x<10 ;x++ )
		{
			double d = Math.random();
		}
		System.out.println(d);
	}
}
