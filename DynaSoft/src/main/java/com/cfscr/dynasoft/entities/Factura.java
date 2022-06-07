/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cfscr.dynasoft.entities;

import java.sql.Date;

/**
 *
 * @author pablo.elizondo
 */
public class Factura {
    private String clave, nombre, tipo, documento;
    private Date fecha;
    private String modulo, NITreceptor, contieneError, errorReceptor, errorSoftland, enviado, codigoMoneda;
    private double totalGravado, totalExtento, totalVenta, totalDescuentos, totalVentaNeta, totalImpuesto, totalComprobante;
    
    public Factura(){
        this.clave = "";
        this.nombre = "";
        this.tipo = "";
        this.documento = "";
        this.fecha = null;
        this.modulo = "";
        this.NITreceptor = "";
        this.contieneError = "";
        this.errorReceptor = "";
        this.errorSoftland = "";
        this.enviado = "";
        this.codigoMoneda = "";
        this.totalGravado = 0.f;
        this.totalExtento = 0.f;
        this.totalVenta = 0.f;
        this.totalDescuentos = 0.f;
        this.totalVentaNeta = 0.f;
        this.totalImpuesto = 0.f;
        this.totalComprobante = 0.f;
    }
    
    public Factura(String pClave, String pNombre, String pTipo, String pDocumento, Date pFecha, String pModulo, String pNITreceptor,
                   String pContieneError, String pErrorReceptor, String pErrorSoftland, String pEnviado, String pCodigoMoneda,
                   double pTotalGravado, double pTotalExtento, double pTotalVenta, double pTotalDescuentos, double pTotalVentaNeta,
                   double pTotalImpuesto, double pTotalComprobante){
        this.clave = pClave; 
        this.nombre = pNombre;
        this.tipo = pTipo;
        this.documento = pDocumento;
        this.fecha = pFecha;
        this.modulo = pModulo;
        this.NITreceptor = pNITreceptor;
        this.contieneError = pContieneError;
        this.errorReceptor = pErrorReceptor;
        this.errorSoftland = pErrorSoftland;
        this.enviado = pEnviado;
        this.codigoMoneda = pCodigoMoneda;
        this.totalGravado = pTotalGravado;
        this.totalExtento = pTotalExtento;
        this.totalVenta = pTotalVenta;
        this.totalDescuentos = pTotalDescuentos;
        this.totalVentaNeta = pTotalVentaNeta;
        this.totalImpuesto = pTotalImpuesto;
        this.totalComprobante = pTotalComprobante;
    }
    
    public void setClave(String pClave) {this.clave = pClave; }
    public void setNombre(String pNombre) { this.nombre = pNombre; }
    public void setTipo(String pTipo) { this.tipo = pTipo; }
    public void setDocumento(String pDocumento) { this.documento = pDocumento; }
    public void setFecha(Date pFecha) { this.fecha = pFecha; }
    public void setModulo(String pModulo) { this.modulo = pModulo; }
    public void setNITreceptor(String pNITreceptor) { this.NITreceptor = pNITreceptor; }
    public void setContieneError(String pContieneError) { this.contieneError = pContieneError; }
    public void setErrorReceptor(String pErrorReceptor) { this.errorReceptor = pErrorReceptor; }
    public void setErrorSoftland(String pErrorSoftland) { this.errorSoftland = pErrorSoftland; }
    public void setEnviado(String pEnviado) { this.enviado = pEnviado; }
    public void setCodigoMoneda(String pCodigoMoneda) { this.codigoMoneda = pCodigoMoneda; }
    public void setTotalGravado(double pTotalGravado) { this.totalGravado = pTotalGravado; }
    public void setTotalExtento(double pTotalExtento) { this.totalExtento = pTotalExtento; }
    public void setTotalVenta(double pTotalVenta) { this.totalVenta = pTotalVenta; }
    public void setTotalDescuento(double pTotalDescuentos ){ this.totalDescuentos = pTotalDescuentos; }
    public void setVentaNeta(double pTotalVentaNeta) { this.totalVentaNeta = pTotalVentaNeta; }
    public void setTotalImpuesto(double pTotalImpuesto) { this.totalImpuesto = pTotalImpuesto; }
    public void setTotalComprobante(double pTotalComprobante) { this.totalComprobante = pTotalComprobante; }

    public String getClave() {return this.clave; }
    public String getNombre() { return this.nombre; }
    public String getTipo() { return this.tipo; }
    public String getDocumento() { return this.documento; }
    public Date getFecha() { return this.fecha; }
    public String getModulo() { return this.modulo; }
    public String getNITReceptor() { return this.NITreceptor; }
    public String getContieneError() { return this.contieneError; }
    public String getErrorReceptor() { return this.errorReceptor; }
    public String getErrorSoftland() { return this.errorSoftland; }
    public String getEnviado() { return this.enviado; }
    public String getCodigoMoneda() { return this.codigoMoneda; }
    public double getTotalGravado() { return this.totalGravado; }
    public double getTotalExtento() { return this.totalExtento; }
    public double getTotalVenta() { return this.totalVenta; }
    public double getTotalDescuentos() { return this.totalDescuentos; }
    public double getTotalVentaNeta() { return this.totalVentaNeta; }
    public double getTotalImpuesto(){ return this.totalImpuesto; }
    public double getTotalComprobante() { return this.totalComprobante; }
}
