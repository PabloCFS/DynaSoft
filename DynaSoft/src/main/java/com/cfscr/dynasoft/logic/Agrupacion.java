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
    //Funciona para agrupar documentos
    
    /**POR ACA VA EL ERR
     * @param docComparativa
     * @param docsAgrupacion
     * @return */
    
    public ArrayList<DocumentoAgrupacion> agruparDocumentos(ArrayList<DocumentoComparativa> docComparativa, ArrayList<DocumentoAgrupacion> docsAgrupacion){
        
        for(int i=0; i<docComparativa.size(); i++){
            DocumentoAgrupacion documento = new DocumentoAgrupacion();
            
            if((docComparativa.get(i).getTipo().equals("Otro Crédito")) || 
               (docComparativa.get(i).getOportunidad().equals("No match CRM"))) {
                
                documento.setOportunidad(docComparativa.get(i).getOportunidad());
                documento.setTipo(docComparativa.get(i).getTipo());
                documento.setNombreCliente(docComparativa.get(i).getCliente());
                documento.setTema(docComparativa.get(i).getTema());
                documento.setMonto(docComparativa.get(i).getMonto());
                documento.setIngresoProfit(docComparativa.get(i).getIngresoProfit());
                documento.setIngresoEstimado(docComparativa.get(i).getIngresoEstimado());
                documento.setTotalVenta(docComparativa.get(i).getTotalVentaNeta());
                documento.setTotalFactura(docComparativa.get(i).getTotalFactura());
                documento.setDiferencia(documento.getTotalVenta() - documento.getIngresoEstimado());
                
            }
            else if((!docComparativa.get(i).getTipo().equals("Otro Crédito")) && 
                    (!docComparativa.get(i).getOportunidad().equals("No match CRM"))) {
                
                documento.setOportunidad(docComparativa.get(i).getOportunidad());
                documento.setTipo((docComparativa.get(i).getTipo().equals("No Match ERP")) ? "No Match ERP" : " - - - ");
                documento.setNombreCliente(docComparativa.get(i).getCliente());
                documento.setTema(docComparativa.get(i).getTema());
                documento.setMonto(0.f);
                documento.setIngresoProfit(docComparativa.get(i).getIngresoProfit());
                documento.setIngresoEstimado(docComparativa.get(i).getIngresoEstimado());
                documento.setTotalVenta(docComparativa.get(i).getTotalVentaNeta());
                
                int j = i + 1;
                while((docComparativa.get(j).getOportunidad().equals(docComparativa.get(i).getOportunidad())) && 
                      (!docComparativa.get(j).getTipo().equals("Otro Crédito"))) {
                    
                    documento.setTotalVenta(documento.getTotalVenta() + docComparativa.get(j).getTotalVentaNeta());
                    j++;
                }
                documento.setTotalFactura(docComparativa.get(i).getTotalFactura());
                documento.setDiferencia(documento.getTotalVenta() - documento.getIngresoEstimado());
                
                i = j - 1;
            }
            docsAgrupacion.add(documento);
        }
        return docsAgrupacion;
    }
}
