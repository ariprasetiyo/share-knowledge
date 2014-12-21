/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arprast.dao;

import com.arprast.domain.mhsDomain;
import com.arprast.sistem.connectDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arprast
 */

public class mhsDao {
    
    /*
    jika npm        != null => dari proses edit
                     = null => dari proses bukan edit
    */
    public List tampilDaftarMhs(){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            
            sql = "select * from mhs order by npm";
            ps = dbMysql.koneksi.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            List hasil = new ArrayList();
            while(rs.next()){
                mhsDomain p = konversiResultSetKeMhs(rs);
                hasil.add(p);
            }
            dbMysql.disconnectDbMysql();
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(mhsDao.class.getName()).log(Level.SEVERE, null, ex);
            new com.arprast.sistem.loggerError(mhsDao.class.getName(), ex);
        }
        return null;
    }
    
    public mhsDomain getEditDataMhs(String npm) throws Exception {
        connectDb dbMysql = new connectDb();
        dbMysql.connectDbMysql();
        String sql = "select  * from mhs where npm =? order by npm";
        
        PreparedStatement ps = dbMysql.koneksi.prepareStatement(sql);
        ps.setString(1, npm);
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()){
            return null;
        }
        mhsDomain p = konversiResultSetKeMhs(rs);
        dbMysql.disconnectDbMysql();
        return p;
        
    }
    
    private mhsDomain konversiResultSetKeMhs(ResultSet rs) throws SQLException {
        mhsDomain p = new mhsDomain();
        p.setNpm(rs.getString("npm"));
        p.setNama(rs.getString("nama"));
        
        System.out.println(rs.getString("npm") + " " + rs.getString("nama") );
        return p;
    }
    
    /*
    editYesOrNo = true  => dari edit
    editYesOrNo = false => bukan dari edit
    */
    public void Simpan(mhsDomain m, String editYesOrNo){
        try {
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            
            String query;
            
            if (editYesOrNo == null ){
                query = "insert into mhs values (?,?)";
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                ps.setString(1, m.getNpm());
                ps.setString(2, m.getNama());
                ps.executeUpdate();
            }
            else {
                query = "update mhs set npm=?, nama=? where npm=?";
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                ps.setString(1, m.getNpm());
                ps.setString(2, m.getNama());
                ps.setString(3, editYesOrNo);
                ps.executeUpdate();
            }

            dbMysql.disconnectDbMysql();
        } catch (SQLException ex) {
            Logger.getLogger(mhsDao.class.getName()).log(Level.SEVERE, null, ex);
            new com.arprast.sistem.loggerError(mhsDao.class.getName(), ex);
        }
    }
    
}
