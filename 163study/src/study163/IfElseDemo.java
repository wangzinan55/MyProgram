package study163;

/*
	选择结构 
	演示:if语句的第一种格式
*/

/*
	if-else语句和三元运算:
		从语义上二者含义相同;
		从本质上说,if-else使语句结构,三元运算符是一种运算符号.
			三元运算符必须有一个结果,表达式必须有结果,必须有返回.
			而if-else,不能返回什么结果,只能控制语句的结构 
*/


public class IfElseDemo
{
	public static void main(String[] args)
	{
	/*	int x = 100;
		int y = 20;
		
		if(x > y){
			System.out.println("x 大于 y");
		}else{
			System.out.println("x 小于 y");
		}
	*/	
		//分页案例
		int totalCount = 46;
		int pageSize = 10;
		int totalPage = totalCount / pageSize;
				
		if(totalCount % pageSize == 0){
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount / pageSize + 1;
		}
		System.out.println(totalPage);
	}
}