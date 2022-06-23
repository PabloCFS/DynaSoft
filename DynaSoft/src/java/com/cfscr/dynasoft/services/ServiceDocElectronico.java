/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.services;

import com.cfscr.dynasoft.entities.DocumentoElectronico;

import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public interface ServiceDocElectronico {
    ArrayList<DocumentoElectronico> obtenerDocumentos(String pFecha1, String pFecha2, char pTipoCosulta);

    void cargarExcel(ArrayList<DocumentoElectronico> documentos);
    
}
