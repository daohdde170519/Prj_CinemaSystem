/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.PhongChieuDAO;
import java.io.IOException;
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
@WebServlet(name="EditRoomServlet1", urlPatterns={"/EditRoomServlet1"})
public class EditRoomServlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maPhongStr = request.getParameter("maPhong");
        int maPhong = Integer.parseInt(maPhongStr);
        String tenPhong = request.getParameter("tenPhong");
        int soGhe = Integer.parseInt(request.getParameter("soGhe"));

        PhongChieu room = new PhongChieu(maPhong, tenPhong, soGhe);
        PhongChieuDAO.updateRoom(room);

        response.sendRedirect("ViewRoomServlet");
    }

}
