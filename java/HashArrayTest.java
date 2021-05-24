package myTestUnits.simpleTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashArrayTest {
	
	static HashMap<String, String[]> hst = new HashMap<String,String[]>();

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		getValue('1','2');
		
		/*
		String val[] = hst.get("1|2");
		System.out.println(val[0]);
		System.out.println(val[1]);
		System.out.println(val[2]);
		
		System.out.println(new BigDecimal("-150"));
		System.out.println(new Integer("50"));
		System.out.println(Integer.parseInt("0"));
		
		System.out.println("20191234".substring(0,6));
		*/
		
		List<HashMap<String,String>> dataList = new ArrayList<HashMap<String,String>>();
		for(int i=0 ; i < 2 ; i++){
			HashMap<String,String> hm = new HashMap<String,String>();
			hm.put("1","a"+i);
			hm.put("2","b"+i);
			hm.put("3","c"+i);
			dataList.add(hm);	
		}
		
		HashMap<String,String> hm2 = new HashMap<String,String>();
		for(int i=0; i<dataList.size(); i++){
			hm2 = dataList.get(i);
			System.out.println(hm2.get("1"));
			System.out.println(hm2.get("2"));
			System.out.println(hm2.get("3"));
		}
		
		//HashMap[] hmLst = new HashMap[10];
		//String[] cols = new String[3];
		
	}

	private static void getValue(char k1, char k2) {
		// TODO 자동 생성된 메소드 스텁
		
		String key = k1 + "|" + k2;
		
		String strAry[] = new String[3];
		//String strAry[] = null;
		strAry[0] = "val1";
		strAry[1] = "val2";
		strAry[2] = "val3";
		
		hst.put(key, strAry);
		
	}

}
