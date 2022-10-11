/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.services;

import com.cfscr.dynasoft.entities.DocumentosERP;
import com.cfscr.dynasoft.entities.DocumentosCRM;
import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public interface ServiceDocElectronicoExt extends ServiceDocElectronico{
    @Override
    ArrayList<DocumentosERP> obtenerDocumentos(String pFecha1, String pFecha2, char pTipoCosulta);

    @Override
    void cargarExcel(ArrayList<DocumentosERP> documentos, ArrayList<DocumentosCRM> documentosCRM);

    @Override
    ArrayList<DocumentosERP> extraerOtrosCredtios(ArrayList<DocumentosERP> documentos);
}
