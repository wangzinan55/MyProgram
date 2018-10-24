package study163;

/*
	switch语句适用于对多整型值进行匹配判断,从而实现条件的分支控制
	switch支持的类型是:byte,short,char,int(本质:switch仅仅只能支持int类型,byte,short,char会自动提升为整形)
*/


public class SwitchDemo2
{
	public static void main(String[] args)
	{
			
		//如果今天是周一,输出周一,如果今天是周二,输出周二.... 
		char ch = 'C';
		
		switch(ch){
			
			case 'A' : System.out.println("A");
			break;
			
			case 'B' : System.out.println("B");
			break;
			
			case 'C' : System.out.println("C");
			break;
			
		}
					
	}
}