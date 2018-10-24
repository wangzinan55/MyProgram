package study163;

/*
	switch语句适用于对多整型值进行匹配判断,从而实现条件的分支控制
	switch支持的类型是:byte,short,char,int(本质:switch仅仅只能支持int类型,byte,short,char会自动提升为整形)
*/


public class SwitchDemo1
{
	public static void main(String[] args)
	{
			
		//如果今天是周一,输出周一,如果今天是周二,输出周二.... 
		int day = 5;
		
		switch(day = 5){
			
			case 1 : System.out.println("周一");
			break;
			
			case 2 : System.out.println("周二");
			break;
			
			case 3 : System.out.println("周三");
			break;
			
			case 4 : System.out.println("周四");
			break;
			
			case 5 : System.out.println("周五");
			break;
			
			case 6 : System.out.println("周六");
			break;
			
			case 7 : System.out.println("周日");
			break;
			
			default : System.out.println("没有这一天");
			
		}
					
	}
}