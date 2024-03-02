/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Movie;
import dao.MovieDAO;

@WebServlet(name="AddMovieServlet", urlPatterns={"/AddMovieServlet"})
public class AddMovieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ request
        String maLP = request.getParameter("maLP");
        String maDP = request.getParameter("maDP");
        String tenPhim = request.getParameter("tenPhim");
        String nhaSX = request.getParameter("nhaSX");
        Date ngaySX = null;
        
        // Chuyển đổi ngày thành định dạng Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date parsedDate = sdf.parse(request.getParameter("ngaySX"));
            ngaySX = new Date(parsedDate.getTime()); // Chuyển đổi thành java.sql.Date
        } catch (ParseException ex) {
            Logger.getLogger(AddMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Tạo đối tượng Movie
        Movie movie = new Movie(maLP, maDP, tenPhim, nhaSX, ngaySX);
        
        // Gọi phương thức thêm phim từ lớp DAO
        boolean success = MovieDAO.addMovie(movie);
        
        // Kiểm tra kết quả thêm phim
        if (success) {
            // Nếu thêm phim thành công, chuyển hướng người dùng đến trang admin.jsp
            response.sendRedirect("admin.jsp");
        } else {
            // Nếu thêm phim không thành công, hiển thị thông báo lỗi
            response.getWriter().println("Failed to add movie.");
        }
    }
}
