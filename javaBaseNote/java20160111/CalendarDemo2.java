/*
Caldendar����:
		void set(int year, int month, int date, int hourOfDay, int minute);
				���������ֶ� YEAR��MONTH��DAY_OF_MONTH��HOUR_OF_DAY �� MINUTE ��ֵ��
		abstract  void add(int field, int amount);
				���������Ĺ���Ϊ�����������ֶ���ӻ��ȥָ����ʱ������
*/
import java.util.*;
class  CalendarDemo2
{
	public static void main(String[] args) 
	{
		Calendar c = Calendar.getInstance();

		c.set(2012,2,26);
		c.add(Calendar.MONTH,4);
	}
	public static void pirntCalendar(Calendar c)
	{
		Calendar c = Calendar.getInstance();

		String[] month = {"һ��","����","����","����","����","����",
						  "����","����","����","ʮ��","ʮһ��","ʮ����"};
		String[] weeks = {"","������""����һ","���ڶ�","������","������","������","������"};
		
		int index = c.get(Calendar.MONTH);
		int index1 = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(c.get(Calendar.YEAR+"��"));
//		System.out.println((c.get(Calendar.MONTH)+1)+"��");
		System.out.println(month[index]);
//		System.out.println("����"+c.get(Calendar.DAY_OF_MONTH+"��"));
		System.out.println(c.get(Calendar.DAY_OF_MONTH+"��")); 
		System.out.println(weeks[index1]);
	}
}
