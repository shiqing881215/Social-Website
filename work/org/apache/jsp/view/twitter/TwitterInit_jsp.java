/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2013-11-28 09:13:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.twitter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class TwitterInit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- This is the page for user interact with twitter -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Twitter page</title>\n");
      out.write("\t<!-- Bootstrap -->\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"css/twitter/twitter.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"css/twitter/twitter-search.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"css/twitter/twitter-profile.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\n");
      out.write("\t<script src=\"js/tw/twitter.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\t<body class=\"search-container\" style=\"background-image: url('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.profileBackgroundImageURL}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">\n");
      out.write("\t\t<div class=\"container\" style=\"text-align: center;\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t        <div class=\"span12\">\n");
      out.write("\t\t            <form id=\"twitter-user-search\" class=\"form-search form-horizontal pull-right\" action=\"tw_TwitterSearch.do\" method=\"get\">\n");
      out.write("\t\t                <div class=\"input-append span12\">\n");
      out.write("\t\t                    <input type=\"text\" class=\"search-query search-bar\" placeholder=\"Search\" name=\"twitterUser\">\n");
      out.write("\t\t                    <button type=\"submit\" class=\"btn\"><i class=\"icon-search\"></i></button>\n");
      out.write("\t\t                </div>\n");
      out.write("\t\t            </form>\n");
      out.write("\t\t        </div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"login-user\">\n");
      out.write("\t\t\t<!-- Login user part -->\n");
      out.write("\t\t\t<div class=\"user-card\" style=\"text-align: center; background-image: url('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.profileBannerURL}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">\n");
      out.write("\t\t\t\t<a class=\"user-card\" href=\"https://twitter.com/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t            \t<img class=\"\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.profileImageURL}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" alt=\"profileImage\" data-user-id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t        </a>\n");
      out.write("\t\t        <br/>\n");
      out.write("\t\t        <a class=\"user-card-content\" href=\"https://twitter.com/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t        \t<strong style=\"font-size: 140%\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</strong>\n");
      out.write("\t\t        </a>\n");
      out.write("\t\t        <br/>\n");
      out.write("\t\t        <a class=\"user-card-content\" href=\"https://twitter.com/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t        \t<span style=\"font-size: 120%\">@");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\n");
      out.write("\t\t        </a>\n");
      out.write("\t\t\t    <p class=\"user-card-content\">\n");
      out.write("\t\t\t        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t\t\t    </p>\n");
      out.write("\t\t\t    <p class=\"user-card-content\">\n");
      out.write("\t\t\t    \t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.location}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t\t\t    </p>\n");
      out.write("\t\t\t    <a class=\"user-card-content\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t\t    \t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginTwitterUser.url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t\t\t    </a>\n");
      out.write("\t        </div>\n");
      out.write("\t        <!-- Me header -->\n");
      out.write("\t        <div >\n");
      out.write("\t        \t<h3 class=\"profile-tweets-header\"> \n");
      out.write("\t        \t\t<img alt=\"me\" src=\"img/profile_image.png\" class=\"profile-image\">\n");
      out.write("\t        \t\tMe \n");
      out.write("\t        \t</h3>\n");
      out.write("\t        </div>\n");
      out.write("\t        <!-- User Timeline  -->\n");
      out.write("\t        <ul class=\"stream-items js-navigable-stream\" style=\"margin: 0; padding: 0; \">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Home Timeline -->\n");
      out.write("\t\t<div class=\"home-timeline-container\">\n");
      out.write("\t\t\t<div class=\"stream-container stream search-stream\">\n");
      out.write("\t\t\t\t<!-- Home header -->\n");
      out.write("\t\t        <div >\n");
      out.write("\t\t        \t<h3 class=\"home-tweets-header\"> \n");
      out.write("\t\t        \t\t<img alt=\"home\" src=\"img/home_image.jpg\" class=\"profile-image\">\n");
      out.write("\t\t        \t\tHome \n");
      out.write("\t\t        \t</h3>\n");
      out.write("\t\t        </div>\n");
      out.write("\t\t\t\t<ul class=\"stream-items js-navigable-stream\" style=\"margin: 0; padding: 0; \">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /view/twitter/TwitterInit.jsp(64,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("tweet");
    // /view/twitter/TwitterInit.jsp(64,4) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userTimeLine}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<li class=\"js-stream-item stream-item stream-item single-user-result\" style=\"list-style-type: none;\">\n");
          out.write(" \t\t\t\t\t\t<div >\n");
          out.write(" \t\t\t\t\t\t\t<div class=\"left\">\n");
          out.write("\t \t\t\t\t\t\t\t<a class=\"account-group js-user-profile-link\" href=\"https://twitter.com/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t            <img class=\"avatar js-action-profile-avatar \" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.profileImageURL}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" alt=\"profileImage\">\n");
          out.write("\t\t\t\t\t\t        </a>\n");
          out.write(" \t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t        <div class=\"right\">\n");
          out.write("\t\t\t\t\t\t        <a class=\"account-group js-user-profile-link\" href=\"https://twitter.com/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t        \t<strong class=\"fullname js-action-profile-name\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</strong>\n");
          out.write("\t\t\t\t\t\t        </a>\n");
          out.write("\t\t\t\t\t\t        <a class=\"account-group js-user-profile-link\" href=\"https://twitter.com/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t        \t<span class=\"username js-action-profile-name\">@");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span>\n");
          out.write("\t\t\t\t\t\t        </a>\n");
          out.write("\t\t\t\t\t\t\t    <p class=\"bio \">\n");
          out.write("\t\t\t\t\t\t\t        ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.plainText}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("\t\t\t\t\t\t\t    </p>\n");
          out.write("\t\t\t\t\t        </div>\n");
          out.write("\t\t\t\t\t        \n");
          out.write("\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t</li>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /view/twitter/TwitterInit.jsp(101,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("tweet");
    // /view/twitter/TwitterInit.jsp(101,4) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${homeTimeLine}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<li class=\"js-stream-item stream-item stream-item single-user-result\" style=\"list-style-type: none;\">\n");
          out.write(" \t\t\t\t\t\t<div >\n");
          out.write(" \t\t\t\t\t\t\t<div class=\"left\">\n");
          out.write("\t \t\t\t\t\t\t\t<a class=\"account-group js-user-profile-link\" href=\"https://twitter.com/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t            <img class=\"avatar js-action-profile-avatar \" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.profileImageURL}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" alt=\"profileImage\">\n");
          out.write("\t\t\t\t\t\t        </a>\n");
          out.write(" \t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t        <div class=\"right\">\n");
          out.write("\t\t\t\t\t\t        <a class=\"account-group js-user-profile-link\" href=\"https://twitter.com/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t        \t<strong class=\"fullname js-action-profile-name\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</strong>\n");
          out.write("\t\t\t\t\t\t        </a>\n");
          out.write("\t\t\t\t\t\t        <a class=\"account-group js-user-profile-link\" href=\"https://twitter.com/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t        \t<span class=\"username js-action-profile-name\">@");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.twitterUser.screenName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span>\n");
          out.write("\t\t\t\t\t\t        </a>\n");
          out.write("\t\t\t\t\t\t\t    <p class=\"bio \">\n");
          out.write("\t\t\t\t\t\t\t        ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tweet.plainText}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("\t\t\t\t\t\t\t    </p>\n");
          out.write("\t\t\t\t\t        </div>\n");
          out.write("\t\t\t\t\t        \n");
          out.write("\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t</li>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
