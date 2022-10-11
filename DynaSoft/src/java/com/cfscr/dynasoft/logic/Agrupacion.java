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
    private DocumentoAgrupacion documento;
    
    //Constructores con y sin parametros
    public void Agrupacion(){
        this.documentos = null;
        this.documento = null;
    }
    
    public void Agrupacion(ArrayList<DocumentoAgrupacion> pDocumentos, DocumentoAgrupacion pDocumento){
        this.documentos = pDocumentos;
        this.documento = pDocumento;
    }
    
    //SET AND GET
    public void setDocumentos(ArrayList<DocumentoAgrupacion> pDocumentos) { this.documentos = pDocumentos; }
    public void setDocumento(DocumentoAgrupacion pDocumento) { this.documento = pDocumento; }
    
    public ArrayList<DocumentoAgrupacion> getDocumentos() { return this.documentos; }
    public DocumentoAgrupacion getDocumento() { return this.documento; }
    
    //Funciona para agrupar documentos
    public ArrayList<DocumentoAgrupacion> agruparDocumentos(ArrayList<DocumentoComparativa> pDocumentos){
        
        for(int i=0; i<pDocumentos.size(); i++){
            
            if(pDocumentos.get(i).getTipo().equals("Otro Crédito")){
                documento.setOportunidad(pDocumentos.get(i).getOportunidad());
                documento.setTipo(pDocumentos.get(i).getTipo());
                documento.setNombreCliente(pDocumentos.get(i).getCliente());
                documento.setMonto(pDocumentos.get(i).getMonto());
                documento.setIngresoProfit(pDocumentos.get(i).getIngresoProfit());
                documento.setIngresoEstimado(pDocumentos.get(i).getIngresoEstimado());
                documento.setTotalVenta(pDocumentos.get(i).getTotalVentaNeta());
                documento.setComentario(" O/C ");
            }
            else if(!pDocumentos.get(i).getTipo().equals("Otro Crédito")){
                
                documento.setOportunidad(pDocumentos.get(i).getOportunidad());
                documento.setTipo(" - - - ");
                documento.setNombreCliente(pDocumentos.get(i).getCliente());
                documento.setMonto(0.f);
                documento.setIngresoProfit(pDocumentos.get(i).getIngresoProfit());
                documento.setIngresoEstimado(pDocumentos.get(i).getIngresoEstimado());
                
                //TOTAL VENTA NETA INICIO
                documento.setTotalVenta(pDocumentos.get(i).getTotalVentaNeta());
                
                for(int j = i + 1; j<pDocumentos.size(); j++){
                    if((!pDocumentos.get(j).getTipo().equals("Otro Crédito")) && (pDocumentos.get(i).getOportunidad().equals(pDocumentos.get(j).getOportunidad()))){
                        documento.setTotalVenta(pDocumentos.get(i).getTotalVentaNeta() + pDocumentos.get(j).getTotalVentaNeta());
                        pDocumentos.remove(j);
                    }
                }
                documento.setComentario(" - - - ");
            }
            documentos.add(documento);
        }
        
        for(int i=0; i<documentos.size(); i++){
            System.out.println("==================================");
            System.out.println(documentos.get(i).getOportunidad());
            System.out.println(documentos.get(i).getTipo());
            System.out.println(documentos.get(i).getNombreCliente());
            System.out.println(documentos.get(i).getMonto());
            System.out.println(documentos.get(i).getIngresoProfit());
            System.out.println(documentos.get(i).getIngresoEstimado());
            System.out.println(documentos.get(i).getTotalVenta());
            System.out.println(documentos.get(i).getComentario());
            System.out.println("==================================");       
        }
        
        return documentos;
    }
    
}
