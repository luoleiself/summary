/*
StaticImport ��̬���롣
		1������������ʱ����Ҫָ������İ�����
		2������������ʱ���ƶ����������Ķ�������ࡣ
			
*/
import java.util.*;
import static java.util.Arrays.*;//�������Arrays������е����о�̬��Ա��
import static java.lang.*;//����System�������еľ�̬��Ա��
class  StaticImportDemo1
{
	public static void main(String[] args) 
	{
		int[] arr = {0,1,2,3,4,5};

		sort(arr);

		int index = binarySearch(arr,3);
		out.println(Arrays.toString(arr));
		System.out.println("index=:"+index);
	}
}
