/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-01-17 02:37:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class support_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Support Page</title>\n");
      out.write("\t<link href=\"/BWeb/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"/BWeb/css/social/welcome-page.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"/BWeb/css/error.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"/BWeb/css/support.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template-header.jsp", out, false);
      out.write("\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<h1 class=\"header\">Contact Me</h1>\n");
      out.write("\t\t<div class=\"photo-container\">\n");
      out.write("        \t<img src=\"/BWeb/img/support-page/shiqing_photo.jpg\" alt=\"shiqing\" class=\"photo\"/>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"info-container\">\n");
      out.write("\t\t\t<h3>Qing Shi</h3>\n");
      out.write("\t\t\t<a href=\"https://www.google.com/maps/preview#!q=1+Market+Street%2C+San+Francisco\" target=\"blank\">\n");
      out.write("\t\t\t\t<small><cite title=\"San Francisco, USA\">San Francisco, USA </cite></small>\n");
      out.write("\t\t\t</a>\n");
      out.write("            <p>\n");
      out.write("            \t<!-- TODO  Use ROT13 to wrap email -->\n");
      out.write("                <a href=\"mailto:shiqing881215@gmail.com\">Email Me</a> \n");
      out.write("                <br />\n");
      out.write("                <a href=\"\">www.shiqing.com</a>\n");
      out.write("                <br />\n");
      out.write("                Working in <a href=\"http://www.salesforce.com\">Salesforce.com</a>\n");
      out.write("            </p>\n");
      out.write("            <div>\n");
      out.write("            \t<a href=\"https://twitter.com/sesedeqing\">\n");
      out.write("         \t    \t<img alt=\"Twitter\" src=\"/BWeb/img/support-page/twitter_32.png\" title=\"Twitter\">\n");
      out.write("            \t</a>\n");
      out.write("            \t<a href=\"https://www.facebook.com/qing.shi.10\">\n");
      out.write("            \t\t<img alt=\"facebook\" src=\"/BWeb/img/support-page/facebook_32.png\" title=\"Facebook\">\n");
      out.write("            \t</a>\n");
      out.write("            \t<a href=\"http://www.linkedin.com/profile/view?id=171658522\">\n");
      out.write("            \t\t<img alt=\"linkedin\" src=\"/BWeb/img/support-page/linkedin_32.png\" title=\"LinkedIn\">\n");
      out.write("            \t</a>\n");
      out.write("            \t<a href=\"https://plus.google.com/116216522361915002333\">\n");
      out.write("            \t\t<img alt=\"twitter\" src=\"/BWeb/img/support-page/google_32.png\" title=\"Google+\">\n");
      out.write("            \t</a>\n");
      out.write("            \t<a href=\"https://github.com/shiqing881215\">\n");
      out.write("            \t\t<img alt=\"twitter\" src=\"/BWeb/img/support-page/github_32.png\" title=\"Github\">\n");
      out.write("            \t</a>\n");
      out.write("            </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div> \n");
      out.write("\t\n");
      out.write("</body>\n");
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
