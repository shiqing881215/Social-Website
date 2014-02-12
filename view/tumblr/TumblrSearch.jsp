<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Tumblr Search Page</title>
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
		            <form id="twitter-user-search" class="form-search form-horizontal pull-right" action="tb_TumblrSearch.do" method="get">
		                <div class="input-append span12">
		                    <input type="text" class="search-query search-bar" placeholder="Search" name="tumblrUser">
		                    <button type="submit" class="btn"><i class="icon-search"></i></button>
		                </div>
		            </form>
		        </div>
			</div>
			<span style="color: white;">Go to </span> <a href="tb_TumblrDashboard.do">Dashboard</a>
		</div>
		
		<!-- Search Results -->
		<div class="foursquare-search-results-container">
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
					<%
						if (request.getAttribute("user") == null) {
					%> 
						<b>
						No user found for id : ${tumblrUser}. 
						<br/>
						Please try another search for exact user id.
						</b>
					<% 
						} else {
					%>
				
					<!-- User Info -->
					<div>
						<h4> User Info</h4>
						<div class="single-friend-left">
							<a class="account-group js-user-profile-link" href="http://${user.blog.name}.tumblr.com">
				            <img class="avatar js-action-profile-avatar friend-photo" src="${user.avater}" alt="profileImage" data-user-id="${user.blog.name}">
				        </a>
						</div>
				        <div class="single-friend-right">
					        <a class="account-group js-user-profile-link" href="http://${user.blog.name}.tumblr.com">
					        	<strong class="fullname js-action-profile-name">${user.blog.name} ${user.blog.title}</strong>
					        </a>
					        <br/>
					        Posts : ${user.blog.postCount}
				        	<br/>
				        	Likes : ${user.blog.likeCount}
				        </div>
					</div>
					<!-- End of User Info -->
					
					<!-- Likes -->
					<h4> User Likes </h4>
						<h5>Text</h5>
						<c:forEach var="textLike" items="${user.textLikes}">
							<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
		 						<div >
		 							<b>${textLike.title}</b>
		 							<br/>
		 							${textLike.body}
								</div>
							</li>
						</c:forEach> 
						
						<h5>Photo</h5>
						<c:forEach var="photoLike" items="${user.photoLikes}">
							<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
		 						<div >
		 							${photoLike.caption}
		 							<a href="${photoLike.postUrl}" target="blank">
		 								<img alt="photo" src="${photoLike.photos[0].sizes[0].url}">
		 							</a>
					    			<br/>
					    			${photoLike.dateGMT}
					    			<br/>
					    			<a href="${photoLike.postUrl}" target="blank"> Click here to go to the link in Tumblr </a> 
								</div>
							</li>
						</c:forEach>
						
						<h5>Video</h5>
						<c:forEach var="videoLike" items="${user.videoLikes}">
							<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
		 						${videoLike.caption}
								 <br/>
		 						 <div >
		 						    <!-- [0]250px,[1]400px,[2]500px -->
		 							${videoLike.videos[1].embedCode}
								</div> 
								<br/>
								${videoLike.dateGMT}
								<br/>
					    		<a href="${videoLike.postUrl}" target="blank"> Click here to go to the link in Tumblr </a> 
							</li>
						</c:forEach>
					<!-- End of Likes -->
					
					<!-- Posts -->
					<h4> User Posts </h4>
						<h5>Text</h5>
						<c:forEach var="textPost" items="${user.textPosts}">
							<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
		 						<div >
		 							<b>${textPost.title}</b>
		 							<br/>
		 							${textPost.body}
								</div>
							</li>
						</c:forEach> 
						
						<h5>Photo</h5>
						<c:forEach var="photoPost" items="${user.photoPosts}">
							<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
		 						<div >
		 							${photoPost.caption}
		 							<a href="${photoPost.postUrl}" target="blank">
		 								<img alt="photo" src="${photoPost.photos[0].sizes[0].url}">
		 							</a>
					    			<br/>
					    			${photoPost.dateGMT}
					    			<br/>
					    			<a href="${photoPost.postUrl}" target="blank"> Click here to go to the link in Tumblr </a> 
								</div>
							</li>
						</c:forEach>
						
						<h5>Video</h5>
						<c:forEach var="videoPost" items="${user.videoPosts}">
							<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
								 ${videoPost.caption}
								 <br/>
		 						 <div >
		 						    <!-- [0]250px,[1]400px,[2]500px -->
		 							${videoPost.videos[1].embedCode}
								</div> 
								<br/>
								${videoPost.dateGMT}
								<br/>
					    		<a href="${videoPost.postUrl}" target="blank"> Click here to go to the link in Tumblr </a> 
							</li>
						</c:forEach>
					<!-- End of Posts -->
					
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</body>
</html>