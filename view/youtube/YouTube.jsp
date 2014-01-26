<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Instagram Home Page</title>
		<link href="/BWeb/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/instagram/instagram-home.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/youtube/youtube.css" rel="stylesheet" media="screen">
		<link href="/BWeb/css/foursquare/foursquare-home.css" rel="stylesheet" media="screen">
		<script src="/BWeb/js/youtube/youtube.js" type="text/javascript"></script>
	</head>
	
	<body>
		<jsp:include page="../social/template-navigation.jsp" />
		<jsp:include page="../template-header.jsp" />
		
		<!-- Search Bar -->
		<div class="container search-bar-container" style="text-align: center;">
			<div class="row">
		        <div class="span12">
		            <form id="twitter-user-search" class="form-search form-horizontal pull-right" action="/BWeb/view/youtube/YouTube.jsp" method="get">
		                <div class="input-append span12">
		                    <input type="text" class="search-query search-bar" placeholder="Search" name="youTubeSearchQuery">
		                    <button type="submit" class="btn"><i class="icon-search"></i></button>
		                    <!-- Hidden field to store the query value for js call use -->
		                    <div id="youTubeSearchQuery" style="visibility: hidden;" id="requestToken">
								<%= request.getParameter("youTubeSearchQuery") %>
							</div>
		                </div>
		            </form>
		        </div>
			</div>
		</div>
		
		<div id="ytThumbs" class="youtube-search-container"></div>

		<script type="text/javascript">
			var searchQuery = document.getElementById('youTubeSearchQuery').innerHTML;
			ytEmbed.init({'block':'ytThumbs','q': searchQuery== null? 'social medial' : searchQuery,'type':'search','results':5,'order':'most_relevance','player':'embed','layout':'full'});
		</script> 
	</body>
</html>