/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DAO
 */

import dao.MovieDAO;

@WebServlet(name = "DeleteMovieServlet", urlPatterns = {"/DeleteMovieServlet"})
public class DeleteMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy mã phim từ request parameter
        String maPhim = request.getParameter("maPhim");

        // Gọi phương thức xóa phim trong MovieDAO
        int status = MovieDAO.deleteMovie(maPhim);

        if (status > 0) {
            // Nếu xóa thành công, chuyển hướng đến trang hiển thị danh sách phim
            response.sendRedirect("ViewMovieServlet");
        } else {
            // Nếu không thành công, hiển thị thông báo lỗi
            response.getWriter().println("Sorry! Unable to delete record");
        }
    }
}
