/*
�������ݿ�Ĳ���
�����ǣ��û���Ϣ��	
	1���������ݿ⣬JDBC / hibernate
	2���������ݿ⡣
		c create  r read  u update  d delete
	3���ر����ݿ����ӡ�
*/

 interface UserInfoDao//�����ڣ�ͨ���ӿڵĵ���ʵ�ַ��������Ժ�Ĺ����в����޸ķ����޸Ľӿڼ��ɣ���������ԡ�
{
	public abstract void add(User user);
	public abstract void delete(User user);
}
class UserInfoByJDBC implements UserInfoDao
{
	public void add()
	{
		1��JDBC�������ݿ⣬
		2��ʹ��SQL���������ݵ����Ӳ�����
		3���ر����ݿ�����ӡ�
	}
	public void delete()
	{
		1��JDBC�������ݿ⣬
		2��ʹ��SQL���������ݵ�ɾ��������
		3���ر����ݿ�����ӡ�
	}
}
class UserInfoByHibernate implements UserInfoDao
{
	public void add()
	{
		1��Hibernate�������ݿ⣬
		2��ʹ��SQL���������ݵ����Ӳ�����
		3���ر����ݿ�����ӡ�
	}
	public void delete()
	{
		1��Hibernate�������ݿ⣬
		2��ʹ��SQL���������ݵ�ɾ��������
		3���ر����ݿ�����ӡ�
	}
}
class  PolymorphismTest5
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
