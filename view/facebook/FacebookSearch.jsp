<!-- This is the page for user interact with twitter -->
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Twitter Search Page</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/facebook/facebook-search.css" rel="stylesheet" media="screen">
		<link href="css/social/social.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		
		<script src="js/fb/facebook.js"></script>
	</head>

	<body>
		<jsp:include page="../social/template-navigation.jsp" />
		<jsp:include page="../template-header.jsp" />
	
		<div id="fb-root"></div>
		<script>debugger;
		(facebookWidget(document, 'script', 'facebook-jssdk'));
		</script>
		
		<!-- Search Bar -->
		<div class="container search-bar-container" style="text-align: center;">
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
			<span style="color: white;">Go to </span> <a href="fb_FacebookProfile.do">profile</a>
		</div>
		
		<!-- Facebook Widget  -->
	 	<div class="search-facebook-widget">
		 	<div class="fb-like" 
			 data-href="https://www.facebook.com/qing.shi.10" 
			 data-layout="standard" 
			 data-action="like" 
			 data-show-faces="true" 
			 data-share="true"
			 style="text-align: center;">
			</div>
	 	</div>
		
		
		<!-- Search Results -->
		<div class="facebook-search-results-container">
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="fbUser" items="${fbUserSearchList}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
 							<div class="left">
	 							<a class="account-group js-user-profile-link" href="${fbUser.link}">
						            <img class="avatar js-action-profile-avatar " src="http://graph.facebook.com/${fbUser.username}/picture" alt="profileImage" data-user-id="${fbUser.username}">
						        </a>
 							</div>
					        <div class="right">
						        <a class="account-group js-user-profile-link" href="${fbUser.link}">
						        	<strong class="fullname js-action-profile-name">${fbUser.firstName} ${fbUser.lastName}</strong>
						        </a>
						        <a class="account-group js-user-profile-link" href="${fbUser.link}">
						        	<span class="username js-action-profile-name">@${fbUser.username}</span>
						        </a>
							    <%-- <p class="bio ">
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