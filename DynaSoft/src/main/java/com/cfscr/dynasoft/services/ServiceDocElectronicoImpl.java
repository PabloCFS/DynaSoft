/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.services;

import com.cfscr.dynasoft.entities.DocumentosERP;
import com.cfscr.dynasoft.entities.DocumentosCRM;

import com.cfscr.dynasoft.logic.Agrupacion;
import com.cfscr.dynasoft.logic.Comparativa;
import com.cfscr.dynasoft.webService.WebServiceCRM;
import com.cfscr.dynasoft.connection.DAOdocElectronico;
import com.cfscr.dynasoft.entities.DocumentoAgrupacion;
import com.cfscr.dynasoft.entities.DocumentoComparativa;
import com.cfscr.dynasoft.excel.EscrituraExcelComparativa;

import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class ServiceDocElectronicoImpl implements ServiceDocElectronicoExt{
    private final DAOdocElectronico daoDocElectronico = new DAOdocElectronico();
    private final WebServiceCRM webService = new WebServiceCRM();
    private final Comparativa comparativa = new Comparativa();
    private final Agrupacion agrupacion = new Agrupacion(); 
    private final EscrituraExcelComparativa escrituraExcel = new EscrituraExcelComparativa();
    
    public void ServiceDocElectronicoImpl(){
    }
    
    @Override
    public ArrayList<DocumentosERP> obtenerERP(ArrayList<DocumentosERP> docsERP, String pFecha1, String pFecha2) {
        
        docsERP = daoDocElectronico.ListarDocsElectronicos(docsERP, pFecha1, pFecha2);
        escrituraExcel.cargarRegistrosERP(docsERP);        
        return docsERP;
    }

    @Override
    public ArrayList<DocumentosCRM> obtenerCRM(ArrayList<DocumentosCRM> docsCRM, String bodyAthorization, String bodyCookie, String fechaInicio, String fechaFin) {
        docsCRM = webService.realizaConsulta(docsCRM, bodyAthorization, bodyCookie, fechaInicio, fechaFin);
        escrituraExcel.cargarRegistrosCRM(docsCRM);
        return docsCRM;
    }

    @Override
    public ArrayList<DocumentoComparativa> creaComparativa(ArrayList<DocumentosCRM> docsCRM, ArrayList<DocumentosERP> docsERP, ArrayList<DocumentoComparativa> docsComparativa) {
        docsComparativa = comparativa.comparaListas(docsCRM, docsERP, docsComparativa);
        escrituraExcel.cargarRegistrosComparativa(docsComparativa);
        return docsComparativa;
    }

    @Override
    public ArrayList<DocumentoAgrupacion> creaAgrupacion(ArrayList<DocumentoComparativa> docsComparativa, ArrayList<DocumentoAgrupacion> docsAgrupacion) {
        docsAgrupacion = agrupacion.agruparDocumentos(docsComparativa, docsAgrupacion);
        escrituraExcel.cargarDocsAgrupados(docsAgrupacion);
        return docsAgrupacion;
    }

    @Override
    public void cargarExcel() {
        escrituraExcel.crearExcel();
    }

}