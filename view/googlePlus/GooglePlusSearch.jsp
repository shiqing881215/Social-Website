<!-- This is the page for user interact with facebook -->
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Add these two lines to allow Chinese character to show on the page -->
<%@page contentType = "text/html; charset=GBK"%>
<% request.setCharacterEncoding ("GBK");%>

<html>
	<head>
		<title>GooglePlus Search Page</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/facebook/facebook-search.css" rel="stylesheet" media="screen">
		<link href="css/linkedin/linkedin-home.css" rel="stylesheet" media="screen">
		<link href="css/google/google-search.css" rel="stylesheet" media="screen">
		<link href="css/social/social.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		
		<script src="js/googlePlus/googlePlus.js"></script>
	</head>

	<body>
		<jsp:include page="../social/template-navigation.jsp" />
		<jsp:include page="../template-header.jsp" />
		
		<!-- Search Bar -->
		<div class="container search-bar-container" style="text-align: center;">
			<div class="row">
		        <div class="span12">
		            <form id="twitter-user-search" class="form-search form-horizontal pull-right" action="gp_GooglePlusSearch.do" method="get">
		                <div class="input-append span12">
		                    <input type="text" class="search-query search-bar" placeholder="Search" name="googlePlusUser">
		                    <button type="submit" class="btn"><i class="icon-search"></i></button>
		                </div>
		            </form>
		        </div>
			</div>
			<span style="color: white;">Go to </span> <a href="gp_GooglePlusProfile.do">profile</a>
		</div>
		
		<!-- Search Results -->
		<div class="googlePlus-search-results-container">
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="activity" items="${activities}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
 							<div class="single-connection-left">
	 							<a class="account-group js-user-profile-link" href="${activity.url}">
						            <img class="avatar js-action-profile-avatar " src="${activity.actor.image.url}" alt="profileImage" data-user-id="${activity.id}">
						        </a>
 							</div>
					        <div class="single-connection-right">
						        ${activity.title}
						        <a class="account-group js-user-profile-link" href="${activity.url}">
						        	Click here
						        </a>
						        <%-- <a class="account-group js-user-profile-link" href="${fbUser.link}">
						        	<span class="username js-action-profile-name">@${fbUser.username}</span>
						        </a>
							    <p class="bio ">
							        ${fbUser.about}
							    </p> --%>
					        </div> 
						</div>
					</li>
				</c:forEach> 
				</ul>
			</div>
		</div>
	</body>
</html>