package jplas_project;
/**
 * ��162��
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
		obj.myoji = "���";
		obj.namae = "��";
		return obj;
	}
	
	public static void main(String[] args) {
		MyojiNamae mn = getYourName();
		System.out.println("������:"+mn.myoji);
		System.out.println("������:"+mn.namae);
	}
}
