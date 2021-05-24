package myTestUnits.simpleTest;
import java.util.*;

public class ArryHashTest {
	
	static List<HashMap<String,String>> getData1(){
		List<HashMap<String,String>>newData = new ArrayList<HashMap<String,String>>();
		
		for(int i =0 ; i < 10; i++) {
			HashMap<String, String> hm = new HashMap<String,String>();
			hm.put("Key"+i,"Value"+i);
			newData.add(hm);
		}
		
		return newData;
	}
	
	static List<HashMap<String,String>> getData2(List<HashMap<String,String>>dataList){
		
		int i=10;
		for(HashMap<String, String>item : dataList) {
			i++;
			item.put("Key"+i, "Value"+i);
		}
		
		return dataList;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		List<HashMap<String,String>>dataList = new ArrayList<HashMap<String,String>>();
		
		/*
		dataList = getData1();
		for(HashMap<String,String> item : dataList) {
			System.out.println(item.values());
		}
		*/
		
		/*
		dataList = getData2(dataList);
		
		for(HashMap<String,String> item : dataList) {
			System.out.println(item.values());
		}
		*/
		
		HashMap<String, String>hm_1 = new HashMap<String, String>();
		hm_1.put("K1", "V1");
		hm_1.put("K2", "V2");
		hm_1.put("K3", "V3");
		hm_1.put("K4", "V4");
		
		System.out.println("hm_1---------->"  + hm_1);
				
		/*
		for( String Key : hm_1.keySet()) {
			System.out.println(Key + " -> " +hm_1.get(Key));
		}
		*/
		
		/*
		hm_1.remove("K2");
		Iterator<String> keys = hm_1.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println("key -> " + key);
			System.out.println("val -> " +hm_1.get(key));
		}
		*/
			
		/*
		System.out.println(hm_1.get("K1"));
		if(hm_1.get("K2") != null) { 
			System.out.println("NOT NULL");
		}else {
			System.out.println("NULL");
		}
		System.out.println(hm_1.get("K2"));
		System.out.println(hm_1.get("K3"));
		System.out.println(hm_1.get("K4"));
		*/
		
	}


}
