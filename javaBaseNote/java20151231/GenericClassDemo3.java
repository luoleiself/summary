/*
泛型前做法：
		什么时候使用泛型类？
			当类中药操作的引用数据类型不确定的时候。
			早期定义Object来完成扩展。
			现在定义泛型类来完成扩展。
*/
class Worker
{
	
}
class Student
{
	
}
class Utils<QQ> 
{
	private QQ q;
	public void setObject(QQ q)
	{
		this.q = q;
	}
	public QQ getObject()
	{
		return q;
	}
}
class  GenericClassDemo3
{
	public static void main(String[] args) 
	{
		Utils<QQ> u = new Utils<Worker>();
		u.setObject(new Worker());
		Woeker w = u.getObject();//定义泛型工具包可以不用进行强制类型转换。
		//Woeker w = (Worker)u.getObject();当不适用泛型时，需要强制类型转换。
		
		/*
		Utils<QQ> u = new Utils<Worker>();
		u.setObject(new Student());直接将问题显示在编译时期，让程序员处理。
		Woeker w = u.getObject();
		*/
	}
}
