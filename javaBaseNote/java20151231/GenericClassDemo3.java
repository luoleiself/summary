/*
����ǰ������
		ʲôʱ��ʹ�÷����ࣿ
			������ҩ�����������������Ͳ�ȷ����ʱ��
			���ڶ���Object�������չ��
			���ڶ��巺�����������չ��
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
		Woeker w = u.getObject();//���巺�͹��߰����Բ��ý���ǿ������ת����
		//Woeker w = (Worker)u.getObject();�������÷���ʱ����Ҫǿ������ת����
		
		/*
		Utils<QQ> u = new Utils<Worker>();
		u.setObject(new Student());ֱ�ӽ�������ʾ�ڱ���ʱ�ڣ��ó���Ա����
		Woeker w = u.getObject();
		*/
	}
}
