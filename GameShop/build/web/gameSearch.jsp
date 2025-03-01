<%-- 
    Document   : gameSearch
    Created on : Feb 24, 2025, 11:40:15 AM
    Author     : THINH
--%>

<%@page import="java.util.List"%>
<%@page import="model.GamesDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body>
        <h1>Game List</h1>
        <%@include file = "homePage.jsp"%>
        <form action='search' method='GET'>
            <input name =keyword type='text' value='<%=request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>'>
            <input type ='submit' value='Search'>     
        </form>
            <table>
                <tr>
                    <td>Id</td>
                    <td><a href="?colSort=title">Game Title</a></td>
                    <td><a href="?colSort=publisher">Publisher</a></td>
                    <td>price</td>
                </tr>
                
                <% List<GamesDTO> list =(List<GamesDTO>) request.getAttribute("GamesList");
                for(GamesDTO game : list){
                    %>
                 <tr><td> <%=game.getId() %> </td>
                <td><%=game.getTitle() %></td>
                <td><%=game.getPublisher() %></td>
                <td><%=game.getPrice() %></td></tr>
                <% }%>                  
            </table>
    </body>
</html>
