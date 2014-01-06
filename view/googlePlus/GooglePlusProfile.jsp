<!-- This is the page for user interact with twitter -->
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Google+ Profile</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/google/google-profile.css" rel="stylesheet" media="screen">
		<link href="css/social/social.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
	
		<script src="js/fb/facebook.js"></script>
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
		</div>
		
		<div class="google-profile-container">
			<!-- Login User Profile -->
			<h5> You are login as 
				<a class="account-group js-user-profile-link" href="${GoogleLoginUser.url}">
					${GoogleLoginUser.displayName} 
				</a>
			</h5> 
			<a class="account-group js-user-profile-link" href="${GoogleLoginUser.url}">
	            <img style="" src="${GoogleLoginUser.image.url}" alt="profileImage" data-user-id="${GoogleLoginUser.id}">
	        </a>
	        <br/>
	        
	        <h5>Experience</h5>
	        <c:forEach var="organization" items="${GoogleLoginUser.organizations}">
				${organization.type} : ${organization.name}
				<br/>
			</c:forEach>
	        
	        <h5>Living</h5>
	        <c:forEach var="place" items="${GoogleLoginUser.placesLived}">
				${place.value}
				<br/>
			</c:forEach>
			<!-- End of Profile -->
		</div>
		
		<div class="google-widget-container">
			<h5> You can follow me on <span style="color: #d34836;">Google+</span> here. </h5>
			<!-- Place this tag where you want the widget to render. -->
			<div class="g-person" data-width="297" data-href="//plus.google.com/116216522361915002333" data-rel="author"></div>
			
			<!-- Place this tag after the last widget tag. -->
			<script type="text/javascript">
			  (function() {
			    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
			    po.src = 'https://apis.google.com/js/platform.js';
			    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
			  })();
			</script>
		</div>
		
	</body>
</html>