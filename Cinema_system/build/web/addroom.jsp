<%-- 
    Document   : addroom
    Created on : Feb 15, 2024, 2:30:07 PM
    Author     : DAO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Room</title>
</head>
<body>
    <h2>Add New Room</h2>
    <form action="RoomManagementServlet" method="post">
        <table>
            <tr>
                <td>Room Name:</td>
                <td><input type="text" name="tenPhong"></td>
            </tr>
            <tr>
                <td>Number of Seats:</td>
                <td><input type="text" name="soGhe"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add Room"></td>
            </tr>
        </table>
    </form>
</body>
</html>

