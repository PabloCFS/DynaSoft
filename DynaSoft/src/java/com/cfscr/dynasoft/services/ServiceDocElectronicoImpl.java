/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.services;

import com.cfscr.dynasoft.connection.DAOdocElectronico;
import com.cfscr.dynasoft.entities.DocumentoElectronico;
import com.cfscr.dynasoft.entities.DocumentosCRM;
import com.cfscr.dynasoft.excel.EscrituraExcel;
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
    private final EscrituraExcel excel = new EscrituraExcel();
    
    @Override
    public ArrayList<DocumentoElectronico> obtenerDocumentos(String pFecha1, String pFecha2, char pTipoCosulta){
        ArrayList<DocumentoElectronico> documentos = new ArrayList<>();
        try {                                       
            documentos = daoDocElectronico.ListarDocsElectronicos(pFecha1, pFecha2, pTipoCosulta);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDocElectronicoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documentos;
    }

    @Override
    public void cargarExcel(ArrayList<DocumentoElectronico> documentos, ArrayList<DocumentosCRM> documentosCRM){
        excel.cargarRegistrosERP(documentos);
        excel.cargarRegistrosCRM(documentosCRM);
        excel.crearExcel();
    }
    
    @Override
    public ArrayList<DocumentoElectronico> extraerOtrosCredtios(ArrayList<DocumentoElectronico> documentos){
        
        
        
        return documentos;
    }
}