/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import model.Users;
/**
 *
 * @author DAO
 */
public class UserDAO {
    private static final String LOGIN_QUERY = "SELECT user_id, role_id FROM Users WHERE username = ? AND password = ?";
    
    public Users checkLogin(String username, String password){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Users user = null;
        
        try(Connection con = DBConnection.getConnection()){
            if(con != null){
                pstmt = con.prepareStatement(LOGIN_QUERY);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                rs = pstmt.executeQuery();
                
                if(rs.next()){
                    user = new Users();
                    user.setUserId(rs.getInt("user_id"));
                    user.setRoleId(rs.getInt("role_id"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return user;
    }
}

//    public static void main(String[] args) {
//        UserDAO us = new UserDAO();
//        if(us.checkLogin("dao", "hadanhdao")){
//            System.out.println("Login success");
//        }
//    }

