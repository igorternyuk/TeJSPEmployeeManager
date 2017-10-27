<%-- 
    Document   : UsersView
    Created on : 27.10.2017, 16:13:30
    Author     : igor
--%>
<%@page import="model.UserDAO"%>
<%@page import="model.dto.UserDTO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User managment page</title>
        <script lang="JavaScript">
            function showMessage(msg){
                alert(msg);
            }
            
            function loadRowData(row){
                var table = document.getElementById("listado"); 
                document.FormUsers.inputID.value = parseInt(table.rows[row].cells[0].innerHTML,10);
                document.FormUsers.inputName.value = table.rows[row].cells[1].innerHTML;
                document.FormUsers.inputEmail.value = table.rows[row].cells[2].innerHTML;
                document.FormUsers.inputPassword.value = table.rows[row].cells[3].innerHTML;
            }            
        </script>
    </head>
    <body>
        <%
            UserDAO dao = new UserDAO();
        %>
        <h1>
            <hr><center>User manager</center>
        </h1>
        <hr><center>
        <form name="FormUsers" method="POST" action="users.do">
            <table border ="1px" style="font-size: 20px">
                <tr>
                    <th>ID:</th> <td><input type="text" name="inputID" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <th>Name:</th> <td><input type="text" name="inputName" style="font-size: 20px" value="" /></td>
                </tr>
                <tr>
                    <th>E-mail:</th> <td><input type="email" name="inputEmail" style="font-size: 20px" value="" required="required"/></td>
                </tr>
                <tr>
                    <th>Password:</th> <td><input type="password" name="inputPassword" style="font-size: 20px" value="" required="required"/></td>
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
                <option>email</option>
            </select>
            Keyword:<input type="text" name="txtRegExp" style="font-size: 20px" value="" />
            <input type="submit" value="Search" name="btnSearch" style="font-size: 20px"/><br><br>
            <br><br>

            <hr><center>
            <h1>List of users</h1>
            <table border ="2px" id = "listado" style="font-size: 20px" >
                <tr>
                <th>ID</th> <th>Name</th> <th>E-mail</th> <th>Password</th>                 
                </tr>                
                <%
                    List<UserDTO> data;
                    if(request.getAttribute("searchResult") != null){
                        data = (List<UserDTO>)request.getAttribute("searchResult");                                
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
                    <td> <%= data.get(row).getEmail()%> </td>
                    <td> <%= data.get(row).getPassword() %> </td>
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
