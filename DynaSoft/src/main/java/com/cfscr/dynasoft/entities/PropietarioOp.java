/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.entities;

/**
 * @author pablo.elizondo
 */
public class PropietarioOp {
    //Declaracion de variables
    private String idPropietario, nombrePropietario;
    
    //Constructor sin parametros
    public PropietarioOp(){
        this.idPropietario = "";
        this.nombrePropietario = "";
    }
    
    //Constructor con parametros
    public PropietarioOp(String pIdPropietario, String pNombrePropietario){
        this.idPropietario = pIdPropietario;
        this.nombrePropietario = pNombrePropietario;
    }
    
    //FUNCIONES SET
    public void setIdPropietario(String pIdPropietario) { this.idPropietario = pIdPropietario; }
    public void setNombrePropietario(String pNombrePropietario) { this.nombrePropietario = pNombrePropietario; }
    
    //FUNCIONES GET
    public String getIdPropietario() { return this.idPropietario; }
    public String getNombrePropietario() { return this.nombrePropietario; }
}
