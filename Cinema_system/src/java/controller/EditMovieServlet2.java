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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Movie;

/**
 *
 * @author DAO
 */
@WebServlet(name="EditMovieServlet2", urlPatterns={"/EditMovieServlet2"})
public class EditMovieServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Lấy các thông tin được gửi từ form
        String maPhimStr = request.getParameter("maPhim");
        int maPhim = Integer.parseInt(maPhimStr);
        String tenPhim = request.getParameter("tenPhim");
        String maLP = request.getParameter("maLP");
        String maDP = request.getParameter("maDP");
        String nhaSX = request.getParameter("nhaSX");
        String ngaySXStr = request.getParameter("ngaySX");
        
        // Chuyển đổi chuỗi ngày sang kiểu java.sql.Date
        java.sql.Date ngaySX = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date parsedDate = dateFormat.parse(ngaySXStr);
            ngaySX = new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            out.println("Invalid date format");
            return; 
        }

        // Tạo một đối tượng Movie và thiết lập thông tin mới
        Movie movie = new Movie();
        movie.setMaPhim(maPhim);
        movie.setTenPhim(tenPhim);
        movie.setMaLP(maLP);
        movie.setMaDP(maDP);
        movie.setNhaSX(nhaSX);
        movie.setNgaySX(ngaySX);

        // Gọi phương thức update trong MovieDAO để cập nhật thông tin
        int status = MovieDAO.updateMovie(movie);

        if (status > 0) {
            // Nếu cập nhật thành công, chuyển hướng đến trang hiển thị danh sách phim
            response.sendRedirect("ViewMovieServlet");
        } else {
            // Nếu không thành công, hiển thị thông báo lỗi
            out.println("Sorry! Unable to update record");
        }

        out.close();
    }
}


