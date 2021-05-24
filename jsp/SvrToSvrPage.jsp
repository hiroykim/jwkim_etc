<html>
	<head>
		<center><h1>GA Server To Meritz Server Upload Test Page</h1></center>
	</head>
	
	<body>
		<form action="SvrToSvrUp.jsp" method="post">	
		<br>
		<center>
			GA FileName in Server : <input type="text" name="FileName1" value="/tmrec/ctl/gatest/moved/source/ga_multi_1.wav" size="50">
			<br>
			GA FileName in Server : <input type="text" name="FileName2" value="/tmrec/ctl/gatest/moved/source/ga_multi_2.wav" size="50">
			<br>
			GA FileName in Server : <input type="text" name="FileName3" value="/tmrec/ctl/gatest/moved/source/ga_multi_3.wav" size="50">
			<br>
			GA FileName in Server : <input type="text" name="FileName4" value="/tmrec/ctl/gatest/moved/source/ga_multi_4.wav" size="50">
			<br>
			GA FileName in Server : <input type="text" name="FileName5" value="/tmrec/ctl/gatest/moved/source/ga_multi_5.wav" size="50">
			<br>
			<br>
			Process : SvrToSvrPage.jsp(Client Web) -> SvrToSvrUp(GA Server) -> SvrGaUpMulti.jsp(Meritz Server)
			<br>
			<br>
			Target in Server : /tmrec/ctl/gatest/~
			<br>
			<br>
			<input type="submit" value="ServerToServer">
			<br>
			<br>
		</center>
		</form>
	</body>
</html>
