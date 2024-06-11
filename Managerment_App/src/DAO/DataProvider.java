/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Duoc Shin
 */
import java.sql.*;

public class DataProvider {

    private static final String CONN_URL = "jdbc:sqlserver://LAPOFIT\\SQLEXPRESS:1433;databaseName=ShopPhone;user=sa;password=123;encrypt=false";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN_URL);
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public static int executeUpdate(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

  
}