/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

import com.cfscr.dynasoft.entities.DocumentosERP;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;

import java.util.ArrayList;
/**
 *
 * @author pablo.elizondo
 */
public class DAOdocElectronico extends Conexion{
    private ResultSet rs;
    private final Connection cn = Conexion.getConnection();
    
    //TRAER DOCUMENTOS ELECTRONICOS DE LA BD
    public ArrayList<DocumentosERP> ListarDocsElectronicos(String pFecha1, String pFecha2, char tipoConsulta) throws SQLException {
       
        ArrayList<DocumentosERP> docsElectronicos = new ArrayList<>();
        CallableStatement csta;
        csta = cn.prepareCall("SP_LISTAR_FACTURAS_DYNASOFT ?,?");
        
        //Facturas
        tipoConsulta = 'F';
        if(tipoConsulta == 'F'){
            csta.setString(1, pFecha1);
            csta.setString(2, pFecha2);
            rs = csta.executeQuery();
                
            while(rs.next()){
                docsElectronicos.add(evaluaConsultas(rs,tipoConsulta));
            }
        }
        //Notas de Credito
        tipoConsulta = 'N';
        if(tipoConsulta == 'N'){
            csta = cn.prepareCall("SP_LISTAR_NOTAS_CREDITO_DYNASOFT ?,?");
            csta.setString(1, pFecha1);
            csta.setString(2, pFecha2);
            rs = csta.executeQuery();
            
            while(rs.next()){
                DocumentosERP docElectronico = evaluaConsultas(rs, tipoConsulta);
                
                if(docElectronico.getTipoAsiento() != null){
                    docsElectronicos.add(docElectronico);
                }
            }
        }
        //Otros Creditos
        tipoConsulta = 'O';
        if(tipoConsulta == 'O'){
            csta = cn.prepareCall("SP_LISTAR_OTROS_CREDITOS_DYNASOFT ?,?");
            csta.setString(1, pFecha1);
            csta.setString(2, pFecha2);
            rs = csta.executeQuery();
            
            while(rs.next()){
                DocumentosERP docElectronico = evaluaConsultas(rs, tipoConsulta);
                if(docElectronico.getTipoAsiento() != null) {
                    docsElectronicos.add(docElectronico);
                }
            }
        }
        
        //Quitar OtrosCreditos
        for(int i=0; i<docsElectronicos.size(); i++){
            if((docsElectronicos.get(i).getTipo().equals("Otro Crédito")) && (eliminarOC(docsElectronicos.get(i).getAplicacion())) == true){
                docsElectronicos.remove(i);
                i = i - 2;
            }
            if(i < 0) i = 0;
        }
        return docsElectronicos;
    }
    
    //Evaluar la consulta Factura, Notas de Credito y Notas de Credito
    private DocumentosERP evaluaConsultas(ResultSet rs, char tipoConsulta) throws SQLException{
        DocumentosERP documento = new DocumentosERP();
        
        documento.setTipoCambio((rs.getString("TIPO_CAMBIO") == null) ? 0.f : rs.getFloat("TIPO_CAMBIO"));
        switch(tipoConsulta){
            case 'F':
                documento.setNombre((rs.getString("NOMBRE_CLIENTE") == null) ? null : rs.getString("NOMBRE_CLIENTE"));
                documento.setTipo((rs.getString("CONSECUTIVO") == null) ? null : tipoDocumento(rs.getString("CONSECUTIVO")));
                documento.setDocumento((rs.getString("FACTURA") == null) ? null : rs.getString("FACTURA"));
                documento.setCreateDate((rs.getDate("FECHA") == null) ? null : rs.getDate("FECHA"));
                documento.setTipoAsiento((rs.getString("MODULO") == null) ? null : perteneceA(rs.getString("MODULO")));
                documento.setMoneda((rs.getString("MONEDA_FACTURA") == null) ? null : rs.getString("MONEDA_FACTURA"));
                
                documento.setCrm((rs.getString("RUBRO1") == null) ? null : rs.getString("RUBRO1"));
                
                documento.setAplicacion("-");
                documento.setDocumentoOC("-");
                documento.setMonto(0.f);
            break;
            case 'N':
                documento.setNombre((rs.getString("NOMBRE") == null) ? null : rs.getString("NOMBRE"));
                documento.setTipo((rs.getString("TIPO") == null) ? null : tipoDocumento(rs.getString("TIPO")));
                documento.setDocumento((rs.getString("DOCUMENTO") == null) ? null : rs.getString("DOCUMENTO"));
                documento.setCreateDate((rs.getDate("CreateDate") == null) ? null : rs.getDate("CreateDate"));
                documento.setTipoAsiento((rs.getString("TIPO_ASIENTO") == null) ? null : perteneceA(rs.getString("TIPO_ASIENTO")));
                documento.setMoneda((rs.getString("MONEDA") == null) ? null : rs.getString("MONEDA"));
                documento.setCrm((rs.getString("RUBRO1") == null) ? null : rs.getString("RUBRO1"));
                documento.setAplicacion("-");
                documento.setDocumentoOC("-");
                documento.setMonto(0.f);
            break;
            case 'O':
                documento.setAplicacion((rs.getString("APLICACION") == null) ? null : rs.getString("APLICACION"));
                documento.setDocumentoOC((rs.getString("DOCUMENTO") == null) ? null : rs.getString("DOCUMENTO"));
                
                documento.setMonto((rs.getString("MONTO") == null) ? 0.f :
                    evaluaNumero(
                        documento.getTipo(),
                        CRCtoUSD(rs.getFloat("MONTO"), documento.getTipoCambio(),documento.getMoneda())
                    )
                );
                
                documento.setNombre((rs.getString("NOMBRE") == null) ? null : rs.getString("NOMBRE"));
                documento.setTipo((rs.getString("TIPO") == null) ? null : tipoDocumento(rs.getString("TIPO")));
                documento.setDocumento((rs.getString("DEBITO") == null) ? null : rs.getString("DEBITO"));
                documento.setCreateDate((rs.getDate("FECHA_DOCUMENTO") == null) ? null : rs.getDate("FECHA_DOCUMENTO"));
                documento.setTipoAsiento((rs.getString("TIPO_ASIENTO") == null) ? null : perteneceA(rs.getString("TIPO_ASIENTO")));
                documento.setMoneda((rs.getString("MONEDA") == null) ? null : rs.getString("MONEDA"));
                documento.setCrm((rs.getString("RUBRO1") == null) ? null : rs.getString("RUBRO1"));
            break;
        }
        documento.setCliente((rs.getString("CLIENTE") == null) ? null : rs.getString("CLIENTE"));
        documento.setNitReceptor((rs.getString("NIT_RECEPTOR") == null) ? null : rs.getString("NIT_RECEPTOR"));
        documento.setContieneErrores((rs.getString("CONTIENE_ERRORES") == null) ? 'X' : rs.getString("CONTIENE_ERRORES").charAt(0));
        documento.setErrorWS((rs.getString("ERROR_WS") == null) ? 'X' : rs.getString("ERROR_WS").charAt(0));
        documento.setErrorSoftland((rs.getString("ERROR_SOFTLAND") == null) ? 'X' : rs.getString("ERROR_SOFTLAND").charAt(0));
        documento.setEnviado((rs.getString("ENVIADO") == null) ? 'X' : rs.getString("ENVIADO").charAt(0));
        
        documento.setTotalGravado((rs.getString("TOTALGRAVADO") == null) ? 0.f :
            evaluaNumero(
                documento.getTipo(),
                CRCtoUSD(rs.getFloat("TOTALGRAVADO"), documento.getTipoCambio(), documento.getMoneda())
            )
        );
        documento.setTotalExento((rs.getString("TOTALEXENTO") == null) ? 0.f : 
            evaluaNumero(
                documento.getTipo(),
                CRCtoUSD(rs.getFloat("TOTALEXENTO"), documento.getTipoCambio(), documento.getMoneda())
            )
        );
        documento.setTotalVenta((rs.getString("TOTALVENTA") == null) ? 0.f : 
            evaluaNumero(
                documento.getTipo(),
                CRCtoUSD(rs.getFloat("TOTALVENTA"), documento.getTipoCambio(), documento.getMoneda())
            )
        );
        documento.setTotalDescuentos((rs.getString("TOTALDESCUENTOS") == null) ? 0.f :
            evaluaNumero(
                documento.getTipo(),
                CRCtoUSD(rs.getFloat("TOTALDESCUENTOS"), documento.getTipoCambio(), documento.getMoneda())
            )    
        );  
        documento.setTotalVentaNeta((rs.getString("TOTALVENTANETA") == null) ? 0.f :
            evaluaNumero(
                documento.getTipo(), 
                CRCtoUSD(rs.getFloat("TOTALVENTANETA"), documento.getTipoCambio(), documento.getMoneda())
            )
        );
        documento.setTotalImpuesto((rs.getString("TOTALIMPUESTO") == null) ? 0.f : 
            evaluaNumero(
                documento.getTipo(), 
                CRCtoUSD(rs.getFloat("TOTALIMPUESTO"),documento.getTipoCambio(), documento.getMoneda())
            )
        );
        documento.setTotalComprobante((rs.getString("TOTALCOMPROBANTE") == null) ? 0.f : 
            evaluaNumero(
                documento.getTipo(),
                CRCtoUSD(rs.getFloat("TOTALCOMPROBANTE"),documento.getTipoCambio(), documento.getMoneda())
            )
        );
        documento.setTotalFactura((rs.getString("TOTAL_FACTURA") == null) ? 0.f : 
            CRCtoUSD(rs.getFloat("TOTAL_FACTURA"), documento.getTipoCambio(), documento.getMoneda())
        );
        
        documento.setMoneda(tipoMoneda(documento.getMoneda()));
        
        return documento;
    }
    
    //EVALUACION DE NEGATIVOS
    private float evaluaNumero(String tipo, float num){
        switch(tipo) {
            case "Nota Crédito": 
                num = num - (num * 2); 
                break;
                
            case "Otro Crédito":
                num = num - (num * 2);
                break;
                
            case "Factura Exportación":
                break;
            case "Factura":
                break;
        }
        return num;
    }
    
    //PASO DE DOLARES A COLONES
    private float CRCtoUSD(float monto, float tipoCambio, String tipoMoneda){
        switch(tipoMoneda){
            case "D":
                break;
            case "L":
                monto = monto / tipoCambio;
            case "USD":
                break;
            case "CRC":
                monto = monto / tipoCambio;
                break;
        }
        return monto;
    }
    
    //MOSTRAR TIPO DE DOCUMENTO
    private String tipoDocumento(String tipoDocumento){
        switch(tipoDocumento) {
            case "DE_FA":
                tipoDocumento = "Factura";
                break;
                
            case "DE_FAC_EXP":
                tipoDocumento = "Factura Exportación";
                break;
                
            case "DE_NC":
                tipoDocumento = "Nota Crédito";
                break;
                
            case "N/C":
                tipoDocumento = "Nota Crédito";
                break;
                
            case "O/C":
                tipoDocumento = "Otro Crédito";
                break;
        }
        return tipoDocumento;
    }
    
    //MOSTRAR NOMBRE DE MODULO
    private String perteneceA(String modulo){
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
    
    //ELIMINAR ELEMENTOS OTROS CREDITOS
    private boolean eliminarOC(String aplicacion){
        boolean esVerdadero = false;
        String [] vect = aplicacion.split(" ");
        
        for(int i=0; i<vect.length; i++){
            if((vect[i].equals("RETENCION")) || (vect[i].equals("2%")) || (vect[i].equals("DIFERENCIAL")) || (vect[i].equals("CAMBIARIO"))
                || (vect[i].equals("20%")) || (vect[i].equals("25%")) || (vect[i].equals("RETENCIONES")) || (vect[i].equals("COMISION"))
                || (vect[i].equals("COMISIONES")) || (vect[i].equals("BANCARIAS")) || (vect[i].equals("BANCARIA"))){
                esVerdadero = true;
            }
        }
        return esVerdadero;
    }
}