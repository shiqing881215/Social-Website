<!-- This is the page for user login with facebook -->
<html>
	<head>
		<title>Facebook Login Page</title>
		<!-- Bootstrap -->
		<link href="/BWeb/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/additional.css" rel="stylesheet" media="screen">
		
		<script src="/BWeb/js/fb/facebook.js"></script>
	</head>

	<body>
		<div class="container account-wall" style="text-align: center;">
			<h2 class="form-signin-heading">Sign in</h2>
			<h4 class="text-muted">Connect with your facebook account</h4>
			<br/>
			<br/>
			<img alt="facebook icon" src="/BWeb/img/Facebook.png" style="width: 73px;height: 73px;">
			<br/>
			<br/>
			<button onclick="redirectForAuthenticate()" class="btn facebook-color btn-primary social-button-size">Login with facebook</button>
		</div>
	</body>
</html>