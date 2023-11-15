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
        String ConexionUrl = "jdbc:sqlserver://xxx.xxx.x.xx:1433;"
            + "databaseName=xxxxx"
            + "user=xxxxxx;"
            + "password=xxxxxxxxxx;"
            + "loginTimeout=30;";
        try{

            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            Connection con = DriverManager.getConnection(ConexionUrl);
            return con;
        } catch(SQLException ex){
            return null;
        }
    }
}