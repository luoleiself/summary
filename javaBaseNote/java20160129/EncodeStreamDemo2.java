/*

*/
import java.io.*;
class  EncodeStreamDemo2
{
	public static void main(String[] args) 
	{
		String str = "��ͨ";
		byte[] by = str.getBytes("GBK");

		for (byte b:by)
		{
			//ʮ����ת���ɶ�����ȡ��Ͱ�λ��
			Sytem.out.println(Integer.toBinaryString(b&255));
		}
	}
}
