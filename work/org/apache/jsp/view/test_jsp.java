/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-01-24 16:24:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- <html>\n");
      out.write("<head>\n");
      out.write("\t<link href=\"/BWeb/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"/BWeb/css/social/welcome-page.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<script type=\"text/javascript\" src=\"//assets.pinterest.com/js/pinit.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<a href=\"http://www.pinterest.com/pin/create/button/\n");
      out.write("        ?url=http%3A%2F%2Fwww.flickr.com%2Fphotos%2Fkentbrew%2F6851755809%2F\n");
      out.write("        &media=http%3A%2F%2Ffarm8.staticflickr.com%2F7027%2F6851755809_df5b2051c9_z.jpg\n");
      out.write("        &description=Next%20stop%3A%20Pinterest\"\n");
      out.write("        data-pin-do=\"buttonPin\"\n");
      out.write("        data-pin-config=\"above\">\n");
      out.write("        <img src=\"//assets.pinterest.com/images/pidgets/pin_it_button.png\" />\n");
      out.write("    </a>\n");
      out.write("    \n");
      out.write("    <a \n");
      out.write("    \tdata-pin-do=\"embedBoard\" \n");
      out.write("    \thref=\"http://www.pinterest.com/qingshi10/interesting-stuff/\" \n");
      out.write("    \tdata-pin-scale-width=\"115\" \n");
      out.write("    \tdata-pin-scale-height=\"120\" \n");
      out.write("    \tdata-pin-board-width=\"900\">\n");
      out.write("\t\tFollow Qing Shi's board Interesting stuff on Pinterest.\n");
      out.write("    </a>\n");
      out.write("    \n");
      out.write("    <a \n");
      out.write("    \tdata-pin-do=\"embedUser\" \n");
      out.write("    \thref=\"http://www.pinterest.com/qingshi10/\" \n");
      out.write("    \tdata-pin-scale-width=\"80\" \n");
      out.write("    \tdata-pin-scale-height=\"320\" \n");
      out.write("    \tdata-pin-board-width=\"400\">\n");
      out.write("    \tVisit Qing Shi's profile on Pinterest.\n");
      out.write("    </a>\n");
      out.write("</body>\n");
      out.write("</html> -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <body>\n");
      out.write("    <!-- 1. The <iframe> (and video player) will replace this <div> tag. -->\n");
      out.write("    <div id=\"player\"></div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("      // 2. This code loads the IFrame Player API code asynchronously.\n");
      out.write("      var tag = document.createElement('script');\n");
      out.write("\n");
      out.write("      tag.src = \"https://www.youtube.com/iframe_api\";\n");
      out.write("      var firstScriptTag = document.getElementsByTagName('script')[0];\n");
      out.write("      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);\n");
      out.write("\n");
      out.write("      // 3. This function creates an <iframe> (and YouTube player)\n");
      out.write("      //    after the API code downloads.\n");
      out.write("      var player;\n");
      out.write("      function onYouTubeIframeAPIReady() {\n");
      out.write("        player = new YT.Player('player', {\n");
      out.write("          height: '390',\n");
      out.write("          width: '640',\n");
      out.write("          videoId: 'VMGBZpGTGB0',\n");
      out.write("          events: {\n");
      out.write("            'onReady': onPlayerReady,\n");
      out.write("            'onStateChange': onPlayerStateChange\n");
      out.write("          }\n");
      out.write("        });\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      // 4. The API will call this function when the video player is ready.\n");
      out.write("      function onPlayerReady(event) {\n");
      out.write("        event.target.playVideo();\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      // 5. The API calls this function when the player's state changes.\n");
      out.write("      //    The function indicates that when playing a video (state=1),\n");
      out.write("      //    the player should play for six seconds and then stop.\n");
      out.write("      var done = false;\n");
      out.write("      function onPlayerStateChange(event) {\n");
      out.write("        if (event.data == YT.PlayerState.PLAYING && !done) {\n");
      out.write("          setTimeout(stopVideo, 6000);\n");
      out.write("          done = true;\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("      function stopVideo() {\n");
      out.write("        player.stopVideo();\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
