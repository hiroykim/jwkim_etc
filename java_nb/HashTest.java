import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTest {
	
	public static String byteToHexString2(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for(byte a : temp) {
			sb.append(String.format("%02x", a));
		}
		return sb.toString();
	}
	
	public static String byteToHexString(byte[] data) {
	    StringBuilder sb = new StringBuilder();
	    for(byte b : data) {
	        sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
	    }

	    return sb.toString();
	}
	
	public static String md5(String msg) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(msg.getBytes());
	    
	    return byteToHexString2(md.digest());

	}

	
	public static String sha256(String msg)  throws NoSuchAlgorithmException {

	    MessageDigest md = MessageDigest.getInstance("SHA-256");

	    md.update(msg.getBytes());

	    return byteToHexString2(md.digest());

	}


	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String rst="";
		
		rst = HashTest.md5("md5 test");
		System.out.println("md5 : " + rst);
		
		rst = HashTest.sha256("sha256 test");
		System.out.println("sha256 : " + rst);

	}

}
