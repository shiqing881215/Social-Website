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
		
		<script src="js/tw/twitter.js"></script>
	</head>

	<body style="background-image: url('${loginTwitterUser.profileBackgroundImageURL}')">
		<jsp:include page="../social/template-navigation.jsp" />
	
		<!-- Search Bar -->
		<div class="container" style="text-align: center;">
			<div class="row">
		        <div class="span12">
		            <form id="twitter-user-search" class="form-search form-horizontal pull-right" action="tw_TwitterSearch.do" method="get">
		                <div class="input-append span12">
		                    <input type="text" class="search-query search-bar" placeholder="Search" name="twitterUser">
		                    <button type="submit" class="btn"><i class="icon-search"></i></button>
		                </div>
		            </form>
		        </div>
			</div>
			Go to <a href="tw_TwitterTimeline.do">timeline</a>.
		</div>
		
		<!-- Search Results -->
		<div class="search-results-container">
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="twUser" items="${twUserSearchList}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
 							<div class="left">
	 							<a class="account-group js-user-profile-link" href="https://twitter.com/${twUser.screenName}">
						            <img class="avatar js-action-profile-avatar " src="${twUser.profileImageURL}" alt="profileImage" data-user-id="${twUser.id}">
						        </a>
 							</div>
					        <div class="right">
						        <a class="account-group js-user-profile-link" href="https://twitter.com/${twUser.screenName}">
						        	<strong class="fullname js-action-profile-name">${twUser.name}</strong>
						        </a>
						        <a class="account-group js-user-profile-link" href="https://twitter.com/${twUser.screenName}">
						        	<span class="username js-action-profile-name">@${twUser.screenName}</span>
						        </a>
							    <p class="bio ">
							        ${twUser.description}
							    </p>
					        </div>
					        
						</div>
					</li>
				</c:forEach> 
				</ul>
			</div>
		</div>
	</body>
</html>