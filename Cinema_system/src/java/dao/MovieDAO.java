/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author DAO
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.Movie;

public class MovieDAO {
    // Câu lệnh SQL để thêm một bộ phim mới vào cơ sở dữ liệu
    private static final String INSERT_MOVIE_SQL = "INSERT INTO PHIM (maLP, maDP, tenPhim, nhaSX, ngaySX) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_MOVIES = "SELECT * FROM PHIM";
    private static final String SELECT_LOAI_PHIM_SQL = "SELECT LOAIPHIM FROM THELOAIPHIM WHERE MALP = ?";
    private static final String SELECT_DANG_PHIM_SQL = "SELECT DANGPHIM FROM DINHDANGPHIM WHERE MADP = ?";
    private static final String SELECT_MOVIE_BY_ID_SQL = "SELECT * FROM PHIM WHERE MaPhim = ?";
    private static final String UPDATE_MOVIE = "UPDATE PHIM SET TenPhim=?, MALP = ?, MADP =?, NhaSX=?, NgaySX=? WHERE MaPhim=?";
    private static final String DELETE_MOVIE = "DELETE FROM PHIM WHERE MaPhim=?";
    // Phương thức để thêm một bộ phim mới vào cơ sở dữ liệu
    public static boolean addMovie(Movie movie) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE_SQL)) {
            preparedStatement.setString(1, movie.getMaLP());
            preparedStatement.setString(2, movie.getMaDP());
            preparedStatement.setString(3, movie.getTenPhim());
            preparedStatement.setString(4, movie.getNhaSX());
            preparedStatement.setDate(5, movie.getNgaySX());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Phương thức để lấy danh sách tất cả các bộ phim từ cơ sở dữ liệu
    public static List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_MOVIES);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int maPhim = rs.getInt("MAPHIM");
                String maLP = rs.getString("MALP");
                String maDP = rs.getString("MADP");
                String tenPhim = rs.getString("TENPHIM");
                String nhaSX = rs.getString("NHASX");
                Date ngaySX = rs.getDate("NGAYSX");
                
                Movie movie = new Movie(maPhim, maLP, maDP, tenPhim, nhaSX, ngaySX);
                movies.add(movie);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return movies;
    }

    public static String getLoaiPhimByMALP(String maLP) {
        String loaiPhim = "";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOAI_PHIM_SQL)) {
            preparedStatement.setString(1, maLP);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    loaiPhim = resultSet.getString("LOAIPHIM");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiPhim;
    }

    public static String getDangPhimByMADP(String maDP) {
        String dangPhim = "";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DANG_PHIM_SQL)) {
            preparedStatement.setString(1, maDP);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    dangPhim = resultSet.getString("DANGPHIM");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dangPhim;
    }
    
    public static Movie getMovieById(int maPhim) {
        Movie movie = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIE_BY_ID_SQL)) {
            preparedStatement.setInt(1, maPhim);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy thông tin từ ResultSet và tạo đối tượng Movie
                    String maLP = resultSet.getString("MALP");
                    String maDP = resultSet.getString("MADP");
                    String tenPhim = resultSet.getString("TenPhim");
                    String nhaSX = resultSet.getString("NhaSX");
                    Date ngaySX = resultSet.getDate("NgaySX");

                    // Tạo đối tượng Movie từ các thông tin lấy được
                    movie = new Movie(maPhim, maLP, maDP, tenPhim, nhaSX, ngaySX);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }
    public static int updateMovie(Movie movie) {
        int status = 0;
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOVIE)) {
            preparedStatement.setString(1, movie.getTenPhim());
            preparedStatement.setString(2, movie.getMaLP());
            preparedStatement.setString(3, movie.getMaDP());
            preparedStatement.setString(4, movie.getNhaSX());
            preparedStatement.setDate(5, new java.sql.Date(movie.getNgaySX().getTime()));
            preparedStatement.setInt(6, movie.getMaPhim());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static int deleteMovie(String maPhim) {
        int status = 0;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MOVIE)) {
            preparedStatement.setString(1, maPhim);
             status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}

