/*
java.lang.Object
	|--java.lang.Math�ࣺ������
			static double ceil(double a);
					������С�ģ���ӽ��������double ֵ����ֵ���ڵ��ڲ�����������ĳ��������
			static double floor(double a);
					�������ģ���ӽ��������double ֵ����ֵС�ڵ��ڲ�����������ĳ��������
			static double exp(double a);
					����ŷ���� e �� double ���ݵ�ֵ��
			static double random();
					���ش����ŵ� double ֵ����ֵ���ڵ��� 0.0 ��С�� 1.0��
			static double cbrt(double a);
					���� double ֵ����������jdk1.5��ʼ��
			static double log(double a);
					���� double ֵ����Ȼ������������ e����
*/
import java.util.*;
class  MathDemo1
{
	public static void main(String[] args) 
	{
		double d1 = Math.ceil(16.34);
		double d2 = Math.ceil(-16.34);//ceil���ش���ָ�����ݵ���С������
	
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);

		double d3 = Math.floor(16.34);
		double d4 = Math.floor(-16.34);//floor����С����ָ�����ݵ����������
	
		System.out.println("d3="+d3);
		System.out.println("d4="+d4);

		double d5 = Math.round(16.34);
		double d6 = Math.round(-16.34);//round�������롣
	
		System.out.println("d5="+d5);
		System.out.println("d6="+d6);

		double d7 = Math.pow(16.34);
		double d8 = Math.pow(-16.34);//pow�����㡣
	
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
