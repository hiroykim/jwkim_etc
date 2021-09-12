
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256V1 {

    public static String alg = "AES/CBC/PKCS5Padding";
    private final String key = "01234567890123456789012345678901";

    private final String iv = key.substring(0, 16); // 16byte
    private final String iv2 = "한글"; // 16byte

    public String encrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }
    
    public void static_iv(AES256V1 aes256, String text) throws Exception  {
    	String cipherText = aes256.encrypt(text);
    	System.out.println("==========Start==========");
        System.out.println("입력 :" + text);
        System.out.println("암호화 :" + cipherText);
        System.out.println("복호화 :" + aes256.decrypt(cipherText));
    }
    
    public static void main(String[] args) throws Exception {

        AES256V1 aes256 = new AES256V1();
        String text = "!! Hello World !!";
        
        aes256.static_iv(aes256, text);
        aes256.static_iv(aes256, text);
        

    }

}
