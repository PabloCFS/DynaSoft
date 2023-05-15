/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.entities;
/**
 * @author pablo.elizondo
 */
public class ClientePotencial {
    //Declaracion de variables
    private String idCliente, nombreCliente;
    
    //Constructor sin parametros
    public ClientePotencial(){
        this.idCliente = "";
        this.nombreCliente = "";
    }
    
    //Constructor con parametros
    public ClientePotencial(String pIdCliente, String pNombreCliente){
        this.idCliente = pIdCliente;
        this.nombreCliente = pNombreCliente;
    }
    
    //FUNCIONES SET
    public void setIdCliente(String pIdCliente) { this.idCliente = pIdCliente; }
    public void setNombreCliente(String pNombreCliente) { this.nombreCliente = pNombreCliente; }
    
    //FUNCIONES GET
    public String getIdCliente() { return this.idCliente; }
    public String getNombreCliente() { return this.nombreCliente; }
}
