<%-- 
    Document   : EmployeeView
    Created on : 23.10.2017, 15:24:41
    Author     : igor
--%>
<%@page import="model.EmployeeDAO"%>
<%@page import="model.dto.EmployeeDTO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Manager</title>
        <script lang="JavaScript">
            function showMessage(msg){
                alert(msg);
            }
            
            function loadRowData(row){
                var table = document.getElementById("listado"); 
                document.FormEmployee.inputID.value = parseInt(table.rows[row].cells[0].innerHTML,10);
                document.FormEmployee.inputName.value = table.rows[row].cells[1].innerHTML;
                document.FormEmployee.inputSurname.value = table.rows[row].cells[2].innerHTML;
                document.FormEmployee.inputAge.value = parseInt(table.rows[row].cells[3].innerHTML,10);
                document.FormEmployee.inputAddress.value = table.rows[row].cells[4].innerHTML;
                document.FormEmployee.inputPhone.value = table.rows[row].cells[5].innerHTML;
                document.FormEmployee.inputEmail.value = table.rows[row].cells[6].innerHTML;
                document.FormEmployee.inputSalary.value = parseFloat(table.rows[row].cells[7].innerHTML);
            }            
        </script>
    </head>
    <body>        
        <%
            EmployeeDAO dao = new EmployeeDAO();
        %>
        <h1>
            <hr><center>Employee manager</center>
        </h1>
        <hr><center>
        <form name="FormEmployee" method="POST" action="employees.do">
            <table border ="1px" style="font-size: 20px">
                <tr>
                    <th>ID:</th> <td><input type="text" name="inputID" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <th>Name:</th> <td><input type="text" name="inputName" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <th>Surname:</th> <td><input type="text" name="inputSurname" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <th>Age:</th> <td><input type="text" name="inputAge" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <th>Address:</th> <td><input type="text" name="inputAddress" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <th>Phone:</th> <td><input type="text" name="inputPhone" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <th>E-mail:</th> <td><input type="email" name="inputEmail" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <th>Salary:</th> <td><input type="number" min = 3200 max = 3000000 name="inputSalary" style="font-size: 20px" value="" /></td>
                </tr>
            </table><br><br>

            <input type="submit" value="Insert" name="btnInsert" style="font-size: 20px"/>
            <input type="submit" value="Update" name="btnUpdate" style="font-size: 20px"/>
            <input type="submit" value="Delete" name="btnDelete" style="font-size: 20px"/>
            <input type="submit" value="Load complete list" name="btnReadAll" style="font-size: 20px"/><br><br>
            <hr>
            Search by: <select name="comboSearch" style="font-size: 20px" >
                <option>id</option>
                <option>name</option>
                <option>surname</option>
                <option>address</option>
                <option>email</option>
            </select>
            Keyword:<input type="text" name="txtRegExp" style="font-size: 20px" value="" />
            <input type="submit" value="Search" name="btnSearch" style="font-size: 20px"/><br><br>
            Consider age:<input type="checkbox" name="checkBoxAge" value="ON" />
            Min age:<input type="number" name="txtMinAge" min ="18" max="75" style="font-size: 20px" value="18" />
            Max age:<input type="number" name="txtMaxAge" min ="18" max="75" style="font-size: 20px" value="18" />
            <br><br>

            <hr><center>
            <h1>List of employees</h1>
            <table border ="2px" id = "listado" style="font-size: 20px" >
                <tr>
                <th>ID</th> <th>Name</th> <th>Surname</th> <th>Age</th> <th>Address</th> <th>Phone</th> <th>E-mail</th> <th>Salary</th> <th>Action</th>                 
                </tr>                
                <%
                    List<EmployeeDTO> data;
                    if(request.getAttribute("searchResult") != null){
                        data = (List<EmployeeDTO>)request.getAttribute("searchResult");                                
                    }
                    else{
                        data = dao.readAll();
                    }
                    
                    if(request.getAttribute("result") != null){
                        String result = (String)request.getAttribute("result");
                    %>
                    <script lang="JavaScript">
                        showMessage('<%= result %>');
                    </script>                            
                  <%  
                   } 
                    
                    for(int row = 0; row < data.size(); ++row){
                %>
                <tr>
                    <td> <%= data.get(row).getId() %> </td>
                    <td> <%= data.get(row).getName() %> </td>
                    <td> <%= data.get(row).getSurname()%> </td>
                    <td> <%= data.get(row).getAge()%> </td>
                    <td> <%= data.get(row).getAddress()%> </td>
                    <td> <%= data.get(row).getPhone()%> </td>
                    <td> <%= data.get(row).getEmail()%> </td>
                    <td> <%= data.get(row).getSalary() %> </td>
                    <td> <input type="button" value = "Load" onclick= "loadRowData('<%= row+1 %>');" style="font-size: 20px" /> </td>
                </tr>
                <%
                    }                    
                %>
            </table>
            </center>
        </form>
        <a href="menu.view" style="font-size: 20px">Back to menu</a>
        </center>
    </body>
</html>
