/*
泛型定义在接口上
	第一种方式：在实现泛型接口的同时明确类类型，建立的对象也只能使用针对泛型定义的类型。
	
	第二种方式：在实现泛型接口的同时不明确实类类型，可以在建立对象的时候明确类类型。
*/
interface Inter<T>
{
	public static final  int NUM = 10;//接口的定义格式。 
	public abstract void show (T t);
}

//第一种方式：先明确实现泛型接口的类类型。
class InterImpl implements	Inter<String>
{
	public void show(String t)
	{
		System.out.println("show:"+t);
	}
}

//第二种方式：不明确实现泛型接口的类类型，在建立对象的时候再明确。
class InterImpl<T> implements Inter<T>
{
	public void show(T t)
	{
		System.out.println("show:"+t);
	}
}
class  GenericInterfaceDemo5
{
	public static void main(String[] args) 
	{
		//InterImpl i = new InterImpl();
		//i.show("hahaha");

		InterImpl<Integer> i = new InterImpl<Integer>();
		i.show(4);
	}
}
