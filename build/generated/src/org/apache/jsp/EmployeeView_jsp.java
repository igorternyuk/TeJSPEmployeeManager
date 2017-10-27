package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.EmployeeDAO;
import model.dto.EmployeeDTO;
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
      out.write("            function showMessage(msg){\n");
      out.write("                alert(msg);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function loadRowData(row){\n");
      out.write("                var table = document.getElementById(\"listado\"); \n");
      out.write("                document.FormEmployee.inputID.value = parseInt(table.rows[row].cells[0].innerHTML,10);\n");
      out.write("                document.FormEmployee.inputName.value = table.rows[row].cells[1].innerHTML;\n");
      out.write("                document.FormEmployee.inputSurname.value = table.rows[row].cells[2].innerHTML;\n");
      out.write("                document.FormEmployee.inputAge.value = parseInt(table.rows[row].cells[3].innerHTML,10);\n");
      out.write("                document.FormEmployee.inputAddress.value = table.rows[row].cells[4].innerHTML;\n");
      out.write("                document.FormEmployee.inputPhone.value = table.rows[row].cells[5].innerHTML;\n");
      out.write("                document.FormEmployee.inputEmail.value = table.rows[row].cells[6].innerHTML;\n");
      out.write("                document.FormEmployee.inputSalary.value = parseFloat(table.rows[row].cells[7].innerHTML);\n");
      out.write("            }            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("        ");

            EmployeeDAO dao = new EmployeeDAO();
        
      out.write("\n");
      out.write("        <h1>\n");
      out.write("            <hr><center>Employee manager</center>\n");
      out.write("        </h1>\n");
      out.write("        <hr><center>\n");
      out.write("        <form name=\"FormEmployee\" method=\"POST\" action=\"employees.do\">\n");
      out.write("            <table border =\"1px\" style=\"font-size: 20px\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID:</th> <td><input type=\"text\" name=\"inputID\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Name:</th> <td><input type=\"text\" name=\"inputName\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Surname:</th> <td><input type=\"text\" name=\"inputSurname\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Age:</th> <td><input type=\"text\" name=\"inputAge\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Address:</th> <td><input type=\"text\" name=\"inputAddress\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Salary:</th> <td><input type=\"text\" name=\"inputPhone\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>E-mail:</th> <td><input type=\"email\" name=\"inputEmail\" style=\"font-size: 20px\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Salary:</th> <td><input type=\"number\" min = 3200 max = 3000000 name=\"inputSalary\" style=\"font-size: 20px\" value=\"\" /></td>\n");
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
      out.write("            Consider age:<input type=\"checkbox\" name=\"checkBoxAge\" value=\"ON\" />\n");
      out.write("            Min age:<input type=\"number\" name=\"txtMinAge\" min =\"18\" max=\"75\" style=\"font-size: 20px\" value=\"18\" />\n");
      out.write("            Max age:<input type=\"number\" name=\"txtMaxAge\" min =\"18\" max=\"75\" style=\"font-size: 20px\" value=\"18\" />\n");
      out.write("            <br><br>\n");
      out.write("\n");
      out.write("            <hr><center>\n");
      out.write("            <h1>List</h1>\n");
      out.write("            <table border =\"2px\" id = \"listado\" style=\"font-size: 20px\" >\n");
      out.write("                <tr>\n");
      out.write("                <td>ID</td> <td>Name</td> <td>Surname</td> <td>Age</td> <td>Address</td> <td>Phone</td> <td>E-mail</td> <td>Action</td>                  \n");
      out.write("                </tr>                \n");
      out.write("                ");

                    List<EmployeeDTO> data;
                    if(request.getAttribute("searchResult") != null){
                        data = (List<EmployeeDTO>)request.getAttribute("searchResult");                                
                    }
                    else{
                        data = dao.readAll();
                    }
                    
                    if(request.getAttribute("result") != null){
                        String result = (String)request.getAttribute("result");
                    
      out.write("\n");
      out.write("                    <script lang=\"JavaScript\">\n");
      out.write("                        showMessage('");
      out.print( result );
      out.write("');\n");
      out.write("                    </script>                            \n");
      out.write("                  ");
  
                   }
                    
                    for(int row = 0; row < data.size(); ++row){
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print( data.get(row).getId() );
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( data.get(row).getName() );
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( data.get(row).getSurname());
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( data.get(row).getAge());
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( data.get(row).getAddress());
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( data.get(row).getPhone());
      out.write(" </td>\n");
      out.write("                    <td> ");
      out.print( data.get(row).getEmail());
      out.write(" </td>\n");
      out.write("                    <td> <input type=\"button\" value = \"Load\" onclick= \"loadRowData('");
      out.print( row+1 );
      out.write("');\" style=\"font-size: 20px\" /> </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }                    
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("            </center>\n");
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
