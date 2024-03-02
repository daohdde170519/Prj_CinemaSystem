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
import java.util.List;
import model.PhongChieu;

/**
 *
 * @author DAO
 */
@WebServlet("/ViewRoomServlet")
public class ViewRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<a href='admin.jsp'>admin_dashboard</a>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>List of Rooms</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>List of Rooms</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>Room ID</th>");
            out.println("<th>Room Name</th>");
            out.println("<th>Number of Seats</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");

            List<PhongChieu> roomList = PhongChieuDAO.getAllRoom();
            for (PhongChieu room : roomList) {
                out.println("<tr>");
                out.println("<td>" + room.getMaPhong() + "</td>");
                out.println("<td>" + room.getTenPhong() + "</td>");
                out.println("<td>" + room.getSoGhe() + "</td>");
                out.println("<td>");
                out.println("<a href='EditRoomServlet?maPhong=" + room.getMaPhong() + "'>Edit</a> | ");
                out.println("<a href='DeleteRoomServlet?maPhong=" + room.getMaPhong() + "'>Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
