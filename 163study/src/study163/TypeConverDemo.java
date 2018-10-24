package study163;

/*
	数据自动转换问题
*/

class TypeConverDemo{
	public static void main(String[] args)
	{
			byte b1 = 5;
			short s1 = b1;//小转大
			int i1 = s1;
			long l1 = i1;
			
			/*
				一般的，byte，short，char不参与转换操作，直接将这三个赋值给int
			*/
			float f1 = i1;//long-->float
			double d1 = f1;
			
			System.out.println(d1);		

         //==============================================

			float f2 = (float)d1;// double-->float,()里是最终要转换成的类型
			
			double pi = 3.14;
			
			int i2 = (int)pi;
			System.out.println(i2);
			
			double d2 = 123 + 1.1F + 99L + 3.14;
			System.out.println(d2);
			
			System.out.println('A'+1);
			
			
	}
}