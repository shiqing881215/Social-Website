function redirectForTumblrAuthenticate() {
	var requestToken = document.getElementById("requestToken").innerHTML.trim();
	window.location = ("https://www.tumblr.com/oauth/authorize?oauth_token=" + requestToken);
}