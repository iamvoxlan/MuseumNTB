/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author voXlan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KonfigDB {
    public static Connection koneksi;
    
    public static Connection configDBConnection() throws SQLException{
        try {
            String url = "jdbc:mysql://localhost:3306/daftarkunjunganmuseum";
            String user = "root";
            String pass = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Koneksi Error");
        }
        return koneksi;
    }
}
