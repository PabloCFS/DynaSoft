/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

import com.cfscr.dynasoft.entities.DocumentoElectronico;

import java.util.ArrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pablo.elizondo
 */
public class DAOdocElectronico extends Conexion{
    private ResultSet rs;
    private final Connection cn = Conexion.getConnection();
    
    //LISTAR DOCUMENTOS ELECTRONICOS
    public ArrayList<DocumentoElectronico> ListarDocsElectronicos(String pFecha1, String pFecha2, char tipoConsulta) throws SQLException {
       
        ArrayList<DocumentoElectronico> docsElectronicos = new ArrayList<>();   System.out.println("\t\tDAO-28"); 
        CallableStatement csta = null;                                          System.out.println("\t\tDAO-29 "+csta);
        csta = cn.prepareCall("SP_LISTAR_FACTURAS_DYNASOFT ?,?");               System.out.println("\t\tDAO-30");
        
        tipoConsulta = 'F';                                                     System.out.println("\t\tDAO-32 "+tipoConsulta);
        if(tipoConsulta == 'F'){                                                System.out.println("\t\tDAO-33 | "+pFecha1);System.out.println("\t\tDAO-33 | "+pFecha2);System.out.println("\t\tDAO-33 | "+tipoConsulta);                                                 
                      
            csta.setString(1, pFecha1);                                         System.out.println("\t\tDAO-35");
            csta.setString(2, pFecha2);                                         System.out.println("\t\tDAO-36");
            rs = csta.executeQuery();                                           System.out.println("\t\tDAO-37");
                
            while(rs.next()){
                docsElectronicos.add(evaluaConsultas(rs,tipoConsulta));         System.out.println("\t\tDAO-40");
            }
        }
        
        tipoConsulta = 'N';                                                     System.out.println("\t\tDAO-44");
        if(tipoConsulta == 'N'){
            csta = cn.prepareCall("SP_LISTAR_NOTAS_CREDITO_DYNASOFT ?,?");      System.out.println("\t\tDAO-46");
            csta.setString(1, pFecha1);
            csta.setString(2, pFecha2);
            rs = csta.executeQuery();
            
            while(rs.next()){
                DocumentoElectronico docElectronico = evaluaConsultas(rs, tipoConsulta);
                if(docElectronico.getTipoAsiento() != null){
                    docsElectronicos.add(docElectronico);
                }
            }
        }
        
        tipoConsulta = 'O';
        if(tipoConsulta == 'O'){
            csta = cn.prepareCall("SP_LISTAR_OTROS_CREDITOS_DYNASOFT ?,?");
            csta.setString(1, pFecha1);
            csta.setString(2, pFecha2);
            rs = csta.executeQuery();
            
            while(rs.next()){
                DocumentoElectronico docElectronico = evaluaConsultas(rs, tipoConsulta);
                if(docElectronico.getTipoAsiento() != null){
                    docsElectronicos.add(docElectronico);
                }
            }
        }
        
        return docsElectronicos;
    }
    
    //Evaluar la consulta Facturas y Notas de Credito
    private DocumentoElectronico evaluaConsultas(ResultSet rs, char tipoConsulta) throws SQLException{
        DocumentoElectronico documento = new DocumentoElectronico();
        
        switch(tipoConsulta){
            case 'F':
                if(rs.getString("NOMBRE_CLIENTE") == null){ documento.setNombre(null);} else{ documento.setNombre(rs.getString("NOMBRE_CLIENTE"));}
                if(rs.getString("CONSECUTIVO") == null){ documento.setTipo(null);} else{ documento.setTipo(rs.getString("CONSECUTIVO"));}
                if(rs.getString("FACTURA") == null) { documento.setDocumento(null);} else { documento.setDocumento(rs.getString("FACTURA"));}
                if(rs.getDate("FECHA") == null) { documento.setCreateDate(null);} else { documento.setCreateDate(rs.getDate("FECHA"));}
                if(rs.getString("MODULO") == null) { documento.setTipoAsiento(null);} else { documento.setTipoAsiento(rs.getString("MODULO"));}
                if(rs.getString("MONEDA_FACTURA") == null) { documento.setMoneda(null);} else { documento.setMoneda(rs.getString("MONEDA_FACTURA"));}
                if(rs.getString("RUBRO1") == null) { documento.setCrm(null);} else { documento.setCrm(rs.getString("RUBRO1"));}
                
                documento.setAplicacion("-");
                documento.setDocumentoOC("-");
                documento.setMonto(0.f);
                break;
                
            case 'N':
                if(rs.getString("NOMBRE") == null) {documento.setNombre(null);} else { documento.setNombre(rs.getString("NOMBRE"));}
                if(rs.getString("TIPO") == null) {documento.setTipo(null);} else { documento.setTipo(rs.getString("TIPO"));}
                if(rs.getString("DOCUMENTO") == null) { documento.setDocumento(null);} { documento.setDocumento(rs.getString("DOCUMENTO"));}
                if(rs.getDate("CreateDate") == null) { documento.setCreateDate(null);} else { documento.setCreateDate(rs.getDate("CreateDate"));}
                if(rs.getString("TIPO_ASIENTO") == null) { documento.setTipoAsiento(null);} { documento.setTipoAsiento(rs.getString("TIPO_ASIENTO"));}
                if(rs.getString("MONEDA") == null) {documento.setMoneda(null);} else { documento.setMoneda(rs.getString("MONEDA"));}
                documento.setCrm("N/A");
                
                documento.setAplicacion("-");
                documento.setDocumentoOC("-");
                documento.setMonto(0.f);
                break;
                
            case 'O':
                if(rs.getString("APLICACION") == null) { documento.setAplicacion(null);} else { documento.setAplicacion(rs.getString("APLICACION"));}
                if(rs.getString("DOCUMENTO") == null) { documento.setDocumentoOC(null);} else { documento.setDocumentoOC(rs.getString("DOCUMENTO"));}
                if(rs.getString("MONTO") == null) { documento.setMonto(0.f);} else { documento.setMonto(rs.getFloat("MONTO"));}
                
                if(rs.getString("NOMBRE") == null) { documento.setNombre(null);} else { documento.setNombre(rs.getString("NOMBRE"));}
                if(rs.getString("TIPO") == null) { documento.setTipo(null);} else { documento.setTipo(rs.getString("TIPO"));}
                if(rs.getString("DEBITO") == null) { documento.setDocumento(null);} else { documento.setDocumento(rs.getString("DEBITO"));}
                if(rs.getDate("FECHA_DOCUMENTO") == null) { documento.setCreateDate(null);} else { documento.setCreateDate(rs.getDate("FECHA_DOCUMENTO"));}
                if(rs.getString("TIPO_ASIENTO") == null) { documento.setTipoAsiento(null);} else { documento.setTipoAsiento(rs.getString("TIPO_ASIENTO"));}
                if(rs.getString("MONEDA") == null) { documento.setMoneda(null);} else { documento.setMoneda(rs.getString("MONEDA"));}
                if(rs.getString("RUBRO1") == null) { documento.setCrm(null);} else { documento.setCrm(rs.getString("RUBRO1"));}
                break;
        }
        
        if(rs.getString("CLIENTE") == null){ documento.setCliente(null);} else{ documento.setCliente(rs.getString("CLIENTE"));}
        
        if(rs.getString("NIT_RECEPTOR") == null) { documento.setNitReceptor(null);} else { documento.setNitReceptor(rs.getString("NIT_RECEPTOR"));}
        if(rs.getString("CONTIENE_ERRORES") == null) { documento.setContieneErrores('X');} else { documento.setContieneErrores(rs.getString("CONTIENE_ERRORES").charAt(0));}
        if(rs.getString("ERROR_WS") == null) { documento.setErrorWS('X');} else { documento.setErrorWS(rs.getString("ERROR_WS").charAt(0));}
        if(rs.getString("ERROR_SOFTLAND") == null) { documento.setErrorSoftland('X');} else { documento.setErrorSoftland( rs.getString("ERROR_SOFTLAND").charAt(0));}
        if(rs.getString("ENVIADO") == null) { documento.setEnviado('X');} else { documento.setEnviado(rs.getString("ENVIADO").charAt(0));}
        
        if(rs.getString("TOTALGRAVADO") == null) { documento.setTotalGravado(0.f);} else { documento.setTotalGravado(rs.getFloat("TOTALGRAVADO"));}
        if(rs.getString("TOTALEXENTO") == null) { documento.setTotalExento(0.f);} else { documento.setTotalExento(rs.getFloat("TOTALEXENTO"));}
        if(rs.getString("TOTALVENTA") == null) { documento.setTotalVenta(0.f);} else { documento.setTotalVenta(rs.getFloat("TOTALVENTA"));}
        if(rs.getString("TOTALDESCUENTOS") == null) { documento.setTotalDescuentos(0.f);} else { documento.setTotalDescuentos(rs.getFloat("TOTALDESCUENTOS"));}
        if(rs.getString("TOTALVENTANETA") == null) { documento.setTotalVentaNeta(0.f);} else { documento.setTotalVentaNeta(rs.getFloat("TOTALVENTANETA"));}
        if(rs.getString("TOTALIMPUESTO") == null) { documento.setTotalImpuesto(0.f);} else { documento.setTotalImpuesto(rs.getFloat("TOTALIMPUESTO"));}
        if(rs.getString("TOTALCOMPROBANTE") == null) { documento.setTotalComprobante(0.f);} else { documento.setTotalComprobante(rs.getFloat("TOTALCOMPROBANTE"));}
        if(rs.getString("TIPO_CAMBIO") == null) { documento.setTipoCambio(0.f);} else { documento.setTipoCambio(rs.getFloat("TIPO_CAMBIO"));}
        
        return documento;
    }
}
