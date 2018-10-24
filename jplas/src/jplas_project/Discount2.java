package jplas_project;

/**
 * 第161题
 * @author Wangzinan
 *
 */

public class Discount2 {
	public static int halve(int n){
		return n/2;
	}
	
	
	public static void main(String[] args) {
		int p = 10000;
		int q = halve(p);
		System.out.println("原来的值是："+p+"的话，"+"现在半价的值是："+q);
	}
}
