package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.DAOEmployee;
import uml.Employee;
import java.util.List;
import java.util.ArrayList;

public final class EmployeeView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Employee Manager</title>\n");
      out.write("        <script lang=\"JavaScript\">\n");
      out.write("            function load(id, name, surname, age, address, phone, email){\n");
      out.write("                document.FormEmployee.inputID.value = id;\n");
      out.write("                document.FormEmployee.inputName.value = name;\n");
      out.write("                document.FormEmployee.inputSurname.value = surname;\n");
      out.write("                document.FormEmployee.inputAge.value = age;\n");
      out.write("                document.FormEmployee.inputAddress.value = address;\n");
      out.write("                document.FormEmployee.inputPhone.value = phone;\n");
      out.write("                document.FormEmployee.inputEmail.value = email;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            /*function getTableCellValue(tableName, row, col){\n");
      out.write("                var table = document.getElementById(tableName);\n");
      out.write("                table.rows[row].cells[col].innerHTML;\n");
      out.write("            }*/\n");
      out.write("            \n");
      out.write("            /*function GetCellValues() {\n");
      out.write("    var table = document.getElementById('mytable');\n");
      out.write("    for (var r = 0, n = table.rows.length; r < n; r++) {\n");
      out.write("        for (var c = 0, m = table.rows[r].cells.length; c < m; c++) {\n");
      out.write("            alert(table.rows[r].cells[c].innerHTML);\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("}*/\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("        ");

            DAOEmployee dao = new DAOEmployee();
            //List<Employee> data = new ArrayList();
        
      out.write("\n");
      out.write("        <h1>\n");
      out.write("            <hr><center>Employee manager</center>\n");
      out.write("        </h1>\n");
      out.write("        <hr><center>\n");
      out.write("        <form name=\"FormEmployee\" method=\"POST\" action=\"employees\">\n");
      out.write("            <table border =\"1px\" style=\"font-size: 20px\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>ID:</td> <td><input type=\"text\" name=\"inputID\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Name:</td> <td><input type=\"text\" name=\"inputName\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Surname:</td> <td><input type=\"text\" name=\"inputSurname\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Age:</td> <td><input type=\"text\" name=\"inputAge\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Address:</td> <td><input type=\"text\" name=\"inputAddress\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Phone:</td> <td><input type=\"text\" name=\"inputPhone\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>E-mail:</td> <td><input type=\"email\" name=\"inputEmail\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("            </table><br><br>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Insert\" name=\"btnInsert\" style=\"font-size: 20px\"/>\n");
      out.write("            <input type=\"submit\" value=\"Update\" name=\"btnUpdate\" style=\"font-size: 20px\"/>\n");
      out.write("            <input type=\"submit\" value=\"Delete\" name=\"btnDelete\" style=\"font-size: 20px\"/>\n");
      out.write("            <input type=\"submit\" value=\"Load complete list\" name=\"btnReadAll\" style=\"font-size: 20px\"/><br><br>\n");
      out.write("            <hr>\n");
      out.write("            Search by: <select name=\"comboSearch\" style=\"font-size: 20px\" >\n");
      out.write("                <option>id</option>\n");
      out.write("                <option>name</option>\n");
      out.write("                <option>surname</option>\n");
      out.write("                <option>address</option>\n");
      out.write("                <option>email</option>\n");
      out.write("            </select>\n");
      out.write("            Keyword:<input type=\"text\" name=\"txtRegExp\" style=\"font-size: 20px\" value=\"\" />\n");
      out.write("            <input type=\"submit\" value=\"Search\" name=\"btnSearch\" style=\"font-size: 20px\"/><br><br>\n");
      out.write("\n");
      out.write("            <hr><center>\n");
      out.write("            <h1>List</h1>\n");
      out.write("            <table border =\"2px\" style=\"font-size: 20px\">\n");
      out.write("                <tr>\n");
      out.write("                <td>ID</td> <td>Name</td> <td>Surname</td> <td>Age</td> <td>Address</td> <td>Phone</td> <td>E-mail</td>                  \n");
      out.write("                </tr>                \n");
      out.write("                ");

                    List<Employee> data;
                    if(request.getAttribute("searchResult") != null){
                        data = (List<Employee>)request.getAttribute("searchResult");                                
                    }
                    else{
                        data = dao.readAll();
                    }
                    
                    for(Employee e: data){
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print( e.getId() );
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( e.getName() );
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( e.getSurname());
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( e.getAge());
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( e.getAddress());
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( e.getPhone());
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( e.getEmail());
      out.write(" </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }                    
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("            </center>>\n");
      out.write("        </form></center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
