<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Tumblr Dashboard</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/social/social.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="css/foursquare/foursquare-home.css" rel="stylesheet" media="screen">
		<link href="css/tumblr/tumblr-dashboard.css" rel="stylesheet" media="screen">
		
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
		</div>
		
		<!-- Text Posts -->
		<div class="tumblr-text-posts-container">
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<h4> Text Posts </h4>
				<c:forEach var="textPost" items="${textPosts}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
							<b> ${textPost.title} </b>
							<br/>
							${textPost.body}
			    			<br/>
			    			${textPost.dateGMT}
			    			<br/>
			    			<a href="${textPost.postUrl}"> Click here to go to the link in Tumblr </a> 
						</div>
					</li>
				</c:forEach> 
				</ul>
			</div> 
		</div>
		<!-- End of Text Posts -->
		
		<!-- Photo Posts -->
		<div class="tumblr-photo-posts-container">
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<h4> Photo Posts </h4>
				<c:forEach var="photoPost" items="${photoPosts}">
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
				</ul>
			</div> 
		</div>
		<!-- End of Photo Posts -->
	</body>
</html>