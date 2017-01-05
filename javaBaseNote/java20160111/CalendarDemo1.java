/*
|--java.lang.Object
	|--java.util.Calendar抽象类：
		|--java.util.GregorianCalendar子类：

	方法：
		void add(int field, int amount)；
				根据日历规则，将指定的（有符号的）时间量添加到给定的日历字段中。
		TimeZone getTimeZone()；
				获得时区。
		int get(int field);
				返回给定日历字段的值。
		static Calendar getInstance(TimeZone zone, Locale aLocale);
				使用指定时区和语言环境获得一个日历。
		abstract  void roll(int field, boolean up);
				在给定的时间字段上添加或减去（上/下）单个时间单元，不更改更大的字段。
		void roll(int field, int amount);
				向指定日历字段添加指定（有符号的）时间量，不更改更大的字段。
		void set(int year, int month, int date, int hourOfDay, int minute, int second);
				设置字段 YEAR、MONTH、DAY_OF_MONTH、HOUR、MINUTE 和 SECOND 的值。

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

		String[] month = {"一月","二月","三月","四月","五月","六月",
						  "七月","八月","九月","十月","十一月","十二月"};
		String[] weeks = {"","星期日""星期一","星期二","星期三","星期四","星期五","星期六"};
		
		int index = c.get(Calendar.MONTH);
		int index1 = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(c.get(Calendar.YEAR+"年"));
//		System.out.println((c.get(Calendar.MONTH)+1)+"月");
		System.out.println(month[index]);
//		System.out.println("星期"+c.get(Calendar.DAY_OF_MONTH+"日"));
		System.out.println(c.get(Calendar.DAY_OF_MONTH+"日")); 
		System.out.println(weeks[index1]);
	}
}
/*
运行结果：
		 2016年
		 一月
		 11日
		 星期一
*/