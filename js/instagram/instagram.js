function redirectForInstagramAuthenticate() {
	debugger;
	window.location = ("https://instagram.com/oauth/authorize/?" +
			"client_id=30a60b22f53f4bd9b263366d438ad697&" +
			"redirect_uri=http%3A%2F%2Flocalhost%3A8080%2FBWeb%2Fview%2Finstagram%2FInstagramInit.jsp&" +
			"response_type=token");
}