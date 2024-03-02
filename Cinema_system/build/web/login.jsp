<%-- 
    Document   : login
    Created on : Jan 6, 2024, 12:56:01 PM
    Author     : DAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
	<table>
		<tr>
		   <td>User name:</td><td><input type="text" name="user"/></td>
		</tr>
		<tr>
		   <td>Password:</td><td><input type="password" name="pass"/></td>
		</tr>
		<tr>
		   <td></td><td><input type="submit" value="Login"/></td>
		</tr>
	</table>
     </form>
    <% if (request.getAttribute("ERROR") != null) { %>
        <div style="color: red;">
            <%= request.getAttribute("ERROR") %>
        </div>
    <% } %>
    </body>
</html>
