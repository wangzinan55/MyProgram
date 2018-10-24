package jplas_project;
/**
 * 第162题
 * @author Wangzinan
 *
 */

class MyojiNamae {
	String myoji;
	String namae;
}


public class MethodTest4 {
	public static MyojiNamae getYourName(){
		MyojiNamae obj = new MyojiNamae();
		obj.myoji = "结城";
		obj.namae = "浩";
		return obj;
	}
	
	public static void main(String[] args) {
		MyojiNamae mn = getYourName();
		System.out.println("姓氏是:"+mn.myoji);
		System.out.println("名字是:"+mn.namae);
	}
}
