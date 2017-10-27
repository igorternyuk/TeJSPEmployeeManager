<%-- 
    Document   : index
    Created on : 24.10.2017, 15:46:22
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start session</title>
    </head>
    <body>
        <center>
            <h1>Start session</h1>
            <form action ="validate.do" method="post">
                <input type="email" name = "inputEmail" placeholder="E-mail" required = "required" style="font-size: 20px"><br><br>
                <input type="password" name = "inputPassword" placeholder="password" required = "required" style="font-size: 20px"><br><br>
                <input type="submit" value = "Start session" style="font-size: 20px"><br><br>
            </form>
        </center>
    </body>
</html>
