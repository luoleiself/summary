/*
object:�����ж����ֱ�Ӻ��߼�Ӹ��ף���˵���ϵۡ�
	   �����ж���Ŀ϶������ж��󶼾߱��ķ�����

Object �����Ѿ��ṩ�˶Զ����Ƿ���ͬ�ıȽϷ���equals();
����Զ�������Ҳ�бȽ���ͬ�ķ�����û�б�Ҫ���¶��塣
ֻҪ��Ϯ�����еķ����������Լ����бȽ����ݼ��ɣ��������д(����)��

Object������
			boolean equals(Object obj);
						ָʾ����ĳ�������Ƿ���˶�����ȡ���
			Class<?> getClass();
						���ش� Object ������ʱ�ࡣ
			int hashCode();
						���ظö���Ĺ�ϣ��ֵ��
			void notify();
						�����ڴ˶���������ϵȴ��ĵ����̡߳�
			void notifyAll();
						�����ڴ˶���������ϵȴ��������̡߳�
			String toString();
						���ظö�����ַ�����ʾ��
			void wait();
						�������̵߳��ô˶���� notify() ������ notifyAll() ����ǰ�����µ�ǰ�̵߳ȴ���
			void wait(long timeout);
						�������̵߳��ô˶���� notify() ������ notifyAll() ���������߳���ָ����ʱ����ǰ�����µ�ǰ�̵߳ȴ���
			void wait(long timeout, int nanos);
						�������̵߳��ô˶���� notify() ������ notifyAll() ��������������ĳ���߳��жϵ�ǰ�̣߳������ѳ���ĳ��ʵ��ʱ����ǰ�����µ�ǰ�̵߳ȴ���						
			
���󷽷� String getName();  
						�� String ����ʽ���ش� Class ��������ʾ��ʵ�壨�ࡢ�ӿڡ������ࡢ�������ͻ� void�����ơ�
���󷽷� Method getMethod(String name, Class<?>... parameterTypes); 
						����һ�� Method ��������ӳ�� Class ��������ʾ�����ӿڵ�ָ��������Ա������
*/
class Demo//extends Object
{
	//�����а�����һ��ϵͳ�������صĹ��캯����
}
class  ObjectTest1
{
	public static void main(String[] args) 
	{
		Demo d = new Demo();
		System,.out.println(getClass().getName() +'@'+ Integer.toHexString(hashCode(d)));
		System.out.println("Hello World!");
	}
}
