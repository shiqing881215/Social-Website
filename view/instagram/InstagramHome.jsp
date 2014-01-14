<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Instagram Home Page</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/instagram/instagram-home.css" rel="stylesheet" media="screen">
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
		</div>
		
		<!-- Login User -->
		<div class="profile-container">
			<a href="http://instagram.com/${loginUser.userName}">
				<b>${loginUser.fullName}</b>
			</a>
			<br/>
			<img alt="ProfilePhoto" src="${loginUser.profilePictureURI}">
			<br/>
			<b>Posts: ${loginUser.mediaCount}</b>
			<br/>
			<b>Followers: ${loginUser.followerCount}</b>
			<br/>
			<b>Following: ${loginUser.followingCount}</b>
			<br/>
		</div>
		
		<!-- Feeds List -->
		<div class="feeds-container">
			<c:forEach var="feed" items="${feedsList}">
				<a href="http://instagram.com/${feed.user.userName}"><b>${feed.user.userName}</b></a>
				&nbsp; &nbsp; 
				<a href="http://instagram.com/${feed.user.userName}">
					<img alt="feedPhoto" src="${feed.user.profilePictureURI}" class="profile-photo">
				</a>
				<br/> 
				<br/>
				<img src="${feed.standardResolutionImage.uri}" class="feed-photo">
				<br/>
				<br/>
			</c:forEach>
		</div>
	</body>
</html>