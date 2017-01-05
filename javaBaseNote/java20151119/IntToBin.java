/*
֪ʶ�㣺������1.append() ������洢��һ���������棬���ȶ��������1������һ��������
		������1.reverse() �������ת���(�������Ϊ�����ӡ���);
		StringBuffer ������ �ؼ��ֶ���ɱ����Ե��ַ���������;

ʹ�ò������ϰ����ת��;	
*/
class  IntToBin
{	//ʮ����ת�����ƣ�
	public static void toBin(int num)
	{
		StringBuffer sb = new StringBuffer();//����һ���ַ���������
		while(num>0)
		{
			sb.append(num%2);//sb.append()�����ǽ����ֵ�洢��һ�������ڣ�
			num=num/2;
		}
		System.out.println(sb.reverse());// sb.reverse()�ǽ������ڵ����ݷ�ת�����
	}
	//ʮ����תʮ�����ƣ�
	public static void toHex(int num)
	{
		StringBuffer sb = new StringBuffer();//����һ���ַ���������
		for (int x=0;x<8;x++)
		{ 
			int temp = num & 15;//��Ϊʮ�����������ȡֵ��ΧΪ15��F��������λ��ʾΪ4λ��
			if (temp>9)
			{
				sb.append((char)(temp-10+'A'));//����������15����������9ʱ����Ҫ����A��Ӧ����ֵ65��
			}
			else
				sb.append(temp);
			num=num>>>4;
		}
		System.out.println(sb.reverse());//sb.reverse()�ǽ������ڵ����ݷ�ת���;
	}
	//ʮ����ת�˽��ƣ�
	public static void toOct(int num)
	{
		StringBuffer sb = new StringBuffer();//����һ���ַ���������
		while(num!=0)
		{
			int temp=num&7;//�˽��������ֵΪ7��
			sb.append(temp);
			num=num>>>3;//�˽�������Ӧ�Ķ�������λΪ3λ;
		}
		System.out.println(sb.reverse());//sb.reverse()�ǽ������ڵ����ݷ�ת���;
	}
	
	//������н���ת����
	/*
	˼·�����������Ҫ�����������飬һ�����ڲ�ѯ��Ӧֵ������һ����Ҫ�洢ת�������ֵ��ͬʱ��Ҫ����һ��ָ�룬
		  ָ���ʮ��������ֵ�����ں����Ԫ�صĶ�ȡ��
	
	���裺    
		  1,���ȶ�һ���ַ�������chs�������˴�0��F��Ԫ�أ������ڶ���һ���ַ�������arr���ڴ����15֮�����ֵ��
		    ������ַ�������arr����Ϊʮ��������ֵ�����ַ���һ��int���������ڴ���ռ��4���ֽڹ�32λ��
			ת��ʮ������ʱ��Ҫͬʱȡ4λ�������Ҫ������ַ������鳤��Ϊ8��

		  2,��chs�����д�ŵĽǱ�Ϊtemp���ַ���ֵ��arr����Ǳ�Ϊpos��Ԫ�أ�
		  3,ʹ��forѭ�������е���ȡֵ����ӡ���arr�����е�Ԫ�أ�
	*/
	public static void toHex1(int num)
	{	
		char [] chs={'0','1','2','3','4','5','6','7','8','9', 'A', 'B','C', 'D', 'E', 'F'};//����һ��������бȽϲ��ң�
	  //char [] chs={'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15'};�Ǳ�ֵ��ʮ�����������ֵһ�¡�
		
		char [] arr=new char [8];//����Ϊʲôȡ8����Ϊʮ������һ��ȡ4λ����8��4λ��
		int pos =0;
		while(num!=0)
		{
			int temp =num&15;
			arr[pos++]=chs[temp];//����15��ֵ��Ϊ�Ǳ�Ӳο������еĶ�Ӧ��Ԫ�ظ�ֵ���¶����ָ������顣
			num=num>>>4;
		}
		for (int x=pos-1;x>=0;x--)//��forѭ������������Ԫ�ص����ӡ�����
		{
			System.out.print(arr[x]+",");//ע�⻻�з����÷�;
		}
	}
	/*
	���ϴ�����Խ����ݻ���
	public static void toHex1(int num)
	{
		char [] chs={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char [] arr=new char [8];
		int pos =arr.length;//���Ƚ������ָ���ֵ��ֵΪ�����ַ�������ĳ��ȣ�Ϊ�˺����������ӡ�����
		while(num!=0)
		{
			int temp =num&15;
			arr[--pos]=chs[temp];//��ִ���Լ�1�����磺���Ǳ�Ϊ8ʱ���Լ�1��Ϊ7���и�ֵ������
			num=num>>>4;
		}
		for (int x=pos;x<arr.length;x++)//��ָ��pos��ʼ�����ӡ��
		{
			System.out.print(arr[x]+",");
		}
	}
	*/
	
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		toBin(60);
		toHex(60);
		toHex1(60);
	}
	/*
	�ܽ᣺
		���ò�����н���ת����������Ҫ��ȷ�����ο�ֵ���бȽϣ������ο�ֵ��ֵ���¶����������Ȼ��������
		ת�������ֵҪע��ȡֵ��˳��
	*/
}
