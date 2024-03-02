/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Movie;
import dao.MovieDAO;
import java.io.PrintWriter;

@WebServlet("/ViewMovieServlet")
public class ViewMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<a href='admin.jsp'>admin_dashboard</a>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>List Movies</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>List of Movies</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>Movie ID</th>");
            out.println("<th>Loai Phim</th>");
            out.println("<th>Dang Phim</th>");
            out.println("<th>Ten Phim</th>");
            out.println("<th>Release Date</th>");
            out.println("<th>Producer</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");

            List<Movie> movieList = MovieDAO.getAllMovies();
            for (Movie movie : movieList) {
                out.println("<tr>");
                out.println("<td>" + movie.getMaPhim() + "</td>");
                out.println("<td>" + MovieDAO.getLoaiPhimByMALP(movie.getMaLP()) + "</td>");
                out.println("<td>" + MovieDAO.getDangPhimByMADP(movie.getMaDP()) + "</td>");
                out.println("<td>" + movie.getTenPhim() + "</td>");
                out.println("<td>" + movie.getNgaySX() + "</td>");
                out.println("<td>" + movie.getNhaSX() + "</td>");
                out.println("<td>");
                out.println("<a href='EditMovieServlet1?maPhim=" + movie.getMaPhim() + "'>Edit</a> | ");
                out.println("<a href='DeleteMovieServlet?maPhim=" + movie.getMaPhim() + "'>Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

