package study163;

/*
	三元运算符
*/


class TernaryOperaDemo{
	public static void main(String[] args)
	{
		// 需求：给出一个小数，需要求出四舍五入的结果，如何完成该功能
		/*
			1.获取3.49小数的整数部分--3；
			2.获取3.49的小数部分--3.49-3 -->0.49；
			3.吧0.49和0.5作比较
				0.49 >= 0.5 --> 3+1
				0.49 < 0.5 -->3				
			
			三元云算法or三目运算符
			数据类型 变量=boolean表达式 ? 值1 :值2;
			
			如果:boolean表达式结果为true,三元运算表达式结果就是值1;
					否则,就是值2;
			
		*/
		double num = 3.49;
		
		int num1 = (int)num;//整数部分
		double num2 = num - num1;
		
		int result = num2 >= 0.5 ? num1 + 1 : num1;
		System.out.println(result);
		
		
		// 1).两个数求最大值/最小值;
		int a = 20;
		int b = 10;
		int max = a >=b ? a : b;
		System.out.println(max);
		int min = a <=b ? a : b;
		System.out.println(min);
		
		
		// 2).判断一个数是奇数还是偶数;
		int number = 10;
		String ret = number % 2 == 0 ? "偶数" : "奇数"; //考虑到负数的情况,余数要判断是不是0
		System.out.println(ret);
		
	}
}