/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arprast.sistem;

import java.io.File;

/**
 *
 * @author arprast
 */
public class createFolder {
   public boolean buatFolder(String nameFolder){
       File file = new File("Directory");
        if (!file.exists()) {
                if (file.mkdir()) {
                        //System.out.println("Directory is created!");
                        return true;
                } else {
                        System.out.println("Failed to create directory! : "+ createFolder.class.getName());
                        return false;
                }
        }
        return false;
   }
   public boolean buatFolderS(){
        File files = new File("C:\\Directory2\\Sub2\\Sub-Sub2");
        if (files.exists()) {
                if (files.mkdirs()) {
                        //System.out.println("Multiple directories are created!");
                        return true;
                } else {
                        System.out.println("Failed to create multiple directories!");
                    return false;
                }
        }
        return false;
   }
}
