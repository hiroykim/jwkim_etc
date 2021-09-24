import java.io.*;
import java.nio.*;
import java.nio.file.*;

// 보안기능만 점검한다. 캡슐화, 에러처리 등의 약점은 점검하지 않는다.
public class IniMng {
	
	private static final String[] aclUserId = {"admin_a", "admin_c", "admin_e"};
	private static final String iniFile = "F:/kisec/project.ini";
	private static final String tmpFile = "F:/tmp/project.tmp";
	
	//public int findData(...){...};
	//public int deletetData(...){...};
	//public int modifyData(...){...};
	
	/*
	 * project.ini : 서비스에 대한 모든 조건이 입력된 시스템 중요 설정 파일
	 * userId   : project.ini에 값 추가를 요청한 userId
	 * keyValue : project.ini의 맨 뒤에 추가할 "key : value" Data
	 * 
	 * Return : 성공(0이상 양수), 실패(음수)
	 */
	public int appendData(String userId, String keyValue) throws Exception
	{		
		// userId와 keyValue값에 대한 기본적인 입력값 점검을 한다.
		if(userId == null || keyValue == null || !keyValue.contains(":") ) return -1;
		
		//Problem 1 - ACL 체크
		int i=0;
		boolean vFlag=false;
		for(i=0; i < aclUserId.length ; i++){
			if(userId.equals(aclUserId[i])) {
				vFlag=true;
			}
		}
		if(!vFlag) return -1;
		
		
		File oFile = new File(iniFile);
		File tFile = new File(tmpFile);
			
		// 변경은 /tmp디렉토리의 임시파일을 생성하고 적용한다.
		Files.copy(oFile.toPath(), tFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		//Problem2 - 중요한 자웡에 대한 권한 설정
		tFile.setReadable(true, false);
		tFile.setWritable(true, false);
		tFile.setExecutable(false, false);
		
		//keyValue 내용을 덧붙인다.
		PrintWriter pw = new PrintWriter(new FileWriter(tFile, true));
		pw.append(keyValue+"\r\n");
		pw.close();
		
		//내용변경이 완료되었으면 ini파일을 덮어쓴다.
		Files.copy(tFile.toPath(), oFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				
		return 0;
	}

	public static void main(String[] args) throws Exception {
		IniMng imc = new IniMng();
		int retCd = imc.appendData("admin_b", "key100:value100");
		
		System.out.println("Result :" + retCd);
	
	}

}
