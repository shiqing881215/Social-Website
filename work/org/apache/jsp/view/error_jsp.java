/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-01-04 01:18:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Error Page</title>\n");
      out.write("\t<link href=\"/BWeb/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"/BWeb/css/social/welcome-page.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"/BWeb/css/error.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template-header.jsp", out, false);
      out.write("\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t    <div class=\"row\">\n");
      out.write("\t        <div class=\"col-md-12\">\n");
      out.write("\t            <div class=\"error-template\">\n");
      out.write("\t            \n");
      out.write("\t            ");

								      List<String> errors = (List<String>)request.getAttribute("errors");
									  if (errors != null && errors.size() != 0) {
								  
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t  <div class=\"alert alert-error\">\n");
      out.write("\t\t\t\t\t\t\t\t  ");
      out.print(errors.get(0) );
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t  </div>\n");
      out.write("\t\t\t\t\t\t\t\t\t  ");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t  ");
 
									  } 
								  
      out.write("\n");
      out.write("\t            \n");
      out.write("\t                <h1>\n");
      out.write("\t                    Oops!</h1>\n");
      out.write("\t                <h2>\n");
      out.write("\t                    404 Not Found</h2>\n");
      out.write("\t                <div class=\"error-details\">\n");
      out.write("\t                    Sorry, an error has occured, Requested page not found!\n");
      out.write("\t                </div>\n");
      out.write("\t                <div class=\"error-actions\">\n");
      out.write("\t                    <a href=\"http://localhost:8080/BWeb/login.do\" class=\"btn btn-primary btn-lg\">\n");
      out.write("\t                        Take Me Home \n");
      out.write("\t                    </a>\n");
      out.write("\t                    <a href=\"http://localhost:8080/BWeb/view/support.jsp\" class=\"btn btn-default btn-lg\"> \n");
      out.write("\t                    \tContact Support \n");
      out.write("\t                    </a>\n");
      out.write("\t                </div>\n");
      out.write("\t            </div>\n");
      out.write("\t        </div>\n");
      out.write("\t    </div>\n");
      out.write("\t</div>\n");
      out.write("\n");
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
