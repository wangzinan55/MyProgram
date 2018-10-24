package mypro01.src.myproject_program;

/**
 * �����Զ�װ��Ͳ���
 * @author Wangzinan
 *
 */

public class test02 {
	public static void main(String[] args) {
		//Integer a = new Integer(1000);
		Integer a = 1000; // �����������ǸĽ����룬�൱��Integer a = new Integer(1000)
		
		Integer b = 2000;		
		int c = b;  //�������Ľ���new Integer(2000).intValue(),�� b.intValue()
		System.out.println(c);
	
		System.out.println("************************");
		
		Integer d = 1234;
		Integer d2 =1234;
		System.out.println(d==d2);
		System.out.println(d.equals(d2));
		
		System.out.println("************************");
		
		Integer d3 = 101;
		Integer d4 = 101;
		System.out.println(d3==d4);  //[-128,127]֮���������Ȼ���������������ʹ���
		System.out.println(d3.equals(d4));
	}
}
