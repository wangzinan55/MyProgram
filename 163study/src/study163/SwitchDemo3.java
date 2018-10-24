package study163;

/*
	switch语句适用于对多整型值进行匹配判断,从而实现条件的分支控制
	switch支持的类型是:byte,short,char,int(本质:switch仅仅只能支持int类型,byte,short,char会自动提升为整形)
*/


public class SwitchDemo3
{
	public static void main(String[] args)
	{
			
		//判断工作日还是休息日
		int day = 5;
			
		switch(day = 1){
			
			case 1 : 
			
			case 2 : 
			
			case 3 : 
			
			case 4 : 
			
			case 5 : System.out.println("工作日");
			
			case 6 : 
			break;
			
			case 7 : System.out.println("休息日");
			
			default : System.out.println("没有这一天");
			
		}
					
	}
}