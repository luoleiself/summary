/**
���󣺶����������������ҷֱ������������ֵ���ڲ�ʹ�õ�����������ǰ���£���������������ֵ�������ӡ�������ò�ͬ�ķ�����
˼�룺
����һ��ʹ��������������мӼ��˳�������и�ֵ������
��������ʹ���߼�����������и�ֵ������
���裺
����һ��
1������ʹ��class����һ���࣬����ΪData1��
2������main��������������������int������������a,b�����ֱ������a,b��ֵΪ3,5.
3��������������Ӳ��ѽ����ֵ������a��
4��������a-b��ֵ��ֵb���ٽ�a-b��ֵ��ֵ��a��
5����󽫱���a��b��ֵ�����ӡ������
��������
1�����ȶ�����������c,d�����ֱ��c,d��ֵ��
2��ʹ���߼��������������'^'��c,d�������Ԥ�㲢��ֵ��ֵ��c,
3��ͬ��ʹ����������'^'��c,d�������Ԥ�㲢��ֵ��ֵ��d,
*/
class  Data1 
{       //����һ���࣬����ΪData1,�������ж���һ����������֤����������С�
	public static void main(String[] args)
	{	
		
		int a = 3 , b = 5;  //��������������������������ֵ�����������㣬Ȼ����������
		System.out.println("a="+a+",b="+b);
		a = a + b;
		b = a - b;
		a = a - b;           
		System.out.println("a="+a+",b="+b);
		
		
		int  c = 66 , d = 99;//��������������ʹ����������'^'���и�ֵ�Ľ�����Ȼ����������
		System.out.println("c="+c+",d="+c);
		c = c ^ d; 
		d = c ^ d;//d = ( c ^ d ) ^ d; 
		c = c ^ d;//c = c ^ ( c ^ d );
		System.out.println("c="+c+",d="+d);
		
		System.out.println(Integer.toBinaryString(6));//��ϰʮ����ת�������Ƶ������
		System.out.println(Integer.toBinaryString(-6));
		System.out.println(Integer.toBinaryString(99));
		System.out.println(Integer.toBinaryString(-99));
		
		int i=1000;              //��ϰ����������еĸ��ֽ��Ƶ�ת����
		String binStr=Integer.toBinaryString(i);
		String octStr=Integer.toOctalString(i);
		String hexStr=Integer.toHexString(i);
		
		System.out.println("binStr="+binStr);
		System.out.println("octStr="+octStr);
		System.out.println("hexStr="+hexStr);

		
	}
}