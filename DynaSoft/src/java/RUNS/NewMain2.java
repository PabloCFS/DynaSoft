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
                
                
        String bodyAuthorization = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiJodHRwczovL2Nmc3Npc3RlbWFzMS5jcm0uZHluYW1pY3MuY29tLyIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNC8iLCJpYXQiOjE2NzU4Njk3NjUsIm5iZiI6MTY3NTg2OTc2NSwiZXhwIjoxNjc1ODc1NDEzLCJhY3IiOiIxIiwiYWdlR3JvdXAiOiIzIiwiYWlvIjoiQVRRQXkvOFRBQUFBeGp5WUM1VU4rWFhtZ3Y3bmZsSE1hMHUvaVZ0YWhDc0JsSmN3SjBuZjl0RlJWaXJ2Tlo4UGFBSktsb3c1YnBjUyIsImFtciI6WyJwd2QiXSwiYXBwaWQiOiIxODRlZTUyOS1iNjYxLTRiZDUtYjFjYy02ZGI4MmExNzRhNGYiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IkVsaXpvbmRvIiwiZ2l2ZW5fbmFtZSI6IlBhYmxvIiwiaXBhZGRyIjoiMTg2LjE3Ny4xODcuMjM5IiwibmFtZSI6IlBhYmxvIEVsaXpvbmRvIiwib2lkIjoiZWM0M2M0NGQtMGI1My00Y2VjLTk3MTgtZTFiMDVlMDQ2YzNmIiwicHVpZCI6IjEwMDMyMDAxMzM5Mjc1MDgiLCJyaCI6IjAuQVc4QVJGcUVVQXNtNWtleUE5aXF5eEItTkFjQUFBQUFBQUFBd0FBQUFBQUFBQUJ2QVBJLiIsInNjcCI6InVzZXJfaW1wZXJzb25hdGlvbiIsInN1YiI6ImJyZnFoQkhOcjNVaDFnNEd3QnlzZHJ4SWZYNVkyX2h4bzRLRDc4Zl9sVzgiLCJ0aWQiOiI1MDg0NWE0NC0yNjBiLTQ3ZTYtYjIwMy1kOGFhY2IxMDdlMzQiLCJ1bmlxdWVfbmFtZSI6InBhYmxvLmVsaXpvbmRvQGNmc2NyLmNvbSIsInVwbiI6InBhYmxvLmVsaXpvbmRvQGNmc2NyLmNvbSIsInV0aSI6IlEwaUdnTGdYNlVHdWJWek9wUXN3QUEiLCJ2ZXIiOiIxLjAifQ.AEcll9XAI2AK-oFwJHkuDUD477U_4juYUeOm-tEx8Hr0yqD6yaXk0XPhMeblvdXqbFmRNd5EB0UqCLuvr_RVoH8OGdyfS2MZ4P7pG5FEaf2BuzEcy2gGhMby2uAhVdMtw96mvFIUpLmld3zjthoN6iI0YPPbX_nD_qmBRAvdCpbRJQszhbk45J2yNP4WgTH5EKijzHgOQFYP7bNX4ARI1nlHHJjSrWzuX78sQD3-4zdvUGWWR-Q1O23YrLxUkalHk0PxaFtPj0g8v1ElKJVh78AhHeBf7KFPIIkMGL4PKULzGsE7GgqcJddk3vzy_hv6K1QEgMvJZ1J1AqjbqY187w";
        
        String bodyCookie = "ARRAffinity=3d057bd3f12cf6c43a41afa94b85ebc612d2f712b8e5f1e0140e2dc809eda266eb29bb4b19df1459d2ea781b605f33064b9fea1f144b525b9d7676625c4ffb5408DB09ED4066B9E91149536762; ReqClientId=0cf19070-4625-45d6-95c0-da1ab4e04749; orgId=24dd677f-a23c-4d40-abe1-166c541f866e";

        
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