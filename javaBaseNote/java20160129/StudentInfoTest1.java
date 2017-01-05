/*
练习：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括姓名，三门课成绩）
输入的格式：如zhangsan,30.40.50，计算出总成绩，
并把学生的信息和计算出的总成绩分数高低顺序存放在磁盘文件"stu.txt"中。

分析：
	1，描述学生对象，
	2，定义一个可操作学生对象的工具类。

思路：
	1，通过键盘录入一行数据，并将该行中的信息取出封装成学生对象。
	2，因为学生有很多，那么就需要存储，使用到集合。因为要对学生的总分排序。
		所以可以使用TreeSet。
	3，将集合的信息写入到一个文件中。
*/
import java.io.*;
import java.util.*;
class Student implements Comparable<Student>
{
	private String name;
	private int ma,cn,en;
	private int sum;
	Student(String name,int ma,int cn,int en)
	{
		this.name = name;
		this.ma = ma;
		this.cn = cn;
		this.en = en;
		sum = ma + cn + en;
	}
	public String getName()
	{
		return name;
	}
	public int getSum()
	{
		return sum;
	}
	public int hashCode()
	{
		return name.hashCode()+sum*78;
	}
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Student))
		{
			throw new ClassCastException("类型不匹配");
		}
		Student s = (Student)obj;
		return this.name.euqals(s.name) && this.sum == s.sum;
	}
	public int compareTo(Student s)
	{
		int num = new Integer(this.sum).compareTo(new Integer(s.sum));
		if (num == 0)
		{
			return this.name.compareTo(s.name);
		}
		return num;
	}
	public String toString()
	{
		return "student["+name+","+ma+","+cn+","+en+"]";
	}
}
class StudentInfoTool
{
	public static Set<Student> getStudents()throws IOException
	{
		return getStudents(null);
	}
	public static Set<Student> getStudents(Comparator<Student> cmp)throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		String line = null;
		
		Set<Student> stus =null;
		if (cmp==null)
		{
			stus = new TreeSet<Student>();
		}
		else
		{
			stus = new TreeSet<Student>(cmp);
		}
		while ((line = bufr.readLine())!=null)
		{
			if ("over".equals(line))
			{
				break;
			}
			String[] info = line.split(",");
			Student stu = new Student(info[0],Integer.parseInt(info[1]),
											Integer.parseInt(info[2]),
											Integer.parseInt(info[3]));
			stus.add(stu);
		}
		bufr.close();
		return stus;
	}
	public static void writeToFile(Set<Student> stus)throws IOException
	{
		BufferedWriter bufw = new BufferedWriter(new FileWriter("stuinfo.txt"));

		for (Student stu : stus )
		{
			bufw.write(stu.toString()+"\t");
			bufw.write(stu.getSum()+"");
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}
}
class  StudentInfoTest1
{
	public static void main(String[] args) throws IOException
	{
		Comparator<Student> cmp = Collections.reverseOrder();//创建一个逆转比较器。

		Set<Student> stus = StudentInfoTool.getStudents(cmp);

		StudentInfoTool.writeToFile(stus);
	}
}


