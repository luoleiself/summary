/* 
if��䶨���ʽ��
if���ж�������
{   
	�������1��
} 
else 
{   
	�������2��
} 

switch��䶨���ʽ��
switch������ʽ��
{  
	case ѡ��ֵ1��
		�������1��             
		break�� 
	case ѡ��ֵ2��
		�������2��				
		break�� 
		����   
	case ѡ��ֵn��
		�������n��                 
		break��  
	default: 
		�������;
		break;
}

while��䶨���ʽ��
while���ж�������
{   
	���1��  
	���2��
	����  
	���n��
} 

do while��䶨���ʽ��
do 
{   
	���1��  
	���2�� 
	����   
	���n�� 
}
while���ж�������;

for��䶨���ʽ��
for (��ʼ�����; �������; �������) 
{ 
���1 ; 
���2 ; 
.... 

���n ; 
} 
*/
/*
�κ���ϰһ����1-1000�е�3�ı����ĺͣ�ͬʱ��3�ı����ĸ�������ϰfor��while�ò�ͬ������⡣
�κ���ϰ����ʹ��Ƕ��ѭ���������ϰ��������������;��󣬻������ε������ߵݼ��������֡�
˼·��
1,��1-1000�е�3�ı����ĸ�����Ҫ�õ��ۼ�˼��ͼ�����˼�룬Ҳ������Ҫ�õ�ѭ�������;
2,����ʹ��forѭ����䶨��һ��ѭ���壬�������3�ı�����Ҫ�õ�if�������ж��ܱ�3��������;
3,����3�ı����ĸ���ͬʱ��Ҫ�õ�һ����������ͳ�ơ�
*/
class  Test1
{ 
	public static void main(String[] args)
	{	
		/*
		  �κ���ϰһ��
		  ʹ��forѭ���Ժ����1000����3�ı����ĺͣ���ͳ�Ƹ���;
		  ����һ��
		*/
		int count=0,sum=0;
		for(int a=1;a<=1000;a++)
		{
			if(a%3==0)//a��3ȡģ����0֤���ܱ�3����;
			{
				count++;
				sum=sum+a;
			}
		}
		System.out.println("��for�����1000����3�ı����ĺ�Ϊ��"+sum);
		System.out.println("��for�����1000����3�ı����ĸ���Ϊ��"+count);
		System.out.println("--------------------------------------");
		
		//��Ȼʹ��while���Ҳ����ʵ�����Ϲ��ܣ��������������ֱ�洢����ĺͣ���������������
		//��������
		int count1=0,sum1=0,b=1;
		while(b<=1000)
		{
			if (b%3==0)//a��3ȡģ����0֤���ܱ�3����;
			{
				sum1=sum1+b;
				count1++;
			}
			b++;//ע�����ѭ�������ı�����λ��;
		}
		System.out.println("��while�����1000����3�ı����ĺ�Ϊ��"+sum1);
		System.out.println("��while�����1000����3�ı����ĸ���Ϊ��"+count1);
		System.out.println("--------------------------------------");

		/*
		��Ȼʹ��do while ���Ҳ����ʵ�����Ϲ���,
		�ܽ᣺
		for����while��������
		1,������������ͬ��forѭ������ж���ı���ֻ��ѭ��������Ч��ѭ���������ڴ潫���ͷű�����
		2,for����while�����Խ��л����������Ҫ������ʱ�Ե�ѭ��������ʹ��for�������ʡ�
		*/

		//�κ���ϰ����������������;��󣬻������ε������ߵݼ���������;
		for (int a1=0;a1<6;a1++)//��ѭ�����Ƴ������������;
		{
			for (int b1=0;b1<6;b1++)//��ѭ�����Ƴ��������ÿһ�еĴ�ӡ�����ݵĸ���;
			{
				System.out.print("*");//һ��ע�⣺�˴�û��ʹ��ת���ַ����л���;
			}
			System.out.println();
		}
		System.out.println("---------------------------------------");

		//������ε�����������;
		for (int a2=1;a2<=6;a2++)
		{
			for (int b2=1;b2<=a2;b2++)
			{
				System.out.print("*");//һ��ע�⣺�˴�û��ʹ��ת���ַ����л���;
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");

		//������εݼ���������;
		for (int a2=1;a2<=6;a2++)
		{
			for (int b2=a2;b2<=6;b2++)//Ҳ����ʹ��for (int b2=6;b2>=a2;b2--);
			{
				System.out.print("*");//һ��ע�⣺�˴�û��ʹ��ת���ַ����л���;
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");

		/*
		���ǹ��ɵĹ��ɣ����Ǹı���ѭ��;
		�⳯�ϣ��ı�������������������ѭ���仯;

		�⳯�£��ı��ʼ��ֵ���ó�ʼ��ֵ������ѭ���仯;
		*/
	}
}