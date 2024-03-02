<%-- 
    Document   : listmovie
    Created on : Feb 14, 2024, 6:01:25 PM
    Author     : DAO
--%>

<%@ page import="java.util.List" %>
<%@ page import="model.Movie" %>
<%@ page import="dao.MovieDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Movies</title>
</head>
<body>
    <h2>List of Movies</h2>
    <table border="1">
        <tr>
            <th>Movie ID</th>
            <th>Loai Phim</th>
            <th>Dang Phim</th>
            <th>Ten Phim</th>
            <th>Release Date</th>
            <th>Producer</th>
            <th>Action</th> <!-- New column for actions -->
        </tr>
        <% 
            List<Movie> movieList = MovieDAO.getAllMovies();
            for (Movie movie : movieList) {
        %>
        <tr>
            <td><%= movie.getMaPhim() %></td>
            <td><%= MovieDAO.getLoaiPhimByMALP(movie.getMaLP()) %></td> 
            <td><%= MovieDAO.getDangPhimByMADP(movie.getMaDP()) %></td> 
            <td><%= movie.getTenPhim() %></td>            
            <td><%= movie.getNgaySX() %></td>
            <td><%= movie.getNhaSX() %></td>
            <td>
                <a href="EditMovieServlet1?maPhim=<%= movie.getMaPhim() %>">Edit</a> | 
                <a href="delete_movie.jsp?maPhim=<%= movie.getMaPhim() %>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>


