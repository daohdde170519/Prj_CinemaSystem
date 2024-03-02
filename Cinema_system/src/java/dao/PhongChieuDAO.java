/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PhongChieu;

/**
 *
 * @author DAO
 */
public class PhongChieuDAO {
        private static final String INSERT_ROOM_SQL = "INSERT INTO PHONGCHIEU (TENPHONG, SOGHE) VALUES (?, ?)";
            private static final String SELECT_ALL_ROOM_SQL = "SELECT * FROM PHONGCHIEU";
            // Phương thức để thêm phòng vào cơ sở dữ liệu
    public static int insertRoom(PhongChieu room) {
        int rowsInserted = 0;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL)) {
            preparedStatement.setString(1, room.getTenPhong());
            preparedStatement.setInt(2, room.getSoGhe());

            // Thực thi truy vấn INSERT và nhận số hàng được chèn
            rowsInserted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }
        public static List<PhongChieu> getAllRoom() {
        List<PhongChieu> roomList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOM_SQL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int maPhong = resultSet.getInt("MAPHONG");
                    String tenPhong = resultSet.getString("TENPHONG");
                    int soGhe = resultSet.getInt("SOGHE");
                    PhongChieu room = new PhongChieu(maPhong, tenPhong, soGhe);
                    roomList.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomList;
    }
    public static PhongChieu selectRoomById(int maPhong) {
        PhongChieu room = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM PhongChieu WHERE MAPHONG = ?")) {
            statement.setInt(1, maPhong);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String tenPhong = rs.getString("TENPHONG");
                    int soGhe = rs.getInt("SOGHE");
                    room = new PhongChieu(maPhong, tenPhong, soGhe);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return room;
    }
        // Update room
    public static int updateRoom(PhongChieu room) {
        int status=0;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement("UPDATE PhongChieu SET TENPHONG = ?, SOGHE = ? WHERE MAPHONG = ?")) {
            statement.setString(1, room.getTenPhong());
            statement.setInt(2, room.getSoGhe());
            statement.setInt(3, room.getMaPhong());
            status = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // Delete room
    public static int deleteRoom(String maPhong) {
        int status=0;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement("DELETE FROM PhongChieu WHERE MAPHONG = ?")) {
            statement.setString(1, maPhong);
            status = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
