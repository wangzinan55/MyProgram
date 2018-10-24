package study163;



/*
	++和--的问题
*/




class ArithmeticOperatorsDemo{
	public static void main(String[] args)
	{
		/*
			++前置情况：
				++a  表示：a变量自身先加1，再运算。			
			
			++后置情况：
				a++  表示：a变量自身先加1，把递增1之前的原始值拿去做运算。（先赋值后运算的说法是错误的）
				
		*/
		int a1 = 5;
		int b1 = ++ a1;
		System.out.println("a1=" + a1 +",b1=" + b1); //a1=6,b1=6
		
		System.out.println("================================");
		
		int a2 = 5;
		int b2 = a2++;
		System.out.println("a2=" + a2 +",b2=" + b2); //a1=6,b1=5

			
			
	}
}