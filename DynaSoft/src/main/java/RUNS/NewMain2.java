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
                
                

        String bodyAuthorization = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiJodHRwczovL2Nmc3Npc3RlbWFzMS5jcm0uZHluYW1pY3MuY29tLyIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNC8iLCJpYXQiOjE2ODEyNDk4MDMsIm5iZiI6MTY4MTI0OTgwMywiZXhwIjoxNjgxMjU0MzQ5LCJhY3IiOiIxIiwiYWdlR3JvdXAiOiIzIiwiYWlvIjoiQVRRQXkvOFRBQUFBL0daSnJJcVR6YnhITVArOHVkL1BFR1hLL1U2T1YvMHFnc0l5NDJnTDd3U091QjJ6ZHZEZFZwRW9nRm9QUWVCTSIsImFtciI6WyJwd2QiXSwiYXBwaWQiOiIxODRlZTUyOS1iNjYxLTRiZDUtYjFjYy02ZGI4MmExNzRhNGYiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IkVsaXpvbmRvIiwiZ2l2ZW5fbmFtZSI6IlBhYmxvIiwiaXBhZGRyIjoiMTcwLjI0Ni4xNDguOTAiLCJuYW1lIjoiUGFibG8gRWxpem9uZG8iLCJvaWQiOiJlYzQzYzQ0ZC0wYjUzLTRjZWMtOTcxOC1lMWIwNWUwNDZjM2YiLCJwdWlkIjoiMTAwMzIwMDEzMzkyNzUwOCIsInJoIjoiMC5BVzhBUkZxRVVBc201a2V5QTlpcXl4Qi1OQWNBQUFBQUFBQUF3QUFBQUFBQUFBQnZBUEkuIiwic2NwIjoidXNlcl9pbXBlcnNvbmF0aW9uIiwic3ViIjoiYnJmcWhCSE5yM1VoMWc0R3dCeXNkcnhJZlg1WTJfaHhvNEtENzhmX2xXOCIsInRpZCI6IjUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNCIsInVuaXF1ZV9uYW1lIjoicGFibG8uZWxpem9uZG9AY2ZzY3IuY29tIiwidXBuIjoicGFibG8uZWxpem9uZG9AY2ZzY3IuY29tIiwidXRpIjoiWmVKekZvU1hURU9DQVRjWHd4RW1BUSIsInZlciI6IjEuMCJ9.pw1aCS5nkiino6ExWpdgq4FuMfYQ8hGvd8S1ZvXpyZtF9L1rZzih7yoBUn7agQJTc4o67nyv4lZUQQVFxBW2QNYoaPVqeoKMblTkY-xcFABAVYggGM3hhE2BwlwJcMr9yQALDUVI3Ne9-I3tymCmkb7JJ-zNycvTEnuhoMLzaNS3C3INrOESYj1E7xQ1a3gI-4U5h9E2cMECQTrJ4M1ijKi9TbmxcWq_1c8p4_uWqekyhmIxDnxCXhD_eR46LPAbXuEpQHete0cUFy8rYzSQNnMzwDFPYrquDxhqKCCAbuyGFebm26Tg93jZQd71exY2b6z5H2xAzaseFz_0IsOa0A";
        
        String bodyCookie = "ARRAffinity=3d057bd3f12cf6c43a41afa94b85ebc612d2f712b8e5f1e0140e2dc809eda26615134d20c556b0b34b9b6ae43ec3f5dcdad61788de889ffc592af7aca85fc1c508DB3ADB9C983CB61571637062; ReqClientId=0cf19070-4625-45d6-95c0-da1ab4e04749; orgId=24dd677f-a23c-4d40-abe1-166c541f866e";

        
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