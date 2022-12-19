/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.entities;
/**
 * @author pablo.elizondo
 */
public class DocumentoAgrupacion {
    //Declaracion de variables
    private String oportunidad, tipo, nombreCliente, tema;
    private float monto, ingresoProfit, ingresoEstimado, totalVenta, totalFactura, diferencia;
    
    //Constructor sin parametros
    public DocumentoAgrupacion(){
        this.oportunidad = "";
        this.tipo = "";
        this.nombreCliente = "";
        this.tema = "";
        this.monto = 0.f;
        this.ingresoProfit = 0.f;
        this.ingresoEstimado = 0.f;
        this.totalVenta = 0.f;
        this.totalFactura = 0.f;
        this.diferencia = 0.f;
    }
    
    //Constructor con parametros
    public DocumentoAgrupacion(String pOportunidad, String pTipo, String pNombreCliente, String pTema, float pMonto, float pIngresoProfit, float pIngresoEstimado, float pTotalVenta, float pTotalFactura, float pDiferencia){
        this.oportunidad = pOportunidad;
        this.tipo = pTipo;
        this.nombreCliente = pNombreCliente;
        this.tema = pTema;
        this.monto = pMonto;
        this.ingresoProfit = pIngresoProfit;
        this.ingresoEstimado = pIngresoEstimado;
        this.totalVenta = pTotalVenta;
        this.totalFactura = pTotalFactura;
    }
    
    //FUNCIONES SET
    public void setOportunidad(String pOportunidad) { this.oportunidad = pOportunidad; }
    public void setTipo(String pTipo) { this.tipo = pTipo; }
    public void setNombreCliente(String pNombreCliente) { this.nombreCliente = pNombreCliente; }
    public void setTema(String pTema) { this.tema = pTema; }
    public void setMonto(float pMonto) { this.monto = pMonto; }
    public void setIngresoProfit(float pIngresoProfit) { this.ingresoProfit = pIngresoProfit; }
    public void setIngresoEstimado(float pIngresoEstimado) { this.ingresoEstimado = pIngresoEstimado; }
    public void setTotalVenta(float pTotalVenta) { this.totalVenta = pTotalVenta; }
    public void setTotalFactura(float pTotalFactura) { this.totalFactura = pTotalFactura; }
    public void setDiferencia(float pDiferencia) { this.diferencia = pDiferencia;}
    
    //FUNCIONES GET
    public String getOportunidad() { return this.oportunidad; }
    public String getTipo() { return this.tipo; }
    public String getNombreCliente() { return this.nombreCliente; }
    public String getTema() { return this.tema; }
    public float getMonto() { return this.monto; }
    public float getIngresoProfit() { return this.ingresoProfit; }
    public float getIngresoEstimado() { return this.ingresoEstimado; }
    public float getTotalVenta() { return this.totalVenta; }
    public float getTotalFactura() { return this.totalFactura; }
    public float getDiferencia() { return this.diferencia; }
}
