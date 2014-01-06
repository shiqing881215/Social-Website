<%@page import="java.util.List" %>
<html>
<head>
	<title>Error Page</title>
	<link href="/BWeb/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="/BWeb/css/social/welcome-page.css" rel="stylesheet" media="screen">
	<link href="/BWeb/css/error.css" rel="stylesheet" media="screen">
</head>

<body>
	<jsp:include page="template-header.jsp" />
	<div class="container">
	    <div class="row">
	        <div class="col-md-12">
	            <div class="error-template">
	            
	            <%
								      List<String> errors = (List<String>)request.getAttribute("errors");
									  if (errors != null && errors.size() != 0) {
								  %>
								  <div class="alert alert-error">
								  <%=errors.get(0) %>
								  </div>
									  <%-- <h3 style="color: red;"> <%=errors.get(0) %> </h3> 
									  <br/> --%>
								  <% 
									  } 
								  %>
	            
	                <h1>
	                    Oops!</h1>
	                <h2>
	                    404 Not Found</h2>
	                <div class="error-details">
	                    Sorry, an error has occured, Requested page not found!
	                </div>
	                <div class="error-actions">
	                    <a href="http://localhost:8080/BWeb/login.do" class="btn btn-primary btn-lg">
	                        Take Me Home 
	                    </a>
	                    <a href="http://localhost:8080/BWeb/view/support.jsp" class="btn btn-default btn-lg"> 
	                    	Contact Support 
	                    </a>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>

</body>
</html>