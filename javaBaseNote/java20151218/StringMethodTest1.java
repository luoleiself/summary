/*
String类适用于描述字符串事物，那么它就提供了多个方法对字符串进行操作。
常见的操作：
		1，获取：
			1.1，字符串中包含的字符数，也就是字符串的长度。
					int length()：获取字符串的长度。	
			1.2，根据位置获取位置上的某个字符。
					char charAt(int index):返回的是字符，参数为整型数据。		
			1.3，根据字符获取该字符在字符串中的位置。
					int indexOf(int ch):返回的是ch在字符串中第一次出现的位置。
					int indexOf(int ch, int fromIndex):从fromIndex指定位置开始，获取ch在字符串中出现的位置。
					示例：
					int indexOf(String str):返回的是子字符在字符串中第一次出现的位置。
					int indexOf(String str, int fromIndex):从fromIndex指定位置开始，获取子字符在字符串中出现的位置。
			1.4，根据字符获取该字符在字符串中的位置。
					int lastIndexOf(int ch);
							返回指定字符在此字符串中最后一次出现处的索引。	
					int lastIndexOf(int ch,int fromIndex);
							返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。
					int lastIndexOf(String str);
							返回指定子字符串在此字符串中最右边出现处的索引。
					int lastIndexOf(String str,int fromIndex);
							返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。
		2，判断：
			2.1，字符串中是否包含某一个子串。
					boolean contains(CharSequence s);当且仅当此字符串包含指定的 char 值序列时，返回 true。
					特殊之处：indexOf(str):可以索引str第一次出现位置，如果返回-1，表示该str不在字符串中存在。
							所以，也可以用于对指定判断是否包含。而且该方法既可以判断，又可以获取出现的位置。
			2.2，字符串中是否有内容。
					boolean isEmpty();原理就是判断长度是否为0，"" null
			2.3，字符串是否以指定内容开头。
					boolean startsWith(str);
			2.4，字符串是否以指定内容结尾。
					boolean endsWith(str);
			2.5，判断内容是否相同，并忽略大小写。
					boolean equalsIgnoreCase();
			2.6，判断两个字符串的大小，不区部分大小写。
					boolean equalsToIgnoreCase(String str);按字典顺序比较两个字符串，不考虑大小写。
		3，转换：
			3.1，将字符数组转换成字符串。
					构造函数：String(char[]);
							  String(char[],int offset,int count);将字符数组中的一部分字符转换成字符串。				
					静态方法：
							  static String copyValueOf(char[]);
							  static String copyValueOf(char[] data,int offset, int count);
							  static String valueOf(char[]);
			3.2，将字符串转换成字符数组。
					char[] toCharArray();
			3.3，将字节数组转换成字符串。
					String(byte[]);
					String(byte[],int offset,int count);			
			3.4，将字符串转换成字节数组。
					byte[] getBytes();
			3.5，将基本数据类型转换成字符串。
					static	String valueOf(int);
					static	String valueOf(double);
					//3+"";//String.valueOf(3);
			特殊：字符串和字节数组在转换过程中，是可以指定编码表的。
		4，替换：
					String replace(char oldChar,char newChar);//如果要替换的字符不存在，返回的还是原串。
		5，切割：
					String [] split(regex);//将目标字符串分割成多个字符串。示例：String [] arr = s.split(",");
		6，截取子串，获取字符串中的一部分。
					String substring(gebin);
					String substring(gegin,end);//截取字符串。包含头不包含尾。
		7，转换，去除空格，比较：
			7.1，将字符串转换成大写或者小写：
					String toUpperCase();
					String toLowerCase();
			7.2，将字符串两端的多个空格去除；
					String trim();
			7.3，对两个字符串进行自然顺序的比较。
					int compareTo(string);//
*/
class  StringMethodTest1
{
	public static void method_compareTo()
	{
		String s1 = "abcdefg";
		String s2 = "abccefg";

		s1.compareTo(s2);//如果s1位于s2前面则返回负整数，如果s1位于s2后面则返回整数，如果相等则返回0。
	}
	public static void method_to_trim()
	{
		String s = "   Hello  Java";
		
		s.toUpperCase();//将小写字符转换成大写格式，

		s.toLowerCase();//将小写字符转换成大写格式，

		s.trim();//将字符串中两头的空格去掉。
	}
	public static void metod_substring()
	{
		String s = "falsdjgjla";
		
		s.substring(2);

		s.substring(2,6);//截取字符串。包含头不包含尾。
	}
	public static void main(String[] args) 
	{
		
		String  str = "asgfafgdcdgakgsgljg";
		//String str = new String("asgfafgdcdgakgsgljg");
		
		char [] arr = {'a','b','c','d','e','f','g'};

		str.length();//返回字符串的长度，

		str.charAt(4);//返回字符串str中角标值为4的字符。

		str.indexOf('g');//返回字符g在此字符串str中中最后一次出现处的索引。

		str.indexOf('g',5);//从字符串str中角标值为5开始获取G在字符串中出现的位置。

		str.lastIndexOf('g');//返回指定字符'g'在此字符串str中最后一次出现处的索引。

		str.lastIndexOf('g',8);//返回指定字符'g'在此字符串str中最后一次出现处的索引，从指定的角标值为8处开始进行反向搜索。

		str.startsWith("asg");//判断字符串str中是否以"asg"开头。

		str.endsWith("ljg");//判断字符串str中是否以"ljg"结尾。

		str.contains("gdcdg");//判断字符串中str中是否包含"gdcdg"。

		str.toCharArray();//将字符串转换成字符数组。
		
		str.getBytes();//将字符串转换成字节数组。
		
		arr.String()////将字符数组转换成字符串。

		String s1 = "abc";//s1是一个类类型变量，"abc"是一个对象。
						//字符串最大特点：一旦被初始化就不可以被改变。
		String s2 = new String("abc");
		//区别：
		//s1在内存中有一个对象，
		//s2在内存中有两个对象。

		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));//String类重写了Object类中equals方法。
	}
}
