/**
 * JS file for show twitter related stuff
 */

/**
 * Create a twitter widget, which can be a share, follow, mention, hashtag twitter button
 */ 
function twitterWidget(doc, scriptTag, id) {
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

//// Follow button widgets
//function follow(d,s,id) {
//	var js,
//	    fjs=d.getElementsByTagName(s)[0],
//	    p=/^http:/.test(d.location)?'http':'https';
//	if(!d.getElementById(id)) {
//		js=d.createElement(s);
//		js.id=id;
//		js.src=p+'://platform.twitter.com/widgets.js';
//		fjs.parentNode.insertBefore(js,fjs);
//	}
//}
//
//// Mention button widgets
//function mention(d,s,id) {
//	var js,
//		fjs=d.getElementsByTagName(s)[0],
//		p=/^http:/.test(d.location)?'http':'https';
//	if(!d.getElementById(id)) {
//		js=d.createElement(s);
//		js.id=id;
//		js.src=p+'://platform.twitter.com/widgets.js';
//		fjs.parentNode.insertBefore(js,fjs);
//	}
//}

/**
 * Function redirect user to the twitter authenticate page 
 * https://api.twitter.com/oauth/authenticate?oauth_token=********
 *See detail at https://dev.twitter.com/docs/api/1/get/oauth/authenticate
 */
function redirectForAuthenticate() {
	debugger;
	var requestToken = document.getElementById("requestToken").innerHTML.trim();
	window.location = ("https://api.twitter.com/oauth/authenticate?oauth_token="+requestToken);
}

/**
 * Parse the plain text tweet into real twitter which contains hashtag, url, mention tags
 * 
 * @param plainText --- plainText already deal with the ' and /n in server side
 * @param parentId --- the id of <p> that the plain text will be appended to
 */
function parseTweetContent(plainText, parentId) {
	var divEle = document.createElement('div');
	for (var i = 0; i < plainText.length;) {
		if (plainText.charAt(i) === '@') {
			var anchorEle = document.createElement('a');
			var endIndex = plainText.substring(i).indexOf(' ') + i;
			if (endIndex < i) endIndex = plainText.length;
			var mention = plainText.substring(i+1, endIndex);
			anchorEle.href = 'https://twitter.com/' + mention;
			anchorEle.innerHTML = '@' + mention + ' ';
			divEle.appendChild(anchorEle);
			document.getElementById(parentId).appendChild(divEle);
			i = endIndex + 1;
		} else if (plainText.charAt(i) === '#') {
			var anchorEle = document.createElement('a');
			var endIndex = plainText.substring(i).indexOf(' ') + i;
			if (endIndex < i) endIndex = plainText.length;
			var hash = plainText.substring(i+1, endIndex);
			anchorEle.href = 'https://twitter.com/search?q=%23' + hash + '&src=hash';
			anchorEle.innerHTML = "#" + hash + ' ';
			divEle.appendChild(anchorEle);
			document.getElementById(parentId).appendChild(divEle);
			i = endIndex + 1;
		} else if (plainText.substring(i, i+4) === 'http') {
			var anchorEle = document.createElement('a');
			var endIndex = plainText.substring(i).indexOf(' ') + i;
			if (endIndex < i) endIndex = plainText.length;
			var url = plainText.substring(i, endIndex);
			anchorEle.href = url;
			anchorEle.innerHTML = url + ' ';
			divEle.appendChild(anchorEle);
			document.getElementById(parentId).appendChild(divEle);
			i = endIndex + 1;
		} else {
			divEle.innerHTML = divEle.innerHTML + plainText.charAt(i);
			document.getElementById(parentId).appendChild(divEle);
			i = i + 1;
		}
	}
}
