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
        
        /*ERP*/
        String ConexionUrl  = "jdbc:sqlserver://192.168.0.12:1433;"
            + "databaseName=Softland;"
            + "user=sa;"
            + "password=Sql2014!Pablo;"
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