/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-01-06 04:42:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.facebook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class FacebookSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<head>\n");
      out.write("\t\t<title>Twitter Search Page</title>\n");
      out.write("\t\t<!-- Bootstrap -->\n");
      out.write("\t\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<link href=\"css/twitter/twitter.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<link href=\"css/twitter/twitter-search.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<link href=\"css/twitter/twitter-timeline.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<link href=\"css/facebook/facebook-search.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<link href=\"css/social/social.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<link href=\"css/social/welcome-page.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t\n");
      out.write("\t\t<script src=\"js/fb/facebook.js\"></script>\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body style=\"background-color: #3b5998;\">\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../social/template-navigation.jsp", out, false);
      out.write('\n');
      out.write('	');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../template-header.jsp", out, false);
      out.write("\n");
      out.write("\t\n");
      out.write("\t\t<div id=\"fb-root\"></div>\n");
      out.write("\t\t<script>debugger;\n");
      out.write("\t\t(facebookWidget(document, 'script', 'facebook-jssdk'));\n");
      out.write("\t\t</script>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Search Bar -->\n");
      out.write("\t\t<div class=\"container search-bar-container\" style=\"text-align: center;\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t        <div class=\"span12\">\n");
      out.write("\t\t            <form id=\"twitter-user-search\" class=\"form-search form-horizontal pull-right\" action=\"fb_FacebookSearch.do\" method=\"get\">\n");
      out.write("\t\t                <div class=\"input-append span12\">\n");
      out.write("\t\t                    <input type=\"text\" class=\"search-query search-bar\" placeholder=\"Search\" name=\"facebookUser\">\n");
      out.write("\t\t                    <button type=\"submit\" class=\"btn\"><i class=\"icon-search\"></i></button>\n");
      out.write("\t\t                </div>\n");
      out.write("\t\t            </form>\n");
      out.write("\t\t        </div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<span style=\"color: white;\">Go to </span> <a href=\"fb_FacebookProfile.do\">profile</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Facebook Widget  -->\n");
      out.write("\t \t<div class=\"search-facebook-widget\">\n");
      out.write("\t\t \t<div class=\"fb-like\" \n");
      out.write("\t\t\t data-href=\"https://www.facebook.com/qing.shi.10\" \n");
      out.write("\t\t\t data-layout=\"standard\" \n");
      out.write("\t\t\t data-action=\"like\" \n");
      out.write("\t\t\t data-show-faces=\"true\" \n");
      out.write("\t\t\t data-share=\"true\"\n");
      out.write("\t\t\t style=\"text-align: center;\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t \t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Search Results -->\n");
      out.write("\t\t<div class=\"facebook-search-results-container\">\n");
      out.write("\t\t\t<div class=\"stream-container stream search-stream\">\n");
      out.write("\t\t\t\t<ul class=\"stream-items js-navigable-stream\" style=\"margin: 0; padding: 0; \">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("\t\t\t\t</ul>\n");
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
    // /view/facebook/FacebookSearch.jsp(61,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("fbUser");
    // /view/facebook/FacebookSearch.jsp(61,4) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fbUserSearchList}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<li class=\"js-stream-item stream-item stream-item single-user-result\" style=\"list-style-type: none;\">\n");
          out.write(" \t\t\t\t\t\t<div >\n");
          out.write(" \t\t\t\t\t\t\t<div class=\"left\">\n");
          out.write("\t \t\t\t\t\t\t\t<a class=\"account-group js-user-profile-link\" href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fbUser.link}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t            <img class=\"avatar js-action-profile-avatar \" src=\"http://graph.facebook.com/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fbUser.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("/picture\" alt=\"profileImage\" data-user-id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fbUser.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t        </a>\n");
          out.write(" \t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t        <div class=\"right\">\n");
          out.write("\t\t\t\t\t\t        <a class=\"account-group js-user-profile-link\" href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fbUser.link}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t        \t<strong class=\"fullname js-action-profile-name\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fbUser.firstName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fbUser.lastName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</strong>\n");
          out.write("\t\t\t\t\t\t        </a>\n");
          out.write("\t\t\t\t\t\t        <a class=\"account-group js-user-profile-link\" href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fbUser.link}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t\t        \t<span class=\"username js-action-profile-name\">@");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fbUser.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span>\n");
          out.write("\t\t\t\t\t\t        </a>\n");
          out.write("\t\t\t\t\t\t\t    ");
          out.write("\n");
          out.write("\t\t\t\t\t        </div>\n");
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
}
