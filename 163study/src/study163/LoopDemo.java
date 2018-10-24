package study163;

//for循环(有限知道循环次数的前提下,一般首选for循环)
/*
	从性能上分析:for循环性能更高.
	因为变量定义在for循环里面,for循环执行完毕,就会释放该变量的存储空间
*/

public class LoopDemo
{
	public static void main(String[] args)
	{
		//案例1:叫500次师妹,打印500次
		for(int count = 0;count < 5;count++)
		{
			System.out.println("师妹");	
		}
		System.out.println("ending...........");	
		System.out.println("--------------------------------");
		
		//案例2:从1数到100,打印1-100
		for(int num = 1;num <= 100;num++)
		{
			System.out.println(num);
		}
		System.out.println("ending............");
		System.out.println("--------------------------------");
		
		//案例3:计算100以内正整数之和
		int result = 0;//表示前n个数之和
		for(int number = 1;number <= 100;number++)
		{
			result += number;
		}
		System.out.println(result);
		System.out.println("ending............");
		System.out.println("--------------------------------");
		
	}
}