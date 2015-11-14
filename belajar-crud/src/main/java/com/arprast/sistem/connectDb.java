/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arprast.sistem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arprast
 */
public class connectDb {
    public Connection koneksi;
    public void connectDbMysql(){
        try {
            String namaClassDriver  = "com.mysql.jdbc.Driver";
            String jdbcUrl = "jdbc:mysql://localhost/belajar";
            String username = "root";
            String password = "isi_sendiri";
            
            Class.forName(namaClassDriver).newInstance();
            koneksi = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connectDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(connectDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(connectDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(connectDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void disconnectDbMysql(){
        try {
            koneksi.close();
        } catch (SQLException ex) {
            Logger.getLogger(connectDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void hapusDbMysql(String tabelDb, String setKey){
        try {
            String sql = "delete from ? where id = ?";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, tabelDb);
            ps.setString(2, setKey);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(connectDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    
}
