/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUNS;

import com.cfscr.dynasoft.entities.DocumentoAgrupacion;
import com.cfscr.dynasoft.entities.DocumentoComparativa;
import com.cfscr.dynasoft.entities.DocumentosCRM;
import com.cfscr.dynasoft.entities.DocumentosERP;
import com.cfscr.dynasoft.services.ServiceDocElectronicoImpl;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    //DOCUMENTOS-----------
 
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        /**
         * Funciona correctamente | Utiliza servicio web del CRM
         * Solo se debe cargar el Postman
         */
        
        /*
        String pFecha1 = "2021-12-31 23:59:59.000";
        String pFecha2= "2023-01-01 00:00:01.000";
        */
          
        String pFecha1 = "2022-12-31 23:59:59.000";
        String pFecha2 = "2024-01-01 00:00:01.000";
        
        String bodyAuthorization = "";
        
        String bodyCookie = "";
        
        ServiceDocElectronicoImpl serviceDocImpl = new ServiceDocElectronicoImpl();
        
        ArrayList<DocumentosERP> docsERP = new ArrayList<>();
        ArrayList<DocumentosCRM> docsCRM = new ArrayList<>();
        ArrayList<DocumentoComparativa> docsComparativa = new ArrayList<>();
        ArrayList<DocumentoAgrupacion> docsAgrupacion = new ArrayList<>();
        
        docsERP = serviceDocImpl.obtenerERP(docsERP, pFecha1, pFecha2);
        docsCRM = serviceDocImpl.obtenerCRM(docsCRM, bodyAuthorization, bodyCookie, pFecha1, pFecha2);
        docsComparativa = serviceDocImpl.creaComparativa(docsCRM, docsERP, docsComparativa);
        serviceDocImpl.creaAgrupacion(docsComparativa, docsAgrupacion);
        
        serviceDocImpl.cargarExcel();
    }
}