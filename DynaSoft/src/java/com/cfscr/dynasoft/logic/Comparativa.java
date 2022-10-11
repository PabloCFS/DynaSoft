/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.logic;

import com.cfscr.dynasoft.entities.DocumentosERP;
import com.cfscr.dynasoft.entities.DocumentosCRM;
import com.cfscr.dynasoft.entities.DocumentoComparativa;

import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class Comparativa {
    
    //VARIABLES
    private ArrayList<DocumentoComparativa> documentos = new ArrayList<> ();
    
    //CONSTRUCTORES CON Y SIN PARAMETROS
    public void comparativa(){
        this.documentos = null;
    }
    
    public void comparativa(ArrayList<DocumentoComparativa> pDocumentos){
        this.documentos = pDocumentos;
    }
    
    //SET AND GET
    public void setDocumentos(ArrayList<DocumentoComparativa> pDocumentos) { this.documentos = pDocumentos; }
    public ArrayList<DocumentoComparativa> getDocumentos() { return this.documentos; }
    
    //AGREGAR ELEMENTOS EN LA SECCION DE COMPARATIVA
    public ArrayList<DocumentoComparativa> comparaListas(ArrayList<DocumentosCRM> docsCRM, ArrayList<DocumentosERP> docsERP){
       
        //AGREGAR CRM CON ERP JUNTOS
        for(int i=0; i < docsCRM.size(); i++){
            String oportunidad = docsCRM.get(i).getOportunidad();
            boolean coinciden = false;
            
            for(int j=0; j<docsERP.size(); j++){
                if(oportunidad.equals(docsERP.get(j).getCrm())){
                    
                    switch(docsERP.get(j).getTipo()){
                        case "Factura":
                            DocumentoComparativa miDocumento = new DocumentoComparativa();
                            miDocumento.setOportunidad(docsCRM.get(i).getOportunidad());
                            miDocumento.setTipo(docsERP.get(j).getTipo());
                            miDocumento.setCliente(docsCRM.get(i).getClientePotencial());
                            miDocumento.setFactura(docsERP.get(j).getDocumento());
                            miDocumento.setMonto(0.f);
                            miDocumento.setIngresoProfit(docsCRM.get(i).getEstProfit());
                            miDocumento.setIngresoEstimado(docsCRM.get(i).getIngresosReales());
                            miDocumento.setTotalVentaNeta(docsERP.get(j).getTotalVentaNeta());
                            miDocumento.setTotalFactura(docsERP.get(j).getTotalFactura());
                            miDocumento.setDiferencia(docsERP.get(j).getTotalVentaNeta() - docsCRM.get(i).getIngresosReales());
                            miDocumento.setFechaEstimada(docsCRM.get(i).getFechaEstimada());
                            miDocumento.setFecha(docsERP.get(j).getCreateDate());
                            documentos.add(miDocumento);
                        break;
                        case "Factura Exportación":
                            DocumentoComparativa miDocumento1 = new DocumentoComparativa();
                            miDocumento1.setOportunidad(docsCRM.get(i).getOportunidad());
                            miDocumento1.setTipo(docsERP.get(j).getTipo());
                            miDocumento1.setCliente(docsCRM.get(i).getClientePotencial());
                            miDocumento1.setFactura(docsERP.get(j).getDocumento());
                            miDocumento1.setMonto(0.f);
                            miDocumento1.setIngresoProfit(docsCRM.get(i).getEstProfit());
                            miDocumento1.setIngresoEstimado(docsCRM.get(i).getIngresosReales());
                            miDocumento1.setTotalVentaNeta(docsERP.get(j).getTotalVentaNeta());
                            miDocumento1.setTotalFactura(docsERP.get(j).getTotalFactura());
                            miDocumento1.setDiferencia(docsERP.get(j).getTotalVentaNeta() - docsCRM.get(i).getIngresosReales());
                            miDocumento1.setFechaEstimada(docsCRM.get(i).getFechaEstimada());
                            miDocumento1.setFecha(docsERP.get(j).getCreateDate());
                            documentos.add(miDocumento1);
                        break;
                        case "Nota Crédito":
                            DocumentoComparativa miDocumento2 = new DocumentoComparativa();
                            miDocumento2.setOportunidad(docsCRM.get(i).getOportunidad());
                            miDocumento2.setTipo(docsERP.get(j).getTipo());
                            miDocumento2.setCliente(docsCRM.get(i).getClientePotencial());
                            miDocumento2.setFactura(docsERP.get(j).getDocumento());
                            miDocumento2.setMonto(0.f);
                            miDocumento2.setIngresoProfit(docsCRM.get(i).getEstProfit());
                            miDocumento2.setIngresoEstimado(docsCRM.get(i).getIngresosReales());
                            miDocumento2.setTotalVentaNeta(docsERP.get(j).getTotalVentaNeta());
                            miDocumento2.setTotalFactura(docsERP.get(j).getTotalFactura());
                            miDocumento2.setDiferencia(0.f);
                            miDocumento2.setFechaEstimada(docsCRM.get(i).getFechaEstimada());
                            miDocumento2.setFecha(docsERP.get(j).getCreateDate());
                            documentos.add(miDocumento2);
                        break;
                        case "Otro Crédito":
                            DocumentoComparativa miDocumento3 = new DocumentoComparativa();
                            miDocumento3.setOportunidad(docsCRM.get(i).getOportunidad());
                            miDocumento3.setTipo(docsERP.get(j).getTipo());
                            miDocumento3.setCliente(docsCRM.get(i).getClientePotencial());
                            miDocumento3.setFactura(docsERP.get(j).getDocumento());
                            miDocumento3.setMonto(docsERP.get(j).getMonto());
                            miDocumento3.setIngresoProfit(docsCRM.get(i).getEstProfit());
                            miDocumento3.setIngresoEstimado(docsCRM.get(i).getIngresosReales());
                            miDocumento3.setTotalVentaNeta(docsERP.get(j).getTotalVentaNeta());
                            miDocumento3.setTotalFactura(docsERP.get(j).getTotalFactura());
                            miDocumento3.setDiferencia(0.f);
                            miDocumento3.setFechaEstimada(docsCRM.get(i).getFechaEstimada());
                            miDocumento3.setFecha(docsERP.get(j).getCreateDate());
                            documentos.add(miDocumento3);
                        break;
                    }
                    coinciden = true;
                    docsERP.remove(j);
                    j = j - 2;
                    if(j < 0) j = 0;
                }
            }
            if(coinciden == true) {
                docsCRM.remove(i);
                i = i - 2;
                if(i < 0) i = 0;
            }
        }
        
        //AGREGAR CRM
        for(int i=0; i < docsCRM.size();){
            DocumentoComparativa miDocumento = new DocumentoComparativa();
            
            miDocumento.setOportunidad(docsCRM.get(i).getOportunidad());
            miDocumento.setTipo("No Match ERP");
            miDocumento.setCliente(docsCRM.get(i).getClientePotencial());
            miDocumento.setFactura(" - ");
            miDocumento.setMonto(0);
            miDocumento.setIngresoProfit(docsCRM.get(i).getEstProfit());
            miDocumento.setIngresoEstimado(docsCRM.get(i).getIngresosReales());
            miDocumento.setTotalVentaNeta(0);
            miDocumento.setTotalFactura(0);
            miDocumento.setDiferencia(0);
            miDocumento.setFechaEstimada(docsCRM.get(i).getFechaEstimada());
            miDocumento.setFecha(docsCRM.get(i).getFechaEstimada());
            
            documentos.add(miDocumento);
            docsCRM.remove(i);
        }
        
        //AGREGAR ERP
        for(int i=0; i < docsERP.size();){
            DocumentoComparativa miDocumento = new DocumentoComparativa();
            
            miDocumento.setOportunidad("No match CRM");
            miDocumento.setTipo(docsERP.get(i).getTipo());
            miDocumento.setCliente(" - ");
            miDocumento.setFactura(docsERP.get(i).getDocumento());
            miDocumento.setMonto(docsERP.get(i).getMonto());
            miDocumento.setIngresoProfit(0);
            miDocumento.setIngresoEstimado(0); 
            miDocumento.setTotalVentaNeta(docsERP.get(i).getTotalVentaNeta());
            miDocumento.setTotalFactura(docsERP.get(i).getTotalFactura());
            miDocumento.setDiferencia(0);
            miDocumento.setFechaEstimada(docsERP.get(i).getCreateDate());
            miDocumento.setFecha(docsERP.get(i).getCreateDate());
            
            documentos.add(miDocumento);
            docsERP.remove(i);
        }
        return documentos;
    }
}