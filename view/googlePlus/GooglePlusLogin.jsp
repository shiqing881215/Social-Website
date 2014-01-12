<html>
	<head>
		<title>Google+ Login Page</title>
		<!-- Bootstrap -->
		<link href="/BWeb/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/additional.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/social/login-page.css" rel="stylesheet" media="screen">
		<script src="/BWeb/js/googlePlus/googlePlus.js"></script>
		<script src="/BWeb/js/jquery-1.9.1.js"></script>
	
		<script type="text/javascript">
		function signinCallback(authResult) {
			debugger;
		    if (authResult['status']['signed_in']) {
		    	// Update the app to reflect a signed in user
		    	// Hide the sign-in button now that the user is authorized, for example:
		    	document.getElementById('signinButton').setAttribute('style', 'display: none');
		    	console.log("Token:" + authResult.access_token);
		    	// Ajax call to the Init action to init the plus client, then go to the profile action
 				$.ajax({
 					type : "GET",
 					url : "http://localhost:8080/BWeb/gp_GooglePlusInit.do",
 					data : {access_token : authResult.access_token},
 					dataType : "text",
 					success : function(result) {
 						debugger;
 						window.location = ("http://localhost:8080/BWeb/gp_GooglePlusProfile.do");
 					}
 				});	
 			} else {
			    // Update the app to reflect a signed out user
			    // Possible error values:
			    //   "user_signed_out" - User is signed-out
			    //   "access_denied" - User denied access to your app
			    //   "immediate_failed" - Could not automatically log in the user
		    	console.log('Sign-in state: ' + authResult['error']);
		    }
		}
		</script>
		
	</head>
	
	<body>
		<jsp:include page="../template-header.jsp" />
		<div class="container account-wall login-panel">
			<h2 class="form-signin-heading">Sign in</h2>
			<h4 class="text-muted">Connect with your Google+ account</h4>
			<br/>
			<br/>
			<img alt="google+ icon" src="/BWeb/img/GooglePlus.jpg" style="width: 73px;height: 73px;">
			<br/>
			<br/>
			<span id="signinButton">
				<span
				    class="g-signin"
				    data-callback="signinCallback"
				    data-clientid="217653803775-8hkvkhcamc51l39vk08bu4nbck8pqj7d.apps.googleusercontent.com"
				    data-cookiepolicy="single_host_origin"
				    data-requestvisibleactions="http://schemas.google.com/AddActivity"
				    data-scope="https://www.googleapis.com/auth/plus.login">
				</span>
			</span>		
		</div>
		
		<!-- Place this asynchronous JavaScript just before your </body> tag -->
	    <script type="text/javascript">
	      (function() {
	       var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
	       po.src = 'https://apis.google.com/js/client:plusone.js';
	       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
	     })();
	    </script>
	    
	    
	    
	</body>
</html>