package jplas_project;

/**
 * 第154题
 * @author Wangzinan
 *
 */



public class SwitchTest1 {
	public static void main(String[] args) {
		int n =1;
		switch (2 * n + 1) {
		case 0:
			System.out.println("零！");
			break;
		case 1:
			System.out.println("一！");
			break;
		case 2:
			System.out.println("二！");
			break;
		case 3:
			System.out.println("三！");
			break;

		default:
			System.out.println("其余的数");
			break;
		}
	}
}
