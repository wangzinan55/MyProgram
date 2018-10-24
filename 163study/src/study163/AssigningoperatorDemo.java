package study163;

/*
	赋值运算符
*/


class AssigningoperatorDemo{
	public static void main(String[] args)
	{
		String name;
		name = "will";
		System.out.println(name);
		
		System.out.println("--------------------------");
		
		/*
			+= 中间不能空格, 自带隐式类型转换
			
			int a = 10 ;
			a += 5 ; 等价于 a = a + 5 
			
		*/
		int a = 10 ;
		a += 5;
		System.out.println(a);
	
	}
}