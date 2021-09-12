import java.io.UnsupportedEncodingException;

public class BytesTest {
	public static String test="한글";
	
	public static void print_str() throws UnsupportedEncodingException {

		System.out.println("length : " + test.length());
	}
	
	
	public static void print_bytes() throws UnsupportedEncodingException {
		int length = test.getBytes().length;

		System.out.println("length : " + length + " Bytes");
	}
	
	public static void print_euckr() throws UnsupportedEncodingException {
		String charset = "euc-kr";

		int length = test.getBytes(charset).length;

		System.out.println("length : " + length + " Bytes");
	}
	
	public static void print_charset(String charset) throws UnsupportedEncodingException {
	
		int length = test.getBytes(charset).length;

		System.out.println("length : " + length + " Bytes");
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		BytesTest.print_str();
		BytesTest.print_bytes();
		BytesTest.print_euckr();
		BytesTest.print_charset("UTF-8");

	}

}
