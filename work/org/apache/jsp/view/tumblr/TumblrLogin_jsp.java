/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-01-28 03:30:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.tumblr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TumblrLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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

      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Tumblr Login Page</title>\n");
      out.write("\t\t<!-- Bootstrap -->\n");
      out.write("\t\t<link href=\"/BWeb/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<link href=\"/BWeb/css/additional.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<link href=\"/BWeb/css/social/welcome-page.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<link href=\"/BWeb/css/social/login-page.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t\t<script src=\"/BWeb/js/tumblr/tumblr.js\"></script>\n");
      out.write("\t\t<script src=\"/BWeb/js/jquery-1.9.1.js\"></script>\n");
      out.write("\t</head>\n");
      out.write("\t\n");
      out.write("\t<body>\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../template-header.jsp", out, false);
      out.write("\n");
      out.write("\t\t<div class=\"container account-wall login-panel\">\n");
      out.write("\t\t\t<h2 class=\"form-signin-heading\">Sign in</h2>\n");
      out.write("\t\t\t<h4 class=\"text-muted\">Connect with your Tumblr account</h4>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<img alt=\"tumblr icon\" src=\"/BWeb/img/Tumblr.png\" style=\"width: 73px;height: 73px;\">\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<button onclick=\"redirectForTumblrAuthenticate()\" class=\"btn tumblr-color btn-primary social-button-size\">Login with tumblr</button>\n");
      out.write("\t\t\t<div style=\"visibility: hidden;\" id=\"requestToken\">\n");
      out.write("\t\t\t\t");
      out.print( request.getAttribute("requestToken") );
      out.write("\n");
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
}
