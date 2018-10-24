package study163;
/*
	当要表示的数据超出数据类型的临界范围时，称为溢出
*/

class OverFlowDemo1{
	public static void main(String[] args)
	{
			//int类型最大值
			int intMAX = 2147483647;
			intMAX = intMAX + 1;
			System.out.println("int类型最大值:"+intMAX); //结果紊乱
			
			
			//int类型最小值
			int intMIN = -2147483648;
			intMIN = intMIN - 1;
			System.out.println("int类型最大值:"+intMIN); //结果紊乱
	}
}