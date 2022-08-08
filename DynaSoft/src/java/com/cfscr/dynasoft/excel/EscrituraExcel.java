/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.excel;

import com.cfscr.dynasoft.entities.DocumentoElectronico;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author pablo.elizondo
 */
public class EscrituraExcel {
    
    private final String columnas[] = {"Cliente","Nombre","Tipo","Documento","Fecha","Módulo","NIT Receptor","Contiene Error",
                                 "Error Receptor","Error Softland","Enviado","Código Moneda","Total Gravado","Total Exento",
                                 "Total Venta","Total Descuentos","Total Venta Neta","Total Impuesto","Total Comprobante","CRM",
                                 "Aplicación","Documento OC","Monto"};
    
    Workbook book = new XSSFWorkbook();
    Sheet sheet = book.createSheet("Facturas ERP");
    Sheet sheet2 = book.createSheet("Oportunidades CRM");
    
    
    FileOutputStream fileout;
    
    //CREAR EXCEL
    public void crearExcel(){
        try {
            fileout = new FileOutputStream("Reporte.xlsx");
            book.write(fileout);
            fileout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrituraExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrituraExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*CARGAR DOCUMENTOS ELECTRONICOS*/
    public void cargarRegistros(ArrayList<DocumentoElectronico> documentos) {
        Row row = sheet.createRow(0);
        
        for(int i=0; i<columnas.length; i++){
            row.createCell(i).setCellValue(columnas[i]);
        }
         
        for (int i=0; i<documentos.size(); i++){
            row = sheet.createRow(i+1);
            
            row.createCell(0).setCellValue(documentos.get(i).getCliente());
            row.createCell(1).setCellValue(documentos.get(i).getNombre());
            row.createCell(2).setCellValue(tipoDocumento(documentos.get(i).getTipo()));
            row.createCell(3).setCellValue(documentos.get(i).getDocumento());
            row.createCell(4).setCellValue(castearDate(documentos.get(i).getCreateDate()));
            row.createCell(5).setCellValue(pertenceA(documentos.get(i).getTipoAsiento()));
            row.createCell(6).setCellValue(documentos.get(i).getNitReceptor());
            row.createCell(7).setCellValue(castearChar(documentos.get(i).getContieneErrores()));
            row.createCell(8).setCellValue(castearChar(documentos.get(i).getErrorWS()));
            row.createCell(9).setCellValue(castearChar(documentos.get(i).getErrorSoftland()));
            row.createCell(10).setCellValue(castearChar(documentos.get(i).getEnviado()));
            row.createCell(11).setCellValue(tipoMoneda(documentos.get(i).getMoneda()));
            row.createCell(12).setCellValue(
                evaluaNumero(
                    documentos.get(i).getTipo(),
                    CRCtoUSD(documentos.get(i).getTotalGravado(),documentos.get(i).getTipoCambio(),documentos.get(i).getMoneda())
                )
            );
            row.createCell(13).setCellValue(
                evaluaNumero(
                    documentos.get(i).getTipo(),
                    CRCtoUSD(documentos.get(i).getTotalExento(),documentos.get(i).getTipoCambio(),documentos.get(i).getMoneda())
                )
            );
            row.createCell(14).setCellValue(
                evaluaNumero(
                    documentos.get(i).getTipo(),
                    CRCtoUSD(documentos.get(i).getTotalVenta(),documentos.get(i).getTipoCambio(),documentos.get(i).getMoneda())
                )
            );
            row.createCell(15).setCellValue(
                evaluaNumero(
                    documentos.get(i).getTipo(),
                    CRCtoUSD(documentos.get(i).getTotalDescuentos(),documentos.get(i).getTipoCambio(),documentos.get(i).getMoneda())
                )
            );
            row.createCell(16).setCellValue(
                evaluaNumero(
                    documentos.get(i).getTipo(),
                    CRCtoUSD(documentos.get(i).getTotalVentaNeta(),documentos.get(i).getTipoCambio(),documentos.get(i).getMoneda())
                )
            );
            row.createCell(17).setCellValue(
                evaluaNumero(
                    documentos.get(i).getTipo(),
                    CRCtoUSD(documentos.get(i).getTotalImpuesto(),documentos.get(i).getTipoCambio(),documentos.get(i).getMoneda())
                )
            );
            row.createCell(18).setCellValue(
                evaluaNumero(
                    documentos.get(i).getTipo(),
                    CRCtoUSD(documentos.get(i).getTotalComprobante(),documentos.get(i).getTipoCambio(),documentos.get(i).getMoneda())
                )
            );
            if(equals(documentos.get(i).getTipo().equals("Nota crédito"))){
                row.createCell(19).setCellValue("-");
            }
            else if (!documentos.get(i).getTipo().equals("Nota crédito")){
                row.createCell(19).setCellValue(documentos.get(i).getCrm());
            }
            row.createCell(20).setCellValue(documentos.get(i).getAplicacion());
            row.createCell(21).setCellValue(documentos.get(i).getDocumentoOC());
            row.createCell(22).setCellValue(
                evaluaNumero(
                    documentos.get(i).getTipo(),
                    CRCtoUSD(documentos.get(i).getMonto(),documentos.get(i).getTipoCambio(),documentos.get(i).getMoneda())
                )
            );
        }
    }
    
    //PASO DE COLONES A DOLARES
    private float CRCtoUSD(float monto, float tipoCambio, String tipoMoneda){
         switch(tipoMoneda){
            case "D":
                break;
            case "L":
                monto = monto / tipoCambio;
                break;
            case "USD":
                break;
            case "CRC":
                monto = monto / tipoCambio;
                break;
        }
        return monto;
    }
    
    //EVALUACION DE NEGATIVOS
    private float evaluaNumero(String tipo, float num){
        switch(tipo) {
            case "DE_NC":
                num = num - (num * 2);
                break;
            case "N/C":
                num = num - (num * 2);
                break;
            case "O/C":
                num = num - (num * 2);
            break;case "DE_FAC_EXP":
                break;
            case "DE_FA":
                break;
        }
        return num;
    }
    
    //MOSTRAR TIPO DE MONEDA
    private String tipoMoneda(String moneda){
        switch(moneda){
            case "D":
                moneda = "USD";
                break;
            case "L":
                moneda = "USD";
                break;
            case "USD":
                moneda = "USD";
                break;
            case "CRC":
                moneda = "USD";
                break;
        }
        return moneda;
    }
    
    //MOSTRAR NOMBRE DE MODULO
    private String pertenceA(String modulo){
        switch(modulo){
            case "FA":
                modulo = "Facturación";
                break;
            case "CC":
                modulo = "Cuentas por Cobrar";
                break;
        }
        return modulo;
    }
    
    //MOSTRAR TIPO DE DOCUMENTO
    private String tipoDocumento(String tipoDocumento){
        switch(tipoDocumento) {
            case "DE_FA":
                tipoDocumento = "Factura";
                break;
            case "DE_FAC_EXP":
                tipoDocumento = "Factura exportación";
                break;
            case "DE_NC":
                tipoDocumento = "Nota crédito";
                break;
            case "N/C":
                tipoDocumento = "Nota crédito";
                break;
            case "O/C":
                tipoDocumento = "Otro Crédito";
                break;
        }
        return tipoDocumento;
    }
    
    //DATE TO STRING
    private String castearDate(Date fecha){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(fecha);
    }
    
    //CHAR TO STRING
    private String castearChar(char dato){
        String retorno = String.valueOf(dato);
        
        if(retorno.equals("X")){
            retorno = "-";
        }
        return retorno;
    }
    
    //LECTURA DE EXCEL
    public void leerExcel() throws FileNotFoundException, IOException, InvalidFormatException{
        File f = new File("C:\\Users\\Pablo.Elizondo\\Documents\\Desarrollos\\1-ERP-CRM\\Proyecto\\DynaSoft\\ReporteDynamics.xlsx");
        InputStream inp = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(inp);
        sheet = wb.getSheetAt(0);
        
    }
}
