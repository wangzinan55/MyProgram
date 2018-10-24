package study163;

/*
	交换两个变量的值
*/


public class SwapVarDemo
{
	public static void main(String[] args)
	{
		//一般是使用一个中间变量temp
		//不用中间变量,用算数运算的方式(缺点:只能用于数字类型,字符串类型不行)
		
		int a = 10;
		int b = 20;
		
		a = b - a; //求出ab两点的距离,保存到a中
		b = b - a; //求出a到原点的距离,并保存到b中(b到原点的距离与ab两点距离只差)
		a = b + a; //求出b到原点的距离,并保存到a中(a到原点距离与ab两点距离之和)
		
		System.out.println("a=" + a + ", " + "b=" + b);
	}
}