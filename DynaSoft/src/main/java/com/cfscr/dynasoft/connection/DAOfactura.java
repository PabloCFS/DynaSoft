/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cfscr.dynasoft.connection;

import com.cfscr.dynasoft.entities.Factura;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class DAOfactura extends Conexion {
    private ResultSet rs;
    private final Connection cn = Conexion.getConnection();
    
    /*INSERTAR FACTURAS -> NO*/
    
    /*ELIMINAR FACTURAS -> NO*/
    
    /*LISTAR FACTURAS*/
    public ArrayList<Factura> ListarFacturas(){
        ArrayList<Factura> factura = new ArrayList<>();
        String SQL_LISTAR;
        CallableStatement csta;
        
        try{
            SQL_LISTAR = "LISTAR_FACTURAS";
            
            csta = cn.prepareCall(SQL_LISTAR);
            rs = csta.executeQuery();
            
            while(rs.next()){
                Factura fa = new Factura();
                
                factura.add(fa);
            }
            return factura;
        } catch(SQLException ex){
            System.out.println(ex.toString());
            return null;
        }
    }
    
    /*OBTENER UNA FACTURA*/
    public Factura obtenerFactura(String pFactura){
        Factura factura = new Factura();
        
        try{
            String SQL_CONSULTAR_FACTURA = "SP_CONSULTAR_UNA_FACTURA";
            
            CallableStatement csta = cn.prepareCall(SQL_CONSULTAR_FACTURA);
            csta.setString(1, pFactura);
            rs = csta.executeQuery();
            
            if(rs.next()){
                factura = new Factura(/*Faltan datos de factura*/);
            }
            
            return factura;
        } catch(SQLException ex){
            System.out.println(ex);
            return factura;
        }
    }
    
    /*MODIFICAR FACTURAS ->  NO*/
    
}
