/*
object:�����ж����ֱ�Ӻ��߼�Ӹ��ף���˵���ϵۡ�
	   �����ж���Ŀ϶������ж��󶼾߱��ķ�����

Object �����Ѿ��ṩ�˶Զ����Ƿ���ͬ�ıȽϷ���equals();
����Զ�������Ҳ�бȽ���ͬ�ķ�����û�б�Ҫ���¶��塣
ֻҪ��Ϯ�����еķ����������Լ����бȽ����ݼ��ɣ��������д(����)��


*/
class Demo //extends Objext
{
	public boolean equals(Object obj)//��̬�����֣�Object obj = new Demo();
	{	
		if (!(obj instanceof Demo))//�����ж�����������Ͳ��ǽ����Ķ���ֱ�ӷ��ش���ֵ��
		{
			return False;
		}
		else
		{
			Demo m3 = (Demo)obj;//��������ת��;
			return this.num = d.num;
		}
		
	}
}
class  ObjectTest
{
	public static void main(String[] args) 
	{
		Demo m1 = new Demo();
		Demo m2 = new Dmeo();
		Demo m3 = m1;
		System.out.println(m1,equals(m2));//equals()�Ƚ��������ͱ����ĵ�ֵַ��
		System.out.println(m1,equals(m3));
	}
}
