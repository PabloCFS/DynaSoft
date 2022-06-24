/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.excel;

import com.cfscr.dynasoft.entities.DocumentoElectronico;
import com.cfscr.dynasoft.entities.Usuario;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author pablo.elizondo
 */
public class ManipulacionExcel {
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet("Hoja 1");
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
    
    /*CARGAR DOCUMENTOS ELECTRONICOS*/
    public void cargarRegistros(ArrayList<DocumentoElectronico> documentos) {
        Row row = sheet.createRow(0);
        
        row.createCell(0).setCellValue("Cliente"); row.createCell(1).setCellValue("Nombre"); row.createCell(2).setCellValue("Tipo");
        row.createCell(3).setCellValue("Documento"); row.createCell(4).setCellValue("Fecha"); row.createCell(5).setCellValue("Modulo"); 
        row.createCell(6).setCellValue("NIT Receptor"); row.createCell(7).setCellValue("Contiene Error"); row.createCell(8).setCellValue("Error Receptor");
        row.createCell(9).setCellValue("Error Softland"); row.createCell(10).setCellValue("Enviado"); row.createCell(11).setCellValue("Codigo Moneda");
        row.createCell(12).setCellValue("Total Gravado"); row.createCell(13).setCellValue("Total Exento"); row.createCell(14).setCellValue("Total Venta"); 
        row.createCell(15).setCellValue("Total Descuentos"); row.createCell(16).setCellValue("Total Venta Neta"); row.createCell(17).setCellValue("Total Impuesto");
        row.createCell(18).setCellValue("Total Comprobante");row.createCell(19).setCellValue("CRM");
    
        for (int i=0; i<documentos.size(); i++){
            row = sheet.createRow(i+1);
            
            row.createCell(0).setCellValue(documentos.get(i).getCliente());
            row.createCell(1).setCellValue(documentos.get(i).getNombre());
            row.createCell(2).setCellValue(documentos.get(i).getTipo());
            row.createCell(3).setCellValue(documentos.get(i).getDocumento());
            row.createCell(4).setCellValue(castearDate(documentos.get(i).getCreateDate()));
            row.createCell(5).setCellValue(documentos.get(i).getTipoAsiento());
            row.createCell(6).setCellValue(documentos.get(i).getNitReceptor());
            row.createCell(7).setCellValue(castearChar(documentos.get(i).getContieneErrores()));
            row.createCell(8).setCellValue(castearChar(documentos.get(i).getErrorWS()));
            row.createCell(9).setCellValue(castearChar(documentos.get(i).getErrorSoftland()));
            row.createCell(10).setCellValue(castearChar(documentos.get(i).getEnviado()));
            row.createCell(11).setCellValue(documentos.get(i).getMoneda());
            row.createCell(12).setCellValue(documentos.get(i).getTotalGravado());
            row.createCell(13).setCellValue(documentos.get(i).getTotalExento());
            row.createCell(14).setCellValue(documentos.get(i).getTotalVenta());
            row.createCell(15).setCellValue(documentos.get(i).getTotalDescuentos());
            row.createCell(16).setCellValue(documentos.get(i).getTotalVentaNeta());
            row.createCell(17).setCellValue(documentos.get(i).getTotalImpuesto());
            row.createCell(18).setCellValue(documentos.get(i).getTotalComprobante());
            if(equals(documentos.get(i).getTipo().equals("N/C"))){
                row.createCell(19).setCellValue("N/A");
            }
            else if (!documentos.get(i).getTipo().equals("N/C")){
                row.createCell(19).setCellValue(documentos.get(i).getCrm());
            }
        }
    }
    
    private String castearDate(Date fecha){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(fecha);
    }
    
    private String castearChar(char dato){
        String retorno = String.valueOf(dato);
        
        if(retorno.equals("X")){
            retorno = "NULL";
        }
        return retorno;
    }
}
