README

See my live demo on YouTube here
https://www.youtube.com/watch?v=lgdKYgaBV-s&list=LLB33hWoG-dkZmvrtWUmv8hg&feature=mh_lolz

Support Social Network:
Twitter 
Facebook 
Google+ 
LinkedIn 
Instagram 
FourSquare
YouTube
Tumblr

To be support:
Flickr
Pinrest
Klout
Blogger
Evernote
DropBox
Chinese Social Network 



Twitter

Login Process
For twitter, in the login process, you need go through the following steps:
1. Get the request token
2. Use this request token to redirect user to the twitter authenticate page
3. User authenticate the app on the twitter page then it redirect user to the rediect_url which is set in the step 1
4. In the above request, it contains the oauth_verifier, use this to get the final access token

1. On the welcome page, include a twitter button with on click event which will call the request token action
2. In the request token action, do the api calls to api.twitter.com/oauth/request_token, and set the callback url to the access token action url
3. After the above action succeeds, it goes to the TwitterLogin.jsp, which includes the button will trigger the api call to twitter authenticate page
   https://api.twitter.com/oauth/authenticate?oauth_token=xxxxx with the request token get in the step 2
4. After user authenticate the app, it goes back to the access token callback url which is set in the step 2
5. In the access token action, extract the oauth_verifier from the request, and use it to do the api call to 
   api.twitter.com/oauth/access_token and insert the verifier in the http header to get the final access token
6. Then we can set the access token attribute for twitter instance
Reference : https://dev.twitter.com/docs/auth/implementing-sign-twitter

Twitter App Setting:
Set Callback URL : http://127.0.0.1:8080

Search/Timeline Process:

   



Facebook

Login Process
1. On the welcome page, have a facebook button which will redirect to the facebook login page
   https://www.facebook.com/dialog/oauth?client_id=xxxxxx&redirect_uri=http://localhost:8080/BWeb/fb_Login.do
   And in the api call, set the redirect_url to call the facebook login action
2. After the above call succeeds, it will go the http://localhost:8080/BWeb/fb_Login.do?code=xxxxxxxxxx
3. We need to exchange the code into access token, do another api call by calling method getFacebookUserToken in FacebookLoginAction
4. After get the access token, we can instantiate the facebook client instance
Reference : https://developers.facebook.com/docs/facebook-login/manually-build-a-login-flow/#checktoken

Another simple way to implement the login process is to use FacebookSDK Javascript to build login process
I have a file called FacebookLogin2.jsp under view/facebook, which implement by using the Facebook JavascriptSDK,
the other thing you need to do is to add another link in the welcome page and refers to this jsp file.
Reference : https://developers.facebook.com/docs/facebook-login/login-flow-for-web/

For Facebook app set up tips:
Site URL : http://localhost:8080/BWeb
Disable sandbox mode, or you can set specific test users under Settings/Develop Roles





Google+

Login Process
1. On the welcome page, have a google+ button link to GooglePlusLogin.jsp
2. In the GooglePlusLogin.jsp follow the instruction here to construct the page
   https://developers.google.com/+/web/signin/add-button
   The only change is adding an ajax call to GooglePlusInitAction to init the plus instance with the access token
   and set the callback as a redirect to profile action
