package mypro01.src.myproject_program;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testDateFormat {
	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = new Date(2232147181123L);
		String str = df.format(d);  //��ʱ������ո�ʽ���ַ�����ת�����ַ���
		System.out.println(str);
		
		System.out.println("***********");
		
		String str2 = "2016-10-26 ";
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); //�˴���ʽҪ�������ַ�����Ӧ
		Date d2;
		try {
			d2 = df2.parse(str2);  //���������ַ���ת����ʱ�����
			System.out.println(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
