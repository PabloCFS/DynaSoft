/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

import java.sql.Connection;

/**
 *
 * @author pablo.elizondo
 */
public class Conexiones extends Conexion{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Connection cn = Conexion.getConnection();
        
    }
    
}
