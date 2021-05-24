package myTestUnits.simpleTest;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	String openTest(){
		String rstCd = "";
		
		String fileLoc = "D:\\samfile\\test.txt";
		fileLoc = "D:\\samfile";
		
		File ftest = new File(fileLoc);
		
		System.out.println("File : " + ftest.toString());
		System.out.println("File exit(): " + ftest.exists());
		
		
		return rstCd;
	}
	
	void mkTest(){
		
		String fileLoc = "D:\\samfile\\testdir\\1\\2\\3\\4";
		
		File ftest = new File(fileLoc);
		System.out.println("mkdirs : " + ftest.mkdirs());
	}
	
	void cpTest(){
		String cmd ="copy";
		String argv1 = "D:\\samfile\\test.txt";
		String argv2 = "D:\\samfile\\testdir\\1\\2\\3\\4\\test_copy.txt";
		
		cmd = "xcopy /Y D:\\samfile\\test.txt D:\\samfile\\testdir\\1\\2\\3\\4\\test_copy.txt";
		
		File of = new File(argv1);
		System.out.println("argv1 : " + of.exists());
		System.out.println("argv1 cw : " + of.canWrite());
		
		File nf = new File(argv2);
		System.out.println("argv2 : " + nf.exists());
		System.out.println("argv2 cw : " + nf.canWrite());
		
		String[] cmdArray = {cmd, argv1, argv2};
		
		try {
			//Process ps = Runtime.getRuntime().exec(cmdArray);
			Process ps = Runtime.getRuntime().exec(cmd);
			ps.waitFor();
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		System.out.println("Start~~");
		FileTest f = new FileTest();
		
		f.openTest();
		//f.mkTest();
		//f.cpTest();
		
		String ns2 = "11.22.33";
		ns2 = ns2.replaceAll("\\.","");
		System.out.println(ns2);
		
		String ns = "0123456789abcdefghijklmn";
		System.out.println(ns.substring(10,18));
		
		

	}

}
