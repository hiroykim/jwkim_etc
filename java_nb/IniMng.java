import java.io.*;
import java.nio.*;
import java.nio.file.*;

// ���ȱ�ɸ� �����Ѵ�. ĸ��ȭ, ����ó�� ���� ������ �������� �ʴ´�.
public class IniMng {
	
	private static final String[] aclUserId = {"admin_a", "admin_c", "admin_e"};
	private static final String iniFile = "F:/kisec/project.ini";
	private static final String tmpFile = "F:/tmp/project.tmp";
	
	//public int findData(...){...};
	//public int deletetData(...){...};
	//public int modifyData(...){...};
	
	/*
	 * project.ini : ���񽺿� ���� ��� ������ �Էµ� �ý��� �߿� ���� ����
	 * userId   : project.ini�� �� �߰��� ��û�� userId
	 * keyValue : project.ini�� �� �ڿ� �߰��� "key : value" Data
	 * 
	 * Return : ����(0�̻� ���), ����(����)
	 */
	public int appendData(String userId, String keyValue) throws Exception
	{		
		// userId�� keyValue���� ���� �⺻���� �Է°� ������ �Ѵ�.
		if(userId == null || keyValue == null || !keyValue.contains(":") ) return -1;
		
		//Problem 1 - ACL üũ
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
			
		// ������ /tmp���丮�� �ӽ������� �����ϰ� �����Ѵ�.
		Files.copy(oFile.toPath(), tFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		//Problem2 - �߿��� �ڿ��� ���� ���� ����
		tFile.setReadable(true, false);
		tFile.setWritable(true, false);
		tFile.setExecutable(false, false);
		
		//keyValue ������ �����δ�.
		PrintWriter pw = new PrintWriter(new FileWriter(tFile, true));
		pw.append(keyValue+"\r\n");
		pw.close();
		
		//���뺯���� �Ϸ�Ǿ����� ini������ �����.
		Files.copy(tFile.toPath(), oFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				
		return 0;
	}

	public static void main(String[] args) throws Exception {
		IniMng imc = new IniMng();
		int retCd = imc.appendData("admin_b", "key100:value100");
		
		System.out.println("Result :" + retCd);
	
	}

}
