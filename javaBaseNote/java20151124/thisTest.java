/*
һ��this:���ֳ�Ա�����;ֲ�������
		������Ķ��������ں���������������ã�
		�ĸ������ڵ���this���ڵĺ�����this�ʹ����ĸ�����		

this��Ӧ�ã����������й���ʱ���ú����ڲ�Ҫ�õ����øú����Ķ���ʱ����ʱ��this����ʾ�������
			�������๦��(����������)�ڲ�ʹ���˱�����󣬶���this��ʾ��

����this���ֻ�����ڹ��캯��֮�以����ã�һ�㺯���͹��캯��֮�䲻��ʹ��this���;
	��ʽ��this(����);
	
����this���ֻ�ܶ����ڹ��캯���ĵ�һ��;

�ġ���������ͬһ���У�����ʡ��this.

�κ���ϰһ�����˶���һ�����ڱȽ������Ƿ���ͬ�Ĺ��ܣ�Ҳ�����Ƿ���ͬ���ˡ�

*/
class This
{
	private String name;
	private int age;
	This(int age)
	{
		this.age=age;
	}
	This(String name)
	{
		this.name=name;//�ĸ�����������������this�ʹ����ĸ������name;
	}
	This(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public void speak()
	{
		System.out.println("name="+this.name+",age="+this.age);//ʡ����this.
		this.show();	
	}
	public void show()
	{
		System.out.println(this.name);//��������ͬһ���У�����ʡ��this.
	}
	//�κ���ϰһ��
	//�Ƚ������˵�����Ĵ�С������ֵ����Ϊ����������(�ǣ���);��δ֪��Ԫ�ز�������;
	public boolean compare (This t)
	{
		return this.name==t.name;//this.˭���õ����������this�ʹ�����������������t1;
	}
}
class  ThisTest
{
	public static void main(String[] args) 
	{
		//This t= new This("zhangsan");
		This t1 =new This(20);
		This t2 =new This(40);
		boolean b = t1.compare(t2);//t1������comparative��������t2��ֵ������t;
		System.out.println(b);

		System.out.println("Hello World!");
	}
	/*
	�ܽ᣺
		this��ʹ�ã�1,this:���ֳ�Ա�����;ֲ�������
					2,���������й���ʱ���ú����ڲ�Ҫ�õ����øú����Ķ���ʱ����ʱ��this����ʾ�������
					  ��ʽ��this.��Ա;
					3,this���ֻ�����ڹ��캯��֮�以����ã�һ�㺯���͹��캯��֮�䲻��ʹ��this���;
					  ��ʽ��this(����);
					4,this���ֻ�ܶ����ڹ��캯���ĵ�һ��;
					5,��������ͬһ���У�����ʡ��this.
	*/
}
