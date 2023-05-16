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
public class DocumentoComparativa {
    //Declaracion de variables
    private String oportunidad, tipo, cliente, factura, tema;
    private float monto, ingresoProfit, ingresoEstimado, totalVentaNeta, totalFactura, diferencia;
    private Date fechaEstimada, fecha;
   
    //Constructor sin parametros
    public DocumentoComparativa(){
        this.oportunidad = "";
        this.tipo = "";
        this.cliente = "";
        this.factura = "";
        this.tema = "";
        this.monto = 0.f;
        this.ingresoProfit = 0.f;
        this.ingresoEstimado = 0.f;
        this.totalVentaNeta = 0.f;
        this.totalFactura = 0.f;
        this.diferencia = 0.f;
        this.fechaEstimada = null;
        this.fecha = null;
    }
    
    //Constructor con parametros
    public DocumentoComparativa(String pOportunidad, String pTipo, String pCliente, String pFactura, String pTema, float pMonto, float pIngresoProfit, float pIngresoEstimado, float pTotalVentaNeta, float pTotalFactura, float pDiferencia, Date pFechaEstimada, Date pFecha){
        this.oportunidad = pOportunidad;
        this.tipo = pTipo;
        this.cliente = pCliente;
        this.factura = pFactura;
        this.tema = pTema;
        this.monto = pMonto;
        this.ingresoProfit = pIngresoProfit;
        this.ingresoEstimado = pIngresoEstimado;
        this.totalVentaNeta = pTotalVentaNeta;
        this.totalFactura = pTotalFactura;
        this.diferencia = pDiferencia;
        this.fechaEstimada = pFechaEstimada;
        this.fecha = pFecha;
    }
    
    //FUNCIONES SET
    public void setOportunidad(String pOportunidad) {this.oportunidad = pOportunidad; }
    public void setTipo(String pTipo) { this.tipo = pTipo; }
    public void setCliente(String pCliente) { this.cliente = pCliente; }
    public void setFactura(String pFactura) { this.factura = pFactura; }
    public void setTema(String pTema) { this.tema = pTema; }
    public void setMonto(float pMonto) { this.monto = pMonto; }
    public void setIngresoProfit(float pIngresoProfit) { this.ingresoProfit = pIngresoProfit; }
    public void setIngresoEstimado(float pIngresoEstimado) { this.ingresoEstimado = pIngresoEstimado; }
    public void setTotalVentaNeta(float pTotalVentaNeta) { this.totalVentaNeta = pTotalVentaNeta; }
    public void setTotalFactura(float pTotalFactura) { this.totalFactura = pTotalFactura; }
    public void setDiferencia(float pDiferencia) { this.diferencia = pDiferencia; }
    public void setFechaEstimada(Date pFechaEstimada) { this.fechaEstimada = pFechaEstimada; }
    public void setFecha(Date pFecha) { this.fecha = pFecha; }
    
    //FUNCIONES GET
    public String getOportunidad() { return this.oportunidad; }
    public String getTipo() { return this.tipo; }
    public String getCliente() { return this.cliente; }
    public String getFactura() { return this.factura; }
    public String getTema() { return this.tema; }
    public float getMonto() { return this.monto; }
    public float getIngresoProfit() { return this.ingresoProfit; }
    public float getIngresoEstimado() { return this.ingresoEstimado; }
    public float getTotalVentaNeta() { return this.totalVentaNeta; }
    public float getTotalFactura() { return this.totalFactura; }
    public float getDiferencia() { return this.diferencia; }
    public Date getFechaEstimada() { return this.fechaEstimada; }
    public Date getFecha() { return this.fecha; }
}