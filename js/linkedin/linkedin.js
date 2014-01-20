function redirectForLinkedInAuthenticate() {
	// Attention, for this window redirect we don't need the url encode, browser will handle that for us
	window.location = (
			"https://www.linkedin.com/uas/oauth2/authorization?" +
			"response_type=code&client_id=0d51b2cxwpfy&" +
			"scope=r_fullprofile r_emailaddress r_network&" +
			"state=DCEEFWF45453sdffef424&" +
			"redirect_uri=http://localhost:8080/BWeb/linkedin_LinkedInInit.do");
}

function getURLParameter(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null
}