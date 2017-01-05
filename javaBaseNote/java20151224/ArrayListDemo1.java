/*
���Ͽ�ܣ�Collection(�ӿ�)�����ӿڡ�
						|--List(�ӿ�)��Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ��������
								|--ArrayList(��)���ײ�����ݽṹʹ�õ�����ṹ��jDk1.2��ʼ���ص㣺��ѯ�ٶȿ죬��ɾԪ���ٶ������̲߳�ͬ�������鳤�ȿɱ�ٷ�֮50�ӳ�����copy��ɾ����
								|--LinkedList(��)���ײ�ʹ�õ��������ݽṹ��jdk1.2��ʼ���̲߳�ͬ�����ص㣺��ѯ�ٶ�������ɾԪ���ٶȿ졣
								|--Vector(��)���ײ����������ݽṹ��jDk1.0��ʼ���߳�ͬ������ArrayList����ˡ����鳤�ȿɱ�ٷ�֮100�ӳ���
						|--Set(�ӿ�)��Ԫ��������ģ�Ԫ�ز������ظ����ü�����ϵû��������
								|--HashSet(��)
								|--TreeSet(��)

List��
	�������з��������ǿ��Բ����Ǳ�ķ������Ǹ���ϵ���еķ�����
		����
			add(index,element);
			addAll(index,Collection);
		ɾ��
			remove(index);
		�ģ�
			set(index,element);
		�飺
			get(ine index);
			subList(int fromindex,int toindex);
			
			listIterator();

ArrayList�ࣺ
			List �ӿڵĴ�С�ɱ������ʵ�֡�ʵ�������п�ѡ�б��������������� null ���ڵ�����Ԫ�ء�
			����ʵ�� List �ӿ��⣬���໹�ṩһЩ�����������ڲ������洢�б������Ĵ�С��
			��������ϵ�ͬ�� Vector �࣬���˴����ǲ�ͬ���ġ�

ÿ�� ArrayList ʵ������һ����������������ָ�����洢�б�Ԫ�ص�����Ĵ�С�����������ٵ����б�Ĵ�С��
������ ArrayList �в������Ԫ�أ�������Ҳ�Զ���������δָ���������Ե�ϸ�ڣ���Ϊ�ⲻֻ�����Ԫ�ػ������̯�̶�ʱ�俪�������򵥡�

ע�⣬��ʵ�ֲ���ͬ���ġ��������߳�ͬʱ����һ�� ArrayList ʵ��������������һ���̴߳ӽṹ���޸����б���ô������ �����ⲿͬ����
���ṹ�ϵ��޸���ָ�κ���ӻ�ɾ��һ������Ԫ�صĲ�����������ʽ�����ײ�����Ĵ�С����������Ԫ�ص�ֵ���ǽṹ�ϵ��޸ġ���
��һ��ͨ������Ȼ��װ���б�Ķ������ͬ����������ɡ���������������Ķ�����Ӧ��ʹ�� Collections.synchronizedList ���������б���װ��������
������ڴ���ʱ��ɣ��Է�ֹ������б���в�ͬ���ķ��ʣ�List list = Collections.synchronizedList(new ArrayList(...)); 

ArrayList������
			���췽����
					ArrayList();
							����һ����ʼ����Ϊ 10 �Ŀ��б�
					ArrayList(Collection<? extends E> c);
							����һ������ָ�� collection ��Ԫ�ص��б���ЩԪ���ǰ��ո� collection �ĵ������������ǵ�˳�����еġ�
					ArrayList(int initialCapacity);
							����һ������ָ����ʼ�����Ŀ��б�
			void trimToSize();
					���� ArrayList ʵ������������Ϊ�б�ĵ�ǰ��С��
*/
import Java.util.*;
class  ArrayListDemo1
{
	public static void stringPrint(String str)
	{
		System.out.println(str);
	}
	public static void method()
	{
		ArrayList al = new ArrayList();

		//1�����Ԫ�ء�
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		

		//��ָ��λ�ò���Ԫ�أ�
		stringPrint("ԭ�����ǣ�"+al);
		al.add(1,"java08");
		stringPrint("�¼����ǣ�"+al);

		//ɾ��ָ��λ�õ�Ԫ�أ�
		stringPrint("ԭ�����ǣ�"+al);
		al.remove(2);
		stringPrint("�¼����ǣ�"+al);

		//�޸�Ԫ�أ�
		stringPrint("ԭ�����ǣ�"+al);
		al.set(3,"java05");
		stringPrint("�¼����ǣ�"+al);

		//��ȡԪ�أ�
		stringPrint("ԭ�����ǣ�"+al);
		al.get(1);
		stringPrint("�¼����ǣ�"+al);

		//��һ�ַ�ʽ��ѭ������ȡ����Ԫ�أ�
		for (int x=0;x<al.size();x++)//size��length����˼��һ���ģ������÷���һ����
		{
			stringPrint("al("+x+")="+al.get(x));
		}

		//�ڶ��ַ�ʽ������ʹ�õ��������в�����
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			stringPrint("al.next:"+it.next());
		}

		//ͨ��idexOf��ȡ�����λ�ã�
		stringPrint("al.indexOf:"+it.indexOf("java03"));

		List sub = al.subList(1,3);
		stringPrint("sub="+sub);
	}
	public static void main(String[] args) 
	{
		
	}
}
