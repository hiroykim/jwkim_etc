package myTestUnits.simpleTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	
	void printYYMMDD() {
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMdd");
		String df = f1.format(date);
		
		System.out.println("============================================================================");
		System.out.println(date);
		System.out.println(df);
		System.out.println("============================================================================");
	}
	
	void printOndayAgo() {
		long pTime = System.currentTimeMillis();
		long tTime = pTime - 1000*60*60*24;
		Date date = new Date(tTime);
		SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMdd");
		String df = f1.format(date);
		
		System.out.println("============================================================================");
		System.out.println(date);
		System.out.println(df);
		System.out.println("============================================================================");
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Date today = new Date();
		Date dDay = new Date(today.getTime() -(long)(1000*60*60*24*90));
		
		DateTest dt = new DateTest();
		
		dt.printYYMMDD();
		dt.printOndayAgo();
		
		System.out.println(today);
		System.out.println(dDay);
		
		
		/*
		long pTime = System.currentTimeMillis();
		long tTime = pTime - 1000*60*60*24*35;
		
		System.out.println(pTime);
		System.out.println(tTime);
		
		Date tDate = new Date(tTime);
		System.out.println(tDate);
		*/
		
		Calendar c = Calendar.getInstance();
		/*
		c.setTime(new Date());
		//c.add(Calendar.DATE, -90);
		
		System.out.println(c.get(c.YEAR));
		System.out.println(c.get(c.MONTH)+1);
		System.out.println(c.get(c.DAY_OF_MONTH));
		*/
		
		c.set(2020, 12, 25);
		Date date = c.getTime();
		SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMdd");
		String d1 = f1.format(date);
		System.out.println(d1);
		
		c.setTime(new Date());
		Date date2 = c.getTime();
		SimpleDateFormat f2 = new SimpleDateFormat("yyyyMMdd");
		String d2 = f2.format(date2);
		System.out.println(d2);
		//String DDay = "" + c.get(c.YEAR) + c.get(c.MONTH) + c.get(c.DAY_OF_MONTH) ;
		//System.out.println(DDay);
		System.out.println("----------------------");
		System.out.println(c.get(c.YEAR));
		System.out.println(c.get(c.MONTH));
		System.out.println(c.get(c.DAY_OF_MONTH));
	}

}
