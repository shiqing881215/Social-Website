/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-01-27 05:54:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("\t<title>Welcome page</title>\n");
      out.write("\t<script type=\"text/javascript\" src=\"ajax.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"search-suggest.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/tw/twitter.js\"></script>\n");
      out.write("\t<!-- Bootstrap -->\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"css/additional.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"css/social/welcome-page.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template-header.jsp", out, false);
      out.write("\n");
      out.write("\t<div class=\"welcome-title\">\n");
      out.write("\t\t<h2> Hello ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </h2>\n");
      out.write("\t\t<h2> Welcome to Social Website</h2>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"search-container\">\n");
      out.write("\t\t<h4>Search username here</h4>\n");
      out.write("        <div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-body\">                \n");
      out.write("                <input type=\"text\" id=\"username\" name=\"username\" onkeyup=\"searchSuggest(this);\" autocomplete=\"off\"/>\n");
      out.write("\t\t\t\t<div id=\"search_suggest\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"social-btn-container\">\n");
      out.write("\t    <div class=\"row\">\n");
      out.write("\t        <div class=\"col-xs-12 col-sm-12 col-md-6\">\n");
      out.write("\t            <div class=\"panel panel-primary\">\n");
      out.write("\t                <div class=\"panel-body\">\n");
      out.write("\t                    <div class=\"row\">\n");
      out.write("\t                        <div class=\"col-xs-6 col-sm-6 col-md-6 separator social-login-box\"> <br />\n");
      out.write("\t                            <a href=\"fb_CheckLogin.do\" class=\"btn facebook-color btn-primary social-button-size\" role=\"button\">Facebook</a>\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <form action=\"tw_CheckLogin.do\" method=\"POST\">\n");
      out.write("\t                            \t<input class=\"btn btn-info social-button-size\" style=\"width: 225px;\" type=\"submit\" name=\"action\" value=\"Twitter\" />\n");
      out.write("\t                            </form>\n");
      out.write("\t                            <a href=\"linkedin_CheckLogin.do\" class=\"btn instagram-color btn-primary social-button-size\" role=\"button\">LinkedIn</a>\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <!-- <a href=\"view/facebook/FacebookLogin2.jsp\"> facebook </a>  -->\n");
      out.write("\t                            <a href=\"gp_CheckLogin.do\" class=\"btn google-color btn-primary social-button-size\" role=\"button\">Google+</a>\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <a href=\"instagram_CheckLogin.do\" class=\"btn instagram-color btn-primary social-button-size\" role=\"button\">Instagram</a>\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <a href=\"fs_CheckLogin.do\" class=\"btn foursquare-color btn-primary social-button-size\" role=\"button\">FourSquare</a>\n");
      out.write("\t                        \t<br />\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <a href=\"view/youtube/YouTube.jsp\" class=\"btn youtube-color btn-primary social-button-size\" role=\"button\">YouTube</a>\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <br />\n");
      out.write("\t                            <a href=\"tb_CheckLogin.do\" class=\"btn tumblr-color btn-primary social-button-size\" role=\"button\">Tumblr</a>\n");
      out.write("\t                        </div>\n");
      out.write("\t                    </div>\n");
      out.write("\t                </div>\n");
      out.write("\t            </div>\n");
      out.write("\t        </div>\n");
      out.write("\t    </div>\n");
      out.write("\t    <br/>\n");
      out.write("\t    <br/>\n");
      out.write("\t    Click <a href=\"logout.do\">here</a> to logout.\n");
      out.write("    </div>\n");
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
