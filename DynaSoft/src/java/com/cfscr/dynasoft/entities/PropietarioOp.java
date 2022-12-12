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
public class PropietarioOp {
    private String idPropietario, nombrePropietario;
    
    public PropietarioOp(){
        this.idPropietario = "";
        this.nombrePropietario = "";
    }
    
    public PropietarioOp(String pIdPropietario, String pNombrePropietario){
        this.idPropietario = pIdPropietario;
        this.nombrePropietario = pNombrePropietario;
    }
    
    public void setIdPropietario(String pIdPropietario) { this.idPropietario = pIdPropietario; }
    public void setNombrePropietario(String pNombrePropietario) { this.nombrePropietario = pNombrePropietario; }
    
    public String getIdPropietario() { return this.idPropietario; }
    public String getNombrePropietario() { return this.nombrePropietario; }
}
