package myTestUnits.simpleTest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class ShaTest {
	
	public static byte[] getSha256(String msg) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		
		return md.digest();
	}
	
	public static byte[] getSha256WithSalt(String msg) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		md.update(salt);
		
		return md.digest(msg.getBytes());
	}
	
	public static byte[] getSha256WithVal(String msg) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		byte[] salt = new byte[16];
		/*
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		
		System.out.println("salt ->" + bytesToHex(salt) );
		*/
		
		//salt="281144dd3f2b152589bc975ae9b02686".getBytes();
		salt="IamSalt".getBytes();
		md.update(salt);
		
		return md.digest(msg.getBytes());
	}
	
	public static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		
		for(byte b: bytes) {
			builder.append(String.format("%02x", b));
		}
		
		return builder.toString();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO 자동 생성된 메소드 스텁
		
		System.out.println("Sha-256 ->" + bytesToHex(getSha256("Meritz")) );
		System.out.println("Sha-256 ->" + bytesToHex(getSha256WithVal("Meritz")) );
		System.out.println("Sha-256 ->" + bytesToHex(getSha256WithSalt("Meritz")) );

	}

}
