//ʮ����ת(�����ƣ��˽��ƣ�ʮ������)��ֵ�еĽ���ת��������
//���淽����Ҫȷ��Ҫת������ֵ��ת���Ļ���base(1,7,15)�����ұ��˵�λ��offset(1,3,15)

class  IntTo
{
	//ʮ����ת(�����ƣ��˽��ƣ�ʮ������)��ֵ�еĽ���ת��������
	//���淽����Ҫȷ��Ҫת������ֵ��ת���Ļ���base(1,7,15)�����ұ��˵�λ��offset(1,3,15)
	public static void trans(int num,int base,int offset)
	{
		if(num==0)
		{
			System.out.println(0);
			return ;
		}
		char [] chs={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char [] arr=new char [32];//��Ϊ��ֵ�����ڴ���ռ�õ����λΪ32λ��
		int pos =arr.length;
		while(num!=0)
		{
			int temp =num & base;
			arr[--pos]=chs[temp];
			num=num>>>offset;//�޷�������offsetλ��
		}
		for (int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);//ע��ln���з���ʹ�÷�����
		}
	}
	//ʮ����-->������;
	public static void toBin(int num)
	{
		trans(num,1,1);
	}
	//ʮ����-->�˽���;
	public static void toOct(int num)
	{
		trans(num,7,3);
	}
	//ʮ����-->ʮ������;
	public static void toHex(int num)
	{
		trans(num,15,4);
	}
	public static void main(String[] args) 
	{
		toBin(99);
		System.out.println();
		toOct(99);
		System.out.println();
		toHex(99);
		System.out.println();
		System.out.println("Hello World!");
	}
}
