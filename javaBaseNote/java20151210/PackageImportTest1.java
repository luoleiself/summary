/*
����Package
	1�����������ļ����з������
	2�������ṩ�������(����)�ռ䡣
	3��д�ڳ����ļ��ĵ�һ�С�
	4��������ȫ�ƣ�����.������
	5����Ҳ��һ�ַ�װ��ʽ��

�����Ķ���ԭ��
				����������Ҫ�ظ�������ʹ��url����ɶ��壬URL��Ψһ�ġ�
				��ʽ��package cn.itcast.pack;

����ʱ��	
		��ʽ��javac  -d . //��ǰĿ¼��Ϊ��  packageTest.java
		��ʽ��javac  -d c:\myclass packageTest.java //��class�ļ���ŵ�C��myclass�ļ��¡�
����ʱ��
		��ʽ��java  pack.packageTest

�ܽ᣺
	1�������֮����з��ʣ������ʵİ��е����Լ����еĳ�Ա����Ҫpublic���Ρ�
	2����ͬ���е����࣬������ֱ�ӷ��ʸ����б�proctectedȨ�����εĳ�Ա��

�����֮�����ʹ�õ�Ȩ�����֣�public  protected
			public	protected	default		private
ͬһ������	  ok		ok		  ok		  ok
ͬһ������	  ok		ok		  ok		 
����		  ok        ok		  
��ͬ����	  ok				  


Ϊ�˼���������д��ʹ��һ���ؼ���import��
���飺��Ҫдͨ���*����Ҫ�õ����е��ĸ���͵����ĸ��࣬������á�


*/
package pack.pack1.pack2.pack3.pack4;//������
import	pack.pack1.pack2.pack3.pack4.*;//�Ǻ�Ϊ�ѵ��뵱ǰĿ¼�����е��ࡣ

public class PackageTest1 
{
	public static void main(String[] args) 
	{
		//pack.pack1.pack2.pack3.pack4.Demo d = new pack.pack1.pack2.pack3.pack4.Demo();
		System.out.println("Hello package!");
	}
}

