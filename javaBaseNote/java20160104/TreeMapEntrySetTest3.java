/*
��ϰ��
	"adfgzxcvasdfxcvdf"��ȡ���ַ����е���ĸ���ֵĴ�����
ϣ����ӡ�����a(1)b(2)......

1��ͨ��������֣�ÿһ����ĸ���ж�Ӧ�Ĵ�����˵����ĸ�ʹ���֮�䶼��ӳ���ϵ��
2����������ӳ���ϵʱ������ѡ��Map���ϣ���Ϊmap�����д�ŵľ���ӳ���ϵ��

ʲôʱ��ʹ��map���ϣ�
	������֮���������ӳ���ϵʱ����Ҫ����map���ϡ�

˼·��
	1�����ַ���ת�����ַ����飬��ΪҪ��ÿһ���ַ����в�����
	2������һ��Map���ϣ���Ϊ��ӡ������ַ�����˳������ʹ��TreeMap���ϡ�
	3�������ַ����顣
		��ÿһ���ַ���Ϊ��ȥ��Map���ϣ�
		�������null�������ַ���1���뵽Map�����С�
		������ز���null��˵�����ַ���Map�������Ѿ����ڲ��ж�Ӧ�Ĵ�����
		��ô�ͻ�ȡ�ô���������������Ȼ�󽫸��ַ�������Ĵ������뵽Map�����У�����ԭ����ֵ��Ӧ��ֵ��
	4����Map�����е����ݱ��ָ�����ַ�����ʽ���ء�
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
			if (!(chs[x]>='a' && chs[x]<='z' || chs[x]>='A' && chs[x]<='Z'))//�ж��Ƿ�����ĸ�����ڡ�
			{
				continue;
			}
			Integer value = tm.get(chs[x]);

			//��һ�ַ�ʽ��
			if (value!=null)
			{
				count = value;
			}
			count++;
			tm.put(chs[x],count);
			count = 0;

			//�ڶ��ַ�ʽ��
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
���н����a(4)c(2)d(2)f(2)g(3)q(1)s(1)v(2)x(1)
*/
