<%-- 
    Document   : addmovie
    Created on : Feb 14, 2024, 5:34:34 PM
    Author     : DAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Movie</title>
</head>
<body>
    <a href='admin.jsp'>admin_dashboard</a>
    <h2>Add Movie</h2>
    <form action="AddMovieServlet" method="post">  
        <label for="maLP">Mã Loại Phim:</label>
        <input type="text" id="maLP" name="maLP"><br><br>
        
        <label for="maDP">Mã Định Dạng Phim:</label>
        <input type="text" id="maDP" name="maDP"><br><br>
        
        <label for="tenPhim">Tên Phim:</label>
        <input type="text" id="tenPhim" name="tenPhim"><br><br>
        
        <label for="nhaSX">Nhà Sản Xuất:</label>
        <input type="text" id="nhaSX" name="nhaSX"><br><br>
        
        <label for="ngaySX">Ngày Sản Xuất:</label>
        <input type="date" id="ngaySX" name="ngaySX"><br><br>
        
        <input type="submit" value="Add Movie">
    </form>
</body>
</html>

