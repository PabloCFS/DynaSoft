/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.services;

import com.cfscr.dynasoft.connection.DAOdocElectronico;
import com.cfscr.dynasoft.entities.DocumentoElectronico;
import com.cfscr.dynasoft.excel.ManipulacionExcel;
import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class ServiceDocElectronicoImpl implements ServiceDocElectronicoExt{
    private final DAOdocElectronico daoDocElectronico = new DAOdocElectronico();
    private final ManipulacionExcel excel = new ManipulacionExcel();
    
    @Override
    public ArrayList<DocumentoElectronico> obtenerDocumentos(String pFecha1, String pFecha2, char pTipoCosulta){
        ArrayList<DocumentoElectronico> documentos; System.out.println("ServiceDI-24");
        documentos = daoDocElectronico.ListarDocsElectronicos(pFecha1, pFecha2, pTipoCosulta); System.out.println("ServiceDI-25");
        return documentos;
    }

    @Override
    public void cargarExcel(ArrayList<DocumentoElectronico> documentos){
        excel.cargarRegistros(documentos);
        excel.crearExcel();
    }
}