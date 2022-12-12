/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.entities;

/**
 *
 * @author pablo.elizondo
 */
public class ClientePotencial {
    private String idCliente, nombreCliente;
    
    public ClientePotencial(){
        this.idCliente = "";
        this.nombreCliente = "";
    }
    
    public ClientePotencial(String pIdCliente, String pNombreCliente){
        this.idCliente = pIdCliente;
        this.nombreCliente = pNombreCliente;
    }
    
    public void setIdCliente(String pIdCliente) { this.idCliente = pIdCliente; }
    public void setNombreCliente(String pNombreCliente) { this.nombreCliente = pNombreCliente; }
    
    public String getIdCliente() { return this.idCliente; }
    public String getNombreCliente() { return this.nombreCliente; }
}
