<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.util.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.apache.log4j.*" %>

<%
	final Logger logger = Logger.getLogger("irlink");
	String tmDirPrefix = "/tmrec/ctl/gatest/";

	String svdDirPath = "";
	String svdFileName = "";
	String svdFilePath = "";
	
	String newDirPath = "";
	String newFileName = "";
	String newFilePath = "";

	int maxSize = 1024 * 1024 * 100;
	String originalFileName = "";

	logger.debug("====================================================");

	svdDirPath = tmDirPrefix;
        logger.debug("svdDirPath: -> " + svdDirPath);

	try{
		MultipartRequest multi = new MultipartRequest(request, svdDirPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

		Enumeration files = multi.getFileNames();
		String str = (String)files.nextElement();

		svdFileName = multi.getFilesystemName(str);
		originalFileName = multi.getOriginalFileName(str);
		logger.debug("str : -> " + str);
		logger.debug("svdFileName : -> " + svdFileName);
		logger.debug("originalFileName: -> " + originalFileName);

		File oldFilePtr = new File(svdDirPath + svdFileName);
        	logger.debug("oldFilePath: -> " + svdDirPath + svdFileName);
	
		String subFilePath = multi.getParameter("strRemoteFileName")!=null?multi.getParameter("strRemoteFileName").trim(): ""; 
		newFilePath = tmDirPrefix + subFilePath; 
        	logger.debug("newFilePath : -> " + newFilePath);
		
		int pos = newFilePath.lastIndexOf("/");
		newDirPath = newFilePath.substring(0,pos+1);
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
