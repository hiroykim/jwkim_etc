package myTestUnits.simpleTest;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMapTest {
	
	public static HashMap<String, String>getHashMap(){
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("FileName1", "FileName5");
		hm.put("FileName2", "FileName4");
		hm.put("FileName3", "FileName3");
		hm.put("FileName4", "FileName2");
		hm.put("FileName5", "FileName1");
		
		return hm;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		HashMap<String,String> hm = new HashMap<String, String>();
		
		hm = getHashMap();
		
		for(String key: hm.keySet()) {
			System.out.println("key : " + key + " value : " + hm.get(key));
		}
        
		TreeMap<String, String>tm = new TreeMap<String, String>(hm);
		for(String key: tm.keySet()) {
			System.out.println("tm key : " + key + " tm value : " + tm.get(key));
		}
		

	}

}
