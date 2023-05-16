/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.services;

import com.cfscr.dynasoft.entities.DocumentosERP;
import com.cfscr.dynasoft.entities.DocumentosCRM;
import com.cfscr.dynasoft.entities.DocumentoAgrupacion;
import com.cfscr.dynasoft.entities.DocumentoComparativa;

import java.util.ArrayList;

/**
 * @author pablo.elizondo       
 */
public interface ServiceDocElectronico {
    //Obtener ERP
    ArrayList<DocumentosERP> obtenerERP(ArrayList<DocumentosERP> docsERP, String pFecha1, String pFecha2);

    //Obtener CRM
    ArrayList<DocumentosCRM> obtenerCRM(ArrayList<DocumentosCRM> docsCRM, String bodyAthorization, String bodyCookie, String fechaInicio, String fechaFin);
    
    //Crear Comparativa
    ArrayList<DocumentoComparativa> creaComparativa(ArrayList<DocumentosCRM> docsCRM, ArrayList<DocumentosERP> docsERP, ArrayList<DocumentoComparativa> docsComparativa);
    
    //Crear Agrupacion
    ArrayList<DocumentoAgrupacion> creaAgrupacion(ArrayList<DocumentoComparativa> docsComparativa, ArrayList<DocumentoAgrupacion> docsAgrupacion);
    
    //Crear Excel
    void cargarExcel();
}
