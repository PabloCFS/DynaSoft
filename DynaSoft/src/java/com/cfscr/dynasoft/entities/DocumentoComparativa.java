/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.entities;

import java.util.Date;

/**
 *
 * @author pablo.elizondo
 */
public class Documento {
    
    private String oportunidad, cliente;
    private Date fechaEstimada, fecha;
    private float ingresoProfit, ingresoEstimado, totalVentaNeta, difercencia;
    
    public Documento(){
        this.oportunidad = "";
        this.cliente = "";
    }
    
    
}
