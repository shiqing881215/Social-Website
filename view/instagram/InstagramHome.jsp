<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Instagram Home Page</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="css/instagram/instagram-home.css" rel="stylesheet" media="screen">
	</head>
	
	<body>
		<jsp:include page="../social/template-navigation.jsp" />
		<jsp:include page="../template-header.jsp" />
		
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