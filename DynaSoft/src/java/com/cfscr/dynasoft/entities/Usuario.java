/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.entities;

/**
 * @author pablo.elizondo
 */

/**
 * Creacion de clase usuario
 **/
public class Usuario {
    
    private String nombre;
    private String clave;
    
    public Usuario(){
        this.nombre="";
        this.clave="";
    }
    
    public Usuario(String pNombre, String pClave){
        this.nombre = pNombre;
        this.clave = pClave;
    }
    
    public void setNombre(String pNombre) { this.nombre = pNombre; }
    public void setClave(String pClave) { this.clave = pClave; }
    
    public String getNombre() { return this.nombre; }
    public String getClave() { return this.clave; }

}
