/** 
  ȡģ�Ĺ���:ȡģ�������ķ���ֻ�ͱ�����������ͬ��
  @author Administrator 
  
  ���ɣ�������С���ұߣ���������

        ��ߵ����ұߣ������0

        �ұ���1�������0
 */  
class ModTest
{  
    /** 
      @param args 
     */  
    public static void main(String[] args)
	{  
        test1();  
        test2();  
        test3();  
        test4();  
    }  
    static void test1()
	{  
        int a = -3;  
        int b = 2;  
        System.out.println("(-a % b):"+a%b);  
    }  
    static void test2()
	{  
        int a = -3;  
        int b = -2;  
        System.out.println("(-a % -b):"+a%b);  
    }  
    static void test3()
	{  
        int a = 3;  
        int b = -2;  
        System.out.println("(a % -b):"+a%b);  
    }  
    static void test4()
	{  
        int a = 3;  
        int b = 2;  
        System.out.println("(a % b):"+a%b);  
    }  
}  
