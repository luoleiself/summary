����һ����˳��ģ��������յ���ֽڼ��ϣ��Ƕ����ݴ�����ܳƻ����
�����������豸��Ĵ����Ϊ�������ı��������ݴ��䣬�������ݴ������Խ�������Ϊ�����࣬�����ֱ�۵Ľ������ݲ�����

���ݴ����������͵Ĳ�ͬ��Ϊ���ַ������ֽ��� 

������������ͬ��Ϊ���������������

���ݹ��ܲ�ͬ��Ϊ���ڵ����ʹ�����

�ڵ�������һ���ض�������Դ��д���ݡ����ڵ�����ֱ�Ӳ����ļ�������ȵ�����
		����FileInputStream��FileOutputStream������ֱ�Ӵ��ļ��ж�ȡ�����ļ���д���ֽ�����

�������������ӡ����Ѵ��ڵ������ڵ�����������֮��ͨ�������ݵĴ���Ϊ�����ṩ��Ϊǿ��Ķ�д���ܡ�
		��������ʹ��һ���Ѿ����ڵ�����������������Ӵ����ģ����������ǶԽڵ�������һϵ�еİ�װ��
		����BufferedInputStream��BufferedOutputStream��ʹ���Ѿ����ڵĽڵ��������죬�ṩ������Ķ�д������˶�д��Ч�ʣ�
		�Լ�DataInputStream��DataOutputStream��ʹ���Ѿ����ڵĽڵ��������죬�ṩ�˶�дJava�еĻ����������͵Ĺ��ܡ����Ƕ����ڹ�������

�ַ������ֽ���������
		1����д��λ��ͬ���ֽ������ֽڣ�8bit��Ϊ��λ���ַ������ַ�Ϊ��λ���������ӳ���ַ���һ�ο��ܶ�����ֽڡ�
		2���������ͬ���ֽ����ܴ����������͵����ݣ���ͼƬ��avi�ȣ������ַ���ֻ�ܴ����ַ����͵����ݡ�
		3���ֽ����ڲ�����ʱ�����ǲ����õ��������ģ����ļ������ֱ�Ӳ����ģ�
			���ַ����ڲ�����ʱ���º��ǻ��õ��������ģ���ͨ���������������ļ������ǽ���������֤��һ�㡣

���ۣ�����ѡ���ֽ�����������ΪӲ���ϵ������ļ��������ֽڵ���ʽ���д�����߱���ģ�����ͼƬ�����ݡ�
		�����ַ�ֻ�����ڴ��вŻ��γɵģ������ڿ����У��ֽ���ʹ�ù㷺��

����			�ֽ�������				�ֽ������				�ַ�������			�ַ������

�������		InputStream				OutputStream			Reader				Writer

�������		FilterInputStream		FilterOutputStream		FilterReader		FilterWriter

�����ļ�		FileInputStream			FileOutputStream		FileReader			FileWriter

��������		ByteArrayInputStream	ByteArrayOutputStream	CharArrayReader		CharArrayWriter

���ʹܵ�		PipedInputStream		PipedOutputStream		PipedReader			PipedWriter

�����ַ���														StringReader		StringWriter

������			BufferedInputStream		BufferedOutputStream	BufferedReader		BufferedWriter

ת����															InputStreamReader	OutputStreamWriter

������			ObjectInputStream		ObjectOutputStream
	
��ӡ��									PrintStream									PrintWriter

�ƻ�������		PushbackInputStream								PushbackReader

������			DataInputStream			DataOutputStream

java.io
	|--Reader �ַ�������
	|--Writer �ַ������
	|--InputStream �ֽ�������
	|--OutputStream �ֽ������

InputStream
	|--�ڵ������ͣ�
		|--FileInputStream			�ļ�������
		|--PipedInputStream			�ܵ�������
		|--ByteArrayInputStream		�ֽ�����������
	|--���������ͣ�
		|--BufferedInputStream		��������������	
		|--SequenceInputStream		˳��������
		|--DataInputStream			���������
		|--ObjectInputStream		����������
OutputStream
	|--�ڵ������ͣ�
		|--FileOutputStream			�ļ������
		|--PipedOutputStream		�ܵ������
		|--ByteArrayOutputStream	�ֽ����������
	|--���������ͣ�
		|--BufferedOutputStream		�������������
		|--DataOutputStream			���������
		|--ObjectOutputStream		���������
		|--PrintStream				��ӡ�����
Reader
	|--�ڵ������ͣ�
		|--FileReader
		|--PipedReader
		|--CharArrayReader
	|--���������ͣ�
		|--BufferedReader
		|--InputStreamReader
Writer
	|--�ڵ������ͣ�
		|--FileWriter
		|--PipedWriter
		|--CharArrayWriter
	|--���������ͣ�
		|--BufferedWriter
		|--OutputStreamWriter
		|--PrintWriter

InputStream
	|--StringBufferInputStream		�ַ���������������
	|--ByteArrayInputStream			�ֽ�����������
	|--FileInputStream				�ļ�������
	|--PipedInputStream				�ܵ�������
	|--SequenceInputStream			˳��������
	|--FilterInputStream			������������
		|--BufferedInputStream		��������������
		|--PushbackInputStream		����������
		|--LineNumberInputStream	�к�������
		|--DataInputStream			����������
			|--ObjectInputStream	����������
OutputStream
	|--ByteArrayOutputStream		�ֽ����������
	|--FileOutputStream				�ļ������
	|--PipedOutputStream			�ܵ������
	|--FilterOutputStream			�����������
		|--BufferedOutputStream		�������������
		|--PrintStream				��ӡ�����
		|--DataOutputStream			���������
			|--ObjectOutputStream	���������

һ����I/O������������ࣺ
		1. Memory (1)��/���ڴ������д����: CharArrayReader�� CharArrayWriter��ByteArrayInputStream��ByteArrayOutputStream
               (2)��/���ڴ��ַ�����д���� StringReader��StringWriter��StringBufferInputStream
		2.Pipe�ܵ�  ʵ�ֹܵ����������������̼�ͨ�ţ�: PipedReader��PipedWriter��PipedInputStream��PipedOutputStream
		3.File �ļ��������ļ����ж���д���� ��FileReader��FileWriter��FileInputStream��FileOutputStream
		4.ObjectSerialization �������롢��� ��ObjectInputStream��ObjectOutputStream
		5.DataConversion������ �������������Ͷ���д�������������Java�Ļ������ͣ��粼���ͣ��ֽڣ������͸�����������DataInputStream��DataOutputStream
		6.Printing ��������Ĵ�ӡ���� ��PrintWriter��PrintStream
		7.Buffering����  �ڶ����д��ʱ�������ݽ��л��棬�Լ���I/O�Ĵ�����BufferedReader��BufferedWriter��BufferedInputStream��BufferedOutputStream
		8.Filtering �����������ݽ��ж���дʱ���й��ˣ�FilterReader��FilterWriter��FilterInputStream��FilterOutputStream��
		9.Concatenation�ϲ����� �Ѷ�����������ӳ�һ�������� ��SequenceInputStream 
		10.Counting����  �ڶ�������ʱ���м��� ��LineNumberReader��LineNumberInputStream
		11.Peeking Ahead ͨ��������ƣ�����Ԥ�� ��PushbackReader��PushbackInputStream
		12.Converting between Bytes and Characters ����һ���ı���/�����׼���ֽ���ת��Ϊ�ַ�����
				����з���ת����Stream��Reader,Writer��ת���ࣩ��InputStreamReader��OutputStreamWriter

������������Դ��ȥ�򣩷��ࣺ 
		1��File���ļ����� FileInputStream, FileOutputStream, FileReader, FileWriter 
		2��byte[]�� ByteArrayInputStream, ByteArrayOutputStream 
		3��Char[]: CharArrayReader, CharArrayWriter 
		4��String: StringBufferInputStream, StringReader, StringWriter 
		5�������������� InputStream, OutputStream, Reader, Writer 

File ��������������Ĺ�ϵ��
	File����InputStream / OutputStream��ͬ����һ������������������ļ����ݡ�
	File����Ҫ���������ļ�����ѯ�ļ����Ժʹ����ļ�Ŀ¼��

File�๲�ṩ��������ͬ�Ĺ��캯�����Բ�ͬ�Ĳ�����ʽ���ؽ����ļ���Ŀ¼����Ϣ�����캯����
(1)File (String   pathname)   
     ��:File  f1=new File("FileTest1.txt"); //�����ļ�����f1��f1��ָ���ļ����ڵ�ǰĿ¼�´�����FileTest1.txt
(2)File (String  parent  ,  String child)
     ��:File f2=new  File(��D:\\dir1","FileTest2.txt"); //ע�⣺D:\\dir1Ŀ¼���ȱ�����ڣ������쳣
(3)File (File    parent  , String child)
     ��:File  f4=new File("\\dir3");
          File  f5=new File(f4,"FileTest5.txt");  //����� //dir3Ŀ¼������ʹ��f4.mkdir()�ȴ���
 һ����Ӧ��ĳ�����ļ���Ŀ¼��File����һ�������� �Ϳ���ͨ���������ķ���������ļ���Ŀ¼�����ԡ�    
       (1)public boolean exists( ) �ж��ļ���Ŀ¼�Ƿ����
       (2)public boolean isFile( ) �ж����ļ�����Ŀ¼ 
       (3)public boolean isDirectory( ) �ж����ļ�����Ŀ¼
       (4)public String getName( ) �����ļ�����Ŀ¼��
       (5)public String getPath( ) �����ļ���Ŀ¼��·����
       (6)public long length( ) ��ȡ�ļ��ĳ��� 
       (7)public String[ ] list ( ) ��Ŀ¼�������ļ����������ַ��������з��ء� 
 File���л�������һЩ���ļ���Ŀ¼���й��������ķ��������õķ����У�
       (1) public boolean renameTo( File newFile );   �������ļ�
	   (2) public void delete( );  ɾ���ļ�
       (3) public boolean mkdir( ); ����Ŀ¼

