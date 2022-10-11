/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.excel;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pablo.elizondo
 */
public class LecturaExcel {
    
    //LECTURA DE EXCEL DE ENTRADA
    public List leerExcel(File fileName){
        List cellData = new ArrayList<>();
        
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            
            XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
            XSSFSheet hssfSheet = workBook.getSheetAt(0);
            
            Iterator rowIterator = hssfSheet.rowIterator();
            
            while(rowIterator.hasNext()){
                
                XSSFRow hasfRow = (XSSFRow) rowIterator.next();
                
                Iterator iterator = hasfRow.cellIterator();
                List cellTemp = new ArrayList();
                
                while(iterator.hasNext()){
                    XSSFCell hssfCell = (XSSFCell) iterator.next();
                    
                    cellTemp.add(hssfCell);
                }
                cellData.add(cellTemp);
            }
        } catch(IOException e){
            System.out.println("Error -> " + e);
        }
        return cellData;
    }
}