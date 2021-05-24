<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.log4j.*" %>

<%!
public final static String CrLf = "\r\n";
public final static String boundary = "69df3f3694f19a550ff2066603e1782f1dd6c19937e8917ffafce81348bfabd5";
String header = null;
HashMap<String,String> hm = new HashMap<String,String>();
DataOutputStream os;

public void  getAllParam(javax.servlet.jsp.JspWriter out, HttpServletRequest request) throws ServletException,IOException{
	String strKey="";

	for(int num=1; num <=5 ; num++){
		strKey = "FileName"+num;
		hm.put(strKey, request.getParameter(strKey));
	}
}

public void sendFile(javax.servlet.jsp.JspWriter out,File f) throws ServletException,IOException{

	String newFileSubPath = "moved/target/"+f.getName();

	header = CrLf + "--" + boundary
		+ CrLf +"Content-Disposition: form-data; name=\"" + newFileSubPath + "\";filename=\"" + f.getName() +"\""
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
	uploader.close();
}
%>


<%
	try{
		//getParameters 
		getAllParam(out, request);
		
		//url-connection
		String url = "http://192.168.151.55:35204/tmsys/SvrGaUpMulti_or.jsp";
		
		HttpURLConnection con = (HttpURLConnection)(new URL(url).openConnection());
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setUseCaches(false);
		con.setChunkedStreamingMode(1024);
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);	

		os = new DataOutputStream(con.getOutputStream());

		TreeMap<String,String>tm = new TreeMap<String,String>(hm);
		for(String tKey : tm.keySet() ){
			out.print("<br>Key :" + tKey);
			out.print("<br>Value:" + hm.get(tKey));
		
			String filePath = hm.get(tKey);
			File f = new File(filePath);
			if(!f.exists()) {
				out.println("<br>");
				out.println("File Flase : " + filePath);
				continue;
			}else {
				out.println("<br>");
				out.println("File True: " + f.getCanonicalPath());
			}
			sendFile(out, f);
		}
		os.write( CrLf.getBytes()) ;
		os.write(("--" + boundary + "--" + CrLf).getBytes()) ;
		os.flush();
		os.close();
		
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
		out.print(e.getMessage());
	}
%>

<html>
	<head>
		<title>Server To Server Upload Test</title>
	</head>
	<body>
		<br>
		file upload success : /tmrec/ctl/gatest/~
	</body>
</html>
