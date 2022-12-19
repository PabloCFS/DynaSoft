/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.entities;

import java.util.Date;
/**
 * @author pablo.elizondo
 */
public class DocumentosCRM {
    //Declaracion de variables
    private String oportunidad, tema, UEN, clientePotencial;
    private float ingresosReales, estProfit;
    private Date fechaCierre, fechaEstimada;
    private String propietario;
    
    //Constructor sin parametros
    public DocumentosCRM(){
        this.oportunidad = "";
        this.tema = "";
        this.UEN = "";
        this.clientePotencial = "";
        this.ingresosReales = 0.f;
        this.estProfit = 0.f;
        this.fechaCierre = null;
        this.fechaEstimada = null;
        this.propietario = "";
    }
    
    //Constructo con parametros
    public DocumentosCRM(String pOportunidad, String pTema, String pUEN, String pClientePotencial, float pIngresosReales, float pEstProfit, Date pFechaCierre, Date pFechaEstimada, String pPropietario){
        this.oportunidad = pOportunidad;
        this.tema = pTema;
        this.UEN = pUEN;
        this.clientePotencial = pClientePotencial;
        this.ingresosReales = pIngresosReales;
        this.estProfit = pEstProfit;
        this.fechaCierre = pFechaCierre;
        this.fechaEstimada = pFechaEstimada;
        this.propietario = pPropietario;
    }
    
    //FUNCIONES SET
    public void setOportunidad(String pOportunidad) { this.oportunidad = pOportunidad; }
    public void setTema(String pTema) { this.tema = pTema; }
    public void setUEN(String pUEN) { this.UEN = pUEN; }
    public void setClientePotencial(String pClientePotencial) { this.clientePotencial = pClientePotencial; }
    public void setIngresosReales(float pIngresosReales) { this.ingresosReales = pIngresosReales; }
    public void setEstProfit(float pEstProfit) { this.estProfit = pEstProfit; }
    public void setFechaCierre(Date pFechaCierre) { this.fechaCierre = pFechaCierre; }
    public void setFechaEstimada(Date pFechaEstimada) { this.fechaEstimada = pFechaEstimada; }
    public void setPropietario(String pPropietario) { this.propietario = pPropietario; }
    
    //FUNCIONES GET
    public String getOportunidad() { return this.oportunidad; }
    public String getTema() { return this.tema; }
    public String getUEN() { return this.UEN; }
    public String getClientePotencial() { return this.clientePotencial; }
    public float getIngresosReales() { return this.ingresosReales; }
    public float getEstProfit() { return this.estProfit; }
    public Date getFechaCierre() { return this.fechaCierre; }
    public Date getFechaEstimada() { return this.fechaEstimada; }
    public String getPropietario() { return this.propietario; }
}