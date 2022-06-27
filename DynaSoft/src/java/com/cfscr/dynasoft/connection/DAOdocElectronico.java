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
    public ArrayList<DocumentoElectronico> ListarDocsElectronicos(String pFecha1, String pFecha2, char tipoConsulta){
       
        ArrayList<DocumentoElectronico> docsElectronicos = new ArrayList<>();   System.out.println("DAO-28");
        
        CallableStatement csta;                                                 System.out.println("DAO-31");
        tipoConsulta = 'F';                                                     System.out.println("DAO-32");
        try{
            if(tipoConsulta == 'F'){                                            System.out.println("DAO-38 | "+pFecha1);System.out.println("DAO-36 | "+pFecha2);                                                  
                csta = cn.prepareCall("SP_LISTAR_FACTURAS_DYNASOFT ?,?");       System.out.println("DAO-37");
                csta.setString(1, pFecha1);                                     System.out.println("DAO-48");
                csta.setString(2, pFecha2);                                     System.out.println("DAO-39");
                rs = csta.executeQuery();                                       System.out.println("DAO-40");
                
                while(rs.next()){
                    docsElectronicos.add(evaluaConsultas(rs,tipoConsulta));     System.out.println("DAO-43");
                }
            }
            
            tipoConsulta = 'N';                                                 System.out.println("DAO-55");
            if(tipoConsulta == 'N'){
                csta = cn.prepareCall("SP_LISTAR_NOTAS_CREDITO_DYNASOFT ?,?");                              System.out.println("DAO-60");
                csta.setString(1, pFecha1);                                     System.out.println("DAO-61");
                csta.setString(2, pFecha2);                                     System.out.println("DAO-62");
                rs = csta.executeQuery();                                       System.out.println("DAO-63");
                
                while(rs.next()){
                    DocumentoElectronico docElectronico = evaluaConsultas(rs, tipoConsulta);
                    if(docElectronico.getTipoAsiento() != null){
                        docsElectronicos.add(docElectronico);   
                    }
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());                                  System.out.println("DAO-76");
            return null;
        }
                                                                                System.out.println("DAO-79");
        return docsElectronicos;
    }
    
    private DocumentoElectronico evaluaConsultas(ResultSet rs, char tipoConsulta) throws SQLException{
        DocumentoElectronico documento = new DocumentoElectronico();
        
        if(tipoConsulta == 'F'){
            if(rs.getString("NOMBRE_CLIENTE") == null){ documento.setNombre(null);} else{ documento.setNombre(rs.getString("NOMBRE_CLIENTE"));}
            if(rs.getString("CONSECUTIVO") == null){ documento.setTipo(null);} else{ documento.setTipo(rs.getString("CONSECUTIVO"));}
            if(rs.getString("FACTURA") == null) { documento.setDocumento(null);} else { documento.setDocumento(rs.getString("FACTURA"));}
            if(rs.getDate("FECHA") == null) { documento.setCreateDate(null);} else { documento.setCreateDate(rs.getDate("FECHA"));}
            if(rs.getString("MODULO") == null) { documento.setTipoAsiento(null);} else { documento.setTipoAsiento(rs.getString("MODULO"));}
            if(rs.getString("MONEDA_FACTURA") == null) { documento.setMoneda(null);} else { documento.setMoneda(rs.getString("MONEDA_FACTURA"));}
            if(rs.getString("RUBRO1") == null) { documento.setCrm(null);} else { documento.setCrm(rs.getString("RUBRO1"));}
        }
        else if(tipoConsulta == 'N'){
            if(rs.getString("NOMBRE") == null) {documento.setNombre(null);} else { documento.setNombre(rs.getString("NOMBRE"));}
            if(rs.getString("TIPO") == null) {documento.setTipo(null);} else { documento.setTipo(rs.getString("TIPO"));}
            if(rs.getString("DOCUMENTO") == null) { documento.setDocumento(null);} { documento.setDocumento(rs.getString("DOCUMENTO"));}
            if(rs.getDate("CreateDate") == null) { documento.setCreateDate(null);} else { documento.setCreateDate(rs.getDate("CreateDate"));}
            if(rs.getString("TIPO_ASIENTO") == null) { documento.setTipoAsiento(null);} { documento.setTipoAsiento(rs.getString("TIPO_ASIENTO"));}
            if(rs.getString("MONEDA") == null) {documento.setMoneda(null);} else { documento.setMoneda(rs.getString("MONEDA"));}
            documento.setCrm("N/A");
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
        
        return documento;
    }
}
