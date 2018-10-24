package testoop.src.program_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**  
 * 计算两个日期之间相差的天数  
 * @param smdate 较小的时间 
 * @param bdate  较大的时间 
 * @return 相差天数 
 * @throws ParseException  
 */ 

public class test16 { 
	public static void main(String[] args) throws ParseException {  
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	    Date d1=sdf.parse("2016-12-05");  
	    Date d2=sdf.parse("2017-12-15");  
	  
	       
	    System.out.println("Difference in years is " +daysBetween(d1,d2)/365 + "years" );  
	    System.out.println("Difference in mouths is " +daysBetween(d1,d2)/12 + "mouths" );  
	    System.out.println("Difference in days is " +daysBetween(d1,d2) + "days" );  
	    

	}  

   
	
	
	
/** 
 *字符串的日期格式的计算 
 */
		 
	public static int daysBetween(Date smdate,Date bdate) throws ParseException{    
	   
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	    smdate=sdf.parse(sdf.format(smdate));  
	    bdate=sdf.parse(sdf.format(bdate));  
	    
	    Calendar cal = Calendar.getInstance();    
	    cal.setTime(smdate);    
	    long time1 = cal.getTimeInMillis();    
	    
	    cal.setTime(bdate);    
	    long time2 = cal.getTimeInMillis();  
	    
	    long between_days=(time2-time1)/(1000*3600*24);  
	     
	    return Integer.parseInt(String.valueOf(between_days));           
	}    
	
}