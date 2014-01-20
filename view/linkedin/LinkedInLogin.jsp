<html>
	<head>
		<title>LinkedIn Login Page</title>
		<!-- Bootstrap -->
		<link href="/BWeb/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/additional.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/social/login-page.css" rel="stylesheet" media="screen">
		<script src="/BWeb/js/linkedin/linkedin.js"></script>
		<script src="/BWeb/js/jquery-1.9.1.js"></script>
	</head>
	
	<body>
		<jsp:include page="../template-header.jsp" />
		<div class="container account-wall login-panel">
			<h2 class="form-signin-heading">Sign in</h2>
			<h4 class="text-muted">Connect with your LinkedIn account</h4>
			<br/>
			<br/>
			<img alt="LinkedIn icon" src="/BWeb/img/LinkedIn.png" style="width: 73px;height: 73px;">
			<br/>
			<br/>
			<button onclick="redirectForLinkedInAuthenticate()" class="btn linkedin-color btn-primary social-button-size">Login with linkedin</button>
		</div>
	</body>
</html>