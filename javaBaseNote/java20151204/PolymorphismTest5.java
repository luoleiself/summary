/*
需求；数据库的操作
数据是：用户信息。	
	1，连接数据库，JDBC / hibernate
	2，操作数据库。
		c create  r read  u update  d delete
	3，关闭数据库连接。
*/

 interface UserInfoDao//定义借口，通过接口的调用实现方法，在以后的过程中不用修改方法修改接口即可，降低耦合性。
{
	public abstract void add(User user);
	public abstract void delete(User user);
}
class UserInfoByJDBC implements UserInfoDao
{
	public void add()
	{
		1，JDBC连接数据库，
		2，使用SQL语句进行数据的增加操作，
		3，关闭数据库的连接。
	}
	public void delete()
	{
		1，JDBC连接数据库，
		2，使用SQL语句进行数据的删除操作，
		3，关闭数据库的连接。
	}
}
class UserInfoByHibernate implements UserInfoDao
{
	public void add()
	{
		1，Hibernate连接数据库，
		2，使用SQL语句进行数据的增加操作，
		3，关闭数据库的连接。
	}
	public void delete()
	{
		1，Hibernate连接数据库，
		2，使用SQL语句进行数据的删除操作，
		3，关闭数据库的连接。
	}
}
class  PolymorphismTest5
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
