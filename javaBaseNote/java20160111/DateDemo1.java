/*
java.util.Date类：
	|--java.text.Format抽象类：
		|--java.text.DateFormat抽象类：
			|--java.text.SimpleDateFormat抽象类：	
			
			字母  日期或时间元素  表示  示例  
			G	Era 标志符  Text  AD  
			y  年  Year  1996; 96  
			M  年中的月份  Month  July; Jul; 07  
			w  年中的周数  Number  27  
			W  月份中的周数  Number  2  
			D  年中的天数  Number  189  
			d  月份中的天数  Number  10  
			F  月份中的星期  Number  2  
			E  星期中的天数  Text  Tuesday; Tue  
			a  Am/pm 标记  Text  PM  
			H  一天中的小时数（0-23）  Number  0  
			k  一天中的小时数（1-24）  Number  24  
			K  am/pm 中的小时数（0-11）  Number  0  
			h  am/pm 中的小时数（1-12）  Number  12  
			m  小时中的分钟数  Number  30  
			s  分钟中的秒数  Number  55  
			S  毫秒数  Number  978  
			z  时区  General time zone  Pacific Standard Time; PST; GMT-08:00  
			Z  时区  RFC 822 time zone  -0800  
	
	构造方法：
		SimpleDateFormat()；
				用默认的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。

		SimpleDateFormat(String pattern);
				用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。

		SimpleDateFormat(String pattern, DateFormatSymbols formatSymbols);
				用给定的模式和日期符号构造 SimpleDateFormat。

		SimpleDateFormat(String pattern, Locale locale);
				用给定的模式和给定语言环境的默认日期格式符号构造 SimpleDateFormat。
	方法：
		 Date parse(String text, ParsePosition pos);
				解析字符串的文本，生成 Date。
		 String toPattern();
				返回描述此日期格式的模式字符串。
		StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos);
				将给定的 Date 格式化为日期/时间字符串，并将结果添加到给定的 StringBuffer。
*/
import java.util.*;
import java.text.*;
class  DateDemo1
{
	public static void main(String[] args) 
	{
		Date d = new Date();
		System.out.println(d);
		
		//将模式封装到SimpleDateFormat对象中；
		SimpleDateFormat sdf = new SimpleDateFormat("yy年mm月rr日 E hh:mm:ss");
		
		//调用Format方法让模式格式化指定Date对象。
		String time = sdf.Format(d);
		System.out.println(time);

	}
}
