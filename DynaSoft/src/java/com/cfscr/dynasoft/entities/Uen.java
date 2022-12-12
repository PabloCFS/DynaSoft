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
public class Uen {
    private String idUEN, nombreUEN;
    
    public Uen(){
        this.idUEN = "";
        this.nombreUEN = "";
    }
    
    public Uen(String pIdUEN, String pNombreUEN){
        this.idUEN = pIdUEN;
        this.nombreUEN = pNombreUEN;
    }
    
    public void setIdUEN(String pIdUEN) { this.idUEN = pIdUEN; }
    public void setNombreUEN(String pNombreUEN) { this.nombreUEN = pNombreUEN; }
    
    public String getIdUEN() { return this.idUEN; }
    public String getNombreUEN() { return this.nombreUEN; }
}
