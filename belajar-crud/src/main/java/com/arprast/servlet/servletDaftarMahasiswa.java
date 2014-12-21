/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arprast.servlet;

import com.arprast.dao.mhsDao;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arprast
 */
public class servletDaftarMahasiswa extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        try {
            mhsDao mhs = new mhsDao();
            List hasil = mhs.tampilDaftarMhs();  
            req.setAttribute("daftarMhs", hasil);
            req.getRequestDispatcher("/index.jsp").forward(req, res);
        } catch (ServletException ex) {
            System.out.println("1");
            Logger.getLogger(servletDaftarMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            new com.arprast.sistem.loggerError(servletDaftarMahasiswa.class.getName(), ex);
        } catch (IOException ex) {
            System.out.println("2");
            Logger.getLogger(servletDaftarMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            new com.arprast.sistem.loggerError(servletDaftarMahasiswa.class.getName(), ex);
        }
    }
     public void doPost(HttpServletRequest req, HttpServletResponse res){
        
    }
    
}
