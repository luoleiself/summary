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
		this(name);//this���ֻ�ܶ����ڹ��캯���ĵ�һ��;
		this.age=age;
	}
	public void show()
	{
		System.out.println(this.name+","+this.age);//��������ͬһ���У�����ʡ��this.
	}
}
class ThisTest1 
{
	public static void main(String[] args) 
	{
		This t =new This("zhangsan",25);
		t.show();
		System.out.println("Hello World!");
	}
}
