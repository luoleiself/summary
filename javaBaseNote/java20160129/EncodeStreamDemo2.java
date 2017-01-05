/*

*/
import java.io.*;
class  EncodeStreamDemo2
{
	public static void main(String[] args) 
	{
		String str = "联通";
		byte[] by = str.getBytes("GBK");

		for (byte b:by)
		{
			//十进制转换成二进制取最低八位。
			Sytem.out.println(Integer.toBinaryString(b&255));
		}
	}
}
