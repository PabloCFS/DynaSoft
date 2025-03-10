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
          
        String pFecha1 = "2024-12-31 23:59:59.000";
        String pFecha2 = "2026-01-01 00:00:01.000";
        
        String bodyAuthorization = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IkpETmFfNGk0cjdGZ2lnTDNzSElsSTN4Vi1JVSIsImtpZCI6IkpETmFfNGk0cjdGZ2lnTDNzSElsSTN4Vi1JVSJ9.eyJhdWQiOiJodHRwczovL2Nmc3Npc3RlbWFzMS5jcm0uZHluYW1pY3MuY29tLyIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNC8iLCJpYXQiOjE3NDE2Mzc2MjcsIm5iZiI6MTc0MTYzNzYyNywiZXhwIjoxNzQxNjQyNzQ3LCJhY2N0IjowLCJhY3IiOiIxIiwiYWdlR3JvdXAiOiIzIiwiYWlvIjoiQVRRQXkvOFpBQUFBSndQQ1NiOUNtdnBRYmxjb09lSzVYbnhESDBXcWxnTXp5VlQycmtiRjMvUFE1eGhuVWxmNzhJTUZSSGxTRGEwWiIsImFtciI6WyJwd2QiXSwiYXBwaWQiOiIxODRlZTUyOS1iNjYxLTRiZDUtYjFjYy02ZGI4MmExNzRhNGYiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IkVsaXpvbmRvIEFndWlsZXJhIiwiZ2l2ZW5fbmFtZSI6IlBhYmxvIFN0ZXZlbiIsImlkdHlwIjoidXNlciIsImlwYWRkciI6IjE3MC4yNDYuMTQ4LjkwIiwibG9naW5faGludCI6Ik8uQ2lSbFl6UXpZelEwWkMwd1lqVXpMVFJqWldNdE9UY3hPQzFsTVdJd05XVXdORFpqTTJZU0pEVXdPRFExWVRRMExUSTJNR0l0TkRkbE5pMWlNakF6TFdRNFlXRmpZakV3TjJVek5Cb1ljR0ZpYkc4dVpXeHBlbTl1Wkc5QVkyWnpZM0l1WTI5dElCaz0iLCJuYW1lIjoiUGFibG8gRWxpem9uZG8gQWd1aWxlcmEiLCJvaWQiOiJlYzQzYzQ0ZC0wYjUzLTRjZWMtOTcxOC1lMWIwNWUwNDZjM2YiLCJwdWlkIjoiMTAwMzIwMDEzMzkyNzUwOCIsInJoIjoiMS5BVzhBUkZxRVVBc201a2V5QTlpcXl4Qi1OQWNBQUFBQUFBQUF3QUFBQUFBQUFBQmtBZkp2QUEuIiwic2NwIjoidXNlcl9pbXBlcnNvbmF0aW9uIiwic2lkIjoiMDAyZWUwMTktNjFlZC04MTgzLTAzNWEtMzUxMDYyZWU1ZDMzIiwic3ViIjoiYnJmcWhCSE5yM1VoMWc0R3dCeXNkcnhJZlg1WTJfaHhvNEtENzhmX2xXOCIsInRlbmFudF9yZWdpb25fc2NvcGUiOiJOQSIsInRpZCI6IjUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNCIsInVuaXF1ZV9uYW1lIjoicGFibG8uZWxpem9uZG9AY2ZzY3IuY29tIiwidXBuIjoicGFibG8uZWxpem9uZG9AY2ZzY3IuY29tIiwidXRpIjoiZmhnZzJBa1ZtRTJMNWtjeGh6RTJBQSIsInZlciI6IjEuMCIsInhtc19pZHJlbCI6IjI4IDEifQ.bB9OXxC_fEPItan7U98rMK6i76TZVY4slaRMoeLQQfE8OUXXwoPArgOX0pglQ2HG6izpXIIUnJgiy5za6Cw-T6qKROO4S4vUFtVkkyoeJDQRnjPVyiHBIAzvZRbgHUvd-ZEz-NXYny1bEhhxh2jbTloL_xGfINKdKmAb4v7fPmIq8-6cxBFLO3VUnZiHsxc-VMcFIu6gCtVXr8QZDmVn8lu11TMfbkqun8_lBG5iB05uINkjIleDDIKUolNkU6yTnd_WpZFMb7AQEbIAOnk6gzzHA2Igz6XbqBiRtqOjrSBp782yM-BHDVVw1TYqwhBoZSTB6jEJA3ePUMxsto4GTQ";

        String bodyCookie = "ARRAffinity=330e1e42b39407499c007c4f684fcf30dab66df57e8a29d7b86a7ea3c54ea9a9dc748ed02332839cb0efbb9e2898da096c2226348c1e154ec1706e5f470d25ad08DD5FF6DCA26747887561929; ReqClientId=9a504e65-83fd-4166-ae08-c1f146689b82; orgId=24dd677f-a23c-4d40-abe1-166c541f866e";
        
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

