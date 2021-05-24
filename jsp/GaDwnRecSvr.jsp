<%@ page contentType = "text/html;charset=UTF-8" %>

<%@ page import="java.io.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.net.*" %>

<%
	request.setCharacterEncoding("UTF-8");

	String recLoc = request.getParameter("recLoc");
	String tmDirPrefix = "/tmrec/ctl/gatest/";
	String svdFilePath = tmDirPrefix + recLoc;
	String FileName = recLoc.substring(recLoc.lastIndexOf("/")+1);

	File file = null;
	InputStream in = null;
	OutputStream os = null;

	boolean skip = false;
	String client = "";
	
	String contentType = "audio/x-wav";

	int fileSize=0;

	try{
		try{
			file = new File(svdFilePath);
			in = new FileInputStream(file);
		}catch(FileNotFoundException fe){
			skip = true;
		}

		//client = request.getHeader("User-Agent");

		fileSize = (int)file.length();


		response.reset();
		response.setContentType("audio/x-wav");
		response.setHeader("Content-Description", "JSP Generated Data");

		if(!skip) {
			response.setHeader("Content-Disposition", "attachment; filename="+FileName);
			response.setHeader("Content-Length", ""+fileSize);

			os = response.getOutputStream();
			byte b[] = new byte[fileSize];
			int leng = 0;

			while( (leng = in.read(b)) > 0 ){
				os.write(b,0,leng);
			}
		}else{
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script language='javascript'>alert('Can not find the file');</script>");
		}
		in.close();
		os.close();
	}catch(Exception e){
		e.printStackTrace();
	}

%>

<html>
	<head>
		<center><h1>Download Test Server Page</h1></center>
	</head>
	<body>
		<br>
		<center>
		<h1>
			file download success -> <%=recLoc%>
			<br>
			full path : <%=svdFilePath%>
			<br>
			file size : <%=fileSize%>
			<br>
			client : <%=client%>
		</h1>
		</center>
	</body>
</html>
