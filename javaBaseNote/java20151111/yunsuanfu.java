/*
优先级		运算符分类		结合顺序			运算符
			
			分隔符			左结合			.    []     ( )     ;      ,
由
			一元运算符		右结合			!  ++     --     -   ~

高			算术运算符		左结合			*     /      %    +     -      <<   >>   >>>
			移位运算符
			
到			关系运算符		左结合			<     >     <=   >=   instanceof(Java 特有)   = =  !=

			逻辑运算符		左结合			! &&  ||  ~  &  |  ^
低
			三目运算符		右结合			布尔表达式?表达式1:表达式2

			赋值运算符		右结合			=  *=     /=  %=   +=   -=    <<= >>= >>>=  &=  *=  |=
		
				一元运算符				

	运算符				含义				例子			
	-			改变数值的符号，取反		-x（-1*x）
	~			逐位取反，属于位运算符		~x
	++			自加1						x++
	--			自减1						x--		
	
				算术运算符

	运算符				含义				例子
	+				加法运算				x+y
	-				减法运算				x-y
	*				乘法运算				x*y
	/				除法运算				x/y
	%				取模运算（求余运算）	x%y	(取模的余数的符号只和被除数符号相同)
			
			 
				移位运算符
	运算符				含义				例子
	<<										x<<3
	>>										x>>3
	>>>										x>>>3

				关系运算符
	运算符				含义				例子
	<					小于				x<y
	>					大于				x>y
	<=					小于等于			x<=y
	>=					大于等于			x>=y
	==					等于				x==y
	!=					不等于				x!=y

				赋值运算符
	运算符				例子				含义
	+=					x+=y				x=x+y
	-=					x-=y				x=x-y
	*=					x*=y				x=x*y
	/=					x/=y				x=x/y
	%=					x%=y				x=x%y
	>>=					x>>=y				x=x>>y
	>>>=				a>>>=y				x=x>>>y
	<<=					a<<=y				x=x<<y
	&=					x&=y				x=x&y
	|=					x|=y				x=x|y
	^=					x^=y				x=x^y
				
						逻辑运算符
	 A	 	 B      A&&B     A||B	!A		A^B		A&B		A|B
    false	false	false	false	true	false	false	false
    true	false	false	true	false	true	false	true
    false	true	false	true	true	true	false	true
    true	true	true	true	false	false	true	true 		




			

*/

class haha 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
