function redirectForFourSquareAuthenticate() {
	window.location = ("https://foursquare.com/oauth2/authenticate?" + 
					  "client_id=1UFV3K1DLT53PKJL1QVRY0JAM4XC02KR4TLXF2WPZRBLY1BG" +
					  "&response_type=code" +
					  "&redirect_uri=http://localhost:8080/BWeb/fs_FourSquareInit.do");
}

function dateTransfer(createdAt) {
	debugger;
	var date = new Date(createdAt);    
	var curr_date = date.getDate();
	var curr_month = date.getMonth() + 1; //Months are zero based
	var curr_year = date.getFullYear();
	return "curr_date" + "curr_month" + "curr_year";
}