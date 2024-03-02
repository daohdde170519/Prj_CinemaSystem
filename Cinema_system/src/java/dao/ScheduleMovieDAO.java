/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.LichChieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author DAO
 */

public class ScheduleMovieDAO {
public static int addSchedule(LichChieu lichChieu) {
    int status = 0; // Default status: 0 (failed)
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("INSERT INTO LichChieu (NGAYCHIEU, MAPHIM, MAPHONG, GIOCHIEU) VALUES (?, ?, ?, ?)")) {
        ps.setDate(1, new java.sql.Date(lichChieu.getNgayChieu().getTime()));
        ps.setInt(2, lichChieu.getMaPhim());
        ps.setInt(3, lichChieu.getMaPhong());
        LocalTime gioChieuLocalTime = lichChieu.getGioChieu();
        java.sql.Time gioChieuTime = java.sql.Time.valueOf(gioChieuLocalTime);
        ps.setTime(4, gioChieuTime);
        status = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return status;
}
public static List<LichChieu> getAllMovieShow() {
    List<LichChieu> movieShows = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM LichChieu");
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            int maXuatChieu = rs.getInt("MAXUATCHIEU");
            Date ngayChieu = rs.getDate("NGAYCHIEU");
            Time gioChieuSQL = rs.getTime("GIOCHIEU");
            LocalTime gioChieu = gioChieuSQL.toLocalTime(); // Chuyển đổi từ java.sql.Time sang LocalTime
            int maPhim = rs.getInt("MAPHIM");
            int maPhong = rs.getInt("MAPHONG");
            // Tạo đối tượng LichChieu từ kết quả truy vấn
            LichChieu movieShow = new LichChieu(maXuatChieu, ngayChieu, gioChieu, maPhim, maPhong);
            movieShows.add(movieShow);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return movieShows;
}

}