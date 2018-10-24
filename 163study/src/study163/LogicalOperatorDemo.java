package study163;
/*
	逻辑运算符
*/


class LogicalOperatorDemo{
	public static void main(String[] args)
	{
		/*
			与: boolean表达式  与  boolean表达式
				当两个boolean表达式都为true,结果才为true,其他情况结果才为false
				& : 位与
				&& : 短路与
				
				& 和 && 的区别:
				&: 即使A表达式为false,也会判断B表达式,再返回false
				&&:如果A表达式为false,则不再判断表达式,直接返回false
				
				短路与(&&) 效率更高
				
		*/
		
		System.out.println(true & true);
		System.out.println(true & false);
		System.out.println(false & true);
		System.out.println(false & false);
		System.out.println("------------------------");
		
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		System.out.println("------------------------");
		
		//System.out.println(false & (1/0 == 1)); //有错说明后半句也执行了
		//System.out.println(false && (1/0 == 1)); //没有错说明后半句没有执行了

		
		/*
			或: boolean表达式  或  boolean表达式
				当两个boolean表达式都为false,结果才为false,其他情况结果才为true 
				
				| 和 || 的区别:
				|: 即使A表达式为true,也会判断B表达式,再返回true
				||:如果A表达式为true,则不再判断表达式,直接返回true
				
				短路与(&&) 效率更高
				
		*/
		System.out.println("=======================");
		System.out.println(true | true);
		System.out.println(true | false);
		System.out.println(false | true);
		System.out.println(false | false);
		System.out.println("------------------------");
		
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		System.out.println("------------------------");
		
		//System.out.println(true | (1/0 == 1)); //有错说明后半句也执行了
		//System.out.println(true || (1/0 == 1)); //没有错说明后半句没有执行了
		
		
		
		/*
			异或 ^
				
				表达式A和B相同,结果为false,否则为true
		*/
		
		System.out.println("=======================");
		System.out.println(true ^ true);
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		System.out.println(false ^ false);
		
		
	}
}