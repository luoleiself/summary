/*
JDK1.5�汾����ֵ������ԣ�
			�����Ŀɱ������
				��ʹ��ʱע�⣬�ɱ����һ��Ҫ�����ڲ����б������档
	
*/
class  ParamMethodDemo1
{
	public static void main(String[] args) 
	{
		/*
		��Ȼ�ٶ����˶��������
		����ÿ�ζ�Ҫ����һ�����飬��Ϊʵ�ʲ�����
		int[] arr = {2,3,4};
		show(arr);

		int[] arr1 = {2,3,4,5};
		show(arr1);
		*/

		//�ɱ��������ʵ������һ����������ļ�д��ʽ������ÿһ�ζ��ֶ��Ľ����������
		//ֻҪ��������Ԫ����Ϊ�������ݼ��ɡ���ʽ�Ľ���Щ������װ�����顣
		show("java001",2,3,4);
		show(2,3,4,5,6);

	}
	public static void show (String str,int... arr)
	{
		System.out.println(arr);//arr.length
	}
	public static void show (int... arr)
	{
		System.out.println(arr);//arr.length
	}
	
	public static void show (int[] arr)
	{
		System.out.println(arr);
	}

	/*
	public static void show (int a, int b)
	{

	}
	public static void show (int a, int b, int c )
	{

	}
	*/
}
