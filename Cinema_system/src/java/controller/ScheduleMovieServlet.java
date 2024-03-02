/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.MovieDAO;
import dao.PhongChieuDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Movie;
import model.PhongChieu;

/**
 *
 * @author DAO
 */
@WebServlet(name="ScheduleMovieServlet", urlPatterns={"/ScheduleMovieServlet"})
public class ScheduleMovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<a href='admin.jsp'>admin_dashboard</a>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Thêm Lịch Chiếu</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Thêm Lịch Chiếu</h2>");

            // Form để nhập thông tin lịch chiếu
            out.println("<form action='AddScheduleServlet' method='post'>");
            out.println("Ngày chiếu: <input type='date' name='ngayChieu'><br>");
            out.println("Giờ chiếu: <input type='time' name='gioChieu'><br>");
            out.println("Phòng chiếu:");
            out.println("<select name='maPhong'>");
            List<PhongChieu> rooms = PhongChieuDAO.getAllRoom();
            for (PhongChieu room : rooms) {
                out.println("<option value='" + room.getMaPhong() + "'>" + room.getTenPhong() + "</option>");
            }
            out.println("</select><br>");
            out.println("Phim:");
            out.println("<select name='maPhim'>");
            List<Movie> movies = MovieDAO.getAllMovies();
            for (Movie movie : movies) {
                out.println("<option value='" + movie.getMaPhim() + "'>" + movie.getTenPhim() + "</option>");
            }
            out.println("</select><br>");
            out.println("<input type='submit' value='Thêm Lịch Chiếu'>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

}
