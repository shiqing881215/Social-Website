<!-- This is the page for foursquare login user -->
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Add these two lines to allow Chinese character to show on the page -->
<%@page contentType = "text/html; charset=GBK"%>
<% request.setCharacterEncoding ("GBK");%>

<html>
	<head>
		<title>FourSquare Profile</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-search.css" rel="stylesheet" media="screen">
		<link href="css/twitter/twitter-timeline.css" rel="stylesheet" media="screen">
		<link href="css/social/social.css" rel="stylesheet" media="screen">
		<link href="css/social/welcome-page.css" rel="stylesheet" media="screen">
		<link href="css/foursquare/foursquare-home.css" rel="stylesheet" media="screen">
		
		<script src="/BWeb/js/foursquare/foursquare.js"></script>
	</head>
	<body>
		<jsp:include page="../social/template-navigation.jsp" />
		<jsp:include page="../template-header.jsp" />
		
		<!-- Search Bar -->
		<div class="container search-bar-container">
			<div class="row">
		        <div class="span12">
		            <form id="twitter-user-search" class="form-search form-horizontal pull-right" action="fs_FourSquareSearch.do" method="get">
		                <div class="input-append span12">
		                    <input type="text" class="search-query search-bar" placeholder="Search" name="fourSquareUser">
		                    <button type="submit" class="btn"><i class="icon-search"></i></button>
		                </div>
		            </form>
		        </div>
			</div>
		</div>
		
		<div class="foursquare-profile-container">
			<!-- Login User Profile -->
			<h5> You are login as 
				<a class="account-group js-user-profile-link" href="https://foursquare.com/user/${loginUser.id}">
					${loginUser.firstName} ${loginUser.lastName} 
				</a>
			</h5> 
			<a class="account-group js-user-profile-link" href="https://foursquare.com/user/${loginUser.id}">
	            <img style="height: 160px; width: 160px;" src="${loginUser.photo}" alt="profileImage" data-user-id="${loginUser.id}">
	        </a>
	        <br/>
	        <h4> Home Town </h4> 
	        ${loginUser.homeCity}
	        <br/>
	        <h4> Contact </h4> 
	        <b>Phone</b> ${loginUser.contact.phone} <br/>
	        <b>Email</b> ${loginUser.contact.email} <br/>
	        <b>Twitter</b> <a href="https://twitter.com/${loginUser.contact.twitter}">${loginUser.firstName} ${loginUser.lastName}</a> <br/>
	        <b>Facebook</b> <a href="https://www.facebook.com/${loginUser.contact.facebook}">${loginUser.firstName} ${loginUser.lastName}</a> 
	        <br/>
			<!-- End of Profile -->
			
			<!-- Friends List -->
			<h4> Your Friends </h4>
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="group" items="${loginUser.friends.groups}">
					<b>${group.name}</b>
					<c:forEach var="friend" items="${group.items}">
						<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
	 						<div >
	 							<div class="single-friend-left">
		 							<a class="account-group js-user-profile-link" href="https://foursquare.com/user/${friend.id}">
							            <img class="avatar js-action-profile-avatar friend-photo" src="${friend.photo}" alt="profileImage" data-user-id="${friend.id}">
							        </a>
	 							</div>
						        <div class="single-friend-right">
							        <a class="account-group js-user-profile-link" href="https://foursquare.com/user/${friend.id}">
							        	<strong class="fullname js-action-profile-name">${friend.firstName} ${friend.lastName}</strong>
							        </a>
							        <br/>
							        <span class="username js-action-profile-name">${friend.homeCity}</span>
							        <br/>
							        <span class="username js-action-profile-name">Relationship : ${friend.relationship}</span>
						        </div>
							</div>
						</li> 
					</c:forEach>
					<br/>
				</c:forEach> 
				</ul>
			</div> 
			<!-- End of Friends List -->
			
			<!-- CheckIn List -->
			<h4> Your CheckIns </h4>
			<div class="stream-container stream search-stream">
				<ul class="stream-items js-navigable-stream" style="margin: 0; padding: 0; ">
				<c:forEach var="checkin" items="${checkins.items}">
					<li class="js-stream-item stream-item stream-item single-user-result" style="list-style-type: none;">
 						<div >
 							<img src="${checkin.venue.categories[0].icon}"></img> <a href="${checkin.venue.url}"> ${checkin.venue.name} </a> 
 							<br/>
					        ${checkin.venue.location.address} ${checkin.venue.location.city} ${checkin.venue.location.state} ${checkin.venue.location.country} ${checkin.venue.location.postalCode} <br/>
						</div>
					</li>
				</c:forEach> 
				</ul>
			</div> 
			<!-- End of CheckIn List -->
		</div>
	</body>
</html>