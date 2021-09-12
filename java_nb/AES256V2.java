//실행환경 : windows10, jdk1.8, eclipse
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256V2 {

    private final String key = "01234567890123456789012345678901";
    private final int blockSize = 16;
    private final String iv = key.substring(0, blockSize); // 16byte
    
    public static String Byte_to_String(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for(byte a : temp) {
			sb.append(String.format("%02x", a));
		}
		return sb.toString();
	}

    public String encrypt_good(String text) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        
        SecureRandom random = new SecureRandom();
        byte iv_bytes[] = new byte[blockSize];
        random.nextBytes(iv_bytes);
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv_bytes);

        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        byte[] ivcipherByte = new byte[blockSize + encrypted.length];
        
        System.arraycopy(iv_bytes, 0, ivcipherByte, 0, blockSize);
        System.arraycopy(encrypted, 0, ivcipherByte, blockSize, encrypted.length);
        return Base64.getEncoder().encodeToString(ivcipherByte);
    }
    
    public String encrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        byte[] ivcipherByte = new byte[blockSize + encrypted.length];
        
        System.arraycopy(iv.getBytes(), 0, ivcipherByte, 0, blockSize);
        System.arraycopy(encrypted, 0, ivcipherByte, blockSize, encrypted.length);
        
        return Base64.getEncoder().encodeToString(ivcipherByte);
    }

    public String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        
        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        
        byte get_bytes[] = new byte[blockSize];
        for(int i =0 ; i < blockSize ; i++) get_bytes[i] = decodedBytes[i];
        
        IvParameterSpec ivParamSpec = new IvParameterSpec(get_bytes);    
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);   
        byte[] cipherByte = new byte[decodedBytes.length - blockSize];
        System.arraycopy(decodedBytes, blockSize, cipherByte, 0, cipherByte.length);
        byte[] decrypted = cipher.doFinal(cipherByte);
        return new String(decrypted, "UTF-8");
    }

      
    public void bad_iv(AES256V2 aes256, String text) throws Exception  {
    	String cipherText = aes256.encrypt(text);
    	System.out.println("==========BAD Start==========");
        System.out.println("입력 :" + text);
        System.out.println("암호화 :" + cipherText);
        System.out.println("복호화 :" + aes256.decrypt(cipherText));
    }
    
    public void good_iv(AES256V2 aes256, String text) throws Exception  {
    	String cipherText = aes256.encrypt_good(text);
    	System.out.println("==========Good Start==========");
        System.out.println("입력 :" + text);
        System.out.println("암호화 :" + cipherText);
        System.out.println("복호화 :" + aes256.decrypt(cipherText));
    }
    
    
    public static void main(String[] args) throws Exception {

        AES256V2 aes256 = new AES256V2();
        String text = "!! 안녕하세요 고객님 !!";
        
        aes256.bad_iv(aes256, text);
        aes256.bad_iv(aes256, text);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        aes256.good_iv(aes256, text);
        aes256.good_iv(aes256, text);

        /*
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        AlgorithmParameters params = cipher.getParameters();
        System.out.println(params.getParameterSpec(IvParameterSpec.class).getIV()); //고정값 반환
		*/
    }

}
