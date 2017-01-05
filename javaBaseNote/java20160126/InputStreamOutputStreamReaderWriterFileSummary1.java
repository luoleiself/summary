流是一组有顺序的，有起点和终点的字节集合，是对数据传输的总称或抽象。
即数据在两设备间的传输称为流，流的本质是数据传输，根据数据传输特性将流抽象为各种类，方便更直观的进行数据操作。

根据处理数据类型的不同分为：字符流和字节流 

根据数据流向不同分为：输入流和输出流

根据功能不同分为：节点流和处理流

节点流：从一个特定的数据源读写数据。即节点流是直接操作文件，网络等的流，
		例如FileInputStream和FileOutputStream，他们直接从文件中读取或往文件中写入字节流。

处理流：“连接”在已存在的流（节点流或处理流）之上通过对数据的处理为程序提供更为强大的读写功能。
		过滤流是使用一个已经存在的输入流或输出流连接创建的，过滤流就是对节点流进行一系列的包装。
		例如BufferedInputStream和BufferedOutputStream，使用已经存在的节点流来构造，提供带缓冲的读写，提高了读写的效率，
		以及DataInputStream和DataOutputStream，使用已经存在的节点流来构造，提供了读写Java中的基本数据类型的功能。他们都属于过滤流。

字符流和字节流的区别：
		1，读写单位不同：字节流以字节（8bit）为单位，字符流以字符为单位，根据码表映射字符，一次可能读多个字节。
		2，处理对象不同：字节流能处理所有类型的数据（如图片、avi等），而字符流只能处理字符类型的数据。
		3，字节流在操作的时候本身是不会用到缓冲区的，是文件本身的直接操作的；
			而字符流在操作的时候下后是会用到缓冲区的，是通过缓冲区来操作文件，我们将在下面验证这一点。

结论：优先选用字节流。首先因为硬盘上的所有文件都是以字节的形式进行传输或者保存的，包括图片等内容。
		但是字符只是在内存中才会形成的，所以在开发中，字节流使用广泛。

分类			字节输入流				字节输出流				字符输入流			字符输出流

抽象基类		InputStream				OutputStream			Reader				Writer

抽象基类		FilterInputStream		FilterOutputStream		FilterReader		FilterWriter

访问文件		FileInputStream			FileOutputStream		FileReader			FileWriter

访问数组		ByteArrayInputStream	ByteArrayOutputStream	CharArrayReader		CharArrayWriter

访问管道		PipedInputStream		PipedOutputStream		PipedReader			PipedWriter

访问字符串														StringReader		StringWriter

缓冲流			BufferedInputStream		BufferedOutputStream	BufferedReader		BufferedWriter

转换流															InputStreamReader	OutputStreamWriter

对象流			ObjectInputStream		ObjectOutputStream
	
打印流									PrintStream									PrintWriter

推回输入流		PushbackInputStream								PushbackReader

特殊流			DataInputStream			DataOutputStream

java.io
	|--Reader 字符输入流
	|--Writer 字符输出流
	|--InputStream 字节输入流
	|--OutputStream 字节输出流

InputStream
	|--节点流类型：
		|--FileInputStream			文件输入流
		|--PipedInputStream			管道输入流
		|--ByteArrayInputStream		字节数组输入流
	|--处理流类型：
		|--BufferedInputStream		带缓冲区输入流	
		|--SequenceInputStream		顺序输入流
		|--DataInputStream			数据输出流
		|--ObjectInputStream		对象输入流
OutputStream
	|--节点流类型：
		|--FileOutputStream			文件输出流
		|--PipedOutputStream		管道输出流
		|--ByteArrayOutputStream	字节数组输出流
	|--处理流类型：
		|--BufferedOutputStream		带缓冲区输出流
		|--DataOutputStream			数据输出流
		|--ObjectOutputStream		对象输出流
		|--PrintStream				打印输出流
Reader
	|--节点流类型：
		|--FileReader
		|--PipedReader
		|--CharArrayReader
	|--处理流类型：
		|--BufferedReader
		|--InputStreamReader
Writer
	|--节点流类型：
		|--FileWriter
		|--PipedWriter
		|--CharArrayWriter
	|--处理流类型：
		|--BufferedWriter
		|--OutputStreamWriter
		|--PrintWriter

InputStream
	|--StringBufferInputStream		字符串缓冲区输入流
	|--ByteArrayInputStream			字节数组输入流
	|--FileInputStream				文件输入流
	|--PipedInputStream				管道输入流
	|--SequenceInputStream			顺序输入流
	|--FilterInputStream			过滤器输入流
		|--BufferedInputStream		带缓冲区输入流
		|--PushbackInputStream		回退输入流
		|--LineNumberInputStream	行号输入流
		|--DataInputStream			数据输入流
			|--ObjectInputStream	对象输入流
OutputStream
	|--ByteArrayOutputStream		字节数组输出流
	|--FileOutputStream				文件输出流
	|--PipedOutputStream			管道输出流
	|--FilterOutputStream			过滤器输出流
		|--BufferedOutputStream		带缓冲区输出流
		|--PrintStream				打印输出流
		|--DataOutputStream			数据输出流
			|--ObjectOutputStream	对象输出流

一、按I/O类型来总体分类：
		1. Memory (1)从/向内存数组读写数据: CharArrayReader、 CharArrayWriter、ByteArrayInputStream、ByteArrayOutputStream
               (2)从/向内存字符串读写数据 StringReader、StringWriter、StringBufferInputStream
		2.Pipe管道  实现管道的输入和输出（进程间通信）: PipedReader、PipedWriter、PipedInputStream、PipedOutputStream
		3.File 文件流。对文件进行读、写操作 ：FileReader、FileWriter、FileInputStream、FileOutputStream
		4.ObjectSerialization 对象输入、输出 ：ObjectInputStream、ObjectOutputStream
		5.DataConversion数据流 按基本数据类型读、写（处理的数据是Java的基本类型（如布尔型，字节，整数和浮点数））：DataInputStream、DataOutputStream
		6.Printing 包含方便的打印方法 ：PrintWriter、PrintStream
		7.Buffering缓冲  在读入或写出时，对数据进行缓存，以减少I/O的次数：BufferedReader、BufferedWriter、BufferedInputStream、BufferedOutputStream
		8.Filtering 滤流，在数据进行读或写时进行过滤：FilterReader、FilterWriter、FilterInputStream、FilterOutputStream过
		9.Concatenation合并输入 把多个输入流连接成一个输入流 ：SequenceInputStream 
		10.Counting计数  在读入数据时对行记数 ：LineNumberReader、LineNumberInputStream
		11.Peeking Ahead 通过缓存机制，进行预读 ：PushbackReader、PushbackInputStream
		12.Converting between Bytes and Characters 按照一定的编码/解码标准将字节流转换为字符流，
				或进行反向转换（Stream到Reader,Writer的转换类）：InputStreamReader、OutputStreamWriter

二、按数据来源（去向）分类： 
		1、File（文件）： FileInputStream, FileOutputStream, FileReader, FileWriter 
		2、byte[]： ByteArrayInputStream, ByteArrayOutputStream 
		3、Char[]: CharArrayReader, CharArrayWriter 
		4、String: StringBufferInputStream, StringReader, StringWriter 
		5、网络数据流： InputStream, OutputStream, Reader, Writer 

File 类于输入输出流的关系：
	File类与InputStream / OutputStream类同属于一个包，它不允许访问文件内容。
	File类主要用于命名文件、查询文件属性和处理文件目录。

File类共提供了三个不同的构造函数，以不同的参数形式灵活地接收文件和目录名信息。构造函数：
(1)File (String   pathname)   
     例:File  f1=new File("FileTest1.txt"); //创建文件对象f1，f1所指的文件是在当前目录下创建的FileTest1.txt
(2)File (String  parent  ,  String child)
     例:File f2=new  File(“D:\\dir1","FileTest2.txt"); //注意：D:\\dir1目录事先必须存在，否则异常
(3)File (File    parent  , String child)
     例:File  f4=new File("\\dir3");
          File  f5=new File(f4,"FileTest5.txt");  //在如果 //dir3目录不存在使用f4.mkdir()先创建
 一个对应于某磁盘文件或目录的File对象一经创建， 就可以通过调用它的方法来获得文件或目录的属性。    
       (1)public boolean exists( ) 判断文件或目录是否存在
       (2)public boolean isFile( ) 判断是文件还是目录 
       (3)public boolean isDirectory( ) 判断是文件还是目录
       (4)public String getName( ) 返回文件名或目录名
       (5)public String getPath( ) 返回文件或目录的路径。
       (6)public long length( ) 获取文件的长度 
       (7)public String[ ] list ( ) 将目录中所有文件名保存在字符串数组中返回。 
 File类中还定义了一些对文件或目录进行管理、操作的方法，常用的方法有：
       (1) public boolean renameTo( File newFile );   重命名文件
	   (2) public void delete( );  删除文件
       (3) public boolean mkdir( ); 创建目录

