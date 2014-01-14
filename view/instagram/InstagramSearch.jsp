<!-- This is the page for user interact with twitter -->
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Instagram Search Page</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/facebook/facebook-search.css" rel="stylesheet" media="screen">
		<link href="css/social/social.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="css/instagram/instagram-search.css" rel="stylesheet" media="screen">
		
		<script src="js/fb/facebook.js"></script>
	</head>

	<body>
		<jsp:include page="../social/template-navigation.jsp" />
		<jsp:include page="../template-header.jsp" />
	
		<!-- Search Bar -->
		<div class="container search-bar-container" style="text-align: center;">
			<div class="row">
		        <div class="span12">
		            <form id="twitter-user-search" class="form-search form-horizontal pull-right" action="ins_InstagramSearch.do" method="get">
		                <div class="input-append span12">
		                    <input type="text" class="search-query search-bar" placeholder="Search" name="instagramUser">
		                    <button type="submit" class="btn"><i class="icon-search"></i></button>
		                </div>
		            </form>
		        </div>
			</div>
			<span style="color: white;">Go to </span> <a href="ins_InstagramHome.do">home</a>
		</div>
		
		<!-- Search Results -->
		<div class="ins-search-results-container">
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="insUser" items="${insUserSearchList}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
 							<div class="left">
	 							<a class="account-group js-user-profile-link" href="http://instagram.com/${insUser.userName}">
						            <img class="avatar js-action-profile-avatar ins-search-profile-photo" src="${insUser.profilePictureURI}" alt="profileImage" data-user-id="${insUser.userName}">
						        </a>
 							</div>
					        <div class="right">
						        <a class="account-group js-user-profile-link" href="http://instagram.com/${insUser.userName}">
						        	<strong class="fullname js-action-profile-name">${insUser.fullName}</strong>
						        </a>
					        </div>
						</div>
					</li>
				</c:forEach> 
				</ul>
			</div>
		</div>
	</body>
</html>