/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.ScheduleMovieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.LichChieu;

/**
 *
 * @author DAO
 */
@WebServlet("/MovieShowServlet")
public class MovieShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<a href='admin.jsp'>admin_dashboard</a>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Movie Shows</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>List of Movie Shows</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>Show ID</th>");
            out.println("<th>Show Date</th>");
            out.println("<th>Show Time</th>"); // Thêm cột giờ chiếu
            out.println("<th>Movie ID</th>");
            out.println("<th>Room ID</th>");
            out.println("</tr>");

            // Gọi phương thức để lấy danh sách các lịch chiếu phim
            List<LichChieu> movieShows = ScheduleMovieDAO.getAllMovieShow();
            for (LichChieu movieShow : movieShows) {
                out.println("<tr>");
                out.println("<td>" + movieShow.getMaXuatChieu() + "</td>");
                out.println("<td>" + movieShow.getNgayChieu() + "</td>");
                out.println("<td>" + movieShow.getGioChieu().toString() + "</td>"); // Hiển thị giờ chiếu
                out.println("<td>" + movieShow.getMaPhim() + "</td>");
                out.println("<td>" + movieShow.getMaPhong() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}


