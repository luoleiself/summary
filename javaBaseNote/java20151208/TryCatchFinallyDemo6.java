/*
第一个格式：
try
{

}
catch()
{

}
第二种格式：
try
{

}
catch()
{

}
finally
{

}
第三种格式：
try
{

}
finally
{

}
//记住一点：catch是用于处理异常的，如果没有catch就代表异常没有被处理过，
			如果该异常时检测时异常，那么必须声明。
*/
class ExceptionTest6
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
