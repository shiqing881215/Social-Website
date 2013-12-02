<!-- This is the page for user login with twitter -->
<html>
<head>
	<title>Twitter Login Page</title>
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/additional.css" rel="stylesheet" media="screen">
	
	<script src="js/tw/twitter.js"></script>
</head>

	<body>
		<div class="container" style="text-align: center;">
			<h2 class="form-signin-heading">Sign in</h2>
			<h4 class="text-muted">Connect with your twitter account</h4>
			<br/>
			<br/>
			<img alt="twitter icon" src="https://pbs.twimg.com/profile_images/2284174758/v65oai7fxn47qv9nectx_bigger.png">
			<div style="visibility: hidden;" id="requestToken">
				<%= request.getAttribute("requestToken") %>
			</div>
			<button onclick="redirectForAuthenticate()" class="btn twitter btn-info">Login with twitter</button>
		</div>
	</body>
</html>