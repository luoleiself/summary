/** 
  取模的规律:取模的余数的符号只和被除数符号相同。
  @author Administrator 
  
  规律：左边如果小于右边，结果是左边

        左边等于右边，结果是0

        右边是1，结果是0
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
