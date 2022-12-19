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
public interface ServiceDocElectronicoExt extends ServiceDocElectronico{
    //Obtener ERP
    @Override
    ArrayList<DocumentosERP> obtenerERP(ArrayList<DocumentosERP> docsERP, String pFecha1, String pFecha2);

    //Obtener CRM
    @Override
    ArrayList<DocumentosCRM> obtenerCRM(ArrayList<DocumentosCRM> docsCRM, String bodyAthorization, String bodyCookie, String fechaInicio, String fechaFin);
    
    //Crear Comparativa
    @Override
    ArrayList<DocumentoComparativa> creaComparativa(ArrayList<DocumentosCRM> docsCRM, ArrayList<DocumentosERP> docsERP, ArrayList<DocumentoComparativa> docsComparativa);
    
    //Crear Agrupacion
    @Override
    ArrayList<DocumentoAgrupacion> creaAgrupacion(ArrayList<DocumentoComparativa> docsComparativa, ArrayList<DocumentoAgrupacion> docsAgrupacion);
    
    //Crear Excel
    @Override
    void cargarExcel();
}
