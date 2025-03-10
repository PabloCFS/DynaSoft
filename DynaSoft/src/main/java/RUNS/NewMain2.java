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
        
        String bodyAuthorization = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IjNQYUs0RWZ5Qk5RdTNDdGpZc2EzWW1oUTVFMCIsImtpZCI6IjNQYUs0RWZ5Qk5RdTNDdGpZc2EzWW1oUTVFMCJ9.eyJhdWQiOiJodHRwczovL2Nmc3Npc3RlbWFzMS5jcm0uZHluYW1pY3MuY29tLyIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNC8iLCJpYXQiOjE3Mjk4ODE0MDQsIm5iZiI6MTcyOTg4MTQwNCwiZXhwIjoxNzI5ODg3MDI1LCJhY2N0IjowLCJhY3IiOiIxIiwiYWdlR3JvdXAiOiIzIiwiYWlvIjoiazJCZ1lHRGRMZDUyclUxU3dUdWM2L296dFNzQ1BBM3JaVTlzbG1uWll1czR3Zmh2V0UxNmo5ZHZwWS9Cd2J5Nm12ZXRzMHFEQVE9PSIsImFtciI6WyJwd2QiXSwiYXBwaWQiOiIxODRlZTUyOS1iNjYxLTRiZDUtYjFjYy02ZGI4MmExNzRhNGYiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IkVsaXpvbmRvIEFndWlsZXJhIiwiZ2l2ZW5fbmFtZSI6IlBhYmxvIFN0ZXZlbiIsImlkdHlwIjoidXNlciIsImlwYWRkciI6IjIwMS4yMDMuMTE3LjUyIiwibG9naW5faGludCI6Ik8uQ2lSbFl6UXpZelEwWkMwd1lqVXpMVFJqWldNdE9UY3hPQzFsTVdJd05XVXdORFpqTTJZU0pEVXdPRFExWVRRMExUSTJNR0l0TkRkbE5pMWlNakF6TFdRNFlXRmpZakV3TjJVek5Cb1ljR0ZpYkc4dVpXeHBlbTl1Wkc5QVkyWnpZM0l1WTI5dElLZ0IiLCJuYW1lIjoiUGFibG8gRWxpem9uZG8gQWd1aWxlcmEiLCJvaWQiOiJlYzQzYzQ0ZC0wYjUzLTRjZWMtOTcxOC1lMWIwNWUwNDZjM2YiLCJwdWlkIjoiMTAwMzIwMDEzMzkyNzUwOCIsInJoIjoiMC5BVzhBUkZxRVVBc201a2V5QTlpcXl4Qi1OQWNBQUFBQUFBQUF3QUFBQUFBQUFBQnZBUEkuIiwic2NwIjoidXNlcl9pbXBlcnNvbmF0aW9uIiwic3ViIjoiYnJmcWhCSE5yM1VoMWc0R3dCeXNkcnhJZlg1WTJfaHhvNEtENzhmX2xXOCIsInRlbmFudF9yZWdpb25fc2NvcGUiOiJOQSIsInRpZCI6IjUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNCIsInVuaXF1ZV9uYW1lIjoicGFibG8uZWxpem9uZG9AY2ZzY3IuY29tIiwidXBuIjoicGFibG8uZWxpem9uZG9AY2ZzY3IuY29tIiwidXRpIjoiVHp2T184Tk1ta09MRFVZUXFja2NBQSIsInZlciI6IjEuMCIsInhtc19pZHJlbCI6IjIyIDEifQ.R9TC4cYaNT5UmVF2RncX0m8UOPj-sEqq5--hLir5-OiDwwO7TGSIAC4LGDXbn_El5NvltzvRRsT-HAQGWYBnO5Pe3NmHps1W_KbMNTNiJl1rpetUjhE4r9eClBE0mZCthb4HwAOvvTnyAE-VrUaowNAVdUpC_8RgiIHB8w_2brWiMi5vlvjJiTBOhwlOw0z9TCuXnf6BNmKOiFEiZWjWEejh6I3Hqtrxpp0lOJJjwQ-r8za4E5VsIiYHkPT_OOgYBDrcYPxpTAO8ktGYIccrQNWzVxkAk80NcnbrtcUWlrpf1WJG0VnXGf758J9px76N-nvYlW3Gl1t-xkL-8Lry0g";

        String bodyCookie = "ARRAffinity=c416c330d0bd6cccd9404249c629bedfee18da8c6767faed85768c6f6bf8f8715ab954b42cfa12ad9f33ddc80a07e15dd633bd57139a65479392e46e5242529408DCF528E5CB88C61396813578; ReqClientId=9a504e65-83fd-4166-ae08-c1f146689b82; orgId=24dd677f-a23c-4d40-abe1-166c541f866e";

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

