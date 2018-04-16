package com.mybatis;

import com.ads.entity.Feedback;

import java.sql.*;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/4/16
 */
public class JDBCTest {

    private static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/adsdb";
            String username = "root";
            String password = "936047ZXmn.";
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    
    
    public static void getFeedback(String id){
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        try {
            ps = conn.prepareStatement("select * from feedback where id=?");
            ps.setString(1, "1");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }
    }
    
    
    public static void main(String[] args) {
        getFeedback("1");
    }
    
    private static void close(ResultSet rs, PreparedStatement ps, Connection conn){
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
