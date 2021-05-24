package myTestUnits.simpleTest;

import java.io.File;

public class StringTest {
	
	String getFileName(String FilePath) {
		
		int pos = FilePath.lastIndexOf("/");
		
		String strFilePath = FilePath.substring(0, pos+1);
		
		String strFileName = FilePath.substring(pos+1);
		System.out.println("FileName : " + strFileName);
		
		return strFilePath;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int pos =0;
		String str1 = null;
		String str2 = null;
		
		StringTest st = new StringTest();
		
		String FileFullPath = "/tmrec/ctl/gatest/123/45/test.wav";
		String strRst = st.getFileName(FileFullPath);
		System.out.println("FileFullPath : " +  FileFullPath);
		System.out.println("FilePath : " +  strRst);
		File ftest = new File(strRst);
		System.out.println("FilePath : " +  ftest.isDirectory());
		
		String str = "aaaaa|bbbbb|ccccc|";
		str="HDCA2|20201026141626031Y21682|008f0301f075b302|send|";
		
		//if(str == null || str.length() < 1) 
		
		/*
		System.out.println(str);
		System.out.println(str.length());
		
		pos = str.lastIndexOf("|", str.length()-2);
		
		str1 = str.substring(0, pos+1);
		str2 = str.substring(pos+1, str.length()-1);
		
		System.out.println(pos);
		System.out.println(str1);
		System.out.println(str2);
		*/
		
		String strPath = "/nasdata/service/ptm/aaaaaaaaa.wav";
		
		String newPath = strPath.replace("/nasdata/service/ptm", "/nasdata/solution/ptmrec");
				
		System.out.println(newPath);
	}

}
