/*
练习：
	"adfgzxcvasdfxcvdf"获取该字符串中的字母出现的次数。
希望打印结果：a(1)b(2)......

1，通过结果发现，每一个字母都有对应的次数，说明字母和次数之间都有映射关系。
2，当防线有映射关系时，可以选择Map集合，因为map集合中存放的就是映射关系。

什么时候使用map集合？
	当数据之间存在这种映射关系时，就要先想map集合。

思路：
	1，将字符串转换成字符数组，因为要对每一个字符进行操作。
	2，定义一个Map集合，因为打印结果的字符都有顺序，所以使用TreeMap集合。
	3，遍历字符数组。
		将每一个字符作为键去查Map集合，
		如果返回null，将该字符和1存入到Map集合中。
		如果返回不是null，说明该字符在Map集合中已经存在并有对应的次数。
		那么就获取该次数并进行自增，然后将该字符和增后的次数存入到Map集合中，覆盖原来键值对应的值。
	4，将Map集合中的数据变成指定的字符串形式返回。
*/
import java.util.*;
class  TreeMapEntrySetTest3
{
	public static void main(String[] args) 
	{
		String s = charCount("aadgfgcvxasqcgavdf");
		System.out.println(s);
	}
	public static String charCount(String str)
	{
		char[] chs = str.toCharArray();

		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
		
		int count = 0;
		for (int x=0;x<chs.length; x++)
		{
			if (!(chs[x]>='a' && chs[x]<='z' || chs[x]>='A' && chs[x]<='Z'))//判断是否在字母区间内。
			{
				continue;
			}
			Integer value = tm.get(chs[x]);

			//第一种方式：
			if (value!=null)
			{
				count = value;
			}
			count++;
			tm.put(chs[x],count);
			count = 0;

			//第二种方式：
			/*
			if (value == null)
			{
				tm.put(chs[x],1);
			}
			else
			{
				value = value + 1;
				tm.put(chs[x],value);
			}
			*/

		}
		//System.out.println(tm);

		StringBuilder sb = new StringBuilder();
			
		Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();

		while (it.hasNext())
		{
			Map.Entry<Character,Integer> me = it.next();
			Character ch = me.getKey();
			Integer value = me.getValue();
			sb.append(ch+"("+value+")");
		}
		return sb.toString();
	}
}
/*
运行结果：a(4)c(2)d(2)f(2)g(3)q(1)s(1)v(2)x(1)
*/
