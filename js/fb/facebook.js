/**
 * Open facebook login page and set the redirect url to http://localhost:8080/BWeb/fb_Login.do
 * You also need to add the scope parameter here to set the permission for your app
 */
function redirectForAuthenticate() {
	debugger;
//	window.location = ("https://www.facebook.com/dialog/oauth?client_id=665302103496806&redirect_uri=https%3A%2F%2Fwww.facebook.com%2Fconnect%2Flogin_success.html");
	window.location = ("https://www.facebook.com/dialog/oauth?client_id=665302103496806&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2FBWeb%2Ffb_Login.do&" +
			"scope=email%2Cpublish_stream%2Cemail%2Crsvp_event%2Cread_stream%2Cuser_likes%2Cuser_birthday");
}

function facebookWidget(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) return;
	js = d.createElement(s); js.id = id;
	js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=665302103496806";
	fjs.parentNode.insertBefore(js, fjs);
}