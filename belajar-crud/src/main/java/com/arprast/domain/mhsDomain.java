/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arprast.domain;

/**
 *
 * @author arprast
 */
public class mhsDomain {
    String nama;
    String npm;
    
    public String getNpm(){
        return npm;
    }
    public void setNpm(String data){
        this.npm = data;
    }
    
    public String getNama(){
        return nama;
    }
    public void setNama(String data){
        this.nama = data;  
    }
}
