/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author pablo.elizondo
 *
 * Conexion SQL Server - DB Utilizada por Softland
 **/
public class ConexionERP {
    public static Connection getConnection(){
        String ConexionUrl = "jdbc:sqlserver://192.168.0.12:1433;"
            + "databaseName=Softland;"
            + "user=sa;"
            + "password=Sql2014!Pablo;"
            + "loginTimeout=30;";
        try{
            Connection con = DriverManager.getConnection(ConexionUrl);
            return con;
        } catch(SQLException ex){
            return null;
        }
    }
}