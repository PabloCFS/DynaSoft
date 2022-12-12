/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.excel;

import com.cfscr.dynasoft.entities.DocumentosCRM;
import com.cfscr.dynasoft.entities.DocumentosERP;
import com.cfscr.dynasoft.entities.DocumentoAgrupacion;
import com.cfscr.dynasoft.entities.DocumentoComparativa;

import java.text.SimpleDateFormat;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author pablo.elizondo
 */
public class EscrituraExcelComparativa {
    
    private final String columnasERP[] = {"Cliente","Nombre","Tipo","Documento","Fecha","Módulo","NIT Receptor","Contiene Error",
                                "Error Receptor","Error Softland","Enviado","Código Moneda","Total Gravado","Total Exento",
                                "Total Venta","Total Descuentos","Total Venta Neta","Total Impuesto","Total Comprobante","Total Factura","CRM",
                                "Aplicación","Documento OC","Monto"};
    private final String columnasCRM[] = {"Oportunidad","Tema","UEN","Cliente Potencial","Ingresos Reales","Est. Profit",
                                "Fecha de cierre real","Fecha estimada de factura","Propietario"};
    private final String columnasComparativa[] = {"Oportunidad-CRM","Tipo-ERP","Nombre Cliente-CRM","Tema-CRM","Número Factura-ERP","Monto-ERP",
                                "Ingreso Profit-CRM","Ingreso Estimado-CRM","Total Venta Neta-ERP","Total Factura-ERP","Diferencia (TotalVenta - Ingreso Estimado)",
                                "Fecha Estimada Factura-CRM","Fecha-ERP","Comentarios"};
    private final String columnasAgrupacion[] = {"Oportunidad","Tipo","Cliente","Tema","Monto","Ingreso Profit","Ingreso Estimado","Total Venta","Total Factura","Diferencia","Comentarios"};
    
    
    private final Workbook book = new XSSFWorkbook();
    private final Sheet sheet = book.createSheet("Facturas ERP");
    private final Sheet sheet2 = book.createSheet("Oportunidades CRM");
    private final Sheet sheet3 = book.createSheet("Comparativa");
    private final Sheet sheet4 = book.createSheet("Agrupación");
 
    private FileOutputStream fileout;
    
    //CREAR EXCEL
    public void crearExcel(){
        try {
            fileout = new FileOutputStream("ReporteOps.xlsx");
            book.write(fileout);
            fileout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrituraExcelComparativa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrituraExcelComparativa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*CARGAR DOCUMENTOS ELECTRONICOS ERP*/
    public void cargarRegistrosERP(ArrayList<DocumentosERP> documentos){
        
        Row row = sheet.createRow(0);
        
        for(int i=0; i < columnasERP.length; i++){
           row.createCell(i).setCellValue(columnasERP[i]);
        }
        
        for (int i=0; i < documentos.size(); i++){
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
            row.createCell(19).setCellValue(documentos.get(i).getTotalFactura());
            
            row.createCell(20).setCellValue((documentos.get(i).getTipo().equals("Nota crédito")) ? "-" : documentos.get(i).getCrm());
            
            row.createCell(21).setCellValue(documentos.get(i).getAplicacion());
            row.createCell(22).setCellValue(documentos.get(i).getDocumentoOC());
            row.createCell(23).setCellValue(documentos.get(i).getMonto());
        }
    }
    
    //CARGAR ELEMENTOS DEL CRM
    public void cargarRegistrosCRM(ArrayList<DocumentosCRM> documentos){
        
        Row row = sheet2.createRow(0);
        
        for(int i=0; i < columnasCRM.length; i++){
            row.createCell(i).setCellValue(columnasCRM[i]);
        }
        
        for (int i=0; i < documentos.size(); i++){
            
            row = sheet2.createRow(i+1);
            
            row.createCell(0).setCellValue(documentos.get(i).getOportunidad());
            row.createCell(1).setCellValue(documentos.get(i).getTema());
            row.createCell(2).setCellValue(documentos.get(i).getUEN());
            row.createCell(3).setCellValue(documentos.get(i).getClientePotencial());
            row.createCell(4).setCellValue(documentos.get(i).getIngresosReales());
            row.createCell(5).setCellValue(documentos.get(i).getEstProfit());
            row.createCell(6).setCellValue(castearDate(documentos.get(i).getFechaCierre()));
            row.createCell(7).setCellValue(castearDate(documentos.get(i).getFechaEstimada()));
            row.createCell(8).setCellValue(documentos.get(i).getPropietario());
        }
    }
    
    //PESTANA DE ESPACIOS COMPARABLES
    public void cargarRegistrosComparativa(ArrayList<DocumentoComparativa> documentos){
        
        Row row = sheet3.createRow(0);
        
        for(int i=0; i < columnasComparativa.length; i++){
            row.createCell(i).setCellValue(columnasComparativa[i]);
        }
        
        for(int i=0; i < documentos.size(); i++){
            row = sheet3.createRow(i+1);
            
            row.createCell(0).setCellValue(documentos.get(i).getOportunidad());
            row.createCell(1).setCellValue(documentos.get(i).getTipo());
            row.createCell(2).setCellValue(documentos.get(i).getCliente());
            row.createCell(3).setCellValue(documentos.get(i).getTema());
            row.createCell(4).setCellValue(documentos.get(i).getFactura());
            row.createCell(5).setCellValue(documentos.get(i).getMonto());
            row.createCell(6).setCellValue(documentos.get(i).getIngresoProfit());
            row.createCell(7).setCellValue(documentos.get(i).getIngresoEstimado());
            row.createCell(8).setCellValue(documentos.get(i).getTotalVentaNeta());
            row.createCell(9).setCellValue(documentos.get(i).getTotalFactura());
            row.createCell(10).setCellValue(documentos.get(i).getDiferencia());
            row.createCell(11).setCellValue(castearDate(documentos.get(i).getFechaEstimada()));
            row.createCell(12).setCellValue(castearDate(documentos.get(i).getFecha()));
            row.createCell(13).setCellValue((
                    (documentos.get(i).getTipo().equals("Nota Crédito")) || 
                    (documentos.get(i).getTipo().equals("Otro Crédito")) || 
                    (documentos.get(i).getTipo().equals("No Match ERP")) ||
                    (documentos.get(i).getTotalVentaNeta() - documentos.get(i).getIngresoEstimado() >= 0)
                ) 
                    ? " - - - " : "Saldo Negativo"
            );
        }
    }
    
    //PESTANA DE AGRUPACION DE DOCUMENTOS
    public void cargarDocsAgrupados(ArrayList<DocumentoAgrupacion> documentos){
        Row row = sheet4.createRow(0);
        
        for(int i=0; i < columnasAgrupacion.length; i++){
            row.createCell(i).setCellValue(columnasAgrupacion[i]);
        }
        
        for (int i=0; i < documentos.size(); i++){
            row = sheet4.createRow(i+1);
            
            row.createCell(0).setCellValue(documentos.get(i).getOportunidad());
            row.createCell(1).setCellValue(documentos.get(i).getTipo());
            row.createCell(2).setCellValue(documentos.get(i).getNombreCliente());
            row.createCell(3).setCellValue(documentos.get(i).getTema());
            row.createCell(4).setCellValue(documentos.get(i).getMonto());
            row.createCell(5).setCellValue(documentos.get(i).getIngresoProfit());
            row.createCell(6).setCellValue(documentos.get(i).getIngresoEstimado());
            row.createCell(7).setCellValue(documentos.get(i).getTotalVenta());
            row.createCell(8).setCellValue(documentos.get(i).getToralFactura());
            row.createCell(9).setCellValue(documentos.get(i).getDiferencia());
            row.createCell(10).setCellValue((documentos.get(i).getDiferencia() >= 0)
                ? " - - - " 
                : " Saldo Negativo ");
        }
    }
    
    //DATE TO STRING
    private String castearDate(Date fecha){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(fecha);
    }
    
    //CHAR TO STRING
    private String castearChar(char dato){
        String retorno = String.valueOf(dato);
        
        if(retorno.equals("X")) retorno = "-";

        return retorno;
    }
}
