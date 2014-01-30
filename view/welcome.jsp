<html>
<head>
	<title>Welcome page</title>
	<script type="text/javascript" src="ajax.js"></script>
	<script type="text/javascript" src="search-suggest.js"></script>
	<script type="text/javascript" src="js/tw/twitter.js"></script>
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/additional.css" rel="stylesheet" media="screen">
	<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
</head>

<body>
	<jsp:include page="template-header.jsp" />
	<div class="welcome-title">
		<h2> Hello ${sessionScope.user.userName} </h2>
		<h2> Welcome to Social Website</h2>
	</div>
	
	<div class="search-container">
		<h4>Search username here</h4>
        <div class="panel panel-default">
            <div class="panel-body">                
                <input type="text" id="username" name="username" onkeyup="searchSuggest(this);" autocomplete="off"/>
				<div id="search_suggest"></div>
            </div>
        </div>
    </div>
	
	<div class="social-btn-container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-6">
	            <div class="panel panel-primary">
	                <div class="panel-body">
	                    <div class="row">
	                        <div class="col-xs-6 col-sm-6 col-md-6 separator social-login-box"> <br />
	                            <a href="fb_CheckLogin.do" class="btn facebook-color btn-primary social-button-size" role="button">Facebook</a>
	                            <br />
	                            <br />
	                            <form action="tw_CheckLogin.do" method="POST">
	                            	<input class="btn btn-info social-button-size" style="width: 225px;" type="submit" name="action" value="Twitter" />
	                            </form>
	                            <a href="linkedin_CheckLogin.do" class="btn instagram-color btn-primary social-button-size" role="button">LinkedIn</a>
	                            <br />
	                            <br />
	                            <!-- <a href="view/facebook/FacebookLogin2.jsp"> facebook </a>  -->
	                            <a href="gp_CheckLogin.do" class="btn google-color btn-primary social-button-size" role="button">Google+</a>
	                            <br />
	                            <br />
	                            <a href="instagram_CheckLogin.do" class="btn instagram-color btn-primary social-button-size" role="button">Instagram</a>
	                            <br />
	                            <br />
	                            <a href="fs_CheckLogin.do" class="btn foursquare-color btn-primary social-button-size" role="button">FourSquare</a>
	                        	<br />
	                            <br />
	                            <a href="view/youtube/YouTube.jsp" class="btn youtube-color btn-primary social-button-size" role="button">YouTube</a>
	                            <br />
	                            <br />
	                            <a href="tb_CheckLogin.do" class="btn tumblr-color btn-primary social-button-size" role="button">Tumblr</a>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <br/>
	    <br/>
	    Click <a href="logout.do">here</a> to logout.
    </div>
</body>
</html>