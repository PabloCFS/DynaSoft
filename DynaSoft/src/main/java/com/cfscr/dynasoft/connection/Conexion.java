/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

/**
 *
 * @author pablo.elizondo
 *
 * */
/**
 * Conexion con DB
 * 
**/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
       
    public static Connection getConnection(){
        
        String ConexionUrl = "jdbc:sqlserver://PABLOELIZONDOPC:1433"
                           + "databaseName=DB_INT_SOFTLAND;"
                           + "user=usuarioSQL;"
                           + "password=sql12345;"
                           + "loginTimeout=30;";
        try{
            Connection con = DriverManager.getConnection(ConexionUrl);
            return con;
        } catch(SQLException ex){
            System.out.println(ex.toString());
            return null;
        }
    }
}