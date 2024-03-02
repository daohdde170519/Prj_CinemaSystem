/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.PhongChieuDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PhongChieu;

/**
 *
 * @author DAO
 */
@WebServlet(name="RoomManagementServlet", urlPatterns={"/RoomManagementServlet"})
public class RoomManagementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Lấy thông tin được gửi từ form
        String tenPhong = request.getParameter("tenPhong");
        String soGheStr = request.getParameter("soGhe");
        int soGhe = Integer.parseInt(soGheStr); // Chuyển đổi chuỗi thành số nguyên

        // Tạo một đối tượng Room và thiết lập thông tin mới
        PhongChieu room = new PhongChieu();
        room.setTenPhong(tenPhong);
        room.setSoGhe(soGhe);

        // Gọi phương thức insertRoom trong RoomDAO để lưu thông tin phòng vào cơ sở dữ liệu
        int status = PhongChieuDAO.insertRoom(room);

        if (status > 0) {
            // Nếu lưu thành công, hiển thị thông báo thành công
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Room added successfully');");
            out.println("location='admin.jsp';"); // Chuyển hướng về trang admin
            out.println("</script>");
        } else {
            // Nếu không thành công, hiển thị thông báo lỗi
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Failed to add room');");
            out.println("location='admin.jsp';"); // Chuyển hướng về trang admin
            out.println("</script>");
        }

        out.close();
    }
}
