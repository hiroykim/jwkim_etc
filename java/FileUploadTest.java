package myTestUnits.simpleTest;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUploadTest {
	
	public final static String CrLf = "\r\n";
	//public final static String boundary = "--myboundary";
	public final static String boundary = "69df3f3694f19a550ff2066603e1782f1dd6c19937e8917ffafce81348bfabd5";

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		
		String url = "http://10.92.99.53:37204/tmsys/SvrJava.jsp?testParam=getMyValue1";
		String filePath = "D:/ITSR/202011-GA환경세팅/uploadTest/zip20180430165440317003469.wav";
		File f = new File(filePath);
		if(!f.exists()) {
			System.out.println("File Flase : " + filePath);
		}else {
			System.out.println("File True: " + f.getCanonicalPath());
		}
		//System.exit(0);
		
		try {
			String header = "";
			HttpURLConnection con = (HttpURLConnection)(new URL(url).openConnection());
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setUseCaches(false);
			con.setChunkedStreamingMode(1024);
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);
			
			
			DataOutputStream os = new DataOutputStream(con.getOutputStream());
			
			header = CrLf + "--" + boundary 
					+ CrLf + "Content-Disposition: form-data; name=\"strRemoteFileName\""
					 + CrLf
					 + CrLf	+ "moved/3/3/ga_test_3.wav";
			
			System.out.print(header);
			os.write(header.getBytes());
			
			header = CrLf + "--" + boundary
					+ CrLf +"Content-Disposition: form-data; name=\"uploadfilename\";filename=\"" + f.getName() +"\""
					+ CrLf +"Content-Type: application/octet-stream"
				    + CrLf;
					
			System.out.print(header);
			System.out.print(CrLf+"filedata"+CrLf);
			os.write(header.getBytes());
			
			FileInputStream uploader = new FileInputStream(f);
			int read_size = 1024;
			int remain_size;
			
			while((remain_size = uploader.available()) > 0) {
				byte[] read_data;
				read_data = remain_size >= read_size ? new byte[read_size] : new byte[remain_size];
				uploader.read(read_data);
				os.write( CrLf.getBytes()) ;
				os.write(read_data);
				os.flush();
			}
			//os.write(("--" + boundary + "--" + CrLf).getBytes()) ;
			/*
			os.write( CrLf.getBytes()) ;
			os.write( CrLf.getBytes()) ;
			os.write("postParam=postValue1".getBytes()) ;
			os.write( CrLf.getBytes()) ;
			*/
			os.write( CrLf.getBytes()) ;
			os.write(("--" + boundary + "--" + CrLf).getBytes()) ;
			os.flush();
			os.close();
			uploader.close();
			
			InputStream is = con.getInputStream();
			StringBuilder response = new StringBuilder();
			byte[] respBuffer = new byte[4096];
			while(is.read(respBuffer) >= 0)
			{
				response.append(new String(respBuffer).trim());
			}
			is.close();
			
			System.out.println("-------------------Response------------------------");
			System.out.println(response.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
