EditPlus常用快捷键：
					以浏览器模式预览文件							Ctrl + B
					新建浏览器窗口（类似于在EditPlus中打开ie）		Ctrl + Shift + B
					新建普通的文本文档								Ctrl + N
					新建html文件									Ctrl + Shift + N
					选中的字母切换为小写							Ctrl + L
					选中的字母切换为大写							Ctrl + U
					选中的词组首字母大写							Ctrl + Shift + U
					反转选定文本的大小写							Ctrl + K
					创建当前行的副本								Ctrl + J
					选择当前行										Ctrl + R
					将当前行向上(下)移动							Alt	 + Shift + UP(DOWN)(可以不使用Ctrl + R直接移动)
					将选定区域扩展到上一页							Shift + PageUp
					将选定区域扩展到下一页							Shift + PageDown
					光标移动到当前屏幕顶部							Ctrl +	PageUp
					光标移动到当前屏幕底部							Ctrl +	PageDown
					将选定区域扩展到当前屏幕顶部					Ctrl + Shift + PageUp
					将选定区域扩展到当前屏幕底部					Ctrl + Shift + PageDown
					移动到上一个单词								Ctrl + Left
					移动到下一个单词								Ctrl + Right
					将选定区域向左扩展一个字符						Shift + Left
					将选定区域向右扩展一个字符						Shift + Right
					将选定区域扩展到上一个单词						Ctrl + Shift + Left
					将选定区域扩展到下一个单词						Ctrl + Shift + Right
					删除光标左侧的单词								Ctrl + Backspace         
					显示或隐藏行号									Ctrl + Shift + L
					显示或隐藏回车符								Alt	 + Shift + L
					显示或隐藏标尺									Alt  + Shift + R
					显示或隐藏制表符与空格							Alt  + Shift + I


方法调用链：sb.append(34).append(true).append(34);返回的本类对象还可以调用方法。

注意大小写：
Iterable			java.lang.集合框架超级接口，子接口Collection。jdk1.5开始。
Collection			java.util.集合框架：根接口，用于存储对象。
Map					java.util.集合接口。jdk1.2开始，将键映射到值的对象。一个映射不能包含重复的键；每个键最多只能映射到一个值。
										Map接口提供三种collection 视图，允许以键集、值集或键-值映射关系集的形式查看某个映射的内容。
Hashtable			java.util.Map接口的子类，底层是哈希表数据结构，不可以存入null键和null值，该集合是线程同步的。jdk1.0开始。效率低。
HashMap				java.util.Map接口的子类，底层是哈希表数据结构，可以使用null键和null键，该集合是线程不同步的。jdk1.2开始。效率高。
TreeMap				java.util.Map接口的子类，底层是二叉树数据结构，线程不同步，可以用于给Map集合中的键进行排序。jdk1.2开始。
Map.Entry<K,V>		java.util.接口，映射项（键-值对）。jdk1.2开始，Map.entrySet 方法返回映射的 collection 视图，其中的元素属于此类。
					获得映射项引用的唯一 方法是通过此 collection 视图的迭代器来实现。
					示例：Set<Map.Entry<Student,String>> entrySet = hm.entrySet();Iterator<Map.Entry<Student,String>> iter = entrySet.iterator();
Set					java.util.集合体系：Collection子接口，元素是无序的，元素不可以重复。因为集合体系无索引。
HashSet				java.util.类名，实现Set接口，底层数据结构是哈希表，集合中存储的是哈希值，元素是无序的，元素不可以重复。
TreeSet				java.util.类名，实现Set接口，底层数据结构是二叉树，可以对Set集合中的元素进行排序。
List				java.util.集合体系：Collection子接口，元素是有序的，并且可以重复。因为集合体系有索引。
ArrayList			java.util.数组集合类实现List接口，jDk1.2开始。特点：查询速度快，增删元素速度慢。线程不同步。数组长度可变百分之50延长，先copy后删除。
LinkedList			java.util.链表集合类实现List接口，jdk1.2开始。特点：查询速度慢，增删元素速度快。
Iterator			java.util.接口迭代器：对 collection 进行迭代的迭代器。jdk1.2开始。只能对元素进行判断，取出，删除的操作。
ListIterator		java.util.Iterator接口子接口，系列表迭代器。允许程序员按任一方向遍历列表、迭代期间修改列表，并获得迭代器在列表中的当前位置。可以判断，取出，删除，添加，修改等，
Vector				java.util.数组集合类实现List接口，jDk1.0开始。特点：线程同步。被ArrayList替代了。数组长度可变百分之100延长。
Enumeration			java.util.枚举接口，JDK1.0开始，用法和Iterator用法一样。只有两种方法：hasMoreElements(),nextElement(),
Comparable			java.lang.接口，比较接口，jdk1.2开始，此接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序，类的 compareTo 方法被称为它的自然比较方法。
Comparator			java.util.接口，比较接口，jdk1.2开始，强行对某个对象 collection 进行整体排序 的比较函数。
Collections			java.util.类，集合框架工具类。此类完全由在 collection 上进行操作或返回 collection 的静态方法组成。jdk1.2开始。此类不能实例化，就像一个工具类，服务于Java的Collection框架。
Arrays				java.util.类，集合框架工具类。此类包含用来操作数组（比如排序和搜索）的各种方法。jdk1.2开始。除非特别注明，否则如果指定数组引用为 null，则此类中的方法都会抛出 NullPointerException。
Properties			java.util.类，获取系统属性信息。示例：Properties prop = System.getProperties();
Calendar			java.util.抽象类：它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等 日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
								示例：Calendar c = Calendar.getInstance();
SimpleDateFormat	java.text.类，是一个以与语言环境有关的方式来格式化和解析日期的具体类。示例：SimpleDateFormat sdf = new SimpleDateFormat("yy年mm月rr日 E hh:mm:ss");
File				java.io.类，文件和目录路径名的抽象表示形式。
FilenameFilter		java.io.接口。实现此接口的类实例可用于过滤器文件名。Abstract Window Toolkit 的文件对话框组件使用这些实例过滤 File 类的 list 方法中的目录清单。
							示例：
Serializable		java.io.接口，没有方法的接口通常为标记接口。类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
transient			关键字，非静态变量不想被序列化。
RandomAccessFile	java.io.类，此类的实例支持对随机访问文件的读取和写入。随机访问文件的行为类似存储在文件系统中的一个大型 byte 数组。

package				java.lang.包：定义包名的关键字。
import						类：关键字导入类。
class				java.lang.类：关键字定义一个类，
interface					接口：关键字定义一个接口，一个特殊的抽象类，当抽象类中的方法都是抽象方法，可以使用接口。			
String				java.lang.字符串类，数据不能被修改，最终类不能被继承。
StringBuffer		java.lang.String子类，jdk1.0开始。最终类名：字符串缓冲区，其中的数据可以被修改，类为最终类不能被继承。线程同步，用于单线程程序，保证程序的安全性。
StringBuilder		java.lang.String子类，jdk1.5开始。最终类名：字符串缓冲区，其中的数据可以被修改，类为最终类不能被继承。线程不同步，用于多线程程序，不能保证程序的安全性。
Throwable			java.lang.异常类，包括Exception和Error两个子类，
public							权限修饰符，最大权限 
protected						权限修饰符。低于pbulic.
default							权限修饰符，低于protected.
private							权限修饰符，低于default.
static							静态修饰符，修饰成员，修饰方法后为静态方法，静态方法只能调用静态方法。
void				java.lang.定义方法没有返回值类型
abstract						修饰符抽象，可以定义抽象方法，抽象类，抽象类至少有一个抽象方法。
final							修饰符最终，被修饰后，不能被继承，不能被重载（重写）。
extends							关键字继承，只能用在类与类之间，只有单继承没有多继承。
implements						关键字实现，只能用在类与接口之间，可以有多实现，接口与接口之间有多继承。
new								关键字新建，在堆内存中新开辟一个空间存储对象。
this							关键字引用，只能用在本类中，指向本类对象引用，也可以用在构造函数之间，
super							关键字引用，指向父类对象，用在构造函数中。
synchronized(对象)				关键字同步器，使用后，同一时间，程序只能被同一线程执行，不能被其他线程操作。
Thread				java.lang.类：关键字线程类。
Exception			java.lang.类：关键字异常类。
Runnable			java.lang.接口：关键字线程接口。
Lock				java.util.concurrent.locks.接口：关键字锁。获取锁的实例示例： Lock lock = new reentrantLock();
ReentrantLock		java.util.concurrent.locks.类：  关键字互斥锁，
Condition			java.util.concurrent.locks.接口：关键字监视器。
throws							异常声明，使用在函数上，后面可以跟多个异常类，用逗号隔开。
throw							异常声明，使用在函数内，后跟的是异常对象，throw new 异常对象名()。

instanceof						关键字判断，二元操作符，它的作用是判断其左边对象是否为其右边类的实例，返回boolean类型的数据。

InputStream			java.io.类，抽象基类，字符流的抽象基类。
OutputStream		java.io.类，抽象基类，字符流的抽象基类。
Reader				java.io.类，抽象基类，字节流的抽象基类。
Writer				java.io.类，抽象基类，字节流的抽象基类。

|--java.lang.Object:
	|--java.io.Writer								抽象类：
		|--java.io.OutputStreamWriter				实例类:转换流，字符流通向字节流的桥梁：
			|--java.io.FileWriter					实例类:
	|--java.io.BufferedWriter						缓冲区实例类：

|--java.lang.Object:
	|--java.io.Reader								抽象类：
		|--java.io.InputStreamReader				实例类:转换流，字节流通向字符流的桥梁：
			|--java.io.FileReader					实例类:
	|--java.io.BufferedReader						缓冲区实例类：
		|--java.io.LineNumberReader					行号缓冲区实例类：

|--java.lang.Object:
	|--java.io.InputStream							抽象类
		|--java.io.FilterInputStream				实例类
			|--java.io.BufferedInputStream			实例类

|--java.lang.Object:
	|--java.io.OutputStream							抽象类
		|--java.io.FilterOutputStream				实例类
			|--java.io.BufferedOutputStream			实例类：


Writer append(char c);									Writer 类中的方法，将指定字符添加到此 writer。
Writer append(CharSequence csq);						Writer 类中的方法，将指定字符序列添加到此 writer。
Writer append(CharSequence csq, int start, int end);	Writer 类中的方法，将指定字符序列的子序列添加到此 writer.Appendable。
void write(char[] cbuf);								Writer 类中的方法，写入字符数组的某一部分。
void write(String str, int off, int len);				Writer 类中的方法，写入字符串的某一部分。
abstract  void close();									Writer 类中的方法，关闭此流，但要先刷新它。
abstract  void flush();									Writer 类中的方法，刷新该流的缓冲。

void newLine();											BufferedWriter 类中的方法，写入一个行分隔符。
void write(char[] cbuf, int off, int len);				BufferedWriter 类中的方法，写入字符数组的某一部分。
void write(String s, int off, int len);					BufferedWriter 类中的方法，写入字符串的某一部分。	

void mark(int readAheadLimit);							Reader 类中的方法，标记流中的当前位置。
boolean markSupported();								Reader 类中的方法，判断此流是否支持 mark() 操作。
int read();												Reader 类中的方法，读取单个字符。
int read(char[] cbuf);									Reader 类中的方法，将字符读入数组。
abstract int read(char[] cbuf, int off, int len);		Reader 类中的方法，将字符读入数组的某一部分。
int read(CharBuffer target);							Reader 类中的方法，试图将字符读入指定的字符缓冲区。
void reset();											Reader 类中的方法，重置该流。
long skip(long n);										Reader 类中的方法，跳过字符。

void mark(int readAheadLimit);							BufferedReader 类中的方法，标记流中的当前位置。
boolean markSupported();								BufferedReader 类中的方法，判断此流是否支持 mark() 操作（它一定支持）。
String readLine();										BufferedReader 类中的方法，读取一个文本行。
boolean ready();										BufferedReader 类中的方法，判断此流是否已准备好被读取。
void reset();											BufferedReader 类中的方法，将流重置到最新的标记。
long skip(long n);										BufferedReader 类中的方法，跳过字符。
int getLineNumber();									LineNumberReader 类中的方法，获得当前行号。
void setLineNumber(int lineNumber);						LineNumberReader 类中的方法，设置当前行号。

int available();										BufferedInputStream 类中的方法，返回可以从此输入流读取（或跳过）、且不受此输入流接下来的方法调用阻塞的估计字节数。
int read(byte[] b, int off, int len);					BufferedInputStream 类中的方法，从此字节输入流中给定偏移量处开始将各字节读取到指定的 byte 数组中。

void write(byte[] b, int off, int len);					BufferedOutputStream 类中的方法，将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此缓冲的输出流。

String getEncoding();									InputStreamReader 类中的方法，返回此流使用的字符编码的名称。
String getEncoding();									OutputStreamWriter 类中的方法，返回此流使用的字符编码的名称。

PrintStream(File file, String csn)；								PrintStream 类中的方法，构造方法，创建具有指定文件名称和字符集且不带自动行刷新的新打印流。
PrintStream(OutputStream out, boolean autoFlush)；					PrintStream 类中的方法，构造方法，创建新的打印流。带自动刷新。
PrintWriter(File file, String csn);									PrintWriter 类中的方法，构造方法，创建具有指定文件和字符集且不带自动刷行新的新 PrintWriter。
PrintWriter(OutputStream out, boolean autoFlush);					PrintWriter 类中的方法，构造方法，通过现有的 OutputStream 创建新的 PrintWriter。
PrintWriter(Writer out, boolean autoFlush);							PrintWriter 类中的方法，构造方法，创建新 PrintWriter。带自动刷新。
PrintStream append(char c)；										PrintStream	 PrintWriter 类中的方法，将指定字符添加到此输出流。 
PrintStream append(CharSequence csq)；								PrintStream	 PrintWriter 类中的方法，将指定字符序列添加到此输出流。 
PrintStream append(CharSequence csq, int start, int end)；			PrintStream	 PrintWriter 类中的方法，将指定字符序列的子序列添加到此输出流。 
boolean checkError()；												PrintStream	 PrintWriter 类中的方法，刷新流并检查其错误状态。 
protected  void clearError()；										PrintStream	 PrintWriter 类中的方法，清除此流的内部错误状态。
PrintStream format(Locale l, String format, Object... args);		PrintStream	 PrintWriter 类中的方法，使用指定格式字符串和参数将格式化字符串写入此输出流中。 
PrintStream format(String format, Object... args);					PrintStream	 PrintWriter 类中的方法，使用指定格式字符串和参数将格式化字符串写入此输出流中。 
protected  void setError();											PrintStream	 PrintWriter 类中的方法，将该流的错误状态设置为 true。
PrintStream printf(Locale l, String format, Object... args);		PrintStream	 PrintWriter 类中的方法，使用指定格式字符串和参数将格式化的字符串写入此输出流的便捷方法。 
PrintStream printf(String format, Object... args);					PrintStream	 PrintWriter 类中的方法，使用指定格式字符串和参数将格式化的字符串写入此输出流的便捷方法。
void println(基本数据类型 x)；										PrintStream  PrintWriter 类中的方法，打印 基本数据类型，然后终止该行。

SequenceInputStream(Enumeration<? extends InputStream> e);			SequenceInputStream 类中的方法，构造方法，通过记住参数来初始化新创建的 SequenceInputStream，该参数必须是生成运行时类型为 InputStream 对象的 Enumeration 型参数。 
SequenceInputStream(InputStream s1, InputStream s2);				SequenceInputStream 类中的方法，构造方法，通过记住这两个参数来初始化新创建的 SequenceInputStream（将按顺序读取这两个参数，先读取 s1，然后读取 s2），以提供从此 SequenceInputStream 读取的字节。

int readInt();														ObjectInputStream 类中的方法，可以是基本数据类型，readLong();readFloat();读取一个 32 位的 int 值。
Object readObject();												ObjectInputStream 类中的方法，从 ObjectInputStream 读取对象。
void defaultReadObject();											ObjectInputStream 类中的方法，从此流读取当前类的非静态和非瞬态字段。
protected  boolean enableResolveObject(boolean enable);				ObjectInputStream 类中的方法，使流允许从该流读取的对象被替代。
void readFully(byte[] buf);											ObjectInputStream 类中的方法，读取字节，同时阻塞直至读取所有字节。
int skipBytes(int len);												ObjectInputStream 类中的方法，跳过字节。
protected  Object readObjectOverride();								ObjectInputStream 类中的方法，此方法由 ObjectOutputStream 的受信任子类调用，这些子类使用受保护的无参数构造方法构造 ObjectOutputStream。
String readUTF();													ObjectInputStream 类中的方法，读取 UTF-8 修改版格式的 String。
void writeBoolean(boolean val);										ObjectOutputStream 类中的方法，可以是基本数据类型，writeLong(),writeFloat()写入一个 boolean 值。 
void writeObject(Object obj);										ObjectOutputStream 类中的方法，将指定的对象写入 ObjectOutputStream。 
void defaultWriteObject();											ObjectOutputStream 类中的方法，将当前类的非静态和非瞬态字段写入此流。
protected  void drain();											ObjectOutputStream 类中的方法，排空 ObjectOutputStream 中的所有已缓冲数据。
protected  boolean enableReplaceObject(boolean enable);				ObjectOutputStream 类中的方法，允许流对流中的对象进行替换。 
ObjectOutputStream.PutField putFields();							ObjectOutputStream 类中的方法，获取用于缓冲写入流中的持久存储字段的对象。
protected  Object replaceObject(Object obj);						ObjectOutputStream 类中的方法，在序列化期间，此方法允许 ObjectOutputStream 的受信任子类使用一个对象替代另一个对象。
void reset();														ObjectOutputStream 类中的方法，重置将丢弃已写入流中的所有对象的状态。
protected  void writeStreamHeader();								ObjectOutputStream 类中的方法，提供 writeStreamHeader 方法，这样子类可以将其自身的头部添加或预加到流中。
void writeUTF(String str);											ObjectOutputStream 类中的方法，以 UTF-8 修改版格式写入此 String 的基本数据。

PipedInputStream();													PipedInputStream 类中的方法，构造方法，创建尚未连接的 PipedInputStream。 
PipedInputStream(int pipeSize);										PipedInputStream 类中的方法，构造方法，创建一个尚未连接的 PipedInputStream，并对管道缓冲区使用指定的管道大小。 
PipedInputStream(PipedOutputStream src);							PipedInputStream 类中的方法，构造方法，创建 PipedInputStream，使其连接到管道输出流 src。 
PipedInputStream(PipedOutputStream src, int pipeSize);				PipedInputStream 类中的方法，构造方法，创建一个 PipedInputStream，使其连接到管道输出流 src，并对管道缓冲区使用指定的管道大小。
PipedOutputStream();												PipedOutputStream 类中的方法，构造方法，创建尚未连接到管道输入流的管道输出流。 
PipedOutputStream(PipedInputStream snk);							PipedOutputStream 类中的方法，构造方法，创建连接到指定管道输入流的管道输出流。
int available();													PipedInputStream 类中的方法，返回可以不受阻塞地从此输入流中读取的字节数。 
void close();														PipedInputStream 类中的方法，关闭此管道输入流并释放与该流相关的所有系统资源。 
void connect(PipedOutputStream src);								PipedInputStream 类中的方法，使此管道输入流连接到管道输出流 src。 
int read();															PipedInputStream 类中的方法，读取此管道输入流中的下一个数据字节。 
int read(byte[] b, int off, int len);								PipedInputStream 类中的方法，将最多 len 个数据字节从此管道输入流读入 byte 数组。 
protected  void receive(int b);										PipedInputStream 类中的方法，接收数据字节。
void close();														PipedOutputStream 类中的方法，关闭此管道输出流并释放与此流有关的所有系统资源。 
void connect(PipedInputStream snk);									PipedOutputStream 类中的方法，将此管道输出流连接到接收者。 
void flush();														PipedOutputStream 类中的方法，刷新此输出流并强制写出所有缓冲的输出字节。 
void write(byte[] b, int off, int len);								PipedOutputStream 类中的方法，将 len 字节从初始偏移量为 off 的指定 byte 数组写入该管道输出流。 
void write(int b);													PipedOutputStream 类中的方法，将指定 byte 写入传送的输出流。

RandomAccessFile(File file, String mode);							RandomAccessFile 类中的方法，构造方法，mode可以是r,w,rw,rws,rwd,创建从中读取和向其中写入（可选）的随机访问文件流，该文件由 File 参数指定。 
RandomAccessFile(String name, String mode);							RandomAccessFile 类中的方法，构造方法，mode可以是r,w,rw,rws,rwd,创建从中读取和向其中写入（可选）的随机访问文件流，该文件具有指定名称。
long getFilePointer();												RandomAccessFile 类中的方法，返回此文件中的当前偏移量。
void seek(long pos);												RandomAccessFile 类中的方法，设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作。
int skipBytes(int n);												RandomAccessFile 类中的方法，尝试跳过输入的 n 个字节以丢弃跳过的字节。
String readLine();													RandomAccessFile 类中的方法，从此文件读取文本的下一行。
void close();														RandomAccessFile 类中的方法，关闭此随机访问文件流并释放与该流关联的所有系统资源。 
FileChannel getChannel();											RandomAccessFile 类中的方法，返回与此文件关联的唯一 FileChannel 对象。 
FileDescriptor getFD();												RandomAccessFile 类中的方法，返回与此流关联的不透明文件描述符对象。 
long length();														RandomAccessFile 类中的方法，返回此文件的长度。
int read();															RandomAccessFile 类中的方法，从此文件中读取一个数据字节。
boolean readBoolean();												RandomAccessFile 类中的方法，可以是八种基本数据类型，readInt();readChar(); 从此文件读取一个 boolean。
void readFully(byte[] b);											RandomAccessFile 类中的方法，将 b.length 个字节从此文件读入 byte 数组，并从当前文件指针开始。 
void readFully(byte[] b, int off, int len);							RandomAccessFile 类中的方法，将正好 len 个字节从此文件读入 byte 数组，并从当前文件指针开始。
int readUnsignedByte();												RandomAccessFile 类中的方法，从此文件读取一个无符号的八位数。 
int readUnsignedShort();											RandomAccessFile 类中的方法，从此文件读取一个无符号的 16 位数。
String readUTF();													RandomAccessFile 类中的方法，从此文件读取一个字符串。 
void setLength(long newLength);										RandomAccessFile 类中的方法，设置此文件的长度。 
void write(byte[] b);												RandomAccessFile 类中的方法，将 b.length 个字节从指定 byte 数组写入到此文件，并从当前文件指针开始。 
void write(byte[] b, int off, int len);								RandomAccessFile 类中的方法，将 len 个字节从指定 byte 数组写入到此文件，并从偏移量 off 处开始。 
void write(int b);													RandomAccessFile 类中的方法，向此文件写入指定的字节。
void writeBoolean(boolean v);										RandomAccessFile 类中的方法，可以是八种基本数据类型，writeInt();writeChar();按单字节值将 boolean 写入该文件。
void writeUTF(String str);											RandomAccessFile 类中的方法，使用 modified UTF-8 编码以与机器无关的方式将一个字符串写入该文件。

DataInputStream(InputStream in);									DataInputStream 类中的方法，构造方法，使用指定的底层 InputStream 创建一个 DataInputStream。
int readUnsignedByte();												DataInputStream 类中的方法，参见 DataInput 的 readUnsignedByte 方法的常规协定。 
int readUnsignedShort();											DataInputStream 类中的方法，参见 DataInput 的 readUnsignedShort 方法的常规协定。 
String readUTF();													DataInputStream 类中的方法，参见 DataInput 的 readUTF 方法的常规协定。 
static String readUTF(DataInput in);								DataInputStream 类中的方法，从流 in 中读取用 UTF-8 修改版格式编码的 Unicode 字符格式的字符串；然后以 String 形式返回此字符串。 
int skipBytes(int n);												DataInputStream 类中的方法，参见 DataInput 的 skipBytes 方法的常规协定。
void readFully(byte[] b);											DataInputStream 类中的方法，参见 DataInput 的 readFully 方法的常规协定。 
void readFully(byte[] b, int off, int len);							DataInputStream 类中的方法，参见 DataInput 的 readFully 方法的常规协定。 
int readInt();readShort();readLong();readBoolean();					DataInputStream 类中的方法，可以是八种基本数据类型，参见 DataInput 的 readInt 方法的常规协定。
DataOutputStream(OutputStream out);									DataOutputStream 类中的方法，构造方法，创建一个新的数据输出流，将数据写入指定基础输出流。
void flush();														DataOutputStream 类中的方法，清空此数据输出流。 
int size();															DataOutputStream 类中的方法，返回计数器 written 的当前值，即到目前为止写入此数据输出流的字节数。
void writeShort(int v);writeInt();writeBoolean();writeBytes();		DataOutputStream 类中的方法，可以是八种基本数据类型，将一个 short 值以 2-byte 值形式写入基础输出流中，先写入高字节。 
void writeUTF(String str);											DataOutputStream 类中的方法，以与机器无关方式使用 UTF-8 修改版编码将一个字符串写入基础输出流。

ByteArrayInputStream(byte[] buf);									ByteArrayInputStream 类中的方法，构造方法，创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组。 
ByteArrayInputStream(byte[] buf, int offset, int length);			ByteArrayInputStream 类中的方法，构造方法，创建 ByteArrayInputStream，使用 buf 作为其缓冲区数组。  
int available();													ByteArrayInputStream 类中的方法，返回可从此输入流读取（或跳过）的剩余字节数。 
void close();														ByteArrayInputStream 类中的方法，关闭 ByteArrayInputStream 无效。
void mark(int readAheadLimit);										ByteArrayInputStream 类中的方法，设置流中的当前标记位置。 
boolean markSupported();											ByteArrayInputStream 类中的方法，测试此 InputStream 是否支持 mark/reset。 
int read();															ByteArrayInputStream 类中的方法，从此输入流中读取下一个数据字节。 
int read(byte[] b, int off, int len);								ByteArrayInputStream 类中的方法，将最多 len 个数据字节从此输入流读入 byte 数组。 
void reset();														ByteArrayInputStream 类中的方法，将缓冲区的位置重置为标记位置。 
long skip(long n);													ByteArrayInputStream 类中的方法，从此输入流中跳过 n 个输入字节。
ByteArrayOutputStream();											ByteArrayOutputStream 类中的方法，构造方法，创建一个新的 byte 数组输出流。 
ByteArrayOutputStream(int size);									ByteArrayOutputStream 类中的方法，构造方法，创建一个新的 byte 数组输出流，它具有指定大小的缓冲区容量（以字节为单位）。 
void close();														ByteArrayOutputStream 类中的方法，关闭 ByteArrayOutputStream 无效。 
void reset();														ByteArrayOutputStream 类中的方法，将此 byte 数组输出流的 count 字段重置为零，从而丢弃输出流中目前已累积的所有输出。 
int size();															ByteArrayOutputStream 类中的方法，返回缓冲区的当前大小。 
byte[] toByteArray();												ByteArrayOutputStream 类中的方法，创建一个新分配的 byte 数组。 
String toString();													ByteArrayOutputStream 类中的方法，使用平台默认的字符集，通过解码字节将缓冲区内容转换为字符串。 
String toString(String charsetName);								ByteArrayOutputStream 类中的方法，使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串。 
void write(byte[] b, int off, int len);								ByteArrayOutputStream 类中的方法，将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此 byte 数组输出流。 
void write(int b);													ByteArrayOutputStream 类中的方法，将指定的字节写入此 byte 数组输出流。 
void writeTo(OutputStream out);										ByteArrayOutputStream 类中的方法，将此 byte 数组输出流的全部内容写入到指定的输出流参数中，这与使用 out.write(buf, 0, count) 调用该输出流的 write 方法效果一样。

CharArrayReader(char[] buf);										CharArrayReader 类中的方法，构造方法，根据指定的 char 数组创建一个 CharArrayReader。 
CharArrayReader(char[] buf, int offset, int length);				CharArrayReader 类中的方法，构造方法，根据指定的 char 数组创建一个 CharArrayReader。 
void close();														CharArrayReader 类中的方法，关闭该流并释放与之关联的所有系统资源。 
void mark(int readAheadLimit);										CharArrayReader 类中的方法，标记流中的当前位置。 
boolean markSupported();											CharArrayReader 类中的方法，判断此流是否支持 mark() 操作（它一定支持）。 
int read();															CharArrayReader 类中的方法，读取单个字符。 
int read(char[] b, int off, int len);								CharArrayReader 类中的方法，将字符读入数组的某一部分。 
boolean ready();													CharArrayReader 类中的方法，判断此流是否已准备好被读取。 
void reset();														CharArrayReader 类中的方法，将该流重置为最新的标记，如果从未标记过，则将其重置到开头。 
long skip(long n);													CharArrayReader 类中的方法，跳过字符。 
CharArrayWriter();													CharArrayWriter 类中的方法，构造方法，创建一个新的 CharArrayWriter。 
CharArrayWriter(int initialSize);									CharArrayWriter 类中的方法，构造方法，创建一个具有指定初始大小的新 CharArrayWriter。 
CharArrayWriter append(char c);										CharArrayWriter 类中的方法，将指定字符添加到此 writer。 
CharArrayWriter append(CharSequence csq);							CharArrayWriter 类中的方法，将指定的字符序列添加到此 writer。 
CharArrayWriter append(CharSequence csq, int start, int end);		CharArrayWriter 类中的方法，将指定字符序列的子序列添加到此 writer。 
void close();														CharArrayWriter 类中的方法，关闭该流。 
void flush();														CharArrayWriter 类中的方法，刷新该流的缓冲。 
void reset();														CharArrayWriter 类中的方法，重置该缓冲区，以便再次使用它而无需丢弃已分配的缓冲区。 
int size();															CharArrayWriter 类中的方法，返回缓冲区的当前大小。 
char[] toCharArray();												CharArrayWriter 类中的方法，返回输入数据的副本。 
String toString();													CharArrayWriter 类中的方法，将输入数据转换为字符串。 
void write(char[] c, int off, int len);								CharArrayWriter 类中的方法，将字符写入缓冲区。 
void write(int c);													CharArrayWriter 类中的方法，将一个字符写入缓冲区。 
void write(String str, int off, int len);							CharArrayWriter 类中的方法，字符串的某一部分写入缓冲区。 
void writeTo(Writer out);											CharArrayWriter 类中的方法，将缓冲区的内容写入另一个字符流。 

StringReader(String s);												StringReader 类中的方法，构造方法，创建一个新字符串 reader。 
void close();														StringReader 类中的方法，关闭该流并释放与之关联的所有系统资源。 
void mark(int readAheadLimit);										StringReader 类中的方法，标记流中的当前位置。 
boolean markSupported();											StringReader 类中的方法，判断此流是否支持 mark() 操作以及支持哪一项操作。 
int read();															StringReader 类中的方法，读取单个字符。 
int read(char[] cbuf, int off, int len);							StringReader 类中的方法，将字符读入数组的某一部分。 
boolean ready();													StringReader 类中的方法，判断此流是否已经准备好用于读取。 
void reset();														StringReader 类中的方法，将该流重置为最新的标记，如果从未标记过，则将其重置到该字符串的开头。 
long skip(long ns);													StringReader 类中的方法，跳过流中指定数量的字符。  
StringWriter();														StringWriter 类中的方法，构造方法，使用默认初始字符串缓冲区大小创建一个新字符串 writer。 
StringWriter(int initialSize);										StringWriter 类中的方法，构造方法，使用指定初始字符串缓冲区大小创建一个新字符串 writer。 
StringWriter append(char c);										StringWriter 类中的方法，将指定字符添加到此 writer。 
StringWriter append(CharSequence csq);								StringWriter 类中的方法，将指定的字符序列添加到此 writer。 
StringWriter append(CharSequence csq, int start, int end);			StringWriter 类中的方法，将指定字符序列的子序列添加到此 writer。 
void close();														StringWriter 类中的方法，关闭 StringWriter 无效。 
void flush();														StringWriter 类中的方法，刷新该流的缓冲。 
StringBuffer getBuffer();											StringWriter 类中的方法，返回该字符串缓冲区本身。 
String toString();													StringWriter 类中的方法，以字符串的形式返回该缓冲区的当前值。 
void write(char[] cbuf, int off, int len);							StringWriter 类中的方法，写入字符数组的某一部分。 
void write(int c);													StringWriter 类中的方法，写入单个字符。 
void write(String str);												StringWriter 类中的方法，写入一个字符串。 
void write(String str, int off, int len);							StringWriter 类中的方法，写入字符串的某一部分。

String getProperty(String key);													Properties 类中的方法，用指定的键在此属性列表中搜索属性。
String getProperty(String key, String defaultValue);							Properties 类中的方法，用指定的键在属性列表中搜索属性。
void list(PrintStream out);														Properties 类中的方法，将属性列表输出到指定的输出流。 
void list(PrintWriter out);														Properties 类中的方法，将属性列表输出到指定的输出流。 
void load(InputStream inStream);												Properties 类中的方法，从输入流中读取属性列表（键和元素对）。
void load(Reader reader);														Properties 类中的方法，按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。
void loadFromXML(InputStream in);												Properties 类中的方法，将指定输入流中由 XML 文档所表示的所有属性加载到此属性表中。
Enumeration<?> propertyNames();													Properties 类中的方法，返回属性列表中所有键的枚举，如果在主属性列表中未找到同名的键，则包括默认属性列表中不同的键。
Object setProperty(String key, String value);									Properties 类中的方法，调用 Hashtable 的方法 put。
void store(OutputStream out, String comments);									Properties 类中的方法，以适合使用 load(InputStream) 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。 
void store(Writer writer, String comments);										Properties 类中的方法，以适合使用 load(Reader) 方法的格式，将此 Properties 表中的属性列表（键和元素对）写入输出字符。
void storeToXML(OutputStream os, String comment);								Properties 类中的方法，发出一个表示此表中包含的所有属性的 XML 文档。
void storeToXML(OutputStream os, String comment, String encoding);				Properties 类中的方法，使用指定的编码发出一个表示此表中包含的所有属性的 XML 文档。
Set<String> stringPropertyNames();												Properties 类中的方法，返回此属性列表中的键集，其中该键及其对应值是字符串，如果在主属性列表中未找到同名的键，则还包括默认属性列表中不同的键。

boolean canExecute();															File 类中的方法，测试应用程序是否可以执行此抽象路径名表示的文件。						
boolean canRead();																File 类中的方法，测试应用程序是否可以读取此抽象路径名表示的文件。 						 
boolean canWrite();																File 类中的方法，测试应用程序是否可以修改此抽象路径名表示的文件。
boolean createNewFile();														File 类中的方法，当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
																								在指定位置创建文件，如果该文件已经存在，则不能创建，返回false。
																								和输出流不一样，输出流对象一建立就创建文件，而且文件如果存在则覆盖。
static File createTempFile(String prefix, String suffix);						File 类中的方法，在默认临时文件目录中创建一个空文件，使用给定前缀和后缀生成其名称。
static File createTempFile(String prefix, String suffix, File directory);		File 类中的方法，在指定目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称。
boolean delete();																File 类中的方法，删除此抽象路径名表示的文件或目录。删除失败返回false。 
void deleteOnExit();															File 类中的方法，在虚拟机终止时，请求删除此抽象路径名表示的文件或目录。 在程序退出时删除指定文件。
boolean exists();																File 类中的方法，测试此抽象路径名表示的文件或目录是否存在。 
String getName();																File 类中的方法，返回由此抽象路径名表示的文件或目录的名称。
String getPath();																File 类中的方法，将此抽象路径名转换为一个路径名字符串。
File getAbsoluteFile();															File 类中的方法，返回此抽象路径名的绝对路径名形式。
String getAbsolutePath();														File 类中的方法，返回此抽象路径名的绝对路径名字符串。
File getParentFile();															File 类中的方法，返回此抽象路径名父目录的抽象路径名；如果此路径名没有指定父目录，则返回 null。
String getParent();																File 类中的方法，返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。 
boolean isAbsolute();															File 类中的方法，测试此抽象路径名是否为绝对路径名。 
boolean isDirectory();															File 类中的方法，测试此抽象路径名表示的文件是否是一个目录。		
																						示例：File f = new File("文件名");文件未创建，返回false，使用boolean exists();判断是否存在。
boolean isFile();																File 类中的方法，测试此抽象路径名表示的文件是否是一个标准文件。	
																						示例：File f = new File("文件名");文件未创建，返回false，使用boolean exists();判断是否存在。
boolean isHidden();																File 类中的方法，测试此抽象路径名指定的文件是否是一个隐藏文件。
long lastModified();															File 类中的方法，返回此抽象路径名表示的文件最后一次被修改的时间。 
boolean setLastModified(long time);												File 类中的方法，设置此抽象路径名指定的文件或目录的最后一次修改时间。
long length();																	File 类中的方法，返回由此抽象路径名表示的文件的长度。
boolean mkdir();																File 类中的方法，创建此抽象路径名指定的目录。
																						注：只能创建一级目录。 
boolean mkdirs();																File 类中的方法，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
																						注：可以创建多级目录。
boolean renameTo(File dest);													File 类中的方法，重新命名此抽象路径名表示的文件。
																						注：将文件重命名。如果新文件在非源文件目录下，则剪切后重命名，功能类似于剪切。
boolean setExecutable(boolean executable, boolean ownerOnly);					File 类中的方法，设置此抽象路径名的所有者或所有用户的执行权限。 
boolean setReadable(boolean readable, boolean ownerOnly);						File 类中的方法，设置此抽象路径名的所有者或所有用户的读权限。
boolean setWritable(boolean writable, boolean ownerOnly);						File 类中的方法，设置此抽象路径名的所有者或所有用户的写权限。
URI toURI();																	File 类中的方法，构造一个表示此抽象路径名的 file: URI。
static File[] listRoots();														File 类中的方法，列出可用的文件系统根。示例：File files = File.listRoots();
String[] list();																File 类中的方法，返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。		
String[] list(FilenameFilter filter);											File 类中的方法，返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录。
File[] listFiles();																File 类中的方法，返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
File[] listFiles(FileFilter filter);											File 类中的方法，返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
File[] listFiles(FilenameFilter filter);										File 类中的方法，返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。

boolean accept(File dir, String name);					FilenameFilter 接口;测试指定文件是否应该包含在某一文件列表中，
																		注：接口只有一个方法，使用中可以使用匿名内部类的方式调用。

int compareTo(T o);										Comparable 接口的方法，比较此对象与指定对象的顺序。
				
int compare(T o1, T o2);								Comparator 接口中的方法，比较用来排序的两个参数。
boolean equals(Object obj);								Comparator 接口中的方法，指示某个其他对象是否“等于”此 Comparator。

V put(K key, V value);											Map 集合接口，jdk1.2开始，将指定的值与此映射中的指定键关联（可选操作）。
void putAll(Map<? extends K,? extends V> m);					Map 集合接口，jdk1.2开始，从指定映射中将所有映射关系复制到此映射中（可选操作）。
void clear()；													Map 集合接口，jdk1.2开始，从此映射中移除所有映射关系（可选操作）。
V remove(Object key);											Map 集合接口，jdk1.2开始，如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
boolean containsKey(Object key);								Map 集合接口，jdk1.2开始，如果此映射包含指定键的映射关系，则返回 true。
boolean containsValue(Object value);							Map 集合接口，jdk1.2开始，如果此映射将一个或多个键映射到指定值，则返回 true。
boolean isEmpty();												Map 集合接口，jdk1.2开始，如果此映射未包含键-值映射关系，则返回 true。
V get(Object key);												Map 集合接口，jdk1.2开始，返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
int size();														Map 集合接口，jdk1.2开始，返回此映射中的键-值映射关系数。
Collection<V> values();											Map 集合接口，jdk1.2开始，返回此映射中包含的值的 Collection 视图。
																		示例：Collection<String> coll = map.values();
Set<K> keySet();												Map 集合接口，jdk1.2开始，返回此映射中包含的键的 Set 视图。	
																		示例：Set<String> keySet = map.keySet(); Iterator<String> it2 = keySet.iterator();																					
Set<Map.Entry<K,V>> entrySet();									Map 集合接口，jdk1.2开始，返回此映射中包含的映射关系的 Set 视图。
																		示例：Set<Map.Entry<String,String>> entrySet = map.entrySet();
																			Iterator<Map.Entry<String,String>> it1 = entrySet.iterator();

boolean equals(Object o);								Map.Entry<K,V>接口中的方法，比较指定对象与此项的相等性。
K getKey();												Map.Entry<K,V>接口中的方法，返回与此项对应的键。
V getValue();											Map.Entry<K,V>接口中的方法，返回与此项对应的值。
int hashCode();											Map.Entry<K,V>接口中的方法，返回此映射项的哈希码值。
V setValue(V value);									Map.Entry<K,V>接口中的方法，用指定的值替换与此项对应的值（可选操作）。

boolean add(E e);										Collection 接口的方法，将指定的元素添加到此列表的尾部。
void add(int index, E element);							Collection 接口的方法，将指定的元素插入此列表中的指定位置。
boolean addAll(Collection<? extends E> c);				Collection 接口的方法，按照指定 collection 的迭代器所返回的元素顺序，将该 collection 中的所有元素添加到此列表的尾部。
boolean addAll(int index, Collection<? extends E> c);	Collection 接口的方法，从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。
void clear();											Collection 接口的方法，移除此列表中的所有元素。
boolean contains(Object o);								Collection 接口的方法，如果此列表中包含指定的元素，则返回 true。
boolean isEmpty();										Collection 接口的方法，如果此列表中没有元素，则返回 true。
Object remove(int index);								Collection 接口的方法，移除此列表中指定位置上的元素。
boolean remove(Object o);								Collection 接口的方法，移除此列表中首次出现的指定元素（如果存在）。
boolean removeAll(Collection<?> c);						Collection 接口的方法，从列表中移除指定 collection 中包含的其所有元素（可选操作）。清除交集，al1中只会保留和al2中不相同的元素。
boolean retainAll(Collection<?> c);						Collection 接口的方法，仅在列表中保留指定 collection 中所包含的元素（可选操作）。保留交集，al1中只会保留和al2中相同的元素。
int size();												Collection 接口的方法，返回列表中的元素数。
E set(int index, E element);							Collection 接口的方法，用指定的元素替代此列表中指定位置上的元素。

boolean removeAll(Collection<?> c);						List 接口中的方法，ArrayList类实现List接口，从列表中移除指定 collection 中包含的其所有元素（可选操作）。清除交集，al1中只会保留和al2中不相同的元素。
boolean retainAll(Collection<?> c);						List 接口中的方法，ArrayList类实现List接口，仅在列表中保留指定 collection 中所包含的元素（可选操作）。保留交集，al1中只会保留和al2中相同的元素。
int indexOf(Object o);									List 接口中的方法，返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。示例：List li = al.indexOf("java05");
List<E> subList(int fromIndex, int toIndex);			List 接口中的方法，返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图。示例：al.subList(1.3);
ListIterator<E> listIterator();							List 接口中的方法，返回此列表元素的列表迭代器（按适当顺序）。示例：ListIterator li = al.listIterator();
ListIterator<E> listIterator(int index);				List 接口中的方法，返回列表中元素的列表迭代器（按适当顺序），从列表的指定位置开始。

boolean add(E e);										ArrayList 类中的方法，实现List接口，将指定的元素添加到此列表的尾部。
void add(int index, E element);							ArrayList 类中的方法，实现List接口，将指定的元素插入此列表中的指定位置。
boolean addAll(int index, Collection<? extends E> c);	ArrayList 类中的方法，实现List接口，从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。
void clear();											ArrayList 类中的方法，实现List接口，移除此列表中的所有元素。
boolean contains(Object o);								ArrayList 类中的方法，实现List接口，如果此列表中包含指定的元素，则返回 true。
boolean isEmpty();										ArrayList 类中的方法，实现List接口，如果此列表中没有元素，则返回 true。
E remove(int index);									ArrayList 类中的方法，实现List接口，移除此列表中指定位置上的元素。
boolean remove(Object o);								ArrayList 类中的方法，实现List接口，移除此列表中首次出现的指定元素（如果存在）。
int size();												ArrayList 类中的方法，实现List接口，返回列表中的元素数。
E set(int index, E element);							ArrayList 类中的方法，实现List接口，用指定的元素替代此列表中指定位置上的元素。
E get(int index);										ArrayList 类中的方法，实现List接口，返回此列表中指定位置上的元素。
void trimToSize();										ArrayList 类中的方法，实现List接口，将此 ArrayList 实例的容量调整为列表的当前大小。

void addFirst(E e);void addLast(E e);					LinkedList 类中的方法，实现List接口，将指定元素添加到此列表的(开始)结尾。jdk1.5开始，如果集合中为空，则抛出NoSuchElementException异常。
void offerFirst(E e);void offerLast(E e);				LinkedList 类中的方法，实现List接口，将指定元素添加到此列表的(开始)结尾。jdk1.6开始，如果集合中为空，则抛出null。
E getFirst();E getLast();								LinkedList 类中的方法，实现List接口，获取但不移除此列表的第一个(最后一个)元素。jdk1.5开始，如果集合中为空，则抛出NoSuchElementException异常。
E peekFirst();E peekLast();								LinkedList 类中的方法，实现List接口，获取但不移除此列表的第一个(最后一个)元素。jdk1.6开始，如果集合中为空，则抛出null。
E removeFirst();E removeLast();							LinkedList 类中的方法，实现List接口，获取并移除此列表的(第一个)最后一个元素。jdk1.5开始，如果集合中为空，则抛出NoSuchElementException异常。
E pollFirst();E pollLast();								LinkedList 类中的方法，实现List接口，获取并移除此列表的(第一个)最后一个元素。jdk1.6开始，如果集合中为空，则抛出null。
boolean removeFirstOccurrence(Object o);				LinkedList 类中的方法，实现List接口，从此列表中移除第一次出现的指定元素（从头部到尾部遍历列表时）。jdk1.6开始。
boolean removeLastOccurrence(Object o);					LinkedList 类中的方法，实现List接口，从此列表中移除最后一次出现的指定元素（从头部到尾部遍历列表时）。jdk1.6开始。
Iterator<E> descendingIterator();						LinkedList 类中的方法，实现List接口，返回以逆向顺序在此双端队列的元素上进行迭代的迭代器。jdk1.6开始。
	
void copyInto(Object[] anArray);						Vector 类中的方法，实现List接口，将此向量的组件复制到指定的数组中。
E elementAt(int index);									Vector 类中的方法，实现List接口，返回指定索引处的组件。
E firstElement();										Vector 类中的方法，实现List接口，返回此向量的第一个组件（位于索引 0) 处的项）。
void insertElementAt(E obj, int index);					Vector 类中的方法，实现List接口，将指定对象作为此向量中的组件插入到指定的 index 处。
E lastElement();										Vector 类中的方法，实现List接口，返回此向量的最后一个组件。
void setElementAt(E obj, int index);					Vector 类中的方法，实现List接口，将此向量指定 index 处的组件设置为指定的对象。
void trimToSize();										Vector 类中的方法，实现List接口，对此向量的容量进行微调，使其等于向量的当前大小。

boolean hasMoreElements();								Enumeration 枚举接口中的方法，和Iterator接口的意思一样。测试此枚举是否包含更多的元素。
																	示例： Enumeration en = al.elements();
E nextElement();										Enumeration 枚举接口中的方法，配合Vector类使用。如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。

Iterator iterator();									Iterator<E>接口中的方法，返回在此 collection 的元素上进行迭代的迭代器。示例：Iterator it = al.iterator();
boolean hasNext();										Iterator<E>接口中的方法，如果仍有元素可以迭代，则返回 true。示例：al.hasNext();
E next();												Iterator<E>接口中的方法，返回迭代的下一个元素。		
void remove();											Iterator<E>接口中的方法，从迭代器指向的 collection 中移除迭代器返回的最后一个元素（可选操作）。
boolean hasNext();										ListIterator 接口中的方法，以正向遍历列表时，如果列表迭代器有多个元素，则返回 true（换句话说，如果 next 返回一个元素而不是抛出异常，则返回 true）。
E next();												ListIterator 接口中的方法，返回列表中的下一个元素。
boolean hasPrevious();									ListIterator 接口中的方法，如果以逆向遍历列表，列表迭代器有多个元素，则返回 true。示例：ListIterator li = al.listIterator();
E previous();											ListIterator 接口中的方法，返回列表中的前一个元素。
int previousIndex();									ListIterator 接口中的方法，返回对 previous 的后续调用所返回元素的索引。
int nextIndex();										ListIterator 接口中的方法，返回对 next 的后续调用所返回元素的索引。 

static addAll(Collection<? super T> c, T... elements);			Collections(类)中的方法，将所有指定元素添加到指定 collection 中。详细介绍见java20160106。
static binarySearch();											Collections(类)中的方法，使用二分搜索法搜索指定列表，以获得指定对象。详细介绍见java20160106。
static copy(List<? super T> dest, List<? extends T> src);		Collections(类)中的方法，将所有元素从一个列表复制到另一个列表。详细介绍见java20160106。
static fill(List<? super T> list, T obj);						Collections(类)中的方法，使用指定元素替换指定列表中的所有元素。详细介绍见java20160106。
static indexOfSubList(List<?> source, List<?> target);			Collections(类)中的方法，返回指定源列表中第一次出现指定目标列表的起始位置；如果没有出现这样的列表，则返回 -1。详细介绍见java20160106。
static reverse(List<?> list);									Collections(类)中的方法，反转指定列表中元素的顺序。详细介绍见java20160106。
static reverseOrder(Comparator<T> cmp);							Collections(类)中的方法，返回一个比较器，它强行逆转指定比较器的顺序。详细介绍见java20160106。
static replaceAll(List<T> list, T oldVal, T newVal);			Collections(类)中的方法，使用另一个值替换列表中出现的所有某一指定值。详细介绍见java20160106。
static shuffle(List<?> list, Random rnd);						Collections(类)中的方法，使用指定的随机源对指定列表进行置换。详细介绍见java20160106。
static sort(List<T> list, Comparator<? super T> c);				Collections(类)中的方法，根据指定比较器产生的顺序对指定列表进行排序。详细介绍见java20160106。
static swap(List<?> list, int i, int j);						Collections(类)中的方法，在指定列表的指定位置处交换元素。详细介绍见java20160106。

static asList(T... a);											Arrays(类)中的方法，返回一个受指定数组支持的固定大小的列表。详细介绍见java20160106。
static copyOf(基本数据类型[] original, int newLength);			Arrays(类)中的方法，复制指定的数组，截取或用 false 填充（如有必要），以使副本具有指定的长度。详细介绍见java20160106。jdk1.6开始。
static copyOfRange(基本数据类型[] original, int from, int to);	Arrays(类)中的方法，将指定数组的指定范围复制到一个新数组。详细介绍见java20160106。jdk1.6开始。
static deepEquals(Object[] a1, Object[] a2);					Arrays(类)中的方法，如果两个指定数组彼此是深层相等 的，则返回 true。详细介绍见java20160106。jdk1.5开始。
static toString(boolean[] a);									Arrays(类)中的方法，返回指定数组内容的字符串表示形式。详细介绍见java20160106。jdk1.5开始。
static sort(byte[] a);											Arrays(类)中的方法，对指定的 byte 型数组按数字升序进行排序。详细介绍见java20160106。
static fill(基本数据类型[] a, 基本数据类型 val);				Arrays(类)中的方法，将指定的 基本数据类型 值分配给指定 基本数据类型 型数组的每个元素。详细介绍见java20160106。

int length();														String 类中的方法，获取字符串的长度。
char charAt(int index);												String 类中的方法，返回的是字符，参数为整型数据。
int indexOf(int ch);												String 类中的方法，返回的是ch在字符串中第一次出现的位置。
int indexOf(int ch, int fromIndex);									String 类中的方法，从fromIndex指定位置开始，获取ch在字符串中出现的位置。
int lastIndexOf(int ch);											String 类中的方法，返回指定字符在此字符串中最后一次出现处的索引。
int lastIndexOf(int ch,int fromIndex);								String 类中的方法，返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。
int lastIndexOf(String str);										String 类中的方法，返回指定子字符串在此字符串中最右边出现处的索引。
int lastIndexOf(String str,int fromIndex);							String 类中的方法，返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。
boolean isEmpty();													String 类中的方法，当且仅当 length() 为 0 时返回 true。1.6版本以后才会有。
boolean startsWith(String prefix);									String 类中的方法，测试此字符串是否以指定的前缀开始。
boolean endsWith(String suffix);									String 类中的方法，测试此字符串是否以指定的后缀结束。 
boolean contains(CharSequence s);									String 类中的方法，当且仅当此字符串包含指定的 char 值序列时，返回 true。
boolean equalsIgnoreCase();											String 类中的方法，判断两个字符串中的内容是否相同，并忽略大小写。
String(char[]);														String 类中的构造方法，
String(char[],int offset,int count);								String 类中的构造方法，将字符数组中的一部分转换成字符串。
String(byte[]);														String 类中的构造方法，
String(byte[],int offset,int count);								String 类中的构造方法，将字节数组中的一部分转换成字符串。
char[] toCharArray();												String 类中的方法，将字符串转换成字符数组。
byte[] getBytes();													String 类中的方法，将字符串转换成字节数组。
static String copyValueOf(char[] data,int offset, int count);		String 类中的静态方法，将字符数组转换成字符串。
static String valueOf(int,double,float);							String 类中的静态方法，将基本数据类型转换成字符串，可以是整型，双精度等类型。
String replace(char oldChar,char newChar);							String 类中的方法替换，//如果要替换的字符不存在，返回的还是原串。
String [] split(regex);												String 类中的方法切割。将目标字符串分割成多个字符串。示例：String [] arr = s.split(",");
String substring(gegin,end);										String 类中的方法，截取字符串。包含头不包含尾。
String toUpperCase();												String 类中的方法，将字符串转换成大写或者小写：
String toLowerCase();												String 类中的方法，将字符串转换成大写或者小写：
String trim();														String 类中的方法，将字符串两端的多个空格去除；
int compareTo(string);												String 类中的方法，对两个字符串进行自然顺序的比较。
static void setIn(InputStream in);									String 类中的方法，重新分配“标准”输入流。
static void setOut(PrintStream out);								String 类中的方法，重新分配“标准”输出流。

void setLength(int newLength);											StringBuffer 类中的方法，设置新的数据区的长度。
StringBuffer append();													StringBuffer 类中的方法，将指定数据作为参数添加到已有数据的结尾处。
StringBuffer insert(index,数据);										StringBuffer 类中的方法，可以将数据插入指定位置。
StringBuffer delete(int start,int end);									StringBuffer 类中的方法，删除缓冲区中的数据，包含strat不包含end。
StringBuffer deleteCharAt(index);										StringBuffer 类中的方法，删除缓冲区中指定位置的字符。
void setCharAt(int index, char ch);										StringBuffer 类中的方法，替换缓冲区的某一位字符。
StringBuffer replace(int start, int end, String str);					StringBuffer 类中的方法，替换缓冲区中的指定字符串，包含strat不包含end。
StringBuffer reverse();													StringBuffer 类中的方法，将缓冲区的字符串进行反转;
void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin);		StringBuffer 类中的方法，将缓冲区中的指定数据存储到指定字符数组中。
																		示例：
																			StringBuffer sb = new StringBuffer("abcde");
																			char [] arr = new char[6];
																			sb.getChars(1,4,arr,2);
																			//从字符串角标值1开始读取到角标值为3(不包含end)停止，从字符数组角标值2开始存储到arr字符数组中。

static long currentTimeMillis();						System 类中的方法，获取当前时间到1970年1月1日0时0分0秒的时间差。可以用在打印语句内部。
static void gc();										System 类中的方法，启动垃圾回收器。
static String setProperty(String key, String value);	System 类中的方法，设置指定键指示的系统属性。
static Properties getProperties();						System 类中的方法，确定当前的系统属性。示例：Properties prop = System.getProperties();		
void list(PrintStream out);								Properties 类中的方法，将属性列表输出到指定的输出流。

xxx a = Xxx.parseXxx(String str);					Integer 类：字符串转换成基本数据类型;示例：int a = Integer.parseInt("123");long a = Long.parseLong("123");
static int parseInt(String s, int radix);			Integer 类：使用第二个参数指定的基数，将字符串参数解析为有符号的整数。示例：int x = Integer.parseInt("F6c",16)			
int intValue();										Integer 类：对象的调用方式返回整型数值；示例：Integer i = new Integer("123");
																								 int num = i.intValue();

void interrupt()									Thread 类中的方法，中断线程：让冻结(wait,sleep,jion)的线程恢复到运行状态中。
void setDaeMon(true)								Thread 类中的方法，后台线程，让线程结束，Java 虚拟机退出。
void join()											Thread 类中的方法，抢夺CPU执行权，优先执行，抛出异常InterruptedException。
void yield()										Thread 类中的方法，暂停当前执行的线程，转向下一个线程执行。
void setPriority(int newPriority);					Thread 类中的方法，MAX_PRIORITY，MIN_PRIORITY，NORM_PRIORITY。

void run();											Runnable 接口中的方法，只有一个，使用实现接口 Runnable 的对象创建一个线程时，启动该线程将导致在独立执行的线程中调用对象的 run 方法。 

getMessage();										返回此 throwable 的详细消息字符串。可以用在打印语句内部。
toString();											返回此 throwable 的简短描述。可以用在打印语句内部。
printStackTrace();									将此 throwable 及其追踪输出到指定的 PrintWriter。用在打印语句外面。
currentThread();									获取当前线程类中对象的引用。
	
wait()													Object 方法等待，用在synchronized中
notify()												Object 方法唤醒等待，用在synchronized中
notifyAll()												Object 方法唤醒所有等待，用在synchronized中

lock()													Lock 接口中的方法，获取锁和Condition中的方法配合使用。
unlock()												Lock 接口中的方法，释放锁和Condition中的方法配合使用。
newCondition()											Lock 接口中的方法，返回绑定到此 Lock 实例的新 Condition 实例。
																示例：private Conditon condition = lock.newCondition();
await()													Condition 接口中的一个线程等待的方法，和Lock接口的方法配合使用。
signal()												Condition 接口中的唤醒一个线程的方法，和Lock接口的方法配合使用。
signalAll()												Condition 接口中的唤醒所有线程的方法，和Lock接口的方法配合使用。

Process exec(String command)；							Runtime 类中的方法，在单独的进程中执行指定的字符串命令。
static Runtime getRuntime();							Runtime 类中的方法，返回与当前 Java 应用程序相关的运行时对象。

static double abs(double a);							Math 类中的方法，返回 double 值的绝对值。
static double ceil(double a);							Math 类中的方法，返回最小的（最接近负无穷大）double 值，该值大于等于参数，并等于某个整数。
static double floor(double a);							Math 类中的方法，返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数。							
static double cbrt(double a);							Math 类中的方法，返回 double 值的立方根。jdk1.5开始。
static double sqrt(double a);							Math 类中的方法，返回正确舍入的 double 值的正平方根。
static double pow(double a, double b);					Math 类中的方法，返回第一个参数的第二个参数次幂的值。
static double exp(double a);							Math 类中的方法，返回欧拉数 e 的 double 次幂的值。					
static double log(double a);							Math 类中的方法，返回 double 值的自然对数（底数是 e）。
static double random();									Math 类中的方法，返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。			

Date parse(String text, ParsePosition pos);										SimpleDateFormat 类中的方法，解析字符串的文本，生成 Date。
String toPattern();																SimpleDateFormat 类中的方法，返回描述此日期格式的模式字符串。
StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos);		SimpleDateFormat 类中的方法，将给定的 Date 格式化为日期/时间字符串，并将结果添加到给定的 StringBuffer。

void roll(int field, int amount);												Calendar 抽象类，GregorianCalendar 子类中的方法，向指定日历字段添加指定（有符号的）时间量，不更改更大的字段。
void set(int year, int month, int date, int hourOfDay, int minute, int second);	Calendar 抽象类，GregorianCalendar 子类中的方法，设置字段 YEAR、MONTH、DAY_OF_MONTH、HOUR、MINUTE 和 SECOND 的值。
static Calendar getInstance(TimeZone zone, Locale aLocale);						Calendar 抽象类，GregorianCalendar 子类中的方法，使用指定时区和语言环境获得一个日历。
int get(int field);																Calendar 抽象类，GregorianCalendar 子类中的方法，返回给定日历字段的值。
void add(int field, int amount);												Calendar 抽象类，GregorianCalendar 子类中的方法，根据日历规则，将指定的（有符号的）时间量添加到给定的日历字段中。
TimeZone getTimeZone();															Calendar 抽象类，GregorianCalendar 子类中的方法，获得时区。


integer							十进制关键字。
binary							二进制关键字。
hex								十六进制关键字。
octal							八进制关键字。
equals(Object obj)				比较两个对象是否相同。


interpretation					单词说明，程序的使用手册(使用javadoc进行编译)
constructor						构造函数单词。
encapsulation					封装单词。
polymorphism					多态单词。


单例设计模式：解决一个类在内存中只存在一个对象。
步骤代码实现：
		1,将构造函数私有化。
		2,在类中创建一个本类对象。
		3,提供一个方法可以获取到该对象。
单例设计模式分为懒汉式和饿汉式两种。
		
什么是模板方法呢？
	在定义功能(方法)时，功能(方法)的一部分是确定的，但是有一部分是不确定，而确定的部分在使用不确定的部分，
	那么这时就将不确定的部分暴露出去，由该类的子类去完成。
	(继承,抽象,最终方法的加强练习)。

装饰设计模式：
		当想要对已有的对象进行功能增强时，可以定义类，将已有对象传入，基于已有对象的功能，
		并提供加强功能，那么自定义的该类就称为装饰类。
	
		装饰类通常会通过构造方法接收被装饰的对象，并基于被装饰的对象的功能提供更强的功能。
		
		装饰设计模式比继承要灵活，避免了继承体系的臃肿，而且降低了类于类之间的关系。

		装饰类因为增强已有对象，具备的功能和已有对象是相同的，只不过提供了更强的功能，
		所以装饰类和被装饰类都属于一个体系中。

泛型，即“参数化类型”。一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。
		jdk1.5开始出现的新特性，用于解决安全问题，是一个安全机制。
		好处：
		1，将运行时期出现问题ClassCastException，转移到了编译时期，
			方便程序员解决问题，让运行事情问题减少，安全。
		2，避免了强制类型转换的麻烦。



Jdk4j   Dom4j