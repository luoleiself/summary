/*
if语句定义格式：
if（判断条件）
{   
	语句主体1；
} 
else 
{   
	语句主体2；
} 

switch语句定义格式：
switch（表达式）
{  
	case 选择值1：
		语句主体1；             
		break； 
	case 选择值2：
		语句主体2；				
		break； 
		……   
	case 选择值n：
		语句主体n；                 
		break；  
	default: 
		语句主体；
		break;
}
*/
/**			
需求一：输入一个数字，判断并输出数字对应的星期。使用if和switch语句进行编写，并使用不同的判断方法。
需求二：输入一个数字，判断并输出数字对应的季节。使用if和switch语句进行编写，并使用不同的判断方法。
目的：练习之前所学到的各种运算符的操作，变量的定义，数据类型的掌握，if和switch语句的掌握情况。
思想：
需求一：首先输入一个数字必须满足1至7之间，否则无法判断数字对应的星期。
需求二：季节包括4个季节;
3-5为春季，6-8为夏季，9-11为秋季，12-1为冬季。首先输入一个数字必须满足1至12区间，否则判断结果无效。
步骤：
需求一：
1、首先定一个类，类名为Test.java，并写出main主函数保证类的正常运行，
2、举例定义一个int型变量a，赋值为4，使用if语句进行判断a是否满足条件，输出a对应的星期。否则输出报错。
3、使用switch语句同样编写一个输出数字对应星期的程序。
需求二：
1、首先定义一个int型变量b，赋值6，使用if语句进行判断是否满足1至12的区间，输出b对应的季节，否则输出报错。
2、使用switch语句同样编写一个输出数字对应姐姐的程序。
*/
//方法一:输入一个数字，判断并输出对应的星期。
//注意细节：if语句的判断条件不需要用分号，if语句的大括号中如果有一条语句的话可以省略大括号不写;
/*总结：
switch语句：1、switch语句支持四种类型：Byte short int  char 
			2、default语句可以和case事件顺序调换，执行顺序不变。
			3、结束方式是以大括号或者break结束。
			4、如果case事件都不满足条件，从default语句往下执行，直到遇到break或者大括号结束。
if和switch语句的使用场景：1、如果数据类型有 Byte short int char 使用switch语句效率更高。
						  2、对于区间的判断和布尔型的数据使用if语句，if语句的使用范围更广。	
*/
/*
运算符的应用：算术运算符，逻辑运算符，比较运算符，位运算符，关系运算符，三元运算符。
*/
class Test 
{
	public static void main(String[] args)
	{	
		int a = 7;
		if(a==4)//if语句的大括号中如果有一条语句的话可以省略大括号不写;
		{ 
			System.out.println("当前输入的数字对应的星期为："+"星期四");
		}
		else if(a==1)
		{
			System.out.println("当前输入的数字对应的星期为："+"星期一");
		}
		else if(a==2)
		{
			System.out.println("当前输入的数字对应的星期为："+"星期二");
		}
		else if(a==3)
		{
			System.out.println("当前输入的数字对应的星期为："+"星期三");
		}
		else if(a==5)
		{
			System.out.println("当前输入的数字对应的星期为："+"星期五");
		}
		else if(a==6)
		{
			System.out.println("当前输入的数字对应的星期为："+"星期六");
		}
		else if(a==7)
		{
			System.out.println("当前输入的数字对应的星期为："+"星期日");
		}
		else
		{
			System.out.println("当前输入的数字超出范围，请检查后重新入");
		}
		
		int c=9;
		if (c>12||c<1)
		{
			System.out.println("输入的数字超出范围，请检查后重新输入");
		}
		else if(c>=3 && c<=5)
		{
			System.out.println("当前输入的数字对应的季节为："+"春季");	
		}
		else if(c>=6 && c<=8)
		{
			System.out.println("当前输入的数字对应的季节为："+"夏季");
		}
		else if(c>=9 && c<=11)
		{
			System.out.println("当前输入的数字对应的季节为："+"秋季");
		}
		else
		{
			System.out.println("当前输入的数字对应的季节为："+"冬季");
		}
		
		
		/*下面使用switch语句进行输出练习;
		switch语句可以将case事件一样的写到一块，也可以全部分开写但是阅读性差;
		switch语句是以break或者大括号结束运行;
		*/
		int b=11;
		switch(b)
		{
			case 12:
			case 1:
			case 2:
				System.out.println("当前输入的数字对应的季节为："+"冬季");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("当前输入的数字对应的季节为："+"春季");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("当前输入的数字对应的季节为："+"夏季");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("当前输入的数字对应的季节为："+"秋季");
				break;
			default:
				System.out.println("当前输入的数字超出范围，请检查后重新输入");
				break;	
		}
		
		/*
		总结：
		if和switch语句的区别：
		1，如果数据类型有 Byte short int char 使用switch语句效率更高。
		2，if语句能够判断数值型数据，区间，switch语句不能判断Boolean型数据。
		3，如果使用switch语句判断区间的话，就需要把执行语句详细划分，使得程序的阅读性降低，
		4，如果需要判断区间的话使用if语句效果更好。
		*/
	}
}