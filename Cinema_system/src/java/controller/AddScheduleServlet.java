/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.ScheduleMovieDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalTime;
import model.LichChieu;

/**
 *
 * @author DAO
 */
@WebServlet("/AddScheduleServlet")
public class AddScheduleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String ngayChieuStr = request.getParameter("ngayChieu");
        String gioChieuStr = request.getParameter("gioChieu"); // Lấy giá trị của giờ chiếu từ request
        String maPhimStr = request.getParameter("maPhim");
        String maPhongStr = request.getParameter("maPhong");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayChieu = null;

        try {
            java.util.Date parsedDate = dateFormat.parse(ngayChieuStr);
            ngayChieu = new Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int maPhim = Integer.parseInt(maPhimStr);
        int maPhong = Integer.parseInt(maPhongStr);

        // Parse giờ chiếu từ chuỗi sang đối tượng LocalTime
        LocalTime gioChieu = LocalTime.parse(gioChieuStr);

        LichChieu lichChieu = new LichChieu();
        lichChieu.setNgayChieu(ngayChieu);
        lichChieu.setGioChieu(gioChieu); // Thiết lập giờ chiếu

        lichChieu.setMaPhim(maPhim);
        lichChieu.setMaPhong(maPhong);

        int status = ScheduleMovieDAO.addSchedule(lichChieu);

        if (status > 0) {
            response.sendRedirect("admin.jsp");
        } else {
            response.getWriter().println("Failed to add movie.");
        }
    }
}
