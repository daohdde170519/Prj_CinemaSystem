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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import model.Movie;
import model.PhongChieu;

/**
 *
 * @author DAO
 */

public class ScheduleMovieDAO {
public static int addSchedule(LichChieu lichChieu) {
    int status = 0; // Default status: 0 (failed)
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("INSERT INTO LichChieu (NGAYCHIEU, MAPHIM, MAPHONG, GIOCHIEU, STATUS) VALUES (?, ?, ?, ?, ?)")) {
        // Thiết lập các tham số cho câu lệnh SQL
        ps.setDate(1, new java.sql.Date(lichChieu.getNgayChieu().getTime()));
        ps.setInt(2, lichChieu.getMaPhim());
        ps.setInt(3, lichChieu.getMaPhong());
        LocalTime gioChieuLocalTime = lichChieu.getGioChieu();
        java.sql.Time gioChieuTime = java.sql.Time.valueOf(gioChieuLocalTime);
        ps.setTime(4, gioChieuTime);
        
        // Xác định trạng thái là active hoặc expired
        LocalDate currentDate = LocalDate.now();
        LocalDate showDate = lichChieu.getNgayChieu().toLocalDate();
        LocalTime currentTime = LocalTime.now();
        String statusStr;
        if (currentDate.isBefore(showDate) || (currentDate.isEqual(showDate) && currentTime.isBefore(gioChieuLocalTime))) {
            statusStr = "active";
        } else {
            statusStr = "expired";
        }
        ps.setString(5, statusStr);
        
        // Thực thi câu lệnh SQL
        status = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return status;
}

    public static List<LichChieu> getAllMovieShow() {
        List<LichChieu> movieShows = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM LICHCHIEU");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int maXuatChieu = rs.getInt("MAXUATCHIEU");
                Date ngayChieu = rs.getDate("NGAYCHIEU");
                Time gioChieuSQL = rs.getTime("GIOCHIEU");
                LocalTime gioChieu = gioChieuSQL.toLocalTime();
                int maPhim = rs.getInt("MAPHIM");
                int maPhong = rs.getInt("MAPHONG");
                // Xác định trạng thái là active hoặc expired
                LocalDate currentDate = LocalDate.now();
                LocalDate showDate = ngayChieu.toLocalDate();
                LocalTime currentTime = LocalTime.now();
                String status;
                if (currentDate.isBefore(showDate) || (currentDate.isEqual(showDate) && currentTime.isBefore(gioChieu))) {
                    status = "active";
                } else {
                    status = "expired";
                }
                // Tạo đối tượng LichChieu từ kết quả truy vấn và trạng thái xác định
                LichChieu movieSchedule = new LichChieu(maXuatChieu, ngayChieu, gioChieu, maPhim, maPhong, status);
                movieShows.add(movieSchedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieShows;
    }

    public static String getTenPhimByMaPhim(int maPhim) {
        String tenPhim = "";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT TenPhim FROM Phim WHERE MaPhim = ?");
        ) {
            ps.setInt(1, maPhim);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tenPhim = rs.getString("TenPhim");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenPhim;
    }

    public static String getTenPhongByMaPhong(int maPhong) {
        String tenPhong = "";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT TENPHONG FROM PhongChieu WHERE MAPHONG = ?");
        ) {
            ps.setInt(1, maPhong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tenPhong = rs.getString("TenPhong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenPhong;
    }
    public static LichChieu getMovieShowById(int maXuatChieu) {
        LichChieu lichChieu = null;
        String sql = "SELECT * FROM LichChieu WHERE maXuatChieu=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maXuatChieu);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    lichChieu = new LichChieu();
                    lichChieu.setMaXuatChieu(resultSet.getInt("maXuatChieu"));
                    lichChieu.setNgayChieu(resultSet.getDate("ngayChieu"));
                    lichChieu.setGioChieu(resultSet.getTime("gioChieu").toLocalTime());
                    lichChieu.setMaPhim(resultSet.getInt("maPhim"));
                    lichChieu.setMaPhong(resultSet.getInt("maPhong"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lichChieu;
    }

    public static List<PhongChieu> getAllPhongChieu() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PhongChieu> phongChieuList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM PhongChieu";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PhongChieu phongChieu = new PhongChieu();
                phongChieu.setMaPhong(resultSet.getInt("maPhong"));
                phongChieu.setTenPhong(resultSet.getString("tenPhong"));
                phongChieu.setSoGhe(resultSet.getInt("soGhe"));

                phongChieuList.add(phongChieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return phongChieuList;
    }

    public static List<Movie> getAllMovie() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Movie> movieList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Phim";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setMaPhim(resultSet.getInt("maPhim"));
                movie.setTenPhim(resultSet.getString("tenPhim"));
                movie.setMaLP(resultSet.getString("maLP"));
                movie.setMaDP(resultSet.getString("maDP"));
                movie.setNhaSX(resultSet.getString("nhaSX"));
                movie.setNgaySX(resultSet.getDate("ngaySX"));

                movieList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return movieList;
    }
public static boolean updateMovieShow(LichChieu movieShow) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        connection = DBConnection.getConnection();

        String sql = "UPDATE LichChieu SET ngayChieu=?, gioChieu=?, maPhim=?, maPhong=?, status=? WHERE maXuatChieu=?";
        preparedStatement = connection.prepareStatement(sql);

        // Chuyển đổi từ java.util.Date thành java.sql.Date
        preparedStatement.setDate(1, new java.sql.Date(movieShow.getNgayChieu().getTime()));
        preparedStatement.setTime(2, java.sql.Time.valueOf(movieShow.getGioChieu()));
        preparedStatement.setInt(3, movieShow.getMaPhim());
        preparedStatement.setInt(4, movieShow.getMaPhong());

        // Xác định trạng thái là active hoặc expired
        LocalDate currentDate = LocalDate.now();
        LocalDate showDate = movieShow.getNgayChieu().toLocalDate();
        LocalTime currentTime = LocalTime.now();
        String statusStr;
        if (currentDate.isBefore(showDate) || (currentDate.isEqual(showDate) && currentTime.isBefore(movieShow.getGioChieu()))) {
            statusStr = "active";
        } else {
            statusStr = "expired";
        }
        preparedStatement.setString(5, statusStr);
        
        preparedStatement.setInt(6, movieShow.getMaXuatChieu());

        int rowsUpdated = preparedStatement.executeUpdate();

        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return false;
}


private static String getStatus(LichChieu movieShow) {
    LocalDate currentDate = LocalDate.now();
    LocalDate showDate = movieShow.getNgayChieu().toLocalDate();
    LocalTime currentTime = LocalTime.now();
    String statusStr;
    if (currentDate.isBefore(showDate) || (currentDate.isEqual(showDate) && currentTime.isBefore(movieShow.getGioChieu()))) {
        statusStr = "active";
    } else {
        statusStr = "expired";
    }
    return statusStr;
}


    public static void deleteMovieShow(int maXuatChieu) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM LichChieu WHERE maXuatChieu = ?")) {
            preparedStatement.setInt(1, maXuatChieu);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
        public static List<Movie> getMoviesByActiveStatus() {
        List<Movie> activeMovies = new ArrayList<>();
        String status = "active"; // Trạng thái "active"
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT MAPHIM FROM LICHCHIEU WHERE status = ?")) {
            ps.setString(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                 Movie movie = MovieDAO.getMovieById(rs.getInt("MAPHIM"));
                 activeMovies.add(movie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return activeMovies;
    }
}

