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

Iterator<E>�ӿ�:
				Iterator iterator();
						�����ڴ� collection ��Ԫ���Ͻ��е����ĵ�������ʾ����Iterator it = al.iterator();
						boolean hasNext();
							�������Ԫ�ؿ��Ե������򷵻� true��
						 E next();
							���ص�������һ��Ԫ�ء�
						void remove();
							�ӵ�����ָ��� collection ���Ƴ����������ص����һ��Ԫ�أ���ѡ��������

��ȡ����ʽ�����ڼ��ϵ��ڲ�������ȡ����ʽ�Ϳ���ֱ�ӷ��ʼ����ڲ���Ԫ�ء�
��ôȡ����ʽ�ͱ���������ڲ��࣬��ÿһ�����������ݽṹ��ͬ������ȡ���Ķ���ϸ�ڲ�һ����
���Ƕ��й��������жϺ�ȡ������ô�Ϳ��Խ��������ݳ�ȡ����Щ�ڲ��඼����һ������Iterator��

��λ�ȡ���ϵ�ȥ������
		ͨ��һ�������ṩ�ķ�����iterator();

ϵ�б������listIterator();
					void add(Element e);
						��ָ����Ԫ�ز����б���ѡ��������
					boolean hasNext();				
						Iterator<E>�ӿ��еķ������������Ԫ�ؿ��Ե������򷵻� true��ʾ����al.hasNext();
					E next();														
						Iterator<E>�ӿ��еķ��������ص�������һ��Ԫ�ء�		
					boolean hasPrevious();
						�������������б��б�������ж��Ԫ�أ��򷵻� true��
					E previous();
						�����б��е�ǰһ��Ԫ�ء�
					int nextIndex();
						���ض� next �ĺ�������������Ԫ�ص�������
					int previousIndex();
						���ض� previous �ĺ�������������Ԫ�ص�������
					void set(Element ,element);
						��ָ��Ԫ���滻 next �� previous ���ص����һ��Ԫ�أ���ѡ��������
					void remove();
						���б����Ƴ��� next �� previous ���ص����һ��Ԫ�أ���ѡ��������
					
List���еĵ�������ListIterator��Iterator���ӽӿڡ�

�ڵ���ʱ��������ͨ�����϶Զ���ķ������������е�Ԫ�ء���Ϊ�ᷢ��ConcurrentModificationException�쳣��
���ԣ��ڵ�����ʱ��ֻ���õ������ķ�������Ԫ�أ�����Iterator���������޵ģ�ֻ�ܶ�Ԫ�ؽ����жϣ�ȡ����ɾ���Ĳ�����
�����Ҫ�����Ĳ���������ӣ��޸ĵȣ�����Ҫʹ�����ӽӿ�ListIterator��

�ýӿ�ֻ��ͨ��List���ϵ�listIterator������ȡ��

*/
import Java.util.*;
class  ListIteratorDemo1
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
		//��ʾ�б��������
		ArrayList al = new ArrayList();

		//1�����Ԫ�ء�
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		//�ڵ��������У�׼����ӻ���ɾ��Ԫ�ء�
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if (obj.equals("java02"))
			{
				it.set("java09");
				//�����׳������쳣��ConcurrentModificationException����Ϊ������ʱ����������
			}
			stringPrint("al.next:"+it.next());
		}
		
		//�����޸ĺ�
		ListIterator it = al.listIterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if (obj.equals("java02"))
			{
				it.set("java09");
			}
			stringPrint("al.next:"+it.next());
		}

		//ϵ�б��������
		ListIterator it = al.listIterator();

		stringPrint("hasPrevious():"+it.hasPrevious());//���������
		while(it.hasNext())
		{
			stringPrint("next():"+it.next());
			stringPrint("nextIndex():"+it.nextIndex());//����������һ��Ԫ�ص�������
		}
		stringPrint("hasNext():"+it.hasNext());
		stringPrint("hasPrevious():"+it.hasPrevious());
		
		System.out.println("=======================================");
		
		stringPrint("hasNext():"+it.hasNext());//���������
		while(it.hasPrevious())
		{
			stringPrint("Previous():"+it.Previous());
			stringPrint("PreviousIndex():"+it.PreviousIndex());//����������һ��Ԫ�ص�������
		}
		stringPrint("hasNext():"+it.hasNext());
		stringPrint("hasPrevious():"+it.hasPrevious());
	}
}
