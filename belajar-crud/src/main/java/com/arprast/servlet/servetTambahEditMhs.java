/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arprast.servlet;
import com.arprast.dao.mhsDao;
import com.arprast.domain.mhsDomain;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;


/**
 *
 * @author arprast
 */
public class servetTambahEditMhs extends HttpServlet { 
    String statusDoGet = null;
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        try {
            mhsDomain domain = new mhsDomain();
            
            String edit = req.getParameter("edit");
            if (edit != null && edit.trim().length() > 0 ) {
                mhsDao dao = new mhsDao();
                domain = dao.getEditDataMhs(edit);
                
                /*
                jika statusDoGet != null maka bisa edit untuk di save
                ini akan berpengaruh pada doPost
                */
                this.statusDoGet = edit;
                
                req.setAttribute("mhs", domain);
                req.getRequestDispatcher("/formInputData.jsp").forward(req, res);
            } 
            else{
                req.setAttribute("mhs", null);
                req.getRequestDispatcher("/formInputData.jsp").forward(req, res);
            }
            
            
        } catch (ServletException ex) {
            Logger.getLogger(servetTambahEditMhs.class.getName()).log(Level.SEVERE, null, ex);
            new com.arprast.sistem.loggerError(servetTambahEditMhs.class.getName(), ex);
        } catch (IOException ex) {
            Logger.getLogger(servetTambahEditMhs.class.getName()).log(Level.SEVERE, null, ex);
            new com.arprast.sistem.loggerError(servetTambahEditMhs.class.getName(), ex);
        } catch (Exception ex) {
            Logger.getLogger(servetTambahEditMhs.class.getName()).log(Level.SEVERE, null, ex);
            new com.arprast.sistem.loggerError(servetTambahEditMhs.class.getName(), ex);
        }
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        try {
            mhsDomain mhsDomain = new mhsDomain();
            mhsDomain.setNpm(req.getParameter("npm"));
            mhsDomain.setNama(req.getParameter("nama"));
            
            //doGet(req,res);
            
            mhsDao Save = new mhsDao();

            Save.Simpan(mhsDomain, statusDoGet);
            
            res.sendRedirect("daftarMhs.ari");
        } catch (IOException ex) {
            Logger.getLogger(servetTambahEditMhs.class.getName()).log(Level.SEVERE, null, ex);
            new com.arprast.sistem.loggerError(servetTambahEditMhs.class.getName(), ex);
        }
    }
}
