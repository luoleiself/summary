/*
Map集合的扩展知识：

Map集合被使用是因为具备映射关系。

第一种练习：
"yureban" ,"01","zhangsan";
"yureban" ,"02","lisi";
"jiuyeban" ,"01","wangwu";
"jiuyeban" ,"02","zhaoliu";
思路：
	1，一个学校有多个教室，一个教室有多个学生。

第二种练习：
"yureban" ,Student("01","zhangsan");
"yureban" ,Student("02","lisi");
"jiuyeban" ,Student("01","wangwu");
"jiuyeban" ,Student("02","zhaoliu");



*/
import java.util.*;
class  MapDemo3
{
	public static void listDemo()
	{
		HashMap<String,List<Student>> czbk = new HashMap<String,List<Student>>();

		List<Student> reyu = new ArrayList<Student>();
		List<Student> jiuye = new ArrayList<Student>();

		czbk.put("reyu",reyu);
		czbk.put("jiuye",jiuye);

		reyu.add(new Student("01","zhangsan"));
		reyu.add(new Student("02","lisi"));
		jiuye.add(new Student("01","wangwu"));
		jiuye.add(new Student("02","zaholiu"));
		
		Set<String> keySet = czbk.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext())
		{
			String roomName = it.next();
			List<Student> room = czbk.get(roomName);
			
			System.out.println(roomName);
			getInfo(room);
		}
	}
	public static void getInfo(List<Student> list)
	{
		Iterator<Student> it = list.iterator();
		while (it.hasNext())
		{
			Student s = it.next();
			System.out.println(s);
		}
	}
	public static void main(String[] args) 
	{
		HashMap<String,HashMap<String,String>> czbk = new HashMap<String,HashMap<String,String>>();

		HashMap<String,String> yureban = new HashMap<String,String>();
		
		HashMap<String,String> jiuyeban = new HashMap<String,String>();
		
		czbk.put("yureban",yureban);
		czbk.put("jiuyeban",jiuyeban);

		yureban.put("01","zhangsan");
		yureban.put("02","lisi");

		jiuyeban.put("01","wangwu");
		jiuyeban.put("02","zaholiu");
		
		//遍历czbk集合，获取所有的教室。
		Set<String> keySet = czbk.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext())
		{
			String roomName = it.next();
			HashMap<String,String> room = czbk.get(roomName);
			
			System.out.println(roomName);
			getStudentInfo(room);
		}
	}
	public static void getStudentInfo(HashMap<String,String> roomMap)
	{
		Set<String> keySet = roomMap.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext())
		{
			String id = it.next();
			String name = roomMap.get(id);
			System.out.println(id+"::"+name);
		}
	}
}
/*
运行结果：
		jiuyeban
		01::wangwu
		02::zaholiu
		yureban
		01::zhangsan
		02::lisi
*/
