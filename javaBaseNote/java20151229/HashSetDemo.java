/*
���Ͽ�ܣ�Collection(�ӿ�)�����ӿڡ�
						|--List(�ӿ�)��Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ��������
								|--ArrayList(��)���ײ�����ݽṹʹ�õ�����ṹ��jDk1.2��ʼ���ص㣺��ѯ�ٶȿ죬��ɾԪ���ٶ������̲߳�ͬ�������鳤�ȿɱ�ٷ�֮50�ӳ�����copy��ɾ����
								|--LinkedList(��)���ײ�ʹ�õ��������ݽṹ��jdk1.2��ʼ���̲߳�ͬ�����ص㣺��ѯ�ٶ�������ɾԪ���ٶȿ졣
								|--Vector(��)���ײ����������ݽṹ��jDk1.0��ʼ���߳�ͬ������ArrayList����ˡ����鳤�ȿɱ�ٷ�֮100�ӳ���
						
						|--Set(�ӿ�)��Ԫ���������(�����ȡ����˳��һ��һ��)��Ԫ�ز������ظ����ü�����ϵû��������
										Set���ϵĹ��ܺ�Collection���ϵĹ�����һ�µġ�
								|--HashSet(��)���ײ����ݽṹ�ǹ�ϣ��
								|--TreeSet(��)��

HashSet(��)��
			HashSet����α�֤Ԫ��Ψһ�Ե��أ�
					��ͨ��Ԫ�ص�����������hashCode��equals����ɡ�
					���Ԫ�ص�HashCodeֵ��ͬ���Ż��ж�equals�Ƿ�Ϊtrue��
					���Ԫ�ص�HashCodeֵ��ͬ���������equals��

			ע�⣺�����ж�Ԫ���Ƿ���ڣ��Լ�ɾ���Ȳ����������ķ�����Ԫ�ص�HashCode��equals������

ArrayList��ɾ���������equals������
HashSet��ɾ���������HashCode��equals������
*/
class  HashSetDemo
{
	public static void strinPrint(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		
		HashSet hs = new HashSet();

		stringPrint(hs.add("java01"));
		stringPrint(hs.add("java01"));//����������ϣֵʱ���жϹ�ϣֵ�Ƿ�һ�£���������ж�Ԫ��
		hs.add("java02");
		stringPrint(hs.add("java03"));
		stringPrint(hs.add("java03"));
		hs.add("java04");

		//ȡ��Ԫ��Ҳʹ�õ�������
		Iterator it = hs.iterator();

		while(it.hasNext())
		{
			stringPrint(it.next());
		}
	}
}
