<!-- This is the page for user interact with twitter -->
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Facebook Profile</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/facebook/facebook-search.css" rel="stylesheet" media="screen">
		<link href="css/facebook/facebook-profile.css" rel="stylesheet" media="screen">
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
		<div class="container search-bar-container">
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
		
		<!-- Facebook Widget  -->
		<div class="profile-facebook-widget">
			<div class="fb-like" 
			 data-href="https://www.facebook.com/qing.shi.10" 
			 data-layout="standard" 
			 data-action="like" 
			 data-show-faces="true" 
			 data-share="true"
			 style="text-align: center;">
			</div>
		</div>
		
		
		<div class="facebook-profile-container">
			<!-- Login User Profile -->
			<h5> You are login as 
				<a class="account-group js-user-profile-link" href="${loginUser.link}">
					${loginUser.firstName} ${loginUser.lastName} 
				</a>
			</h5> 
			<a class="account-group js-user-profile-link" href="${loginUser.link}">
	            <img style="height: 200px; width: 160px;" src="http://graph.facebook.com/${loginUser.username}/picture?type=large" alt="profileImage" data-user-id="${loginUser.username}">
	        </a>
	        <br/>
	        <h4> Bio </h4> 
	        ${loginUser.bio}
	        <br/>
	        <%-- Quote : 
	        <br/>
	        ${loginUser.quotes}
	        <br/>
	        About : 
	        <br/>
	        ${loginUser.about}
	        <br/> --%>
	        <h4> Birthday </h4> 
	        ${loginUser.birthday}
	        <br/>
	        <h4> Email </h4> 
	        ${loginUser.email}
	        <br/>
	        <h4> Gender </h4> 
	        ${loginUser.gender}
	        <br/>
	        <h4> Location </h4> 
	        Hometown : ${loginUser.hometown.name}
	        <br/>
	        Live in ${loginUser.location.name}
	        <br/>
	        <h4> Work </h4> 
			<c:forEach var="work" items="${loginUser.work}">
				${work.position.name} at ${work.employer.name}
				<br/>
				<%-- Start from <fmt:formatDate value="${work.startDate}" pattern="MM/YYYY"/> to 
				<c:if test="${empty work.endDate}">Now</c:if>
					<fmt:formatDate value="${work.endDate}" pattern="MM/YYYY"/>
				<br/> --%>
			</c:forEach>
			<h4> Education </h4> 
			<c:forEach var="education" items="${loginUser.education}">
				${education.school.name} ${education.year.name} 
				<br/>
			</c:forEach>
			<!-- End of Profile -->
			
			<!-- Friends List -->
			<h4> Your Friends </h4>
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="fbUser" items="${myFriends}">
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
			<!-- End of Friends List -->
			
			<!-- Feeds List -->
			<h4> Your Feeds </h4>
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="post" items="${myFeeds}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
					        From 
					        <a	href="https://www.facebook.com/${post.from.id}">
					        	${post.from.name}
					        </a>
					        To 
					        <a	href="https://www.facebook.com/${post.to[0].id}">
					        	${post.to[0].name}
					        </a>
					        <br/>
					        <a href="${post.actions[0].link}">
					        	${post.message}
					        </a>
						</div>
					</li>
				</c:forEach> 
				</ul>
			</div>
			<!-- End of Feeds List -->
		</div>
	</body>
</html>