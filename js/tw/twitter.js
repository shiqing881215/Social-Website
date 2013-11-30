/**
 * JS file for show twitter related widgets
 */

// Show tweets widgets
function showTweets(doc, scriptTag, id) {
	var scriptEle, 
		fjs = doc.getElementsByTagName(scriptTag)[0], 
		protocol = /^http:/.test(doc.location)?'http':'https';
	if(!doc.getElementById(id)) {
		scriptEle = doc.createElement(scriptTag);
		scriptEle.id = id;
		scriptEle.src = protocol + '://platform.twitter.com/widgets.js';
		fjs.parentNode.insertBefore(scriptEle,fjs);
	}
}

// Function redirect user to the twitter authenticate page 
// https://api.twitter.com/oauth/authenticate?oauth_token=********
// See detail at https://dev.twitter.com/docs/api/1/get/oauth/authenticate
function redirectForAuthenticate() {
	debugger;
	var requestToken = document.getElementById("requestToken").innerHTML.trim();
//	window.open("https://api.twitter.com/oauth/authenticate?oauth_token="+requestToken);
	window.location = ("https://api.twitter.com/oauth/authenticate?oauth_token="+requestToken);
}
