<html>
	<head>
		<title>DownLoad Title</title>
		<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
		<center><h1>Download Test Page</h1></center>

	<script language="javascript">
		function z_test()
 		{
			alert("http://10.92.99.53:37204/tmsys/ga_test_1.wav");
			ZiPhonePlayer.StartURLPlay("http://10.92.99.53:37204/tmsys/ga_test_1.wav",0);
		}
		
		function jsp_test()
 		{
			alert("GaDwnRecSvr.jsp?recLoc=moved/1/1/ga_test_1.wav");
			ZiPhonePlayer.StartURLPlay("http://10.92.99.53:37204/tmsys/GaDwnRecSvr.jsp?recLoc=moved/1/1/ga_test_1.wav",0);
		}
	</script>
	</head>
	<body>
		<br>
		<center>
			File: gatest/moved/1/1/ga_test_1.wav
			<br>
			<br>
			Direct DownLoad :<a href="/tmsys/ga_test_1.wav"> Direct Download ! </a>
			<br>
			Url : http://10.92.99.53:37204/tmsys/ga_test_1.wav
			<br>
			<br>
			JSP Call :<a href="javascript:jsp_test();"> Start JSP DownLoad!</a>
			<br>
			<br>
			File Download : <a href="javascript:z_test();">Start Ziphone Direct Download!</a>
			<br>
			<br>
			<br>
			<br>

<OBJECT id="ZiPhonePlayer" classid="CLSID:65409E0F-7801-4455-BEDB-9A3A2655177D" style="LEFT: 0px; TOP: 0px; Width:500px; Height:100px; " codebase="./ZiPhonePlayer.cab#version=2,1,2,23"></OBJECT>
		</center>
	</body>
</html>
