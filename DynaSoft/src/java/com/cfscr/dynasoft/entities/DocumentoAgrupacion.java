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
public class DocumentoAgrupacion {
    private String oportunidad, tipo, nombreCliente;
    private float monto, ingresoProfit, ingresoEstimado, totalVenta;
    private String comentario;
    
    //Constructores con y sin parametros
    public DocumentoAgrupacion(){
        this.oportunidad = "";
        this.tipo = "";
        this.nombreCliente = "";
        this.monto = 0.f;
        this.ingresoProfit = 0.f;
        this.ingresoEstimado = 0.f;
        this.totalVenta = 0.f;
        this.comentario  = "";
    }
    
    public DocumentoAgrupacion(String pOportunidad, String pTipo, String pNombreCliente, float pMonto, float pIngresoProfit, float pIngresoEstimado, float pTotalVenta, String pComentario){
        this.oportunidad = pOportunidad;
        this.tipo = pTipo;
        this.nombreCliente = pNombreCliente;
        this.monto = pMonto;
        this.ingresoProfit = pIngresoProfit;
        this.ingresoEstimado = pIngresoEstimado;
        this.totalVenta = pTotalVenta;
        this.comentario = pComentario;
    }
    
    //FUNCIONES SET
    public void setOportunidad(String pOportunidad) { this.oportunidad = pOportunidad; }
    public void setTipo(String pTipo) { this.tipo = pTipo; }
    public void setNombreCliente(String pNombreCliente) { this.nombreCliente = pNombreCliente; }
    public void setMonto(float pMonto) { this.monto = pMonto; }
    public void setIngresoProfit(float pIngresoProfit) { this.ingresoProfit = pIngresoProfit; }
    public void setIngresoEstimado(float pIngresoEstimado) { this.ingresoEstimado = pIngresoEstimado; }
    public void setTotalVenta(float pTotalVenta) { this.totalVenta = pTotalVenta; }
    public void setComentario(String pComentario) { this.comentario = pComentario; }
    
    public String getOportunidad() { return this.oportunidad; }
    public String getTipo() { return this.tipo; }
    public String getNombreCliente() { return this.nombreCliente; }
    public float getMonto() { return this.monto; }
    public float getIngresoProfit() { return this.ingresoProfit; }
    public float getIngresoEstimado() { return this.ingresoEstimado; }
    public float getTotalVenta() { return this.totalVenta; }
    public String getComentario() { return this.comentario; }
}
