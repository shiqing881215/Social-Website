/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-01-25 06:29:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<script src=\"http://www.yvoschaap.com/ytpage/ytembed.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<div id=\"ytThumbs\"></div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tytEmbed.init({'block':'ytThumbs','q':'kobe','type':'search','results':5,'order':'most_relevance','player':'embed','layout':'full'});\n");
      out.write("</script> \n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- <html>\n");
      out.write("<head>\n");
      out.write("<title>Untitled Document</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("function go_get(){\n");
      out.write(" var base_url = 'http://www.youtube.com/embed?listType=search&list=' ;\n");
      out.write(" var search_field = document.getElementById('yourtextfield').text ;\n");
      out.write(" var target_url = base_url + search_field ;\n");
      out.write(" var ifr = document.getElementById('youriframe') ;\n");
      out.write(" ifr.src = target_url ;\n");
      out.write(" return false ;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</script> \n");
      out.write("\n");
      out.write("<form onsubmit=\"go_get(); return false;\" >\n");
      out.write(" <input type=\"text\"  id=\"yourtextfield\"/>\n");
      out.write(" <input type=\"submit\" value=\"Search Playlists\" />\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<iframe id=\"youriframe\" width=\"640\" height=\"360\" ></iframe>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html> -->");
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