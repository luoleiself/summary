/*
java.util.Date�ࣺ
	|--java.text.Format�����ࣺ
		|--java.text.DateFormat�����ࣺ
			|--java.text.SimpleDateFormat�����ࣺ	
			
			��ĸ  ���ڻ�ʱ��Ԫ��  ��ʾ  ʾ��  
			G	Era ��־��  Text  AD  
			y  ��  Year  1996; 96  
			M  ���е��·�  Month  July; Jul; 07  
			w  ���е�����  Number  27  
			W  �·��е�����  Number  2  
			D  ���е�����  Number  189  
			d  �·��е�����  Number  10  
			F  �·��е�����  Number  2  
			E  �����е�����  Text  Tuesday; Tue  
			a  Am/pm ���  Text  PM  
			H  һ���е�Сʱ����0-23��  Number  0  
			k  һ���е�Сʱ����1-24��  Number  24  
			K  am/pm �е�Сʱ����0-11��  Number  0  
			h  am/pm �е�Сʱ����1-12��  Number  12  
			m  Сʱ�еķ�����  Number  30  
			s  �����е�����  Number  55  
			S  ������  Number  978  
			z  ʱ��  General time zone  Pacific Standard Time; PST; GMT-08:00  
			Z  ʱ��  RFC 822 time zone  -0800  
	
	���췽����
		SimpleDateFormat()��
				��Ĭ�ϵ�ģʽ��Ĭ�����Ի��������ڸ�ʽ���Ź��� SimpleDateFormat��

		SimpleDateFormat(String pattern);
				�ø�����ģʽ��Ĭ�����Ի��������ڸ�ʽ���Ź��� SimpleDateFormat��

		SimpleDateFormat(String pattern, DateFormatSymbols formatSymbols);
				�ø�����ģʽ�����ڷ��Ź��� SimpleDateFormat��

		SimpleDateFormat(String pattern, Locale locale);
				�ø�����ģʽ�͸������Ի�����Ĭ�����ڸ�ʽ���Ź��� SimpleDateFormat��
	������
		 Date parse(String text, ParsePosition pos);
				�����ַ������ı������� Date��
		 String toPattern();
				�������������ڸ�ʽ��ģʽ�ַ�����
		StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos);
				�������� Date ��ʽ��Ϊ����/ʱ���ַ��������������ӵ������� StringBuffer��
*/
import java.util.*;
import java.text.*;
class  DateDemo1
{
	public static void main(String[] args) 
	{
		Date d = new Date();
		System.out.println(d);
		
		//��ģʽ��װ��SimpleDateFormat�����У�
		SimpleDateFormat sdf = new SimpleDateFormat("yy��mm��rr�� E hh:mm:ss");
		
		//����Format������ģʽ��ʽ��ָ��Date����
		String time = sdf.Format(d);
		System.out.println(time);

	}
}
