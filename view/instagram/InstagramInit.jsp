<!-- This page is aimed at getting the access token from the callback url as value of # -->
<!-- This kind of work can only be done on the client side, after that will do the ajax call to server side -->
<html>
	<head>
		<title>Instagram Init Page</title>
		<script src="/BWeb/js/jquery-1.9.1.js"></script>
	</head>
	
	<body>
		<script type="text/javascript">
			// Get the value after # tag, which is access_token
			debugger;
			var access_token = location.hash;
			$.ajax({
				type : "GET",
				url : "http://localhost:8080/BWeb/ins_InstagramInit.do",
				data : {access_token : access_token},
				dataType : "text",
				success : function(result) {
					window.location = ("http://localhost:8080/BWeb/ins_InstagramHome.do");
				}
			});	
		</script>
	</body>
</html>