<!-- This is the page for user interact with twitter -->
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Twitter Timeline Page</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/social/social.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		
		<script src="js/tw/twitter.js"></script>
	</head>

	<body>
		<jsp:include page="../social/template-navigation.jsp" />
		<jsp:include page="../template-header.jsp" />
	
		<div class="container search-bar-container">
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
		</div>
		
		<!-- Tweet Button -->
		<div class="tweet-button">
			<a href="https://twitter.com/share" class="twitter-share-button" data-via="sesedeqing">Tweet</a>
			<script type="text/javascript">
				twitterWidget(document, 'script', 'twitter-wjs');
			</script>
		</div>
		
		<!-- Follow Button -->
		<div class="follow-button">
			<a href="https://twitter.com/sesedeqing" class="twitter-follow-button" data-show-count="true">Follow Me On Twitter @sesedeqing</a>
			<script type="text/javascript">
				twitterWidget(document, 'script', 'twitter-wjs');
			</script>
		</div>
		
		<!-- Mention Button -->
		<div class="mention-button">
			<a href="https://twitter.com/intent/tweet?screen_name=sesedeqing" class="twitter-mention-button" data-related="sesedeqing">Tweet to @sesedeqing</a>
			<script type="text/javascript">
				twitterWidget(document, 'script', 'twitter-wjs');
			</script>
		</div>
		
		<!-- Hashtag Button -->	
		<div class="hashtag-button">
			<a href="https://twitter.com/intent/tweet?button_hashtag=SocialWebsiteRocks" class="twitter-hashtag-button" data-related="sesedeqing">Tweet #SocialWebsiteRocks</a>
			<script type="text/javascript">
				twitterWidget(document, 'script', 'twitter-wjs');
			</script>
		</div>
		
		<div class="login-user">
			<!-- Login user part -->
			<div class="user-card" style="text-align: center; background-image: url('${loginTwitterUser.profileBannerURL}')">
				<a class="user-card" href="https://twitter.com/${loginTwitterUser.screenName}">
	            	<img class="" src="${loginTwitterUser.profileImageURL}" alt="profileImage" data-user-id="${loginTwitterUser.id}">
		        </a>
		        <br/>
		        <a class="user-card-content" href="https://twitter.com/${loginTwitterUser.screenName}">
		        	<strong style="font-size: 140%">${loginTwitterUser.name}</strong>
		        </a>
		        <br/>
		        <a class="user-card-content" href="https://twitter.com/${loginTwitterUser.screenName}">
		        	<span style="font-size: 120%">@${loginTwitterUser.screenName}</span>
		        </a>
			    <p class="user-card-content">
			        ${loginTwitterUser.description}
			    </p>
			    <p class="user-card-content">
			    	${loginTwitterUser.location}
			    </p>
			    <a class="user-card-content" href="${loginTwitterUser.url}">
			    	${loginTwitterUser.url}
			    </a>
	        </div>
	        <!-- Me header -->
	        <div >
	        	<h3 class="profile-tweets-header"> 
	        		<img alt="me" src="img/profile_image.png" class="profile-image">
	        		Me 
	        	</h3>
	        </div>
	        <!-- User Timeline  -->
	        <ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="tweet" items="${userTimeLine}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
 							<div class="left">
	 							<a class="account-group js-user-profile-link" href="https://twitter.com/${tweet.twitterUser.screenName}">
						            <img class="avatar js-action-profile-avatar " src="${tweet.twitterUser.profileImageURL}" alt="profileImage">
						        </a>
 							</div>
					        <div class="right">
						        <a class="account-group js-user-profile-link" href="https://twitter.com/${tweet.twitterUser.screenName}">
						        	<strong class="fullname js-action-profile-name">${tweet.twitterUser.name}</strong>
						        </a>
						        <a class="account-group js-user-profile-link" href="https://twitter.com/${tweet.twitterUser.screenName}">
						        	<span class="username js-action-profile-name">@${tweet.twitterUser.screenName}</span>
						        </a>
							    <p class="bio" id="${tweet.id}">
							        <%-- ${tweet.plainText} --%>
							        <script type="text/javascript">
							        	parseTweetContent('${tweet.plainText}', '${tweet.id}');
							        </script>
							    </p>
					        </div>
					        
						</div>
					</li>
				</c:forEach> 
			</ul>
		</div>
		
		<!-- Home Timeline -->
		<div class="home-timeline-container">
			<div class="stream-container stream search-stream">
				<!-- Home header -->
		        <div >
		        	<h3 class="home-tweets-header"> 
		        		<img alt="home" src="img/home_image.jpg" class="profile-image">
		        		Home 
		        	</h3>
		        </div>
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="tweet" items="${homeTimeLine}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
 							<div class="left">
	 							<a class="account-group js-user-profile-link" href="https://twitter.com/${tweet.twitterUser.screenName}">
						            <img class="avatar js-action-profile-avatar " src="${tweet.twitterUser.profileImageURL}" alt="profileImage">
						        </a>
 							</div>
					        <div class="right">
						        <a class="account-group js-user-profile-link" href="https://twitter.com/${tweet.twitterUser.screenName}">
						        	<strong class="fullname js-action-profile-name">${tweet.twitterUser.name}</strong>
						        </a>
						        <a class="account-group js-user-profile-link" href="https://twitter.com/${tweet.twitterUser.screenName}">
						        	<span class="username js-action-profile-name">@${tweet.twitterUser.screenName}</span>
						        </a>
							    <p class="bio" id="${tweet.id}">
							        <%-- ${tweet.plainText} --%>
							        <script type="text/javascript">
							        	parseTweetContent('${tweet.plainText}', '${tweet.id}');
							        </script>
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