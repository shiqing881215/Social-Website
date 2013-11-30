<html>
<head>
	<title>Welcome page</title>
	<script type="text/javascript" src="ajax.js"></script>
	<script type="text/javascript" src="search-suggest.js"></script>
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	
	<link href="css/additional.css" rel="stylesheet" media="screen">
</head>

<body>
	<div class="container">
		<h1 style="color: red;"> Welcome <%= request.getParameter("userName") %></h1>
		<h4>Search username here.</h4>
	    <div class="row">
			<div class="col-sm-4 col-md-4">
	            <div class="panel panel-default">
	                <div class="panel-body">                
	                    <input type="text" id="username" name="username" onkeyup="searchSuggest(this);" autocomplete="off"/>
						<div id="search_suggest"></div>
	                </div>
	            </div>
	        </div>
		</div>
		
		Click <a href="logout.do">here</a> to logout.
	</div>
	
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-6">
	            <div class="panel panel-primary">
	                <div class="panel-body">
	                    <div class="row">
	                        <div class="col-xs-6 col-sm-6 col-md-6 separator social-login-box"> <br />
	                            <a href="http://www.jquery2dotnet.com" class="btn facebook btn-primary" role="button">Facebook</a>
	                            <br />
	                            <br />
	                            <form action="tw_OauthRequestToken.do" method="POST">
	                            	<input class="btn twitter btn-info" type="submit" name="action" value="Twitter" />
	                            </form>
	                            
	                            <a href="Twitter.jsp" class="btn twitter btn-info" role="button">Twitter</a>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
    </div>
	
	

</body>
</html>