/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GroupProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connections {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";
    private static final String CON_URL = "jdbc:postgresql://localhost:5432/Test";
    private static final String DRIVER = "org.postgresql.Driver";

    public Connections() {
    }

    public Connection getCon() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
            System.out.println("Connected to database");
        } catch (SQLException ex) {
            System.out.println("Failed to connect to database: " + ex.getMessage());
            throw ex;
        }
        return con;
    }

    public void addRegister(String id, String n, String s, int age, String p, String pass, String email) {
        try (Connection conn = getCon();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO RegisterUsers (id, name, surname, age, phone, password, email) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            pstmt.setString(1, id);
            pstmt.setString(2, n);
            pstmt.setString(3, s);
            pstmt.setInt(4, age);
            pstmt.setString(5, p);
            pstmt.setString(6, pass);
            pstmt.setString(7, email);

            pstmt.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Could not add");
        }
    }
    
    
    public void addLogin(String id, String n, String s, int age, String p, String pass, String email) {
        try (Connection conn = getCon();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO LoginUsers (id, name, surname, age, phone, password, email) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            pstmt.setString(1, id);
            pstmt.setString(2, n);
            pstmt.setString(3, s);
            pstmt.setInt(4, age);
            pstmt.setString(5, p);
            pstmt.setString(6, pass);
            pstmt.setString(7, email);

            pstmt.executeUpdate();
          
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Could not add");
        }
    }
    
    
}


