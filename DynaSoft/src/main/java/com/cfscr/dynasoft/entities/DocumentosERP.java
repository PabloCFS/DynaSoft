/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.entities;

import java.sql.Date;
/**
 * @author pablo.elizondo
 */
public class DocumentosERP {
    //Declaracion de variables
    private String aplicacion, documentoOC;
    private float monto;
    private String cliente, nombre, tipo, documento;
    private Date createDate;
    private String tipoAsiento, nitReceptor;
    private char contieneErrores, errorWS, errorSoftland, enviado;
    private String moneda;
    private float totalGravado, totalExento, totalVenta, totalDescuentos, totalVentaNeta, totalImpuesto, totalComprobante, totalFactura;
    private String crm;
    private float tipoCambio;
            
    //Constructor sin parametros
    public DocumentosERP() {
        this.aplicacion = "";
        this.documentoOC = "";
        this.monto = 0.f;
        this.cliente = "";
        this.nombre = "";
        this.tipo = "";
        this.documento = "";
        this.createDate = null;
        this.tipoAsiento = "";
        this.nitReceptor = "";
        this.contieneErrores = '-';
        this.errorWS = '-';
        this.errorSoftland = '-';
        this.enviado = '-';
        this.moneda = "";
        this.totalGravado = 0.f;
        this.totalExento = 0.f;
        this.totalVenta = 0.f;
        this.totalDescuentos = 0.f;
        this.totalVentaNeta = 0.f;
        this.totalImpuesto = 0.f;
        this.totalComprobante = 0.f;
        this.totalFactura = 0.f;
        this.crm = "";
        this.tipoCambio = 0.f;
    }
    
    //Constructor con parametros
    public DocumentosERP(String pAplicacion, String pDocumentoOC, float pMonto, String pCliente, String pNombre, String pTipo, String pDocumento, Date pCreateDate, String pTipoAsiento, String pNitReceptor,
                       char pContieneErrores, char pErrorWS, char pErrorSoftland, char pEnviado, String pMoneda, float pTotalGravado,
                       float pTotalExento, float pTotalVenta, float pTotalDescuentos, float pTotalVentaNeta, float pTotalImpuesto,
                       float pTotalComprobante, float pTotalFactura, String  pCrm, float pTipoCambio) {
        this.aplicacion = pAplicacion;
        this.documentoOC = pDocumentoOC;
        this.monto = pMonto;
        this.cliente = pCliente;
        this.nombre = pNombre;
        this.tipo = pTipo;
        this.documento = pDocumento;
        this.createDate = pCreateDate;
        this.tipoAsiento = pTipoAsiento;
        this.nitReceptor = pNitReceptor;
        this.contieneErrores = pContieneErrores;
        this.errorWS = pErrorWS;
        this.errorSoftland = pErrorSoftland;
        this.enviado = pEnviado;
        this.moneda = pMoneda;
        this.totalGravado = pTotalGravado;
        this.totalExento = pTotalExento;
        this.totalVenta = pTotalVenta;
        this.totalDescuentos = pTotalDescuentos;
        this.totalVentaNeta = pTotalVentaNeta;
        this.totalImpuesto = pTotalImpuesto;
        this.totalComprobante = pTotalComprobante;
        this.totalFactura = pTotalFactura;
        this.crm = pCrm;
        this.tipoCambio = pTipoCambio;
    }

    //FUNCIONES SET
    public void setAplicacion(String pAplicacion) { this.aplicacion = pAplicacion; }
    public void setDocumentoOC(String pDocumentoOC) { this.documentoOC = pDocumentoOC; }
    public void setMonto(float pMonto) { this.monto = pMonto; }
    public void setCliente(String pCliente) { this.cliente = pCliente; }
    public void setNombre(String pNombre) { this.nombre = pNombre; }
    public void setTipo(String pTipo) { this.tipo = pTipo; }
    public void setDocumento(String pDocumento) { this.documento = pDocumento; }
    public void setCreateDate(Date pCreateDate) { this.createDate = pCreateDate; }
    public void setTipoAsiento(String pTipoAsiento) { this.tipoAsiento = pTipoAsiento; }
    public void setNitReceptor(String pNitReceptor) { this.nitReceptor = pNitReceptor; }
    public void setContieneErrores(char pContieneErrores) { this.contieneErrores = pContieneErrores; }
    public void setErrorWS(char pErrorWS) { this.errorWS = pErrorWS; }
    public void setErrorSoftland(char pErrorSoftland) { this.errorSoftland = pErrorSoftland; }
    public void setEnviado(char pEnviado) { this.enviado = pEnviado; }
    public void setMoneda(String pMoneda) { this.moneda = pMoneda; }
    public void setTotalGravado(float pTotalGravado) { this.totalGravado = pTotalGravado; }
    public void setTotalExento(float pTotalExento) { this.totalExento = pTotalExento; }
    public void setTotalVenta(float pTotalVenta) { this.totalVenta = pTotalVenta; }
    public void setTotalDescuentos(float pTotalDescuentos) { this.totalDescuentos = pTotalDescuentos; }
    public void setTotalVentaNeta(float pTotalVentaNeta) { this.totalVentaNeta = pTotalVentaNeta; }
    public void setTotalImpuesto(float pTotalImpuesto) { this.totalImpuesto = pTotalImpuesto; }
    public void setTotalComprobante(float pTotalComprobante) { this.totalComprobante = pTotalComprobante; }
    public void setTotalFactura(float pTotalFactura) { this.totalFactura = pTotalFactura; }
    public void setCrm(String pCrm) { this.crm = pCrm; }
    public void setTipoCambio(float pTipoCambio) { this.tipoCambio = pTipoCambio; }
     
    //FUNCIONES GET
    public String getAplicacion() { return this.aplicacion; }
    public String getDocumentoOC() { return this.documentoOC; }
    public float getMonto() { return this.monto; }
    public String getCliente() { return this.cliente; }
    public String getNombre() { return this.nombre; }
    public String getTipo() { return this.tipo; }
    public String getDocumento() { return this.documento; }
    public Date getCreateDate() { return this.createDate; }
    public String getTipoAsiento() { return this.tipoAsiento; }
    public String getNitReceptor() { return this.nitReceptor; }
    public char getContieneErrores() { return this.contieneErrores; }
    public char getErrorWS() { return this.errorWS; }
    public char getErrorSoftland() { return this.errorSoftland; }
    public char getEnviado() { return this.enviado; }
    public String getMoneda() { return this.moneda; }
    public float getTotalGravado() { return this.totalGravado; }
    public float getTotalExento() { return this.totalExento; }
    public float getTotalVenta() { return this.totalVenta; }
    public float getTotalDescuentos() { return this.totalDescuentos; }
    public float getTotalVentaNeta() { return this.totalVentaNeta; }
    public float getTotalImpuesto() { return this.totalImpuesto; }
    public float getTotalComprobante() { return this.totalComprobante; }
    public float getTotalFactura() { return this.totalFactura; }
    public String getCrm() { return this.crm; }
    public float getTipoCambio() { return this.tipoCambio; }
}