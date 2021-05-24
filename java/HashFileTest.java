package myTestUnits.simpleTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HashFileTest {
	
	 void printHashMap(HashMap<String,String> hm, int max) {
		 int cnt=0;
		 String key = null;
		 Iterator<String> keys = hm.keySet().iterator();
		
		 while(keys.hasNext()) {
			 key = keys.next();
			 
			 if(cnt++ > max ) {break;}
			 System.out.println(key + " -> " + hm.get(key));
		 }
		 
	 }

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		HashMap<String,String>hm_all = new HashMap<String,String>();
		HashMap<String,String>hm_send = new HashMap<String,String>();
		int cnt=0;
		
		HashFileTest hashFile = new HashFileTest();
		
		try {
			hashFile.getHashMap(hm_all, "D:/TestData/QcCov_step_all.text");
			hashFile.getHashMap(hm_send, "D:/TestData/QcCov_step_send.text");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("hm_all.size() : " + hm_all.size());
		System.out.println("hm_send.size() : " +  hm_send.size());
		
		/*
		hashFile.printHashMap(hm_all, 10);
		hashFile.printHashMap(hm_send, 10);
		*/
		
		//중복을 제거한다.
		for( String sendKey : hm_send.keySet()) {
			if(hm_all.get(sendKey) != null){
				hm_all.remove(sendKey);
				if(cnt++ < 10) System.out.println(sendKey);
			}
		}
		
		//hashFile.printHashMap(hm_all, 100);
		
		//중복제거된 파일 생성
		System.out.println("hm_target.size() : " +  hm_all.size());
		try {
			hashFile.writeHashMap(hm_all, "D:/TestData/QcCov_step_target.dat");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	void writeHashMap(HashMap<String,String> hm, String fileName) throws Exception {
		
		BufferedWriter out  = null;
		int cnt=0;
		
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
			
			//print Header
			out.write("AFLCO_CD"); out.write("|");
			out.write("AFLCO_CUS_ID"); out.write("|");
			out.write("RCDG_KEY"); out.write("|");
			out.write("PRV_COT_POL_NO"); out.write("|");
			out.newLine();
			
			Iterator<String> keys = hm.keySet().iterator();
			String keyStr = null;
			
			while( keys.hasNext() ) {
				cnt++;
				keyStr = keys.next();
				
				out.write(keyStr); 
				out.write(hm.get(keyStr));out.write("|");
				out.newLine();
			}
			
		}catch(Exception e) {
		    throw new Exception(e); 
		}finally {
			try{
				out.close();
			} catch ( Exception e){ 
				throw new Exception(e);
			}
		}
		
		System.out.println("Process-write Cnt : " + cnt);

	}

	
	void getHashMap(HashMap<String,String> hm, String fileName) throws Exception {
		
		BufferedReader in  = null;
		int cnt=0;
		int pos=0;
		String key=null;
		String val=null;
		
		try {
			in  = new BufferedReader(new InputStreamReader (new FileInputStream (fileName ),"UTF-8"));
			
			while(in.ready()){
				String outLine = in.readLine();
				if(cnt==0) { //skip header
					cnt++;
					continue;
				}
				if(outLine == null || outLine.trim().length() < 1) {	continue; 	}
				
				pos = outLine.lastIndexOf("|", outLine.length()-2);
				key = outLine.substring(0,pos+1);
				val = outLine.substring(pos+1,outLine.length()-1);
				
				/*
					System.out.println(outLine);
					System.out.println(key+val);
				*/
				hm.put(key, val);
				
				//if(cnt++ > 10) break;
				cnt++;
			}
			
		}catch(Exception e) {
		    throw new Exception(e); 
		}finally {
			try{
				in.close();
			} catch ( Exception e){ 
				throw new Exception(e);
			}
		}
		
		System.out.println("Process Cnt : " + cnt);

	}

}