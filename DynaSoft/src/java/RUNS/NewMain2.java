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

        String pFecha1 = "2021-12-31 23:59:59.000";
        String pFecha2= "2023-01-01 00:00:01.000";
        
        String bodyAuthorization = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiJodHRwczovL2Nmc3Npc3RlbWFzMS5jcm0uZHluYW1pY3MuY29tLyIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNC8iLCJpYXQiOjE2NzA5NDQ2NTksIm5iZiI6MTY3MDk0NDY1OSwiZXhwIjoxNjcwOTQ5NTQ0LCJhY3IiOiIxIiwiYWdlR3JvdXAiOiIzIiwiYWlvIjoiQVRRQXkvOFRBQUFBcTN0c0ZJL3lUOWpwdVRUQlhPMzFMTVlxdXMwQUpjNFBzMlF2MFFJYkQ5R2MrWHlETU9CT0lHa0h6dHpJRFlmbiIsImFtciI6WyJwd2QiXSwiYXBwaWQiOiIxODRlZTUyOS1iNjYxLTRiZDUtYjFjYy02ZGI4MmExNzRhNGYiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IkVsaXpvbmRvIiwiZ2l2ZW5fbmFtZSI6IlBhYmxvIiwiaXBhZGRyIjoiMTcwLjI0Ni4xNDguOTAiLCJuYW1lIjoiUGFibG8gRWxpem9uZG8iLCJvaWQiOiJlYzQzYzQ0ZC0wYjUzLTRjZWMtOTcxOC1lMWIwNWUwNDZjM2YiLCJwdWlkIjoiMTAwMzIwMDEzMzkyNzUwOCIsInJoIjoiMC5BVzhBUkZxRVVBc201a2V5QTlpcXl4Qi1OQWNBQUFBQUFBQUF3QUFBQUFBQUFBQnZBUEkuIiwic2NwIjoidXNlcl9pbXBlcnNvbmF0aW9uIiwic3ViIjoiYnJmcWhCSE5yM1VoMWc0R3dCeXNkcnhJZlg1WTJfaHhvNEtENzhmX2xXOCIsInRpZCI6IjUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNCIsInVuaXF1ZV9uYW1lIjoicGFibG8uZWxpem9uZG9AY2ZzY3IuY29tIiwidXBuIjoicGFibG8uZWxpem9uZG9AY2ZzY3IuY29tIiwidXRpIjoicVZRU0ZpMlNma0tYN3ktdlhJaG9BZyIsInZlciI6IjEuMCJ9.X7g5GCeHQpGiDlfNa65_JtS1tzemasp-hkDe5cS9O9QUlTH3wRYq2JnZktqrYTpL4J6vkdmym6Mi68g_9Iadl1znDJ5mJYInmqqsrH3HxMC8sFMhf2KuvnwwVxWKyLK9xf-veeWtjpz7WdlNsglGFHTtB4iDInSQbtt4Gf7HrNjNIQ06F3FsAlxHOA14SsnRCGvrmzFx9KlbmtrkbLW_aJSAtW0JyoLglAjKPNfA3JQ4qSHF2GNpIlsQ9SYEaA408MBYWwond_lExx40ULJRPHGlF6mUHn4kglspAlSk0CPQ7jo_N0jkl9htru60NE0I0-iW6QpyheBvF5iLD0yoLQ";
        
        String bodyCookie = "ARRAffinity=bd9fce4c0a1e74c2b3a7db5a9d7b7ec6cd3631fc1fca386b816206ecaac0b679eb29bb4b19df1459d2ea781b605f33064b9fea1f144b525b9d7676625c4ffb5408DADC6ADA20BAF71924607886; ReqClientId=0cf19070-4625-45d6-95c0-da1ab4e04749; orgId=24dd677f-a23c-4d40-abe1-166c541f866e";
        
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