/*
|--java.lang.Object
	|--java.util.Calendar�����ࣺ
		|--java.util.GregorianCalendar���ࣺ

	������
		void add(int field, int amount)��
				�����������򣬽�ָ���ģ��з��ŵģ�ʱ������ӵ������������ֶ��С�
		TimeZone getTimeZone()��
				���ʱ����
		int get(int field);
				���ظ��������ֶε�ֵ��
		static Calendar getInstance(TimeZone zone, Locale aLocale);
				ʹ��ָ��ʱ�������Ի������һ��������
		abstract  void roll(int field, boolean up);
				�ڸ�����ʱ���ֶ�����ӻ��ȥ����/�£�����ʱ�䵥Ԫ�������ĸ�����ֶΡ�
		void roll(int field, int amount);
				��ָ�������ֶ����ָ�����з��ŵģ�ʱ�����������ĸ�����ֶΡ�
		void set(int year, int month, int date, int hourOfDay, int minute, int second);
				�����ֶ� YEAR��MONTH��DAY_OF_MONTH��HOUR��MINUTE �� SECOND ��ֵ��

*/
import java.util.*;
import java.text.*;
class  CalendarDemo1
{
	public static void main(String[] args) 
	{
//		SimpleDateFormat sdf = new 	SimpleDateFormat("yyyy");
//		
//		String year = sdf.format();
//		System.out.println(year);

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
/*
���н����
		 2016��
		 һ��
		 11��
		 ����һ
*/