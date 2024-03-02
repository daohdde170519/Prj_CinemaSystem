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
@WebServlet("/EditRoomServlet")
public class EditRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String maPhongStr = request.getParameter("maPhong");
            int maPhong = Integer.parseInt(maPhongStr);
            PhongChieu room = PhongChieuDAO.selectRoomById(maPhong);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Edit Room</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Edit Room</h2>");
            out.println("<form action='EditRoomServlet1' method='post'>");
            out.println("<table>");
            out.println("<tr><td>Room ID:</td><td><input type='text' name='maPhong' value='" + room.getMaPhong() + "' readonly></td></tr>");
            out.println("<tr><td>Room Name:</td><td><input type='text' name='tenPhong' value='" + room.getTenPhong() + "'></td></tr>");
            out.println("<tr><td>Number of Seats:</td><td><input type='text' name='soGhe' value='" + room.getSoGhe() + "'></td></tr>");
            out.println("<tr><td colspan='2'><input type='submit' value='Save Changes'></td></tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
