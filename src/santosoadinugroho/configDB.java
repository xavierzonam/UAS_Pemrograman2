package santosoadinugroho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author niken
 */
public class configDB {
    private static Connection mysqlConfig;
    
    public static Connection configDB() {
    Connection mysqlConfig = null; // Deklarasi dan inisialisasi objek Connection

    try {

       String url = "jdbc:mysql://localhost:3306/pemrograman_2"; // Perbaiki URL dengan menambahkan port (biasanya 3306)
       String user = "root";
       String pass = "";

        // Tidak perlu lagi melakukan DriverManager.registerDriver
        mysqlConfig = DriverManager.getConnection(url, user, pass);
    } catch (SQLException e) {
        e.printStackTrace(); // Tampilkan kesalahan ke konsol
    }

    return mysqlConfig;
}}
