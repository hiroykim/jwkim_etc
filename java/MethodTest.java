package myTestUnits.simpleTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MethodTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		System.out.println(testDate());
	}

	private static String testDate() {
		Date today = new Date();
		
		// TODO 자동 생성된 메소드 스텁
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		
		cal.add(Calendar.YEAR, -1);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		
		return dateFormatter.format(cal.getTime());
		
	}

}
