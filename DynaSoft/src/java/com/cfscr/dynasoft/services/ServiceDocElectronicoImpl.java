/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.services;

import com.cfscr.dynasoft.connection.DAOdocElectronico;
import com.cfscr.dynasoft.entities.DocumentosERP;
import com.cfscr.dynasoft.entities.DocumentosCRM;
import com.cfscr.dynasoft.excel.EscrituraExcelComparativa;
import com.cfscr.dynasoft.logic.Agrupacion;
import com.cfscr.dynasoft.logic.Comparativa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo.elizondo
 */
public class ServiceDocElectronicoImpl implements ServiceDocElectronicoExt{
    private final DAOdocElectronico daoDocElectronico = new DAOdocElectronico();
    private final EscrituraExcelComparativa excel = new EscrituraExcelComparativa();
    private final Comparativa comparativa = new Comparativa();
    private final Agrupacion agrupacion = new Agrupacion();
    
    @Override
    public ArrayList<DocumentosERP> obtenerDocumentos(String pFecha1, String pFecha2, char pTipoCosulta){
        ArrayList<DocumentosERP> documentos = new ArrayList<>();
        try {                                       
            documentos = daoDocElectronico.ListarDocsElectronicos(pFecha1, pFecha2, pTipoCosulta);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDocElectronicoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documentos;
    }

    @Override
    public void cargarExcel(ArrayList<DocumentosERP> documentos, ArrayList<DocumentosCRM> documentosCRM){
        
        excel.cargarRegistrosERP(documentos);
        excel.cargarRegistrosCRM(documentosCRM);
        excel.cargarRegistrosComparativa(comparativa.comparaListas(documentosCRM, documentos));
        excel.cargarDocsAgrupados(agrupacion.agruparDocumentos(comparativa.comparaListas(documentosCRM, documentos)));
        excel.crearExcel();
    }
    
    @Override
    public ArrayList<DocumentosERP> extraerOtrosCredtios(ArrayList<DocumentosERP> documentos){
        
        return documentos;
    }
}