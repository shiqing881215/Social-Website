<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>LinkedIn Home Page</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/instagram/instagram-home.css" rel="stylesheet" media="screen">
		<link href="css/facebook/facebook-profile.css" rel="stylesheet" media="screen">
		<link href="css/linkedin/linkedin-home.css" rel="stylesheet" media="screen">
		<link href="css/social/social.css" rel="stylesheet" media="screen">
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
		<div class="linkedin-profile-container">
			<a href="${loginUser.profileUrl}">
				<b>${loginUser.firstName} ${loginUser.lastName}</b>
			</a> 
			<br/>
			<img alt="ProfilePhoto" src="${loginUser.picUrl}">
			<br/>
			<b>${loginUser.headline}</b>
			<br/>
		</div>
		
		<!-- Widget -->
		<!-- <div class="widget-container">
			<a href="http://instagram.com/shiqing881215?ref=badge" class="ig-b- ig-b-v-24">
				<img src="//badges.instagram.com/static/images/ig-badge-view-24.png" alt="Instagram" />
			</a>
		</div> -->
		
		<!-- Feeds List -->
		<%-- <div class="feeds-container">
			<c:forEach var="connection" items="${connections}">
				<b>${connection.firstName} ${connection.lastName}</b>
				${connection.headline}
				<br/> 
				<br/>
				<img src="${connection.picUrl}" class="connection-photo">
				<br/>
				<br/>
			</c:forEach>
		</div> --%>
		
		<!-- Connection List -->
		<div class="linkedin-connection-container">
			<h4> Your Connections </h4>
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="connection" items="${connections}">
					<li class="js-stream-item stream-item stream-item single-connection-result" style="list-style-type: none;">
						<div>
							<div class="single-connection-left">
					            <img class="avatar js-action-profile-avatar connection-photo" src="${connection.picUrl}" alt="profileImage">
							</div>
				        	<div class="single-connection-right">
					        	<strong class="fullname js-action-profile-name"> ${connection.firstName} ${connection.lastName}</strong>
					        	<br/>
					        	<span class="username js-action-profile-name"> ${connection.headline}</span>
				        	</div>
						</div>
					</li>
				</c:forEach> 
				</ul>
			</div>
		</div>
		<!-- End of Friends List --> 
	</body>
</html>