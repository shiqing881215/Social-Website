<!-- This is the page for user interact with twitter -->
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Google+ Profile</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/facebook/facebook-search.css" rel="stylesheet" media="screen">
		<link href="css/facebook/facebook-profile.css" rel="stylesheet" media="screen">
	
		<script src="js/fb/facebook.js"></script>
	</head>
	<body style="background-color: #3b5998;">
		<jsp:include page="../social/template-navigation.jsp" />
		
		<!-- Search Bar -->
		<div class="container" style="text-align: center;">
			<div class="row">
		        <div class="span12">
		            <form id="twitter-user-search" class="form-search form-horizontal pull-right" action="fb_FacebookSearch.do" method="get">
		                <div class="input-append span12">
		                    <input type="text" class="search-query search-bar" placeholder="Search" name="facebookUser">
		                    <button type="submit" class="btn"><i class="icon-search"></i></button>
		                </div>
		            </form>
		        </div>
			</div>
		</div>
		
		<div class="facebook-profile-container">
			<!-- Login User Profile -->
			<h5> You are login as 
			</h5> 
			<!-- End of Profile -->
			
			<!-- Friends List -->
			<h4> Your Friends </h4>
			<!-- End of Friends List -->
			
			<!-- Feeds List -->
			<h4> Your Feeds </h4>
			<!-- End of Feeds List -->
		</div>
	</body>
</html>