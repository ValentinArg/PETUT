/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.67
 * Generated at: 2016-10-24 20:39:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.eleve;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class forum_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel =\"stylesheet\" href = \"/PETUT/css/main.css\"/>\r\n");
      out.write("<link rel =\"stylesheet\" href = \"/PETUT/css/allSemestres.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.jeasyui.com/easyui/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.jeasyui.com/easyui/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.6.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://www.jeasyui.com/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"position: fixed;width:100%;z-index:10;\">\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/enTete.jsp", out, false);
      out.write("\r\n");
      out.write("\t<div class=\"navigation\" id=\"navigation\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li class=\"semestre\">\r\n");
      out.write("\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- <input type=\"radio\" name=\"semestre\" value=\"0\">S1</>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"semestre\" value=\"1\">S2</>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"semestre\" value=\"0\">S3</>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"semestre\" value=\"1\">S4</>-->\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"parent\" id=\"parent1\"><p class=\"ue\" id=\"ue1\">UE 1</p>\r\n");
      out.write("\t\t\t\t<div class=\"rubrique\" id=\"module1\">\r\n");
      out.write("\t\t\t\t\t<ul >\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\" id=\"1101\" >M1101</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\" id=\"1102\">M1102</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1103</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1104</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1105</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1106</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1107</p></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li class=\"parent\" id=\"parent2\"><p class=\"ue\" id=\"ue2\">UE 2</p>\r\n");
      out.write("\t\t\t\t<div class=\"rubrique\" id=\"module2\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1201</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1202</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1203</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1204</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1205</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1206</p></li>\r\n");
      out.write("\t\t\t\t\t\t<li><p class=\"module\">M1207</p></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"arborescence\" style=\"display:inline-block;\">\r\n");
      out.write("\t\t<!-- <ul>\r\n");
      out.write("\t\t\t<li class=\"dossier\" onclick='slideDossier(this,\"dossier\")'> TP1: Machine virtuelle linux\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li class=\"sousDossier\"> Comment on fait ?</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"dossier\"> TP2: serveur virtuelle\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li class=\"sousDossier\"> Ca marche pas</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>-->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"conteneurGeneral\" id=\"conteneurGeneral\">\r\n");
      out.write("\t\t<div class=\"tableauTopic\">\r\n");
      out.write("\t\t\t<div style=\"position:relative;display:inline-block\">\r\n");
      out.write("\t\t\t\t<table id=\"listeSujet\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>Question</td>\r\n");
      out.write("\t\t\t\t\t\t<td>Auteur</td>\r\n");
      out.write("\t\t\t\t\t\t<td>Date de publication</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar haut = false\r\n");
      out.write("\t\tfunction slideUp(){\r\n");
      out.write("\t\t\tif(!haut){\r\n");
      out.write("\t\t\t\t$('#navigation').slideUp()\r\n");
      out.write("\t\t\t\tif($('#navigation').is(':animated')){\r\n");
      out.write("\t\t\t\t\tcheckAnimate();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\thaut = true;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tdocument.getElementById('conteneurGeneral').style.marginLeft=\"20%\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('conteneurGeneral').style.width=\"80%\";\r\n");
      out.write("\t\t\t\t$('#navigation').slideDown();\r\n");
      out.write("\t\t\t\thaut = false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\tfunction checkAnimate() {\r\n");
      out.write("            if( $( '#navigation' ).is( ':animated' )) {\r\n");
      out.write("                setTimeout(function() {\r\n");
      out.write("                    checkAnimate();\r\n");
      out.write("                }, 0 );\r\n");
      out.write("            }else{\r\n");
      out.write("            \tif(haut){\r\n");
      out.write("            \t\tdocument.getElementById('conteneurGeneral').style.marginLeft=\"0%\";\r\n");
      out.write("            \t\tdocument.getElementById('conteneurGeneral').style.width=\"100%\";\r\n");
      out.write("            \t}\t\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#module2\").slideUp();\r\n");
      out.write("\t\t$(\"#module1\").slideUp();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar hautModule1 = true;\r\n");
      out.write("\t\tfunction sildeModule1(){\r\n");
      out.write("\t\t\tif(!hautModule2){\r\n");
      out.write("\t\t\t\t$(\"#module2\").slideUp();\r\n");
      out.write("\t\t\t\thautModule2=true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(hautModule1){\r\n");
      out.write("\t\t\t\t$(\"#module1\").slideDown();\r\n");
      out.write("\t\t\t\thautModule1=false;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$(\"#module1\").slideUp();\r\n");
      out.write("\t\t\t\thautModule1=true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar hautModule2 = true;\r\n");
      out.write("\t\tfunction sildeModule2(){\r\n");
      out.write("\t\t\tif(!hautModule1){\r\n");
      out.write("\t\t\t\t$(\"#module1\").slideUp();\r\n");
      out.write("\t\t\t\thautModule1=true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(hautModule2){\r\n");
      out.write("\t\t\t\t$(\"#module2\").slideDown();\r\n");
      out.write("\t\t\t\thautModule2=false;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$(\"#module2\").slideUp();\r\n");
      out.write("\t\t\t\thautModule2=true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction slideDosier(nom,numero,nombrePere){\r\n");
      out.write("\t\t\tfor(var i = 1; i<nombrePere+1;i++){\r\n");
      out.write("\t\t\t\t$(nom+i).slideUp();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(!$(nom+numero).is(\":visible\"))\r\n");
      out.write("\t\t\t\t$(nom+numero).slideDown();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$( '#boutonHautBas' ).click(function(){\r\n");
      out.write("\t\t\tslideUp()});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$( '#parent1' ).click(function(){\r\n");
      out.write("\t\t\tsildeModule1()});\r\n");
      out.write("\t\t$( '#parent2' ).click(function(){\r\n");
      out.write("\t\t\tsildeModule2()});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar idModule = null;\r\n");
      out.write("\t\t$( '.module' ).click(function(){\r\n");
      out.write("\t\t\tidModule = this.getAttribute('id');\r\n");
      out.write("\t\t\tslideUp();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//function ajax pour afficher les sujets d'une matière donnée et d'un forum donnée\r\n");
      out.write("\t\t$( '.forum' ).click(function(){\r\n");
      out.write("\t\t\tif(idModule != null){\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl : '/PETUT/eleves/forum',\r\n");
      out.write("\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\tdata : 'idModule=' + idModule + '&idForum='+this.getAttribute('id'),\r\n");
      out.write("\t\t\t\t\tsuccess : function(valeur){\r\n");
      out.write("\t\t\t\t\t\t$('.sujet').remove();\r\n");
      out.write("\t\t\t\t\t\tvar listeSujets = JSON.parse(valeur);\r\n");
      out.write("\t\t\t\t\t\t//identifiant = identifiant du sujet se trouvant dans la listeSujets.id\r\n");
      out.write("\t\t\t\t\t\tvar tr = $('<tr class=\"sujet\" id=\"\"/>');\r\n");
      out.write("\t\t\t\t\t\t$(tr).appendTo($(\"#listeSujet\"));\r\n");
      out.write("\t\t\t\t\t\tvar tdQuestion = $('<td/>');\r\n");
      out.write("\t\t\t\t\t\tvar tdAuteur = $('<td/>');\r\n");
      out.write("\t\t\t\t\t\tvar tdDate = $('<td/>');\r\n");
      out.write("\t\t\t\t\t\ttdQuestion.text(\"quel est le resultat de la requete\");\r\n");
      out.write("\t\t\t\t\t\ttdAuteur.text(\"Bremec Florian\");\r\n");
      out.write("\t\t\t\t\t\ttdDate.text(\"14/05/2016\");\r\n");
      out.write("\t\t\t\t\t\t$(tdQuestion).appendTo(tr);\r\n");
      out.write("\t\t\t\t\t\t$(tdAuteur).appendTo(tr);\r\n");
      out.write("\t\t\t\t\t\t$(tdDate).appendTo(tr);\r\n");
      out.write("\t\t\t\t    },\r\n");
      out.write("\t\t\t\t\tdataType : 'text'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$( '.sousDossier').slideUp();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction slideDossier(dossierClicker,nom){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(nom).slideUp();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tif(!$(dossierClicker).is(\":visible\"))\r\n");
      out.write("\t\t\t\t$(dossierClicker).slideDown();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
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
    // /WEB-INF/jsp/eleve/forum.jsp(24,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("semestre");
    // /WEB-INF/jsp/eleve/forum.jsp(24,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/eleve/forum.jsp(24,5) '${listeSemestre}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${listeSemestre}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"semestre\">");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</>\r\n");
          out.write("\t\t\t\t\t");
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

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsp/eleve/forum.jsp(25,42) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("S${semestre.numero}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
