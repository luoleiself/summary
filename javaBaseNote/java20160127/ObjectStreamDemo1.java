/*
操作对象：被操作的对象需要实现Serializable(标记接口)。

Serializable(标记接口)：没有方法。
		类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
	
	私有变量不能被序列化，如果私有变量需要序列化可以使用:static final long serialVersionUID = 42L;
	静态不能被序列化。
	非静态变量不想被序列化使用关键字：transient。

ObjectInputStream
只有支持 java.io.Serializable 或 java.io.Externalizable 接口的对象才能从流读取。
	构造函数：
		ObjectInputStream(InputStream in)；
				创建从指定 InputStream 读取的 ObjectInputStream。
		protected  ObjectInputStream(); 
				为完全重新实现 ObjectInputStream 的子类提供一种方式，
				让它不必分配仅由 ObjectInputStream 的实现使用的私有数据。 
	一般方法：
		int readInt(); 可以是基本数据类型，readLong(),readFloat()
				读取一个 32 位的 int 值。 
		Object readObject(); 
				从 ObjectInputStream 读取对象。 
		void defaultReadObject(); 
				从此流读取当前类的非静态和非瞬态字段。
		protected  boolean enableResolveObject(boolean enable); 
				使流允许从该流读取的对象被替代。
		void readFully(byte[] buf); 
				读取字节，同时阻塞直至读取所有字节。
		int skipBytes(int len);
				跳过字节。
		protected  Object readObjectOverride(); 
				此方法由 ObjectOutputStream 的受信任子类调用，
				这些子类使用受保护的无参数构造方法构造 ObjectOutputStream。
		String readUTF();
				读取 UTF-8 修改版格式的 String。
ObjectOutputStream
	构造函数：
		protected  ObjectOutputStream(); 
				为完全重新实现 ObjectOutputStream 的子类提供一种方法，
				让它不必分配仅由 ObjectOutputStream 的实现使用的私有数据。 
		ObjectOutputStream(OutputStream out); 
				创建写入指定 OutputStream 的 ObjectOutputStream。
	一般方法：
		void writeBoolean(boolean val); 可以是基本数据类型，writeLong(),writeFloat()
				写入一个 boolean 值。 
		void writeObject(Object obj); 
				将指定的对象写入 ObjectOutputStream。 
		void defaultWriteObject(); 
				将当前类的非静态和非瞬态字段写入此流。
		protected  void drain(); 
				排空 ObjectOutputStream 中的所有已缓冲数据。
		protected  boolean enableReplaceObject(boolean enable); 
				允许流对流中的对象进行替换。 
		ObjectOutputStream.PutField putFields(); 
				获取用于缓冲写入流中的持久存储字段的对象。
		protected  Object replaceObject(Object obj); 
				在序列化期间，此方法允许 ObjectOutputStream 的受信任子类使用一个对象替代另一个对象。
		void reset(); 
				重置将丢弃已写入流中的所有对象的状态。
		protected  void writeStreamHeader(); 
				提供 writeStreamHeader 方法，这样子类可以将其自身的头部添加或预加到流中。
		void writeUTF(String str); 
				以 UTF-8 修改版格式写入此 String 的基本数据。 
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

