<html>
	<head>
		<title>Instagram Login Page</title>
		<!-- Bootstrap -->
		<link href="/BWeb/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/additional.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/social/login-page.css" rel="stylesheet" media="screen">
		<script src="/BWeb/js/instagram/instagram.js"></script>
		<script src="/BWeb/js/jquery-1.9.1.js"></script>
	</head>
	
	<body>
		<jsp:include page="../template-header.jsp" />
		<div class="container account-wall login-panel">
			<h2 class="form-signin-heading">Sign in</h2>
			<h4 class="text-muted">Connect with your Instagram account</h4>
			<br/>
			<br/>
			<img alt="instagram icon" src="/BWeb/img/Instagram.png" style="width: 73px;height: 73px;">
			<br/>
			<br/>
			<button onclick="redirectForInstagramAuthenticate()" class="btn instagram-color btn-primary social-button-size">Login with instagram</button>
		</div>
	</body>
</html>