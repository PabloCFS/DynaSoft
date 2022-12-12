/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.logic;

import com.cfscr.dynasoft.entities.DocumentoAgrupacion;
import com.cfscr.dynasoft.entities.DocumentoComparativa;

import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class Agrupacion {
    
    private ArrayList<DocumentoAgrupacion> documentos = new ArrayList<> ();
    
    //Constructores con y sin parametros
    public void Agrupacion(){
        this.documentos = null;
    }
    
    public void Agrupacion(ArrayList<DocumentoAgrupacion> pDocumentos){
        this.documentos = pDocumentos;
    }
    
    //SET AND GET
    public void setDocumentos(ArrayList<DocumentoAgrupacion> pDocumentos) { this.documentos = pDocumentos; }
    
    public ArrayList<DocumentoAgrupacion> getDocumentos() { return this.documentos; }
    
    //Funciona para agrupar documentos
    public ArrayList<DocumentoAgrupacion> agruparDocumentos(ArrayList<DocumentoComparativa> pDocumentos){
        
        for(int i=0; i<pDocumentos.size(); i++){
            DocumentoAgrupacion documento = new DocumentoAgrupacion();
            
            if((pDocumentos.get(i).getTipo().equals("Otro Crédito")) || 
               (pDocumentos.get(i).getOportunidad().equals("No match CRM"))) {
                
                documento.setOportunidad(pDocumentos.get(i).getOportunidad());
                documento.setTipo(pDocumentos.get(i).getTipo());
                documento.setNombreCliente(pDocumentos.get(i).getCliente());
                documento.setTema(pDocumentos.get(i).getTema());
                documento.setMonto(pDocumentos.get(i).getMonto());
                documento.setIngresoProfit(pDocumentos.get(i).getIngresoProfit());
                documento.setIngresoEstimado(pDocumentos.get(i).getIngresoEstimado());
                documento.setTotalVenta(pDocumentos.get(i).getTotalVentaNeta());
                documento.setTotalFactura(pDocumentos.get(i).getTotalFactura());
                documento.setDiferencia(documento.getTotalVenta() - documento.getIngresoEstimado());
                
            }
            else if((!pDocumentos.get(i).getTipo().equals("Otro Crédito")) && 
                    (!pDocumentos.get(i).getOportunidad().equals("No match CRM"))) {
                
                documento.setOportunidad(pDocumentos.get(i).getOportunidad());
                documento.setTipo((pDocumentos.get(i).getTipo().equals("No Match ERP")) ? "No Match ERP" : " - - - ");
                documento.setNombreCliente(pDocumentos.get(i).getCliente());
                documento.setTema(pDocumentos.get(i).getTema());
                documento.setMonto(0.f);
                documento.setIngresoProfit(pDocumentos.get(i).getIngresoProfit());
                documento.setIngresoEstimado(pDocumentos.get(i).getIngresoEstimado());
                documento.setTotalVenta(pDocumentos.get(i).getTotalVentaNeta());
                
                while((pDocumentos.get(i+1).getOportunidad().equals(pDocumentos.get(i).getOportunidad())) && 
                      (!pDocumentos.get(i+1).getTipo().equals("Otro Crédito"))) {
                    
                    documento.setTotalVenta(documento.getTotalVenta() + pDocumentos.get(i+1).getTotalVentaNeta());
                    pDocumentos.remove(i+1);
                }
                
                documento.setTotalFactura(pDocumentos.get(i).getTotalFactura());
                documento.setDiferencia(documento.getTotalVenta() - documento.getIngresoEstimado());
            }
            documentos.add(documento);
        }
        
        return documentos;
    }
}
