<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.log4j.*" %>
<%!
	final Logger logger = Logger.getLogger("irlink");
	
	public void writeFile(FileItem f_item, String svdDirPath, String newFileSubPath){
		
		String newFileName = "";

		try{
			
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
			f_item.write(newFilePtr);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<%
	String tmDirPrefix = "/tmrec/ctl/gatest/";

	String svdDirPath = "";
	String svdFileName = "";
	String svdFilePath = "";
	
	int maxSize = 1024 * 1024 * 100;
	String originalFileName = "";

	logger.debug("====================================================");

	svdDirPath = tmDirPrefix;
        logger.debug("svdDirPath: -> " + svdDirPath);


	try{
		HashMap<String, String> map = new HashMap<String, String>();
		ServletFileUpload multi = new ServletFileUpload(new DiskFileItemFactory());
		multi.setHeaderEncoding("UTF-8");
		multi.setSizeMax(maxSize);

		List<FileItem> items = multi.parseRequest(request);
		for(FileItem _item : items){
			if(_item.isFormField()){
				String key = _item.getFieldName();
				String val = _item.getString();
				map.put(key, val);
				out.println("<br>HashMap -> " + map);
			}else{
				out.println("<br>_item.getFieldName() -> " + _item.getFieldName());
				out.println("<br>_item.getNme() -> " + _item.getName());
				out.println("<br>_item.getSize() -> " + _item.getSize());
				out.println("<br>_item.getContentType() -> " + _item.getContentType());
				originalFileName = _item.getName().substring(_item.getName().lastIndexOf('/')+1);
				out.println("<br>originalFileName -> " + originalFileName);
				out.println("<br>");
			
				if(_item.getSize() > 0 ){	
					writeFile(_item, svdDirPath, _item.getFieldName()); 
				}
			}
		}
	}catch (Exception e){
		e.printStackTrace();
	}
%>

<html>
	<head>
		<title>Apache Common Upload Test</title>
	</head>
	<body>
		<br>
		file upload success
	</body>
</html>
