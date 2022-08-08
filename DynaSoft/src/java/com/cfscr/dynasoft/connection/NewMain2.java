/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

import com.cfscr.dynasoft.entities.DocumentoElectronico;
import com.cfscr.dynasoft.entities.Usuario;

import com.cfscr.dynasoft.services.ServiceDocElectronicoImpl;
import java.io.File;
import java.io.FileInputStream;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pablo.elizondo
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    
    public NewMain2(File fileName){
        List cellData = new ArrayList();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
            
            XSSFSheet hssfSheet = workBook.getSheetAt(0);
            //RowIterator es un iterator una coleccion de filas o hileras
            Iterator rowIterator = hssfSheet.rowIterator();
            
            //Nos movemos por los registros o sea la cantidad de filas
            //hasNext Devuelve verdadero si la iteracion tiene mas elementos
            while(rowIterator.hasNext()){
                /*La representacion de alto nivel de una fila de una hoja de calculo.
                Obtenemos los datos de las celdas de la fila 0*/
                XSSFRow hasfRow = (XSSFRow) rowIterator.next();
                //Almacenamos los datos en el Iterator
                Iterator iterator = hasfRow.cellIterator();
                List cellTemp = new ArrayList();
                //Nos movemos por los datos de cada fila o sea los datos de las celdas
                while(iterator.hasNext()){
                    //Almacenamos los datos de cada celda en el hssfCell
                    XSSFCell hssfCell = (XSSFCell) iterator.next();
                    //Y los datos almacenados en el hssfCell los almacenamoms en el cellTempo
                    cellTemp.add(hssfCell);
                }
                //Y los datos almacenamos en el cellTemp los almacenamos en el cellData
                cellData.add(cellTemp);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        //Colocamos el metodo obtener y le pasamos como parametro el objeto cellData
        obtener(cellData);
    }
    
    private void obtener(List cellDataList){
        for(int i=0; i<cellDataList.size(); i++){
            //Obtenemos los datos cellDataList y los almacenamos cellTempList
            List cellTempList = (List) cellDataList.get(i);
            for(int j = 0; j < cellTempList.size(); j++){
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                //Convertimos los datos a String
                String stringCellValue = hssfCell.toString();
                System.out.print(stringCellValue + "|||");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        
        
        
        /*LECTURA DE EXCEL*/
        //File f = new File("C:/Users/Pablo.Elizondo/Documents/Desarrollos/1-ERP-CRM/Proyecto/DynaSoft/ReporteDynamics.xlsx");
        // C:/1 - Reporte final - Analisis de costos (Historial).xlsx
        // C:/Users/Pablo.Elizondo/Documents/Desarrollos/1-ERP-CRM/Proyecto/DynaSoft/ReporteDynamics.xlsx
        
        /*if(f.exists()){
            NewMain2 obj = new NewMain2(f);
        }*/
        
        System.out.println("----------------------------");
        
        /*GESTION DE USUARIOS*/
        /*
        DAOusuario us = new DAOusuario();
        ArrayList<Usuario> usuarios = us.ListarUsuarios();
        
        for(int i=0; i<usuarios.size(); i++){
            System.out.println("Nombre -> " + usuarios.get(i).getNombre());
            System.out.println("Clave -> " + usuarios.get(i).getClave());
        }
        */
        
        System.out.println("============================");
        
        /*TRABAJO CON DOCUMENTOS ELECTRONICOS*/
        
        ArrayList<DocumentoElectronico> nc;
        ServiceDocElectronicoImpl serviceDoc = new ServiceDocElectronicoImpl();

        String pFecha1= "2021-12-31 23:59:59.000";
        String pFecha2= "2023-01-01 00:00:01.000";

        nc = serviceDoc.obtenerDocumentos(pFecha1, pFecha2, 'F');
        System.out.println("Fui a la base");
        
        for(int i=0; i<nc.size(); i++){
            System.out.println("-> "+ nc.get(i).getDocumento());
            System.out.println("-> "+ nc.get(i).getDocumentoOC());
        }
        serviceDoc.cargarExcel(nc);
        System.out.println("Cargue el excel");
        
    }
}


