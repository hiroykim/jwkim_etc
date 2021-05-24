package myTestUnits.simpleTest;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeTest {
	
	String getHhmmss(){
		Date date_now = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmssS");
		return sdf.format(date_now);
	}
	
	String getYYYYMMDD(){
		Date date_now = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date_now);
	}
	
	String getId(int offset){
		String id=null;
		int maxDigit = 1000000000;
		
		Date date_now = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strDay = sdf.format(date_now);
		
		int seqNum = maxDigit + offset;
		String strNum = Integer.toString(seqNum).substring(1);
		
		id = "P" + strDay + strNum;
		System.out.println(id);
		
		return id;
	}

	public static void main(String[] args) {
		System.out.println("Start!!");
		
		// TODO 자동 생성된 메소드 스텁
		TimeTest tt = new TimeTest();
		String rst = tt.getHhmmss();
		System.out.println(rst);
		System.out.println(rst.length());
		
		System.out.println("11111111111111111111111111111111111111111111");
		
		rst = tt.getYYYYMMDD();
		System.out.println(rst);
		System.out.println(rst.length());
		
		System.out.println("2222222222222222222222222222222222222222222222222222");
		
		int seqNum = 1;
		String id = tt.getId(seqNum);
		System.out.println(id);
		System.out.println(id.length());
		
		System.out.println("3333333333333333333333333333333333333333333333333");
		
		/*
		String ss = "123456789" + rst;
		System.out.println(ss);
		ss = ss.substring(0,20);
		System.out.println(ss);
		System.out.println(ss.length());
		*/
	}

}
