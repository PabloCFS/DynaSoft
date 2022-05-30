/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cfscr.dynasoft.entities.Usuario;
import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class ManipulacionExcel {
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet("Mi hoja 1");
    FileOutputStream fileout;
    
    
    public void crearExcel(){
        try {
            fileout = new FileOutputStream("Reporte.xlsx");
            book.write(fileout);
            fileout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipulacionExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManipulacionExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarExcel(ArrayList<Usuario> usuarios){
        Row row = sheet.createRow(0);
        
        row.createCell(0).setCellValue("Nombre");
        row.createCell(1).setCellValue("Clave");
        
        for(int i=0; i<usuarios.size(); i++){
            row = sheet.createRow(i+1);
            String nombre = usuarios.get(i).getNombre();
            String clave = usuarios.get(i).getClave();
            
            row.createCell(0).setCellValue(nombre);
            row.createCell(1).setCellValue(clave);
        }
    }
}
