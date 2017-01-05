/*
�������󣺱������Ķ�����Ҫʵ��Serializable(��ǽӿ�)��

Serializable(��ǽӿ�)��û�з�����
		��ͨ��ʵ�� java.io.Serializable �ӿ������������л����ܡ�δʵ�ִ˽ӿڵ��ཫ�޷�ʹ���κ�״̬���л������л���
	
	˽�б������ܱ����л������˽�б�����Ҫ���л�����ʹ��:static final long serialVersionUID = 42L;
	��̬���ܱ����л���
	�Ǿ�̬�������뱻���л�ʹ�ùؼ��֣�transient��

ObjectInputStream
ֻ��֧�� java.io.Serializable �� java.io.Externalizable �ӿڵĶ�����ܴ�����ȡ��
	���캯����
		ObjectInputStream(InputStream in)��
				������ָ�� InputStream ��ȡ�� ObjectInputStream��
		protected  ObjectInputStream(); 
				Ϊ��ȫ����ʵ�� ObjectInputStream �������ṩһ�ַ�ʽ��
				�������ط������ ObjectInputStream ��ʵ��ʹ�õ�˽�����ݡ� 
	һ�㷽����
		int readInt(); �����ǻ����������ͣ�readLong(),readFloat()
				��ȡһ�� 32 λ�� int ֵ�� 
		Object readObject(); 
				�� ObjectInputStream ��ȡ���� 
		void defaultReadObject(); 
				�Ӵ�����ȡ��ǰ��ķǾ�̬�ͷ�˲̬�ֶΡ�
		protected  boolean enableResolveObject(boolean enable); 
				ʹ������Ӹ�����ȡ�Ķ��������
		void readFully(byte[] buf); 
				��ȡ�ֽڣ�ͬʱ����ֱ����ȡ�����ֽڡ�
		int skipBytes(int len);
				�����ֽڡ�
		protected  Object readObjectOverride(); 
				�˷����� ObjectOutputStream ��������������ã�
				��Щ����ʹ���ܱ������޲������췽������ ObjectOutputStream��
		String readUTF();
				��ȡ UTF-8 �޸İ��ʽ�� String��
ObjectOutputStream
	���캯����
		protected  ObjectOutputStream(); 
				Ϊ��ȫ����ʵ�� ObjectOutputStream �������ṩһ�ַ�����
				�������ط������ ObjectOutputStream ��ʵ��ʹ�õ�˽�����ݡ� 
		ObjectOutputStream(OutputStream out); 
				����д��ָ�� OutputStream �� ObjectOutputStream��
	һ�㷽����
		void writeBoolean(boolean val); �����ǻ����������ͣ�writeLong(),writeFloat()
				д��һ�� boolean ֵ�� 
		void writeObject(Object obj); 
				��ָ���Ķ���д�� ObjectOutputStream�� 
		void defaultWriteObject(); 
				����ǰ��ķǾ�̬�ͷ�˲̬�ֶ�д�������
		protected  void drain(); 
				�ſ� ObjectOutputStream �е������ѻ������ݡ�
		protected  boolean enableReplaceObject(boolean enable); 
				�����������еĶ�������滻�� 
		ObjectOutputStream.PutField putFields(); 
				��ȡ���ڻ���д�����еĳ־ô洢�ֶεĶ���
		protected  Object replaceObject(Object obj); 
				�����л��ڼ䣬�˷������� ObjectOutputStream ������������ʹ��һ�����������һ������
		void reset(); 
				���ý�������д�����е����ж����״̬��
		protected  void writeStreamHeader(); 
				�ṩ writeStreamHeader ����������������Խ��������ͷ����ӻ�Ԥ�ӵ����С�
		void writeUTF(String str); 
				�� UTF-8 �޸İ��ʽд��� String �Ļ������ݡ� 
*/
import java.io.*;
class	ObjectStreamDemo1 
{
	public static void main(String[] args) 
	{
		writeObj();
		readObj();
	}
	public static void writeObj()
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));

		oos.writeObject(new Person("zhangsan",20));

		oos.close();
	}
	public static void readObj()
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
		Person p = (Person)ois.readObject();

		System.out.println(p);
		ois.close();
	}
}

