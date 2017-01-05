/*
知识点：
	一：泛型类定义的泛型，在整个类中有效，如果被方法使用，那么泛型类的对象明确要操作的具体类型后，
所有要操作的类型就已经固定了。
		为了让不同方法可以操作不同类型，而且类型还不确定，那么可以泛型定义在方法上。

注意：泛型定义在方法上，泛型应放到返回值类型的前面。

特殊之处：
		静态方法不可以访问类上定义的泛型，如果静态方法操作的应用数据类型不确定，可以将泛型定义在方法上。
*/
class Demo1<T>//泛型类在初始化时确定引用数据类型后，其中的方法也确定了引用数据类型。
{
	public void show(T t)
	{
		System.out.println("show:"+t);
	}
	public void print(T t)
	{
		System.out.println("print:"+t);
	}
	public static <T> void println(T t)//静态方法先于对象的建立而加载，无法访问非静态成员。
	{
		System.out.println("print:"+t);
	}

}
//============================================================
class Demo2
{
	public <T> void show(T t)//将方法定义泛型后，方法不用考虑调用者的数据类型。
	{
		System.out.println("show:"+t);
	}
	public <T> void print(T t)
	{
		System.out.println("print:"+t);
	}
}
class  GenericStaticDemo4
{
	public static void main(String[] args) 
	{
		/*
		Demo1<Integer> d1 = new Demo1<Integer>();
		d1.show(new Integer(4));
		d1.print(4);

		Demo1<String> d2 = new Demo1<String>();
		d2.show("abc");
		d2.print('4');
		*/

		Demo2 d1 = new Demo2();
		d1.show("abcdefg");
		d1.show(new Integer(4));
		d1.print("heihei");
	}
}
