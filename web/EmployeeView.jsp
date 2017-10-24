<%-- 
    Document   : EmployeeView
    Created on : 23.10.2017, 15:24:41
    Author     : igor
--%>
<%@page import= "model.DAOEmployee" %>
<%@page import= "uml.Employee" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Manager</title>
        <script lang="JavaScript">
            function loadRowData(row){
                var table = document.getElementById("listado"); 
                document.FormEmployee.inputID.value = parseInt(table.rows[row].cells[0].innerHTML,10);
                document.FormEmployee.inputName.value = table.rows[row].cells[1].innerHTML;
                document.FormEmployee.inputSurname.value = table.rows[row].cells[2].innerHTML;
                document.FormEmployee.inputAge.value = parseInt(table.rows[row].cells[3].innerHTML,10);
                document.FormEmployee.inputAddress.value = table.rows[row].cells[4].innerHTML;
                document.FormEmployee.inputPhone.value = table.rows[row].cells[5].innerHTML;
                document.FormEmployee.inputEmail.value = table.rows[row].cells[6].innerHTML;
            }            
        </script>
    </head>
    <body>        
        <%
            DAOEmployee dao = new DAOEmployee();
        %>
        <h1>
            <hr><center>Employee manager</center>
        </h1>
        <hr><center>
        <form name="FormEmployee" method="POST" action="employees">
            <table border ="1px" style="font-size: 20px">
                <tr>
                    <td>ID:</td> <td><input type="text" name="inputID" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <td>Name:</td> <td><input type="text" name="inputName" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <td>Surname:</td> <td><input type="text" name="inputSurname" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <td>Age:</td> <td><input type="text" name="inputAge" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <td>Address:</td> <td><input type="text" name="inputAddress" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <td>Phone:</td> <td><input type="text" name="inputPhone" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <td>E-mail:</td> <td><input type="email" name="inputEmail" style="font-size: 20px" value="" /></td>
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
            Min age:<input type="number" name="txtMinAge" style="font-size: 20px" value="" />
            Max age:<input type="number" name="txtMaxAge" style="font-size: 20px" value="" />
            <br><br>

            <hr><center>
            <h1>List</h1>
            <table border ="2px" id = "listado" style="font-size: 20px" >
                <tr>
                <td>ID</td> <td>Name</td> <td>Surname</td> <td>Age</td> <td>Address</td> <td>Phone</td> <td>E-mail</td> <td>Action</td>                  
                </tr>                
                <%
                    List<Employee> data;
                    if(request.getAttribute("searchResult") != null){
                        data = (List<Employee>)request.getAttribute("searchResult");                                
                    }
                    else{
                        data = dao.readAll();
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
                    <td> <input type="button" value = "Load" onclick= "loadRowData('<%= row+1 %>');" style="font-size: 20px" /> </td>
                </tr>
                <%
                    }                    
                %>
            </table>
            </center>
        </form></center>
    </body>
</html>
