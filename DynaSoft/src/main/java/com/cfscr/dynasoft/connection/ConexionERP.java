/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * @author pablo.elizondo
 *
 * Conexion SQL Server - DB Utilizada por Softland
 **/
public class ConexionERP {
    
    private static final String URL = "jdbc:sqlserver://192.168.0.12:1433;databaseName=Softland";
    private static final String USER = "SA";
    private static final String PASSWORD = "Sql2014!Pablo";
    
    public static Connection getConnection() throws SQLException {
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch(ClassNotFoundException e){
            throw new SQLException("No se encontró el driver JDBC.",e);
        }
        
        return DriverManager.getConnection(URL,USER,PASSWORD);        
    }
}