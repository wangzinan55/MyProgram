package mypro01.src.myproject_program;



import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ����������
 * @author Wangzinan
 *
 */


public class testCalendar {
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar(); //Calendar�ǳ����࣬����Ҫ�������࣬���������Ĭ�Ϲ�����������һ��������
		c.set(2016, 9, 27, 13, 03, 12);
		Date d = c.getTime();
		System.out.println(d);
		System.out.println(c.get(Calendar.YEAR));
		
		System.out.println("***********************");
		
	//�������ڼ���
		c.add(Calendar.YEAR, 30);
		System.out.println(c);
	}
}
