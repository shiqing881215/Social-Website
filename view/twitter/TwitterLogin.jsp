<!-- This is the page for user login with twitter -->
<html>
<head>
	<title>Twitter Login Page</title>
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/additional.css" rel="stylesheet" media="screen">
	<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
	<link href="css/social/login-page.css" rel="stylesheet" media="screen">
		
	<script src="js/tw/twitter.js"></script>
</head>

	<body>
		<jsp:include page="../template-header.jsp" />
		<div class="container account-wall login-panel">
			<h2 class="form-signin-heading">Sign in</h2>
			<h4 class="text-muted">Connect with your Twitter account</h4>
			<br/>
			<br/>
			<img alt="twitter icon" src="/BWeb/img/Twitter.png" style="width: 73px;height: 73px;">
			<!-- https://pbs.twimg.com/profile_images/2284174758/v65oai7fxn47qv9nectx_bigger.png -->
			<div style="visibility: hidden;" id="requestToken">
				<%= request.getAttribute("requestToken") %>
			</div>
			<button onclick="redirectForAuthenticate()" class="btn social-button-size btn-info">Login with twitter</button>
		</div>
	</body>
</html>