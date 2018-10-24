package study163;

/*
	三元运算符在分页业务逻辑中使用
*/


class PageDemo{
	public static void main(String[] args)
	{
		/*需求：给出一共46条数据,要求一页最多10条数据
			计算:一共多少页;
		*/
		
		int totalCount = 46; //总页数
		int pageSize = 10; //一页最多10条数据
		
		//总页数
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :  totalCount / pageSize + 1;	
		System.out.println(totalPage);
		
		int currentPage = 2; //当前页
		//上一页(上页或者下页都要考虑边界问题)
		int prevPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
		System.out.println(prevPage); //上一页
		
		//下一页
		int nextPsge = currentPage + 1 <= totalCount ? currentPage + 1 : totalCount;
		System.out.println(nextPsge); //下一页
		
	}
}