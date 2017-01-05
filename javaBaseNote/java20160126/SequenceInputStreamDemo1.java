/*
|--java.lang.Object
	|--java.io.InputStream
		|--java.io.SequenceInputStream

序列流：SequenceInputStream
	SequenceInputStream 表示其他输入流的逻辑串联。它从输入流的有序集合开始，并从第一个输入流开始读取，
	直到到达文件末尾，接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末尾为止。	
	构造函数：
	SequenceInputStream(Enumeration<? extends InputStream> e); 
          通过记住参数来初始化新创建的 SequenceInputStream，该参数必须是生成运行时类型为 InputStream 对象的 Enumeration 型参数。 
	SequenceInputStream(InputStream s1, InputStream s2); 
          通过记住这两个参数来初始化新创建的 SequenceInputStream（将按顺序读取这两个参数，先读取 s1，然后读取 s2），以提供从此 SequenceInputStream 读取的字节。 

*/
class  SequenceInputStreamDemo1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
