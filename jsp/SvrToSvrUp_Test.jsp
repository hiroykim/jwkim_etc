<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.log4j.*" %>

<%!
public final static String CrLf = "\r\n";
public final static String boundary = "69df3f3694f19a550ff2066603e1782f1dd6c19937e8917ffafce81348bfabd5";
String header = null;

%>


<%
	//form-data
	String pData1 = request.getParameter("FileName1");	
	out.print("pData1 : " + pData1);

	//url-connection
	String url = "http://192.168.151.55:35204/tmsys/SvrJava.jsp?testParam=getMyValue1";
	String filePath = pData1;
	File f = new File(filePath);
		if(!f.exists()) {
			out.println("<br>");
			out.println("File Flase : " + filePath);
		}else {
			out.println("<br>");
			out.println("File True: " + f.getCanonicalPath());
	}

	try{
		HttpURLConnection con = (HttpURLConnection)(new URL(url).openConnection());
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setUseCaches(false);
		con.setChunkedStreamingMode(1024);
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);	

		DataOutputStream os = new DataOutputStream(con.getOutputStream());

		//send-msg-form
		header = CrLf + "--" + boundary 
			 + CrLf + "Content-Disposition: form-data; name=\"strRemoteFileName\""
			 + CrLf
			 + CrLf	+ "moved/3/3/ga_test_3.wav";

		out.print(header);
		os.write(header.getBytes());

		//send-msg-file
		header = CrLf + "--" + boundary
			+ CrLf +"Content-Disposition: form-data; name=\"uploadfilename\";filename=\"" + f.getName() +"\""
			+ CrLf +"Content-Type: application/octet-stream"
		        + CrLf;

		out.print(header);
		out.print(CrLf+"filedata"+CrLf);
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

		//send-end_msg
		os.write( CrLf.getBytes()) ;
		os.write(("--" + boundary + "--" + CrLf).getBytes()) ;
		os.flush();
		os.close();
		uploader.close();
	
		InputStream is = con.getInputStream();
		StringBuilder res = new StringBuilder();
		byte[] respBuffer = new byte[4096];
		while(is.read(respBuffer) >= 0)
		{
			res.append(new String(respBuffer).trim());
		}
		is.close();
		out.println("-------------------Response String------------------------");
		out.println(res.toString());

	}catch(Exception e){
		out.println(e.getMessage());
		e.printStackTrace();
	}

%>

<html>
	<head>
		<title>Server To Server Upload Test</title>
	</head>
	<body>
		<br>
		file upload success : /tmrec/ctl/gatest/moved/target/
	</body>
</html>
