<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.util.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.apache.log4j.*" %>

<%!
	final Logger logger = Logger.getLogger("irlink");

	public void renameFile(String svdDirPath, String svdFileName, String newFileSubPath){
		
		File oldFilePtr = new File(svdDirPath + svdFileName);
        	logger.debug("oldFilePath: -> " + svdDirPath + svdFileName);
		
		String newFilePath = svdDirPath + newFileSubPath; 
        	logger.debug("newFilePath : -> " + newFilePath);
		
		int pos = newFilePath.lastIndexOf("/");
		String newDirPath = newFilePath.substring(0,pos+1);
        	logger.debug("newDirPath : -> " + newDirPath);
	
		File newDirPathPtr = new File(newDirPath);
		if(!newDirPathPtr.isDirectory()){
			logger.info("mkdirs : -> " + newDirPathPtr.mkdirs());
		}	
		File newFilePtr = new File(newFilePath);
		if(newFilePtr.exists()){
			logger.info("is exit " + newFilePath);
			newFilePtr.delete();
		}
		
		if(oldFilePtr.renameTo(newFilePtr)){
			logger.info("Mk Successs : " + newFilePath);
		}else{
			logger.info("Mk Fail " + newFilePath);
		}
	}
%>

<%
	String tmDirPrefix = "/tmrec/ctl/gatest/";

	String svdDirPath = "";
	String svdFileName = "";
	
	int maxSize = 1024 * 1024 * 100;
	String originalFileName = "";

	logger.debug("====================================================");

	svdDirPath = tmDirPrefix;
        logger.debug("svdDirPath: -> " + svdDirPath);

	try{
		MultipartRequest multi = new MultipartRequest(request, svdDirPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

		Enumeration files = multi.getFileNames();

		while(files.hasMoreElements()){
			String newFileSubPath = (String)files.nextElement();

			svdFileName = multi.getFilesystemName(newFileSubPath);
			originalFileName = multi.getOriginalFileName(newFileSubPath);
			File svdFilePtr = multi.getFile(newFileSubPath);
			logger.debug("newFileSubPath : -> " + newFileSubPath);
			logger.debug("svdFileName : -> " + svdFileName);
			logger.debug("originalFileName: -> " + originalFileName);
			if(svdFilePtr != null) logger.debug("svdFileSize: -> " + svdFilePtr.length());
			out.print("newFileSubPath : -> " + newFileSubPath);
			out.print("<br>");
			out.print("svdFileName : -> " + svdFileName);
			out.print("<br>");
			out.print("originalFileName: -> " + originalFileName);
			out.print("<br>");
			if(svdFilePtr != null) out.print("svdFileSize: -> " + svdFilePtr.length());
			out.print("<br>");
			out.print("<br>");

			renameFile(svdDirPath , svdFileName, newFileSubPath);
		}

	}catch (Exception e){
		e.printStackTrace();
	}
%>

<html>
	<head>
		<title><Title></title>
	</head>
	<body>
		file upload success
	</body>
</html>
