<%-- 
    Document   : admin
    Created on : Feb 14, 2024, 5:00:06 PM
    Author     : DAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="model.Users" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
        <c:if test="${sessionScope.user == null}">
        <c:redirect url="login.jsp"/>
    </c:if>
    <a href="LogoutServlet">Logout</a>
    <div id="navbar">
        <ul>
            <li><a href="addmovie.jsp">Thêm phim</a></li>
            <li><a href="ViewMovieServlet">Danh sách phim</a></li>
            <li><a href="ScheduleMovieServlet">Lịch Chiếu</a></li>
            <li><a href="MovieShowServlet">List Lịch Chiếu</a></li>
            <li><a href="addroom.jsp">Quản lí Phòng Chiếu</a></li>
            <li><a href="ViewRoomServlet">List Phòng Chiếu</a></li>
        </ul>
    </div>   
</body>
</html>
