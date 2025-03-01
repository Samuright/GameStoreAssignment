<%-- 
    Document   : loginPage
    Created on : Feb 22, 2025, 9:33:00 PM
    Author     : Quoc Bao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="loginServlet" method="GET">
            <input type ="text" name ="txtmail" placeholder="Nhap email cua ban" required=""/>
            <input type ="text" name ="txtpassword" placeholder="Nhap password" required=""/>
            <input type="submit" value="Login"/>
        </form>
        <h4>
            <%
                if(request.getAttribute("WARNING") != null){
                    out.print(request.getAttribute("WARNING"));
                }
            %>
        </h4>
    </body>
</html>
