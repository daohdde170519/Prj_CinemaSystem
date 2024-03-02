/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.MovieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Movie;

/**
 *
 * @author DAO
 */
@WebServlet(name="EditMovieServlet1", urlPatterns={"/EditMovieServlet1"})
public class EditMovieServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
try (PrintWriter out = response.getWriter()) {
    out.println("<a href='admin.jsp'>admin_dashboard</a>");
    out.println("<h1>Edit Movie</h1>");
     String MaPhimStr = request.getParameter("maPhim");
     int MaPhim = Integer.parseInt(MaPhimStr);
    // Lấy thông tin bộ phim từ request attribute
    Movie movie = MovieDAO.getMovieById(MaPhim);

    out.print("<form action='EditMovieServlet2' method='post'>");
    out.print("<table>");
    out.print("<tr><td></td><td><input type='hidden' name='maPhim' value='" + movie.getMaPhim() + "'/></td></tr>");
    out.print("<tr><td>Ten Phim:</td><td><input type='text' name='tenPhim' value='" + movie.getTenPhim() + "'/></td></tr>");
    out.print("<tr><td>Loai Phim:</td><td><input type='text' name='maLP' value='" + movie.getMaLP() + "'/></td></tr>");
    out.print("<tr><td>Dang Phim:</td><td><input type='text' name='maDP' value='" + movie.getMaDP() + "'/></td></tr>");
    out.print("<tr><td>Nha San Xuat:</td><td><input type='text' name='nhaSX' value='" + movie.getNhaSX() + "'/></td></tr>");
    out.print("<tr><td>Ngay San Xuat:</td><td><input type='text' name='ngaySX' value='" + movie.getNgaySX() + "'/></td></tr>");
    out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
    out.print("</table>");
    out.print("</form>");
}
    }

}
