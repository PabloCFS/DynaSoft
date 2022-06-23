/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

import com.cfscr.dynasoft.entities.DocumentoElectronico;

import java.util.ArrayList;

import java.sql.Date;
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
       
        ArrayList<DocumentoElectronico> docsElectronicos = new ArrayList<>(); System.out.println("DAO-29");
        
        String SQL_LISTAR; System.out.println("DAO-31");
        CallableStatement csta; System.out.println("DAO-32");
        tipoConsulta = 'F'; System.out.println("DAO-33");
        try{
            if(tipoConsulta == 'F'){
                SQL_LISTAR = "SP_LISTAR_FACTURAS_DYNASOFT ?,?"; System.out.println("DAO-36");
                DocumentoElectronico fac; System.out.println("DAO-37");
                System.out.println("DAO-38 | "+pFecha1);System.out.println("DAO-38 | "+pFecha2);
                csta = cn.prepareCall(SQL_LISTAR); System.out.println("DAO-39");
                csta.setString(1, pFecha1); System.out.println("DAO-40");
                csta.setString(2, pFecha2); System.out.println("DAO-41");
                rs=csta.executeQuery(); System.out.println("DAO-42");
                
                while(rs.next()){
                    fac = new DocumentoElectronico(rs.getString("CLIENTE"),rs.getString("NOMBRE_CLIENTE"),rs.getString("CONSECUTIVO"),
                        rs.getString("FACTURA"),rs.getDate("FECHA"),rs.getString("MODULO"),rs.getString("NIT_RECEPTOR"),
                        rs.getString("CONTIENE_ERRORES").charAt(0),rs.getString("ERROR_WS").charAt(0),rs.getString("ERROR_SOFTLAND").charAt(0),
                        rs.getString("ENVIADO").charAt(0),rs.getString("NIVEL_PRECIO"),rs.getFloat("TOTALGRAVADO"),rs.getFloat("TOTALEXENTO"),
                        rs.getFloat("TOTALVENTA"),rs.getFloat("TOTALDESCUENTOS"),rs.getFloat("TOTALVENTANETA"),rs.getFloat("TOTALIMPUESTO"),
                        rs.getFloat("TOTALCOMPROBANTE"),rs.getString("RUBRO1"));
                
                    docsElectronicos.add(fac); System.out.println("DAO-52");
                }
            }
            tipoConsulta = 'N'; System.out.println("DAO-55");
            if(tipoConsulta == 'N'){
                SQL_LISTAR= "SP_LISTAR_NOTAS_CREDITO_DYNASOFT ?,?"; System.out.println("DAO-57");
                DocumentoElectronico nc; System.out.println("DAO-58");
                
                csta = cn.prepareCall(SQL_LISTAR); System.out.println("DAO-60");
                csta.setString(1, pFecha1); System.out.println("DAO-61");
                csta.setString(2, pFecha2); System.out.println("DAO-62");
                rs=csta.executeQuery(); System.out.println("DAO-63");
                
                while(rs.next()){
                    nc = new DocumentoElectronico(rs.getString("CLIENTE"),rs.getString("NOMBRE"),rs.getString("TIPO"),rs.getString("DOCUMENTO"),
                        rs.getDate("CreateDate"),rs.getString("TIPO_ASIENTO"),rs.getString("NIT_RECEPTOR"),rs.getString("CONTIENE_ERRORES").charAt(0),
                        rs.getString("ERROR_WS").charAt(0),rs.getString("ERROR_SOFTLAND").charAt(0),rs.getString("ENVIADO").charAt(0),rs.getString("MONEDA"),
                        rs.getFloat("TOTALGRAVADO"), rs.getFloat("TOTALEXENTO"),rs.getFloat("TOTALVENTA"),rs.getFloat("TOTALDESCUENTOS"),
                        rs.getFloat("TOTALVENTANETA"),rs.getFloat("TOTALIMPUESTO"),rs.getFloat("TOTALCOMPROBANTE"), "N/A");
                    
                    docsElectronicos.add(nc); System.out.println("DAO-72");
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.toString()); System.out.println("DAO-76");
            return null;
        }
        System.out.println("DAO-79");
        return docsElectronicos;
    }
}
