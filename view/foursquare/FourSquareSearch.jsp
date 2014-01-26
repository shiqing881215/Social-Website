<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>FourSquare Search Page</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/facebook/facebook-search.css" rel="stylesheet" media="screen">
		<link href="css/social/social.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="css/foursquare/foursquare-home.css" rel="stylesheet" media="screen">
		<link href="css/foursquare/foursquare-search.css" rel="stylesheet" media="screen">
		
		<script src="js/foursquare/foursquare.js"></script>
	</head>

	<body>
		<jsp:include page="../social/template-navigation.jsp" />
		<jsp:include page="../template-header.jsp" />
	
		<!-- Search Bar -->
		<div class="container search-bar-container">
			<div class="row">
		        <div class="span12">
		            <form id="twitter-user-search" class="form-search form-horizontal pull-right" action="fs_FourSquareSearch.do" method="get">
		                <div class="input-append span12">
		                    <input type="text" class="search-query search-bar" placeholder="Search" name="fourSquareUser">
		                    <button type="submit" class="btn"><i class="icon-search"></i></button>
		                </div>
		            </form>
		        </div>
			</div>
			<span style="color: white;">Go to </span> <a href="fs_FourSquareHome.do">Home</a>
		</div>
		
		<!-- Search Results -->
		<div class="foursquare-search-results-container">
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="user" items="${users}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
 							<div class="single-friend-left">
	 							<a class="account-group js-user-profile-link" href="https://foursquare.com/user/${user.id}">
						            <img class="avatar js-action-profile-avatar friend-photo" src="${user.photo}" alt="profileImage" data-user-id="${user.id}">
						        </a>
 							</div>
					        <div class="single-friend-right">
						        <a class="account-group js-user-profile-link" href="https://foursquare.com/user/${user.id}">
						        	<strong class="fullname js-action-profile-name">${user.firstName} ${user.lastName}</strong>
						        </a>
						        <br/>
						        ${user.homeCity}
					        </div>
						</div>
					</li>
				</c:forEach> 
				</ul>
			</div>
		</div>
	</body>
</html>