/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DAO
 */
public class DBConnection {
    public static String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLRAPCHIEUPHIM1";
    public static String userDB ="sa";
    public static String passDB ="201003";
    
    public static Connection getConnection(){
       Connection con = null;
       try{
           Class.forName(drivername);
           con = DriverManager.getConnection(dbURL, userDB, passDB);
           return con;
       } catch(Exception ex){
           Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
    
//public static void main(String[] args) {
//    try {
//        Connection con = DBConnection.getConnection();
//        if (con != null) {
//            System.out.println("Success");
//            // Perform database operations here, if needed
//        } else {
//            System.err.println("Failed to connect to the database.");
//        }
//    } catch (Exception ex) {
//        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//    }
//  }
}

