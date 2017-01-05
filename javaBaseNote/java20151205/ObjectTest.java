/*
object:是所有对象的直接后者间接父亲，传说的上帝。
	   该类中定义的肯定是所有对象都具备的方法，

Object 类中已经提供了对对象是否相同的比较方法equals();
如果自定义类中也有比较相同的方法，没有必要重新定义。
只要沿袭父类中的方法，建立自己特有比较内容即可，这就是重写(覆盖)。


*/
class Demo //extends Objext
{
	public boolean equals(Object obj)//多态的体现：Object obj = new Demo();
	{	
		if (!(obj instanceof Demo))//首先判断如果引用类型不是建立的对象，直接返回错误值。
		{
			return False;
		}
		else
		{
			Demo m3 = (Demo)obj;//类型向下转型;
			return this.num = d.num;
		}
		
	}
}
class  ObjectTest
{
	public static void main(String[] args) 
	{
		Demo m1 = new Demo();
		Demo m2 = new Dmeo();
		Demo m3 = m1;
		System.out.println(m1,equals(m2));//equals()比较引用类型变量的地址值。
		System.out.println(m1,equals(m3));
	}
}
