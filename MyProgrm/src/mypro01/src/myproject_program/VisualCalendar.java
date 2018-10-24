package mypro01.src.myproject_program;


/**
 * ���ӻ�����
 * @author Wangzinan
 *
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class VisualCalendar {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("���������ڣ����ո�ʽ:2011-1-1��:");
			String temp = scanner.nextLine();
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try {
				date = format.parse(temp); 
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				int day = calendar.get(Calendar.DATE); //��õ�������
				
				calendar.set(calendar.DATE,1); //��������Ϊ�����1��
				int maxDate = calendar.getActualMaximum(calendar.DATE); //��maxDateΪ����µ����ֵ
				
				System.out.println("��\tһ\t��\t��\t��\t��\t��"); 
				for(int i=1;i<calendar.get(calendar.DAY_OF_WEEK);i++){   //��calendar.get(calendar.DAY_OF_WEEK)�ǿ�1�����ܼ�
					System.out.print("\t");
				}
					
				for (int i=1; i <= maxDate; i++) {
					if(i==day){   //�����жϣ�����ǵ������ھͼӸ�*
						System.out.print("*");
					}
					System.out.print(i+"\t");
					
					int w = calendar.get(calendar.DAY_OF_WEEK);
					if (w==calendar.SATURDAY) {      //�����жϣ�ÿ�������ͻ���
						System.out.println("\n");
					}
					calendar.add(Calendar.DATE, 1); //�����Լ�
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
}





