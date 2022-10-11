/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.excel;

import com.cfscr.dynasoft.entities.DocumentosCRM;

import java.util.List;
import java.util.ArrayList;

import java.text.ParseException;

import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 *
 * @author pablo.elizondo
 */
public class CargarDocCRM {
        
    //CARGAR LISTA DE DOCUMENTOS CRM
    public ArrayList<DocumentosCRM> obtener(List cellDataList) throws ParseException{
        
        ArrayList<DocumentosCRM> documentos = new ArrayList();
        
        for(int i = 1; i < cellDataList.size(); i++){
            List cellTempList = (List) cellDataList.get(i);
            DocumentosCRM documento = new DocumentosCRM();
            
            for(int j = 3; j < cellTempList.size(); j++){
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                switch(j){
                    case 3:
                        documento.setOportunidad(hssfCell.getStringCellValue());
                    break;
                    case 4:                                                      
                        documento.setTema(hssfCell.getStringCellValue());
                    break;
                    case 5:                                                      
                        documento.setUEN(hssfCell.getStringCellValue());
                    break;
                    case 6:                                                      
                        documento.setClientePotencial(hssfCell.getStringCellValue());
                    break;
                    case 7:
                        documento.setIngresosReales((float) hssfCell.getNumericCellValue());
                    break;
                    case 8:
                        documento.setEstProfit((float) hssfCell.getNumericCellValue());
                    break;
                    case 9:
                        documento.setFechaCierre(hssfCell.getDateCellValue());                         
                    break;
                    case 10:                                                                                   
                        documento.setFechaEstimada(hssfCell.getDateCellValue());
                    break;
                    case 11:                                                                          
                        documento.setPropietario(hssfCell.getStringCellValue());
                    break;
                }
            }
            documentos.add(documento);
        }
        return documentos;
    }
}
